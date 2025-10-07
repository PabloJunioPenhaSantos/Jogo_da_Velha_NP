package controller;

import model.*;

import view.ConsoleView;
public class Game {
    private final Board board;
    private final Player p1; // X
    private final Player p2; // O
    private final ConsoleView view;

    public Game(Board board, Player p1, Player p2, ConsoleView view) {
        this.board = board;
        this.p1 = p1;
        this.p2 = p2;
        this.view = view;

    }

    /** Executa a partida até vitória ou empate. */
    public GameResult jogarPartida() {
        board.limpar();
        Player atual = p1;
        GameResult resultado;

        while (true) {
            view.exibirTabuleiro(board);
            view.mostrarMensagem("Vez de " + atual.getNome() + " (" + atual.getSymbol() + ")");
            Move jogada = atual.escolherJogada(board);
            board.marcar(jogada.getLinha(), jogada.getColuna(), atual.getSymbol());
            resultado = board.verificarResultado();

            if (resultado != GameResult.EM_ANDAMENTO) {
                view.exibirTabuleiro(board);
                return resultado;
            }

            atual = (atual == p1) ? p2 : p1;
        }
    }
}
