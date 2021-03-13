/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.tela;

import br.com.autos.control.ControlCarro;
import br.com.autos.control.ControlCliente;
import br.com.autos.control.ControlFuncionario;
import br.com.autos.control.ControlLocacao;
import br.com.autos.model.ModelCarro;
import br.com.autos.model.ModelCliente;
import br.com.autos.model.ModelFuncionario;
import br.com.autos.model.ModelLocacao;
import br.com.autos.util.DataHora;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gilber
 * @version 1
 */
public class TelaLocacao extends javax.swing.JFrame {
    ControlCliente controlCliente = new ControlCliente();
    ControlCarro controlCarro = new ControlCarro();
    ControlFuncionario controlFuncionario = new ControlFuncionario();
    ControlLocacao controlLocacao = new ControlLocacao();
    ModelLocacao modelLocacao = new ModelLocacao();
    ArrayList<ModelLocacao> listarLocacao = new ArrayList<>();
   

    /**
     * Creates new form TelaAlocacao
     */
    public TelaLocacao() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/com/autos/img/iconAlocacao.png")));
        carregarLocacao();
        addCliente();
        addCarro();
        addFuncionario();
        addSituacao();
        campoCodigo.setEnabled(false);
    }
    //metodo limpar campos
    public void limparCampos(){
      campoDataLocacao.setToolTipText("");
      campoHoraLocacao.setText("");
     campoDataDevolucao.setToolTipText("");
     campoHoraDevolucao.setText("");
     campoTotal.setText("");
     campoQtdDias.setText("");
     comboBoxSituacao.addItem("");
    }
    private void addSituacao(){
       comboBoxSituacao.removeAllItems();
       comboBoxSituacao.addItem("");
       comboBoxSituacao.addItem("Diaria");
       comboBoxSituacao.addItem("Semanal");
       comboBoxSituacao.addItem("Mensal");
    }
private void addCliente(){
        ArrayList<ModelCliente> listCliente = new ArrayList<>();
        listCliente = controlCliente.controlGetListarClientes();
        comboBoxCliente.removeAllItems();
        comboBoxCliente.addItem("");
        for (int i = 0; i < listCliente.size(); i++){
            comboBoxCliente.addItem(listCliente.get(i).getCliNome());
        }
    }
//adicionar carro comboBox
private void addCarro(){
        ArrayList<ModelCarro> listCarro = new ArrayList<>();
        listCarro = controlCarro.controlListarCarro();
        comboBoxCarro.removeAllItems();
        int total = listCarro.size();
        comboBoxCarro.addItem("");
        for (int i = 0; i < total; i++){
            comboBoxCarro.addItem(listCarro.get(i).getCarChassi());
        }
    }
//adicionar funcionario comboBox
private void addFuncionario(){
        ArrayList<ModelFuncionario> listFun = new ArrayList<>();
        listFun = controlFuncionario.controlGetListaFuncionario();
        comboBoxFuncionario.removeAllItems();
        int tamanho = listFun.size();
        comboBoxFuncionario.addItem("");
        for (int i = 0; i < listFun.size(); i++){
            comboBoxFuncionario.addItem(listFun.get(i).getFunNome());
        }
    }
public Double calculo(int qtd, double preco){
    double resultado = 0;
    return resultado = preco * qtd;
}

