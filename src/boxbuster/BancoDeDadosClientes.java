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
    
    private static Cliente cliente_atual;

    public static Cliente getCliente_atual() {
        return cliente_atual;
    }

    public static void setCliente_atual(Cliente cliente_atual) {
        BancoDeDadosClientes.cliente_atual = cliente_atual;
    }
    
    
    

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
    
    public void removerPessoa(String CPF) {
        ArrayList<String> linhas = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            boolean encontrouCPF = false;

            while ((linha = br.readLine()) != null) {
                if (linha.contains(CPF)) {
                    encontrouCPF = true;
                    while (!linha.equals("-------------------------------------------")) {
                        linha = br.readLine(); 
                    }
                    linha = br.readLine();
                    
                } else {
                    linhas.add(linha); 
                }
            }

            if (!encontrouCPF) {
                System.out.println("Cliente com CPF " + CPF + " não encontrado.");
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
    
    public void adicionarItem(String CPF, ArrayList<String> itens) {
        ArrayList<String> linhas = new ArrayList<>();
        Collections.reverse(itens);
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
           

            while ((linha = br.readLine()) != null) {
                if (linha.contains(CPF)) {
                    linhas.add(linha); 
                    for (String novaLinha : itens) {
                        linhas.add(novaLinha); 
                    }
                    while (!linha.equals("-------------------------------------------")) {
                        linha = br.readLine(); 
                    }
                } else {
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





