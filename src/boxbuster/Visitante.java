package boxbuster;

import java.util.ArrayList;

/**
 *
 * @author hsaless
 */
public class Visitante extends Cliente {

    public Visitante() {
        this.alugados = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        
    }

    public Visitante(String nome, int CPF, int idade, double divida) {
        super(nome, CPF, idade, divida);
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
    
    
    

    @Override
    public void calculaDivida() {
        double totalDivida = 0.0;
        ArrayList<Alugar> alugados = getAlugados();

        for (int i = 0; i < alugados.size(); i++) {
            totalDivida += alugados.get(i).getProduto().getPreco();
        }

        setDivida(totalDivida);
    }
}
