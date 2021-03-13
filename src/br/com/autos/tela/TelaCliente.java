/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.tela;

import br.com.autos.control.ControlCliente;
import br.com.autos.model.ModelCliente;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Gilber
 */
public class TelaCliente extends javax.swing.JFrame {
    //instancia da classe ModelCliente e ControlCliente
    ModelCliente modelCliente = new ModelCliente();
    ControlCliente controlCliente = new ControlCliente();
    ArrayList<ModelCliente> listClientes = new ArrayList<>();
    /**
     * Creates new form TelaCliente
     */
    public TelaCliente() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/com/autos/img/icCliente48.png")));
        desabilitarCampos();
        desabilitarBotões();
        carregarTabelaCliente();
    }
public boolean verificarUF(){
        if (edtCliUf.getText().length() > 2){
            JOptionPane.showMessageDialog(this, "Preencha o campo UF corretamente!");
            return false;
        }
        return true;
    }

//metodo limpar campos
public void limparCampos(){
    edtCliCodigo.setText("");
    edtCliNome.setText("");
    edtCliIdade.setText("");
    edtCliCnh.setText("");
    edtCliRua.setText("");
    edtCliNumero.setText("");
    edtCliCep.setText("");
    edtCliBairro.setText("");
    edtCliCidade.setText("");
    edtCliUf.setText("");
}
/**
 * metodo habilitar campo
 */
public void habilitarCampos(){
    edtCliCodigo.setEnabled(false);
    edtCliNome.setEnabled(true);
    edtCliIdade.setEnabled(true);
    edtCliCnh.setEnabled(true);
    edtCliRua.setEnabled(true);
    edtCliNumero.setEnabled(true);
    edtCliCep.setEnabled(true);
    edtCliBairro.setEnabled(true);
    edtCliCidade.setEnabled(true);
    edtCliUf.setEnabled(true);
}
/**
 * metodo desabilitar campo
 */
public void desabilitarCampos(){
    edtCliCodigo.setEnabled(false);
    edtCliNome.setEnabled(false);
    edtCliIdade.setEnabled(false);
    edtCliCnh.setEnabled(false);
    edtCliRua.setEnabled(false);
    edtCliNumero.setEnabled(false);
    edtCliCep.setEnabled(false);
    edtCliBairro.setEnabled(false);
    edtCliCidade.setEnabled(false);
    edtCliUf.setEnabled(false);
}
/**
 * metodo desabilitar botões
 */
public void desabilitarBotões(){
    btnCliCancelar.setEnabled(false);
    btnCliExcluir.setEnabled(false);
    btnCliSalve.setEnabled(false);
    btnCliLimpar.setEnabled(false);
    btnCliAlterar.setEnabled(false);
}
/**
 * metodo habilitar botões
 */
