package boxbuster;
import java.util.Date;
/**
 *
 * @author elisrb
 */
public abstract class Pessoa {
    protected String nome;
    protected int cpf;
    protected Date dataNascimento;

    public Pessoa(){
    }
    
    public Pessoa(String nome, int cpf, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return nome + " " + cpf + " " + dataNascimento;
    }
    
    
}
