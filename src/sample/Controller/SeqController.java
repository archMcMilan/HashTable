package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Model.HashStruct;
import sample.Model.IntVariable;
import sample.Model.ProcessHashTable;
import sample.Model.RandomGen;
import sample.View.TableObj;

public class SeqController {

    HashStruct hashStruct;
    ProcessHashTable curProcess;

    private ObservableList<TableObj> hashData = FXCollections.observableArrayList();
    private ObservableList<TableObj> valData = FXCollections.observableArrayList();

    @FXML
    private TableView TableViewHash;
    @FXML
    private TableView TableViewData;
    @FXML
    private TableColumn<TableObj, String> HashId;
    @FXML
    private TableColumn<TableObj, String> HashVariable;
    @FXML
    private TableColumn<TableObj, String> DataNumber;
    @FXML
    private TableColumn<TableObj, String> DataValue;
    @FXML
    private TextField TextFieldId;
    @FXML
    private TextField TextFieldValue;
    @FXML
    private TextField TextFieldId1;
    @FXML
    public void initialize() {
        hashStruct = new HashStruct(Controller.tableSize);
        curProcess = new ProcessHashTable(hashStruct);
        HashId.setCellValueFactory(new PropertyValueFactory<>("id"));
        HashVariable.setCellValueFactory(new PropertyValueFactory<>("value"));

        DataNumber.setCellValueFactory(new PropertyValueFactory<>("id"));
        DataValue.setCellValueFactory(new PropertyValueFactory<>("value"));
        addData();
        TableViewHash.setItems(hashData);
        TableViewData.setItems(valData);
    }

    public void addVar(ActionEvent actionEvent) {
        try {
            curProcess.insertInTable(new IntVariable(TextFieldId.getText(), Integer.parseInt(TextFieldValue.getText())));
            hashData.clear();
            valData.clear();
            updateData();
        } catch (Exception hashTableFullExcpetion) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Conflict !");
            //e.printStackTrace();
            alert.setHeaderText("Error has occured");
            alert.setContentText(hashTableFullExcpetion.getMessage());
            alert.showAndWait();
        }
    }

    private void addData() {
        for (int i = 0; i < Controller.tableSize; i++) {
            hashData.add(new TableObj(i, ""));
            valData.add(new TableObj(i, ""));
        }
    }

    private void updateData() {
        for (int i = 0; i < Controller.tableSize; i++) {
            hashData.add(new TableObj(i, hashStruct.getHashTable()[i]));
            valData.add(new TableObj(i, String.valueOf(hashStruct.getDataTable()[i])));
        }
    }

    public void ifContains(ActionEvent actionEvent) {
        TextFieldId1.setText(String.valueOf(curProcess.containsElementName(TextFieldId1.getText())));
    }

    public void EfficiencyRandom(ActionEvent actionEvent) throws Exception{

        hashData.clear();
        valData.clear();

        hashStruct = new HashStruct(100);
        curProcess = new ProcessHashTable(hashStruct);
        Controller.currentRan = new RandomGen(100);

        for (int i = 0; i < 10; i++) {
            curProcess.insertInTable(new IntVariable(HashStruct.genName(), HashStruct.genValue()));
        }
        Controller.eff1 = curProcess.getEfficiency();

        for (int i = 10; i < 50; i++) {
            curProcess.insertInTable(new IntVariable(HashStruct.genName(), HashStruct.genValue()));
        }
        Controller.eff2  = curProcess.getEfficiency();

        for (int i = 50; i < 90; i++) {
            curProcess.insertInTable(new IntVariable(HashStruct.genName(), HashStruct.genValue()));
        }
        Controller.eff3  = curProcess.getEfficiency();

        Parent root = FXMLLoader.load(getClass().getResource("../View/Efficiency.fxml"));
        Stage stage = new Stage();
        stage.setTitle("EFFICIENCY RESULT");
        stage.setScene(new Scene(root, 190, 215));
        stage.setResizable(false);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());

        stage.show();

        updateData();
    }
}
