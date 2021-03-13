/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.tela;

import br.com.autos.control.ControlCarro;
import br.com.autos.control.ControlCategoria;
import br.com.autos.model.ModelCarro;
import br.com.autos.model.ModelCategoria;
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
 * @version 1.0
 * 
 */
public class TelaCarro extends javax.swing.JFrame {
   ModelCarro modelCarro = new ModelCarro();
   ControlCarro controlCarro = new ControlCarro();
    ControlCategoria controlCategoria = new ControlCategoria();

    /**
     * Creates new form TelaCliente
     */
    public TelaCarro() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/com/autos/img/icCar48.png")));
        listarCategoria();
        addStatus();
        desabilitarCampos();
        carregarTabelaCarro();
        desabilitarBotao();
    }
    //Metodo Limpar campo
    public void limparCampos(){
        edtCarCodigo.setText("");
       edtCarChassi.setText("");
       edtCarPlaca.setText("");
       edtCarMarca.setText("");
       edtCarModelo.setText("");
       edtCarAno.setText("");
       edtCarCor.setText("");
       //comboListaCategoria.setToolTipText("");
    }
     //Metodo desabilitarCampos
    private void desabilitarCampos(){
        edtCarCodigo.setEnabled(false);
       edtCarChassi.setEnabled(false);
       edtCarPlaca.setEnabled(false);
       edtCarMarca.setEnabled(false);
       edtCarModelo.setEnabled(false);
       edtCarAno.setEnabled(false);
       edtCarCor.setEnabled(false);
       cbCategoria.setEnabled(false);
    }
     //Metodo desabiliatarBotões
    private void desabilitarBotao(){
       btnCarCancelar.setEnabled(false);
       btnCarExcluir.setEnabled(false);
       btnCarAlterar.setEnabled(false);
       btnCarLimpar.setEnabled(false);
       //btnCarSelect.setEnabled(false);
       btnCarSalve.setEnabled(false);
    }
     //Metodo habilitarBotões
    public void habilitarBotoes(){
        btnCarCancelar.setEnabled(true);
       btnCarExcluir.setEnabled(true);
       btnCarAlterar.setEnabled(true);
       btnCarLimpar.setEnabled(true);
       //btnCarSelect.setEnabled(false);
       btnCarSalve.setEnabled(true);
    }
     //metodo habilitar campos
    public void habilitarCampos(){
        edtCarCodigo.setEnabled(false);
       edtCarChassi.setEnabled(true);
       edtCarPlaca.setEnabled(true);
       edtCarMarca.setEnabled(true);
       edtCarModelo.setEnabled(true);
       edtCarAno.setEnabled(true);
       edtCarCor.setEnabled(true);
       cbCategoria.setEnabled(true);
    }
   
    //metodo  salvar
    public void salvarCarro(){
        ModelCarro pModelCarro = new ModelCarro();
        String txtCarChassi, txtPlaca, txtMarca, txtModelo, txtAno, txtCor, txtStatus;
        txtCarChassi = edtCarChassi.getText();
        txtPlaca = edtCarPlaca.getText();
        txtMarca = edtCarMarca.getText();
        txtModelo = edtCarModelo.getText();
        txtAno = edtCarAno.getText();
        txtCor = edtCarCor.getText();
        txtStatus = comboBoxStatus.getSelectedItem().toString();
        //verificar campos
        if(!txtCarChassi.isEmpty()){
            if(!txtPlaca.isEmpty()){
                if(!txtMarca.isEmpty()){
                    if(!txtModelo.isEmpty()){
                        if(!txtAno.isEmpty()){
                            if(!txtCor.isEmpty()){
                              modelCarro.setCarChassi(txtCarChassi);
                              modelCarro.setCarPlaca(txtPlaca);
                              modelCarro.setCarMarca(txtMarca);
                              modelCarro.setCarModelo(txtModelo);
                              modelCarro.setCarAno(txtAno);
                              modelCarro.setCarCor(txtCor);
                              modelCarro.setCarStatus(txtStatus);
                              modelCarro.setCategoriasCodigo(controlCategoria.controlGetRecuperarCodigoCat(this.cbCategoria.getSelectedIndex()).getCatCodigo());
                              boolean resultado=controlCarro.controlInsertCarro(modelCarro);
                              if(resultado ==true){
                                  carregarTabelaCarro();
                                  limparCampos();
                                  desabilitarBotao();
                                  desabilitarCampos();
                                  btnCarNovo.setEnabled(true);
                                  btnCarSelect.setEnabled(true);
                                  JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
                              }
        }else{
            JOptionPane.showMessageDialog(this, "Preencha o campo Cor");
            edtCarCor.requestFocus();
        }
        }else{
            JOptionPane.showMessageDialog(this, "Preencha o campo Ano");
            edtCarAno.requestFocus();
        }
        }else{
            JOptionPane.showMessageDialog(this, "Preencha o campo modelo");
            edtCarModelo.requestFocus();
        }
        }else{
            JOptionPane.showMessageDialog(this, "Preencha o campo Marca");
            edtCarMarca.requestFocus();
        }
        }else{
            JOptionPane.showMessageDialog(this, "Preencha o campo Placa");
            edtCarPlaca.requestFocus();
        }
        }else{
            JOptionPane.showMessageDialog(this, "Preencha o campo Chassi");
            edtCarChassi.requestFocus();
        }
        
    }
  
    //metodo update
    private void alterarCarro(){
        String txtCarChassi, txtPlaca, txtMarca, txtModelo, txtAno, txtCor;
        txtCarChassi = edtCarChassi.getText();
        txtPlaca = edtCarPlaca.getText();
        txtMarca = edtCarMarca.getText();
        txtModelo = edtCarModelo.getText();
        txtAno = edtCarAno.getText();
        txtCor = edtCarCor.getText();
        //verificar campos
        if(!txtCarChassi.isEmpty()){
            if(!txtPlaca.isEmpty()){
                if(!txtMarca.isEmpty()){
                    if(!txtModelo.isEmpty()){
                        if(!txtAno.isEmpty()){
                            if(!txtCor.isEmpty()){
                              ModelCarro pModelCarro = new ModelCarro();
                              pModelCarro.setCarCodigo(Integer.parseInt(this.edtCarCodigo.getText()));
                              pModelCarro.setCarChassi(txtCarChassi);
                              pModelCarro.setCarPlaca(txtPlaca);
                              pModelCarro.setCarMarca(txtMarca);
                              pModelCarro.setCarModelo(txtModelo);
                              pModelCarro.setCarAno(txtAno);
                              pModelCarro.setCarCor(txtCor);
                              pModelCarro.setCarStatus(comboBoxStatus.getSelectedItem().toString());
                              ModelCategoria categoriacodigo =controlCategoria.controlGetRecuperarCodigoCat(this.cbCategoria.getSelectedIndex());
                              pModelCarro.setCategoriasCodigo(categoriacodigo.getCatCodigo());
                              boolean resultado=controlCarro.controlUpdateCarro(pModelCarro);
                              if(resultado ==true){
                                  carregarTabelaCarro();
                                  limparCampos();
                                  desabilitarBotao();
                                  desabilitarCampos();
                                  btnCarNovo.setEnabled(true);
                                  btnCarSelect.setEnabled(true);
                                  JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
                              }
        }else{
            JOptionPane.showMessageDialog(this, "Preencha o campo Cor");
            edtCarCor.requestFocus();
        }
        }else{
            JOptionPane.showMessageDialog(this, "Preencha o campo Ano");
            edtCarAno.requestFocus();
        }
        }else{
            JOptionPane.showMessageDialog(this, "Preencha o campo modelo");
            edtCarModelo.requestFocus();
        }
        }else{
            JOptionPane.showMessageDialog(this, "Preencha o campo Marca");
            edtCarMarca.requestFocus();
        }
        }else{
            JOptionPane.showMessageDialog(this, "Preencha o campo Placa");
            edtCarPlaca.requestFocus();
        }
        }else{
            JOptionPane.showMessageDialog(this, "Preencha o campo Chassi");
            edtCarChassi.requestFocus();
        }
        
    
    }
    //metodo delete
    public void excluirCarro(){
        int linha = tabelaCarro.getSelectedRow();
        String txtCarro = (String) tabelaCarro.getValueAt(linha, 1);
        int codigo = (int) tabelaCarro.getValueAt(linha, 0);
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir: \n"
                +txtCarro+"?","Atenção",JOptionPane.YES_NO_OPTION);
        if(opcao==JOptionPane.OK_OPTION){
            boolean resultado = controlCarro.controlDeleteCarro(codigo);
            if(resultado == true){
                JOptionPane.showMessageDialog(this, "Registro Excluido com sucesso!");
                ((DefaultTableModel) tabelaCarro.getModel()).removeRow(tabelaCarro.getSelectedRow());
                limparCampos();
                desabilitarCampos();
                desabilitarBotao();
                btnCarNovo.setEnabled(true);
            }
        }
    }
    //metodo lista categoria
    private void listarCategoria(){
        ArrayList<ModelCategoria> listCategoria = new ArrayList<>();
        listCategoria = controlCategoria.controlGetListaCategoria();
        cbCategoria.removeAllItems();
        for (int i = 0; i < listCategoria.size(); i++){
            cbCategoria.addItem("");
            cbCategoria.addItem(listCategoria.get(i).getCatClasse());
        }
    }
    //add
    private void addStatus(){
        comboBoxStatus.removeAllItems();
        comboBoxStatus.addItem("");
        comboBoxStatus.addItem("Disponivel");
        comboBoxStatus.addItem("Indisponivel");
    }
    //metodo carregar tabela
    private void carregarTabelaCarro(){
        ArrayList<ModelCarro> listarCarro = new ArrayList<>();
        listarCarro = controlCarro.controlListarCarro();
        DefaultTableModel tableModel = (DefaultTableModel) tabelaCarro.getModel();
        //limpar tabela
        tableModel.setNumRows(0);
        int cont = listarCarro.size();
        for(int i = 0; i < cont; i++){  
            tableModel.addRow(new Object[]{
                listarCarro.get(i).getCarCodigo(),
                listarCarro.get(i).getCarChassi(),
                listarCarro.get(i).getCarPlaca(),
                listarCarro.get(i).getCarModelo(),
                listarCarro.get(i).getModelCategoria().getCatClasse()
            });
        }
        
    }
    //metodo selecionar carro
    public void recuperarCarro(){
        //recebe a linha selecionada
        int linha = this.tabelaCarro.getSelectedRow();
        //pegar o codigo da categoria selecionado
        int catCodigo = (int) tabelaCarro.getValueAt(linha, 0);
        try{
            //recuperar dados do banco de dados
            modelCarro = controlCarro.controlRecuperarCarro(catCodigo);
            //seta dados na interface
            this.edtCarCodigo.setText(String.valueOf(modelCarro.getCarCodigo()));
            this.edtCarChassi.setText(modelCarro.getCarChassi());
            this.edtCarPlaca.setText(modelCarro.getCarPlaca());
            this.edtCarMarca.setText(modelCarro.getCarMarca());
            this.edtCarModelo.setText(modelCarro.getCarModelo());
            this.edtCarAno.setText(modelCarro.getCarAno());
            this.edtCarCor.setText(modelCarro.getCarCor());
            this.comboBoxStatus.setSelectedItem(modelCarro.getCarStatus());
            this.cbCategoria.setSelectedItem(controlCategoria.controlGetRecuperarCodigoCat(modelCarro.getCategoriasCodigo()).getCatClasse());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,"Erro"+ex);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        edtCarCodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        edtCarChassi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        edtCarPlaca = new javax.swing.JTextField();
        edtCarMarca = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        edtCarModelo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        edtCarAno = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        edtCarCor = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        comboBoxStatus = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCarro = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        edtCarPesquisar = new javax.swing.JTextField();
        btnCarPesquisar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnCarCancelar = new javax.swing.JButton();
        btnCarAlterar = new javax.swing.JButton();
        btnCarExcluir = new javax.swing.JButton();
        btnCarSalve = new javax.swing.JButton();
        btnCarLimpar = new javax.swing.JButton();
        btnCarNovo = new javax.swing.JButton();
        btnCarSelect = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Carro");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastrar Carro");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Codigo:");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Chassi:");

        edtCarChassi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCarChassiActionPerformed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Placa:");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Marca:");

        edtCarPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCarPlacaActionPerformed(evt);
            }
        });

        edtCarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCarMarcaActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Modelo:");

        edtCarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCarModeloActionPerformed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Ano:");

        edtCarAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCarAnoActionPerformed(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Cor:");

        edtCarCor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCarCorActionPerformed(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Categoria:");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Status:");

        comboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(edtCarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(175, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edtCarChassi)
                            .addComponent(edtCarPlaca)
                            .addComponent(edtCarMarca)
                            .addComponent(edtCarModelo)
                            .addComponent(edtCarAno)
                            .addComponent(edtCarCor)
                            .addComponent(cbCategoria, 0, 202, Short.MAX_VALUE)
                            .addComponent(comboBoxStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(edtCarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(edtCarChassi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(edtCarPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(edtCarMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(edtCarModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(edtCarAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(edtCarCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(comboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Informações Carro");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Listar Carro");

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelaCarro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Chassi", "Placa", "Modelo", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaCarro);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("Pesquisar");

        btnCarPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon16/ic_pesquisar_16.png"))); // NOI18N
        btnCarPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(edtCarPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCarPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(edtCarPesquisar, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCarPesquisar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnCarCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/ic_cancel_24.png"))); // NOI18N
        btnCarCancelar.setText("Cancelar");
        btnCarCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCarCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCarCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarCancelarActionPerformed(evt);
            }
        });

        btnCarAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/ic_update_24.png"))); // NOI18N
        btnCarAlterar.setText("Alterar");
        btnCarAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCarAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCarAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarAlterarActionPerformed(evt);
            }
        });

        btnCarExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/ic_delete_24.png"))); // NOI18N
        btnCarExcluir.setText("Excluir");
        btnCarExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCarExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCarExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarExcluirActionPerformed(evt);
            }
        });

        btnCarSalve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/ic_salve_24.png"))); // NOI18N
        btnCarSalve.setText("Salvar");
        btnCarSalve.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCarSalve.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCarSalve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarSalveActionPerformed(evt);
            }
        });

        btnCarLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/ic_limpar_24.png"))); // NOI18N
        btnCarLimpar.setText("Limpar");
        btnCarLimpar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCarLimpar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnCarNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/ic_add_24.png"))); // NOI18N
        btnCarNovo.setText("Novo");
        btnCarNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCarNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCarNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarNovoActionPerformed(evt);
            }
        });

        btnCarSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/iconSelectROw24.png"))); // NOI18N
        btnCarSelect.setText("selecionar");
        btnCarSelect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCarSelect.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCarSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCarCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCarAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCarExcluir)
                .addGap(18, 18, 18)
                .addComponent(btnCarLimpar)
                .addGap(18, 18, 18)
                .addComponent(btnCarSelect)
                .addGap(18, 18, 18)
                .addComponent(btnCarSalve)
                .addGap(27, 27, 27)
                .addComponent(btnCarNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCarSalve)
                    .addComponent(btnCarSelect)
                    .addComponent(btnCarLimpar)
                    .addComponent(btnCarExcluir)
                    .addComponent(btnCarAlterar)
                    .addComponent(btnCarCancelar)
                    .addComponent(btnCarNovo))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCarSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarSelectActionPerformed
        recuperarCarro();
        habilitarCampos();
        btnCarNovo.setEnabled(false);
        btnCarAlterar.setEnabled(true);
        btnCarCancelar.setEnabled(true);
        btnCarExcluir.setEnabled(true);
    }//GEN-LAST:event_btnCarSelectActionPerformed

    private void btnCarExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarExcluirActionPerformed
        excluirCarro();
    }//GEN-LAST:event_btnCarExcluirActionPerformed

    private void btnCarNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarNovoActionPerformed
        // TODO add your handling code here:
        desabilitarBotao();
        habilitarCampos();
        btnCarSelect.setEnabled(false);
        btnCarNovo.setEnabled(false);
        btnCarCancelar.setEnabled(true);
        btnCarSalve.setEnabled(true);
        edtCarChassi.requestFocus();
    }//GEN-LAST:event_btnCarNovoActionPerformed

    private void btnCarCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarCancelarActionPerformed
        btnCarNovo.setEnabled(true);
        btnCarSelect.setEnabled(true);
        limparCampos();
        desabilitarBotao();
        desabilitarCampos();
    }//GEN-LAST:event_btnCarCancelarActionPerformed

    private void btnCarSalveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarSalveActionPerformed
        salvarCarro();
    }//GEN-LAST:event_btnCarSalveActionPerformed

    private void edtCarChassiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCarChassiActionPerformed
        edtCarPlaca.requestFocus();
    }//GEN-LAST:event_edtCarChassiActionPerformed

    private void edtCarPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCarPlacaActionPerformed
        edtCarMarca.requestFocus();
    }//GEN-LAST:event_edtCarPlacaActionPerformed

    private void edtCarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCarMarcaActionPerformed
        edtCarModelo.requestFocus();
    }//GEN-LAST:event_edtCarMarcaActionPerformed

    private void edtCarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCarModeloActionPerformed
        edtCarAno.requestFocus();
    }//GEN-LAST:event_edtCarModeloActionPerformed

    private void edtCarAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCarAnoActionPerformed
        edtCarCor.requestFocus();
    }//GEN-LAST:event_edtCarAnoActionPerformed

    private void edtCarCorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCarCorActionPerformed
        cbCategoria.requestFocus();
    }//GEN-LAST:event_edtCarCorActionPerformed

    private void btnCarAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarAlterarActionPerformed
        alterarCarro();
    }//GEN-LAST:event_btnCarAlterarActionPerformed

    private void btnCarPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarPesquisarActionPerformed
        DefaultTableModel tabela = (DefaultTableModel) this.tabelaCarro.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabela);
        this.tabelaCarro.setRowSorter(sorter);
        String text = edtCarPesquisar.getText();
        sorter.setRowFilter(RowFilter.regexFilter(text, 1));
    }//GEN-LAST:event_btnCarPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCarro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarAlterar;
    private javax.swing.JButton btnCarCancelar;
    private javax.swing.JButton btnCarExcluir;
    private javax.swing.JButton btnCarLimpar;
    private javax.swing.JButton btnCarNovo;
    private javax.swing.JButton btnCarPesquisar;
    private javax.swing.JButton btnCarSalve;
    private javax.swing.JButton btnCarSelect;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> comboBoxStatus;
    private javax.swing.JTextField edtCarAno;
    private javax.swing.JTextField edtCarChassi;
    private javax.swing.JTextField edtCarCodigo;
    private javax.swing.JTextField edtCarCor;
    private javax.swing.JTextField edtCarMarca;
    private javax.swing.JTextField edtCarModelo;
    private javax.swing.JTextField edtCarPesquisar;
    private javax.swing.JTextField edtCarPlaca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JTable tabelaCarro;
    // End of variables declaration//GEN-END:variables

   
}
