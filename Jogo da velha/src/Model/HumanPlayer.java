package model;

import view.ConsoleView;

public class HumanPlayer extends Player {
    private final ConsoleView view;

    public HumanPlayer(String nome, Symbol s, ConsoleView view) {
        super(nome,s);
        this.view = view;
    }

    @Override
    public Move escolherJogada(Board board) {
        int linha, coluna;
        while (true) {
            linha = view.perguntarLinha(getNome());
            coluna = view.perguntarColuna(getNome());
            if (linha >= 0 && linha <= 2 && coluna >= 0 && coluna <= 2 && board.estaVazio(linha, coluna)) {
                return new Move(linha, coluna);
            }
            view.mostrarMensagem("Jogada inválida. Tente novamente.");
        }


    }
}