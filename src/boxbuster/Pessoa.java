package boxbuster;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author elisrb
 */
public abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected Date dataNascimento;

    public Pessoa(){
    }
    
    public Pessoa(String nome){
        this.nome = nome;
    }
    
    public Pessoa(String nome, String cpf, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formato.format(dataNascimento);
        return nome + " " + cpf + " " + dataFormatada;
    }
        
}
