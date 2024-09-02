package boxbuster;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author hsaless
 */
public class Cadastrado extends Cliente {
    private String senha;
    

    public Cadastrado() {
        this.alugados = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public Cadastrado(String nome, String CPF, Date dataNascimento, double divida, String senha) {
        super(nome, CPF, dataNascimento, divida);
        this.senha = senha;
        this.alugados = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        
        
    }
    
    
    

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    
    
    public void addAlugado(Pedido pedido) {
        this.pedidos.add(pedido);
    }
    
    public void addAlugado(Alugar alugado) {
        this.alugados.add(alugado);
    }
    
    
    
    @Override
    public void calculaDivida() { // pega a lista de alugueis e calcula a divida
        double totalDivida = 0.0;
        ArrayList<Alugar> alugados = getAlugados();
        for(int i = 0; i < alugados.size(); i++){
            Alugar aluguel = alugados.get(i);
            for(int j = 0; j < alugados.get(i).getListaProdutos().size(); j++){
                
                Produtos item = aluguel.getListaProdutos().get(j);
                Status status = aluguel.getProdutoStatus(item.getCodigoProd());
                if(status == Status.ATRASADO){
                    totalDivida += (item.getPreco() / 2) * 0.9;
                }
            }
        }

        

        setDivida(totalDivida);
    }
    @Override
    public String toString() {
        String aux = "Cadastrado_" + super.toString() + "_" + senha;
        
        
        return aux;
    }
    
    
    
    
    
    
    
}
