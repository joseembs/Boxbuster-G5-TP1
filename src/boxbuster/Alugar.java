package boxbuster;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import telas.CadastroCliente;


/**
 *
 * @author hsaless
 */
public class Alugar {
    private int codigoPedido;
    private Date dataPedido;
    private Date dataDevolucao;
    private String pagamento;
    private String clienteCPF;
    private String caixaCodigo;
    private ArrayList<Produtos> listaProdutos;

    public Alugar(String pagamentoIn, Caixa caixaIn) {
        this.codigoPedido = Pedido.getCodigoPedido();
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        this.dataPedido = new Date();
        
        Calendar endDate = Calendar.getInstance();
        endDate.setTime(dataPedido);
        endDate.add(Calendar.DATE, 30);
        dataDevolucao = endDate.getTime();
        
        this.pagamento = pagamentoIn;
        
        this.clienteCPF = BancoDeDadosClientes.getCliente_atual().getCPF();
        
        //this.caixaCodigo = caixaIn.get;
        
        this.listaProdutos = Pedido.getPedidoAtual();
    }

    public Alugar(String codigoPedido, String dataPedido, String dataDevolucao, String pagamento, String clienteCPF, String caixaCodigo, String codigos) {
        this.codigoPedido = Integer.parseInt(codigoPedido);
        //this.dataPedido = dataPedido;
        //this.dataDevolucao = dataDevolucao;
        this.pagamento = pagamento;
        this.clienteCPF = clienteCPF;
        this.caixaCodigo = caixaCodigo;
        
        String[] listaCodigos = codigos.split(" ");
        
        ArrayList<Produtos> listaProdutos = new ArrayList<>();
        for(int i = 0; i < listaCodigos.length; i++){
            listaProdutos.add(Estoque.getProdutoPorCodigo(Integer.parseInt(listaCodigos[i])));
        }
        this.listaProdutos = listaProdutos;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }
    
    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getClienteCPF() {
        return clienteCPF;
    }

    public void setClienteCPF(String clienteCPF) {
        this.clienteCPF = clienteCPF;
    }

    public String getCaixaCodigo() {
        return caixaCodigo;
    }

    public void setCaixaCodigo(String caixaCodigo) {
        this.caixaCodigo = caixaCodigo;
    }
    
    public ArrayList<Produtos> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(ArrayList<Produtos> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
    
    @Override
    public String toString() {
        String codigosProd = "";
        
        for(Produtos prod : listaProdutos){
            codigosProd = codigosProd + " " + Integer.toString(prod.getCodigoProd());
        }
        
        return Integer.toString(codigoPedido) + "_" + dataPedido + "_" + dataDevolucao + codigosProd;
    }
}
