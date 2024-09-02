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

    public Visitante(String nome, String CPF, Date dataNascimento, double divida) {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    

    @Override
    public void calculaDivida() {// pega a lista de alugueis e calcula a divida
        double totalDivida = 0.0;
        ArrayList<Alugar> alugados = getAlugados();
        for(int i = 0; i < alugados.size(); i++){
            Alugar aluguel = alugados.get(i);
            for(int j = 0; j < alugados.get(i).getListaProdutos().size(); j++){
                
                Produtos item = aluguel.getListaProdutos().get(j);
                Status status = aluguel.getProdutoStatus(item.getCodigoProd());
                if(status == Status.ATRASADO){
                    totalDivida += (item.getPreco() / 2);
                }
            }
        }

        

        setDivida(totalDivida);
    }

    @Override
    public String toString() {
        String aux = "Visitante_" + super.toString();
        
        
        return aux;
    }
    
    
}
