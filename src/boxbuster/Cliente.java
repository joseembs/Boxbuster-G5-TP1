package boxbuster;

import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author hsaless
 */

public abstract class Cliente extends Pessoa {
    protected double divida;
    protected ArrayList<Alugar> alugados;
    protected ArrayList<Pedido> pedidos;
    
    public Cliente(){
        this.alugados = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public Cliente(String nome, int CPF, Date dataNascimento, double divida) {
        super(nome, CPF, dataNascimento);
        this.divida = divida;
        this.alugados = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }
    
    public abstract void calculaDivida();

    @Override
    public String toString() {
        return super.toString() + " " + divida;
    }
    
    
    
    
    
    
    
}
