package boxbuster;

import java.util.ArrayList;

public class Visitante extends Cliente {

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
