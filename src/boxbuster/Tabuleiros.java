package boxbuster;

import boxbuster.Jogos;

/**
 *
 * @author joseembs
 */
public class Tabuleiros extends Jogos{
    private String tipo;
    private String marca;
    
    public Tabuleiros() {
    }

    public Tabuleiros(String nomeProd, double preco, int ano, int codigoProd, String faixaEtaria, int disponiveis, int alugados, int numJogadores, String tipo, String marca) {
        super(nomeProd, preco, ano, codigoProd, faixaEtaria, disponiveis, alugados, numJogadores);
        this.tipo = tipo;
        this.marca = marca;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    @Override
    public String toString() {
        return "Tabuleiro_" + super.toString() + "_" + tipo + "_" + marca;
    }
    
}
