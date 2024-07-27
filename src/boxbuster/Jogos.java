/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boxbuster;

/**
 *
 * @author Adm
 */
public class Jogos extends Produtos{
    private int numJogadores;
    private Tabuleiro[] listaTabuleiros;
    private Videogames[] listaVideogames;

    public Jogos(String nomeProd, double preco, int ano, int codigoProd, int faixaEtaria, boolean alugado, int numJogadores) {
        super(nomeProd, preco, ano, codigoProd, faixaEtaria, alugado);
        this.numJogadores = numJogadores;
    }

    public int getNumJogadores() {
        return numJogadores;
    }

    public void setNumJogadores(int numJogadores) {
        this.numJogadores = numJogadores;
    }

    public Tabuleiro[] getListaTabuleiros() {
        return listaTabuleiros;
    }

    public void setListaTabuleiros(Tabuleiro[] listaTabuleiros) {
        this.listaTabuleiros = listaTabuleiros;
    }

    public Videogames[] getListaVideogames() {
        return listaVideogames;
    }

    public void setListaVideogames(Videogames[] listaVideogames) {
        this.listaVideogames = listaVideogames;
    }

}
