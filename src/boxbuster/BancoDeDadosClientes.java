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

public class BancoDeDadosClientes implements BancoDeDados{
    private String arquivo;

    public BancoDeDadosClientes(String arquivo) {
        this.arquivo = arquivo;
    }

    public void adicionarPessoa(Cliente cliente) {
    try (FileWriter fw = new FileWriter(arquivo, true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter out = new PrintWriter(bw)) {
        out.println(cliente.toString());
        out.println("-------------------------------------------"); 
    } catch (IOException e) {
        e.printStackTrace();
    }
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
            boolean encontrouCPF = false;

            while ((linha = br.readLine()) != null) {
                if (linha.contains(CPF)) {
                    encontrouCPF = true; 
                }

                if (encontrouCPF) {
                    if (linha.equals("-------------------------------------------")) {
                        break;
                    }
                    lista.add(linha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }
    
 
}



