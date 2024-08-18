package boxbuster;

import boxbuster.Jogos;

/**
 *
 * @author joseembs
 */
public class Videogames extends Jogos{
    private String genero;
    private String plataforma;
    private String estudio;

    public Videogames() {
    }
    
    public Videogames(String nomeProd, double preco, int ano, int codigoProd, int faixaEtaria, boolean alugado, int numJogadores, String genero, String plataforma, String autor) {
        super(nomeProd, preco, ano, codigoProd, faixaEtaria, alugado, numJogadores);
        this.genero = genero;
        this.plataforma = plataforma;
        this.estudio = autor;
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

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String autor) {
        this.estudio = autor;
    }
    
}
