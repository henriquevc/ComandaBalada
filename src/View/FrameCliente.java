/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Cliente.BuscaCliente;
import Controller.Comanda.IncluiComanda;
import Controller.Cliente.SalvaCliente;
import Model.Cliente;
import Model.Comanda;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrique
 */
public class FrameCliente extends javax.swing.JFrame {

    /**
     * Creates new form Cliente
     */
    public FrameCliente() {
        this.getContentPane().setBackground(new Color(47, 64, 80));
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    Cliente cliente = new Cliente();
    Comanda comanda = new Comanda();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCpf = new javax.swing.JLabel();
        tfCpf = new javax.swing.JFormattedTextField();
        lblNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JFormattedTextField();
        lblValorAcumulado = new javax.swing.JLabel();
        btnSalvarAbrirComanda = new javax.swing.JButton();
        tfValorAcumulado = new javax.swing.JFormattedTextField();
        lblId = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setTitle("Cadastro Cliente");

        lblCpf.setForeground(new java.awt.Color(255, 255, 255));
        lblCpf.setText("CPF:");

        try {
            tfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCpfFocusLost(evt);
            }
        });
        tfCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCpfActionPerformed(evt);
            }
        });

        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome:");

        lblTelefone.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefone.setText("Telefone:");

        try {
            tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)*####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfTelefone.setToolTipText("");
        tfTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTelefoneActionPerformed(evt);
            }
        });

        lblValorAcumulado.setForeground(new java.awt.Color(255, 255, 255));
        lblValorAcumulado.setText("Valor Acumulado:");

        btnSalvarAbrirComanda.setText("Salvar e Abrir Comanda");
        btnSalvarAbrirComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAbrirComandaActionPerformed(evt);
            }
        });

        tfValorAcumulado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        tfValorAcumulado.setToolTipText("");
        tfValorAcumulado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfValorAcumuladoActionPerformed(evt);
            }
        });

        lblId.setForeground(new java.awt.Color(255, 255, 255));
        lblId.setText("Id:");

        tfId.setEditable(false);
        tfId.setDisabledTextColor(new java.awt.Color(153, 153, 153));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome)
                    .addComponent(lblCpf)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblValorAcumulado, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblTelefone))
                    .addComponent(lblId)
                    .addComponent(btnSalvar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tfTelefone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(tfCpf, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addGap(29, 29, 29)
                        .addComponent(btnSalvarAbrirComanda))
                    .addComponent(tfId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNome, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfValorAcumulado))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCpf))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefone))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfValorAcumulado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorAcumulado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarAbrirComanda)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarAbrirComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAbrirComandaActionPerformed
        // TODO add your handling code here:
        
        cliente.setId(Integer.parseInt(tfId.getText()));
        cliente.setNome(tfNome.getText());
        cliente.setCpf(tfCpf.getText());
        cliente.setTelefone(tfTelefone.getText());
        String valoracumulado = tfValorAcumulado.getText().replace(".", "").replace(",", ".");

        cliente.setValorAcumulado(Float.parseFloat(valoracumulado));
        try {
            int idCliente = SalvaCliente.Salvar(cliente);
            IncluiComanda.Incluir(comanda, idCliente);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao gravar no Banco", "ERRO", 0);
        }
        
    }//GEN-LAST:event_btnSalvarAbrirComandaActionPerformed
    

    
    public String formatarFloat(String numero){
        float numeroF = Float.parseFloat(numero);
        String retorno = "";
        DecimalFormat formatter = new DecimalFormat("#.00");
        try{
          retorno = formatter.format(numeroF);
        }catch(Exception ex){
          System.err.println("Erro ao formatar numero: " + ex);
        }
        return retorno;
    }
    private void tfCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCpfActionPerformed

    private void tfTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTelefoneActionPerformed

    private void tfCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCpfFocusLost

        // TODO add your handling code here:
        try {
            cliente = BuscaCliente.BuscaClienteCPF(tfCpf.getText());
            tfId.setText(String.valueOf(cliente.getId()));
            tfNome.setText(cliente.getNome());
            tfTelefone.setText(cliente.getTelefone());
            tfValorAcumulado.setText(formatarFloat(String.valueOf(cliente.getValorAcumulado())).replace(".", ","));
        } catch (SQLException ex) {
            Logger.getLogger(FrameCliente.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_tfCpfFocusLost

    private void tfValorAcumuladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfValorAcumuladoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfValorAcumuladoActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        tfId.setText("");
        tfCpf.setText("");
        tfNome.setText("");
        tfTelefone.setText("");
        tfValorAcumulado.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        cliente.setId(Integer.parseInt(tfId.getText()));
        cliente.setNome(tfNome.getText());
        cliente.setCpf(tfCpf.getText());
        cliente.setTelefone(tfTelefone.getText());
        String valoracumulado = tfValorAcumulado.getText().replace(".", "").replace(",", ".");
        cliente.setValorAcumulado(Float.parseFloat(valoracumulado));
        try {
            int idCliente = SalvaCliente.Salvar(cliente);
            tfId.setText(String.valueOf(idCliente));
        } catch (SQLException ex) {
            Logger.getLogger(FrameCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed
    
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
            java.util.logging.Logger.getLogger(FrameCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameCliente().setVisible(true);
            }
        });
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSalvarAbrirComanda;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblValorAcumulado;
    private javax.swing.JFormattedTextField tfCpf;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNome;
    private javax.swing.JFormattedTextField tfTelefone;
    private javax.swing.JFormattedTextField tfValorAcumulado;
    // End of variables declaration//GEN-END:variables
}
