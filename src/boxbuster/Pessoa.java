package boxbuster;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author elisrb
 */
public abstract class Pessoa {
    private String nome;
    private String cpf;
    private Date dataNascimento;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formato.format(dataNascimento);
        return nome + "_" + cpf + "_" + dataFormatada;
    }
}
