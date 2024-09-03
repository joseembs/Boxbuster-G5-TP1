package boxbuster;

import java.util.Date;
/**
 *
 * @author elisrb
 */
public class Caixa extends Funcionario {
    private Gerente gerente;

    public Caixa(Gerente gerente, String senha, int codigoFunc, String nome, String cpf, Date dataNascimento) {
        super(senha, codigoFunc, nome, cpf, dataNascimento);
        this.gerente = gerente;
    }
 
    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
    
    @Override
    public String toString() {
        return super.toString() + "_Caixa_" + "Gerenciado_por_" + gerente.getNome();
    }
}
