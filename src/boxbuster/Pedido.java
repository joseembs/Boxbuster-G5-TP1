/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boxbuster;

import java.util.ArrayList;

/**
 *
 * @author hsaless
 */
public class Pedido {
    static private int codigoPedido;
    static private Cliente cliente;
    static private Caixa caixa;
    
    static private ArrayList<Produtos> pedidoAtual = new ArrayList<>(); 

    public Pedido() {
    }

    public Pedido(int codigoPedido, Cliente cliente, Caixa caixa) {
        Pedido.codigoPedido = codigoPedido;
        Pedido.cliente = cliente;
        Pedido.caixa = caixa;
    }

    public static int getCodigoPedido() {
        return codigoPedido;
    }

    public static void setCodigoPedido(int codigoPedido) {
        Pedido.codigoPedido = codigoPedido;
    }

    public static Cliente getCliente() {
        return cliente;
    }

    public static void setCliente(Cliente cliente) {
        Pedido.cliente = cliente;
    }

    public static Caixa getCaixa() {
        return caixa;
    }

    public static void setCaixa(Caixa caixa) {
        Pedido.caixa = caixa;
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
}
