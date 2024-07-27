package boxbuster;

import java.util.Date;
import java.util.ArrayList;


/**
 *
 * @author User
 */
public class Alugar {
    private Date dataPedido;
    private Date dataDevolucao;
    private Cliente cliente;
    private Produtos produto;

    public Alugar() {
    }

    public Alugar(Date dataPedido, Date dataDevolucao, Cliente cliente, Produtos produto) {
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

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }
    
    
    
    
    
}
