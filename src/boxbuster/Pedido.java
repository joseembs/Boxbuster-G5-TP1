package boxbuster;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author hsaless
 */
public class Pedido {
    private static final String arquivo = "pedidos.txt";
    
    // contador de pedidos que sempre fica atualizado com base no "pedidos.txt"
    private static int codigoPedido = 1;
    
    // lista que armazena todos os itens que o cliente adicionou ao seu carrinho
    private static ArrayList<Produtos> pedidoAtual = new ArrayList<>(); 
    
    // mapa que, por meio do arquivo e atualizações, sempre tem todos os 
    // pedidos já feitos relacionados a seus respectivos códigos de pedido
    private static HashMap<Integer, Alugar> mapAlugueis = new HashMap<>();

    public Pedido() {
    }

    public Pedido(int codigoPedido) {
        Pedido.codigoPedido = codigoPedido;
    }

    public static int getCodigoPedido() {
        return codigoPedido;
    }

    public static void setCodigoPedido(int codigoPedido) {
        Pedido.codigoPedido = codigoPedido;
    }

    public static ArrayList<Produtos> getPedidoAtual() {
        return pedidoAtual;
    }

    public static void setPedidoAtual(ArrayList<Produtos> pedidoAtual) {
        Pedido.pedidoAtual = pedidoAtual;
    }
    
    public static void addProduto(Produtos produto){
        Pedido.pedidoAtual.add(produto);
    }

    public static HashMap<Integer, Alugar> getMapPedidos() {
        return mapAlugueis;
    }

    public static void setMapPedidos(HashMap<Integer, Alugar> mapAlugueis) {
        Pedido.mapAlugueis = mapAlugueis;
    }
    
    // método que é chamado pela tela de finalização, reunindo as informações do
    // aluguel e adicionando-o ao mapa de pedidos, também atualizando o arquivo de aluguéis e o estoque
    public static void addPedido(String pagamento, String codigoCaixa){
        Alugar aluguelFeito = new Alugar(pagamento, codigoCaixa);
        
        Pedido.mapAlugueis.put(codigoPedido, aluguelFeito);
        codigoPedido++;
        
        salvarAluguel(aluguelFeito);
        
        for(Produtos prodTemp : aluguelFeito.getListaProdutos()){
            Produtos trueProd = Estoque.getProdutoPorCodigo(prodTemp.getCodigoProd());
            trueProd.alugaProduto();
        }
        
        Pedido.pedidoAtual = new ArrayList<>();
    }
    
    // usa as keys do mapa de aluguéis para adicionar ou modificar um aluguel
    public static void replaceAluguel(int codigoPedido, Alugar aluguel){
        Pedido.mapAlugueis.put(codigoPedido, aluguel);
    }
    
    // chamada para preencher as tabelas, usa o codigoProd salvo pelos Alugar para retornar o produto alugado 
    public static Alugar getAluguelPorCodigo(int codigoPedido){
        Alugar aluguel = mapAlugueis.get(codigoPedido);
        
        return aluguel;
    }
    
    // escreve uma linha nova no arquivo dos pedidos com o aluguel informado
    public static void salvarAluguel(Alugar aluguel) {
        try (FileWriter fw = new FileWriter(arquivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(aluguel.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // recupera o mapa de pedidos com base no "pedidos.txt"
    static public HashMap<Integer, Alugar> loadAlugueis() {
        HashMap<Integer, Alugar> alugueis = new HashMap<>();
        int temp = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if(!linha.isEmpty()){
                    String[] item = linha.split("_");
                    Alugar aluguel = new Alugar(item[0], item[1], item[2], item[3], item[4], item[5], item[6], item[7]);

                    alugueis.put(Integer.valueOf(item[0]), aluguel);

                    temp = Math.max(temp, Integer.parseInt(item[0]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Pedido.codigoPedido = temp+1;        
        Pedido.setMapPedidos(alugueis);
        return alugueis;
    }
    
    // reescreve por completo o arquivo dos pedidos com base no mapa de pedidos
    // geralmente usado para salvar mudanças
    static public void reescreverAlugueis() {
        HashMap<Integer, Alugar> alugueis = Pedido.getMapPedidos();
        
        try (FileWriter fw = new FileWriter(arquivo, false);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for(Alugar aluguel : alugueis.values()){
                out.println(aluguel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Pedido.loadAlugueis(); // mantém tudo sincronizado
    }
}
