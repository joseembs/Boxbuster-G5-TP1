package telas;

import boxbuster.BancoDeDadosClientes;
import boxbuster.BancoDeDadosFuncionarios;
import boxbuster.Cadastrado;
import boxbuster.Pedido;
import boxbuster.Produtos;
import boxbuster.Visitante;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author josembs
 */
public class FinalizarPedido extends javax.swing.JFrame {

    // recupera o carrinho atual do cliente
    private ArrayList<Produtos> listaPedido = Pedido.getPedidoAtual();
    
    double valorTotal = 0;
    
    int rowClick = -1;
    
    BancoDeDadosClientes bdClientes = new BancoDeDadosClientes();
    
    /**
     * Creates new form FinalizarPedido
     */
    public FinalizarPedido() {
        
        setLocationRelativeTo(null);
        initComponents();
        
        updateProdTable();
        updateCmbCaixa();
        
        startFields();
        
        setDates();
        
        lblValor.setText("Valor total: R$ " + valorTotal + "0");
    }
    
    // inicia os campos relacionados à identificação e seus estados
    private void startFields() {
        if(BancoDeDadosClientes.getClienteAtual() == null){
            cmbSituacao.setEnabled(true);
            cmbSituacao.setSelectedIndex(0);
            
            txtfCPF.setText("");
            txtfSenha.setText("");
            txtfNome.setText("");
            txtfDataNascimento.setText("");
            
            txtfNome.setEnabled(false);
            lblNome.setVisible(false);
            txtfNome.setVisible(false);
            lblCPF.setVisible(false);
            txtfCPF.setEnabled(false);
            txtfCPF.setVisible(false);
            lblDataNascimento.setVisible(false);
            txtfDataNascimento.setEnabled(false);
            txtfDataNascimento.setVisible(false);
            lblSenha.setVisible(false);
            txtfSenha.setVisible(false);
            txtfSenha.setEnabled(false);
            btnLogin.setEnabled(false);
            btnLogin.setVisible(false);
            btnLogout.setEnabled(false);
        } else {
            cmbSituacao.setEnabled(false);
            lblSenha.setVisible(false);
            txtfSenha.setVisible(false);
            txtfSenha.setEnabled(false);
            txtfNome.setEnabled(false);
            lblNome.setVisible(true);
            txtfNome.setVisible(true);
            txtfNome.setText(BancoDeDadosClientes.getClienteAtual().getNome());
            lblUsuario.setText("Usuário atual: " + BancoDeDadosClientes.getClienteAtual().getNome());
            lblDataNascimento.setVisible(true);
            txtfDataNascimento.setVisible(true);
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            String dataFormatada = formatador.format(BancoDeDadosClientes.getClienteAtual().getDataNascimento());
            txtfDataNascimento.setText(dataFormatada);
            txtfDataNascimento.setEnabled(false);
            txtfCPF.setEnabled(false);
            lblCPF.setVisible(true);
            txtfCPF.setVisible(true);
            txtfCPF.setText(BancoDeDadosClientes.getClienteAtual().getCPF());
            btnLogin.setEnabled(false);
            btnLogout.setEnabled(true);
        }
    }

    // atualiza a lista do carrinho quando necessário
    private void updateProdTable() {   
        DefaultTableModel tabela = new DefaultTableModel(new Object[] {"Nº", "Título", "Preço"}, 0);
        valorTotal = 0;

        for(int i = 0; i < listaPedido.size(); i++){
            Object linha[] = new Object[]{
            i+1,
            listaPedido.get(i).getNomeProd(),
            "R$ " + listaPedido.get(i).getPreco()+ "0"}; 

            tabela.addRow(linha);
            valorTotal += listaPedido.get(i).getPreco();
        }
        
        tableCart.setModel(tabela);
        
        tableCart.getColumnModel().getColumn(0).setPreferredWidth(20);
        tableCart.getColumnModel().getColumn(1).setPreferredWidth(200);
        tableCart.getColumnModel().getColumn(2).setPreferredWidth(60);
        
        lblValor.setText("Valor total: R$ " + valorTotal + "0");
    }
    
