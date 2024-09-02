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
    
    public void adicionarPessoa(Funcionario func) { // escreve uma linha nova no arquivo contendo os dados do funcionário
        try (FileWriter fw = new FileWriter(arquivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(func.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public int[] quantidades() { // calcula a quantidade de gerentes e caixas
        int caixas = 0, gerentes = 0;            
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if(linha.contains("_Caixa")){
                    caixas++;
                }
                else if(linha.contains("_Gerente")){
                    gerentes++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        int[] ans = {caixas, gerentes};
        return ans;
    }
    
    public void removerPessoa(String CPF) { // busca um funcionário pelo CPF e o remove
        //reescreve o arquivo com todas as linhas menos uma (a linha que contém o CPF buscado)
        
        ArrayList<String> linhas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            boolean encontrou = false;

            while ((linha = br.readLine()) != null) {
                if (linha.contains(CPF)) {
                    encontrou = true;
                } else {
                    linhas.add(linha); 
                }
            }

            if (!encontrou) {
                System.out.println("Funcionario não encontrado.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (String linha : linhas) {
                bw.write(linha);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public Gerente buscarGerente(String nome) { // encontra o gerente a partir do nome do caixa correspondente
        String[] palavras;
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                palavras = linha.split("_");
                if(palavras[0].equals(nome) && palavras[5].equals("Gerente")){
                    return new Gerente(nome);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return new Gerente("--");
    }
    
    @Override
    public ArrayList<String> lerPessoas() { // retorna todos os funcionários
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
    public ArrayList<String> buscarPessoa(String busca) { // busca por uma substring na string de dados do funcionário
        ArrayList<String> ans = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.contains(busca)) {
                    for(String i : linha.split("_")){
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
