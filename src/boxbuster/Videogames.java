package boxbuster;

import boxbuster.Jogos;

/**
 *
 * @author joseembs
 */
public class Videogames extends Jogos{
    private String genero;
    private String console;
    private String autor;

    public Videogames() {
    }
    
    public Videogames(String genero, String console, String autor, String nomeProd, double preco, int ano, int codigoProd, int faixaEtaria, boolean alugado, int numJogadores) {
        super(nomeProd, preco, ano, codigoProd, faixaEtaria, alugado, numJogadores);
        this.genero = genero;
        this.console = console;
        this.autor = autor;
    }
    
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
}
