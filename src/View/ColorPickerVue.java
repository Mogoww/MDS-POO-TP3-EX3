package View;

import Controller.ColorPickerController;
import Model.ColorPickerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class ColorPickerVue implements Observer {

    //--------------------------------------------------------------------------------Atributs
    private ColorPickerModel model;
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
    JTextField hexaTextField = new JTextField("#000000", 7);



    //--------------------------------------------------------------------------------Constructeur
    public ColorPickerVue(ColorPickerModel model, ColorPickerController controller, int posX, int posY) {

        // add 2 columns
        JPanel panel = new JPanel(new GridLayout(0, 2));

        this.model = model;
        this.controller = controller;
        model.addObserver(this);

        JFrame colorPickerJFrame = new JFrame("Color Picker");
        colorPickerJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colorPickerJFrame.setSize(400, 400);
        colorPickerJFrame.setLocation(posX, posY);
        colorPickerJFrame.setVisible(true);

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

        JPanel panelHexaAndColorDisplay = new JPanel(new GridLayout(2, 1));
        JTextField hexaTextField = new JTextField(
                String.format("#%02x%02x%02x", model.getRed(), model.getGreen(), model.getBlue()), 7);
        panelHexaAndColorDisplay.add(hexaTextField);



        panelColorDisplay.setBackground(
                new Color(
                        model.getRed(),
                        model.getGreen(),
                        model.getBlue()
                )
        );
        panelHexaAndColorDisplay.add(panelColorDisplay);
        panel.add(panelHexaAndColorDisplay);

        colorPickerJFrame.add(panel, BorderLayout.CENTER);




        // display pourcentage
        redSlider.setMajorTickSpacing(20);
        redSlider.setMinorTickSpacing(5);

        redSlider.setValue(model.getRed());
        redTextField.setText(String.valueOf(model.getRed()));

        //

        redTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                redSlider.setValue(Integer.parseInt(redTextField.getText()));
                panelColorDisplay.setBackground(
                        new Color(
                                redSlider.getValue(),
                                greenSlider.getValue(),
                                blueSlider.getValue()
                        )
                );
                hexaTextField.setText(
                        String.format("#%02x%02x%02x", redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue())
                );
            }
        });

        redSlider.addChangeListener(e -> {
            controller.setRed(redSlider.getValue());
            redTextField.setText(String.valueOf(redSlider.getValue()));
            panelColorDisplay.setBackground(
                    new Color(
                            redSlider.getValue(),
                            greenSlider.getValue(),
                            blueSlider.getValue()
                    )
            );
            hexaTextField.setText(
                    String.format("#%02x%02x%02x", redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue())
            );
        });

        greenSlider.setMajorTickSpacing(20);
        greenSlider.setMinorTickSpacing(5);

        greenSlider.setValue(model.getGreen());
        greenTextField.setText(String.valueOf(model.getGreen()));

        greenTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                greenSlider.setValue(Integer.parseInt(greenTextField.getText()));
                panelColorDisplay.setBackground(
                        new Color(
                                redSlider.getValue(),
                                greenSlider.getValue(),
                                blueSlider.getValue()
                        )
                );
                hexaTextField.setText(
                        String.format("#%02x%02x%02x", redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue())
                );
            }
        });
        greenSlider.addChangeListener(e -> {
            controller.setGreen(greenSlider.getValue());
            greenTextField.setText(String.valueOf(greenSlider.getValue()));
            panelColorDisplay.setBackground(
                    new Color(
                            redSlider.getValue(),
                            greenSlider.getValue(),
                            blueSlider.getValue()
                    )
            );
            hexaTextField.setText(
                    String.format("#%02x%02x%02x", redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue())
            );
        });

        blueSlider.setMajorTickSpacing(20);
        blueSlider.setMinorTickSpacing(5);

        blueSlider.setValue(model.getBlue());
        blueTextField.setText(String.valueOf(model.getBlue()));

        blueTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                blueSlider.setValue(Integer.parseInt(blueTextField.getText()));
                panelColorDisplay.setBackground(
                        new Color(
                                redSlider.getValue(),
                                greenSlider.getValue(),
                                blueSlider.getValue()
                        )
                );
                hexaTextField.setText(
                        String.format("#%02x%02x%02x", redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue())
                );
            }
        });
        blueSlider.addChangeListener(e -> {
            controller.setBlue(blueSlider.getValue());
            blueTextField.setText(String.valueOf(blueSlider.getValue()));
            panelColorDisplay.setBackground(
                    new Color(
                            redSlider.getValue(),
                            greenSlider.getValue(),
                            blueSlider.getValue()
                    )
            );
            hexaTextField.setText(
                    String.format("#%02x%02x%02x", redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue())
            );
        });

        // start at controller value
        redSlider.setValue((int) model.getRed());
        greenSlider.setValue((int) model.getGreen());
        blueSlider.setValue((int) model.getBlue());





    }


    protected ColorPickerModel model() {
        return model;
    }

    @Override
    public void update(Observable o, Object arg) {
        redSlider.setValue(model.getRed());
    }



}
