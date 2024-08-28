/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package boxbuster;

import java.util.ArrayList;

/**
 *
 * @author elisrb
 */
public interface BancoDeDados {
    public ArrayList<String> lerPessoas();
    public String buscarPessoa(String busca);
}