    // atualiza combo box com os caixas
    private void updateCmbCaixa(){
        
        cmbCaixa.removeAllItems();
        cmbCaixa.addItem("Selecione");
        
        String[] linha;
        String nomeCaixa;
        
        BancoDeDadosFuncionarios bdFunc = new BancoDeDadosFuncionarios();
        ArrayList<String> funcionarios = bdFunc.lerPessoas();
        
        for(int i=0;i<funcionarios.size();i++){
            linha = funcionarios.get(i).split("_");
            if(linha[5].equals("Caixa")){
                nomeCaixa = linha[4] + "-" + linha[0];
                cmbCaixa.addItem(nomeCaixa);
            }
        }
    }
    
    // recupera a data atual e a data de devolução
    private void setDates() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAtual = new Date();
        
        String dataAtualForm = formatador.format(dataAtual);
        lblDataAtual.setText("Data atual: " + dataAtualForm);
        
        Calendar endDate = Calendar.getInstance();
        endDate.setTime(dataAtual);
        endDate.add(Calendar.DATE, 30);
        
        Date dataDevolucao = endDate.getTime();
        
        String dataFinalForm = formatador.format(dataDevolucao);
        lblDataFinal.setText("Data máx. de devolução: " + dataFinalForm);
    }
    
    // confere se todas as informações necessárias para finalizar o pedido foram determinadas
    private void checkFim() {
        if(BancoDeDadosClientes.getClienteAtual() != null && !Pedido.getPedidoAtual().isEmpty() && cmbPagamento.getSelectedIndex() > 0 && cmbCaixa.getSelectedIndex() >0){
            btnFinalizar.setEnabled(true);
        } else {
            btnFinalizar.setEnabled(false);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCart = new javax.swing.JPanel();
        lblIdentificacao = new javax.swing.JLabel();
        lblSituacao = new javax.swing.JLabel();
        cmbSituacao = new javax.swing.JComboBox<>();
        lblNome = new javax.swing.JLabel();
        txtfNome = new javax.swing.JTextField();
        lblCPF = new javax.swing.JLabel();
        txtfCPF = new javax.swing.JFormattedTextField();
        lblDataNascimento = new javax.swing.JLabel();
        txtfDataNascimento = new javax.swing.JFormattedTextField();
        lblSenha = new javax.swing.JLabel();
        txtfSenha = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        separator2Cart = new javax.swing.JSeparator();
        lblCart = new javax.swing.JLabel();
        scrlCart = new javax.swing.JScrollPane();
        tableCart = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        separator3Cart = new javax.swing.JSeparator();
        lblFinalizacao = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        lblPagamento = new javax.swing.JLabel();
        cmbPagamento = new javax.swing.JComboBox<>();
        lblDataAtual = new javax.swing.JLabel();
        lblDataFinal = new javax.swing.JLabel();
        lblCaixa = new javax.swing.JLabel();
        cmbCaixa = new javax.swing.JComboBox<>();
        lblFilial = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        menuBarCart = new javax.swing.JMenuBar();
        menuCart = new javax.swing.JMenu();
        menuVoltarCart = new javax.swing.JMenuItem();
        separator1Cart = new javax.swing.JPopupMenu.Separator();
        menuSairCart = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pedido");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/boxLogo.png")).getImage());

        lblIdentificacao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblIdentificacao.setText("Identificação:");

        lblSituacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSituacao.setText("Já possui cadastro?");

        cmbSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma opção", "Quero me cadastrar", "Não quero me cadastrar", "Sim" }));
        cmbSituacao.setToolTipText("");
        cmbSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSituacaoActionPerformed(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("Nome:");

        txtfNome.setEnabled(false);

        lblCPF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCPF.setText("CPF:");

        try {
            txtfCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtfCPF.setEnabled(false);

        lblDataNascimento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDataNascimento.setText("Data de nasc.: ");

        try {
            txtfDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtfDataNascimento.setEnabled(false);

        lblSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSenha.setText("Senha:");

        txtfSenha.setEnabled(false);

        btnLogin.setText("Entrar");
        btnLogin.setEnabled(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        separator2Cart.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblCart.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCart.setText("Carrinho:");

        tableCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Título", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCartMouseClicked(evt);
            }
        });
        scrlCart.setViewportView(tableCart);
        if (tableCart.getColumnModel().getColumnCount() > 0) {
            tableCart.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableCart.getColumnModel().getColumn(1).setPreferredWidth(200);
            tableCart.getColumnModel().getColumn(2).setPreferredWidth(60);
        }

        btnExcluir.setText("Remover produto");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblFinalizacao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFinalizacao.setText("Finalização:");

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUsuario.setText("Usuário atual: -----");

        btnLogout.setText("Sair");
        btnLogout.setEnabled(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        lblPagamento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPagamento.setText("Forma de pagamento:");

        cmbPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Cartão", "Pix" }));
        cmbPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPagamentoActionPerformed(evt);
            }
        });

        lblDataAtual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDataAtual.setText("Data atual: XX/XX/XXXX");

        lblDataFinal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDataFinal.setText("Data máx. de devolução: XX/XX/XXXX");

        lblCaixa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCaixa.setText("Caixa:");

        cmbCaixa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cmbCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCaixaActionPerformed(evt);
            }
        });

        lblFilial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFilial.setText("Filial: UnB - Darcy Ribeiro");

        lblValor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblValor.setText("Valor total: R$ --.--");

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnFinalizar.setText("Finalizar compra");
        btnFinalizar.setEnabled(false);
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCartLayout = new javax.swing.GroupLayout(pnlCart);
        pnlCart.setLayout(pnlCartLayout);
        pnlCartLayout.setHorizontalGroup(
            pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separator3Cart)
            .addGroup(pnlCartLayout.createSequentialGroup()
                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCartLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCartLayout.createSequentialGroup()
                                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSituacao))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE))
                            .addGroup(pnlCartLayout.createSequentialGroup()
                                .addComponent(lblDataNascimento)
                                .addGap(6, 6, 6)
                                .addComponent(txtfDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnlCartLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCartLayout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addGap(6, 6, 6)
                                .addComponent(txtfNome))
                            .addGroup(pnlCartLayout.createSequentialGroup()
                                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlCartLayout.createSequentialGroup()
                                        .addComponent(lblCPF)
                                        .addGap(6, 6, 6)
                                        .addComponent(txtfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(pnlCartLayout.createSequentialGroup()
                                        .addComponent(lblSenha)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtfSenha)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLogin))))
                    .addGroup(pnlCartLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(lblIdentificacao)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(12, 12, 12)
                .addComponent(separator2Cart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCartLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(lblCart)
                        .addGap(125, 125, 125))
                    .addGroup(pnlCartLayout.createSequentialGroup()
                        .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCartLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrlCart, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCartLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(btnExcluir)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCartLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCartLayout.createSequentialGroup()
                        .addComponent(btnVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFinalizar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCartLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblFinalizacao)
                        .addGap(270, 270, 270))
                    .addGroup(pnlCartLayout.createSequentialGroup()
                        .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDataFinal)
                            .addComponent(lblDataAtual)
                            .addGroup(pnlCartLayout.createSequentialGroup()
                                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPagamento)
                                    .addComponent(lblUsuario))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValor)
                            .addComponent(lblFilial)
                            .addGroup(pnlCartLayout.createSequentialGroup()
                                .addComponent(lblCaixa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(138, 138, 138))))
        );
        pnlCartLayout.setVerticalGroup(
            pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCartLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCartLayout.createSequentialGroup()
                        .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCart)
                            .addComponent(lblIdentificacao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCartLayout.createSequentialGroup()
                                .addComponent(lblSituacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNome)
                                    .addComponent(txtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCPF)
                                    .addComponent(txtfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDataNascimento)
                                    .addComponent(txtfDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSenha)
                                    .addComponent(txtfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLogin)))
                            .addGroup(pnlCartLayout.createSequentialGroup()
                                .addComponent(scrlCart, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnExcluir)
                                    .addComponent(btnCancelar))))
                        .addGap(12, 12, 12))
                    .addGroup(pnlCartLayout.createSequentialGroup()
                        .addComponent(separator2Cart, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(separator3Cart, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFinalizacao)
                .addGap(9, 9, 9)
                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(btnLogout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPagamento)
                    .addComponent(cmbPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCaixa)
                    .addComponent(cmbCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataAtual)
                    .addComponent(lblFilial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataFinal)
                    .addComponent(lblValor))
                .addGap(18, 18, 18)
                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnFinalizar))
                .addGap(12, 12, 12))
        );

        menuCart.setText("Menu");

        menuVoltarCart.setText("Voltar");
        menuVoltarCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVoltarCartActionPerformed(evt);
            }
        });
        menuCart.add(menuVoltarCart);
        menuCart.add(separator1Cart);

        menuSairCart.setText("Sair");
        menuSairCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairCartActionPerformed(evt);
            }
        });
        menuCart.add(menuSairCart);

        menuBarCart.add(menuCart);

        setJMenuBar(menuBarCart);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuVoltarCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVoltarCartActionPerformed
        new Loja().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menuVoltarCartActionPerformed

    private void menuSairCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairCartActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSairCartActionPerformed

    // chama a função para processar os dados do pedido e abre a área do cliente
    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        String[] caixaInfo = cmbCaixa.getSelectedItem().toString().split("-");

        Pedido.addPedido(cmbPagamento.getSelectedItem().toString(), caixaInfo[0]);

        new AreaCliente().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        new Loja().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void cmbCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCaixaActionPerformed
        checkFim();
    }//GEN-LAST:event_cmbCaixaActionPerformed

    private void cmbPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPagamentoActionPerformed
        checkFim();
    }//GEN-LAST:event_cmbPagamentoActionPerformed

    // botão cancelar do carrinho
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        checkFim();

        rowClick = -1;

        btnExcluir.setEnabled(false);
        btnCancelar.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    // botão para excluir produto do carrinho
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (rowClick >= 0 && rowClick < Pedido.getPedidoAtual().size()){
            Produtos selectedProd = Pedido.getPedidoAtual().get(rowClick);
            Pedido.getPedidoAtual().remove(selectedProd);

            updateProdTable();
        }

        checkFim();

        rowClick = -1;

        btnExcluir.setEnabled(false);
        btnCancelar.setEnabled(false);
    }//GEN-LAST:event_btnExcluirActionPerformed

    // seleciona um produto do carrinho
    private void tableCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCartMouseClicked
        rowClick = tableCart.getSelectedRow();

        btnExcluir.setEnabled(true);
        btnCancelar.setEnabled(true);
    }//GEN-LAST:event_tableCartMouseClicked

    // analisa como o usuário deseja logar com base na situação dele
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        int index = cmbSituacao.getSelectedIndex();
        
        if(index == 1){
            if(txtfNome.getText().equals("") || txtfCPF.getText().equals("") || txtfDataNascimento.getText().equals("") || txtfSenha.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser inseridos!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
            } else {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String nome = txtfNome.getText();
                String CPF = txtfCPF.getText();
                Date dataNascimento = null;
                String dataNascimentoString = txtfDataNascimento.getText();
                
                try {
                    dataNascimento = formato.parse(dataNascimentoString);
                } catch (ParseException ex) {
                    Logger.getLogger(LoginCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                String senha = txtfSenha.getText();
                Cadastrado cadastrado = new Cadastrado(nome, CPF, dataNascimento, 0, senha);
                
                BancoDeDadosClientes.setClienteAtual(cadastrado);
                bdClientes.adicionarPessoa(cadastrado);
                
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                
                cmbSituacao.setEnabled(false);
                txtfNome.setEnabled(false);
                txtfCPF.setEnabled(false);
                txtfDataNascimento.setEnabled(false);
                txtfSenha.setEnabled(false);
                txtfSenha.setVisible(false);
                lblSenha.setVisible(false);
                btnLogin.setEnabled(false);
            }
        } else if(index == 2){
            if(txtfNome.getText().equals("") || txtfCPF.getText().equals("") || txtfDataNascimento.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser inseridos!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
            } else {
                String CPF = txtfCPF.getText();
                
                ArrayList<String> lista = bdClientes.buscarPessoa(CPF);
                
                if(lista.isEmpty()){
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    String nome = txtfNome.getText();
                    Date dataNascimento = null;
                    String dataNascimentoString = txtfDataNascimento.getText();
                    
                    try {
                        dataNascimento = formato.parse(dataNascimentoString);
                    } catch (ParseException ex) {
                        Logger.getLogger(LoginCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    Visitante visitante = new Visitante(nome, CPF, dataNascimento, 0);
                    
                    bdClientes.adicionarPessoa(visitante);
                    BancoDeDadosClientes.setClienteAtual(visitante);
                    
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                    
                    cmbSituacao.setEnabled(false);
                    txtfNome.setEnabled(false);
                    txtfCPF.setEnabled(false);
                    txtfDataNascimento.setEnabled(false);
                    txtfSenha.setEnabled(false);
                    txtfSenha.setVisible(false);
                    lblSenha.setVisible(false);
                    btnLogin.setEnabled(false);
                } else {
                    Date dataNascimento = null;
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    String[] palavras = lista.get(0).split("_");
                    
                    if (palavras[0].equals("Cadastrado")){
                        JOptionPane.showMessageDialog(null, "Esse CPF está associado a um cadastrado.", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        String nome = palavras[1];
                        String dataNascimentoString = palavras[3];
                        String divida = palavras[4];
                        
                        try {
                            dataNascimento = formato.parse(dataNascimentoString);
                        } catch (ParseException ex) {
                            Logger.getLogger(LoginCliente.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Visitante visitante = new Visitante(nome, CPF, dataNascimento, Double.parseDouble(divida));
                        
                        BancoDeDadosClientes.setClienteAtual(visitante);
                        
                        if(Double.parseDouble(divida) > 0){
                            Pedido.setPedidoAtual(new ArrayList<>());
                            JOptionPane.showMessageDialog(null, "É necessário pagar sua dívida e devolver os\nprodutos atrasados para realizar novos pedidos.", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                            
                            new AreaCliente().setVisible(true);
                            this.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuário entrou com sucesso!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                            
                            cmbSituacao.setEnabled(false);
                            txtfNome.setEnabled(false);
                            txtfCPF.setEnabled(false);
                            txtfDataNascimento.setEnabled(false);
                            txtfSenha.setEnabled(false);
                            txtfSenha.setVisible(false);
                            lblSenha.setVisible(false);
                            btnLogin.setEnabled(false);
                        }
                    }
                }
            }
        } else if(index == 3){
            if(txtfCPF.getText().equals("")|| txtfSenha.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser inseridos!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
            } else {
                String CPF = txtfCPF.getText();
                Date dataNascimento = null;
                String senha = txtfSenha.getText();
                ArrayList<String> lista = bdClientes.buscarPessoa(CPF);
                
                if(lista.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Não existe nenhuma pessoa já cadastrada com esse CPF.", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                } else{
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    String[] palavras = lista.get(0).split("_");
                    
                    if (palavras[0].equals("Visitante")){
                        JOptionPane.showMessageDialog(null, "Esse CPF está associado a um visitante.", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        String nome = palavras[1];
                        String dataNascimentoString = palavras[3];
                        String divida = palavras[4];
                        String senhaChecar = palavras[5];
                        
                        try {
                            dataNascimento = formato.parse(dataNascimentoString);
                        } catch (ParseException ex) {
                            Logger.getLogger(LoginCliente.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        if(!senha.equals(senhaChecar)){
                            JOptionPane.showMessageDialog(null, "A senha está incorreta.", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                        } else {
                            Cadastrado cadastrado = new Cadastrado(nome, CPF, dataNascimento, Double.parseDouble(divida), senha);
                            BancoDeDadosClientes.setClienteAtual(cadastrado);
                            
                            if(Double.parseDouble(divida) > 0){
                                Pedido.setPedidoAtual(new ArrayList<>());
                                JOptionPane.showMessageDialog(null, "É necessário pagar sua dívida e devolver os\nprodutos atrasados para realizar novos pedidos.", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                                
                                new AreaCliente().setVisible(true);
                                this.setVisible(false);
                            } else {
                                JOptionPane.showMessageDialog(null, "Usuário entrou com sucesso!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                                
                                cmbSituacao.setEnabled(false);
                                txtfNome.setEnabled(false);
                                txtfCPF.setEnabled(false);
                                txtfDataNascimento.setEnabled(false);
                                txtfSenha.setEnabled(false);
                                txtfSenha.setVisible(false);
                                lblSenha.setVisible(false);
                                btnLogin.setEnabled(false);
                            }
                        }
                    }
                }
            }
        }
        
        if(BancoDeDadosClientes.getClienteAtual() != null){
            lblUsuario.setText("Usuário atual: " + BancoDeDadosClientes.getClienteAtual().getNome());
            checkFim();
            btnLogout.setEnabled(true);
            updateProdTable();
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    // mudanças realizadas pela combo box de situação
    private void cmbSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSituacaoActionPerformed
        int index = cmbSituacao.getSelectedIndex();
        
        if(index == 1){
            txtfNome.setEnabled(true);
            lblNome.setVisible(true);
            txtfNome.setVisible(true);
            lblCPF.setVisible(true);
            txtfCPF.setVisible(true);
            txtfCPF.setEnabled(true);
            txtfDataNascimento.setEnabled(true);
            lblDataNascimento.setVisible(true);
            txtfDataNascimento.setVisible(true);
            lblSenha.setVisible(true);
            txtfSenha.setVisible(true);
            txtfSenha.setEnabled(true);
            btnLogin.setEnabled(true);
            btnLogin.setVisible(true);
            btnLogin.setText("Cadastrar");
            
        } else if(index == 3){
            txtfNome.setEnabled(false);
            lblNome.setVisible(false);
            txtfNome.setVisible(false);
            lblCPF.setVisible(true);
            txtfCPF.setVisible(true);
            txtfCPF.setEnabled(true);
            txtfDataNascimento.setEnabled(false);
            lblDataNascimento.setVisible(false);
            txtfDataNascimento.setVisible(false);
            lblSenha.setVisible(true);
            txtfSenha.setVisible(true);
            txtfSenha.setEnabled(true);
            btnLogin.setEnabled(true);
            btnLogin.setVisible(true);
            btnLogin.setText("Entrar");
            
        } else if(index == 2){
            txtfNome.setEnabled(true);
            lblNome.setVisible(true);
            txtfNome.setVisible(true);
            lblCPF.setVisible(true);
            txtfCPF.setVisible(true);
            txtfCPF.setEnabled(true);
            txtfDataNascimento.setEnabled(true);
            lblDataNascimento.setVisible(true);
            txtfDataNascimento.setVisible(true);
            lblSenha.setVisible(false);
            txtfSenha.setVisible(false);
            txtfSenha.setEnabled(false);
            btnLogin.setEnabled(true);
            btnLogin.setEnabled(true);
            btnLogin.setVisible(true);
            btnLogin.setText("Cadastrar-se");
            
        } else {
            txtfNome.setEnabled(false);
            lblNome.setVisible(false);
            txtfNome.setVisible(false);
            lblCPF.setVisible(false);
            txtfCPF.setEnabled(false);
            txtfCPF.setVisible(false);
            lblDataNascimento.setVisible(false);
            txtfDataNascimento.setEnabled(false);
            txtfDataNascimento.setVisible(false);
            lblSenha.setVisible(false);
            txtfSenha.setVisible(false);
            txtfSenha.setEnabled(false);
            btnLogin.setEnabled(false);
            btnLogin.setVisible(false);

        }
    }//GEN-LAST:event_cmbSituacaoActionPerformed

    // botão de sair para deslogar o cliente
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        btnLogout.setEnabled(false);
        BancoDeDadosClientes.setClienteAtual(null);
        
        startFields();
        
        updateProdTable();
    }//GEN-LAST:event_btnLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FinalizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinalizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinalizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinalizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinalizarPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cmbCaixa;
    private javax.swing.JComboBox<String> cmbPagamento;
    private javax.swing.JComboBox<String> cmbSituacao;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCaixa;
    private javax.swing.JLabel lblCart;
    private javax.swing.JLabel lblDataAtual;
    private javax.swing.JLabel lblDataFinal;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblFilial;
    private javax.swing.JLabel lblFinalizacao;
    private javax.swing.JLabel lblIdentificacao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPagamento;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSituacao;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblValor;
    private javax.swing.JMenuBar menuBarCart;
    private javax.swing.JMenu menuCart;
    private javax.swing.JMenuItem menuSairCart;
    private javax.swing.JMenuItem menuVoltarCart;
    private javax.swing.JPanel pnlCart;
    private javax.swing.JScrollPane scrlCart;
    private javax.swing.JPopupMenu.Separator separator1Cart;
    private javax.swing.JSeparator separator2Cart;
    private javax.swing.JSeparator separator3Cart;
    private javax.swing.JTable tableCart;
    private javax.swing.JFormattedTextField txtfCPF;
    private javax.swing.JFormattedTextField txtfDataNascimento;
    private javax.swing.JTextField txtfNome;
    private javax.swing.JTextField txtfSenha;
    // End of variables declaration//GEN-END:variables
}
