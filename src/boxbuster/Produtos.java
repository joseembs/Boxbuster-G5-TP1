package boxbuster;

import java.util.ArrayList;
import boxbuster.Musicas;
import boxbuster.Jogos;
import boxbuster.Filmes;

/**
 *
 * @author joseembs
 */
public abstract class Produtos {
    private String nomeProd;
    private double preco;
    private int ano;
    private int codigoProd;
    private String faixaEtaria;
    private boolean alugado;
    
    public Produtos() {
    }

    public Produtos(String nomeProd, double preco, int ano, int codigoProd, String faixaEtaria, boolean alugado) {
        this.nomeProd = nomeProd;
        this.preco = preco;
        this.ano = ano;
        this.codigoProd = codigoProd;
        this.faixaEtaria = faixaEtaria;
        this.alugado = alugado;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getCodigoProd() {
        return codigoProd;
    }

    public void setCodigoProd(int codigoProd) {
        this.codigoProd = codigoProd;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }
    
    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    @Override
    public String toString() {
        return nomeProd + "_" + preco + "_" + ano + "_" + codigoProd + "_" + faixaEtaria + "_" + alugado;
    }
    
    
}
