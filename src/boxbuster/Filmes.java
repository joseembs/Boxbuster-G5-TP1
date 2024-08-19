package boxbuster;

/**
 *
 * @author joseembs
 */
public class Filmes extends Produtos{
    private String genero;
    private String estudio;
    private String diretor;
    
    public Filmes() {
    }

     public Filmes(String nomeProd, double preco, int ano, int codigoProd, int faixaEtaria, boolean alugado, String genero, String estudio, String diretor) {
        super(nomeProd, preco, ano, codigoProd, faixaEtaria, alugado);
        this.genero = genero;
        this.estudio = estudio;
        this.diretor = diretor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }


    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
    
    @Override
    public String toString() {
        return "Filme " + super.toString() + " " + genero + " " + estudio + " " + diretor;
    }
    
}
