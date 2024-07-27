/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoo;
import java.util.Date;

/**
 *
 * @author User
 */
public class Alugar {
    private Date dataPedido;
    private Date dataDevolucao;
    private Cliente cliente;
    private Produto produto;

    public Alugar() {
    }

    public Alugar(Date dataPedido, Date dataDevolucao, Cliente cliente, Produto produto) {
        this.dataPedido = dataPedido;
        this.dataDevolucao = dataDevolucao;
        this.cliente = cliente;
        this.produto = produto;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
    
    
    
}
