package boxbuster;

import java.util.ArrayList;

/**
 *
 * @author joseembs
 */
public class Estoque {
    private ArrayList<Filmes> listaFilmes;
    private ArrayList<Musica> listaMusicas;
    private ArrayList<Tabuleiro> listaTabuleiros;
    private ArrayList<Videogames> listaVideogames;

    public Estoque() {
        this.listaFilmes = new ArrayList<>();
        this.listaMusicas = new ArrayList<>();
        this.listaTabuleiros = new ArrayList<>();
    }

    public Estoque(ArrayList<Filmes> listaFilmes, ArrayList<Musica> listaMusicas, ArrayList<Tabuleiro> listaTabuleiro, ArrayList<Videogames> listaVideogames) {
        this.listaFilmes = listaFilmes;
        this.listaMusicas = listaMusicas;
        this.listaTabuleiros = listaTabuleiro;
        this.listaVideogames = listaVideogames;
    }

    public ArrayList<Filmes> getListaFilmes() {
        return listaFilmes;
    }

    public void setListaFilmes(ArrayList<Filmes> listaFilmes) {
        this.listaFilmes = listaFilmes;
    }

    public ArrayList<Musica> getListaMusicas() {
        return listaMusicas;
    }

    public void setListaMusicas(ArrayList<Musica> listaMusicas) {
        this.listaMusicas = listaMusicas;
    }

    public ArrayList<Tabuleiro> getListaTabuleiro() {
        return listaTabuleiros;
    }

    public void setListaTabuleiro(ArrayList<Tabuleiro> listaTabuleiro) {
        this.listaTabuleiros = listaTabuleiro;
    }

    public ArrayList<Videogames> getListaVideogames() {
        return listaVideogames;
    }

    public void setListaVideogames(ArrayList<Videogames> listaVideogames) {
        this.listaVideogames = listaVideogames;
    }

    public void addFilme (Filmes filme){
        this.listaFilmes.add(filme);
    }
    
    public void addMusica (Musica musica){
        this.listaMusicas.add(musica);
    }
    
    public void addTabuleiro (Tabuleiro tabuleiro){
        this.listaTabuleiros.add(tabuleiro);
    }
    
    public void addVideogame (Videogames videogame){
        this.listaVideogames.add(videogame);
    }
    
}
