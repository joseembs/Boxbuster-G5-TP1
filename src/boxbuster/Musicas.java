package boxbuster;

/**
 *
 * @author joseembs
 */
public class Musicas extends Produtos{
    private String estilo;
    private String autor;
    
    public Musicas() {
    }

    public Musicas(String nomeProd, double preco, int ano, int codigoProd, String faixaEtaria, int disponiveis, int alugados, String estilo, String autor){
        super(nomeProd, preco, ano, codigoProd, faixaEtaria, disponiveis, alugados);
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
        return "Musica_" + super.toString() + "_" + estilo + "_" + autor;
    }
}
