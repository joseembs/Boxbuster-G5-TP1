package boxbuster;

import java.util.ArrayList;
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

    public Cliente(String nome, int CPF, int idade, double divida) {
        super(nome, CPF, idade);
        this.divida = divida;
        this.alugados = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }
    
    public abstract void calculaDivida();
    
}
