package controller;

import model.*;
import view.ConsoleView;

public class MatchController {
    private final ConsoleView view = new ConsoleView();
    private int vitoriasX = 0;
    private int vitoriasO = 0;
    private int empates = 0;

    public void iniciar() {
        System.out.println("Programa iniciado");
        while (true) {
            int escolha = menuPrincipal();
            if (escolha == 0) break;

            Player p1, p2;
            Symbol[] simbolos = {Symbol.X, Symbol.O};

            switch (escolha) {
                case 1 -> {
                    String nome1 = lerNomeNaoVazio("Nome do Jogador 1: ");
                    String nome2 = lerNomeNaoVazio("Nome do Jogador 2: ");
                    p1 = new HumanPlayer(nome1, simbolos[0], view);
                    p2 = new HumanPlayer(nome2, simbolos[1],view);
                }
                case 2 -> {
                    String nome1 = lerNomeNaoVazio("Nome do Jogador: ");
                    p1 = new HumanPlayer(nome1, simbolos[0], view);
                    p2 = new ComputerPlayer("CPU", simbolos[1]);
                }
                case 3 -> {
                    p1 = new ComputerPlayer("CPU 1", simbolos[0]);
                    p2 = new ComputerPlayer("CPU 2", simbolos[1]);
                }
                default -> {
                    view.mostrarMensagem("Opção inválida.");
                    continue;
                }
            }

            String nome1 = p1.getNome();
            String nome2 = p2.getNome();

            Board board = new Board();
            Game jogo = new Game(board,p1, p2, view);

            do {
                GameResult resultado = jogo.jogarPartida();
                exibirResultado(resultado,nome1,nome2);
                atualizarPlacar(resultado);
                exibirPlacar(nome1,nome2);
            } while (desejaRepetir());

            // Exibir placar final






        }

    }
    private void exibirPlacar(String p1, String p2) {
        view.mostrarMensagem(String.format("Placar da sessão -> "+ p1 + ": %d | "+ p2  + ": %d | Empates: %d\n", vitoriasX, vitoriasO, empates));
    }

    private int menuPrincipal() {
        return view.menuInicial();
    }

    private String lerNomeNaoVazio(String prompt) {
        String nome;
        do {
            view.mostrarMensagem(prompt);
            nome = view.lerString();
            if (nome.trim().isEmpty()) {
                view.mostrarMensagem("Nome não pode ser vazio.");
            }
        } while (nome.trim().isEmpty());
        return nome;
    }


    private boolean desejaRepetir() {
        return view.perguntarRepetir();

    }

    private void atualizarPlacar(GameResult r) {
        switch (r) {
            case X_VENCEU -> vitoriasX++;
            case O_VENCEU -> vitoriasO++;
            case EMPATE -> empates++;
            default -> {
            }
        }
    }

    private void exibirResultado(GameResult r, String p1, String p2) {
        switch (r) {
            case X_VENCEU -> view.mostrarMensagem("Vitória de " + p1 + "(X) !");
            case O_VENCEU -> view.mostrarMensagem("Vitória de " + p2 + "(O) !");
            case EMPATE -> view.mostrarMensagem("Empate!");
            default -> view.mostrarMensagem("Erro ao determinar resultado.");
        }
    }





}