public void habilitarBotões(){
    btnCliCancelar.setEnabled(true);
    btnCliExcluir.setEnabled(true);
    btnCliSalve.setEnabled(true);
    btnCliLimpar.setEnabled(true);
    btnCliAlterar.setEnabled(true);
}
//
public void salvarDadosClientes(){
     int cliCodigo;
    String cliNome;
    int cliIdade;
    String cliCnh;
    String cliRua;
    int cliNumero;
    String cliCep;
    String cliBairro;
    String cliCidade;
    String cliUf;
    cliNome = edtCliNome.getText();
    cliIdade = Integer.parseInt(edtCliIdade.getText());
    cliCnh = edtCliCnh.getText();
    cliRua = edtCliRua.getText();
    cliNumero = Integer.parseInt(edtCliNumero.getText());
    cliCep = edtCliCep.getText();
    cliBairro = edtCliBairro.getText();
    cliCidade = edtCliCidade.getText();
    cliUf = edtCliUf.getText();
    if(!cliNome.isEmpty()){
        if(cliIdade > 17){
        if(!cliCnh.isEmpty()){
        if(!cliRua.isEmpty()){
        if(cliNumero>0){
        if(!cliCep.isEmpty()){
        if(!cliBairro.isEmpty()){
        if(!cliCidade.isEmpty()){
        if(cliUf.length()== 2){
            modelCliente.setCliNome(cliNome);
            modelCliente.setIdade(cliIdade);
            modelCliente.setCliCnh(cliCnh);
            modelCliente.setCliRua(cliRua);
            modelCliente.setCliNumero(cliNumero);
            modelCliente.setCliCep(cliCep);
            modelCliente.setCliBairro(cliBairro);
            modelCliente.setCliCidade(cliCidade);
            modelCliente.setCliUf(cliUf);
            boolean resultado = controlCliente.controlSalvarCliente(modelCliente);
            if(resultado == true){
                JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
                desabilitarBotões();
                desabilitarCampos();
                btnCliNovo.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar!");
                limparCampos();
                habilitarCampos();
                habilitarBotões();
                btnCliNovo.setEnabled(false);
            }
            
    }else{
        JOptionPane.showMessageDialog(this, "Preencha o campo UF, EX: AM!");
        edtCliUf.requestFocus();
    }
    }else{
        JOptionPane.showMessageDialog(this, "Preencha o campo Cidade!");
        edtCliCidade.requestFocus();
    }
    }else{
        JOptionPane.showMessageDialog(this, "Preencha o campo Bairro!");
        edtCliBairro.requestFocus();
    }
        
    }else{
        JOptionPane.showMessageDialog(this, "Preencha o campo Cep!");
        edtCliCep.requestFocus();
    }
    }else{
        JOptionPane.showMessageDialog(this, "Preencha o campo Numero!");
        edtCliNumero.requestFocus();
    }
    }else{
        JOptionPane.showMessageDialog(this, "Preencha o campo Rua!");
        edtCliRua.requestFocus();
    }
    }else{
        JOptionPane.showMessageDialog(this, "Preencha o campo CNH!");
        edtCliCnh.requestFocus();
    }
    }else{
        JOptionPane.showMessageDialog(this, "Preencha o campo Idade!");
        edtCliIdade.requestFocus();
    }
    }else{
        JOptionPane.showMessageDialog(this, "Preencha o campo Nome!");
        edtCliNome.requestFocus();
    }
}
/**
 * carregar tabela clientes
 */
    public void carregarTabelaCliente(){
        ArrayList<ModelCliente> listarCliente = new ArrayList<>();
        listarCliente = controlCliente.controlGetListarClientes();
        DefaultTableModel tableModel = (DefaultTableModel) tabelaCliente.getModel();
        tableModel.setNumRows(0);
        int cont = listarCliente.size();
        for(int i = 0; i < cont; i++){  
            tableModel.addRow(new Object[]{
                listarCliente.get(i).getCliCodigo(),
                listarCliente.get(i).getCliNome(),
                listarCliente.get(i).getIdade(),
                listarCliente.get(i).getCliCnh()
            });
        }    
    }
 /**
 * recuperar cliente selecionado na tabela
 */
public void recuperarCliente(){
        //recebe a linha selecionada
        int linha = this.tabelaCliente.getSelectedRow();
        //recuperar codigo do cliente selecionado
        int cliCodigo = (int) tabelaCliente.getValueAt(linha, 0);
        try{
            //recuperar dados do banco de dados
            modelCliente = controlCliente.controlRecuperarCliente(cliCodigo);
            //seta dados na interface
    edtCliCodigo.setText(String.valueOf(modelCliente.getCliCodigo()));
    edtCliNome.setText(modelCliente.getCliNome());
    edtCliIdade.setText(String.valueOf(modelCliente.getIdade()));
    edtCliCnh.setText(modelCliente.getCliCnh());
    edtCliRua.setText(modelCliente.getCliRua());
    edtCliNumero.setText(String.valueOf(modelCliente.getCliNumero()));
    edtCliCep.setText(modelCliente.getCliCep());
    edtCliBairro.setText(modelCliente.getCliBairro());
    edtCliCidade.setText(modelCliente.getCliCidade());
    edtCliUf.setText(modelCliente.getCliUf());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,"Erro");
        }
        
    }