public void validarCampos(){
    Date dataLocacao, dataDevolucao;
    String horaLocacao, horaDevolucao;
    String cbCliente;
    int qtdDias;
    double preco, total;
    
    if(comboBoxCliente.getSelectedItem().equals("")){
        JOptionPane.showConfirmDialog(rootPane, "selecione um cliente");
        comboBoxCliente.requestFocus();
    }else{
        if(comboBoxCarro.getSelectedItem().equals("")){
        JOptionPane.showConfirmDialog(rootPane, "selecione um carro");
        comboBoxCarro.requestFocus();
    }else{
        if(comboBoxFuncionario.getSelectedItem().equals("")){
        JOptionPane.showConfirmDialog(rootPane, "selecione um funcionario");
        comboBoxFuncionario.requestFocus();
    }else{
            if (campoDataLocacao.getDate()!=null) {
                if (!campoHoraLocacao.getText().isEmpty()) {
                   if (!campoQtdDias.getText().isEmpty()) {
                   if (campoDataDevolucao.getDate()!=null) {
                   if (!campoHoraDevolucao.getText().isEmpty()) {
                   if (comboBoxSituacao.getSelectedItem().equals("Diaria")||comboBoxSituacao.getSelectedItem().equals("Semanal") || comboBoxSituacao.getSelectedItem().equals("Mensal")) {
                      if (!campoPreco.getText().isEmpty()) {
                         if (!campoTotal.getText().isEmpty()) {
                             //chamar metodo gravar no banco
                             gravarLocacao();
            }else{
                JOptionPane.showConfirmDialog(rootPane, "Verifique o campo total!");
                campoTotal.requestFocus();
            }
            }else{
                JOptionPane.showConfirmDialog(rootPane, "Preencha o campo preço!");
                campoPreco.requestFocus();
            }
            }else{
                JOptionPane.showConfirmDialog(rootPane, "Selecione o tipo de locação!");
                comboBoxSituacao.requestFocus();
            }
            }else{
                JOptionPane.showConfirmDialog(rootPane, "Preencha a hora de Devolução!");
                campoHoraDevolucao.requestFocus();
            }
            }else{
                JOptionPane.showConfirmDialog(rootPane, "Preencha Data de Devolução!");
                campoDataDevolucao.requestFocus();
            }
            }else{
                JOptionPane.showConfirmDialog(rootPane, "Preencha o campo quantidades de dias!");
                campoQtdDias.requestFocus();
            }
            }else{
                JOptionPane.showConfirmDialog(rootPane, "Preencha hora de locação!");
                campoHoraLocacao.requestFocus();
            }
            }else{
                JOptionPane.showConfirmDialog(rootPane, "selecione uma data de Locação!");
            }
    }
    }
    }
      
}
public void gravarLocacao(){
    DataHora setData = new DataHora();
    String dtLocacao =setData.formatarData(this.campoDataLocacao.getDate());
    String dtDevolucao = setData.formatarData(this.campoDataDevolucao.getDate());
    modelLocacao.setLocData(dtLocacao);
    modelLocacao.setLocHora(this.campoHoraLocacao.getText());
    modelLocacao.setLocDataDevolucao(dtDevolucao);
    modelLocacao.setLocHoraDevolucao(this.campoHoraDevolucao.getText());
    modelLocacao.setLocValorTotal(Double.parseDouble(this.campoTotal.getText()));
    modelLocacao.setQtdDias(Integer.parseInt(this.campoQtdDias.getText()));
    modelLocacao.setSituacao(this.comboBoxSituacao.getSelectedItem().toString());
    modelLocacao.setLocFunMatricula(controlFuncionario.controlGetRecuperarFunId(this.comboBoxFuncionario.getSelectedIndex()).getFunMatricula());
    modelLocacao.setLocCarCodigo(controlCarro.controlRecuperarCarro(this.comboBoxCarro.getSelectedIndex()).getCarCodigo());
    modelLocacao.setLocCliCodigo(controlCliente.controlRecuperarCliente(this.comboBoxCliente.getSelectedIndex()).getCliCodigo());
    
    boolean resultado = controlLocacao.controlSalvarLocacao(modelLocacao);
    if(resultado==true){
        JOptionPane.showMessageDialog(this, "Locação gravada com sucesso!!");
        carregarLocacao();
    }else{
        JOptionPane.showMessageDialog(this, "Locação não realizada!!");
    }
}
 private void carregarLocacao() {
        listarLocacao = controlLocacao.controlListaLocacao();
        DefaultTableModel list = (DefaultTableModel) tbLocacao.getModel();
        list.setNumRows(0);
        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listarLocacao.size();
        for (int i = 0; i < cont; i++) {
            list.addRow(new Object[]{
                listarLocacao.get(i).getLocCodigo(),
                listarLocacao.get(i).getModelCliente().getCliNome(),
                listarLocacao.get(i).getModelCarro().getCarChassi(),
                listarLocacao.get(i).getModelFuncionario().getFunNome()
            });
        }
    }
