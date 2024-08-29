package boxbuster;

import java.util.ArrayList;

/**
 *
 * @author joseembs
 */
public class Estoque {
    static private ArrayList<Filmes> listaFilmes = new ArrayList<>();
    static private ArrayList<Musica> listaMusicas = new ArrayList<>();
    static private ArrayList<Tabuleiro> listaTabuleiros = new ArrayList<>();
    static private ArrayList<Videogames> listaVideogames = new ArrayList<>();
    static private ArrayList<Produtos> listaProdutos = new ArrayList<>();

//    public Estoque() {
//        listaFilmes = new ArrayList<>();
//        listaMusicas = new ArrayList<>();
//        listaTabuleiros = new ArrayList<>();
//    }

//    public Estoque(ArrayList<Filmes> listaFilmes, ArrayList<Musica> listaMusicas, ArrayList<Tabuleiro> listaTabuleiro, ArrayList<Videogames> listaVideogames) {
//        listaFilmes = listaFilmes;
//        listaMusicas = listaMusicas;
//        listaTabuleiros = listaTabuleiro;
//        listaVideogames = listaVideogames;
//    }

    static public ArrayList<Filmes> getListaFilmes() {
        return listaFilmes;
    }

    static public void setListaFilmes(ArrayList<Filmes> listaFilmes) {
        listaFilmes = listaFilmes;
    }

    static public ArrayList<Musica> getListaMusicas() {
        return listaMusicas;
    }

    static public void setListaMusicas(ArrayList<Musica> listaMusicas) {
        listaMusicas = listaMusicas;
    }

    static public ArrayList<Tabuleiro> getListaTabuleiros() {
        return listaTabuleiros;
    }

    static public void setListaTabuleiros(ArrayList<Tabuleiro> listaTabuleiro) {
        listaTabuleiros = listaTabuleiro;
    }

    static public ArrayList<Videogames> getListaVideogames() {
        return listaVideogames;
    }

    static public void setListaVideogames(ArrayList<Videogames> listaVideogames) {
        listaVideogames = listaVideogames;
    }
    
    static public ArrayList<Produtos> getListaProdutos() {
        return listaProdutos;
    }
    
    static public void setListaProdutos(ArrayList<Produtos> listaProdutos) {
        listaProdutos = listaProdutos;
    }

    static public void addFilme (Filmes filme){
        listaFilmes.add(filme);
    }
    
    static public void addMusica (Musica musica){
        listaMusicas.add(musica);
    }
    
    static public void addTabuleiro (Tabuleiro tabuleiro){
        listaTabuleiros.add(tabuleiro);
    }
    
    static public void addVideogame (Videogames videogame){
        listaVideogames.add(videogame);
    }
    
    static public void addProduto (Produtos produto){
        listaProdutos.add(produto);
    }
}
