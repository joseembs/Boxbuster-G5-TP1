package boxbuster;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class BancoDeDadosClientes {
    private String arquivo;

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
    
    public String buscarPessoa(String CPF) {
    try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
        String linha;
        while ((linha = br.readLine()) != null) {
            if (linha.contains(CPF)) {
                return linha;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    return "Pessoa não encontrada"; 
}

}

