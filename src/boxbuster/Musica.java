package boxbuster;

/**
 *
 * @author joseembs
 */
public class Musica extends Produtos{
    private String estilo;
    private String autor;
    
    public Musica() {
    }

    public Musica(String estilo, String autor, String nomeProd, double preco, int ano, int codigoProd, int faixaEtaria, boolean alugado){
        super(nomeProd, preco, ano, codigoProd, faixaEtaria, alugado);
        this.estilo = estilo;
        this.autor = autor;
    }
    
    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    @Override
    public String toString() {
        return "Musica " + super.toString() + " " + estilo + " " + autor;
    }
}
