package boxbuster;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author hsaless
 */
public class Cadastrado extends Cliente {
    private String senha;
    private int codigoCliente;

    public Cadastrado() {
        this.alugados = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public Cadastrado(String nome, int CPF, Date dataNascimento, double divida, String senha, int codigoCliente) {
        super(nome, CPF, dataNascimento, divida);
        this.senha = senha;
        this.codigoCliente = codigoCliente;
        this.alugados = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        
        
    }
    
    
    

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
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

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    
    public void addAlugado(Pedido pedido) {
        this.pedidos.add(pedido);
    }
    
    public void addAlugado(Alugar alugado) {
        this.alugados.add(alugado);
    }
    
    
    
    @Override
    public void calculaDivida() {
        double totalDivida = 0.0;
        ArrayList<Alugar> alugados = getAlugados();

        for (int i = 0; i < alugados.size(); i++) {
            totalDivida += (alugados.get(i).getProduto().getPreco()) * 0.9;
        }

        setDivida(totalDivida);
    }
    
    
}
