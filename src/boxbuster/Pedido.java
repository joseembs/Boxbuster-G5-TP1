/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boxbuster;

import java.io.BufferedWriter;
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
    static private int codigoPedido = 1;
    
    static private ArrayList<Produtos> pedidoAtual = new ArrayList<>(); 
    
    static private HashMap<Integer, Alugar> mapAlugueis = new HashMap<Integer, Alugar>();
    
    static private String arquivo = "pedidos.txt";

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
    
    public static void addPedido(String pagamento, Caixa caixa){
        Alugar aluguelFeito = new Alugar(pagamento, caixa);
        
        Pedido.mapAlugueis.put(codigoPedido, aluguelFeito);
        codigoPedido++;
    }
    
    static public void salvarAluguel(Alugar aluguel) {
        try (FileWriter fw = new FileWriter(arquivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(aluguel.toString());
            out.println("-------------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
}
