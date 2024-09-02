/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import boxbuster.Alugar;
import boxbuster.BancoDeDadosClientes;
import boxbuster.Cliente;
import boxbuster.Pedido;
import boxbuster.Produtos;
import boxbuster.Status;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class AreaCliente extends javax.swing.JFrame {

    Cliente clienteAtual = BancoDeDadosClientes.getClienteAtual();
    BancoDeDadosClientes bdClientes = new BancoDeDadosClientes("clientes.txt");
    ArrayList<Alugar> histAlugueis = BancoDeDadosClientes.getHistoricoCliente(clienteAtual.getCPF());
    int alugados = 0;
    /**
     * Creates new form AreaCliente
     */
    public AreaCliente() { //Inicia a tela e suas labels
        setLocationRelativeTo(null);
        initComponents();
        updateHistList();
        BancoDeDadosClientes.getClienteAtual().calculaDivida();
        bdClientes.removerPessoa(BancoDeDadosClientes.getClienteAtual().getCPF());
        bdClientes.adicionarPessoa(BancoDeDadosClientes.getClienteAtual());
        lblNome.setText("Nome: " + BancoDeDadosClientes.getClienteAtual().getNome());
        lblCPF.setText("CPF: " + BancoDeDadosClientes.getClienteAtual().getCPF());
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatador.format(BancoDeDadosClientes.getClienteAtual().getDataNascimento());
        lblDataNasc.setText("Data de nasc.: " + dataFormatada);
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataNascimento = BancoDeDadosClientes.getClienteAtual().getDataNascimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int idade = Period.between(dataNascimento, dataAtual).getYears();
        lblIdade.setText("Idade: " + String.valueOf(idade));
        lblDivida.setText("Divida: R$ " + String.valueOf(BancoDeDadosClientes.getClienteAtual().getDivida()) + "0");
        
        btnDevolver.setEnabled(false);
    }

    private void updateHistList() { // cria a tabela de produtos
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        histAlugueis = BancoDeDadosClientes.getHistoricoCliente(clienteAtual.getCPF());
        BancoDeDadosClientes.getClienteAtual().setAlugados(histAlugueis);
        int contAlugados = 0;
        
        DefaultTableModel tabela = new DefaultTableModel(new Object[] {"Pedido", "Produto", "Tipo", "Data Inicial", "Devolução", "Preço", "Dívida", "Status"}, 0);
        for(int i = 0; i < histAlugueis.size(); i++){
            Alugar aluguel = histAlugueis.get(i);
            System.out.println(aluguel);
            for(int j = 0; j < histAlugueis.get(i).getListaProdutos().size(); j++){
                LocalDate dataAtual = LocalDate.now();
                Date dataDevolucao = aluguel.getDataDevolucao();
                LocalDate localDateDevolucao = dataDevolucao.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int codigoAluguel = (Integer) aluguel.getCodigoPedido();
                Produtos item = aluguel.getListaProdutos().get(j);
                Status status = aluguel.getProdutoStatus(item.getCodigoProd());
                int codigoProduto = item.getCodigoProd();
                if (localDateDevolucao.isBefore(dataAtual)){
                    if(status == Status.ALUGADO){
                        status = Status.ATRASADO;
                        aluguel.setProdutoStatus(codigoProduto, Status.ATRASADO);
                        Pedido.addStatus(codigoAluguel, aluguel);
                        Pedido.reescreverAlugueis();
                    }
                } 
                double divida = 0;
                if(status == Status.ATRASADO){
                    if(BancoDeDadosClientes.getClienteAtual().getClass().getSimpleName().equals("Cadastrado")){
                        divida = (item.getPreco() / 2)* 0.9;
                    }
                    else{
                        divida = item.getPreco() / 2;
                        
                    }
                    
                }
                if(status == Status.ALUGADO || status == Status.ATRASADO){
                    contAlugados++;
                }
                Object linha[] = new Object[]{
                aluguel.getCodigoPedido(),
                item.getNomeProd(),
                item.getClass().getSimpleName(), 
                formato.format(aluguel.getDataPedido()),
                formato.format(aluguel.getDataDevolucao()),
                item.getPreco(),
                divida,
                status};

               tabela.addRow(linha);
            }
                    
                    
        
        tableAluguel.setModel(tabela);  
        }
        lblProdutosAlugados.setText("Produtos Alugados: " + String.valueOf(contAlugados));
        alugados = contAlugados;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAreaCliente = new javax.swing.JPanel();
        lblInfo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblDataNasc = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        lblIdade = new javax.swing.JLabel();
        lblDivida = new javax.swing.JLabel();
        lblProdutosAlugados = new javax.swing.JLabel();
        btnDeslogar = new javax.swing.JButton();
        btnLojaMain = new javax.swing.JButton();
        logoBoxbuster = new javax.swing.JLabel();
        separator2AreaCli = new javax.swing.JSeparator();
        lblHistAluguel = new javax.swing.JLabel();
        scrlAluguel = new javax.swing.JScrollPane();
        tableAluguel = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnDevolver = new javax.swing.JButton();
        lblPagamento = new javax.swing.JLabel();
        cmbPagamento = new javax.swing.JComboBox<>();
        menuBarAreaCli = new javax.swing.JMenuBar();
        menuAreaCli = new javax.swing.JMenu();
        menuVoltarAreaCli = new javax.swing.JMenuItem();
        separator1AreaCli = new javax.swing.JPopupMenu.Separator();
        menuSairAreaCli = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Área do cliente");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/boxLogo.png")).getImage());

        pnlAreaCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Área do Cliente"));

        lblInfo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblInfo.setText("Suas informações:");

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("Nome: -----");

        lblDataNasc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDataNasc.setText("Data de nasc.: 00/00/0000");

        lblCPF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCPF.setText("CPF: 000.000.000-00");

        lblIdade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIdade.setText("Idade: --");

        lblDivida.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDivida.setText("Dívida: R$ --,--");

        lblProdutosAlugados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblProdutosAlugados.setText("Produtos Alugados: --");

        btnDeslogar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDeslogar.setText("Deslogar");
        btnDeslogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeslogarActionPerformed(evt);
            }
        });

        btnLojaMain.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLojaMain.setText("Ir para a loja");
        btnLojaMain.setToolTipText("Ver produtos");
        btnLojaMain.setRequestFocusEnabled(false);
        btnLojaMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLojaMainActionPerformed(evt);
            }
        });

        logoBoxbuster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/boxLogoBig.png"))); // NOI18N

        lblHistAluguel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblHistAluguel.setText("Histórico de Aluguel:");

        scrlAluguel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scrlAluguelMouseClicked(evt);
            }
        });

        tableAluguel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pedido", "Produto", "Tipo", "Data Inicial", "Devolução", "Preço", "Dívida", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrlAluguel.setViewportView(tableAluguel);

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnDevolver.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDevolver.setText("Devolver");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

        lblPagamento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPagamento.setText("Forma de pagamento: ");

        cmbPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Cartão", "Pix" }));
        cmbPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPagamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAreaClienteLayout = new javax.swing.GroupLayout(pnlAreaCliente);
        pnlAreaCliente.setLayout(pnlAreaClienteLayout);
        pnlAreaClienteLayout.setHorizontalGroup(
            pnlAreaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrlAluguel)
            .addGroup(pnlAreaClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAreaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separator2AreaCli)
                    .addGroup(pnlAreaClienteLayout.createSequentialGroup()
                        .addGroup(pnlAreaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAreaClienteLayout.createSequentialGroup()
                                .addGroup(pnlAreaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCPF)
                                    .addComponent(lblNome)
                                    .addComponent(lblDivida))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addGroup(pnlAreaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIdade)
                                    .addComponent(lblDataNasc)
                                    .addComponent(lblProdutosAlugados))
                                .addGap(60, 60, 60))
                            .addGroup(pnlAreaClienteLayout.createSequentialGroup()
                                .addGroup(pnlAreaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlAreaClienteLayout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(lblInfo))
                                    .addGroup(pnlAreaClienteLayout.createSequentialGroup()
                                        .addComponent(btnDeslogar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEditar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLojaMain)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(logoBoxbuster)
                        .addGap(35, 35, 35))
                    .addGroup(pnlAreaClienteLayout.createSequentialGroup()
                        .addComponent(lblHistAluguel)
                        .addGap(53, 53, 53)
                        .addComponent(lblPagamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlAreaClienteLayout.setVerticalGroup(
            pnlAreaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAreaClienteLayout.createSequentialGroup()
                .addGroup(pnlAreaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoBoxbuster, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlAreaClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblInfo)
                        .addGap(18, 18, 18)
                        .addGroup(pnlAreaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome)
                            .addComponent(lblDataNasc))
                        .addGap(18, 18, 18)
                        .addGroup(pnlAreaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCPF)
                            .addComponent(lblIdade))
                        .addGap(18, 18, 18)
                        .addGroup(pnlAreaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDivida)
                            .addComponent(lblProdutosAlugados))
                        .addGap(18, 18, 18)
                        .addGroup(pnlAreaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDeslogar)
                            .addComponent(btnLojaMain)
                            .addComponent(btnEditar))))
                .addGap(6, 6, 6)
                .addComponent(separator2AreaCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAreaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHistAluguel)
                    .addComponent(btnDevolver)
                    .addComponent(lblPagamento)
                    .addComponent(cmbPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrlAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );

        menuAreaCli.setText("Menu");

        menuVoltarAreaCli.setText("Voltar");
        menuVoltarAreaCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVoltarAreaCliActionPerformed(evt);
            }
        });
        menuAreaCli.add(menuVoltarAreaCli);
        menuAreaCli.add(separator1AreaCli);

        menuSairAreaCli.setText("Sair");
        menuSairAreaCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairAreaCliActionPerformed(evt);
            }
        });
        menuAreaCli.add(menuSairAreaCli);

        menuBarAreaCli.add(menuAreaCli);

        setJMenuBar(menuBarAreaCli);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAreaCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAreaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 445, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //volta pra área do cliente
    private void menuVoltarAreaCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVoltarAreaCliActionPerformed
        new TelaPrincipal().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menuVoltarAreaCliActionPerformed
    
    //vai pra loja se o cliente não tiver dívida
    private void btnLojaMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLojaMainActionPerformed
        if(BancoDeDadosClientes.getClienteAtual().getDivida() > 0){
            JOptionPane.showMessageDialog(null, "Primeiro pague a dívida antes de usar a loja", "Mensagem", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            new Loja().setVisible(true);
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_btnLojaMainActionPerformed
    
    // desloga da conta do cliente
    private void btnDeslogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeslogarActionPerformed
        BancoDeDadosClientes.setClienteAtual(null);
        new TelaPrincipal().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDeslogarActionPerformed
    
   
    private void menuSairAreaCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairAreaCliActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSairAreaCliActionPerformed
    
    
    // vai pra tela de editar informações do cliente
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        new EditarCliente().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnEditarActionPerformed
    
    // usado para devolver item alugado ou atrasado e pagar a dívida
    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        int index = tableAluguel.getSelectedRow();
        
        if(index >= 0){
            histAlugueis = BancoDeDadosClientes.getHistoricoCliente(clienteAtual.getCPF());

            int codigoAluguel = (Integer) (tableAluguel.getModel().getValueAt(index, 0));

            String nomeProd = (String) (tableAluguel.getModel().getValueAt(index, 1));

            for(int i = 0; i < histAlugueis.size(); i++){
                Alugar aluguel = histAlugueis.get(i);

                if(codigoAluguel == aluguel.getCodigoPedido()){
                    for(Produtos prod : aluguel.getListaProdutos()){

                        if(nomeProd.equals(prod.getNomeProd())){
                            int index2 = aluguel.getListaProdutos().indexOf(prod);

                            int codigoProduto = prod.getCodigoProd();

                            Status oldStatus = aluguel.getListaStatus().get(index2);

                            if(oldStatus == Status.DEVOLVIDO){
                                JOptionPane.showMessageDialog(null, "Esse produto já foi devolvido!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                            }
                            else {
                                aluguel.setProdutoStatus(codigoProduto, Status.DEVOLVIDO);
                                Pedido.addStatus(codigoAluguel, aluguel);
                                Pedido.reescreverAlugueis();
                                break;
                            }
                        }
                    }
                }
            }
            BancoDeDadosClientes.getClienteAtual().setAlugados(histAlugueis);
            BancoDeDadosClientes.getClienteAtual().calculaDivida();
            lblDivida.setText("Divida: R$ " + String.valueOf(BancoDeDadosClientes.getClienteAtual().getDivida()) + "0");
            updateHistList();

            index = -1;
        }
    }//GEN-LAST:event_btnDevolverActionPerformed

    private void scrlAluguelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scrlAluguelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_scrlAluguelMouseClicked
    
    // usado para definir o pagamento
    private void cmbPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPagamentoActionPerformed
        if(cmbPagamento.getSelectedIndex() == 0){
            btnDevolver.setEnabled(false);
        } else {
            btnDevolver.setEnabled(true);
        }
    }//GEN-LAST:event_cmbPagamentoActionPerformed

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
            java.util.logging.Logger.getLogger(AreaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AreaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AreaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AreaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AreaCliente().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeslogar;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLojaMain;
    private javax.swing.JComboBox<String> cmbPagamento;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblDataNasc;
    private javax.swing.JLabel lblDivida;
    private javax.swing.JLabel lblHistAluguel;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPagamento;
    private javax.swing.JLabel lblProdutosAlugados;
    private javax.swing.JLabel logoBoxbuster;
    private javax.swing.JMenu menuAreaCli;
    private javax.swing.JMenuBar menuBarAreaCli;
    private javax.swing.JMenuItem menuSairAreaCli;
    private javax.swing.JMenuItem menuVoltarAreaCli;
    private javax.swing.JPanel pnlAreaCliente;
    private javax.swing.JScrollPane scrlAluguel;
    private javax.swing.JPopupMenu.Separator separator1AreaCli;
    private javax.swing.JSeparator separator2AreaCli;
    private javax.swing.JTable tableAluguel;
    // End of variables declaration//GEN-END:variables
}
