package sample.Model;

public enum HashNumberFunctions {
    CALCULATE_BY_POSITION {
        @Override
        public int getNumber(String input) {
            int output = 0;

            for (int i = 0; i < input.length(); i++) {
                output += input.charAt(i);
            }

            return output;
        }
    };

    public abstract int getNumber(String input);
}
