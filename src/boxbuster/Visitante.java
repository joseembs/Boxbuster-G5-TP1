package boxbuster;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author hsaless
 */
public class Visitante extends Cliente {

    public Visitante() {
        this.alugados = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        
    }

    public Visitante(String nome, int CPF, Date dataNascimento, double divida) {
        super(nome, CPF, dataNascimento, divida);
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

    

    @Override
    public void calculaDivida() {
        double totalDivida = 0.0;
        ArrayList<Alugar> alugados = getAlugados();
 
        for (int i = 0; i < alugados.size(); i++) {
            totalDivida += alugados.get(i).getProduto().getPreco();
        }

        setDivida(totalDivida);
    }

    @Override
    public String toString() {
        return "Visitante " + super.toString();
    }
    
    
}
