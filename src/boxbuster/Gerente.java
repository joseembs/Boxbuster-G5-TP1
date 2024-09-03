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

    @Override
    public String toString() {
        return super.toString() + "_Gerente";
    }
}
