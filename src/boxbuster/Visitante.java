package boxbuster;

import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author hsaless
 */
public class Visitante extends Cliente {

    public Visitante() {
    }

    public Visitante(String nome, String CPF, Date dataNascimento, double divida) {
        super(nome, CPF, dataNascimento, divida);
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
