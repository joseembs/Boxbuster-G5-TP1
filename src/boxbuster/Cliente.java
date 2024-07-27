package projetoo;

import java.util.ArrayList;

public abstract class Cliente extends Pessoa {
    private double divida;
    private ArrayList<Alugar> alugados;
    private ArrayList<Pedido> pedidos;
    
    public Cliente(){
        this.alugados = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public Cliente(double divida) {
        this.divida = divida;
        this.alugados = new ArrayList<>();
        this.pedidos = new ArrayList<>();
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
    
    public void addAlugado(Pedido pedido) {
        this.pedidos.add(pedido);
    }
    
    
    
    
    

    
    public abstract void calculaDivida();

  
    
    

    
    public void addAlugado(Alugar alugado) {
        this.alugados.add(alugado);
    }
}
