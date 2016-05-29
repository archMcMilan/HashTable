package sample.Model;

public class Symbol {
    private String name;
    private int value;
    private int reference;

    public Symbol(String name, int value, int reference) {
        this.name = name;
        this.value = value;
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public boolean ifRefZero() {
        return reference == 0;
    }
}
