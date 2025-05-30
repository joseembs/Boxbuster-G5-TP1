package boxbuster;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author joseembs
 */
public class Estoque {
    private static final String arquivo = "estoque.txt";
    
    // listas utilizadas para realizar a maioria das modificações do estoque
    static private ArrayList<Filmes> listaFilmes = new ArrayList<>();
    static private ArrayList<Musicas> listaMusicas = new ArrayList<>();
    static private ArrayList<Tabuleiros> listaTabuleiros = new ArrayList<>();
    static private ArrayList<Videogames> listaVideogames = new ArrayList<>();
    
    // lista utilizada em momentos que todos os produtos ser apresentados
    static private ArrayList<Produtos> listaProdutos = new ArrayList<>(); 
    
    // contador de produtos, sempre se mantém atualizados pelo "estoque.txt"
    static private int cont = 1;

    static public ArrayList<Filmes> getListaFilmes() {
        return listaFilmes;
    }

    static public void setListaFilmes(ArrayList<Filmes> listaFilmesIn) {
        listaFilmes = listaFilmesIn;
    }

    static public ArrayList<Musicas> getListaMusicas() {
        return listaMusicas;
    }

    static public void setListaMusicas(ArrayList<Musicas> listaMusicasIn) {
        listaMusicas = listaMusicasIn;
    }

    static public ArrayList<Tabuleiros> getListaTabuleiros() {
        return listaTabuleiros;
    }

    static public void setListaTabuleiros(ArrayList<Tabuleiros> listaTabuleirosIn) {
        listaTabuleiros = listaTabuleirosIn;
    }

    static public ArrayList<Videogames> getListaVideogames() {
        return listaVideogames;
    }

    static public void setListaVideogames(ArrayList<Videogames> listaVideogamesIn) {
        listaVideogames = listaVideogamesIn;
    }
    
    static public ArrayList<Produtos> getListaProdutos() {
        return listaProdutos;
    }
    
    static public void setListaProdutos(ArrayList<Produtos> listaProdutosIn) {
        listaProdutos = listaProdutosIn;
    }

    static public void addFilme (Filmes filme){
        listaFilmes.add(filme);
    }
    
    static public void addMusica (Musicas musica){
        listaMusicas.add(musica);
    }
    
    static public void addTabuleiro (Tabuleiros tabuleiro){
        listaTabuleiros.add(tabuleiro);
    }
    
    static public void addVideogame (Videogames videogame){
        listaVideogames.add(videogame);
    }
    
    static public void addProduto (Produtos produto){
        listaProdutos.add(produto);
    }

    static public int getCont() {
        return cont;
    }

    static public void setCont(int cont) {
        Estoque.cont = cont;
    }
    
    // retorna o objeto de um produto, apenas necessitando de seu código 
    static public Produtos getProdutoPorCodigo(int codigoProd){
        Produtos produto = null;
        
        for(Produtos tempProduto : Estoque.getListaProdutos()){
            if(codigoProd == tempProduto.getCodigoProd()){
                produto = tempProduto;
                break;
            }
        }
        
        return produto;
    }

    // escreve uma linha nova no arquivo do estoque com o produto informado
    static public void salvarProduto(Produtos item) {
        try (FileWriter fw = new FileWriter(arquivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(item.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // atualiza a lista de produtos geral com base nas listas específicas
    static public ArrayList<Produtos> atualizarLista() {
        listaProdutos = new ArrayList();
        
        listaProdutos.addAll(listaFilmes);
        listaProdutos.addAll(listaMusicas);
        listaProdutos.addAll(listaTabuleiros);
        listaProdutos.addAll(listaVideogames);
        
        Collections.sort(listaProdutos, new Comparator<Produtos>(){
            public int compare (Produtos p1, Produtos p2) {
                int comp = p1.getCodigoProd() - p2.getCodigoProd();
                return comp;
            }
        });
        
        return listaProdutos;
    }
    
    // reescreve por completo o arquivo dos produtos com base na lista geral atualizada
    // geralmente usado para salvar mudanças
    static public void reescreverEstoque() {
        ArrayList<Produtos> listaTemp = atualizarLista();
        
        try (FileWriter fw = new FileWriter(arquivo, false);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for(int i = 0; i < listaTemp.size(); i++){
                out.println(listaTemp.get(i).toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Estoque.loadEstoque(); // mantém tudo sincronizado
    }

    // retorna uma lista com as Strings dos produtos escritos no arquivo
    static public ArrayList<String> lerEstoque() {
        ArrayList<String> produtos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                produtos.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return produtos;
    }
    
    // usa as Strings retornadas pela função lerEstoque() para reconstruir os objetos dos produtos, como também atualiza o cont
    static public ArrayList<Produtos> loadEstoque() {
        Estoque.setListaFilmes(new ArrayList<>());
        Estoque.setListaMusicas(new ArrayList<>());
        Estoque.setListaTabuleiros(new ArrayList<>());
        Estoque.setListaVideogames(new ArrayList<>());
        
        ArrayList<String> produtos = lerEstoque();
        
        int temp = 0;
        
        for(int i = 0; i < produtos.size(); i++){
            String[] item = produtos.get(i).split("_");
            if("Filme".equals(item[0])){
                Filmes filme = new Filmes(item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], Integer.parseInt(item[6]), Integer.parseInt(item[7]), item[8], item[9], item[10]);
                Estoque.addFilme(filme);
            } else if("Musica".equals(item[0])){
                Musicas musica = new Musicas(item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], Integer.parseInt(item[6]), Integer.parseInt(item[7]), item[8], item[9]);
                Estoque.addMusica(musica);
            } else if("Tabuleiro".equals(item[0])){
                Tabuleiros tabuleiro = new Tabuleiros(item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], Integer.parseInt(item[6]), Integer.parseInt(item[7]), item[8], item[9], item[10]);
                Estoque.addTabuleiro(tabuleiro);
            } else if("Videogame".equals(item[0])){
                Videogames videogame = new Videogames(item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], Integer.parseInt(item[6]), Integer.parseInt(item[7]), item[8], item[9], item[10], item[11]);
                Estoque.addVideogame(videogame);
            }
            if(item.length > 4){
                temp = Math.max(temp, Integer.parseInt(item[4]));
            }
        }
        cont = temp;
        
        return atualizarLista();
    }    
}
