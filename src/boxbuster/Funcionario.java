package boxbuster;
/**
 *
 * @author elisrb
 */
public class Funcionario extends Pessoa {
    protected String senha;
    protected int codigoFunc;

    public Funcionario(String senha, int codigoFunc, String nome, int cpf, int idade) {
        super(nome, cpf, idade);
        this.senha = senha;
        this.codigoFunc = codigoFunc;
    }
}
