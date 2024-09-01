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
    private static Funcionario funcAtual;
    
    public BancoDeDadosFuncionarios(String arquivo) {
        this.arquivo = arquivo;
    }

    /*public static Funcionario getFunc_atual() {
        return funcAtual;
    }

    public static void setFunc_atual(Funcionario func_atual) {
        BancoDeDadosFuncionarios.funcAtual = func_atual;
    }*/
    
    public void adicionarPessoa(Funcionario func) {
        try (FileWriter fw = new FileWriter(arquivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(func.toString());
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
    
    // chamada pela AreaCaixa, usa o caixa logado para achar todos os aluguéis dele
    public static ArrayList<Alugar> getHistoricoCaixa(Caixa caixaAtual){
        ArrayList<Alugar> historico = new ArrayList<>();
        
        for(Alugar tempAluguel : Pedido.getMapPedidos().values()){
            if(caixaAtual.equals(tempAluguel.getCaixaCodigo())){
                historico.add(tempAluguel);
            }
        }
    
        return historico;
    }
    
    static public Cliente getClientePorCPF(String cpfCliente){
        Cliente cliente = null;
        
        //for(Cliente tempCliente : BancoDeDadosClientes.getListaClientes()){
        //    if(cpfCliente == tempCliente.getCpf()){
        //        cliente = tempCliente;
        //    }
        //}
        
        return cliente;
    }
    
    public void removerPessoa(String CPF) {
        ArrayList<String> linhas = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            boolean encontrou = false;

            while ((linha = br.readLine()) != null) {
                if (linha.contains(CPF)) {
                    encontrou = true;
                    /*while (!linha.equals("-------------------------------------------")) {
                        linha = br.readLine(); 
                    }
                    linha = br.readLine();*/
                    
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
    
    public Gerente buscarGerente(String nome) {
        String[] palavras;
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                palavras = linha.split(" ");
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
