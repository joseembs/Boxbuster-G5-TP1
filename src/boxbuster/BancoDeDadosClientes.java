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
    
    private static Cliente clienteAtual = null;

    public BancoDeDadosClientes() {
    }
    
    public static Cliente getClienteAtual() {
        return clienteAtual;
    }

    public static void setClienteAtual(Cliente clienteAtual) {
        BancoDeDadosClientes.clienteAtual = clienteAtual;
    }    

    public void adicionarPessoa(Cliente cliente) { // escreve uma linha nova no arquivo contendo os dados do cliente
        try (FileWriter fw = new FileWriter(arquivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(cliente.toString());           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Alugar> getHistoricoCliente(String clienteCPF){// chamada pela AreaCliente, usa o cliente logado para achar todos os aluguéis dele
        ArrayList<Alugar> historico = new ArrayList<>();
        
        for(Alugar tempAluguel : Pedido.getMapPedidos().values()){
            if(clienteCPF.equals(tempAluguel.getClienteCPF())){
                historico.add(tempAluguel);
            }
        }
    
        return historico;
    }
    
    public void removerPessoa(String CPF) {// busca um cliente pelo CPF e o remove
        //reescreve o arquivo com todas as linhas menos uma (a linha que contém o CPF buscado)
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

    @Override
    public ArrayList<String> lerPessoas() {// retorna uma lista com todos os clientes armazenados no banco de dados
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
    public ArrayList<String> buscarPessoa(String CPF) {// encontra o cliente a partir do seu CPF
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