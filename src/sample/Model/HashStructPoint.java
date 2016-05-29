package sample.Model;

import java.util.Arrays;

public class HashStructPoint {
    private int[] hashTable;
    private Symbol[] dataTable;
    private int pointFree;

    public HashStructPoint(int initialSize) {
        hashTable = new int[initialSize];
        Arrays.fill(hashTable, -1);
        dataTable = new Symbol[initialSize];
        pointFree = 0;
        Arrays.fill(dataTable, new Symbol("", 0, 0));
    }

    public int[] getHashTable() {
        return hashTable;
    }

    public void setHashTable(int[] hashTable) {
        this.hashTable = hashTable;
    }

    public Symbol[] getDataTable() {
        return dataTable;
    }

    public void setDataTable(Symbol[] dataTable) {
        this.dataTable = dataTable;
    }

    public int getPointFree() {
        return pointFree;
    }

    public void setPointFree(int pointFree) {
        this.pointFree = pointFree;
    }

    public void addNewSymbol(String name, int value, int reference) {
        dataTable[pointFree] = new Symbol(name, value, reference);
        pointFree++;
    }
}
