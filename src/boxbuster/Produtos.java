/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boxbuster;

import boxbuster.Musica;
import boxbuster.Jogos;
import boxbuster.Filmes;

/**
 *
 * @author Adm
 */
public class Produtos {
    private String nomeProd;
    private double preco;
    private int ano;
    private int codigoProd;
    private int faixaEtaria;
    private boolean alugado;
    
    private Filmes[] listaFilmes;
    private Musica[] listaMusicas;
    private Jogos[] listaJogos;

    public Produtos(String nomeProd, double preco, int ano, int codigoProd, int faixaEtaria, boolean alugado) {
        this.nomeProd = nomeProd;
        this.preco = preco;
        this.ano = ano;
        this.codigoProd = codigoProd;
        this.faixaEtaria = faixaEtaria;
        this.alugado = alugado;
    }

    public Produtos(Filmes[] listaFilmes, Musica[] listaMusicas, Jogos[] listaJogos) {
        this.listaFilmes = listaFilmes;
        this.listaMusicas = listaMusicas;
        this.listaJogos = listaJogos;
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

    public int getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(int faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }
    
    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    public Filmes[] getListaFilmes() {
        return listaFilmes;
    }

    public void setListaFilmes(Filmes[] listaFilmes) {
        this.listaFilmes = listaFilmes;
    }

    public Musica[] getListaMusicas() {
        return listaMusicas;
    }

    public void setListaMusicas(Musica[] listaMusicas) {
        this.listaMusicas = listaMusicas;
    }

    public Jogos[] getListaJogos() {
        return listaJogos;
    }

    public void setListaJogos(Jogos[] listaJogos) {
        this.listaJogos = listaJogos;
    }
    
}
