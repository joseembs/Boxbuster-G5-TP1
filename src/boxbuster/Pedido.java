/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import java.util.HashMap;

/**
 *
 * @author hsaless
 */
public class Pedido {
    static private int codigoPedido = 1;
    
    static private ArrayList<Produtos> pedidoAtual = new ArrayList<>(); 
    
    static private HashMap<Integer, Alugar> mapAlugueis = new HashMap<Integer, Alugar>();

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
    
    public static void addPedido(String pagamento, String codigoCaixa){
        Alugar aluguelFeito = new Alugar(pagamento, codigoCaixa);
        
        Pedido.mapAlugueis.put(codigoPedido, aluguelFeito);
        codigoPedido++;
        
        salvarAluguel(aluguelFeito);
    }
    
    // chamada para preencher as tabelas, usa o codigoProd salvo pelos Alugar para retornar o produto alugado 
    static public Alugar getAluguelPorCodigo(int codigoPedido){
        Alugar aluguel = mapAlugueis.get(codigoPedido);
        
        return aluguel;
    }
    
    static private String arquivo = "pedidos.txt";
    
    static public void salvarAluguel(Alugar aluguel) {
        try (FileWriter fw = new FileWriter(arquivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(aluguel.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static public HashMap<Integer, Alugar> lerAlugueis() {
        HashMap<Integer, Alugar> alugueis = new HashMap<>();
        int temp = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] item = linha.split("_");
                Alugar aluguel = new Alugar(item[0], item[1], item[2], item[3], item[4], item[5], item[6]);
                
                alugueis.put(Integer.valueOf(item[0]), aluguel);
                
                temp = Math.max(temp, Integer.parseInt(item[0]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(alugueis);
        Pedido.setMapPedidos(alugueis);
        return alugueis;
    }
    
    static public void reescreverAlugueis() {
        HashMap<Integer, Alugar> alugueis = Pedido.getMapPedidos();
        
        try (FileWriter fw = new FileWriter(arquivo, false);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for(Alugar aluguel : alugueis.values()){
                out.println(aluguel);
                out.println("-------------------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Pedido.lerAlugueis(); // mantém tudo sincronizado
    }
}
