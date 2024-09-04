package boxbuster;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
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
    private ArrayList<Status> listaStatus;

    public Alugar(String pagamentoIn, String codigoCaixa) {
        this.codigoPedido = Pedido.getCodigoPedido();
        
        this.dataPedido = new Date();
        
        Calendar endDate = Calendar.getInstance();
        endDate.setTime(dataPedido);
        endDate.add(Calendar.DATE, 30);
        dataDevolucao = endDate.getTime();
        
        this.pagamento = pagamentoIn;
        
        this.clienteCPF = BancoDeDadosClientes.getClienteAtual().getCPF();
        
        this.caixaCodigo = codigoCaixa;
        
        this.listaProdutos = Pedido.getPedidoAtual();
        
        this.listaStatus = new ArrayList<>();
        for(Produtos prod : listaProdutos){
            listaStatus.add(Status.ALUGADO);
        }
    }

    public Alugar(String codigoPedido, String dataPedido, String dataDevolucao, String pagamento, String clienteCPF, String caixaCodigo, String codigos, String status) {
        this.codigoPedido = Integer.parseInt(codigoPedido);
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            this.dataPedido = formato.parse(dataPedido);
            this.dataDevolucao = formato.parse(dataDevolucao);
        } catch (ParseException e) {
            System.out.println("Erro convertendo data:" + e.getMessage());
        }
        
        this.pagamento = pagamento;
        this.clienteCPF = clienteCPF;
        this.caixaCodigo = caixaCodigo;
        
        String[] codigosFile = codigos.split(" ");
        ArrayList<Produtos> listaProdutosTemp = new ArrayList<>();
        
        for(int i = 0; i < codigosFile.length; i++){
            Produtos tempProduto = Estoque.getProdutoPorCodigo(Integer.parseInt(codigosFile[i]));
            listaProdutosTemp.add(tempProduto);
        }
        this.listaProdutos = listaProdutosTemp;
        
        
        String[] statusFile = status.split(" ");
        ArrayList<Status> listaStatusTemp = new ArrayList<>();
        
        for(int i = 0; i < statusFile.length; i++){
            listaStatusTemp.add(Status.valueOf(statusFile[i]));
        } 
        
        this.listaStatus = listaStatusTemp;
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

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public ArrayList<Status> getListaStatus() {
        return listaStatus;
    }

    public void setListaStatus(ArrayList<Status> listaStatus) {
        this.listaStatus = listaStatus;
    }    

    public Status getProdutoStatus(int codigoProd){
        int ind = -1;
        
        for(int i = 0; i < this.listaProdutos.size(); i++){
            Produtos tempProd = this.listaProdutos.get(i);
            
            if(codigoProd == tempProd.getCodigoProd()){
                ind = i;
                break;
            }
        }

        return listaStatus.get(ind);
    }
    
    public void setProdutoStatus(int codigoProd, Status status){
        int ind = -1;
        
        for(int i = 0; i < this.listaProdutos.size(); i++){
            Produtos tempProd = this.listaProdutos.get(i);
            
            if(codigoProd == tempProd.getCodigoProd()){
                ind = i;
                break;
            }
        }

        listaStatus.set(ind, status);
    }
    
    @Override
    public String toString() {
        String codigosProd = "";
        String statusProd = "";
        
        for(int i = 0; i < listaProdutos.size(); i++){
            Produtos prod = listaProdutos.get(i);
            codigosProd = codigosProd + Integer.toString(prod.getCodigoProd()) + " ";
            
            Status status = listaStatus.get(i);
            statusProd = statusProd + status + " ";
        }
        
        codigosProd = codigosProd.substring(0, codigosProd.length() - 1);
        statusProd = statusProd.substring(0, statusProd.length() - 1);
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String data1 = formato.format(dataPedido);
        String data2 = formato.format(dataDevolucao);
        
        return Integer.toString(codigoPedido) + "_" + data1 + "_" + data2 + "_" + pagamento + "_" + clienteCPF + "_" + caixaCodigo + "_" + codigosProd + "_" + statusProd;
    }
}
