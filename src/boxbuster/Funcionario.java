package boxbuster;

import java.util.Date;
/**
 *
 * @author elisrb
 */
public abstract class Funcionario extends Pessoa {
    private String senha;
    private int codigoFunc;

    public Funcionario(String senha, int codigoFunc, String nome, String cpf, Date dataNascimento) {
        super(nome, cpf, dataNascimento);
        this.senha = senha;
        this.codigoFunc = codigoFunc;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public int getCodigoFunc() {
        return codigoFunc;
    }

    public void setCodigoFunc(int codigoFunc) {
        this.codigoFunc = codigoFunc;
    }
    
    public Funcionario(String nome){
        super(nome);
    }
    
    @Override
    public String toString() {
        return super.toString() + "_" + senha + "_" + codigoFunc;
    }
}
