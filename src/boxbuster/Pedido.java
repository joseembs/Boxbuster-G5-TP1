/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boxbuster;

/**
 *
 * @author hsaless
 */
public class Pedido {
    private int codigoPedido;
    private Cliente cliente;
    private Caixa caixa;

    public Pedido() {
    }

    public Pedido(int codigoPedido, Cliente cliente, Caixa caixa) {
        this.codigoPedido = codigoPedido;
        this.cliente = cliente;
        this.caixa = caixa;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }
    
    
    
}
