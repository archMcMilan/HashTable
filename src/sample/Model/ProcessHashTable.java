package sample.Model;

import sample.Controller.Controller;

public class ProcessHashTable implements ProcessUnit {
    HashStruct hashStruct;
    int comparasionCount = 0;
    int insertCount = 0;

    public ProcessHashTable(int size) {
        hashStruct = new HashStruct(size);
    }

    public ProcessHashTable(HashStruct hashStruct) {
        this.hashStruct = hashStruct;
    }

    public void insertInTable(IntVariable inputVar) throws HashTableFullExcpetion {
        int counter = 0;
        insertCount++;
        while (!tryInsert(inputVar, counter) && counter <= hashStruct.getHashTable().length - 1) {
            counter++;
        }

        if (counter == hashStruct.getDataTable().length) {
            throw new HashTableFullExcpetion("Conflict ! The table is full !", counter + 1, inputVar.getName());
        }

    }

    public boolean tryInsert(IntVariable inputVar, int addNum) {
        int currentId =  Controller.currentHashFunc.getIdNumber(inputVar.getName(),
                hashStruct.getHashTable().length, addNum);

        comparasionCount++;

        if ((hashStruct.getHashTable()[currentId] == null)
                || (hashStruct.getHashTable()[currentId].equals(inputVar.getName()))) {
            hashStruct.getHashTable()[currentId] = inputVar.getName();
            hashStruct.getDataTable()[currentId] = inputVar.getValue();
            return true;
        }

        return false;
    }

    public boolean containsElementName(String name) {
        int currentId =  Controller.currentHashFunc.getIdNumber(name, hashStruct.getHashTable().length, 0);
        int counter = 0;

        if ((hashStruct.getHashTable()[currentId] == null)) {
            return false;
        } else {
            while (hashStruct.getHashTable()[currentId] != null
                    || !hashStruct.getHashTable()[currentId].equals(name)) {
                    counter++;
                    currentId =  Controller.currentHashFunc.getIdNumber(name,
                            hashStruct.getHashTable().length, counter);
            }

            if (hashStruct.getHashTable()[currentId].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
       /* Controller.currentNumFunc = HashNumberFunctions.CALCULATE_BY_POSITION;
        Controller.currentHashFunc = HashFunctions.RANDOM_FUNCTION;

        HashStruct hashStruct = new HashStruct(6);
        Controller.currentRan = new RandomGen(6);
        ProcessHashTable curProcess = new ProcessHashTable(hashStruct);

        IntVariable v1 = new IntVariable("sinus", 10);
        IntVariable v2 = new IntVariable("var1", 15);
        IntVariable v3 = new IntVariable("Joe", 20);
        IntVariable v4 = new IntVariable("ByGs", 40);
        IntVariable v5 = new IntVariable("Js", 3);

        try {
           curProcess.insertInTable(v1);
            curProcess.insertInTable(v2);
            curProcess.insertInTable(v3);
            curProcess.insertInTable(v4);
            curProcess.insertInTable(v5);
           *//* for (int i = 0; i < 34; i++) {
                curProcess.insertInTable(new IntVariable(String.valueOf(i), i));
            }*//*
            double s = (double) curProcess.comparasionCount / (double) curProcess.insertCount;
            System.out.println(s);
        } catch (HashTableFullExcpetion hashTableFullExcpetion) {
        }
        System.out.println();*/
    }

    public double getEfficiency() {
        return (double) comparasionCount / insertCount;
    }
}
