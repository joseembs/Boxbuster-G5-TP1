package boxbuster;

import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author hsaless
 */
public abstract class Cliente extends Pessoa {
    private double divida;
    private ArrayList<Alugar> alugados;
    
    public Cliente(){
        this.alugados = new ArrayList<>();
    }

    public Cliente(String nome, String CPF, Date dataNascimento, double divida) {
        super(nome, CPF, dataNascimento);
        this.divida = divida;
        this.alugados = new ArrayList<>();
    }
    
    // pega a lista de alugueis e calcula a divida
    public abstract void calculaDivida(); 

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
    
    public void addAlugado(Alugar alugado) {
        this.alugados.add(alugado);
    }
    
    @Override
    public String toString() {
        return super.toString() + "_" + divida;
    }
}
