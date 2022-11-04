package Controller;

import Model.ColorPickerModel;
import View.ColorPickerVue;

public class ColorPickerController {

    //--------------------------------------------------------------------------------Atributs
    private ColorPickerModel model;
    private ColorPickerVue vue = null;

    //--------------------------------------------------------------------------------Constructeur
    public ColorPickerController(ColorPickerModel model) {
        this.model = model;
    }


    //--------------------------------------------------------------------------------Méthodes

    // set red value
    public void setRed(int red) {
        model.setRed(red);
    }
    public int getRed() {
        return model.getRed();
    }
    public void setGreen(int green) {
        model.setGreen(green);
    }
    public int getGreen() {
        return model.getGreen();
    }

    public void setBlue(int blue) {
        model.setBlue(blue);
    }
    public int getBlue() {
        return model.getBlue();
    }
    public void setVue(ColorPickerVue vue) {
        this.vue = vue;
        this.model.addObserver(vue);
    }



}
