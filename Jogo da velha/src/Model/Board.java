package Model;

import java.util.Arrays;

public class Board {
    private final Symbol[][] grid;
    public static final int TAM = 3;

    public Board() {
        this.grid = new Symbol[TAM][TAM];
        limpar();
    }

    public Symbol[][] getGridCopia() {
        Symbol[][] copia = new Symbol[TAM][TAM];
        for (int i = 0; i < TAM; i++) {
            System.arraycopy(grid[i], 0, copia[i], 0, TAM);
        }
        return copia;
    }

    public void limpar() {
        for (int i = 0; i < TAM; i++) {
            Arrays.fill(grid[i], Symbol.VAZIO);
        }
    }

    public boolean marcar(int linha, int coluna, Symbol s) {
        if (linha < 0 || linha >= TAM || coluna < 0 || coluna >= TAM || grid[linha][coluna] != Symbol.VAZIO) {
            return false;
        }

        grid[linha][coluna] = s;
        return true;
    }

    public boolean estaVazio(int linha, int coluna) {
        return grid[linha][coluna] == Symbol.VAZIO;
    }

    public boolean estaCheio() {
        for (int linha = 0; linha < TAM; linha++) {
            for (int coluna = 0; coluna < TAM; coluna++) {
                if (grid[linha][coluna] == Symbol.VAZIO) {
                    return false;
                }
            }
        }
        return true;
    }

    public GameResult verificarResultado() {
        // Linhas
        for (int i = 0; i < TAM; i++) {
            if (grid[i][0] != Symbol.VAZIO && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
                return grid[i][0] == Symbol.X ? GameResult.X_VENCEU : GameResult.O_VENCEU;
            }
        }

        // Colunas
        for (int i = 0; i < TAM; i++) {
            if (grid[0][i] != Symbol.VAZIO && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
                return grid[0][i] == Symbol.X ? GameResult.X_VENCEU : GameResult.O_VENCEU;
            }
        }

        // Diagonais
        if (grid[0][0] != Symbol.VAZIO && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            return grid[0][0] == Symbol.X ? GameResult.X_VENCEU : GameResult.O_VENCEU;
        }

        if (grid[0][2] != Symbol.VAZIO && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
            return grid[0][2] == Symbol.X ? GameResult.X_VENCEU : GameResult.O_VENCEU;
        }

        // Empate ou em andamento
        if (estaCheio()) {
            return GameResult.EMPATE;
        }

        return GameResult.EM_ANDAMENTO;
    }

    public Symbol getAt(int linha, int coluna) {
        if (!coordValida(linha, coluna)) throw new IndexOutOfBoundsException("Coordenadas inválidas");
        return grid[linha][coluna];
    }

    private boolean coordValida(int l, int c) {
        return l >= 0 && l < TAM && c >= 0 && c < TAM;
    }
}
