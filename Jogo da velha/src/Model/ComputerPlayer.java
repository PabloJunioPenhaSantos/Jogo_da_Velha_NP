package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerPlayer extends Player {
    private final Random rng = new Random();

    public ComputerPlayer(String nome, Symbol s) {
        super(nome, s);
    }

    @Override
    public Move escolherJogada(Board board) {
        List<Move> livres = new ArrayList<>();
        Symbol[][] grid = board.getGridCopia();
        for (int i = 0; i < Board.TAM; i++) {
            for (int j = 0; j < Board.TAM; j++) {
                if (grid[i][j] == Symbol.VAZIO) {
                    livres.add(new Move(i, j));
                }
            }
        }
        return livres.get(rng.nextInt(livres.size()));
    }
}