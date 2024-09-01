package boxbuster;

import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author hsaless
 */

public abstract class Cliente extends Pessoa {
    protected double divida;
    protected ArrayList<Alugar> alugados;
    protected ArrayList<Pedido> pedidos;
    
    public Cliente(){
        this.alugados = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public Cliente(String nome, String CPF, Date dataNascimento, double divida) {
        super(nome, CPF, dataNascimento);
        this.divida = divida;
        this.alugados = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }
    
    public abstract void calculaDivida();

    @Override
    public String toString() {
        return super.toString() + "_" + divida;
    }

    public double getDivida() {
        return divida;
    }

    public void setDivida(double divida) {
        this.divida = divida;
    }

    public ArrayList<Alugar> getAlugados() {
        return alugados;
    }

    public void setAlugados(ArrayList<Alugar> alugados) {
        this.alugados = alugados;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    
    
    
    
    
    
    
    
    
    
}
