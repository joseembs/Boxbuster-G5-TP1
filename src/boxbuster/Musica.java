/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boxbuster;

/**
 *
 * @author Adm
 */
public class Musica extends Produtos{
    private String estilo;
    private String autor;

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
    
}
