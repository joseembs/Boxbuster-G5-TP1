package boxbuster;

import java.util.Date;
/**
 *
 * @author elisrb
 */


public class Gerente extends Funcionario {

    public Gerente(String nome) {
        super(nome);
    }

    public Gerente(String senha, int codigoFunc, String nome, String cpf, Date dataNascimento) {
        super(senha, codigoFunc, nome, cpf, dataNascimento);
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
        return super.toString() + "_Gerente";
    }
}
