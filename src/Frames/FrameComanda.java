/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Classes.Comanda;
import Classes.ItemPedido;
import Classes.Produto;
import DAO.ClienteDAO;
import DAO.ComandaDAO;
import DAO.ProdutoDAO;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Henrique
 */
public class FrameComanda extends javax.swing.JFrame {

    /**
     * Creates new form FrameComanda
     * @throws java.sql.SQLException
     */
    public FrameComanda() throws SQLException {
        this.getContentPane().setBackground(new Color(250, 250, 250));
        initComponents();
    }
    
    ComandaDAO acessoComanda = new ComandaDAO();
    ProdutoDAO acessoProduto = new ProdutoDAO();
    
    @SuppressWarnings("empty-statement")
    private void CreateTable(int comandaId) throws SQLException {
        //Integer.parseInt(tfBuscaComanda.getText())
        ArrayList<ItemPedido> lista = acessoComanda.ListarPedidos(comandaId);

        String col[] = { "Produto", "Valor", "Quantidade", "Total"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for ( ItemPedido item : lista){
            Produto prod = acessoProduto.Buscar(item.getProdutoId());
            Object[] i = {acessoProduto.BuscarNomeProduto(item.getProdutoId()), item.getValor(), item.getQuantidade(), item.getValor() * item.getQuantidade() };  
            tableModel.addRow(i);
        };
        jTable1.setModel(tableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBuscaComanda = new javax.swing.JLabel();
        tfBuscaComanda = new javax.swing.JTextField();
        lblNomeCliente = new javax.swing.JLabel();
        tfNomeCliente = new javax.swing.JTextField();
        lblPedidos = new javax.swing.JLabel();
        btnFecharComanda = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        lblBuscaComanda.setText("Buscar por Id:");

        tfBuscaComanda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfBuscaComandaFocusLost(evt);
            }
        });

        lblNomeCliente.setText("Nome do cliente:");

        lblPedidos.setText("Pedidos");

        btnFecharComanda.setText("Fechar Comanda");
        btnFecharComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharComandaActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNomeCliente)
                            .addComponent(lblBuscaComanda))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                            .addComponent(tfBuscaComanda)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(lblPedidos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(btnFecharComanda))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscaComanda)
                    .addComponent(tfBuscaComanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeCliente)
                    .addComponent(tfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblPedidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFecharComanda)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfBuscaComandaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBuscaComandaFocusLost
        try {
            // TODO add your handling code here:
            Comanda comanda = acessoComanda.Buscar(Integer.parseInt(tfBuscaComanda.getText()));
            String nomeCliente = new ClienteDAO().BuscarNomeCliente(comanda.getClienteId());
            tfNomeCliente.setText(nomeCliente);
            CreateTable(comanda.getId());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "ERRO", 0);
        }
    }//GEN-LAST:event_tfBuscaComandaFocusLost

    private void btnFecharComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharComandaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFecharComandaActionPerformed

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
            java.util.logging.Logger.getLogger(FrameComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrameComanda().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrameComanda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFecharComanda;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBuscaComanda;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblPedidos;
    private javax.swing.JTextField tfBuscaComanda;
    private javax.swing.JTextField tfNomeCliente;
    // End of variables declaration//GEN-END:variables
}
