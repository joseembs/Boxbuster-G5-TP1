package boxbuster;

import java.util.ArrayList;

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

    public Cadastrado(String nome, int CPF, int idade, double divida, String senha, int codigoCliente) {
        super(nome, CPF, idade, divida);
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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
