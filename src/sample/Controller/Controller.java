package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Model.HashFunctions;
import sample.Model.HashNumberFunctions;
import sample.Model.RandomGen;

public class Controller {
    public static HashNumberFunctions currentNumFunc;
    public static HashFunctions currentHashFunc;
    public static RandomGen currentRan;
    public static int tableSize;

    public static double eff1, eff2, eff3;

    @FXML
    TextField TextFieldSize;

    @FXML
    public void initialize() {
        currentNumFunc = HashNumberFunctions.CALCULATE_BY_POSITION;
        currentHashFunc = HashFunctions.RANDOM_FUNCTION;
    }

    public void RandomTable(ActionEvent actionEvent) {
        try {
            tableSize = Integer.parseInt(TextFieldSize.getText());
            currentNumFunc = HashNumberFunctions.CALCULATE_BY_POSITION;
            currentHashFunc = HashFunctions.RANDOM_FUNCTION;
            Parent root = FXMLLoader.load(getClass().getResource("../View/RanMethod.fxml"));
            Stage stage = new Stage();
            stage.setTitle("RANDOM METHOD");
            stage.setScene(new Scene(root, 632,483));
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            //e.printStackTrace();
            alert.setHeaderText("Error has occured");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    public void SeqTable(ActionEvent actionEvent) {
        try {
            tableSize = Integer.parseInt(TextFieldSize.getText());
            currentNumFunc = HashNumberFunctions.CALCULATE_BY_POSITION;
            currentHashFunc = HashFunctions.LINEAR_FUNCTION;
            Parent root = FXMLLoader.load(getClass().getResource("../View/RanMethod.fxml"));
            Stage stage = new Stage();
            stage.setTitle("RANDOM METHOD");
            stage.setScene(new Scene(root, 632,483));
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            //e.printStackTrace();
            alert.setHeaderText("Error has occured");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}
