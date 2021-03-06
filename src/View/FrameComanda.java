/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Cliente.BuscaCliente;
import Controller.Comanda.BuscaComanda;
import Controller.Produto.BuscaProduto;
import Model.Cliente;
import Model.Comanda;
import Model.ItemPedido;
import Model.Produto;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
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
        initComponents();
        this.getContentPane().setBackground(new Color(47, 64, 80));
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("empty-statement")
    private void CreateTable(int comandaId) throws SQLException {
        //Integer.parseInt(tfBuscaComanda.getText())
        ArrayList<ItemPedido> lista = BuscaComanda.ListarPedidosComanda(comandaId);

        String col[] = { "Produto", "Valor", "Quantidade", "Total"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for ( ItemPedido item : lista){
            Produto prod = BuscaProduto.Buscar(item.getProdutoId());
            Object[] i = {prod.getNome(), formatarMoeda((float) item.getValor()), item.getQuantidade(), formatarMoeda((float) (item.getValor() * item.getQuantidade())) };  
            tableModel.addRow(i);
        };
        jTable1.setModel(tableModel);
    }
    
    public String formatarFloat(float numeroF) {
        String retorno = "";

        DecimalFormat formatter = new DecimalFormat("#.00");
        try{
            retorno = formatter.format(numeroF).replace(",", ".");
        }catch(Exception ex){
          System.err.println("Erro ao formatar numero: " + ex);
        }
        return retorno;
    }
    
    public String formatarMoeda (float numero){
        Locale brasil = new Locale("pt", "BR");
        NumberFormat formatadorMoeda = NumberFormat.getCurrencyInstance(brasil);
        return formatadorMoeda.format(numero);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tfValorAcumulado = new javax.swing.JTextField();

        setTitle("Comanda");

        lblBuscaComanda.setForeground(new java.awt.Color(255, 255, 255));
        lblBuscaComanda.setText("Buscar por Id:");

        tfBuscaComanda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfBuscaComandaFocusLost(evt);
            }
        });
        tfBuscaComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBuscaComandaActionPerformed(evt);
            }
        });

        lblNomeCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeCliente.setText("Nome do cliente:");

        lblPedidos.setForeground(new java.awt.Color(255, 255, 255));
        lblPedidos.setText("Pedidos");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Valor", "Quantidade", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setCellSelectionEnabled(true);
        jTable1.setEditingRow(jTable1.getSelectedRow());
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Valor Acumulado:");

        tfValorAcumulado.setEditable(false);
        tfValorAcumulado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfValorAcumuladoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(lblPedidos)
                .addGap(0, 256, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNomeCliente)
                            .addComponent(jLabel1)
                            .addComponent(lblBuscaComanda))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfBuscaComanda, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                            .addComponent(tfNomeCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                            .addComponent(tfValorAcumulado))))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscaComanda)
                    .addComponent(tfBuscaComanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeCliente)
                    .addComponent(tfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfValorAcumulado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(lblPedidos)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfBuscaComandaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBuscaComandaFocusLost
        try {
            // TODO add your handling code here:
            Comanda comanda = BuscaComanda.Buscar(Integer.parseInt(tfBuscaComanda.getText()));
            Cliente cliente = BuscaCliente.Buscar(comanda.getClienteId());
            tfNomeCliente.setText(cliente.getNome());

            //tfValorAcumulado.setText(formatarFloat((float) cliente.getValorAcumulado()));
            tfValorAcumulado.setText(formatarMoeda((float)cliente.getValorAcumulado()));
            CreateTable(comanda.getId());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "ERRO", 0);
        }
    }//GEN-LAST:event_tfBuscaComandaFocusLost

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void tfValorAcumuladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfValorAcumuladoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfValorAcumuladoActionPerformed

    private void tfBuscaComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBuscaComandaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBuscaComandaActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBuscaComanda;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblPedidos;
    private javax.swing.JTextField tfBuscaComanda;
    private javax.swing.JTextField tfNomeCliente;
    private javax.swing.JTextField tfValorAcumulado;
    // End of variables declaration//GEN-END:variables
}
