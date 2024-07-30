package boxbuster;

/**
 *
 * @author elisrb
 */
public abstract class Pessoa {
    protected String nome;
    protected int cpf;
    protected int idade;

    public Pessoa(){
    }
    
    public Pessoa(String nome, int cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }
}
