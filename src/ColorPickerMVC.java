import Controller.ColorPickerController;
import Model.ColorPickerModel;
import View.ColorPickerVue;

public class ColorPickerMVC {

    public ColorPickerMVC() {
        ColorPickerModel model = new ColorPickerModel();

        ColorPickerController controller = new ColorPickerController(model);
        ColorPickerVue vue = new ColorPickerVue( controller, 1000, 1000);
        controller.setVue(vue);
    }





    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ColorPickerMVC();
            }
        });
    }
}