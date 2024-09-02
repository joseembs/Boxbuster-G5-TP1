package boxbuster;

import boxbuster.Jogos;

/**
 *
 * @author joseembs
 */
public class Videogames extends Jogos{
    private String genero;
    private String plataforma;
    private String desenvolvedor;

    public Videogames() {
    }
    
    public Videogames(String nomeProd, double preco, int ano, int codigoProd, String faixaEtaria, int disponiveis, int alugados, int numJogadores, String genero, String plataforma, String desenvolvedor) {
        super(nomeProd, preco, ano, codigoProd, faixaEtaria, disponiveis, alugados, numJogadores);
        this.genero = genero;
        this.plataforma = plataforma;
        this.desenvolvedor = desenvolvedor;
    }
    
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String console) {
        this.plataforma = console;
    }

    public String getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(String autor) {
        this.desenvolvedor = autor;
    }
    
    @Override
    public String toString() {
        return "Videogame_" + super.toString() + "_" + genero + "_" + plataforma + "_" + desenvolvedor;
    }
    
}
