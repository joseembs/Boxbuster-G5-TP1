package boxbuster;

import java.util.ArrayList;

/**
 *
 * @author joseembs
 */
public abstract class Jogos extends Produtos{
    private int numJogadores;
    
    public Jogos() {
    }

    public Jogos(String nomeProd, double preco, int ano, int codigoProd, String faixaEtaria, boolean alugado, int numJogadores) {
        super(nomeProd, preco, ano, codigoProd, faixaEtaria, alugado);
        this.numJogadores = numJogadores;
    }

    public int getNumJogadores() {
        return numJogadores;
    }

    public void setNumJogadores(int numJogadores) {
        this.numJogadores = numJogadores;
    }

    @Override
    public String toString() {
        return super.toString() + "_" + numJogadores;
    }
    
    
}
