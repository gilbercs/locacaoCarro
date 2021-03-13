/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.tela;

import br.com.autos.control.ControlOficina;
import br.com.autos.model.ModelOficina;
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
 */
public class TelaOficina extends javax.swing.JFrame {
    ControlOficina controlOficina = new ControlOficina();
    ModelOficina modelOficina = new ModelOficina();
    ArrayList<ModelOficina> listOficina = new ArrayList<>();

    /**
     * Creates new form TelaOficina
     */
    public TelaOficina() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/com/autos/img/iconOficina48.png")));
        this.carregarTabelaOficina();
        edtOfiCodigo.setEnabled(false);
    }
    //Metodo limpar campos
    public void limparCampos(){
        edtOfiCodigo.setText("");
        edtOfiNome.setText("");
        edtOfiDescricao.setText("");
    }
    //metodo desabiliatar
    private void desabilitar(){
        edtOfiCodigo.setEnabled(false);
        edtOfiNome.setEnabled(false);
        edtOfiDescricao.setEnabled(false);
    }
    //metodo habiliatar
    public void habilitar(){
        edtOfiCodigo.setEnabled(false);
        edtOfiNome.setEnabled(true);
        edtOfiDescricao.setEnabled(true);
    }
    //verificar campos
    public void verificarCampos(){
        //validar campos
        String txtNome;
        txtNome = edtOfiNome.getText();
        if(!txtNome.isEmpty()){
            cadastroOficina();
        }else{
            edtOfiNome.requestFocus();
            JOptionPane.showMessageDialog(this, "Preencha o campo Nome!");
        }
    }
    //metodo cadastro
    public boolean cadastroOficina(){
        modelOficina.setOfiNome(this.edtOfiNome.getText());
        modelOficina.setOfiDescricao(this.edtOfiDescricao.getText());
        boolean resultado = controlOficina.controlCadastroOficina(modelOficina);
        if(resultado==true){
            limparCampos();
            desabilitar();
            carregarTabelaOficina();
            JOptionPane.showMessageDialog(this, "Oficina cadastrada com sucesso!!");
            return true;
        }else{
            JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    //metodo atualizar
    public boolean alterarOficina(){
        modelOficina.setOfiCodigo(Integer.parseInt(this.edtOfiCodigo.getText()));
        modelOficina.setOfiNome(this.edtOfiNome.getText());
        modelOficina.setOfiDescricao(this.edtOfiDescricao.getText());
        boolean resultado = controlOficina.controlAlterarOficina(modelOficina);
        if(resultado==true){
            limparCampos();
            carregarTabelaOficina();
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!!");
            return true;
        }else{
            JOptionPane.showMessageDialog(this, "Erro ao alterar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    //metodo excluir oficina
    public void excluirOficina(){
        desabilitar();
        //linha selecionada
        int linha = tabelaOficina.getSelectedRow();
        String tNome = (String) tabelaOficina.getValueAt(linha, 1);
        int codigo = (int) tabelaOficina.getValueAt(linha, 0);
        modelOficina = controlOficina.controlRecuperarOficinaCodigo(codigo);
            edtOfiCodigo.setText(String.valueOf(modelOficina.getOfiCodigo()));
            edtOfiNome.setText(modelOficina.getOfiNome());
            edtOfiDescricao.setText(modelOficina.getOfiDescricao());
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir a Oficina: \n"
                +tNome+"?","Atenção",JOptionPane.YES_NO_OPTION);
        if(opcao==JOptionPane.OK_OPTION){
            boolean resultado = controlOficina.controlExcluirOficina(codigo);
            if(resultado == true){
                JOptionPane.showMessageDialog(this, "Oficina Excluida com sucesso!");
                carregarTabelaOficina();
                limparCampos();
            }
        }
    }
    //carregar tabela oficina
    private void carregarTabelaOficina(){
        listOficina = controlOficina.controlListarOficina();
        DefaultTableModel tableModel = (DefaultTableModel) tabelaOficina.getModel();
        tableModel.setNumRows(0);
        int cont = listOficina.size();
        for(int i = 0; i < cont; i++){  
            tableModel.addRow(new Object[]{
                listOficina.get(i).getOfiCodigo(),
                listOficina.get(i).getOfiNome()
            });
        }    
    }
    //recuperar oficina na tabela
    public void recuperarOficina(){
        //recebe a linha selecionada
        int linha = this.tabelaOficina.getSelectedRow();
        //recuperar codigo da oficina selecionado
        int ofiCodigo = (int) tabelaOficina.getValueAt(linha, 0);
        try{
            //recuperar dados do banco de dados
            modelOficina = controlOficina.controlRecuperarOficinaCodigo(ofiCodigo);
            //seta dados na interface
            edtOfiCodigo.setText(String.valueOf(modelOficina.getOfiCodigo()));
            edtOfiNome.setText(modelOficina.getOfiNome());
            edtOfiDescricao.setText(modelOficina.getOfiDescricao());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,"Erro");
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        edtOfiCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        edtOfiNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        edtOfiDescricao = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnOfiSelect = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnSlavar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        edtPesquisa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaOficina = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Oficina");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro Oficina");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Codigo:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nome:");

        edtOfiNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtOfiNomeActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Descrição:");

        edtOfiDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtOfiDescricaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(edtOfiCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edtOfiNome)
                            .addComponent(edtOfiDescricao))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(edtOfiCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(edtOfiNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(edtOfiDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(144, Short.MAX_VALUE))
        );

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/ic_cancel_24.png"))); // NOI18N
        btnCancelar.setText("Cancelar");

        btnOfiSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/iconSelectROw24.png"))); // NOI18N
        btnOfiSelect.setText("Select");
        btnOfiSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOfiSelectActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/ic_delete_24.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/ic_update_24.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnSlavar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon24/ic_salve_24.png"))); // NOI18N
        btnSlavar.setText("Salvar");
        btnSlavar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSlavarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOfiSelect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSlavar)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnOfiSelect)
                    .addComponent(btnExcluir)
                    .addComponent(btnAlterar)
                    .addComponent(btnSlavar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/autos/icon16/ic_pesquisar_16.png"))); // NOI18N
        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(edtPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelaOficina.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabelaOficina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaOficina);
        if (tabelaOficina.getColumnModel().getColumnCount() > 0) {
            tabelaOficina.getColumnModel().getColumn(0).setMinWidth(50);
            tabelaOficina.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelaOficina.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSlavarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSlavarActionPerformed
         //metodo salvar dados
        verificarCampos();
    }//GEN-LAST:event_btnSlavarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        String txtNome;
        txtNome = edtOfiNome.getText();
        if(!txtNome.isEmpty()){
            alterarOficina();
        }else{
            edtOfiNome.requestFocus();
            JOptionPane.showMessageDialog(this, "Preencha o campo nome!");
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void edtOfiNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtOfiNomeActionPerformed
        edtOfiDescricao.requestFocus();
    }//GEN-LAST:event_edtOfiNomeActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluirOficina();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnOfiSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOfiSelectActionPerformed
        recuperarOficina();
    }//GEN-LAST:event_btnOfiSelectActionPerformed

    private void edtOfiDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtOfiDescricaoActionPerformed
        btnSlavar.requestFocus();
    }//GEN-LAST:event_edtOfiDescricaoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel tabela = (DefaultTableModel) this.tabelaOficina.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabela);
        this.tabelaOficina.setRowSorter(sorter);
        String text = edtPesquisa.getText();
        sorter.setRowFilter(RowFilter.regexFilter(text, 1));
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaOficina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaOficina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaOficina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaOficina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaOficina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnOfiSelect;
    private javax.swing.JButton btnSlavar;
    private javax.swing.JTextField edtOfiCodigo;
    private javax.swing.JTextField edtOfiDescricao;
    private javax.swing.JTextField edtOfiNome;
    private javax.swing.JTextField edtPesquisa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaOficina;
    // End of variables declaration//GEN-END:variables
}
