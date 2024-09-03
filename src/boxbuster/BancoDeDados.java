package boxbuster;

import java.util.ArrayList;
/**
 *
 * @author elisrb
 */
public interface BancoDeDados {    
    public ArrayList<String> lerPessoas();
    public ArrayList<String> buscarPessoa(String busca);
}
