/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boxbuster;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author elisrb
 */
public class BancoDeDadosFuncionarios implements BancoDeDados{
    private static String arquivo;

    public BancoDeDadosFuncionarios(String arquivo) {
        this.arquivo = arquivo;
    }

    public void adicionarPessoa(Funcionario func) {
        try (FileWriter fw = new FileWriter(arquivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(func.toString());
            out.println("-------------------------------------------"); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public int[] quantidades() {
        int caixas = 0, gerentes = 0;            
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if(linha.contains(" Caixa")){
                    caixas++;
                }
                else if(linha.contains(" Gerente")){
                    gerentes++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        int[] ans = {caixas, gerentes};
        return ans;
    }
    
    @Override
    public ArrayList<String> lerPessoas() {
        ArrayList<String> pessoas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                pessoas.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pessoas;
    }
    
    @Override
    public ArrayList<String> buscarPessoa(String busca) {
        ArrayList<String> ans = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.contains(busca)) {
                    for(String i : linha.split(" ")){
                        ans.add(i);
                    }
                    return ans;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }
}
