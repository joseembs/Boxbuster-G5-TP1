package telas;

import boxbuster.Estoque;
import boxbuster.BancoDeDadosFuncionarios;
import boxbuster.Filmes;
import boxbuster.Musicas;
import boxbuster.Produtos;
import boxbuster.Tabuleiros;
import boxbuster.Videogames;
import boxbuster.Gerente;
import boxbuster.Caixa;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author elisrb
 */
public class AreaGerente extends javax.swing.JFrame {
    boolean ok = false;
    String action = "cancel";
    
    int rowClick = -1;

    // variáveis da parte de estoque
    int cont = Estoque.getCont()+1;
    private ArrayList<Produtos> allProducts = new ArrayList();
    int selectedProdInd;
    
    // variáveis da parte de equipe
    BancoDeDadosFuncionarios bdFunc = new BancoDeDadosFuncionarios();
    ArrayList<String> funcionarios = new ArrayList<>();
    int totalFunc = 0;
    ArrayList<String> funcAtual;

    /**
     * Creates new form AreaGerente
     */
    public AreaGerente() {
        setLocationRelativeTo(null);
        
        initComponents();
        
        // confirma que o estoque está carregado e atualizado
        Estoque.loadEstoque();
        cont = Estoque.getCont()+1;
        
        updateEstoqueStats();
        
        // inicializa as tabelas
        updateProdList();
        updateFuncionarios(); 
    }

    // atualiza a tabela de produtos
    private void updateProdList() {
        allProducts = Estoque.atualizarLista();
        
        DefaultTableModel tabela = new DefaultTableModel(new Object[] {"Código", "Tipo", "Nome", "Faixa", "Ano", "Preço", "Disp./Alugados"}, 0);

        for(int i = 0; i < allProducts.size(); i++){
            Object linha[] = new Object[]{
            allProducts.get(i).getCodigoProd(),
            allProducts.get(i).getClass().getSimpleName(), 
            allProducts.get(i).getNomeProd(),
            allProducts.get(i).getFaixaEtaria(),
            allProducts.get(i).getAno(),
            allProducts.get(i).getPreco(),
            allProducts.get(i).getDisponiveis() + "/" + allProducts.get(i).getAlugados()};

            tabela.addRow(linha);
        }
        
        tableProdutos.setModel(tabela);        
    }
    
    // atualiza os valores de estatísticas do estoque
    private void updateEstoqueStats(){
        allProducts = Estoque.atualizarLista();
        
        lblTotalProd.setText("Total de produtos: "+ allProducts.size());
        
        if(cmbTipoProd.getSelectedIndex() == 0){
            lblQuantTipo.setText("Produtos desse tipo: --");
        } else if(cmbTipoProd.getSelectedIndex() == 1){
            ArrayList<Filmes> tempLista = Estoque.getListaFilmes();
            lblQuantTipo.setText("Produtos desse tipo: "+ tempLista.size());
        } else if(cmbTipoProd.getSelectedIndex() == 2){
            ArrayList<Musicas> tempLista = Estoque.getListaMusicas();
            lblQuantTipo.setText("Produtos desse tipo: "+ tempLista.size());
        } else if(cmbTipoProd.getSelectedIndex() == 3){
            ArrayList<Tabuleiros> tempLista = Estoque.getListaTabuleiros();
            lblQuantTipo.setText("Produtos desse tipo: "+ tempLista.size());
        } else if(cmbTipoProd.getSelectedIndex() == 4){
            ArrayList<Videogames> tempLista = Estoque.getListaVideogames();
            lblQuantTipo.setText("Produtos desse tipo: "+ tempLista.size());
        }
    }
    
    // atualiza tabela e quantidade de funcionários, e a combo box de gerentes 
    private void updateFuncionarios() { 
        
        // atualiza tabela de funcionarios
        tableEquipe.removeAll();
        funcionarios = bdFunc.lerPessoas(); // retorna uma ArrayList de todos os funcionários
        
        DefaultTableModel tabela = new DefaultTableModel(new Object[] {"Nome", "CPF", "Data de Nascimento", "Código", "Cargo", "Gerente"}, 0);
        String[] palavras;
        
        for(int i = 0; i < funcionarios.size(); i++){
            palavras = funcionarios.get(i).split("_");
            String gerente = "--";
            if(palavras[5].equals("Caixa")){
                gerente = palavras[8]; // caso o funcionário seja gerente preenche o campo "Gerente" da tabela
            }
            Object linha[] = new Object[]{
            palavras[0],
            palavras[1],
            palavras[2],
            palavras[4],
            palavras[5],
            gerente};

            tabela.addRow(linha);
        }
        
        tableEquipe.setModel(tabela);
        
        // atualiza total de caixas e gerentes
        int[] quant = bdFunc.quantidades();
        lblTotalCaixas.setText("Total de caixas: "+ quant[0]);
        lblTotalGerentes.setText("Total de gerentes: "+ quant[1]);
        totalFunc = quant[0]+quant[1];
        
        // atualiza combo box de gerentes
        cmbGerenteEq.removeAllItems();
        cmbGerenteEq.addItem("Selecione");
        
        String[] linha;
        String nomeGerente;
        
        for(int i=0;i<funcionarios.size();i++){
            linha = funcionarios.get(i).split("_");
            
            if(linha[5].equals("Gerente")){
                nomeGerente = linha[0];
                cmbGerenteEq.addItem(nomeGerente);
            }
        }
    }
    
    // esvazia todos os campos do estoque
    public void clearFieldsEstoque(){
        cmbTipoProd.setSelectedItem("Selecione");
        txtfQuantidade.setEnabled(false);
        txtfQuantidade.setText("/");
        txtfCodigoProd.setText("");
        txtfFaixaEtaria.setText("");
        txtfPreco.setText("");
        txtfNome.setText("");
        txtfAno.setText("");
        txtfVar1.setText("");
        txtfVar2.setText("");
        txtfVar3.setText("");
        txtfVar4.setText("");
    }
    
    // ativa os campos comuns para todos produtos no estoque
    public void enableBaseFieldsEst(){
        cmbTipoProd.setEnabled(true);
        txtfQuantidade.setEnabled(true);
        txtfCodigoProd.setEnabled(true);
        txtfFaixaEtaria.setEnabled(true);
        txtfPreco.setEnabled(true);
        txtfNome.setEnabled(true);
        txtfAno.setEnabled(true);
        btnCancelarEst.setEnabled(true);
    }
    
    // desativa os campos comuns para todos produtos no estoque
    public void disableBaseFieldsEst(){
        cmbTipoProd.setEnabled(false);
        txtfQuantidade.setEnabled(false);
        txtfCodigoProd.setEnabled(false);
        txtfFaixaEtaria.setEnabled(false);
        txtfPreco.setEnabled(false);
        txtfNome.setEnabled(false);
        txtfAno.setEnabled(false);
        btnConfirmarEst.setEnabled(false);
        btnCancelarEst.setEnabled(false);
    }
    
