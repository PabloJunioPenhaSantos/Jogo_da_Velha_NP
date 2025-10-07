package Model;

public enum Symbol {
    X, O, VAZIO;


    public char toChar() {
        return switch (this) {
            case X -> 'X';
            case O -> 'O';
            case VAZIO -> ' ';
        };
    }
}
