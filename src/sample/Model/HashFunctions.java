package sample.Model;

import sample.Controller.Controller;

public enum HashFunctions {
    DEFAULT_FUNCTION {
        @Override
        public int getIdNumber(String currentString, int arraySize, int additionalNum) {
            int currentId = Controller.currentNumFunc.getNumber(currentString);
            return (currentId + additionalNum) % arraySize;
        }
    },
    LINEAR_FUNCTION {
        @Override
        public int getIdNumber(String currentString, int arraySize, int additionalNum) {
            int currentId = Controller.currentNumFunc.getNumber(currentString);
            return (currentId + additionalNum) % arraySize;
        }
    },
    RANDOM_FUNCTION {
        @Override
        public int getIdNumber(String currentString, int arraySize, int additionalNum) {
            int currentId = Controller.currentNumFunc.getNumber(currentString);
            System.out.println(Controller.currentRan.getGeneratedSeq()[additionalNum]);
            return (currentId + Controller.currentRan.getGeneratedSeq()[additionalNum]) % arraySize;
        }
    };

    public abstract int getIdNumber(String currentString, int arraySize, int additionalNum);


}
