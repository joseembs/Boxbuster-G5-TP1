/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boxbuster;

import boxbuster.Jogos;

/**
 *
 * @author Adm
 */
public class Tabuleiro extends Jogos{
    private String tipo;
    private String marca;

    public Tabuleiro(String nomeProd, double preco, int ano, int codigoProd, int faixaEtaria, boolean alugado, int numJogadores, String tipo, String marca) {
        super(nomeProd, preco, ano, codigoProd, faixaEtaria, alugado, numJogadores);
        this.tipo = tipo;
        this.marca = marca;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
}
