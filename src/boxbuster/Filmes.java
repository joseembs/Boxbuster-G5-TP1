/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boxbuster;

/**
 *
 * @author Adm
 */
public class Filmes extends Produtos{
    private String genero;
    private String diretor;

    public Filmes(String nomeProd, double preco, int ano, int codigoProd, int faixaEtaria, boolean alugado, String genero, String diretor) {
        super(nomeProd, preco, ano, codigoProd, faixaEtaria, alugado);
        this.genero = genero;
        this.diretor = diretor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
    
}