//setar hora atual
public void setHora(){
    DataHora set = new DataHora();
        String hora = set.MostraHora();
        campoHoraLocacao.setText(hora);
}
public void setHoraD(){
    DataHora set = new DataHora();
        String hora = set.MostraHora();
        campoHoraDevolucao.setText(hora);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLocaleChooser1 = new com.toedter.components.JLocaleChooser();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        comboBoxCliente = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxCarro = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        comboBoxFuncionario = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        campoDataLocacao = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        campoHoraLocacao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLocacao = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        campoDataDevolucao = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        campoHoraDevolucao = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        campoTotal = new javax.swing.JFormattedTextField();
        comboBoxSituacao = new javax.swing.JComboBox<>();
        campoCodigo = new javax.swing.JTextField();
        campoQtdDias = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        campoPreco = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alocação de Carro");

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Cliente");

        comboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Nº da Alocação:");

        jLabel6.setText("Carro");

        comboBoxCarro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Funcionario:");

        jLabel8.setText("Data da Alocação:");

        campoDataLocacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoDataLocacaoKeyPressed(evt);
            }
        });

        jLabel9.setText("Hora da Alocação:");

        campoHoraLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoHoraLocacaoMouseClicked(evt);
            }
        });
        campoHoraLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoHoraLocacaoActionPerformed(evt);
            }
        });

        tbLocacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Cliente", "Carro", "Funcionario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbLocacao);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/cancelar24.png"))); // NOI18N
        jButton1.setText("Cancelar");

        jButton2.setBackground(new java.awt.Color(0, 191, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/cursor24.png"))); // NOI18N
        jButton2.setText("Select");

        jButton3.setBackground(new java.awt.Color(204, 0, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/excluir24.png"))); // NOI18N
        jButton3.setText("Delete");

        jButton4.setBackground(new java.awt.Color(0, 191, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/alterar24.png"))); // NOI18N
        jButton4.setText("Alterar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnGravar.setBackground(new java.awt.Color(0, 191, 255));
        btnGravar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGravar.setForeground(new java.awt.Color(255, 255, 255));
        btnGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/Salvar24.png"))); // NOI18N
        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGravar)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(btnGravar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel1.setText("Data Devolução:");

        jLabel2.setText("Hora Devolução:");

        campoHoraDevolucao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoHoraDevolucaoMouseClicked(evt);
            }
        });
        campoHoraDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoHoraDevolucaoActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantidade Dias:");

        jLabel10.setText("Tipo Locação:");

        jLabel11.setText("Preço Total");

        campoTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        campoTotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoTotalMouseClicked(evt);
            }
        });

        comboBoxSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoQtdDias.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jLabel12.setText("Preço:");

        campoPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        campoPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPrecoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(comboBoxCarro, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxCliente, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(campoDataLocacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoCodigo)
                                    .addComponent(campoHoraLocacao))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoQtdDias)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoDataDevolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoHoraDevolucao))))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoPreco))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(comboBoxSituacao, javax.swing.GroupLayout.Alignment.TRAILING, 0, 103, Short.MAX_VALUE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(campoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoQtdDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel1)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoHoraLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoHoraDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Locação", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
validarCampos();
    }//GEN-LAST:event_btnGravarActionPerformed

    private void campoHoraLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoHoraLocacaoActionPerformed
        setHora();
    }//GEN-LAST:event_campoHoraLocacaoActionPerformed

    private void campoDataLocacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDataLocacaoKeyPressed
       campoHoraLocacao.requestFocus();
    }//GEN-LAST:event_campoDataLocacaoKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      
    }//GEN-LAST:event_jButton4ActionPerformed

    private void campoHoraLocacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoHoraLocacaoMouseClicked
        setHora();
    }//GEN-LAST:event_campoHoraLocacaoMouseClicked

    private void campoHoraDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoHoraDevolucaoActionPerformed
        //hora devolução
        setHoraD();
    }//GEN-LAST:event_campoHoraDevolucaoActionPerformed

    private void campoHoraDevolucaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoHoraDevolucaoMouseClicked
        setHoraD();
    }//GEN-LAST:event_campoHoraDevolucaoMouseClicked

    private void campoPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPrecoActionPerformed
       int dias;
       double resultado, preco;
       String mostrar;
       dias = Integer.parseInt(campoQtdDias.getText());
       preco = Double.parseDouble(campoPreco.getText());
       resultado=calculo(dias, preco);
        mostrar = String.valueOf(resultado);
        campoTotal.setText(mostrar);
        campoTotal.setEditable(false);
    }//GEN-LAST:event_campoPrecoActionPerformed

    private void campoTotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoTotalMouseClicked
        int dias;
       double resultado, preco;
       String mostrar;
       dias = Integer.parseInt(campoQtdDias.getText());
       preco = Double.parseDouble(campoPreco.getText());
       resultado=calculo(dias, preco);
        mostrar = String.valueOf(resultado);
        campoTotal.setText(mostrar);
    }//GEN-LAST:event_campoTotalMouseClicked

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLocacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGravar;
    private javax.swing.JTextField campoCodigo;
    private com.toedter.calendar.JDateChooser campoDataDevolucao;
    private com.toedter.calendar.JDateChooser campoDataLocacao;
    private javax.swing.JFormattedTextField campoHoraDevolucao;
    private javax.swing.JTextField campoHoraLocacao;
    private javax.swing.JFormattedTextField campoPreco;
    private javax.swing.JFormattedTextField campoQtdDias;
    private javax.swing.JFormattedTextField campoTotal;
    private javax.swing.JComboBox<String> comboBoxCarro;
    private javax.swing.JComboBox<String> comboBoxCliente;
    private javax.swing.JComboBox<String> comboBoxFuncionario;
    private javax.swing.JComboBox<String> comboBoxSituacao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.components.JLocaleChooser jLocaleChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbLocacao;
    // End of variables declaration//GEN-END:variables
}
