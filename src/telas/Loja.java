package telas;

import boxbuster.Estoque;
import boxbuster.Filmes;
import boxbuster.Musicas;
import boxbuster.Pedido;
import boxbuster.Produtos;
import boxbuster.Tabuleiros;
import boxbuster.Videogames;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author josembs
 */
public class Loja extends javax.swing.JFrame {

    // listas para facilitar a comunicação com o estoque
    private ArrayList<Filmes> listaFilmes;
    private ArrayList<Musicas> listaMusicas;
    private ArrayList<Tabuleiros> listaTabuleiros;
    private ArrayList<Videogames> listaVideogames;
    
    // mantém e informa o valor total do aluguel sendo feito
    private double valorTotal = 0.0;
    
    // listas para coordenar o pedido e manter a loja condizente com as decisões feitas pelo cliente
    private ArrayList<javax.swing.JRadioButton> tempBtnSelected = new ArrayList<>();
    private ArrayList<Produtos> tempPedido = new ArrayList<>();
    private ArrayList<Produtos> finalPedido = Pedido.getPedidoAtual();
    
    /**
     * Creates new form LojaScr
     */    
    public Loja() {
        setLocationRelativeTo(null);
        initComponents();
        
        valorTotal = 0.0;
        
        setLoja();
        lblCartLoja.setText("Carrinho: " + finalPedido.size() + " itens - R$ " + valorTotal + "0");
    }

    // listas com base na quantidade de itens de cada aba da loj
    private String[] detalhesMv = new String[10];
    private String[] detalhesMus = new String[10];
    private String[] detalhesTab = new String[6];
    private String[] detalhesVid = new String[10];
    
