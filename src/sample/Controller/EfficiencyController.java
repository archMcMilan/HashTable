package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EfficiencyController {
    @FXML
    TextField TextField1;
    @FXML
    TextField TextField2;
    @FXML
    TextField TextField3;

    @FXML
    public void initialize() {
        TextField1.setText(String.valueOf(Controller.eff1));
        TextField2.setText(String.valueOf(Controller.eff2));
        TextField3.setText(String.valueOf(Controller.eff3));
    }
}
