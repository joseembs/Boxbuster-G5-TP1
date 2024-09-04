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
 * @author hsaless
 */
public class BancoDeDadosClientes implements BancoDeDados{ // escreve uma linha nova no arquivo contendo os dados do cliente
    private static final String arquivo = "clientes.txt";
    
    // armazena as informações do cliente logado, para serem acessadas em diversas telas
    private static Cliente clienteAtual = null;

    public BancoDeDadosClientes() {
    }
    
    public static Cliente getClienteAtual() {
        return clienteAtual;
    }

    public static void setClienteAtual(Cliente clienteAtual) {
        BancoDeDadosClientes.clienteAtual = clienteAtual;
    }    

    // escreve uma linha nova no arquivo contendo os dados do cliente
    public void adicionarPessoa(Cliente cliente) { 
        try (FileWriter fw = new FileWriter(arquivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(cliente.toString());           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // chamada pela AreaCliente, usa o cliente logado para achar todos os aluguéis dele
    public static ArrayList<Alugar> getHistoricoCliente(String clienteCPF){
        ArrayList<Alugar> historico = new ArrayList<>();
        
        for(Alugar tempAluguel : Pedido.getMapPedidos().values()){
            if(clienteCPF.equals(tempAluguel.getClienteCPF())){
                historico.add(tempAluguel);
            }
        }
    
        return historico;
    }
    
    // busca um cliente pelo CPF e o remove
    //reescreve o arquivo com todas as linhas menos uma (a linha que contém o CPF buscado)
    public void removerPessoa(String CPF) {
        ArrayList<String> linhas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                if (!linha.contains(CPF)) {
                    linhas.add(linha);
                } 
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

    // retorna uma lista com todos os clientes armazenados no banco de dados
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
    
    // encontra o cliente a partir do seu CPF
    @Override
    public ArrayList<String> buscarPessoa(String CPF) {
        ArrayList<String> lista = new ArrayList<>(); 

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                if (linha.contains(CPF)) {
                    lista.add(linha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }
}