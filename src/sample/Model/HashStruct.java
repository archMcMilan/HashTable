package sample.Model;

import java.util.Arrays;
import java.util.Random;

public class HashStruct {
    private String[] hashTable;
    private Object[] dataTable;

    public HashStruct(int initialSize) {
        hashTable = new String[initialSize];
        dataTable = new Object[initialSize];
        //Arrays.fill(hashTable, -1);
    }

    public String[] getHashTable() {
        return hashTable;
    }

    public void setHashTable(String[] hashTable) {
        this.hashTable = hashTable;
    }

    public Object[] getDataTable() {
        return dataTable;
    }

    public void setDataTable(Object[] dataTable) {
        this.dataTable = dataTable;
    }

    /*public IntVariable generateRandomVar() {
        return new IntVariable()
    }*/

    public static String genName() {
        Random rand = new Random();
        int lengthName = rand.nextInt(6) + 2;
        StringBuilder builder = new StringBuilder();

        char inSymb;

        for (int i = 0; i < lengthName; i++) {
            inSymb = (char) (rand.nextInt(25)+97);
            builder.append(inSymb);
        }

        return builder.toString();
    }

    public static int genValue() {
        Random rand = new Random();

        return rand.nextInt(200)-100;
    }



    public void clear() {
        Arrays.fill(hashTable, "");
        Arrays.fill(dataTable, "");
    }

    public static void main(String[] args) {
        for (int i =0; i < 10; i++) {
            System.out.println( genValue() );
        }
    }
}
