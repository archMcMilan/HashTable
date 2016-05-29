package sample.Model;

import sample.Controller.Controller;

public class ProcessPointHashTable implements ProcessUnit {
    HashStructPoint hashStruct;
    int comparasionCount = 0;
    int insertCount = 0;

    public ProcessPointHashTable(int size) {
        hashStruct = new HashStructPoint(size);
    }

    public ProcessPointHashTable(HashStructPoint hashStruct) {
        this.hashStruct = hashStruct;
    }

    public void insertInTable(IntVariable inputVar) throws HashTableFullExcpetion {
        if (hashStruct.getPointFree() <= hashStruct.getHashTable().length - 1) {
            insertCount++;
            tryInsert(inputVar, 0);
        } else {
            throw new HashTableFullExcpetion("Conflict ! The table is full !", hashStruct.getPointFree()
                    + 1, inputVar.getName());
        }
    }

    public boolean tryInsert(IntVariable inputVar, int addNum) {
        int currentId =  Controller.currentHashFunc.getIdNumber(inputVar.getName(),
                hashStruct.getHashTable().length, addNum);
        comparasionCount++;
        if (hashStruct.getHashTable()[currentId] == -1) {
            hashStruct.getHashTable()[currentId] = hashStruct.getPointFree();
            hashStruct.addNewSymbol(inputVar.getName(), inputVar.getValue(), 0);
        }
        else {
            int currentRefNum = hashStruct.getHashTable()[currentId];

            do {
                comparasionCount++;
                currentRefNum = deepSearch(currentRefNum, inputVar);
            }
            while (currentRefNum != 0);
        }
        return true;
    }

    private int deepSearch(int currentReference, IntVariable inputVar) {
        if (hashStruct.getDataTable()[currentReference].getName().equals(inputVar.getName())) {
            hashStruct.getDataTable()[currentReference].setValue(inputVar.getValue());
            return 0;
        }
        if (hashStruct.getDataTable()[currentReference].ifRefZero())  {
            hashStruct.getDataTable()[currentReference].setReference(hashStruct.getPointFree());
            hashStruct.addNewSymbol(inputVar.getName(), inputVar.getValue(), 0);
            return 0;
        } else {
            return hashStruct.getDataTable()[currentReference].getReference();
        }
    }

    public boolean containsElementName(String name) {
        int currentId =  Controller.currentHashFunc.getIdNumber(name, hashStruct.getHashTable().length, 0);

        if (hashStruct.getHashTable()[currentId] == -1) {
           return false;
        } else {
            return deepFindName(name, currentId);
        }
    }

    private boolean deepFindName(String name, int insertId) {
        if (hashStruct.getDataTable()[insertId].getName().equals(name)) {
            return true;
        } else if (hashStruct.getDataTable()[insertId].getReference()!=-1) {
            return deepFindName(name, hashStruct.getDataTable()[insertId].getReference());
        } else {
            return false;
        }
    }

    public double getEfficiency() {
        return (double) comparasionCount / insertCount;
    }

    public static void main(String[] args) {
        Controller.currentNumFunc = HashNumberFunctions.CALCULATE_BY_POSITION;
        Controller.currentHashFunc = HashFunctions.DEFAULT_FUNCTION;

        HashStructPoint hashStruct = new HashStructPoint(7);
        Controller.currentRan = new RandomGen(7);
        ProcessPointHashTable curProcess = new ProcessPointHashTable(hashStruct);

        IntVariable v1 = new IntVariable("sinus", 10);
        IntVariable v2 = new IntVariable("var1", 15);
        IntVariable v3 = new IntVariable("Joe", 20);
        IntVariable v4 = new IntVariable("ByGs", 40);
        IntVariable v5 = new IntVariable("Js", 3);

        try {
           /* curProcess.insertInTable(v1);
            curProcess.insertInTable(v2);
            curProcess.insertInTable(v3);*/
            /*for (int i = 0; i < 15; i++) {
                curProcess.insertInTable(new IntVariable(String.valueOf(i), i));
            }*/
            curProcess.insertInTable(v1);
            curProcess.insertInTable(v2);
            curProcess.insertInTable(v3);
            curProcess.insertInTable(v4);
            curProcess.insertInTable(v5);
            double s = (double) curProcess.comparasionCount / (double) curProcess.insertCount;
            System.out.println(s);
        } catch (HashTableFullExcpetion hashTableFullExcpetion) {
            System.out.println(hashTableFullExcpetion);
        }
        System.out.println();
    }
}
