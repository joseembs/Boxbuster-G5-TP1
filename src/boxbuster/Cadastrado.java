/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoo;

import java.util.ArrayList;
public class Cadastrado extends Cliente {
    private String senha;
    private int codigoCliente;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
    
    @Override
    public void calculaDivida() {
        double totalDivida = 0.0;
        ArrayList<Alugar> alugados = getAlugados();

        for (int i = 0; i < alugados.size(); i++) {
            totalDivida += (alugados.get(i).getProduto().getPreco()) * 0.9;
        }

        this.divida = totalDivida;
    }
    
}