    // ativa os campos da equipe
    public void enableEquipe(){
        cmbTipoEq.setEnabled(true);
        cmbGerenteEq.setEnabled(true);
        txtfDataEq.setEnabled(true);
        txtfCPFEq.setEnabled(true);
        txtfNomeEq.setEnabled(true);
        txtfCodigoEq.setEnabled(true);
        btnConfirmarEq.setEnabled(true);
        btnCancelarEq.setEnabled(true);
    }
    
    // ativa os campos da equipe
    public void disableEquipe(){
        cmbTipoEq.setEnabled(false);
        cmbGerenteEq.setEnabled(false);
        cmbTipoEq.setSelectedIndex(0);
        cmbGerenteEq.setSelectedIndex(0);
        txtfDataEq.setEnabled(false);
        txtfCPFEq.setEnabled(false);
        txtfNomeEq.setEnabled(false);
        txtfCodigoEq.setEnabled(false);
        txtfDataEq.setText("");
        txtfCPFEq.setText("");
        txtfNomeEq.setText("");
        txtfCodigoEq.setText("");
        btnConfirmarEq.setEnabled(false);
        btnCancelarEq.setEnabled(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGerente = new javax.swing.JPanel();
        tabbedPnlGerente = new javax.swing.JTabbedPane();
        pnlEquipe = new javax.swing.JPanel();
        lblTotalCaixas = new javax.swing.JLabel();
        lblTotalGerentes = new javax.swing.JLabel();
        lblCodigoEq = new javax.swing.JLabel();
        txtfCodigoEq = new javax.swing.JTextField();
        lblCPF = new javax.swing.JLabel();
        txtfCPFEq = new javax.swing.JTextField();
        lblTipoEq = new javax.swing.JLabel();
        cmbTipoEq = new javax.swing.JComboBox<>();
        lblNomeEq = new javax.swing.JLabel();
        txtfNomeEq = new javax.swing.JTextField();
        lblDataEq = new javax.swing.JLabel();
        txtfDataEq = new javax.swing.JTextField();
        lblGerente = new javax.swing.JLabel();
        cmbGerenteEq = new javax.swing.JComboBox<>();
        btnVoltarEq = new javax.swing.JButton();
        btnNovoFunc = new javax.swing.JButton();
        btnEditarEq = new javax.swing.JButton();
        btnPesquisarEq = new javax.swing.JButton();
        scrlEquipe = new javax.swing.JScrollPane();
        tableEquipe = new javax.swing.JTable();
        btnConfirmarEq = new javax.swing.JButton();
        btnCancelarEq = new javax.swing.JButton();
        pnlEstoque = new javax.swing.JPanel();
        btnVoltarEst = new javax.swing.JButton();
        btnNovoProd = new javax.swing.JButton();
        btnPesquisarProd = new javax.swing.JButton();
        btnEditarProd = new javax.swing.JButton();
        lblTotalProd = new javax.swing.JLabel();
        lblTipoProd = new javax.swing.JLabel();
        cmbTipoProd = new javax.swing.JComboBox<>();
        lblQuantTipo = new javax.swing.JLabel();
        lblCodigoProd = new javax.swing.JLabel();
        txtfCodigoProd = new javax.swing.JTextField();
        lblFaixaEtaria = new javax.swing.JLabel();
        txtfFaixaEtaria = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        txtfPreco = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtfNome = new javax.swing.JTextField();
        lblAno = new javax.swing.JLabel();
        txtfAno = new javax.swing.JTextField();
        lblVar1 = new javax.swing.JLabel();
        txtfVar1 = new javax.swing.JTextField();
        lblVar2 = new javax.swing.JLabel();
        txtfVar2 = new javax.swing.JTextField();
        lblVar3 = new javax.swing.JLabel();
        txtfVar3 = new javax.swing.JTextField();
        lblVar4 = new javax.swing.JLabel();
        txtfVar4 = new javax.swing.JTextField();
        btnConfirmarEst = new javax.swing.JButton();
        btnCancelarEst = new javax.swing.JButton();
        scrlProdutos = new javax.swing.JScrollPane();
        tableProdutos = new javax.swing.JTable();
        btnEditarProd1 = new javax.swing.JButton();
        lblQuantidade = new javax.swing.JLabel();
        txtfQuantidade = new javax.swing.JTextField();
        menuBarAreaGr = new javax.swing.JMenuBar();
        menuAreaGr = new javax.swing.JMenu();
        menuVoltarAreaGr = new javax.swing.JMenuItem();
        separatorAreaGr = new javax.swing.JPopupMenu.Separator();
        menuSairAreaGr = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Área do gerente");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/boxLogo.png")).getImage());

        pnlGerente.setBorder(javax.swing.BorderFactory.createTitledBorder("Área do Gerente"));

        pnlEquipe.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N

        lblTotalCaixas.setText("Total de caixas: --");

        lblTotalGerentes.setText("Total de gerentes: --");

        lblCodigoEq.setText("Código:");

        txtfCodigoEq.setEnabled(false);

        lblCPF.setText("CPF:");

        txtfCPFEq.setEnabled(false);

        lblTipoEq.setText("Tipo:");

        cmbTipoEq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Caixa", "Gerente" }));
        cmbTipoEq.setEnabled(false);

        lblNomeEq.setText("Nome:");

        txtfNomeEq.setEnabled(false);

        lblDataEq.setText("Data de nasc.:");

        txtfDataEq.setEnabled(false);

        lblGerente.setText("Gerente:");

        cmbGerenteEq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cmbGerenteEq.setEnabled(false);

        btnVoltarEq.setText("Voltar");
        btnVoltarEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarEqActionPerformed(evt);
            }
        });

        btnNovoFunc.setText("Novo funcionário");
        btnNovoFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoFuncActionPerformed(evt);
            }
        });

        btnEditarEq.setText("Editar");
        btnEditarEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarEqActionPerformed(evt);
            }
        });

        btnPesquisarEq.setText("Pesquisar");
        btnPesquisarEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarEqActionPerformed(evt);
            }
        });

        tableEquipe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cargo", "Nome", "Data de nasc.", "Pedidos"
            }
        ));
        tableEquipe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEquipeMouseClicked(evt);
            }
        });
        scrlEquipe.setViewportView(tableEquipe);

        btnConfirmarEq.setText("Confirmar");
        btnConfirmarEq.setEnabled(false);
        btnConfirmarEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarEqActionPerformed(evt);
            }
        });

        btnCancelarEq.setText("Cancelar");
        btnCancelarEq.setEnabled(false);
        btnCancelarEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarEqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEquipeLayout = new javax.swing.GroupLayout(pnlEquipe);
        pnlEquipe.setLayout(pnlEquipeLayout);
        pnlEquipeLayout.setHorizontalGroup(
            pnlEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEquipeLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(btnNovoFunc)
                .addGap(18, 18, 18)
                .addComponent(btnPesquisarEq)
                .addGap(18, 18, 18)
                .addComponent(btnEditarEq)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlEquipeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEquipeLayout.createSequentialGroup()
                        .addGroup(pnlEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlEquipeLayout.createSequentialGroup()
                                .addComponent(btnVoltarEq)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnConfirmarEq)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarEq)
                                .addGap(78, 78, 78))
                            .addGroup(pnlEquipeLayout.createSequentialGroup()
                                .addGroup(pnlEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlEquipeLayout.createSequentialGroup()
                                        .addComponent(lblCodigoEq)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtfCodigoEq, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblTotalCaixas))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlEquipeLayout.createSequentialGroup()
                                        .addComponent(lblCPF)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtfCPFEq, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblTotalGerentes))
                                .addGap(89, 89, 89)))
                        .addComponent(lblTipoEq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTipoEq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(pnlEquipeLayout.createSequentialGroup()
                        .addComponent(lblNomeEq, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfNomeEq, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(lblDataEq)
                        .addGap(18, 18, 18)
                        .addComponent(txtfDataEq, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(lblGerente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbGerenteEq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(scrlEquipe)
        );
        pnlEquipeLayout.setVerticalGroup(
            pnlEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEquipeLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoFunc)
                    .addComponent(btnPesquisarEq)
                    .addComponent(btnEditarEq))
                .addGap(18, 18, 18)
                .addGroup(pnlEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEquipeLayout.createSequentialGroup()
                        .addComponent(lblTotalCaixas)
                        .addGap(18, 18, 18)
                        .addGroup(pnlEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfCodigoEq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCodigoEq)))
                    .addGroup(pnlEquipeLayout.createSequentialGroup()
                        .addComponent(lblTotalGerentes)
                        .addGap(18, 18, 18)
                        .addGroup(pnlEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtfCPFEq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCPF))
                            .addGroup(pnlEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTipoEq)
                                .addComponent(cmbTipoEq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(pnlEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeEq)
                    .addComponent(txtfNomeEq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtfDataEq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDataEq))
                    .addGroup(pnlEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblGerente)
                        .addComponent(cmbGerenteEq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirmarEq)
                    .addComponent(btnCancelarEq)
                    .addComponent(btnVoltarEq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(scrlEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabbedPnlGerente.addTab("Equipe", pnlEquipe);

        btnVoltarEst.setText("Voltar");
        btnVoltarEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarEstActionPerformed(evt);
            }
        });

        btnNovoProd.setText("Novo produto");
        btnNovoProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProdActionPerformed(evt);
            }
        });

        btnPesquisarProd.setText("Pesquisar");
        btnPesquisarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarProdActionPerformed(evt);
            }
        });

        btnEditarProd.setText("Editar");
        btnEditarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProdActionPerformed(evt);
            }
        });

        lblTotalProd.setText("Total de produtos: --");

        lblTipoProd.setText("Tipo:");

        cmbTipoProd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Filme", "Música", "Tabuleiro", "Videogame" }));
        cmbTipoProd.setEnabled(false);
        cmbTipoProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoProdActionPerformed(evt);
            }
        });

        lblQuantTipo.setText("Produtos desse tipo: --");

        lblCodigoProd.setText("Código:");

        txtfCodigoProd.setEnabled(false);

        lblFaixaEtaria.setText("Faixa etária:");

        txtfFaixaEtaria.setEnabled(false);

        lblPreco.setText("Preço:");

        txtfPreco.setEnabled(false);

        lblNome.setText("Nome:");

        txtfNome.setEnabled(false);

        lblAno.setText("Ano:");

        txtfAno.setEnabled(false);

        lblVar1.setText("----------:");

        txtfVar1.setEnabled(false);

        lblVar2.setText("----------:");

        txtfVar2.setEnabled(false);

        lblVar3.setText("----------:");

        txtfVar3.setEnabled(false);

        lblVar4.setText("----------:");

        txtfVar4.setEnabled(false);

        btnConfirmarEst.setText("Confirmar");
        btnConfirmarEst.setEnabled(false);
        btnConfirmarEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarEstActionPerformed(evt);
            }
        });

        btnCancelarEst.setText("Cancelar");
        btnCancelarEst.setEnabled(false);
        btnCancelarEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarEstActionPerformed(evt);
            }
        });

        tableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Tipo", "Nome", "Faixa ", "Ano", "Preço", "Disp./Alugados"
            }
        ));
        tableProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProdutosMouseClicked(evt);
            }
        });
        scrlProdutos.setViewportView(tableProdutos);

        btnEditarProd1.setText("Excluir");
        btnEditarProd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProd1ActionPerformed(evt);
            }
        });

        lblQuantidade.setText("Disp./Alugados:");

        txtfQuantidade.setText("/");
        txtfQuantidade.setEnabled(false);

        javax.swing.GroupLayout pnlEstoqueLayout = new javax.swing.GroupLayout(pnlEstoque);
        pnlEstoque.setLayout(pnlEstoqueLayout);
        pnlEstoqueLayout.setHorizontalGroup(
            pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrlProdutos)
            .addGroup(pnlEstoqueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEstoqueLayout.createSequentialGroup()
                        .addGap(0, 69, Short.MAX_VALUE)
                        .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEstoqueLayout.createSequentialGroup()
                                .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblVar1)
                                    .addComponent(lblVar2))
                                .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlEstoqueLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtfVar1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEstoqueLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtfVar2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(244, 244, 244))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEstoqueLayout.createSequentialGroup()
                                .addGap(244, 244, 244)
                                .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblVar3)
                                    .addComponent(lblVar4))
                                .addGap(18, 18, 18)
                                .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtfVar4)
                                    .addComponent(txtfVar3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(82, 82, 82))
                    .addGroup(pnlEstoqueLayout.createSequentialGroup()
                        .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pnlEstoqueLayout.createSequentialGroup()
                                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(99, 99, 99))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlEstoqueLayout.createSequentialGroup()
                                    .addComponent(lblCodigoProd)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtfCodigoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(135, 135, 135)))
                            .addGroup(pnlEstoqueLayout.createSequentialGroup()
                                .addComponent(btnVoltarEst)
                                .addGap(133, 133, 133)
                                .addComponent(btnConfirmarEst)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarEst)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEstoqueLayout.createSequentialGroup()
                        .addComponent(lblTotalProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuantTipo)
                            .addGroup(pnlEstoqueLayout.createSequentialGroup()
                                .addComponent(lblQuantidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlEstoqueLayout.createSequentialGroup()
                                .addComponent(lblPreco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(pnlEstoqueLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(btnNovoProd)
                .addGap(18, 18, 18)
                .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEstoqueLayout.createSequentialGroup()
                        .addComponent(lblTipoProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTipoProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEstoqueLayout.createSequentialGroup()
                        .addComponent(lblFaixaEtaria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfFaixaEtaria, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEstoqueLayout.createSequentialGroup()
                        .addComponent(lblAno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfAno, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEstoqueLayout.createSequentialGroup()
                        .addComponent(btnPesquisarProd)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarProd)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarProd1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlEstoqueLayout.setVerticalGroup(
            pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEstoqueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisarProd)
                    .addComponent(btnNovoProd)
                    .addComponent(btnEditarProd)
                    .addComponent(btnEditarProd1))
                .addGap(18, 18, 18)
                .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEstoqueLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtfCodigoProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCodigoProd))
                            .addGroup(pnlEstoqueLayout.createSequentialGroup()
                                .addComponent(lblQuantTipo)
                                .addGap(22, 22, 22)
                                .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPreco))))
                        .addGap(18, 18, 18)
                        .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblQuantidade))
                            .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNome))))
                    .addGroup(pnlEstoqueLayout.createSequentialGroup()
                        .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipoProd)
                            .addComponent(cmbTipoProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalProd))
                        .addGap(18, 18, 18)
                        .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfFaixaEtaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFaixaEtaria))
                        .addGap(18, 18, 18)
                        .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAno))))
                .addGap(24, 24, 24)
                .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEstoqueLayout.createSequentialGroup()
                        .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVar1)
                            .addComponent(txtfVar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVar2)
                            .addComponent(txtfVar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlEstoqueLayout.createSequentialGroup()
                        .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVar3)
                            .addComponent(txtfVar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVar4)
                            .addComponent(txtfVar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pnlEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarEst)
                    .addComponent(btnConfirmarEst)
                    .addComponent(btnVoltarEst))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrlProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
        );

        tabbedPnlGerente.addTab("Estoque", pnlEstoque);

        javax.swing.GroupLayout pnlGerenteLayout = new javax.swing.GroupLayout(pnlGerente);
        pnlGerente.setLayout(pnlGerenteLayout);
        pnlGerenteLayout.setHorizontalGroup(
            pnlGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
            .addGroup(pnlGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tabbedPnlGerente, javax.swing.GroupLayout.Alignment.TRAILING))
        );
        pnlGerenteLayout.setVerticalGroup(
            pnlGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
            .addGroup(pnlGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tabbedPnlGerente, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
        );

        menuAreaGr.setText("Menu");

        menuVoltarAreaGr.setText("Voltar");
        menuVoltarAreaGr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVoltarAreaGrActionPerformed(evt);
            }
        });
        menuAreaGr.add(menuVoltarAreaGr);
        menuAreaGr.add(separatorAreaGr);

        menuSairAreaGr.setText("Sair");
        menuSairAreaGr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairAreaGrActionPerformed(evt);
            }
        });
        menuAreaGr.add(menuSairAreaGr);

        menuBarAreaGr.add(menuAreaGr);

        setJMenuBar(menuBarAreaGr);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlGerente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlGerente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProdActionPerformed
        action = "new";
        
        cmbTipoProd.setSelectedItem(cmbTipoProd.getSelectedItem()); //caso o usuário clique no botão após escolher um produto reseta a combo box para os campos específicos ativarem
        
        enableBaseFieldsEst();
        txtfCodigoProd.setEnabled(false);
        txtfCodigoProd.setText(Integer.toString(cont));
    }//GEN-LAST:event_btnNovoProdActionPerformed

    private void menuVoltarAreaGrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVoltarAreaGrActionPerformed
        new TelaPrincipal().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menuVoltarAreaGrActionPerformed

    private void menuSairAreaGrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairAreaGrActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSairAreaGrActionPerformed

    private void btnVoltarEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarEstActionPerformed
        new TelaPrincipal().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarEstActionPerformed

    // ativa e desativa os campos específicos para cada tipo de produto com base no tipo escolhido
    private void cmbTipoProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoProdActionPerformed
        String prodType = (String) cmbTipoProd.getSelectedItem();

        updateEstoqueStats();
        
        btnConfirmarEst.setEnabled(true);

        if (prodType.equals("Filme")){
            lblVar1.setText("Gênero:");
            lblVar2.setText("Estúdio:");
            lblVar3.setText("Diretor:");
            lblVar4.setText("----------:");
            txtfVar1.setEnabled(true);
            txtfVar2.setEnabled(true);
            txtfVar3.setEnabled(true);
            txtfVar4.setEnabled(false);
            txtfVar4.setText("");
        } else if (prodType.equals("Música")){
            lblVar1.setText("Estilo:");
            lblVar2.setText("Autor:");
            lblVar3.setText("----------:");
            lblVar4.setText("----------:");
            txtfVar1.setEnabled(true);
            txtfVar2.setEnabled(true);
            txtfVar3.setEnabled(false);
            txtfVar4.setEnabled(false);
            txtfVar3.setText("");
            txtfVar4.setText("");
        } else if (prodType.equals("Tabuleiro")){
            lblVar1.setText("Tipo:");
            lblVar2.setText("Marca:");
            lblVar3.setText("Nº de jogadores:");
            lblVar4.setText("----------:");
            txtfVar1.setEnabled(true);
            txtfVar2.setEnabled(true);
            txtfVar3.setEnabled(true);
            txtfVar4.setEnabled(false);
            txtfVar4.setText("");
        } else if (prodType.equals("Videogame")){
            lblVar1.setText("Gênero:");
            lblVar2.setText("Desenvolvedor:");
            lblVar3.setText("Nº de jogadores:");
            lblVar4.setText("Plataforma:");
            txtfVar1.setEnabled(true);
            txtfVar2.setEnabled(true);
            txtfVar3.setEnabled(true);
            txtfVar4.setEnabled(true);
        } else {
            lblVar1.setText("----------:");
            lblVar2.setText("----------:");
            lblVar3.setText("----------:");
            lblVar4.setText("----------:");
            txtfVar1.setEnabled(false);
            txtfVar2.setEnabled(false);
            txtfVar3.setEnabled(false);
            txtfVar4.setEnabled(false);

            if(!action.equals("search")){
                btnConfirmarEst.setEnabled(false);
            }
        } 
    }//GEN-LAST:event_cmbTipoProdActionPerformed

    // realiza as funções da área do estoque
    private void btnConfirmarEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarEstActionPerformed
        rowClick = -1;
        
        if(action.equals("delete")){
            String prodType = (String) cmbTipoProd.getSelectedItem();
            
            if (prodType.equals("Filme")){
                Estoque.getListaFilmes().remove(selectedProdInd);
            } else if (prodType.equals("Música")){
                Estoque.getListaMusicas().remove(selectedProdInd);
            } else if (prodType.equals("Tabuleiro")){
                Estoque.getListaTabuleiros().remove(selectedProdInd);
            } else if (prodType.equals("Videogame")){
                Estoque.getListaVideogames().remove(selectedProdInd);
            } 
            
            Estoque.reescreverEstoque();
            updateProdList();
            
            clearFieldsEstoque();
            
        } else if(action.equals("search")){
            tableProdutos.removeAll();
            DefaultTableModel tabela = new DefaultTableModel(new Object[] {"Código", "Tipo", "Nome", "Faixa", "Ano", "Preço", "Alugado"}, 0);

            String disponiveis = "", alugados = "";
            
            String[] quant = txtfQuantidade.getText().split("/");
            
            if(quant.length == 1){
                disponiveis = quant[0];
            } else if (quant.length == 2){
                disponiveis = quant[0];
                alugados = quant[1];
            }
            
            String codTemp = txtfCodigoProd.getText();
            
            String codigo;
            
            if(codTemp.isEmpty()){
                codigo = "";
            } else {
                codigo = codTemp;
            }
            
            String tipo = (String) cmbTipoProd.getSelectedItem(),
                    faixaEtaria = txtfFaixaEtaria.getText(),
                    preco = txtfPreco.getText(),
                    nome = txtfNome.getText(),
                    ano = txtfAno.getText(),
                    var1 = txtfVar1.getText(),
                    var2 = txtfVar2.getText(),
                    var3 = txtfVar3.getText(),
                    var4 = txtfVar4.getText();
            if(tipo.equals("Selecione")){
                tipo = "";
            } else if (tipo.equals("Música")){
                tipo = "Musica";
            }
            for(Produtos prod : allProducts){
                
                String[] info = prod.toString().split("_");
 
                boolean ok3 = true;
                boolean ok4 = true;
                
                if(info.length >= 11 && !info[10].contains(var3)){
                    ok3 = false;
                }
                if(info.length >= 12 && !info[11].contains(var4)){
                    ok4 = false;
                }
                
                // busca por cada campo em conjunto
                if(info[0].contains(tipo) &&
                        info[1].contains(nome) &&
                        info[2].contains(preco) &&
                        info[3].contains(ano) &&
                        info[4].contains(codigo) &&
                        info[5].contains(faixaEtaria) &&
                        info[6].contains(disponiveis) &&
                        info[7].contains(alugados) &&
                        info[8].contains(var1) &&
                        info[9].contains(var2) &&
                        ok3 && ok4){
                    

                    Object linha[] = new Object[]{
                    Integer.valueOf(info[4]),
                    info[0]+"s",
                    info[1],
                    info[5],
                    info[3],
                    info[2],
                    info[6] + "/" + info[7]};

                    tabela.addRow(linha);
                }
            }
            tableProdutos.setModel(tabela);
    
        } else if(action.equals("new") || action.equals("edit")) {
            // já que ambas funções de adicionar e editar um produto precisam 
            // recriar os objetos dos produtos, ambas compartilham vários métodos,
            // apenas apresentando mudanças na hora de aplicar as funções
            
            int codigo = Integer.parseInt(txtfCodigoProd.getText());
            String faixaEtaria = txtfFaixaEtaria.getText(),
                    preco = txtfPreco.getText(),
                    nome = txtfNome.getText(),
                    ano = txtfAno.getText();
            
            String[] quant = txtfQuantidade.getText().split("/");

            String prodType = (String) cmbTipoProd.getSelectedItem();

            ok = true;
            
            String disponiveis = "";
            String alugados = "";
            
            if(quant.length == 2){
                disponiveis = quant[0];
                alugados = quant[1];
            } else {
                JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos corretamente.");
                ok = false;
            }
            
            try {
                Double.parseDouble(preco);
                Integer.parseInt(ano);
                Integer.parseInt(disponiveis);
                Integer.parseInt(alugados);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos corretamente.");
                ok = false;
            }
            
            if(action.equals("new")){
                for(Produtos prod : Estoque.getListaProdutos()){
                    if(prod.getNomeProd().equals(nome)){
                        JOptionPane.showMessageDialog(null, "Já existe um produto com esse nome.");
                        ok = false;
                    }
                }
            }

            if(ok){
                if(faixaEtaria.isEmpty() || preco.isEmpty() || nome.isEmpty() || ano.isEmpty() || quant.length != 2){
                    JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos corretamente.");
                    ok = false;
                } else {
                    if (prodType.equals("Filme")){
                        String genero = txtfVar1.getText(),
                                estudio = txtfVar2.getText(),
                                diretor = txtfVar3.getText();

                        if(genero.isEmpty() || estudio.isEmpty() || diretor.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos.");
                            ok = false;
                        } else {
                            Filmes newFilme = new Filmes(nome, Double.parseDouble(preco), Integer.parseInt(ano), codigo, faixaEtaria, Integer.parseInt(disponiveis), Integer.parseInt(alugados), genero, estudio, diretor);

                            if(action.equals("edit")){
                                Estoque.getListaFilmes().set(selectedProdInd, newFilme);
                            } else if (action.equals("new")){
                                Estoque.addFilme(newFilme);
                                Estoque.salvarProduto(newFilme);
                            }
                        }
                    } else if (prodType.equals("Música")){
                        String estilo = txtfVar1.getText(),
                                autor = txtfVar2.getText();

                        if(estilo.isEmpty() || autor.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos.");
                            ok = false;
                        } else {
                            Musicas newMusica = new Musicas(nome, Double.parseDouble(preco), Integer.parseInt(ano), codigo, faixaEtaria, Integer.parseInt(disponiveis), Integer.parseInt(alugados), estilo, autor);

                            if(action.equals("edit")){
                                Estoque.getListaMusicas().set(selectedProdInd, newMusica);
                            } else if (action.equals("new")){
                                Estoque.addMusica(newMusica);
                                Estoque.salvarProduto(newMusica);;
                            }
                        }
                    } else if (prodType.equals("Tabuleiro")){
                        String tipo = txtfVar1.getText(),
                                marca = txtfVar2.getText(),
                                numJogadores = txtfVar3.getText();

                        if(tipo.isEmpty() || marca.isEmpty() || numJogadores.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos.");
                            ok = false;
                        } else {
                            Tabuleiros newTabuleiro = new Tabuleiros(nome, Double.parseDouble(preco), Integer.parseInt(ano), codigo, faixaEtaria, Integer.parseInt(disponiveis), Integer.parseInt(alugados), numJogadores, tipo, marca);

                            if(action.equals("edit")){
                                Estoque.getListaTabuleiros().set(selectedProdInd, newTabuleiro);
                            } else if (action.equals("new")){
                                Estoque.addTabuleiro(newTabuleiro);
                                Estoque.salvarProduto(newTabuleiro);
                            }
                        }
                    } else if (prodType.equals("Videogame")){
                        String genero = txtfVar1.getText(),
                                estudio = txtfVar2.getText(),
                                numJogadores = txtfVar3.getText(),
                                plataforma = txtfVar4.getText();

                        if(genero.isEmpty() || estudio.isEmpty() || numJogadores.isEmpty() || plataforma.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos.");
                            ok = false;
                        } else {
                            Videogames newVideogame = new Videogames(nome, Double.parseDouble(preco), Integer.parseInt(ano), codigo, faixaEtaria, Integer.parseInt(disponiveis), Integer.parseInt(alugados), numJogadores, genero, plataforma, estudio);

                            if(action.equals("edit")){
                                Estoque.getListaVideogames().set(selectedProdInd, newVideogame);
                            } else if (action.equals("new")){
                                Estoque.addVideogame(newVideogame);
                                Estoque.salvarProduto(newVideogame);
                            }
                        }
                    }

                    if(ok){
                        cont++;
                        Estoque.setCont(cont);
                        Estoque.reescreverEstoque();

                        updateProdList();
                        
                        updateEstoqueStats();

                        disableBaseFieldsEst();
                        clearFieldsEstoque();

                        switch(action){
                            case "new":
                                JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso.");
                                break;
                            case "edit":
                                JOptionPane.showMessageDialog(null, "Produto editado com sucesso.");
                                break;
                            case "delete":
                                JOptionPane.showMessageDialog(null, "Produto deletado com sucesso.");
                                break;
                        }
                    }
                }
            }
        }
        
        if(!action.equals("search")){
            action = "confirm";
        }
        cont = Estoque.getCont()+1;
    }//GEN-LAST:event_btnConfirmarEstActionPerformed

    // limpa a tela do estoque
    private void btnCancelarEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarEstActionPerformed
        action = "cancel";
        
        rowClick = -1;
        
        disableBaseFieldsEst();
        clearFieldsEstoque();
        
        updateProdList();
    }//GEN-LAST:event_btnCancelarEstActionPerformed

    // realiza as mudanças necessárias para o botão pesquisar do estoque
    private void btnPesquisarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarProdActionPerformed
        action = "search";
        
        cmbTipoProd.setSelectedItem(cmbTipoProd.getSelectedItem()); //caso o usuário clique no botão após escolher um produto reseta a combo box para os campos específicos ativarem
        
        if (rowClick >= 0 && rowClick < allProducts.size()){
            
            int codigoProduto = (Integer) (tableProdutos.getModel().getValueAt(rowClick, 0));
            
            Produtos selectedProd = Estoque.getProdutoPorCodigo(codigoProduto);
            
            txtfCodigoProd.setText(Integer.toString(selectedProd.getCodigoProd()));
        } else {
            txtfCodigoProd.setText("");
        }
        
        enableBaseFieldsEst();
        btnConfirmarEst.setEnabled(true);
    }//GEN-LAST:event_btnPesquisarProdActionPerformed

    // realiza as mudanças necessárias para o botão editar do estoque
    private void btnEditarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProdActionPerformed
        action = "edit";
                
        disableBaseFieldsEst();
        btnCancelarEst.setEnabled(true);
        
        if (rowClick >= 0 && rowClick < allProducts.size()){
            cmbTipoProd.setSelectedItem(cmbTipoProd.getSelectedItem()); //caso o usuário clique no botão após escolher um produto reseta a combo box para os campos específicos ativarem
            
            int codigoProduto = (Integer) (tableProdutos.getModel().getValueAt(rowClick, 0));
            
            Produtos selectedProd = Estoque.getProdutoPorCodigo(codigoProduto);
            
            txtfCodigoProd.setText(Integer.toString(selectedProd.getCodigoProd()));
            btnConfirmarEst.setEnabled(true);
            
            enableBaseFieldsEst();
            txtfCodigoProd.setEnabled(false);
        } else {
            txtfCodigoProd.setText("");
        }
    }//GEN-LAST:event_btnEditarProdActionPerformed

    // retorna à tela principal
    private void btnVoltarEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarEqActionPerformed
        new TelaPrincipal().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarEqActionPerformed

    // botão de novo funcionário da equipe
    private void btnNovoFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoFuncActionPerformed
        action = "new";
        enableEquipe();
    }//GEN-LAST:event_btnNovoFuncActionPerformed

    // realiza as funções da área do estoque
    private void btnConfirmarEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarEqActionPerformed
        // cria um novo funcionário
        if("new".equals(action)){ 
            if(txtfCodigoEq.getText().equals("")|| txtfNomeEq.getText().equals("")|| txtfDataEq.getText().equals("")||
                    txtfCPFEq.getText().equals("")||cmbTipoEq.getSelectedIndex()==0||(cmbTipoEq.getSelectedIndex()==1 && cmbGerenteEq.getSelectedIndex()==0)){
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser inseridos!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
            } else {
                String nome = txtfNomeEq.getText(),
                    cpf = txtfCPFEq.getText(),
                    dataString = txtfDataEq.getText(),
                    codigoString = txtfCodigoEq.getText(),
                    tipo = cmbTipoEq.getSelectedItem().toString(),
                    gerenteString = cmbGerenteEq.getSelectedItem().toString(),
                    senha;
                
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Date data = null;
                
                try {
                    data = formato.parse(dataString);
                } catch (ParseException ex) {
                    Logger.getLogger(LoginCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                int codigo = Integer.parseInt(codigoString);
                
                // cria uma nova senha
                senha = JOptionPane.showInputDialog(null, "Determine uma senha para o novo funcionário", "Definição de senha", JOptionPane.PLAIN_MESSAGE);
                
                // adiciona o novo funcionário ao banco de dados
                if(tipo.equals("Gerente")){
                    Gerente funcionario = new Gerente(senha, codigo, nome, cpf, data);
                    bdFunc.adicionarPessoa(funcionario);
                } else if(tipo.equals("Caixa")){ // caso seja um caixa, encontra o gerente correspondente
                    Gerente gerente = bdFunc.buscarGerente(gerenteString);
                    Caixa funcionario = new Caixa(gerente, senha, codigo, nome, cpf, data);
                    bdFunc.adicionarPessoa(funcionario);
                }
                
            }
            updateFuncionarios(); 
            
        } else if("edit".equals(action)){
            int i = tableEquipe.getSelectedRow(); // edita o funcionário selecionado
            
            // ao selecionar um funcionário na tabela, o conteúdo dos campos de texto e das combo boxes é atualizado para os dados do funcionário selecionado
            // logo, para confirmar a edição dos dados basta apenas coletar os dados dos campos assim como na criação de um novo funcioário
        
            if(i >= 0 && i < totalFunc) {
                if(txtfCodigoEq.getText().equals("")|| txtfNomeEq.getText().equals("")|| txtfDataEq.getText().equals("")||
                    txtfCPFEq.getText().equals("")||cmbTipoEq.getSelectedIndex()==0||(cmbTipoEq.getSelectedIndex()==1 && cmbGerenteEq.getSelectedIndex()==0)){
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser inseridos!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                } else {
                    String nome = txtfNomeEq.getText(),
                        cpf = txtfCPFEq.getText(),
                        dataString = txtfDataEq.getText(),
                        codigoString = txtfCodigoEq.getText(),
                        tipo = cmbTipoEq.getSelectedItem().toString(),
                        gerenteString = cmbGerenteEq.getSelectedItem().toString(),
                        senha = funcAtual.get(3); // a senha não pode ser alterada

                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date data = null;
                    try {
                        data = formato.parse(dataString);
                    } catch (ParseException ex) {
                        Logger.getLogger(LoginCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    int codigo = Integer.parseInt(codigoString);
                                        
                    bdFunc.removerPessoa(funcAtual.get(1)); // remove funcionario do banco de dados pelo cpf

                    // adiciona o "novo funcionário" ao banco de dados
                    if(tipo.equals("Gerente")){
                        Gerente funcionario = new Gerente(senha, codigo, nome, cpf, data);
                        bdFunc.adicionarPessoa(funcionario);
                    }
                    else if(tipo.equals("Caixa")){
                        Gerente gerente = bdFunc.buscarGerente(gerenteString);
                        Caixa funcionario = new Caixa(gerente, senha, codigo, nome, cpf, data);
                        bdFunc.adicionarPessoa(funcionario);
                    }
                    
                    disableEquipe();
                }
            }   
            updateFuncionarios();
            
        } else if("search".equals(action)){
            tableEquipe.removeAll();
            DefaultTableModel tabela = new DefaultTableModel(new Object[] {"Nome", "CPF", "Data de Nascimento", "Código", "Cargo", "Gerente"}, 0);

            String nome = txtfNomeEq.getText(),
                    cpf = txtfCPFEq.getText(),
                    data = txtfDataEq.getText(),
                    codigo = txtfCodigoEq.getText(),
                    tipo = cmbTipoEq.getSelectedItem().toString(),
                    gerente = cmbGerenteEq.getSelectedItem().toString();
            
            if(tipo.equals("Selecione")){
                tipo = ""; // desconsidera o tipo "Selecione"
            }
            
            for(String func : funcionarios){ // busca em todos os funcionários
                // caso o campo de busca esteja vazio, ele será desconsiderado na busca (uma vez que toda string contém a string vazia)
                String[] f = func.split("_");
                if(f[0].contains(nome) &&
                        f[1].contains(cpf) &&
                        f[2].contains(data) &&
                        f[4].contains(codigo) &&
                        f[5].contains(tipo)){
                    if(gerente.equals("Selecione")||(f[5].equals("Caixa") && f[8].equals(gerente))){
                        // caso o funcionário se enquadre na busca, ele será mostrado na tabela
                        String g = "--";
                        if(f[5].equals("Caixa")){
                            g = f[8];
                        }
                        Object linha[] = new Object[]{
                        f[0],
                        f[1],
                        f[2],
                        f[4],
                        f[5],
                        g};

                        tabela.addRow(linha);
                    }
                }
            }
            tableEquipe.setModel(tabela);
            disableEquipe();
        }
    }//GEN-LAST:event_btnConfirmarEqActionPerformed

    // botão editar da equipe
    private void btnEditarEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEqActionPerformed
        action = "edit";        
        enableEquipe();
    }//GEN-LAST:event_btnEditarEqActionPerformed

    // botão pesquisar da equipe
    private void btnPesquisarEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarEqActionPerformed
        action = "search";        
        enableEquipe();
    }//GEN-LAST:event_btnPesquisarEqActionPerformed

    // botão cancelar da equipe
    private void btnCancelarEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarEqActionPerformed
        disableEquipe();
    }//GEN-LAST:event_btnCancelarEqActionPerformed

    // realiza as mudanças necessárias para o botão de editar do estoque
    private void btnEditarProd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProd1ActionPerformed
        action = "delete";
        
        if (rowClick >= 0 && rowClick < allProducts.size()){
            int codigoProduto = (Integer) (tableProdutos.getModel().getValueAt(rowClick, 0));
            
            Produtos selectedProd = Estoque.getProdutoPorCodigo(codigoProduto);
            
            txtfCodigoProd.setText(Integer.toString(selectedProd.getCodigoProd()));
            
            btnConfirmarEst.setEnabled(true);
        } else {
            txtfCodigoProd.setText("");
            disableBaseFieldsEst();
        }
        btnCancelarEst.setEnabled(true);
    }//GEN-LAST:event_btnEditarProd1ActionPerformed

    // ações realizadas ao clicar em um funcionário da lista da equipe
    private void tableEquipeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEquipeMouseClicked
        int row = tableEquipe.getSelectedRow();
        
        if (row >= 0 && row < funcionarios.size()){
            // muda os campos de texto e combo boxes para os dados do funcionário selecionado
            txtfNomeEq.setText(tableEquipe.getModel().getValueAt(row, 0).toString());
            txtfCPFEq.setText(tableEquipe.getModel().getValueAt(row, 1).toString());
            txtfDataEq.setText(tableEquipe.getModel().getValueAt(row, 2).toString());
            txtfCodigoEq.setText(tableEquipe.getModel().getValueAt(row, 3).toString());
            
            if(tableEquipe.getModel().getValueAt(row, 4).toString().equals("Caixa")){
                cmbTipoEq.setSelectedIndex(1);
            }
            else{
                cmbTipoEq.setSelectedIndex(2);
            }
            
            for(int i = 0; i < cmbGerenteEq.getItemCount(); i++){
                if(cmbGerenteEq.getItemAt(i).equals(tableEquipe.getModel().getValueAt(row, 5).toString())){
                    cmbGerenteEq.setSelectedIndex(i);
                    break;
                }
            }
            
            // seleciona o funcionário do banco de dados correspondente à seleção
            funcAtual = bdFunc.buscarPessoa(txtfNomeEq.getText() + "_" +
                    txtfCPFEq.getText() + "_" +
                    txtfDataEq.getText() + "_");
        }
    }//GEN-LAST:event_tableEquipeMouseClicked

    // ações realizadas ao clicar em um produto da lista do estoque
    private void tableProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProdutosMouseClicked
        rowClick = tableProdutos.getSelectedRow();
        
        if (rowClick >= 0 && rowClick < allProducts.size()){
            int codigoProduto = (Integer) (tableProdutos.getModel().getValueAt(rowClick, 0));
            
            Produtos selectedProd = Estoque.getProdutoPorCodigo(codigoProduto);
            
            if(!action.equals("new")){
                txtfCodigoProd.setText(Integer.toString(selectedProd.getCodigoProd()));
            } else {
                txtfCodigoProd.setEnabled(false);
            }
            txtfNome.setText(selectedProd.getNomeProd());
            txtfFaixaEtaria.setText(selectedProd.getFaixaEtaria());
            txtfAno.setText(Integer.toString(selectedProd.getAno()));
            txtfPreco.setText(Double.toString(selectedProd.getPreco()));
            txtfQuantidade.setText(selectedProd.getDisponiveis() + "/" + selectedProd.getAlugados());
            
            if(selectedProd.getClass().getSimpleName().equals("Filmes")){
                selectedProdInd = Estoque.getListaFilmes().indexOf(selectedProd);
                
                cmbTipoProd.setSelectedItem("Filme");
                
                txtfVar1.setText(((Filmes) selectedProd).getGenero());
                txtfVar2.setText(((Filmes) selectedProd).getEstudio());
                txtfVar3.setText(((Filmes) selectedProd).getDiretor());
                
            } else if(selectedProd.getClass().getSimpleName().equals("Musicas")){
                selectedProdInd = Estoque.getListaMusicas().indexOf(selectedProd);
                
                cmbTipoProd.setSelectedItem("Música");
                
                txtfVar1.setText(((Musicas) selectedProd).getEstilo());
                txtfVar2.setText(((Musicas) selectedProd).getAutor());
                
            } else if(selectedProd.getClass().getSimpleName().equals("Tabuleiros")){
                selectedProdInd = Estoque.getListaTabuleiros().indexOf(selectedProd);
                
                cmbTipoProd.setSelectedItem("Tabuleiro");
                
                txtfVar1.setText(((Tabuleiros) selectedProd).getTipo());
                txtfVar2.setText(((Tabuleiros) selectedProd).getMarca());
                txtfVar3.setText(((Tabuleiros) selectedProd).getNumJogadores());
                
            } else if(selectedProd.getClass().getSimpleName().equals("Videogames")){
                selectedProdInd = Estoque.getListaVideogames().indexOf(selectedProd);
                
                cmbTipoProd.setSelectedItem("Videogame");
                
                txtfVar1.setText(((Videogames) selectedProd).getGenero());
                txtfVar2.setText(((Videogames) selectedProd).getDesenvolvedor());
                txtfVar3.setText(((Videogames) selectedProd).getNumJogadores());
                txtfVar4.setText(((Videogames) selectedProd).getPlataforma());
            }
            
            if(action.equals("confirm") || action.equals("cancel") || action.equals("delete")){
                disableBaseFieldsEst();
            
                txtfVar1.setEnabled(false);
                txtfVar2.setEnabled(false);
                txtfVar3.setEnabled(false);
                txtfVar4.setEnabled(false);
                
                if(!action.equals("delete")){
                    btnConfirmarEst.setEnabled(false);
                }
            } else {
                enableBaseFieldsEst();
            }
                        
            btnCancelarEst.setEnabled(true);
            
            if(action.equals("edit")){
                txtfCodigoProd.setEnabled(false);
            }
        }
    }//GEN-LAST:event_tableProdutosMouseClicked
    
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
            java.util.logging.Logger.getLogger(AreaGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AreaGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AreaGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AreaGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AreaGerente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarEq;
    private javax.swing.JButton btnCancelarEst;
    private javax.swing.JButton btnConfirmarEq;
    private javax.swing.JButton btnConfirmarEst;
    private javax.swing.JButton btnEditarEq;
    private javax.swing.JButton btnEditarProd;
    private javax.swing.JButton btnEditarProd1;
    private javax.swing.JButton btnNovoFunc;
    private javax.swing.JButton btnNovoProd;
    private javax.swing.JButton btnPesquisarEq;
    private javax.swing.JButton btnPesquisarProd;
    private javax.swing.JButton btnVoltarEq;
    private javax.swing.JButton btnVoltarEst;
    private javax.swing.JComboBox<String> cmbGerenteEq;
    private javax.swing.JComboBox<String> cmbTipoEq;
    private javax.swing.JComboBox<String> cmbTipoProd;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCodigoEq;
    private javax.swing.JLabel lblCodigoProd;
    private javax.swing.JLabel lblDataEq;
    private javax.swing.JLabel lblFaixaEtaria;
    private javax.swing.JLabel lblGerente;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeEq;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblQuantTipo;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblTipoEq;
    private javax.swing.JLabel lblTipoProd;
    private javax.swing.JLabel lblTotalCaixas;
    private javax.swing.JLabel lblTotalGerentes;
    private javax.swing.JLabel lblTotalProd;
    private javax.swing.JLabel lblVar1;
    private javax.swing.JLabel lblVar2;
    private javax.swing.JLabel lblVar3;
    private javax.swing.JLabel lblVar4;
    private javax.swing.JMenu menuAreaGr;
    private javax.swing.JMenuBar menuBarAreaGr;
    private javax.swing.JMenuItem menuSairAreaGr;
    private javax.swing.JMenuItem menuVoltarAreaGr;
    private javax.swing.JPanel pnlEquipe;
    private javax.swing.JPanel pnlEstoque;
    private javax.swing.JPanel pnlGerente;
    private javax.swing.JScrollPane scrlEquipe;
    private javax.swing.JScrollPane scrlProdutos;
    private javax.swing.JPopupMenu.Separator separatorAreaGr;
    private javax.swing.JTabbedPane tabbedPnlGerente;
    private javax.swing.JTable tableEquipe;
    private javax.swing.JTable tableProdutos;
    private javax.swing.JTextField txtfAno;
    private javax.swing.JTextField txtfCPFEq;
    private javax.swing.JTextField txtfCodigoEq;
    private javax.swing.JTextField txtfCodigoProd;
    private javax.swing.JTextField txtfDataEq;
    private javax.swing.JTextField txtfFaixaEtaria;
    private javax.swing.JTextField txtfNome;
    private javax.swing.JTextField txtfNomeEq;
    private javax.swing.JTextField txtfPreco;
    private javax.swing.JTextField txtfQuantidade;
    private javax.swing.JTextField txtfVar1;
    private javax.swing.JTextField txtfVar2;
    private javax.swing.JTextField txtfVar3;
    private javax.swing.JTextField txtfVar4;
    // End of variables declaration//GEN-END:variables
}
