package boxbuster;

import java.util.ArrayList;

/**
 *
 * @author joseembs
 */
public abstract class Jogos extends Produtos{
    private String numJogadores;
    
    public Jogos() {
    }

    public Jogos(String nomeProd, double preco, int ano, int codigoProd, String faixaEtaria, int disponiveis, int alugados, String numJogadores) {
        super(nomeProd, preco, ano, codigoProd, faixaEtaria, disponiveis, alugados);
        this.numJogadores = numJogadores;
    }

    public String getNumJogadores() {
        return numJogadores;
    }

    public void setNumJogadores(String numJogadores) {
        this.numJogadores = numJogadores;
    }

    @Override
    public String toString() {
        return super.toString() + "_" + numJogadores;
    }
    
    
}
