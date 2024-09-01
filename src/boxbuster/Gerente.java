package boxbuster;

import java.util.ArrayList;// import the ArrayList class
import java.util.Date;
/**
 *
 * @author elisrb
 */


public class Gerente extends Funcionario {
    protected ArrayList<Caixa> caixas;

    public Gerente(String nome) {
        super(nome);
        this.caixas = new ArrayList<Caixa>();
    }

    public Gerente(String senha, int codigoFunc, String nome, String cpf, Date dataNascimento) {
        super(senha, codigoFunc, nome, cpf, dataNascimento);
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

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        String aux = super.toString() + "_Gerente_gerencia";
        if(!caixas.isEmpty()){
            for (Caixa caixa : caixas) {
                aux += "_" + caixa.getNome();
            }
        }
        return aux;
    }
}
