package boxbuster;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author hsaless
 */

public class BancoDeDadosClientes implements BancoDeDados{
    private String arquivo;
    
    private static Cliente clienteAtual = null;

    public static Cliente getClienteAtual() {
        return clienteAtual;
    }

    public static void setClienteAtual(Cliente cliente_atual) {
        BancoDeDadosClientes.clienteAtual = cliente_atual;
    }
    
    
    

    public BancoDeDadosClientes(String arquivo) {
        this.arquivo = arquivo;
    }

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
    
    
    
 
}





