package View;

import Controller.ColorPickerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class ColorPickerVue implements Observer {

    //--------------------------------------------------------------------------------Atributs
    private ColorPickerController controller;

    // display 3 sliders for red, green and blue values
    // display a color rectangle with the current color
    // display a text field with the current color in hexadecimal format
    // display a button to copy the current color in hexadecimal format to the clipboard
    // display a button to close the window

    private JSlider redSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
    private JTextField redTextField = new JTextField("0", 3);
    private JSlider greenSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
    private JTextField greenTextField = new JTextField("0", 3);
    private JSlider blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
    private JTextField blueTextField = new JTextField("0", 3);

    JPanel panelColorDisplay = new JPanel();
    JTextField hexaTextField = new JTextField("", 7);



    //--------------------------------------------------------------------------------Constructeur
    public ColorPickerVue(ColorPickerController controller, int posX, int posY) {
        this.controller = controller;

        // add 2 columns
        JPanel panel = new JPanel(new GridLayout(0, 2));


        JFrame colorPickerJFrame = new JFrame("Color Picker");
        colorPickerJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colorPickerJFrame.setSize(400, 400);
        colorPickerJFrame.setLocation(posX, posY);
        colorPickerJFrame.setVisible(true);

        // create the sliders and text fields for red, green and blue values
        JPanel panelRed = new JPanel(new GridLayout(0, 2));
        panelRed.add(redSlider);
        panelRed.add(redTextField);
        JPanel panelGreen = new JPanel(new GridLayout(0, 2));
        panelGreen.add(greenSlider);
        panelGreen.add(greenTextField);
        JPanel panelBlue = new JPanel(new GridLayout(0, 2));
        panelBlue.add(blueSlider);
        panelBlue.add(blueTextField);

        JPanel panelColor = new JPanel(new GridLayout(3, 1));
        panelColor.add(panelRed);
        panelColor.add(panelGreen);
        panelColor.add(panelBlue);

        panel.add(panelColor);

        // create the color display
        JPanel panelHexaAndColorDisplay = new JPanel(new GridLayout(2, 1));
        panelHexaAndColorDisplay.add(hexaTextField);


        panelHexaAndColorDisplay.add(panelColorDisplay);
        panel.add(panelHexaAndColorDisplay);

        colorPickerJFrame.add(panel, BorderLayout.CENTER);




        // display pourcentage
        redSlider.setMajorTickSpacing(20);
        redSlider.setMinorTickSpacing(5);

        redSlider.setValue(this.controller.getRed());
        redTextField.setText(String.valueOf(this.controller.getRed()));

        redTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                // modifier le model via le controller
                controller.setRed(Integer.parseInt(redTextField.getText()));
            }
        });

        redSlider.addChangeListener(e -> {
            controller.setRed(redSlider.getValue());
        });

        greenSlider.setMajorTickSpacing(20);
        greenSlider.setMinorTickSpacing(5);

        greenSlider.setValue(this.controller.getGreen());
        greenTextField.setText(String.valueOf(this.controller.getGreen()));

        greenTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                // modifier le model via le controller
                controller.setGreen(Integer.parseInt(greenTextField.getText()));
            }
        });
        greenSlider.addChangeListener(e -> {
            controller.setGreen(greenSlider.getValue());
        });

        blueSlider.setMajorTickSpacing(20);
        blueSlider.setMinorTickSpacing(5);

        blueSlider.setValue(this.controller.getBlue());
        blueTextField.setText(String.valueOf(this.controller.getBlue()));

        this.blueTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                // modifier le model via le controller
                controller.setBlue(Integer.parseInt(blueTextField.getText()));
            }
        });
        this.blueSlider.addChangeListener(e -> {
            this.controller.setBlue(this.blueSlider.getValue());
        });

        // start at controller value
        this.redSlider.setValue(this.controller.getRed());
        this.greenSlider.setValue(this.controller.getGreen());
        this.blueSlider.setValue(this.controller.getBlue());

        // create the color display
        this.panelColorDisplay.setBackground(new Color(this.controller.getRed(), this.controller.getGreen(), this.controller.getBlue()));

        this.hexaTextField.setText(
                String.format("#%02x%02x%02x", this.controller.getRed(), this.controller.getGreen(), this.controller.getBlue())
        );
    }

    // method for changing the color of the color display
    public void changeColorDisplay() {
        this.panelColorDisplay.setBackground(
                new Color(
                        this.controller.getRed(),
                        this.controller.getGreen(),
                        this.controller.getBlue()
                )
        );
    }

    // method for changing the color of the color display
    public void changeHexaTextField() {
        this.hexaTextField.setText(
                String.format("#%02x%02x%02x", this.controller.getRed(), this.controller.getGreen(), this.controller.getBlue())
        );
    }

    @Override
    public void update(Observable o, Object arg) {
        // red
        this.redSlider.setValue(this.controller.getRed());
        this.redTextField.setText(String.valueOf(this.controller.getRed()));
        // green
        this.greenSlider.setValue(this.controller.getGreen());
        this.greenTextField.setText(String.valueOf(this.controller.getGreen()));
        // blue
        this.blueSlider.setValue(this.controller.getBlue());
        this.blueTextField.setText(String.valueOf(this.controller.getBlue()));

        // color display
        this.changeColorDisplay();

        // hexa
        this.changeHexaTextField();
    }



}
