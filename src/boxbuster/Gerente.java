package boxbuster;
/**
 *
 * @author elisrb
 */
import java.util.ArrayList; // import the ArrayList class

public class Gerente extends Funcionario {
    protected ArrayList<Caixa> caixas;

    public Gerente(/*Caixa[] caixas,*/ String senha, int codigoFunc, String nome, int cpf, int idade) {
        super(senha, codigoFunc, nome, cpf, idade);
        this.caixas = new ArrayList<Caixa>();
    }

    public ArrayList<Caixa> getCaixas() {
        return caixas;
    }

    public String getSenha() {
        return senha;
    }

    public int getCodigoFunc() {
        return codigoFunc;
    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setCaixas(Caixa caixa) {
        this.caixas.add(caixa);
        caixa.setGerente(this);
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCodigoFunc(int codigoFunc) {
        this.codigoFunc = codigoFunc;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
      
}
