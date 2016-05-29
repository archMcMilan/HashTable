package sample.Model;

public class HashTableFullExcpetion extends Exception {
    private int sizeNeeded;
    private String elemName;

    public HashTableFullExcpetion(String message, int sizeNeeded, String elemName) {
        super(message);
        this.sizeNeeded = sizeNeeded;
        this.elemName = elemName;
    }

    public int getSizeNeeded() {
        return sizeNeeded;
    }

    public void setSizeNeeded(int sizeNeeded) {
        this.sizeNeeded = sizeNeeded;
    }

    public String getElemName() {
        return elemName;
    }

    public void setElemName(String elemName) {
        this.elemName = elemName;
    }

    @Override
    public String toString() {
        return "HashTableFullExcpetion{" +
                "sizeNeeded=" + sizeNeeded +
                ", elemName='" + elemName + '\'' +
                '}';
    }
}