    // utiliza as informações do estoque para definir todos os itens da loja, cada tipo de produto por vez
    // nessa função que são determinadas as imagens da loja com base no nome dos produtos
    private void setLoja() {
        Estoque.loadEstoque();
        
        listaFilmes = Estoque.getListaFilmes();
        listaMusicas = Estoque.getListaMusicas();
        listaTabuleiros = Estoque.getListaTabuleiros();
        listaVideogames = Estoque.getListaVideogames();
        
        javax.swing.JLabel[] listImgMv = {imgMv1, imgMv2, imgMv3, imgMv4, imgMv5, imgMv6, imgMv7, imgMv8, imgMv9, imgMv10};
        javax.swing.JLabel[] listNomeMv = {nomeMv1, nomeMv2, nomeMv3, nomeMv4, nomeMv5, nomeMv6, nomeMv7, nomeMv8, nomeMv9, nomeMv10};
        javax.swing.JLabel[] listDescMv = {descMv1, descMv2, descMv3, descMv4, descMv5, descMv6, descMv7, descMv8, descMv9, descMv10};
        javax.swing.JLabel[] listPrecoMv = {precoMv1, precoMv2, precoMv3, precoMv4, precoMv5, precoMv6, precoMv7, precoMv8, precoMv9, precoMv10};
        javax.swing.JRadioButton[] listAlugarMv = {btnAlugarMv1, btnAlugarMv2, btnAlugarMv3, btnAlugarMv4, btnAlugarMv5, btnAlugarMv6, btnAlugarMv7, btnAlugarMv8, btnAlugarMv9, btnAlugarMv10};
        javax.swing.JButton[] btnDetalhesMv = {btnDetalhesMv1, btnDetalhesMv2, btnDetalhesMv3, btnDetalhesMv4, btnDetalhesMv5, btnDetalhesMv6, btnDetalhesMv7, btnDetalhesMv8, btnDetalhesMv9, btnDetalhesMv10};
        
        for(int i = 0; i < 10 && i < listaFilmes.size(); i++){
            Filmes filme = listaFilmes.get(i);
            
            String titulo = filme.getNomeProd().toLowerCase();
            
            if(titulo.contains("alien")){
                listImgMv[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/filmes/Alien.png")));
            } else if(titulo.contains("de volta para o futuro")){
                listImgMv[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/filmes/DeVoltaParaoFuturo.png")));
            } else if(titulo.contains("enigma de outro mundo")){
                listImgMv[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/filmes/EnigmaDeOutroMundo.png")));
            } else if(titulo.contains("esqueceram de mim")){
                listImgMv[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/filmes/EsqueceramDeMim.png")));
            } else if(titulo.contains("la la land")){
                listImgMv[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/filmes/LaLaLand.png")));
            } else if(titulo.contains("lorax")){
                listImgMv[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/filmes/Lorax.png")));
            } else if(titulo.contains("matrix")){
                listImgMv[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/filmes/Matrix.png")));
            } else if(titulo.contains("procurando nemo")){
                listImgMv[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/filmes/Nemo.png")));
            } else if(titulo.contains("rei leão")){
                listImgMv[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/filmes/OReiLeao.png")));
            } else if(titulo.contains("senhor dos anéis")){
                listImgMv[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/filmes/OSenhorDosAneis.png")));
            } else if(titulo.contains("vingadores")){
                listImgMv[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/filmes/OsVingadores.png")));
            } else if(titulo.contains("pânico")){
                listImgMv[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/filmes/Panico.png")));
            } else if(titulo.contains("shrek")){
                listImgMv[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/filmes/Shrek.png")));
            } else if(titulo.contains("titanic")){
                listImgMv[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/filmes/Titanic.png")));
            } else if(titulo.contains("toy story")){
                listImgMv[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/filmes/ToyStory.png")));
            } else {
                listImgMv[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/filmes/MissingPoster.png")));
            }
            
            listNomeMv[i].setText(filme.getNomeProd());
            listDescMv[i].setText(Integer.toString(filme.getAno()) + " - " + filme.getDisponiveis() + " em estoque");
            listPrecoMv[i].setText("R$ " + Double.toString(filme.getPreco()) + "0");
            listAlugarMv[i].setEnabled(filme.getDisponiveis() > 0);
            
            if(finalPedido.contains(filme)){
                listAlugarMv[i].setText("Remover do carrinho");
                valorTotal += filme.getPreco();
            } else if(filme.getDisponiveis() == 0){
                listAlugarMv[i].setText("Esgotado");
            } else {
                listAlugarMv[i].setText("Alugar");
            }
            
            btnDetalhesMv[i].setEnabled(true);
            detalhesMv[i] = filme.getNomeProd() + "\nValor do aluguel: R$ " + Double.toString(filme.getPreco()) + "0" + "\nGênero: " + filme.getGenero() + "\nEstúdio: " + filme.getEstudio()  + "\nDiretor: " + filme.getDiretor() + "\nAno: " + Integer.toString(filme.getAno()) +  "\nFaixa etária: " + filme.getFaixaEtaria();
        }
        
        javax.swing.JLabel[] listImgMus = {imgMus1, imgMus2, imgMus3, imgMus4, imgMus5, imgMus6, imgMus7, imgMus8, imgMus9, imgMus10};
        javax.swing.JLabel[] listNomeMus = {nomeMus1, nomeMus2, nomeMus3, nomeMus4, nomeMus5, nomeMus6, nomeMus7, nomeMus8, nomeMus9, nomeMus10};
        javax.swing.JLabel[] listDescMus = {descMus1, descMus2, descMus3, descMus4, descMus5, descMus6, descMus7, descMus8, descMus9, descMus10};
        javax.swing.JLabel[] listPrecoMus = {precoMus1, precoMus2, precoMus3, precoMus4, precoMus5, precoMus6, precoMus7, precoMus8, precoMus9, precoMus10};
        javax.swing.JRadioButton[] listAlugarMus = {btnAlugarMus1, btnAlugarMus2, btnAlugarMus3, btnAlugarMus4, btnAlugarMus5, btnAlugarMus6, btnAlugarMus7, btnAlugarMus8, btnAlugarMus9, btnAlugarMus10};
        javax.swing.JButton[] btnDetalhesMus = {btnDetalhesMus1, btnDetalhesMus2, btnDetalhesMus3, btnDetalhesMus4, btnDetalhesMus5, btnDetalhesMus6, btnDetalhesMus7, btnDetalhesMus8, btnDetalhesMus9, btnDetalhesMus10};
        
        for(int i = 0; i < 10 && i < listaMusicas.size(); i++){
            Musicas musica = listaMusicas.get(i);
            
            String titulo = musica.getNomeProd().toLowerCase();
            
            if(titulo.contains("1000 gecs")){
                listImgMus[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/musicas/1000gecs.jpeg")));
            } else if(titulo.contains("abbey road")){
                listImgMus[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/musicas/AbbeyRoad.jpeg")));
            } else if(titulo.contains("bohemian rhapsody")){
                listImgMus[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/musicas/BohemianRhapsody.jpeg")));
            } else if(titulo.contains("brand new eyes")){
                listImgMus[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/musicas/BrandNewEyes.jpeg")));
            } else if(titulo.contains("celebration")){
                listImgMus[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/musicas/Celebration")));
            } else if(titulo.contains("construção")){
                listImgMus[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/musicas/Construcao.jpeg")));
            } else if(titulo.contains("discovery")){
                listImgMus[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/musicas/Discovery.jpeg")));
            } else if(titulo.contains("elis & tom")){
                listImgMus[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/musicas/ElisETom.jpeg")));
            } else if(titulo.contains("folklore")){
                listImgMus[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/musicas/Folklore.jpeg")));
            } else if(titulo.contains("heroes")){
                listImgMus[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/musicas/Heroes.jpeg")));
            } else if(titulo.contains("hit me hard and soft")){
                listImgMus[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/musicas/HitMeHardAndSoft.jpeg")));
            } else if(titulo.contains("ok computer")){
                listImgMus[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/musicas/OKComputer.jpeg")));
            } else if(titulo.contains("plastic love")){
                listImgMus[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/musicas/PlasticLove.jpg")));
            } else if(titulo.contains("rosas e vinho tinto")){
                listImgMus[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/musicas/RosasEVinhoTinto.jpeg")));
            } else if(titulo.contains("sayonara")){
                listImgMus[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/musicas/Sayonara.jpeg")));
            } else if(titulo.contains("speaking in tongues")){
                listImgMus[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/musicas/SpeakingInTongues.jpeg")));
            } else if(titulo.contains("spirit phone")){
                listImgMus[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/musicas/SpiritPhone.jpeg")));
            } else if(titulo.contains("dark side of the moon")){
                listImgMus[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/musicas/TheDarkSideOfTheMoon.jpeg")));
            } else if(titulo.contains("thriller")){
                listImgMus[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/musicas/Thriller.jpeg")));
            } else if(titulo.contains("worlds")){
                listImgMus[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/musicas/Worlds.jpeg")));
            } else if(titulo.contains("xou da xuxa")){
                listImgMus[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/musicas/XouDaXuxa.jpeg")));
            } else {
                listImgMus[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/musicas/MissingImage2.png")));
            }
            
            listNomeMus[i].setText(musica.getNomeProd());
            listDescMus[i].setText(Integer.toString(musica.getAno()) + " - " + musica.getDisponiveis() + " em estoque");
            listPrecoMus[i].setText("R$ " + Double.toString(musica.getPreco()) + "0");
            listAlugarMus[i].setEnabled(musica.getDisponiveis() > 0);
            
            if(finalPedido.contains(musica)){
                listAlugarMus[i].setText("Remover do carrinho");
                valorTotal += musica.getPreco();
            } else if(musica.getDisponiveis() == 0){
                listAlugarMus[i].setText("Esgotado");
            } else {
                listAlugarMus[i].setText("Alugar");
            }
            
            btnDetalhesMus[i].setEnabled(true);
            detalhesMus[i] = musica.getNomeProd() + "\nValor do aluguel: R$ " + Double.toString(musica.getPreco()) + "0" + "\nEstilo: " + musica.getEstilo() + "\nAutor: " + musica.getAutor() + "\nAno: " + Integer.toString(musica.getAno()) +  "\nFaixa etária: " + musica.getFaixaEtaria();
        }
        
        javax.swing.JLabel[] listImgTab = {imgTab1, imgTab2, imgTab3, imgTab4, imgTab5, imgTab6};
        javax.swing.JLabel[] listNomeTab = {nomeTab1, nomeTab2, nomeTab3, nomeTab4, nomeTab5, nomeTab6};
        javax.swing.JLabel[] listDescTab = {descTab1, descTab2, descTab3, descTab4, descTab5, descTab6};
        javax.swing.JLabel[] listPrecoTab = {precoTab1, precoTab2, precoTab3, precoTab4, precoTab5, precoTab6};
        javax.swing.JRadioButton[] listAlugarTab = {btnAlugarTab1, btnAlugarTab2, btnAlugarTab3, btnAlugarTab4, btnAlugarTab5, btnAlugarTab6};
        javax.swing.JButton[] btnDetalhesTab = {btnDetalhesTab1, btnDetalhesTab2, btnDetalhesTab3, btnDetalhesTab4, btnDetalhesTab5, btnDetalhesTab6};
        
        for(int i = 0; i < 6 && i < listaTabuleiros.size(); i++){
            Tabuleiros tabuleiro = listaTabuleiros.get(i);
            
            String titulo = tabuleiro.getNomeProd().toLowerCase();
            
            if(titulo.contains("black stories")){
                listImgTab[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tabuleiros/BlackStories.png")));
            } else if(titulo.contains("cobras e escadas")){
                listImgTab[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tabuleiros/Cobras.png")));
            } else if(titulo.contains("coup")){
                listImgTab[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tabuleiros/Coup.png")));
            } else if(titulo.contains("dungeons & dragons")){
                listImgTab[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tabuleiros/Dungeons.png")));
            } else if(titulo.contains("jogo da vida")){
                listImgTab[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tabuleiros/JogoDaVida.png")));
            } else if(titulo.contains("monopoly")){
                listImgTab[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tabuleiros/Monopoly.png")));
            } else {
                listImgTab[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tabuleiros/MissingImage2.png")));
            }
            
            listNomeTab[i].setText(tabuleiro.getNomeProd());
            listDescTab[i].setText(Integer.toString(tabuleiro.getAno()) + " - " + tabuleiro.getDisponiveis() + " em estoque");
            listPrecoTab[i].setText("R$ " + Double.toString(tabuleiro.getPreco()) + "0");
            listAlugarTab[i].setEnabled(tabuleiro.getDisponiveis() > 0);
            
            if(finalPedido.contains(tabuleiro)){
                listAlugarTab[i].setText("Remover do carrinho");
                valorTotal += tabuleiro.getPreco();
            } else if(tabuleiro.getDisponiveis() == 0){
                listAlugarTab[i].setText("Esgotado");
            } else {
                listAlugarTab[i].setText("Alugar");
            }
            
            btnDetalhesTab[i].setEnabled(true);
            detalhesTab[i] = tabuleiro.getNomeProd() + "\nValor do aluguel: R$ " + Double.toString(tabuleiro.getPreco()) + "0" + "\nTipo: " + tabuleiro.getTipo() + "\nNúmero de jogadores: " + tabuleiro.getNumJogadores() + "\nMarca: " + tabuleiro.getMarca() + "\nAno: " + Integer.toString(tabuleiro.getAno()) +  "\nFaixa etária: " + tabuleiro.getFaixaEtaria();
        }
        
        javax.swing.JLabel[] listImgVid = {imgVid1, imgVid2, imgVid3, imgVid4, imgVid5, imgVid6, imgVid7, imgVid8, imgVid9, imgVid10};
        javax.swing.JLabel[] listNomeVid = {nomeVid1, nomeVid2, nomeVid3, nomeVid4, nomeVid5, nomeVid6, nomeVid7, nomeVid8, nomeVid9, nomeVid10};
        javax.swing.JLabel[] listDescVid = {descVid1, descVid2, descVid3, descVid4, descVid5, descVid6, descVid7, descVid8, descVid9, descVid10};
        javax.swing.JLabel[] listPrecoVid = {precoVid1, precoVid2, precoVid3, precoVid4, precoVid5, precoVid6, precoVid7, precoVid8, precoVid9, precoVid10};
        javax.swing.JRadioButton[] listAlugarVid = {btnAlugarVid1, btnAlugarVid2, btnAlugarVid3, btnAlugarVid4, btnAlugarVid5, btnAlugarVid6, btnAlugarVid7, btnAlugarVid8, btnAlugarVid9, btnAlugarVid10};
        javax.swing.JButton[] btnDetalhesVid = {btnDetalhesVid1, btnDetalhesVid2, btnDetalhesVid3, btnDetalhesVid4, btnDetalhesVid5, btnDetalhesVid6, btnDetalhesVid7, btnDetalhesVid8, btnDetalhesVid9, btnDetalhesVid10};
        
        for(int i = 0; i < 10 && i < listaVideogames.size(); i++){
            Videogames videogame = listaVideogames.get(i);
            
            String titulo = videogame.getNomeProd().toLowerCase();
            
            if(titulo.contains("hat in time")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/AHatInTime.jpg")));
            } else if(titulo.contains("ace attorney")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/AceAttorney.jpg")));
            } else if(titulo.contains("animal crossing")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/AnimalCrossingNewLeaf.jpg")));
            } else if(titulo.contains("castle crashers")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/CastleCrashers.jpg")));
            } else if(titulo.contains("celeste")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/Celeste.jpg")));
            } else if(titulo.contains("crash bandicoot")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/CrashBandicoot.jpg")));
            } else if(titulo.contains("doom")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/Doom.jpg")));
            } else if(titulo.contains("enigma do medo")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/EnigmaDoMedo.jpg")));
            } else if(titulo.contains("golden eye 007")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/GoldenEye007.jpg")));
            } else if(titulo.contains("guitar hero 3")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/GuitarHero3.jpg")));
            } else if(titulo.contains("silksong")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/Silksong.jpg")));
            } else if(titulo.contains("luigi's mansion")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/LuigisMansion.jpg")));
            } else if(titulo.contains("omori")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/Omori.jpg")));
            } else if(titulo.contains("outer wilds")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/OuterWilds.jpg")));
            } else if(titulo.contains("pokémon red")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/PokemonRed.jpg")));
            } else if(titulo.contains("red dead redemption 2")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/RedDeadRedemption2.jpg")));
             } else if(titulo.contains("resident evil 4")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/ResidentEvil4.jpg")));
             } else if(titulo.contains("shadow of the colossus")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/ShadowOfTheColossus.jpg")));
            } else if(titulo.contains("silent hill 2")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/SilentHill2.jpg")));
            } else if(titulo.contains("hollow knight")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/HollowKnight.jpg")));
            } else if(titulo.contains("sonic the hedgehog")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/SonicTheHedgehog.jpg")));
            } else if(titulo.contains("super mario bros")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/SuperMarioBros.jpg")));
            } else if(titulo.contains("the last of us")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/TheLastOfUs.jpg")));
            } else if(titulo.contains("wii sports")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/WiiSports.jpg")));
            } else if(titulo.contains("breath of the wild")){
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/ZeldaBreathOfTheWild.jpg")));
            } else {
                listImgVid[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/videogames/MissingImage1.png")));
            }
            
            listNomeVid[i].setText(videogame.getNomeProd());
            listDescVid[i].setText(Integer.toString(videogame.getAno()) + " - " + videogame.getDisponiveis() + " em estoque");
            listPrecoVid[i].setText("R$ " + Double.toString(videogame.getPreco()) + "0");
            listAlugarVid[i].setEnabled(videogame.getDisponiveis() > 0);
            
            if(finalPedido.contains(videogame)){
                listAlugarVid[i].setText("Remover do carrinho");
                valorTotal += videogame.getPreco();
            } else if(videogame.getDisponiveis() == 0){
                listAlugarVid[i].setText("Esgotado");
            } else {
                listAlugarVid[i].setText("Alugar");
            }
            
            btnDetalhesVid[i].setEnabled(true);
            detalhesVid[i] = videogame.getNomeProd() + "\nValor do aluguel: R$ " + Double.toString(videogame.getPreco()) + "0" + "\nPlataforma: " + videogame.getPlataforma() + "\nGênero: " + videogame.getGenero() + "\nDesenvolvedor: " + videogame.getDesenvolvedor() + "\nNúmero de jogadores: " + videogame.getNumJogadores() + "\nAno: " + Integer.toString(videogame.getAno()) +  "\nFaixa etária: " + videogame.getFaixaEtaria();
        }
    }
    
    
    // analisa o estado de cada botão de alugar para salvar os itens que o usuário 
    // selecionou para adicionar ou remover do carrinho
    private void addItemToTemp(javax.swing.JRadioButton btn, String tipo, int ind){
        if(btn.isSelected()){
            tempBtnSelected.add(btn);
            switch(tipo){
                case "Mv" -> tempPedido.add(listaFilmes.get(ind-1));
                case "Mus" -> tempPedido.add(listaMusicas.get(ind-1));
                case "Tab" -> tempPedido.add(listaTabuleiros.get(ind-1));
                case "Vid" -> tempPedido.add(listaVideogames.get(ind-1));
            }
        } else {
            tempBtnSelected.remove(btn);
            switch(tipo){
                case "Mv" -> tempPedido.remove(listaFilmes.get(ind-1));
                case "Mus" -> tempPedido.remove(listaMusicas.get(ind-1));
                case "Tab" -> tempPedido.remove(listaTabuleiros.get(ind-1));
                case "Vid" -> tempPedido.remove(listaVideogames.get(ind-1));
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLoja = new javax.swing.JPanel();
        tabbedPnlLoja = new javax.swing.JTabbedPane();
        scrollFilmes = new javax.swing.JScrollPane();
        pnlFilmes = new javax.swing.JPanel();
        pnlMv1 = new javax.swing.JPanel();
        imgMv1 = new javax.swing.JLabel();
        nomeMv1 = new javax.swing.JLabel();
        descMv1 = new javax.swing.JLabel();
        precoMv1 = new javax.swing.JLabel();
        btnAlugarMv1 = new javax.swing.JRadioButton();
        btnDetalhesMv1 = new javax.swing.JButton();
        pnlMv2 = new javax.swing.JPanel();
        imgMv2 = new javax.swing.JLabel();
        nomeMv2 = new javax.swing.JLabel();
        descMv2 = new javax.swing.JLabel();
        precoMv2 = new javax.swing.JLabel();
        btnAlugarMv2 = new javax.swing.JRadioButton();
        btnDetalhesMv2 = new javax.swing.JButton();
        pnlMv3 = new javax.swing.JPanel();
        imgMv3 = new javax.swing.JLabel();
        nomeMv3 = new javax.swing.JLabel();
        descMv3 = new javax.swing.JLabel();
        precoMv3 = new javax.swing.JLabel();
        btnAlugarMv3 = new javax.swing.JRadioButton();
        btnDetalhesMv3 = new javax.swing.JButton();
        pnlMv4 = new javax.swing.JPanel();
        imgMv4 = new javax.swing.JLabel();
        nomeMv4 = new javax.swing.JLabel();
        descMv4 = new javax.swing.JLabel();
        precoMv4 = new javax.swing.JLabel();
        btnAlugarMv4 = new javax.swing.JRadioButton();
        btnDetalhesMv4 = new javax.swing.JButton();
        pnlMv5 = new javax.swing.JPanel();
        imgMv5 = new javax.swing.JLabel();
        nomeMv5 = new javax.swing.JLabel();
        descMv5 = new javax.swing.JLabel();
        precoMv5 = new javax.swing.JLabel();
        btnAlugarMv5 = new javax.swing.JRadioButton();
        btnDetalhesMv5 = new javax.swing.JButton();
        pnlMv6 = new javax.swing.JPanel();
        imgMv6 = new javax.swing.JLabel();
        nomeMv6 = new javax.swing.JLabel();
        descMv6 = new javax.swing.JLabel();
        precoMv6 = new javax.swing.JLabel();
        btnAlugarMv6 = new javax.swing.JRadioButton();
        btnDetalhesMv6 = new javax.swing.JButton();
        pnlMv7 = new javax.swing.JPanel();
        imgMv7 = new javax.swing.JLabel();
        nomeMv7 = new javax.swing.JLabel();
        descMv7 = new javax.swing.JLabel();
        precoMv7 = new javax.swing.JLabel();
        btnAlugarMv7 = new javax.swing.JRadioButton();
        btnDetalhesMv7 = new javax.swing.JButton();
        pnlMv8 = new javax.swing.JPanel();
        imgMv8 = new javax.swing.JLabel();
        nomeMv8 = new javax.swing.JLabel();
        descMv8 = new javax.swing.JLabel();
        precoMv8 = new javax.swing.JLabel();
        btnAlugarMv8 = new javax.swing.JRadioButton();
        btnDetalhesMv8 = new javax.swing.JButton();
        pnlMv9 = new javax.swing.JPanel();
        imgMv9 = new javax.swing.JLabel();
        nomeMv9 = new javax.swing.JLabel();
        descMv9 = new javax.swing.JLabel();
        precoMv9 = new javax.swing.JLabel();
        btnAlugarMv9 = new javax.swing.JRadioButton();
        btnDetalhesMv9 = new javax.swing.JButton();
        pnlMv10 = new javax.swing.JPanel();
        imgMv10 = new javax.swing.JLabel();
        nomeMv10 = new javax.swing.JLabel();
        descMv10 = new javax.swing.JLabel();
        precoMv10 = new javax.swing.JLabel();
        btnAlugarMv10 = new javax.swing.JRadioButton();
        btnDetalhesMv10 = new javax.swing.JButton();
        scrollMusicas = new javax.swing.JScrollPane();
        pnlMusicas = new javax.swing.JPanel();
        pnlMus1 = new javax.swing.JPanel();
        imgMus1 = new javax.swing.JLabel();
        nomeMus1 = new javax.swing.JLabel();
        descMus1 = new javax.swing.JLabel();
        precoMus1 = new javax.swing.JLabel();
        btnAlugarMus1 = new javax.swing.JRadioButton();
        btnDetalhesMus1 = new javax.swing.JButton();
        pnlMus2 = new javax.swing.JPanel();
        imgMus2 = new javax.swing.JLabel();
        nomeMus2 = new javax.swing.JLabel();
        descMus2 = new javax.swing.JLabel();
        precoMus2 = new javax.swing.JLabel();
        btnAlugarMus2 = new javax.swing.JRadioButton();
        btnDetalhesMus2 = new javax.swing.JButton();
        pnlMus3 = new javax.swing.JPanel();
        imgMus3 = new javax.swing.JLabel();
        nomeMus3 = new javax.swing.JLabel();
        descMus3 = new javax.swing.JLabel();
        precoMus3 = new javax.swing.JLabel();
        btnAlugarMus3 = new javax.swing.JRadioButton();
        btnDetalhesMus3 = new javax.swing.JButton();
        pnlMus4 = new javax.swing.JPanel();
        imgMus4 = new javax.swing.JLabel();
        nomeMus4 = new javax.swing.JLabel();
        descMus4 = new javax.swing.JLabel();
        precoMus4 = new javax.swing.JLabel();
        btnAlugarMus4 = new javax.swing.JRadioButton();
        btnDetalhesMus4 = new javax.swing.JButton();
        pnlMus5 = new javax.swing.JPanel();
        imgMus5 = new javax.swing.JLabel();
        nomeMus5 = new javax.swing.JLabel();
        descMus5 = new javax.swing.JLabel();
        precoMus5 = new javax.swing.JLabel();
        btnAlugarMus5 = new javax.swing.JRadioButton();
        btnDetalhesMus5 = new javax.swing.JButton();
        pnlMus6 = new javax.swing.JPanel();
        imgMus6 = new javax.swing.JLabel();
        nomeMus6 = new javax.swing.JLabel();
        descMus6 = new javax.swing.JLabel();
        precoMus6 = new javax.swing.JLabel();
        btnAlugarMus6 = new javax.swing.JRadioButton();
        btnDetalhesMus6 = new javax.swing.JButton();
        pnlMus7 = new javax.swing.JPanel();
        imgMus7 = new javax.swing.JLabel();
        nomeMus7 = new javax.swing.JLabel();
        descMus7 = new javax.swing.JLabel();
        precoMus7 = new javax.swing.JLabel();
        btnAlugarMus7 = new javax.swing.JRadioButton();
        btnDetalhesMus7 = new javax.swing.JButton();
        pnlMus8 = new javax.swing.JPanel();
        imgMus8 = new javax.swing.JLabel();
        nomeMus8 = new javax.swing.JLabel();
        descMus8 = new javax.swing.JLabel();
        precoMus8 = new javax.swing.JLabel();
        btnAlugarMus8 = new javax.swing.JRadioButton();
        btnDetalhesMus8 = new javax.swing.JButton();
        pnlMus9 = new javax.swing.JPanel();
        imgMus9 = new javax.swing.JLabel();
        nomeMus9 = new javax.swing.JLabel();
        descMus9 = new javax.swing.JLabel();
        precoMus9 = new javax.swing.JLabel();
        btnAlugarMus9 = new javax.swing.JRadioButton();
        btnDetalhesMus9 = new javax.swing.JButton();
        pnlMus10 = new javax.swing.JPanel();
        imgMus10 = new javax.swing.JLabel();
        nomeMus10 = new javax.swing.JLabel();
        descMus10 = new javax.swing.JLabel();
        precoMus10 = new javax.swing.JLabel();
        btnAlugarMus10 = new javax.swing.JRadioButton();
        btnDetalhesMus10 = new javax.swing.JButton();
        scrollTabuleiros = new javax.swing.JScrollPane();
        pnlTabuleiros = new javax.swing.JPanel();
        pnlTab1 = new javax.swing.JPanel();
        imgTab1 = new javax.swing.JLabel();
        nomeTab1 = new javax.swing.JLabel();
        descTab1 = new javax.swing.JLabel();
        precoTab1 = new javax.swing.JLabel();
        btnAlugarTab1 = new javax.swing.JRadioButton();
        btnDetalhesTab1 = new javax.swing.JButton();
        pnlTab2 = new javax.swing.JPanel();
        imgTab2 = new javax.swing.JLabel();
        nomeTab2 = new javax.swing.JLabel();
        descTab2 = new javax.swing.JLabel();
        precoTab2 = new javax.swing.JLabel();
        btnAlugarTab2 = new javax.swing.JRadioButton();
        btnDetalhesTab2 = new javax.swing.JButton();
        pnlTab3 = new javax.swing.JPanel();
        imgTab3 = new javax.swing.JLabel();
        nomeTab3 = new javax.swing.JLabel();
        descTab3 = new javax.swing.JLabel();
        precoTab3 = new javax.swing.JLabel();
        btnAlugarTab3 = new javax.swing.JRadioButton();
        btnDetalhesTab3 = new javax.swing.JButton();
        pnlTab4 = new javax.swing.JPanel();
        imgTab4 = new javax.swing.JLabel();
        nomeTab4 = new javax.swing.JLabel();
        descTab4 = new javax.swing.JLabel();
        precoTab4 = new javax.swing.JLabel();
        btnAlugarTab4 = new javax.swing.JRadioButton();
        btnDetalhesTab4 = new javax.swing.JButton();
        pnlTab5 = new javax.swing.JPanel();
        imgTab5 = new javax.swing.JLabel();
        nomeTab5 = new javax.swing.JLabel();
        descTab5 = new javax.swing.JLabel();
        precoTab5 = new javax.swing.JLabel();
        btnAlugarTab5 = new javax.swing.JRadioButton();
        btnDetalhesTab5 = new javax.swing.JButton();
        pnlTab6 = new javax.swing.JPanel();
        imgTab6 = new javax.swing.JLabel();
        nomeTab6 = new javax.swing.JLabel();
        descTab6 = new javax.swing.JLabel();
        precoTab6 = new javax.swing.JLabel();
        btnAlugarTab6 = new javax.swing.JRadioButton();
        btnDetalhesTab6 = new javax.swing.JButton();
        scrollVideogames = new javax.swing.JScrollPane();
        pnlVideogames = new javax.swing.JPanel();
        pnlVid1 = new javax.swing.JPanel();
        imgVid1 = new javax.swing.JLabel();
        nomeVid1 = new javax.swing.JLabel();
        descVid1 = new javax.swing.JLabel();
        precoVid1 = new javax.swing.JLabel();
        btnAlugarVid1 = new javax.swing.JRadioButton();
        btnDetalhesVid1 = new javax.swing.JButton();
        pnlVid2 = new javax.swing.JPanel();
        imgVid2 = new javax.swing.JLabel();
        nomeVid2 = new javax.swing.JLabel();
        descVid2 = new javax.swing.JLabel();
        precoVid2 = new javax.swing.JLabel();
        btnAlugarVid2 = new javax.swing.JRadioButton();
        btnDetalhesVid2 = new javax.swing.JButton();
        pnlVid3 = new javax.swing.JPanel();
        imgVid3 = new javax.swing.JLabel();
        nomeVid3 = new javax.swing.JLabel();
        descVid3 = new javax.swing.JLabel();
        precoVid3 = new javax.swing.JLabel();
        btnAlugarVid3 = new javax.swing.JRadioButton();
        btnDetalhesVid3 = new javax.swing.JButton();
        pnlVid4 = new javax.swing.JPanel();
        imgVid4 = new javax.swing.JLabel();
        nomeVid4 = new javax.swing.JLabel();
        descVid4 = new javax.swing.JLabel();
        precoVid4 = new javax.swing.JLabel();
        btnAlugarVid4 = new javax.swing.JRadioButton();
        btnDetalhesVid4 = new javax.swing.JButton();
        pnlVid5 = new javax.swing.JPanel();
        imgVid5 = new javax.swing.JLabel();
        nomeVid5 = new javax.swing.JLabel();
        descVid5 = new javax.swing.JLabel();
        precoVid5 = new javax.swing.JLabel();
        btnAlugarVid5 = new javax.swing.JRadioButton();
        btnDetalhesVid5 = new javax.swing.JButton();
        pnlVid6 = new javax.swing.JPanel();
        imgVid6 = new javax.swing.JLabel();
        nomeVid6 = new javax.swing.JLabel();
        descVid6 = new javax.swing.JLabel();
        precoVid6 = new javax.swing.JLabel();
        btnAlugarVid6 = new javax.swing.JRadioButton();
        btnDetalhesVid6 = new javax.swing.JButton();
        pnlVid7 = new javax.swing.JPanel();
        imgVid7 = new javax.swing.JLabel();
        nomeVid7 = new javax.swing.JLabel();
        descVid7 = new javax.swing.JLabel();
        precoVid7 = new javax.swing.JLabel();
        btnAlugarVid7 = new javax.swing.JRadioButton();
        btnDetalhesVid7 = new javax.swing.JButton();
        pnlVid8 = new javax.swing.JPanel();
        imgVid8 = new javax.swing.JLabel();
        nomeVid8 = new javax.swing.JLabel();
        descVid8 = new javax.swing.JLabel();
        precoVid8 = new javax.swing.JLabel();
        btnAlugarVid8 = new javax.swing.JRadioButton();
        btnDetalhesVid8 = new javax.swing.JButton();
        pnlVid9 = new javax.swing.JPanel();
        imgVid9 = new javax.swing.JLabel();
        nomeVid9 = new javax.swing.JLabel();
        descVid9 = new javax.swing.JLabel();
        precoVid9 = new javax.swing.JLabel();
        btnAlugarVid9 = new javax.swing.JRadioButton();
        btnDetalhesVid9 = new javax.swing.JButton();
        pnlVid10 = new javax.swing.JPanel();
        imgVid10 = new javax.swing.JLabel();
        nomeVid10 = new javax.swing.JLabel();
        descVid10 = new javax.swing.JLabel();
        precoVid10 = new javax.swing.JLabel();
        btnAlugarVid10 = new javax.swing.JRadioButton();
        btnDetalhesVid10 = new javax.swing.JButton();
        btnVoltarLoja = new javax.swing.JButton();
        btnFinalizarLoja = new javax.swing.JButton();
        btnAddCartLoja = new javax.swing.JButton();
        lblCartLoja = new javax.swing.JLabel();
        menuBarLoja = new javax.swing.JMenuBar();
        menuLoja = new javax.swing.JMenu();
        menuFinalizarLoja = new javax.swing.JMenuItem();
        menuVoltarLoja = new javax.swing.JMenuItem();
        separatorLoja = new javax.swing.JPopupMenu.Separator();
        menuSairLoja = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loja");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/boxLogo.png")).getImage());

        scrollFilmes.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnlMv1.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeMv1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeMv1.setText("-----");

        descMv1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descMv1.setText("-----");

        precoMv1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoMv1.setText("R$ --.--");

        btnAlugarMv1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarMv1.setText("-----");
        btnAlugarMv1.setEnabled(false);
        btnAlugarMv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarMv1ActionPerformed(evt);
            }
        });

        btnDetalhesMv1.setText("Detalhes");
        btnDetalhesMv1.setEnabled(false);
        btnDetalhesMv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesMv1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMv1Layout = new javax.swing.GroupLayout(pnlMv1);
        pnlMv1.setLayout(pnlMv1Layout);
        pnlMv1Layout.setHorizontalGroup(
            pnlMv1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMv1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMv1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMv1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descMv1)
                    .addComponent(nomeMv1)
                    .addComponent(precoMv1)
                    .addComponent(btnAlugarMv1)
                    .addComponent(btnDetalhesMv1))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlMv1Layout.setVerticalGroup(
            pnlMv1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMv1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlMv1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgMv1)
                    .addGroup(pnlMv1Layout.createSequentialGroup()
                        .addComponent(nomeMv1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descMv1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoMv1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarMv1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesMv1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMv2.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeMv2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeMv2.setText("-----");

        descMv2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descMv2.setText("-----");

        precoMv2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoMv2.setText("R$ --.--");

        btnAlugarMv2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarMv2.setText("-----");
        btnAlugarMv2.setEnabled(false);
        btnAlugarMv2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarMv2ActionPerformed(evt);
            }
        });

        btnDetalhesMv2.setText("Detalhes");
        btnDetalhesMv2.setEnabled(false);
        btnDetalhesMv2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesMv2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMv2Layout = new javax.swing.GroupLayout(pnlMv2);
        pnlMv2.setLayout(pnlMv2Layout);
        pnlMv2Layout.setHorizontalGroup(
            pnlMv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMv2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMv2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descMv2)
                    .addComponent(nomeMv2)
                    .addComponent(precoMv2)
                    .addComponent(btnAlugarMv2)
                    .addComponent(btnDetalhesMv2))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlMv2Layout.setVerticalGroup(
            pnlMv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMv2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlMv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgMv2)
                    .addGroup(pnlMv2Layout.createSequentialGroup()
                        .addComponent(nomeMv2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descMv2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoMv2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarMv2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesMv2)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlMv3.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeMv3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeMv3.setText("-----");

        descMv3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descMv3.setText("-----");

        precoMv3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoMv3.setText("R$ --.--");

        btnAlugarMv3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarMv3.setText("-----");
        btnAlugarMv3.setEnabled(false);
        btnAlugarMv3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarMv3ActionPerformed(evt);
            }
        });

        btnDetalhesMv3.setText("Detalhes");
        btnDetalhesMv3.setEnabled(false);
        btnDetalhesMv3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesMv3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMv3Layout = new javax.swing.GroupLayout(pnlMv3);
        pnlMv3.setLayout(pnlMv3Layout);
        pnlMv3Layout.setHorizontalGroup(
            pnlMv3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMv3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMv3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMv3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descMv3)
                    .addComponent(nomeMv3)
                    .addComponent(precoMv3)
                    .addComponent(btnAlugarMv3)
                    .addComponent(btnDetalhesMv3))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlMv3Layout.setVerticalGroup(
            pnlMv3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMv3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlMv3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgMv3)
                    .addGroup(pnlMv3Layout.createSequentialGroup()
                        .addComponent(nomeMv3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descMv3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoMv3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarMv3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesMv3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMv4.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeMv4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeMv4.setText("-----");

        descMv4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descMv4.setText("-----");

        precoMv4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoMv4.setText("R$ --.--");

        btnAlugarMv4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarMv4.setText("-----");
        btnAlugarMv4.setEnabled(false);
        btnAlugarMv4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarMv4ActionPerformed(evt);
            }
        });

        btnDetalhesMv4.setText("Detalhes");
        btnDetalhesMv4.setEnabled(false);
        btnDetalhesMv4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesMv4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMv4Layout = new javax.swing.GroupLayout(pnlMv4);
        pnlMv4.setLayout(pnlMv4Layout);
        pnlMv4Layout.setHorizontalGroup(
            pnlMv4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMv4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMv4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMv4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descMv4)
                    .addComponent(nomeMv4)
                    .addComponent(precoMv4)
                    .addComponent(btnAlugarMv4)
                    .addComponent(btnDetalhesMv4))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlMv4Layout.setVerticalGroup(
            pnlMv4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMv4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlMv4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgMv4)
                    .addGroup(pnlMv4Layout.createSequentialGroup()
                        .addComponent(nomeMv4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descMv4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoMv4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarMv4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesMv4)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlMv5.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeMv5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeMv5.setText("-----");

        descMv5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descMv5.setText("-----");

        precoMv5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoMv5.setText("R$ --.--");

        btnAlugarMv5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarMv5.setText("-----");
        btnAlugarMv5.setEnabled(false);
        btnAlugarMv5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarMv5ActionPerformed(evt);
            }
        });

        btnDetalhesMv5.setText("Detalhes");
        btnDetalhesMv5.setEnabled(false);
        btnDetalhesMv5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesMv5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMv5Layout = new javax.swing.GroupLayout(pnlMv5);
        pnlMv5.setLayout(pnlMv5Layout);
        pnlMv5Layout.setHorizontalGroup(
            pnlMv5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMv5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMv5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMv5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descMv5)
                    .addComponent(nomeMv5)
                    .addComponent(precoMv5)
                    .addComponent(btnAlugarMv5)
                    .addComponent(btnDetalhesMv5))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlMv5Layout.setVerticalGroup(
            pnlMv5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMv5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlMv5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgMv5)
                    .addGroup(pnlMv5Layout.createSequentialGroup()
                        .addComponent(nomeMv5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descMv5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoMv5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarMv5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesMv5)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlMv6.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeMv6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeMv6.setText("-----");

        descMv6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descMv6.setText("-----");

        precoMv6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoMv6.setText("R$ --.--");

        btnAlugarMv6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarMv6.setText("-----");
        btnAlugarMv6.setEnabled(false);
        btnAlugarMv6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarMv6ActionPerformed(evt);
            }
        });

        btnDetalhesMv6.setText("Detalhes");
        btnDetalhesMv6.setEnabled(false);
        btnDetalhesMv6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesMv6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMv6Layout = new javax.swing.GroupLayout(pnlMv6);
        pnlMv6.setLayout(pnlMv6Layout);
        pnlMv6Layout.setHorizontalGroup(
            pnlMv6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMv6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMv6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMv6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descMv6)
                    .addComponent(nomeMv6)
                    .addComponent(precoMv6)
                    .addComponent(btnAlugarMv6)
                    .addComponent(btnDetalhesMv6))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlMv6Layout.setVerticalGroup(
            pnlMv6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMv6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlMv6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgMv6)
                    .addGroup(pnlMv6Layout.createSequentialGroup()
                        .addComponent(nomeMv6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descMv6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoMv6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarMv6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesMv6)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlMv7.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeMv7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeMv7.setText("-----");

        descMv7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descMv7.setText("-----");

        precoMv7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoMv7.setText("R$ --.--");

        btnAlugarMv7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarMv7.setText("-----");
        btnAlugarMv7.setEnabled(false);
        btnAlugarMv7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarMv7ActionPerformed(evt);
            }
        });

        btnDetalhesMv7.setText("Detalhes");
        btnDetalhesMv7.setEnabled(false);
        btnDetalhesMv7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesMv7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMv7Layout = new javax.swing.GroupLayout(pnlMv7);
        pnlMv7.setLayout(pnlMv7Layout);
        pnlMv7Layout.setHorizontalGroup(
            pnlMv7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMv7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMv7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMv7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descMv7)
                    .addComponent(nomeMv7)
                    .addComponent(precoMv7)
                    .addComponent(btnAlugarMv7)
                    .addComponent(btnDetalhesMv7))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlMv7Layout.setVerticalGroup(
            pnlMv7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMv7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlMv7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgMv7)
                    .addGroup(pnlMv7Layout.createSequentialGroup()
                        .addComponent(nomeMv7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descMv7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoMv7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarMv7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesMv7)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlMv8.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeMv8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeMv8.setText("-----");

        descMv8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descMv8.setText("-----");

        precoMv8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoMv8.setText("R$ --.--");

        btnAlugarMv8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarMv8.setText("-----");
        btnAlugarMv8.setEnabled(false);
        btnAlugarMv8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarMv8ActionPerformed(evt);
            }
        });

        btnDetalhesMv8.setText("Detalhes");
        btnDetalhesMv8.setEnabled(false);
        btnDetalhesMv8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesMv8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMv8Layout = new javax.swing.GroupLayout(pnlMv8);
        pnlMv8.setLayout(pnlMv8Layout);
        pnlMv8Layout.setHorizontalGroup(
            pnlMv8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMv8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMv8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMv8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descMv8)
                    .addComponent(nomeMv8)
                    .addComponent(precoMv8)
                    .addComponent(btnAlugarMv8)
                    .addComponent(btnDetalhesMv8))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlMv8Layout.setVerticalGroup(
            pnlMv8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMv8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlMv8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgMv8)
                    .addGroup(pnlMv8Layout.createSequentialGroup()
                        .addComponent(nomeMv8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descMv8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoMv8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarMv8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesMv8)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlMv9.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeMv9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeMv9.setText("-----");

        descMv9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descMv9.setText("-----");

        precoMv9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoMv9.setText("R$ --.--");

        btnAlugarMv9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarMv9.setText("-----");
        btnAlugarMv9.setEnabled(false);
        btnAlugarMv9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarMv9ActionPerformed(evt);
            }
        });

        btnDetalhesMv9.setText("Detalhes");
        btnDetalhesMv9.setEnabled(false);
        btnDetalhesMv9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesMv9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMv9Layout = new javax.swing.GroupLayout(pnlMv9);
        pnlMv9.setLayout(pnlMv9Layout);
        pnlMv9Layout.setHorizontalGroup(
            pnlMv9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMv9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMv9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMv9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descMv9)
                    .addComponent(nomeMv9)
                    .addComponent(precoMv9)
                    .addComponent(btnAlugarMv9)
                    .addComponent(btnDetalhesMv9))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlMv9Layout.setVerticalGroup(
            pnlMv9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMv9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlMv9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgMv9)
                    .addGroup(pnlMv9Layout.createSequentialGroup()
                        .addComponent(nomeMv9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descMv9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoMv9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarMv9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesMv9)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlMv10.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeMv10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeMv10.setText("-----");

        descMv10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descMv10.setText("-----");

        precoMv10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoMv10.setText("R$ --,--");

        btnAlugarMv10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarMv10.setText("-----");
        btnAlugarMv10.setEnabled(false);
        btnAlugarMv10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarMv10ActionPerformed(evt);
            }
        });

        btnDetalhesMv10.setText("Detalhes");
        btnDetalhesMv10.setEnabled(false);
        btnDetalhesMv10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesMv10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMv10Layout = new javax.swing.GroupLayout(pnlMv10);
        pnlMv10.setLayout(pnlMv10Layout);
        pnlMv10Layout.setHorizontalGroup(
            pnlMv10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMv10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMv10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMv10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descMv10)
                    .addComponent(nomeMv10)
                    .addComponent(precoMv10)
                    .addComponent(btnAlugarMv10)
                    .addComponent(btnDetalhesMv10))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlMv10Layout.setVerticalGroup(
            pnlMv10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMv10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlMv10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgMv10)
                    .addGroup(pnlMv10Layout.createSequentialGroup()
                        .addComponent(nomeMv10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descMv10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoMv10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarMv10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesMv10)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlFilmesLayout = new javax.swing.GroupLayout(pnlFilmes);
        pnlFilmes.setLayout(pnlFilmesLayout);
        pnlFilmesLayout.setHorizontalGroup(
            pnlFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFilmesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFilmesLayout.createSequentialGroup()
                        .addComponent(pnlMv1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlMv2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFilmesLayout.createSequentialGroup()
                        .addComponent(pnlMv3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlMv4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFilmesLayout.createSequentialGroup()
                        .addComponent(pnlMv5, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlMv6, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFilmesLayout.createSequentialGroup()
                        .addComponent(pnlMv7, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlMv8, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFilmesLayout.createSequentialGroup()
                        .addComponent(pnlMv9, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlMv10, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlFilmesLayout.setVerticalGroup(
            pnlFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilmesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlMv1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(pnlMv2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlMv3, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(pnlMv4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlMv5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMv6, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMv7, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMv8, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlMv9, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMv10, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scrollFilmes.setViewportView(pnlFilmes);

        tabbedPnlLoja.addTab("Filmes", scrollFilmes);

        pnlMus1.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeMus1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeMus1.setText("-----");

        descMus1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descMus1.setText("-----");

        precoMus1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoMus1.setText("R$ --.--");
        precoMus1.setToolTipText("");

        btnAlugarMus1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarMus1.setText("-----");
        btnAlugarMus1.setEnabled(false);
        btnAlugarMus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarMus1ActionPerformed(evt);
            }
        });

        btnDetalhesMus1.setText("Detalhes");
        btnDetalhesMus1.setEnabled(false);
        btnDetalhesMus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesMus1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMus1Layout = new javax.swing.GroupLayout(pnlMus1);
        pnlMus1.setLayout(pnlMus1Layout);
        pnlMus1Layout.setHorizontalGroup(
            pnlMus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMus1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMus1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descMus1)
                    .addComponent(nomeMus1)
                    .addComponent(precoMus1)
                    .addComponent(btnAlugarMus1)
                    .addComponent(btnDetalhesMus1))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlMus1Layout.setVerticalGroup(
            pnlMus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMus1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlMus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgMus1)
                    .addGroup(pnlMus1Layout.createSequentialGroup()
                        .addComponent(nomeMus1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descMus1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoMus1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarMus1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesMus1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlMus2.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeMus2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeMus2.setText("-----");

        descMus2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descMus2.setText("-----");

        precoMus2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoMus2.setText("R$ --.--");

        btnAlugarMus2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarMus2.setText("-----");
        btnAlugarMus2.setEnabled(false);
        btnAlugarMus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarMus2ActionPerformed(evt);
            }
        });

        btnDetalhesMus2.setText("Detalhes");
        btnDetalhesMus2.setEnabled(false);
        btnDetalhesMus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesMus2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMus2Layout = new javax.swing.GroupLayout(pnlMus2);
        pnlMus2.setLayout(pnlMus2Layout);
        pnlMus2Layout.setHorizontalGroup(
            pnlMus2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMus2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMus2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMus2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descMus2)
                    .addComponent(nomeMus2)
                    .addComponent(precoMus2)
                    .addComponent(btnAlugarMus2)
                    .addComponent(btnDetalhesMus2))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlMus2Layout.setVerticalGroup(
            pnlMus2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMus2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlMus2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgMus2)
                    .addGroup(pnlMus2Layout.createSequentialGroup()
                        .addComponent(nomeMus2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descMus2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoMus2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarMus2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesMus2)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlMus3.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeMus3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeMus3.setText("-----");

        descMus3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descMus3.setText("-----");

        precoMus3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoMus3.setText("R$ --.--");

        btnAlugarMus3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarMus3.setText("-----");
        btnAlugarMus3.setEnabled(false);
        btnAlugarMus3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarMus3ActionPerformed(evt);
            }
        });

        btnDetalhesMus3.setText("Detalhes");
        btnDetalhesMus3.setEnabled(false);
        btnDetalhesMus3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesMus3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMus3Layout = new javax.swing.GroupLayout(pnlMus3);
        pnlMus3.setLayout(pnlMus3Layout);
        pnlMus3Layout.setHorizontalGroup(
            pnlMus3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMus3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMus3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMus3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descMus3)
                    .addComponent(nomeMus3)
                    .addComponent(precoMus3)
                    .addComponent(btnAlugarMus3)
                    .addComponent(btnDetalhesMus3))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlMus3Layout.setVerticalGroup(
            pnlMus3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMus3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlMus3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgMus3)
                    .addGroup(pnlMus3Layout.createSequentialGroup()
                        .addComponent(nomeMus3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descMus3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoMus3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarMus3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesMus3)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlMus4.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeMus4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeMus4.setText("-----");

        descMus4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descMus4.setText("-----");

        precoMus4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoMus4.setText("R$ --.--");

        btnAlugarMus4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarMus4.setText("-----");
        btnAlugarMus4.setEnabled(false);
        btnAlugarMus4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarMus4ActionPerformed(evt);
            }
        });

        btnDetalhesMus4.setText("Detalhes");
        btnDetalhesMus4.setEnabled(false);
        btnDetalhesMus4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesMus4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMus4Layout = new javax.swing.GroupLayout(pnlMus4);
        pnlMus4.setLayout(pnlMus4Layout);
        pnlMus4Layout.setHorizontalGroup(
            pnlMus4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMus4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMus4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMus4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descMus4)
                    .addComponent(nomeMus4)
                    .addComponent(precoMus4)
                    .addComponent(btnAlugarMus4)
                    .addComponent(btnDetalhesMus4))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlMus4Layout.setVerticalGroup(
            pnlMus4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMus4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlMus4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgMus4)
                    .addGroup(pnlMus4Layout.createSequentialGroup()
                        .addComponent(nomeMus4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descMus4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoMus4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarMus4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesMus4)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlMus5.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeMus5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeMus5.setText("-----");

        descMus5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descMus5.setText("-----");

        precoMus5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoMus5.setText("R$ --.--");

        btnAlugarMus5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarMus5.setText("-----");
        btnAlugarMus5.setEnabled(false);
        btnAlugarMus5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarMus5ActionPerformed(evt);
            }
        });

        btnDetalhesMus5.setText("Detalhes");
        btnDetalhesMus5.setEnabled(false);
        btnDetalhesMus5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesMus5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMus5Layout = new javax.swing.GroupLayout(pnlMus5);
        pnlMus5.setLayout(pnlMus5Layout);
        pnlMus5Layout.setHorizontalGroup(
            pnlMus5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMus5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMus5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMus5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descMus5)
                    .addComponent(nomeMus5)
                    .addComponent(precoMus5)
                    .addComponent(btnAlugarMus5)
                    .addComponent(btnDetalhesMus5))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlMus5Layout.setVerticalGroup(
            pnlMus5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMus5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlMus5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgMus5)
                    .addGroup(pnlMus5Layout.createSequentialGroup()
                        .addComponent(nomeMus5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descMus5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoMus5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarMus5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesMus5)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlMus6.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeMus6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeMus6.setText("-----");

        descMus6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descMus6.setText("-----");

        precoMus6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoMus6.setText("R$ --.--");

        btnAlugarMus6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarMus6.setText("-----");
        btnAlugarMus6.setEnabled(false);
        btnAlugarMus6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarMus6ActionPerformed(evt);
            }
        });

        btnDetalhesMus6.setText("Detalhes");
        btnDetalhesMus6.setEnabled(false);
        btnDetalhesMus6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesMus6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMus6Layout = new javax.swing.GroupLayout(pnlMus6);
        pnlMus6.setLayout(pnlMus6Layout);
        pnlMus6Layout.setHorizontalGroup(
            pnlMus6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMus6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMus6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMus6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descMus6)
                    .addComponent(nomeMus6)
                    .addComponent(precoMus6)
                    .addComponent(btnAlugarMus6)
                    .addComponent(btnDetalhesMus6))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlMus6Layout.setVerticalGroup(
            pnlMus6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMus6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlMus6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgMus6)
                    .addGroup(pnlMus6Layout.createSequentialGroup()
                        .addComponent(nomeMus6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descMus6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoMus6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarMus6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesMus6)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlMus7.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeMus7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeMus7.setText("-----");

        descMus7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descMus7.setText("-----");

        precoMus7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoMus7.setText("R$ --.--");

        btnAlugarMus7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarMus7.setText("-----");
        btnAlugarMus7.setEnabled(false);
        btnAlugarMus7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarMus7ActionPerformed(evt);
            }
        });

        btnDetalhesMus7.setText("Detalhes");
        btnDetalhesMus7.setEnabled(false);
        btnDetalhesMus7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesMus7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMus7Layout = new javax.swing.GroupLayout(pnlMus7);
        pnlMus7.setLayout(pnlMus7Layout);
        pnlMus7Layout.setHorizontalGroup(
            pnlMus7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMus7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMus7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMus7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descMus7)
                    .addComponent(nomeMus7)
                    .addComponent(precoMus7)
                    .addComponent(btnAlugarMus7)
                    .addComponent(btnDetalhesMus7))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlMus7Layout.setVerticalGroup(
            pnlMus7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMus7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlMus7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgMus7)
                    .addGroup(pnlMus7Layout.createSequentialGroup()
                        .addComponent(nomeMus7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descMus7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoMus7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarMus7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesMus7)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlMus8.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeMus8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeMus8.setText("-----");

        descMus8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descMus8.setText("-----");

        precoMus8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoMus8.setText("R$ --.--");

        btnAlugarMus8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarMus8.setText("-----");
        btnAlugarMus8.setEnabled(false);
        btnAlugarMus8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarMus8ActionPerformed(evt);
            }
        });

        btnDetalhesMus8.setText("Detalhes");
        btnDetalhesMus8.setEnabled(false);
        btnDetalhesMus8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesMus8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMus8Layout = new javax.swing.GroupLayout(pnlMus8);
        pnlMus8.setLayout(pnlMus8Layout);
        pnlMus8Layout.setHorizontalGroup(
            pnlMus8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMus8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMus8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMus8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descMus8)
                    .addComponent(nomeMus8)
                    .addComponent(precoMus8)
                    .addComponent(btnAlugarMus8)
                    .addComponent(btnDetalhesMus8))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlMus8Layout.setVerticalGroup(
            pnlMus8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMus8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlMus8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgMus8)
                    .addGroup(pnlMus8Layout.createSequentialGroup()
                        .addComponent(nomeMus8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descMus8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoMus8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarMus8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesMus8)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlMus9.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeMus9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeMus9.setText("-----");
        nomeMus9.setToolTipText("");

        descMus9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descMus9.setText("-----");

        precoMus9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoMus9.setText("R$ --.--");

        btnAlugarMus9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarMus9.setText("-----");
        btnAlugarMus9.setEnabled(false);
        btnAlugarMus9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarMus9ActionPerformed(evt);
            }
        });

        btnDetalhesMus9.setText("Detalhes");
        btnDetalhesMus9.setEnabled(false);
        btnDetalhesMus9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesMus9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMus9Layout = new javax.swing.GroupLayout(pnlMus9);
        pnlMus9.setLayout(pnlMus9Layout);
        pnlMus9Layout.setHorizontalGroup(
            pnlMus9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMus9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMus9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMus9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descMus9)
                    .addComponent(nomeMus9)
                    .addComponent(precoMus9)
                    .addComponent(btnAlugarMus9)
                    .addComponent(btnDetalhesMus9))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlMus9Layout.setVerticalGroup(
            pnlMus9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMus9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlMus9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgMus9)
                    .addGroup(pnlMus9Layout.createSequentialGroup()
                        .addComponent(nomeMus9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descMus9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoMus9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarMus9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesMus9)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlMus10.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeMus10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeMus10.setText("-----");

        descMus10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descMus10.setText("-----");

        precoMus10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoMus10.setText("R$ --.--");

        btnAlugarMus10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarMus10.setText("-----");
        btnAlugarMus10.setEnabled(false);
        btnAlugarMus10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarMus10ActionPerformed(evt);
            }
        });

        btnDetalhesMus10.setText("Detalhes");
        btnDetalhesMus10.setEnabled(false);
        btnDetalhesMus10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesMus10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMus10Layout = new javax.swing.GroupLayout(pnlMus10);
        pnlMus10.setLayout(pnlMus10Layout);
        pnlMus10Layout.setHorizontalGroup(
            pnlMus10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMus10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgMus10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMus10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descMus10)
                    .addComponent(nomeMus10)
                    .addComponent(precoMus10)
                    .addComponent(btnAlugarMus10)
                    .addComponent(btnDetalhesMus10))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlMus10Layout.setVerticalGroup(
            pnlMus10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMus10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlMus10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgMus10)
                    .addGroup(pnlMus10Layout.createSequentialGroup()
                        .addComponent(nomeMus10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descMus10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoMus10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarMus10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesMus10)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlMusicasLayout = new javax.swing.GroupLayout(pnlMusicas);
        pnlMusicas.setLayout(pnlMusicasLayout);
        pnlMusicasLayout.setHorizontalGroup(
            pnlMusicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMusicasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMusicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMusicasLayout.createSequentialGroup()
                        .addComponent(pnlMus1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(pnlMus2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMusicasLayout.createSequentialGroup()
                        .addComponent(pnlMus3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlMus4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMusicasLayout.createSequentialGroup()
                        .addComponent(pnlMus5, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlMus6, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMusicasLayout.createSequentialGroup()
                        .addComponent(pnlMus7, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlMus8, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMusicasLayout.createSequentialGroup()
                        .addComponent(pnlMus9, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlMus10, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlMusicasLayout.setVerticalGroup(
            pnlMusicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMusicasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMusicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlMus2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMus1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlMusicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlMus3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMus4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlMusicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlMus5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMus6, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlMusicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMus7, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMus8, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(pnlMusicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMus9, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMus10, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        scrollMusicas.setViewportView(pnlMusicas);

        tabbedPnlLoja.addTab("Músicas", scrollMusicas);

        pnlTab1.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeTab1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeTab1.setText("-----");

        descTab1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descTab1.setText("-----");

        precoTab1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoTab1.setText("R$ --.--");

        btnAlugarTab1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarTab1.setText("-----");
        btnAlugarTab1.setEnabled(false);
        btnAlugarTab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarTab1ActionPerformed(evt);
            }
        });

        btnDetalhesTab1.setText("Detalhes");
        btnDetalhesTab1.setEnabled(false);
        btnDetalhesTab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesTab1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTab1Layout = new javax.swing.GroupLayout(pnlTab1);
        pnlTab1.setLayout(pnlTab1Layout);
        pnlTab1Layout.setHorizontalGroup(
            pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTab1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgTab1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descTab1)
                    .addComponent(nomeTab1)
                    .addComponent(precoTab1)
                    .addComponent(btnAlugarTab1)
                    .addComponent(btnDetalhesTab1))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlTab1Layout.setVerticalGroup(
            pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTab1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgTab1)
                    .addGroup(pnlTab1Layout.createSequentialGroup()
                        .addComponent(nomeTab1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descTab1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoTab1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarTab1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesTab1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlTab2.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeTab2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeTab2.setText("-----");

        descTab2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descTab2.setText("-----");

        precoTab2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoTab2.setText("R$ --.--");

        btnAlugarTab2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarTab2.setText("-----");
        btnAlugarTab2.setEnabled(false);
        btnAlugarTab2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarTab2ActionPerformed(evt);
            }
        });

        btnDetalhesTab2.setText("Detalhes");
        btnDetalhesTab2.setEnabled(false);
        btnDetalhesTab2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesTab2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTab2Layout = new javax.swing.GroupLayout(pnlTab2);
        pnlTab2.setLayout(pnlTab2Layout);
        pnlTab2Layout.setHorizontalGroup(
            pnlTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTab2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgTab2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descTab2)
                    .addComponent(nomeTab2)
                    .addComponent(precoTab2)
                    .addComponent(btnAlugarTab2)
                    .addComponent(btnDetalhesTab2))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlTab2Layout.setVerticalGroup(
            pnlTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTab2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgTab2)
                    .addGroup(pnlTab2Layout.createSequentialGroup()
                        .addComponent(nomeTab2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descTab2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoTab2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarTab2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesTab2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTab3.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeTab3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeTab3.setText("-----");

        descTab3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descTab3.setText("-----");

        precoTab3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoTab3.setText("R$ --.--");

        btnAlugarTab3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarTab3.setText("-----");
        btnAlugarTab3.setEnabled(false);
        btnAlugarTab3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarTab3ActionPerformed(evt);
            }
        });

        btnDetalhesTab3.setText("Detalhes");
        btnDetalhesTab3.setEnabled(false);
        btnDetalhesTab3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesTab3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTab3Layout = new javax.swing.GroupLayout(pnlTab3);
        pnlTab3.setLayout(pnlTab3Layout);
        pnlTab3Layout.setHorizontalGroup(
            pnlTab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTab3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgTab3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descTab3)
                    .addComponent(nomeTab3)
                    .addComponent(precoTab3)
                    .addComponent(btnAlugarTab3)
                    .addComponent(btnDetalhesTab3))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlTab3Layout.setVerticalGroup(
            pnlTab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTab3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlTab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgTab3)
                    .addGroup(pnlTab3Layout.createSequentialGroup()
                        .addComponent(nomeTab3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descTab3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoTab3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarTab3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesTab3)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlTab4.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeTab4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeTab4.setText("-----");

        descTab4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descTab4.setText("-----");

        precoTab4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoTab4.setText("R$ --.--");

        btnAlugarTab4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarTab4.setText("-----");
        btnAlugarTab4.setEnabled(false);
        btnAlugarTab4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarTab4ActionPerformed(evt);
            }
        });

        btnDetalhesTab4.setText("Detalhes");
        btnDetalhesTab4.setEnabled(false);
        btnDetalhesTab4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesTab4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTab4Layout = new javax.swing.GroupLayout(pnlTab4);
        pnlTab4.setLayout(pnlTab4Layout);
        pnlTab4Layout.setHorizontalGroup(
            pnlTab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTab4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgTab4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descTab4)
                    .addComponent(nomeTab4)
                    .addComponent(precoTab4)
                    .addComponent(btnAlugarTab4)
                    .addComponent(btnDetalhesTab4))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlTab4Layout.setVerticalGroup(
            pnlTab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTab4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlTab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgTab4)
                    .addGroup(pnlTab4Layout.createSequentialGroup()
                        .addComponent(nomeTab4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descTab4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoTab4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarTab4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesTab4)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlTab5.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeTab5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeTab5.setText("-----");

        descTab5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descTab5.setText("-----");

        precoTab5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoTab5.setText("R$ --.--");

        btnAlugarTab5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarTab5.setText("-----");
        btnAlugarTab5.setEnabled(false);
        btnAlugarTab5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarTab5ActionPerformed(evt);
            }
        });

        btnDetalhesTab5.setText("Detalhes");
        btnDetalhesTab5.setEnabled(false);
        btnDetalhesTab5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesTab5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTab5Layout = new javax.swing.GroupLayout(pnlTab5);
        pnlTab5.setLayout(pnlTab5Layout);
        pnlTab5Layout.setHorizontalGroup(
            pnlTab5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTab5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgTab5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTab5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descTab5)
                    .addComponent(nomeTab5)
                    .addComponent(precoTab5)
                    .addComponent(btnAlugarTab5)
                    .addComponent(btnDetalhesTab5))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlTab5Layout.setVerticalGroup(
            pnlTab5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTab5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlTab5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgTab5)
                    .addGroup(pnlTab5Layout.createSequentialGroup()
                        .addComponent(nomeTab5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descTab5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoTab5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarTab5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesTab5)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlTab6.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeTab6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeTab6.setText("-----");

        descTab6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descTab6.setText("-----");

        precoTab6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoTab6.setText("R$ --,--");

        btnAlugarTab6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarTab6.setText("-----");
        btnAlugarTab6.setEnabled(false);
        btnAlugarTab6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarTab6ActionPerformed(evt);
            }
        });

        btnDetalhesTab6.setText("Detalhes");
        btnDetalhesTab6.setEnabled(false);
        btnDetalhesTab6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesTab6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTab6Layout = new javax.swing.GroupLayout(pnlTab6);
        pnlTab6.setLayout(pnlTab6Layout);
        pnlTab6Layout.setHorizontalGroup(
            pnlTab6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTab6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgTab6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTab6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descTab6)
                    .addComponent(nomeTab6)
                    .addComponent(precoTab6)
                    .addComponent(btnAlugarTab6)
                    .addComponent(btnDetalhesTab6))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlTab6Layout.setVerticalGroup(
            pnlTab6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTab6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlTab6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgTab6)
                    .addGroup(pnlTab6Layout.createSequentialGroup()
                        .addComponent(nomeTab6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descTab6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoTab6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarTab6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesTab6)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlTabuleirosLayout = new javax.swing.GroupLayout(pnlTabuleiros);
        pnlTabuleiros.setLayout(pnlTabuleirosLayout);
        pnlTabuleirosLayout.setHorizontalGroup(
            pnlTabuleirosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabuleirosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTabuleirosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTabuleirosLayout.createSequentialGroup()
                        .addGroup(pnlTabuleirosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTabuleirosLayout.createSequentialGroup()
                                .addComponent(pnlTab1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnlTab2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlTabuleirosLayout.createSequentialGroup()
                                .addComponent(pnlTab3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnlTab4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlTabuleirosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnlTab5, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlTab6, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        pnlTabuleirosLayout.setVerticalGroup(
            pnlTabuleirosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabuleirosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTabuleirosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlTab1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(pnlTab2, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlTabuleirosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTab3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlTab4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTabuleirosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTab5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlTab6, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        scrollTabuleiros.setViewportView(pnlTabuleiros);

        tabbedPnlLoja.addTab("Jogos de Mesa", scrollTabuleiros);

        scrollVideogames.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnlVid1.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeVid1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeVid1.setText("-----");

        descVid1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descVid1.setText("-----");

        precoVid1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoVid1.setText("R$ --.--");

        btnAlugarVid1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarVid1.setText("-----");
        btnAlugarVid1.setEnabled(false);
        btnAlugarVid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarVid1ActionPerformed(evt);
            }
        });

        btnDetalhesVid1.setText("Detalhes");
        btnDetalhesVid1.setEnabled(false);
        btnDetalhesVid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesVid1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVid1Layout = new javax.swing.GroupLayout(pnlVid1);
        pnlVid1.setLayout(pnlVid1Layout);
        pnlVid1Layout.setHorizontalGroup(
            pnlVid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVid1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgVid1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descVid1)
                    .addComponent(nomeVid1)
                    .addComponent(precoVid1)
                    .addComponent(btnAlugarVid1)
                    .addComponent(btnDetalhesVid1))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlVid1Layout.setVerticalGroup(
            pnlVid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVid1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlVid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgVid1)
                    .addGroup(pnlVid1Layout.createSequentialGroup()
                        .addComponent(nomeVid1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descVid1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoVid1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarVid1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesVid1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlVid2.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeVid2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeVid2.setText("-----");

        descVid2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descVid2.setText("-----");

        precoVid2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoVid2.setText("R$ --.--");

        btnAlugarVid2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarVid2.setText("-----");
        btnAlugarVid2.setEnabled(false);
        btnAlugarVid2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarVid2ActionPerformed(evt);
            }
        });

        btnDetalhesVid2.setText("Detalhes");
        btnDetalhesVid2.setEnabled(false);
        btnDetalhesVid2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesVid2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVid2Layout = new javax.swing.GroupLayout(pnlVid2);
        pnlVid2.setLayout(pnlVid2Layout);
        pnlVid2Layout.setHorizontalGroup(
            pnlVid2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVid2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgVid2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVid2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descVid2)
                    .addComponent(nomeVid2)
                    .addComponent(precoVid2)
                    .addComponent(btnAlugarVid2)
                    .addComponent(btnDetalhesVid2))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlVid2Layout.setVerticalGroup(
            pnlVid2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVid2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlVid2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgVid2)
                    .addGroup(pnlVid2Layout.createSequentialGroup()
                        .addComponent(nomeVid2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descVid2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoVid2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarVid2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesVid2)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlVid3.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeVid3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeVid3.setText("-----");

        descVid3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descVid3.setText("-----");

        precoVid3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoVid3.setText("R$ --.--");

        btnAlugarVid3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarVid3.setText("-----");
        btnAlugarVid3.setEnabled(false);
        btnAlugarVid3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarVid3ActionPerformed(evt);
            }
        });

        btnDetalhesVid3.setText("Detalhes");
        btnDetalhesVid3.setEnabled(false);
        btnDetalhesVid3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesVid3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVid3Layout = new javax.swing.GroupLayout(pnlVid3);
        pnlVid3.setLayout(pnlVid3Layout);
        pnlVid3Layout.setHorizontalGroup(
            pnlVid3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVid3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgVid3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVid3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descVid3)
                    .addComponent(nomeVid3)
                    .addComponent(precoVid3)
                    .addComponent(btnAlugarVid3)
                    .addComponent(btnDetalhesVid3))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlVid3Layout.setVerticalGroup(
            pnlVid3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVid3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlVid3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgVid3)
                    .addGroup(pnlVid3Layout.createSequentialGroup()
                        .addComponent(nomeVid3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descVid3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoVid3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarVid3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesVid3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlVid4.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeVid4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeVid4.setText("-----");

        descVid4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descVid4.setText("-----");

        precoVid4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoVid4.setText("R$ --.--");

        btnAlugarVid4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarVid4.setText("-----");
        btnAlugarVid4.setEnabled(false);
        btnAlugarVid4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarVid4ActionPerformed(evt);
            }
        });

        btnDetalhesVid4.setText("Detalhes");
        btnDetalhesVid4.setEnabled(false);
        btnDetalhesVid4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesVid4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVid4Layout = new javax.swing.GroupLayout(pnlVid4);
        pnlVid4.setLayout(pnlVid4Layout);
        pnlVid4Layout.setHorizontalGroup(
            pnlVid4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVid4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgVid4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVid4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descVid4)
                    .addComponent(nomeVid4)
                    .addComponent(precoVid4)
                    .addComponent(btnAlugarVid4)
                    .addComponent(btnDetalhesVid4))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlVid4Layout.setVerticalGroup(
            pnlVid4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVid4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlVid4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgVid4)
                    .addGroup(pnlVid4Layout.createSequentialGroup()
                        .addComponent(nomeVid4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descVid4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoVid4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarVid4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesVid4)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlVid5.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeVid5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeVid5.setText("-----");

        descVid5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descVid5.setText("-----");

        precoVid5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoVid5.setText("R$ --.--");

        btnAlugarVid5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarVid5.setText("-----");
        btnAlugarVid5.setEnabled(false);
        btnAlugarVid5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarVid5ActionPerformed(evt);
            }
        });

        btnDetalhesVid5.setText("Detalhes");
        btnDetalhesVid5.setEnabled(false);
        btnDetalhesVid5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesVid5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVid5Layout = new javax.swing.GroupLayout(pnlVid5);
        pnlVid5.setLayout(pnlVid5Layout);
        pnlVid5Layout.setHorizontalGroup(
            pnlVid5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVid5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgVid5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVid5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descVid5)
                    .addComponent(nomeVid5)
                    .addComponent(precoVid5)
                    .addComponent(btnAlugarVid5)
                    .addComponent(btnDetalhesVid5))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlVid5Layout.setVerticalGroup(
            pnlVid5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVid5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlVid5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgVid5)
                    .addGroup(pnlVid5Layout.createSequentialGroup()
                        .addComponent(nomeVid5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descVid5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoVid5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarVid5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesVid5)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlVid6.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeVid6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeVid6.setText("-----");

        descVid6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descVid6.setText("-----");

        precoVid6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoVid6.setText("R$ --.--");

        btnAlugarVid6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarVid6.setText("-----");
        btnAlugarVid6.setEnabled(false);
        btnAlugarVid6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarVid6ActionPerformed(evt);
            }
        });

        btnDetalhesVid6.setText("Detalhes");
        btnDetalhesVid6.setEnabled(false);
        btnDetalhesVid6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesVid6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVid6Layout = new javax.swing.GroupLayout(pnlVid6);
        pnlVid6.setLayout(pnlVid6Layout);
        pnlVid6Layout.setHorizontalGroup(
            pnlVid6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVid6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgVid6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVid6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descVid6)
                    .addComponent(nomeVid6)
                    .addComponent(precoVid6)
                    .addComponent(btnAlugarVid6)
                    .addComponent(btnDetalhesVid6))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlVid6Layout.setVerticalGroup(
            pnlVid6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVid6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlVid6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgVid6)
                    .addGroup(pnlVid6Layout.createSequentialGroup()
                        .addComponent(nomeVid6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descVid6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoVid6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarVid6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesVid6)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlVid7.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeVid7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeVid7.setText("-----");

        descVid7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descVid7.setText("-----");

        precoVid7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoVid7.setText("R$ --.--");

        btnAlugarVid7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarVid7.setText("-----");
        btnAlugarVid7.setEnabled(false);
        btnAlugarVid7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarVid7ActionPerformed(evt);
            }
        });

        btnDetalhesVid7.setText("Detalhes");
        btnDetalhesVid7.setEnabled(false);
        btnDetalhesVid7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesVid7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVid7Layout = new javax.swing.GroupLayout(pnlVid7);
        pnlVid7.setLayout(pnlVid7Layout);
        pnlVid7Layout.setHorizontalGroup(
            pnlVid7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVid7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgVid7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVid7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descVid7)
                    .addComponent(nomeVid7)
                    .addComponent(precoVid7)
                    .addComponent(btnAlugarVid7)
                    .addComponent(btnDetalhesVid7))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlVid7Layout.setVerticalGroup(
            pnlVid7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVid7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlVid7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgVid7)
                    .addGroup(pnlVid7Layout.createSequentialGroup()
                        .addComponent(nomeVid7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descVid7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoVid7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarVid7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesVid7)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlVid8.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeVid8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeVid8.setText("-----");

        descVid8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descVid8.setText("-----");

        precoVid8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoVid8.setText("R$ --.--");

        btnAlugarVid8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarVid8.setText("-----");
        btnAlugarVid8.setEnabled(false);
        btnAlugarVid8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarVid8ActionPerformed(evt);
            }
        });

        btnDetalhesVid8.setText("Detalhes");
        btnDetalhesVid8.setEnabled(false);
        btnDetalhesVid8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesVid8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVid8Layout = new javax.swing.GroupLayout(pnlVid8);
        pnlVid8.setLayout(pnlVid8Layout);
        pnlVid8Layout.setHorizontalGroup(
            pnlVid8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVid8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgVid8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVid8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descVid8)
                    .addComponent(nomeVid8)
                    .addComponent(precoVid8)
                    .addComponent(btnAlugarVid8)
                    .addComponent(btnDetalhesVid8))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlVid8Layout.setVerticalGroup(
            pnlVid8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVid8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlVid8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgVid8)
                    .addGroup(pnlVid8Layout.createSequentialGroup()
                        .addComponent(nomeVid8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descVid8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoVid8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarVid8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesVid8)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlVid9.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeVid9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeVid9.setText("-----");

        descVid9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descVid9.setText("-----");

        precoVid9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoVid9.setText("R$ --.--");

        btnAlugarVid9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarVid9.setText("-----");
        btnAlugarVid9.setEnabled(false);
        btnAlugarVid9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarVid9ActionPerformed(evt);
            }
        });

        btnDetalhesVid9.setText("Detalhes");
        btnDetalhesVid9.setEnabled(false);
        btnDetalhesVid9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesVid9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVid9Layout = new javax.swing.GroupLayout(pnlVid9);
        pnlVid9.setLayout(pnlVid9Layout);
        pnlVid9Layout.setHorizontalGroup(
            pnlVid9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVid9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgVid9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVid9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descVid9)
                    .addComponent(nomeVid9)
                    .addComponent(precoVid9)
                    .addComponent(btnAlugarVid9)
                    .addComponent(btnDetalhesVid9))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlVid9Layout.setVerticalGroup(
            pnlVid9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVid9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlVid9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgVid9)
                    .addGroup(pnlVid9Layout.createSequentialGroup()
                        .addComponent(nomeVid9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descVid9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoVid9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarVid9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesVid9)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlVid10.setPreferredSize(new java.awt.Dimension(190, 190));

        nomeVid10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeVid10.setText("-----");

        descVid10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descVid10.setText("-----");

        precoVid10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoVid10.setText("R$ --.--");

        btnAlugarVid10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlugarVid10.setText("-----");
        btnAlugarVid10.setEnabled(false);
        btnAlugarVid10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarVid10ActionPerformed(evt);
            }
        });

        btnDetalhesVid10.setText("Detalhes");
        btnDetalhesVid10.setEnabled(false);
        btnDetalhesVid10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesVid10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVid10Layout = new javax.swing.GroupLayout(pnlVid10);
        pnlVid10.setLayout(pnlVid10Layout);
        pnlVid10Layout.setHorizontalGroup(
            pnlVid10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVid10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgVid10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVid10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descVid10)
                    .addComponent(nomeVid10)
                    .addComponent(precoVid10)
                    .addComponent(btnAlugarVid10)
                    .addComponent(btnDetalhesVid10))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        pnlVid10Layout.setVerticalGroup(
            pnlVid10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVid10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlVid10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgVid10)
                    .addGroup(pnlVid10Layout.createSequentialGroup()
                        .addComponent(nomeVid10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descVid10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoVid10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarVid10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesVid10)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlVideogamesLayout = new javax.swing.GroupLayout(pnlVideogames);
        pnlVideogames.setLayout(pnlVideogamesLayout);
        pnlVideogamesLayout.setHorizontalGroup(
            pnlVideogamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVideogamesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlVideogamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlVideogamesLayout.createSequentialGroup()
                        .addComponent(pnlVid1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlVid2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlVideogamesLayout.createSequentialGroup()
                        .addComponent(pnlVid3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlVid4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlVideogamesLayout.createSequentialGroup()
                        .addComponent(pnlVid5, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlVid6, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlVideogamesLayout.createSequentialGroup()
                        .addComponent(pnlVid7, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlVid8, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlVideogamesLayout.createSequentialGroup()
                        .addComponent(pnlVid9, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlVid10, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlVideogamesLayout.setVerticalGroup(
            pnlVideogamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVideogamesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlVideogamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlVid1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(pnlVid2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlVideogamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlVid3, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(pnlVid4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlVideogamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlVid5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlVid6, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlVideogamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlVid7, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlVid8, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlVideogamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlVid9, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlVid10, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scrollVideogames.setViewportView(pnlVideogames);

        tabbedPnlLoja.addTab("Videogames", scrollVideogames);

        btnVoltarLoja.setText("Voltar");
        btnVoltarLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarLojaActionPerformed(evt);
            }
        });

        btnFinalizarLoja.setText("Finalizar pedido");
        btnFinalizarLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarLojaActionPerformed(evt);
            }
        });

        btnAddCartLoja.setText("Atualizar carrinho");
        btnAddCartLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCartLojaActionPerformed(evt);
            }
        });

        lblCartLoja.setText("Carrinho: 0 itens - R$ 0,00");

        javax.swing.GroupLayout pnlLojaLayout = new javax.swing.GroupLayout(pnlLoja);
        pnlLoja.setLayout(pnlLojaLayout);
        pnlLojaLayout.setHorizontalGroup(
            pnlLojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPnlLoja)
            .addGroup(pnlLojaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVoltarLoja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddCartLoja)
                .addGap(18, 18, 18)
                .addComponent(lblCartLoja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFinalizarLoja)
                .addContainerGap())
        );
        pnlLojaLayout.setVerticalGroup(
            pnlLojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLojaLayout.createSequentialGroup()
                .addComponent(tabbedPnlLoja, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlLojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltarLoja)
                    .addComponent(btnFinalizarLoja)
                    .addComponent(btnAddCartLoja)
                    .addComponent(lblCartLoja))
                .addContainerGap())
        );

        menuLoja.setText("Menu");

        menuFinalizarLoja.setText("Finalizar pedido");
        menuFinalizarLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFinalizarLojaActionPerformed(evt);
            }
        });
        menuLoja.add(menuFinalizarLoja);

        menuVoltarLoja.setText("Voltar");
        menuVoltarLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVoltarLojaActionPerformed(evt);
            }
        });
        menuLoja.add(menuVoltarLoja);
        menuLoja.add(separatorLoja);

        menuSairLoja.setText("Sair");
        menuSairLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairLojaActionPerformed(evt);
            }
        });
        menuLoja.add(menuSairLoja);

        menuBarLoja.add(menuLoja);

        setJMenuBar(menuBarLoja);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlLoja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlLoja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // cada botão de Detalhes tem sua mensagem definida no SetLoja() //
    // cada radio button chama a função addItemToTemp() com seus parâmetros ao ser modificado //
    
    private void menuVoltarLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVoltarLojaActionPerformed
        tempPedido = new ArrayList<>();
        finalPedido = new ArrayList<>();
        valorTotal = 0;
        
        new TelaPrincipal().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menuVoltarLojaActionPerformed

    private void menuFinalizarLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFinalizarLojaActionPerformed
        if(!tempBtnSelected.isEmpty()){
            JOptionPane.showMessageDialog(null, "Você ainda possui produtos selecionados!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
        } else {
            new FinalizarPedido().setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_menuFinalizarLojaActionPerformed

    private void btnDetalhesMv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesMv1ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesMv[0]);
    }//GEN-LAST:event_btnDetalhesMv1ActionPerformed

    // botão de finalizar avisa se o usuário não deicidiu a ação para algum produto
    private void btnVoltarLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarLojaActionPerformed
        tempPedido = new ArrayList<>();
        finalPedido = new ArrayList<>();
        valorTotal = 0;
        
        new TelaPrincipal().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarLojaActionPerformed
    
    private void btnDetalhesMv2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesMv2ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesMv[1]);
    }//GEN-LAST:event_btnDetalhesMv2ActionPerformed

    private void btnDetalhesMv3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesMv3ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesMv[2]);
    }//GEN-LAST:event_btnDetalhesMv3ActionPerformed

    private void btnDetalhesMv4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesMv4ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesMv[3]);
    }//GEN-LAST:event_btnDetalhesMv4ActionPerformed

    private void btnDetalhesMv5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesMv5ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesMv[4]);
    }//GEN-LAST:event_btnDetalhesMv5ActionPerformed

    private void btnDetalhesMv6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesMv6ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesMv[5]);
    }//GEN-LAST:event_btnDetalhesMv6ActionPerformed

    private void menuSairLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairLojaActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSairLojaActionPerformed

    // botão de finalizar avisa se o usuário não deicidiu a ação para algum produto
    private void btnFinalizarLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarLojaActionPerformed
        if(!tempBtnSelected.isEmpty()){
            JOptionPane.showMessageDialog(null, "Você ainda possui produtos selecionados!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
        } else {
            new FinalizarPedido().setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnFinalizarLojaActionPerformed

    private void btnDetalhesMv7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesMv7ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesMv[6]);
    }//GEN-LAST:event_btnDetalhesMv7ActionPerformed

    private void btnDetalhesMv8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesMv8ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesMv[7]);
    }//GEN-LAST:event_btnDetalhesMv8ActionPerformed

    private void btnDetalhesMv9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesMv9ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesMv[8]);
    }//GEN-LAST:event_btnDetalhesMv9ActionPerformed

    private void btnDetalhesMv10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesMv10ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesMv[9]);
    }//GEN-LAST:event_btnDetalhesMv10ActionPerformed

    private void btnDetalhesTab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesTab1ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesTab[0]);
    }//GEN-LAST:event_btnDetalhesTab1ActionPerformed

    private void btnDetalhesTab2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesTab2ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesTab[1]);
    }//GEN-LAST:event_btnDetalhesTab2ActionPerformed

    private void btnDetalhesTab3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesTab3ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesTab[2]);
    }//GEN-LAST:event_btnDetalhesTab3ActionPerformed

    private void btnDetalhesTab4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesTab4ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesTab[3]);
    }//GEN-LAST:event_btnDetalhesTab4ActionPerformed

    private void btnDetalhesTab5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesTab5ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesTab[4]);
    }//GEN-LAST:event_btnDetalhesTab5ActionPerformed

    private void btnDetalhesTab6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesTab6ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesTab[5]);
    }//GEN-LAST:event_btnDetalhesTab6ActionPerformed

    private void btnDetalhesMus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesMus1ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesMus[0]);
    }//GEN-LAST:event_btnDetalhesMus1ActionPerformed

    private void btnDetalhesMus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesMus2ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesMus[1]);
    }//GEN-LAST:event_btnDetalhesMus2ActionPerformed

    private void btnDetalhesMus3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesMus3ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesMus[2]);
    }//GEN-LAST:event_btnDetalhesMus3ActionPerformed

    private void btnDetalhesMus7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesMus7ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesMus[6]);
    }//GEN-LAST:event_btnDetalhesMus7ActionPerformed

    private void btnDetalhesMus20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesMus20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetalhesMus20ActionPerformed

    private void btnDetalhesMus4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesMus4ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesMus[3]);
    }//GEN-LAST:event_btnDetalhesMus4ActionPerformed

    private void btnDetalhesMus5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesMus5ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesMus[4]);
    }//GEN-LAST:event_btnDetalhesMus5ActionPerformed

    private void btnDetalhesMus6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesMus6ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesMus[5]);
    }//GEN-LAST:event_btnDetalhesMus6ActionPerformed

    private void btnDetalhesMus8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesMus8ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesMus[7]);
    }//GEN-LAST:event_btnDetalhesMus8ActionPerformed

    private void btnDetalhesMus9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesMus9ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesMus[8]);
    }//GEN-LAST:event_btnDetalhesMus9ActionPerformed

    private void btnDetalhesMus10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesMus10ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesMus[9]);
    }//GEN-LAST:event_btnDetalhesMus10ActionPerformed

    private void btnDetalhesVid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesVid1ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesVid[0]);
    }//GEN-LAST:event_btnDetalhesVid1ActionPerformed

    private void btnDetalhesVid2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesVid2ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesVid[1]);
    }//GEN-LAST:event_btnDetalhesVid2ActionPerformed

    private void btnDetalhesVid3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesVid3ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesVid[2]);
    }//GEN-LAST:event_btnDetalhesVid3ActionPerformed

    private void btnDetalhesVid4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesVid4ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesVid[3]);
    }//GEN-LAST:event_btnDetalhesVid4ActionPerformed

    private void btnDetalhesVid5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesVid5ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesVid[4]);
    }//GEN-LAST:event_btnDetalhesVid5ActionPerformed

    private void btnDetalhesVid6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesVid6ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesVid[5]);
    }//GEN-LAST:event_btnDetalhesVid6ActionPerformed

    private void btnDetalhesVid7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesVid7ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesVid[6]);
    }//GEN-LAST:event_btnDetalhesVid7ActionPerformed

    private void btnDetalhesVid8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesVid8ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesVid[7]);
    }//GEN-LAST:event_btnDetalhesVid8ActionPerformed

    private void btnDetalhesVid9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesVid9ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesVid[8]);
    }//GEN-LAST:event_btnDetalhesVid9ActionPerformed

    private void btnDetalhesVid10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesVid10ActionPerformed
        JOptionPane.showMessageDialog(null, detalhesVid[9]);
    }//GEN-LAST:event_btnDetalhesVid10ActionPerformed

    private void btnAlugarTab4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarTab4ActionPerformed
        addItemToTemp(btnAlugarTab4, "Tab", 4);
    }//GEN-LAST:event_btnAlugarTab4ActionPerformed

    private void btnAlugarTab5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarTab5ActionPerformed
        addItemToTemp(btnAlugarTab5, "Tab", 5);
    }//GEN-LAST:event_btnAlugarTab5ActionPerformed

    private void btnAlugarVid2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarVid2ActionPerformed
        addItemToTemp(btnAlugarVid2, "Vid", 2);
    }//GEN-LAST:event_btnAlugarVid2ActionPerformed

    private void btnAlugarMv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarMv1ActionPerformed
        addItemToTemp(btnAlugarMv1, "Mv", 1);
    }//GEN-LAST:event_btnAlugarMv1ActionPerformed

    private void btnAlugarMv2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarMv2ActionPerformed
        addItemToTemp(btnAlugarMv2, "Mv", 2);
    }//GEN-LAST:event_btnAlugarMv2ActionPerformed

    private void btnAlugarMv3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarMv3ActionPerformed
        addItemToTemp(btnAlugarMv3, "Mv", 3);
    }//GEN-LAST:event_btnAlugarMv3ActionPerformed

    private void btnAlugarMv4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarMv4ActionPerformed
        addItemToTemp(btnAlugarMv4, "Mv", 4);
    }//GEN-LAST:event_btnAlugarMv4ActionPerformed

    private void btnAlugarMv5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarMv5ActionPerformed
        addItemToTemp(btnAlugarMv5, "Mv", 5);
    }//GEN-LAST:event_btnAlugarMv5ActionPerformed

    private void btnAlugarMv6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarMv6ActionPerformed
        addItemToTemp(btnAlugarMv6, "Mv", 6);
    }//GEN-LAST:event_btnAlugarMv6ActionPerformed

    private void btnAlugarMv7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarMv7ActionPerformed
        addItemToTemp(btnAlugarMv7, "Mv", 7);
    }//GEN-LAST:event_btnAlugarMv7ActionPerformed

    private void btnAlugarMv8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarMv8ActionPerformed
        addItemToTemp(btnAlugarMv8, "Mv", 8);
    }//GEN-LAST:event_btnAlugarMv8ActionPerformed

    private void btnAlugarMv9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarMv9ActionPerformed
        addItemToTemp(btnAlugarMv9, "Mv", 9);
    }//GEN-LAST:event_btnAlugarMv9ActionPerformed

    private void btnAlugarMv10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarMv10ActionPerformed
        addItemToTemp(btnAlugarMv10, "Mv", 10);
    }//GEN-LAST:event_btnAlugarMv10ActionPerformed

    private void btnAlugarMus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarMus1ActionPerformed
        addItemToTemp(btnAlugarMus1, "Mus", 1);
    }//GEN-LAST:event_btnAlugarMus1ActionPerformed

    private void btnAlugarMus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarMus2ActionPerformed
        addItemToTemp(btnAlugarMus2, "Mus", 2);
    }//GEN-LAST:event_btnAlugarMus2ActionPerformed

    private void btnAlugarMus3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarMus3ActionPerformed
        addItemToTemp(btnAlugarMus3, "Mus", 3);
    }//GEN-LAST:event_btnAlugarMus3ActionPerformed

    private void btnAlugarMus4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarMus4ActionPerformed
        addItemToTemp(btnAlugarMus4, "Mus", 4);
    }//GEN-LAST:event_btnAlugarMus4ActionPerformed

    private void btnAlugarMus5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarMus5ActionPerformed
        addItemToTemp(btnAlugarMus5, "Mus", 5);
    }//GEN-LAST:event_btnAlugarMus5ActionPerformed

    private void btnAlugarMus6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarMus6ActionPerformed
        addItemToTemp(btnAlugarMus6, "Mus", 6);
    }//GEN-LAST:event_btnAlugarMus6ActionPerformed

    private void btnAlugarMus7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarMus7ActionPerformed
        addItemToTemp(btnAlugarMus7, "Mus", 7);
    }//GEN-LAST:event_btnAlugarMus7ActionPerformed

    private void btnAlugarMus8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarMus8ActionPerformed
        addItemToTemp(btnAlugarMus8, "Mus", 8);
    }//GEN-LAST:event_btnAlugarMus8ActionPerformed

    private void btnAlugarMus9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarMus9ActionPerformed
        addItemToTemp(btnAlugarMus9, "Mus", 9);
    }//GEN-LAST:event_btnAlugarMus9ActionPerformed

    private void btnAlugarMus10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarMus10ActionPerformed
        addItemToTemp(btnAlugarMus10, "Mus", 10);
    }//GEN-LAST:event_btnAlugarMus10ActionPerformed

    private void btnAlugarTab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarTab1ActionPerformed
        addItemToTemp(btnAlugarTab1, "Tab", 1);
    }//GEN-LAST:event_btnAlugarTab1ActionPerformed

    private void btnAlugarTab2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarTab2ActionPerformed
        addItemToTemp(btnAlugarTab2, "Tab", 2);
    }//GEN-LAST:event_btnAlugarTab2ActionPerformed

    private void btnAlugarTab3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarTab3ActionPerformed
        addItemToTemp(btnAlugarTab3, "Tab", 3);
    }//GEN-LAST:event_btnAlugarTab3ActionPerformed

    private void btnAlugarTab6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarTab6ActionPerformed
        addItemToTemp(btnAlugarTab6, "Tab", 6);
    }//GEN-LAST:event_btnAlugarTab6ActionPerformed

    private void btnAlugarVid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarVid1ActionPerformed
        addItemToTemp(btnAlugarVid1, "Vid", 1);
    }//GEN-LAST:event_btnAlugarVid1ActionPerformed

    private void btnAlugarVid3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarVid3ActionPerformed
        addItemToTemp(btnAlugarVid3, "Vid", 3);
    }//GEN-LAST:event_btnAlugarVid3ActionPerformed

    private void btnAlugarVid4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarVid4ActionPerformed
        addItemToTemp(btnAlugarVid4, "Vid", 4);
    }//GEN-LAST:event_btnAlugarVid4ActionPerformed

    private void btnAlugarVid5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarVid5ActionPerformed
        addItemToTemp(btnAlugarVid5, "Vid", 5);
    }//GEN-LAST:event_btnAlugarVid5ActionPerformed

    private void btnAlugarVid6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarVid6ActionPerformed
        addItemToTemp(btnAlugarVid6, "Vid", 6);
    }//GEN-LAST:event_btnAlugarVid6ActionPerformed

    private void btnAlugarVid7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarVid7ActionPerformed
        addItemToTemp(btnAlugarVid7, "Vid", 7);
    }//GEN-LAST:event_btnAlugarVid7ActionPerformed

    private void btnAlugarVid8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarVid8ActionPerformed
        addItemToTemp(btnAlugarVid8, "Vid", 8);
    }//GEN-LAST:event_btnAlugarVid8ActionPerformed

    private void btnAlugarVid9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarVid9ActionPerformed
        addItemToTemp(btnAlugarVid9, "Vid", 9);
    }//GEN-LAST:event_btnAlugarVid9ActionPerformed

    private void btnAlugarVid10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarVid10ActionPerformed
        addItemToTemp(btnAlugarVid10, "Vid", 10);
    }//GEN-LAST:event_btnAlugarVid10ActionPerformed

    // botão de atualizar loja realiza as ações escolhidas pelo usuário
    private void btnAddCartLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCartLojaActionPerformed
        int quant = tempPedido.size();
        
        for(int i = 0; i < quant; i++){
            Produtos item = tempPedido.get(i);
            javax.swing.JRadioButton btn = tempBtnSelected.get(i);
            
            if(finalPedido.contains(item)){ // removeu do carrinho
                btn.setText("Alugar");
                
                finalPedido.remove(item);
                
                valorTotal -= item.getPreco();
                
            } else { // adicionou ao carrinho
                btn.setText("Remover do carrinho");
                
                finalPedido.add(item);
                
                valorTotal += item.getPreco();
            }
            
            btn.setSelected(false);
        }
        
        Pedido.setPedidoAtual(finalPedido);
        
        tempBtnSelected.clear();
        tempPedido.clear();
        
        lblCartLoja.setText("Carrinho: " + finalPedido.size() + " itens - R$ " + valorTotal + "0");
    }//GEN-LAST:event_btnAddCartLojaActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Loja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCartLoja;
    private javax.swing.JRadioButton btnAlugarMus1;
    private javax.swing.JRadioButton btnAlugarMus10;
    private javax.swing.JRadioButton btnAlugarMus2;
    private javax.swing.JRadioButton btnAlugarMus3;
    private javax.swing.JRadioButton btnAlugarMus4;
    private javax.swing.JRadioButton btnAlugarMus5;
    private javax.swing.JRadioButton btnAlugarMus6;
    private javax.swing.JRadioButton btnAlugarMus7;
    private javax.swing.JRadioButton btnAlugarMus8;
    private javax.swing.JRadioButton btnAlugarMus9;
    private javax.swing.JRadioButton btnAlugarMv1;
    private javax.swing.JRadioButton btnAlugarMv10;
    private javax.swing.JRadioButton btnAlugarMv2;
    private javax.swing.JRadioButton btnAlugarMv3;
    private javax.swing.JRadioButton btnAlugarMv4;
    private javax.swing.JRadioButton btnAlugarMv5;
    private javax.swing.JRadioButton btnAlugarMv6;
    private javax.swing.JRadioButton btnAlugarMv7;
    private javax.swing.JRadioButton btnAlugarMv8;
    private javax.swing.JRadioButton btnAlugarMv9;
    private javax.swing.JRadioButton btnAlugarTab1;
    private javax.swing.JRadioButton btnAlugarTab2;
    private javax.swing.JRadioButton btnAlugarTab3;
    private javax.swing.JRadioButton btnAlugarTab4;
    private javax.swing.JRadioButton btnAlugarTab5;
    private javax.swing.JRadioButton btnAlugarTab6;
    private javax.swing.JRadioButton btnAlugarVid1;
    private javax.swing.JRadioButton btnAlugarVid10;
    private javax.swing.JRadioButton btnAlugarVid2;
    private javax.swing.JRadioButton btnAlugarVid3;
    private javax.swing.JRadioButton btnAlugarVid4;
    private javax.swing.JRadioButton btnAlugarVid5;
    private javax.swing.JRadioButton btnAlugarVid6;
    private javax.swing.JRadioButton btnAlugarVid7;
    private javax.swing.JRadioButton btnAlugarVid8;
    private javax.swing.JRadioButton btnAlugarVid9;
    private javax.swing.JButton btnDetalhesMus1;
    private javax.swing.JButton btnDetalhesMus10;
    private javax.swing.JButton btnDetalhesMus2;
    private javax.swing.JButton btnDetalhesMus3;
    private javax.swing.JButton btnDetalhesMus4;
    private javax.swing.JButton btnDetalhesMus5;
    private javax.swing.JButton btnDetalhesMus6;
    private javax.swing.JButton btnDetalhesMus7;
    private javax.swing.JButton btnDetalhesMus8;
    private javax.swing.JButton btnDetalhesMus9;
    private javax.swing.JButton btnDetalhesMv1;
    private javax.swing.JButton btnDetalhesMv10;
    private javax.swing.JButton btnDetalhesMv2;
    private javax.swing.JButton btnDetalhesMv3;
    private javax.swing.JButton btnDetalhesMv4;
    private javax.swing.JButton btnDetalhesMv5;
    private javax.swing.JButton btnDetalhesMv6;
    private javax.swing.JButton btnDetalhesMv7;
    private javax.swing.JButton btnDetalhesMv8;
    private javax.swing.JButton btnDetalhesMv9;
    private javax.swing.JButton btnDetalhesTab1;
    private javax.swing.JButton btnDetalhesTab2;
    private javax.swing.JButton btnDetalhesTab3;
    private javax.swing.JButton btnDetalhesTab4;
    private javax.swing.JButton btnDetalhesTab5;
    private javax.swing.JButton btnDetalhesTab6;
    private javax.swing.JButton btnDetalhesVid1;
    private javax.swing.JButton btnDetalhesVid10;
    private javax.swing.JButton btnDetalhesVid2;
    private javax.swing.JButton btnDetalhesVid3;
    private javax.swing.JButton btnDetalhesVid4;
    private javax.swing.JButton btnDetalhesVid5;
    private javax.swing.JButton btnDetalhesVid6;
    private javax.swing.JButton btnDetalhesVid7;
    private javax.swing.JButton btnDetalhesVid8;
    private javax.swing.JButton btnDetalhesVid9;
    private javax.swing.JButton btnFinalizarLoja;
    private javax.swing.JButton btnVoltarLoja;
    private javax.swing.JLabel descMus1;
    private javax.swing.JLabel descMus10;
    private javax.swing.JLabel descMus2;
    private javax.swing.JLabel descMus3;
    private javax.swing.JLabel descMus4;
    private javax.swing.JLabel descMus5;
    private javax.swing.JLabel descMus6;
    private javax.swing.JLabel descMus7;
    private javax.swing.JLabel descMus8;
    private javax.swing.JLabel descMus9;
    private javax.swing.JLabel descMv1;
    private javax.swing.JLabel descMv10;
    private javax.swing.JLabel descMv2;
    private javax.swing.JLabel descMv3;
    private javax.swing.JLabel descMv4;
    private javax.swing.JLabel descMv5;
    private javax.swing.JLabel descMv6;
    private javax.swing.JLabel descMv7;
    private javax.swing.JLabel descMv8;
    private javax.swing.JLabel descMv9;
    private javax.swing.JLabel descTab1;
    private javax.swing.JLabel descTab2;
    private javax.swing.JLabel descTab3;
    private javax.swing.JLabel descTab4;
    private javax.swing.JLabel descTab5;
    private javax.swing.JLabel descTab6;
    private javax.swing.JLabel descVid1;
    private javax.swing.JLabel descVid10;
    private javax.swing.JLabel descVid2;
    private javax.swing.JLabel descVid3;
    private javax.swing.JLabel descVid4;
    private javax.swing.JLabel descVid5;
    private javax.swing.JLabel descVid6;
    private javax.swing.JLabel descVid7;
    private javax.swing.JLabel descVid8;
    private javax.swing.JLabel descVid9;
    private javax.swing.JLabel imgMus1;
    private javax.swing.JLabel imgMus10;
    private javax.swing.JLabel imgMus2;
    private javax.swing.JLabel imgMus3;
    private javax.swing.JLabel imgMus4;
    private javax.swing.JLabel imgMus5;
    private javax.swing.JLabel imgMus6;
    private javax.swing.JLabel imgMus7;
    private javax.swing.JLabel imgMus8;
    private javax.swing.JLabel imgMus9;
    private javax.swing.JLabel imgMv1;
    private javax.swing.JLabel imgMv10;
    private javax.swing.JLabel imgMv2;
    private javax.swing.JLabel imgMv3;
    private javax.swing.JLabel imgMv4;
    private javax.swing.JLabel imgMv5;
    private javax.swing.JLabel imgMv6;
    private javax.swing.JLabel imgMv7;
    private javax.swing.JLabel imgMv8;
    private javax.swing.JLabel imgMv9;
    private javax.swing.JLabel imgTab1;
    private javax.swing.JLabel imgTab2;
    private javax.swing.JLabel imgTab3;
    private javax.swing.JLabel imgTab4;
    private javax.swing.JLabel imgTab5;
    private javax.swing.JLabel imgTab6;
    private javax.swing.JLabel imgVid1;
    private javax.swing.JLabel imgVid10;
    private javax.swing.JLabel imgVid2;
    private javax.swing.JLabel imgVid3;
    private javax.swing.JLabel imgVid4;
    private javax.swing.JLabel imgVid5;
    private javax.swing.JLabel imgVid6;
    private javax.swing.JLabel imgVid7;
    private javax.swing.JLabel imgVid8;
    private javax.swing.JLabel imgVid9;
    private javax.swing.JLabel lblCartLoja;
    private javax.swing.JMenuBar menuBarLoja;
    private javax.swing.JMenuItem menuFinalizarLoja;
    private javax.swing.JMenu menuLoja;
    private javax.swing.JMenuItem menuSairLoja;
    private javax.swing.JMenuItem menuVoltarLoja;
    private javax.swing.JLabel nomeMus1;
    private javax.swing.JLabel nomeMus10;
    private javax.swing.JLabel nomeMus2;
    private javax.swing.JLabel nomeMus3;
    private javax.swing.JLabel nomeMus4;
    private javax.swing.JLabel nomeMus5;
    private javax.swing.JLabel nomeMus6;
    private javax.swing.JLabel nomeMus7;
    private javax.swing.JLabel nomeMus8;
    private javax.swing.JLabel nomeMus9;
    private javax.swing.JLabel nomeMv1;
    private javax.swing.JLabel nomeMv10;
    private javax.swing.JLabel nomeMv2;
    private javax.swing.JLabel nomeMv3;
    private javax.swing.JLabel nomeMv4;
    private javax.swing.JLabel nomeMv5;
    private javax.swing.JLabel nomeMv6;
    private javax.swing.JLabel nomeMv7;
    private javax.swing.JLabel nomeMv8;
    private javax.swing.JLabel nomeMv9;
    private javax.swing.JLabel nomeTab1;
    private javax.swing.JLabel nomeTab2;
    private javax.swing.JLabel nomeTab3;
    private javax.swing.JLabel nomeTab4;
    private javax.swing.JLabel nomeTab5;
    private javax.swing.JLabel nomeTab6;
    private javax.swing.JLabel nomeVid1;
    private javax.swing.JLabel nomeVid10;
    private javax.swing.JLabel nomeVid2;
    private javax.swing.JLabel nomeVid3;
    private javax.swing.JLabel nomeVid4;
    private javax.swing.JLabel nomeVid5;
    private javax.swing.JLabel nomeVid6;
    private javax.swing.JLabel nomeVid7;
    private javax.swing.JLabel nomeVid8;
    private javax.swing.JLabel nomeVid9;
    private javax.swing.JPanel pnlFilmes;
    private javax.swing.JPanel pnlLoja;
    private javax.swing.JPanel pnlMus1;
    private javax.swing.JPanel pnlMus10;
    private javax.swing.JPanel pnlMus2;
    private javax.swing.JPanel pnlMus3;
    private javax.swing.JPanel pnlMus4;
    private javax.swing.JPanel pnlMus5;
    private javax.swing.JPanel pnlMus6;
    private javax.swing.JPanel pnlMus7;
    private javax.swing.JPanel pnlMus8;
    private javax.swing.JPanel pnlMus9;
    private javax.swing.JPanel pnlMusicas;
    private javax.swing.JPanel pnlMv1;
    private javax.swing.JPanel pnlMv10;
    private javax.swing.JPanel pnlMv2;
    private javax.swing.JPanel pnlMv3;
    private javax.swing.JPanel pnlMv4;
    private javax.swing.JPanel pnlMv5;
    private javax.swing.JPanel pnlMv6;
    private javax.swing.JPanel pnlMv7;
    private javax.swing.JPanel pnlMv8;
    private javax.swing.JPanel pnlMv9;
    private javax.swing.JPanel pnlTab1;
    private javax.swing.JPanel pnlTab2;
    private javax.swing.JPanel pnlTab3;
    private javax.swing.JPanel pnlTab4;
    private javax.swing.JPanel pnlTab5;
    private javax.swing.JPanel pnlTab6;
    private javax.swing.JPanel pnlTabuleiros;
    private javax.swing.JPanel pnlVid1;
    private javax.swing.JPanel pnlVid10;
    private javax.swing.JPanel pnlVid2;
    private javax.swing.JPanel pnlVid3;
    private javax.swing.JPanel pnlVid4;
    private javax.swing.JPanel pnlVid5;
    private javax.swing.JPanel pnlVid6;
    private javax.swing.JPanel pnlVid7;
    private javax.swing.JPanel pnlVid8;
    private javax.swing.JPanel pnlVid9;
    private javax.swing.JPanel pnlVideogames;
    private javax.swing.JLabel precoMus1;
    private javax.swing.JLabel precoMus10;
    private javax.swing.JLabel precoMus2;
    private javax.swing.JLabel precoMus3;
    private javax.swing.JLabel precoMus4;
    private javax.swing.JLabel precoMus5;
    private javax.swing.JLabel precoMus6;
    private javax.swing.JLabel precoMus7;
    private javax.swing.JLabel precoMus8;
    private javax.swing.JLabel precoMus9;
    private javax.swing.JLabel precoMv1;
    private javax.swing.JLabel precoMv10;
    private javax.swing.JLabel precoMv2;
    private javax.swing.JLabel precoMv3;
    private javax.swing.JLabel precoMv4;
    private javax.swing.JLabel precoMv5;
    private javax.swing.JLabel precoMv6;
    private javax.swing.JLabel precoMv7;
    private javax.swing.JLabel precoMv8;
    private javax.swing.JLabel precoMv9;
    private javax.swing.JLabel precoTab1;
    private javax.swing.JLabel precoTab2;
    private javax.swing.JLabel precoTab3;
    private javax.swing.JLabel precoTab4;
    private javax.swing.JLabel precoTab5;
    private javax.swing.JLabel precoTab6;
    private javax.swing.JLabel precoVid1;
    private javax.swing.JLabel precoVid10;
    private javax.swing.JLabel precoVid2;
    private javax.swing.JLabel precoVid3;
    private javax.swing.JLabel precoVid4;
    private javax.swing.JLabel precoVid5;
    private javax.swing.JLabel precoVid6;
    private javax.swing.JLabel precoVid7;
    private javax.swing.JLabel precoVid8;
    private javax.swing.JLabel precoVid9;
    private javax.swing.JScrollPane scrollFilmes;
    private javax.swing.JScrollPane scrollMusicas;
    private javax.swing.JScrollPane scrollTabuleiros;
    private javax.swing.JScrollPane scrollVideogames;
    private javax.swing.JPopupMenu.Separator separatorLoja;
    private javax.swing.JTabbedPane tabbedPnlLoja;
    // End of variables declaration//GEN-END:variables
}
