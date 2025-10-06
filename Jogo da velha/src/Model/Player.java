package model;

public abstract class Player {

    private String nome;
    private final Symbol s;

    public Player(String nome, Symbol symbol) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do jogador não pode ser vazio.");
        }
        if (symbol == null) {
            throw new NullPointerException("Symbol não pode ser nulo.");
        }
        this.nome = nome.trim();
        this.s = symbol;
    }

    public String getNome() {
        return nome;
    }
    public Symbol getSymbol() {
        return s;
    }

    /** Ação do jogador de escolher a jogada. */
    public abstract Move escolherJogada(Board board);

    @Override
    public String toString() {
        return "Player{" + "nome='" + nome + '\'' + ", symbol=" + s + '}';
    }

}
