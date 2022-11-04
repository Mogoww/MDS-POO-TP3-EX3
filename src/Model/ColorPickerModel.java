package Model;

import java.util.Observable;

public class ColorPickerModel extends Observable {

    //--------------------------------------------------------------------------------Atributs
    private int red;
    private int green;
    private int blue;

    //--------------------------------------------------------------------------------Getters & Setters

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
        setChanged();
        notifyObservers();
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
        setChanged();
        notifyObservers();
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
        setChanged();
        notifyObservers();
    }
}