//metodo alterar cliente no banco de dados
public void alterarClientes(){
     int cliCodigo;
    String cliNome;
    int cliIdade;
    String cliCnh;
    String cliRua;
    int cliNumero;
    String cliCep;
    String cliBairro;
    String cliCidade;
    String cliUf;
    cliCodigo = Integer.parseInt(edtCliCodigo.getText());
    cliNome = edtCliNome.getText();
    cliIdade = Integer.parseInt(edtCliIdade.getText());
    cliCnh = edtCliCnh.getText();
    cliRua = edtCliRua.getText();
    cliNumero = Integer.parseInt(edtCliNumero.getText());
    cliCep = edtCliCep.getText();
    cliBairro = edtCliBairro.getText();
    cliCidade = edtCliCidade.getText();
    cliUf = edtCliUf.getText();
    if(!cliNome.isEmpty()){
        if(cliIdade > 17){
        if(!cliCnh.isEmpty()){
        if(!cliRua.isEmpty()){
        if(cliNumero>0){
        if(!cliCep.isEmpty()){
        if(!cliBairro.isEmpty()){
        if(!cliCidade.isEmpty()){
        if(cliUf.length()== 2){
            modelCliente.setCliCodigo(cliCodigo);
            modelCliente.setCliNome(cliNome);
            modelCliente.setIdade(cliIdade);
            modelCliente.setCliCnh(cliCnh);
            modelCliente.setCliRua(cliRua);
            modelCliente.setCliNumero(cliNumero);
            modelCliente.setCliCep(cliCep);
            modelCliente.setCliBairro(cliBairro);
            modelCliente.setCliCidade(cliCidade);
            modelCliente.setCliUf(cliUf);
            boolean resultado = controlCliente.controlUpdateCliente(modelCliente);
            if(resultado == true){
                JOptionPane.showMessageDialog(this, "Cliente Alterado com sucesso!");
                desabilitarBotões();
                desabilitarCampos();
                btnCliNovo.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(this, "Erro ao alterar!");
                limparCampos();
                habilitarCampos();
                habilitarBotões();
                btnCliNovo.setEnabled(false);
            }
            
    }else{
        JOptionPane.showMessageDialog(this, "Preencha o campo UF, EX: AM!");
        edtCliUf.requestFocus();
    }
    }else{
        JOptionPane.showMessageDialog(this, "Preencha o campo Cidade!");
        edtCliCidade.requestFocus();
    }
    }else{
        JOptionPane.showMessageDialog(this, "Preencha o campo Bairro!");
        edtCliBairro.requestFocus();
    }
        
    }else{
        JOptionPane.showMessageDialog(this, "Preencha o campo Cep!");
        edtCliCep.requestFocus();
    }
    }else{
        JOptionPane.showMessageDialog(this, "Preencha o campo Numero!");
        edtCliNumero.requestFocus();
    }
    }else{
        JOptionPane.showMessageDialog(this, "Preencha o campo Rua!");
        edtCliRua.requestFocus();
    }
    }else{
        JOptionPane.showMessageDialog(this, "Preencha o campo CNH!");
        edtCliCnh.requestFocus();
    }
    }else{
        JOptionPane.showMessageDialog(this, "Preencha o campo Idade!");
        edtCliIdade.requestFocus();
    }
    }else{
        JOptionPane.showMessageDialog(this, "Preencha o campo Nome!");
        edtCliNome.requestFocus();
    }
}
/**
     * metodo excluir funcionario
     * 
     */
    public void excluirCliente(){
        desabilitarCampos();
        int linha = tabelaCliente.getSelectedRow();
        String tNome = (String) tabelaCliente.getValueAt(linha, 1);
        int codigo = (int) tabelaCliente.getValueAt(linha, 0);
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o Cliente: \n"
                +tNome+"?","Atenção",JOptionPane.YES_NO_OPTION);
        if(opcao==JOptionPane.OK_OPTION){
            boolean resultado = controlCliente.controlDeleteCliente(codigo);
            if(resultado == true){
                JOptionPane.showMessageDialog(this, "Cliente Excluido com sucesso!");
                carregarTabelaCliente();
                limparCampos();
                desabilitarCampos();
                desabilitarBotões();
                btnCliNovo.setEnabled(true);
            }
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

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        edtCliCodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        edtCliNome = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        edtCliIdade = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        edtCliCnh = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        edtCliRua = new javax.swing.JTextField();
        edtCliNumero = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        edtCliCep = new javax.swing.JFormattedTextField();
        edtCliBairro = new javax.swing.JTextField();
        edtCliCidade = new javax.swing.JTextField();
        edtCliUf = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        edtCliPesquisar = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnCliCancelar = new javax.swing.JButton();
        btnCliLimpar = new javax.swing.JButton();
        btnCliExcluir = new javax.swing.JButton();
        btnCliAlterar = new javax.swing.JButton();
        btnCliSalve = new javax.swing.JButton();
        btnCliNovo = new javax.swing.JButton();
        btnSelect = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setTitle("Cadastro de cliente");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Cliente");

        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Idade", "CNH"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
        jScrollPane1.setViewportView(tabelaCliente);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Codigo:");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Nome:");

        edtCliNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCliNomeActionPerformed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Idade:");

        edtCliIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCliIdadeActionPerformed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("CNH:");

        edtCliCnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCliCnhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(edtCliCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edtCliIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtCliNome)
                            .addComponent(edtCliCnh, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(edtCliCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(edtCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(edtCliIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(edtCliCnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Informações Pessoais do Cliente");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Endereço");

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Rua:");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Numero:");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Bairro:");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Cidade:");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("UF:");

        edtCliRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCliRuaActionPerformed(evt);
            }
        });

        edtCliNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCliNumeroActionPerformed(evt);
            }
        });

        jLabel15.setText("CEP:");

        edtCliCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCliCepActionPerformed(evt);
            }
        });

        edtCliBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCliBairroActionPerformed(evt);
            }
        });

        edtCliCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCliCidadeActionPerformed(evt);
            }
        });

        edtCliUf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCliUfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(edtCliRua)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(edtCliNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCliCep))
                    .addComponent(edtCliBairro)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(edtCliCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCliUf, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(edtCliRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(edtCliNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(edtCliCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(edtCliBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edtCliCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(edtCliUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon16/ic_pesquisar_16.png"))); // NOI18N
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(edtCliPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(edtCliPesquisar, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCliCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/ic_cancel_24.png"))); // NOI18N
        btnCliCancelar.setText("Cancelar");
        btnCliCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCliCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCliCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliCancelarActionPerformed(evt);
            }
        });

        btnCliLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/ic_limpar_24.png"))); // NOI18N
        btnCliLimpar.setText("Limpar");
        btnCliLimpar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCliLimpar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCliLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliLimparActionPerformed(evt);
            }
        });

        btnCliExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/ic_delete_24.png"))); // NOI18N
        btnCliExcluir.setText("Excluir");
        btnCliExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCliExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCliExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliExcluirActionPerformed(evt);
            }
        });

        btnCliAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/ic_update_24.png"))); // NOI18N
        btnCliAlterar.setText("Alterar");
        btnCliAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCliAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCliAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliAlterarActionPerformed(evt);
            }
        });

        btnCliSalve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/ic_salve_24.png"))); // NOI18N
        btnCliSalve.setText("Salvar");
        btnCliSalve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCliSalve.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCliSalve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliSalveActionPerformed(evt);
            }
        });

        btnCliNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/ic_add_24.png"))); // NOI18N
        btnCliNovo.setText("Novo");
        btnCliNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCliNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCliNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliNovoActionPerformed(evt);
            }
        });

        btnSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/iconSelectROw24.png"))); // NOI18N
        btnSelect.setText("selecionar");
        btnSelect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSelect.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCliCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCliLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCliExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCliAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCliSalve)
                .addGap(18, 18, 18)
                .addComponent(btnCliNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSelect)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCliNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCliSalve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCliAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCliExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCliLimpar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCliCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(38, 38, 38))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCliAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliAlterarActionPerformed
                   //recuperarCliente();
                   alterarClientes();
                   limparCampos();
                   carregarTabelaCliente();
    }//GEN-LAST:event_btnCliAlterarActionPerformed

    private void btnCliNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliNovoActionPerformed
        // TODO add your handling code here:
        btnCliNovo.setEnabled(false);
        habilitarCampos();
        habilitarBotões();
        btnCliAlterar.setEnabled(false);
        btnCliExcluir.setEnabled(false);
        edtCliNome.requestFocus();
    }//GEN-LAST:event_btnCliNovoActionPerformed

    private void btnCliSalveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliSalveActionPerformed
        // TODO add your handling code here:
        salvarDadosClientes();
        limparCampos();
        carregarTabelaCliente();
    }//GEN-LAST:event_btnCliSalveActionPerformed

    private void btnCliCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliCancelarActionPerformed
        carregarTabelaCliente();
        desabilitarCampos();
        desabilitarBotões();
        limparCampos();
        btnCliNovo.setEnabled(true);
    }//GEN-LAST:event_btnCliCancelarActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        recuperarCliente();
        habilitarCampos();
        habilitarBotões();
        btnCliNovo.setEnabled(false);
        btnCliSalve.setEnabled(false);
    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnCliExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliExcluirActionPerformed
        excluirCliente();
    }//GEN-LAST:event_btnCliExcluirActionPerformed

    private void btnCliLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnCliLimparActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
         DefaultTableModel tabela = (DefaultTableModel) this.tabelaCliente.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabela);
        this.tabelaCliente.setRowSorter(sorter);
        String text = edtCliPesquisar.getText();
        sorter.setRowFilter(RowFilter.regexFilter(text, 1));
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void edtCliNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCliNomeActionPerformed
        edtCliIdade.requestFocus();
    }//GEN-LAST:event_edtCliNomeActionPerformed

    private void edtCliIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCliIdadeActionPerformed
        edtCliCnh.requestFocus();
    }//GEN-LAST:event_edtCliIdadeActionPerformed

    private void edtCliCnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCliCnhActionPerformed
        edtCliRua.requestFocus();
    }//GEN-LAST:event_edtCliCnhActionPerformed

    private void edtCliRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCliRuaActionPerformed
        edtCliNumero.requestFocus();
    }//GEN-LAST:event_edtCliRuaActionPerformed

    private void edtCliNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCliNumeroActionPerformed
        edtCliCep.requestFocus();
    }//GEN-LAST:event_edtCliNumeroActionPerformed

    private void edtCliCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCliCepActionPerformed
        edtCliBairro.requestFocus();
    }//GEN-LAST:event_edtCliCepActionPerformed

    private void edtCliBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCliBairroActionPerformed
        edtCliCidade.requestFocus();
    }//GEN-LAST:event_edtCliBairroActionPerformed

    private void edtCliCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCliCidadeActionPerformed
        edtCliUf.requestFocus();
    }//GEN-LAST:event_edtCliCidadeActionPerformed

    private void edtCliUfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCliUfActionPerformed
        btnCliSalve.requestFocus();
    }//GEN-LAST:event_edtCliUfActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliAlterar;
    private javax.swing.JButton btnCliCancelar;
    private javax.swing.JButton btnCliExcluir;
    private javax.swing.JButton btnCliLimpar;
    private javax.swing.JButton btnCliNovo;
    private javax.swing.JButton btnCliSalve;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSelect;
    private javax.swing.JTextField edtCliBairro;
    private javax.swing.JFormattedTextField edtCliCep;
    private javax.swing.JTextField edtCliCidade;
    private javax.swing.JTextField edtCliCnh;
    private javax.swing.JTextField edtCliCodigo;
    private javax.swing.JFormattedTextField edtCliIdade;
    private javax.swing.JTextField edtCliNome;
    private javax.swing.JFormattedTextField edtCliNumero;
    private javax.swing.JTextField edtCliPesquisar;
    private javax.swing.JTextField edtCliRua;
    private javax.swing.JFormattedTextField edtCliUf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaCliente;
    // End of variables declaration//GEN-END:variables

   
}
