package sample.Model;

public interface ProcessUnit {
    void insertInTable(IntVariable inputVar) throws HashTableFullExcpetion;
    boolean tryInsert(IntVariable inputVar, int addNum);
}
