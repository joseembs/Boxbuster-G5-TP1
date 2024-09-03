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
    }

    public Cadastrado(String nome, String CPF, Date dataNascimento, double divida, String senha) {
        super(nome, CPF, dataNascimento, divida);
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
