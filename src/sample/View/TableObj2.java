package sample.View;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Nick on 22.05.2016.
 */
public class TableObj2 {
    public TableObj2(int id, String varName, String val, int ref) {
        this.id = new SimpleIntegerProperty(id);
        this.varName = new SimpleStringProperty(varName);
        this.value =  new SimpleStringProperty(val);
        reference = new SimpleIntegerProperty(ref);
    }

    private IntegerProperty id;
    private StringProperty varName;
    private StringProperty value;
    private IntegerProperty reference;


    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getValue() {
        return value.get();
    }

    public StringProperty valueProperty() {
        return value;
    }

    public void setValue(String value) {
        this.value.set(value);
    }

    public int getReference() {
        return reference.get();
    }

    public IntegerProperty referenceProperty() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference.set(reference);
    }

    public String getVarName() {
        return varName.get();
    }

    public StringProperty varNameProperty() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName.set(varName);
    }
}
