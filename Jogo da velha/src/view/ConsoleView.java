package view;

import Model.Board;
import Model.Symbol;

import java.util.Scanner;

public class ConsoleView {
    private Scanner leia = new Scanner(System.in);

    public void exibirTabuleiro(Board board) {
        Symbol[][] grid = board.getGridCopia();
        System.out.println("   0   1   2");
        for (int i = 0; i < Board.TAM; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < Board.TAM; j++) {
                System.out.print(" " + (grid[i][j] == Symbol.VAZIO ? "_" : grid[i][j]) + " ");
                if (j < Board.TAM - 1) System.out.print("|");
            }
            System.out.println();
        }
    }

    public String lerString() {
        return leia.nextLine();
    }

    public int perguntarLinha(String nome) {
        System.out.print(nome + " - Linha: ");
        while (true) {
            String line = leia.nextLine();
            try {
                int linha = Integer.parseInt(line);
                if (linha >= 0 && linha <= 2) {
                    return linha;
                }
                System.out.print("Linha inválida. Digite entre 0 e 2: ");
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Linha (0-2): ");
            }
        }
    }

    public int perguntarColuna(String nome) {
        System.out.print(nome + " - Coluna: ");
        while (true) {
            String line = leia.nextLine();
            try {
                int coluna = Integer.parseInt(line);
                if (coluna >= 0 && coluna <= 2) {
                    return coluna;
                }
                System.out.print("Coluna inválida. Digite entre 0 e 2: ");
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Coluna (0-2): ");
            }
        }
    }
}

