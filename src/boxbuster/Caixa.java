package boxbuster;
import java.util.Date;
/**
 *
 * @author elisrb
 */
public class Caixa extends Funcionario {
    protected Gerente gerente;

    public Caixa(Gerente gerente, String senha, int codigoFunc, String nome, int cpf, Date dataNascimento) {
        super(senha, codigoFunc, nome, cpf, dataNascimento);
        this.gerente = gerente;
    }

    public Gerente getGerente() {
        return gerente;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }


    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
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

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    
}
