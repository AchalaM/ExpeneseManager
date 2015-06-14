/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.view;

import com.epicsoft.expensemanager.controller.UserController;
import com.epicsoft.expensemanager.model.Currency;
import com.epicsoft.expensemanager.model.User;
import com.epicsoft.expensemanager.model.UserAccount;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class NewUserFrame extends javax.swing.JFrame {

    private UserController userController;
    /**
     * Creates new form NewUser
     */
    public NewUserFrame() {
        initComponents();
        userController = new UserController();
        setLocationRelativeTo(null);
        
        try {
            fillCurrencyTypeComboBoxes();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NewUserFrame.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        nameLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        passwordLabel1 = new javax.swing.JLabel();
        passwordLabel2 = new javax.swing.JLabel();
        nameTextFeild = new javax.swing.JTextField();
        usernameTextFeild = new javax.swing.JTextField();
        passwordFeild = new javax.swing.JPasswordField();
        currencyTypeComboBox = new javax.swing.JComboBox();
        symbolComboBox = new javax.swing.JComboBox();
        saveButton = new javax.swing.JLabel();
        cancelButton = new javax.swing.JLabel();
        errorMessageLabel = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("New User");

        nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameLabel.setText("Name");

        usernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        usernameLabel.setText("Username");

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passwordLabel.setText("Password");

        passwordLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passwordLabel1.setText("Currency Type");

        passwordLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passwordLabel2.setText("Symbol");

        nameTextFeild.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameTextFeild.setPreferredSize(new java.awt.Dimension(250, 26));

        usernameTextFeild.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        usernameTextFeild.setPreferredSize(new java.awt.Dimension(250, 26));
        usernameTextFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFeildActionPerformed(evt);
            }
        });
        usernameTextFeild.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                usernameTextFeildPropertyChange(evt);
            }
        });
        usernameTextFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameTextFeildKeyTyped(evt);
            }
        });

        passwordFeild.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordFeild.setMinimumSize(new java.awt.Dimension(150, 26));
        passwordFeild.setPreferredSize(new java.awt.Dimension(250, 26));

        currencyTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        symbolComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epicsoft/expensemanager/guiImages/SaveActive.png"))); // NOI18N
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveButtonMouseClicked(evt);
            }
        });

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epicsoft/expensemanager/guiImages/CancelActive.png"))); // NOI18N
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelButtonMouseClicked(evt);
            }
        });

        errorMessageLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        errorMessageLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorMessageLabel.setPreferredSize(new java.awt.Dimension(250, 14));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel)
                    .addComponent(usernameLabel)
                    .addComponent(passwordLabel)
                    .addComponent(passwordLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameTextFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTextFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cancelButton)
                            .addGap(30, 30, 30)
                            .addComponent(saveButton))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(currencyTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(64, 64, 64)
                            .addComponent(passwordLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(symbolComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(usernameTextFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(errorMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel1)
                    .addComponent(passwordLabel2)
                    .addComponent(currencyTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(symbolComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameTextFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFeildActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextFeildActionPerformed

    private void cancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_cancelButtonMouseClicked

    private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseClicked
        String name = nameTextFeild.getText();
        String username = usernameTextFeild.getText();
        String password = Arrays.toString(passwordFeild.getPassword());
        String currencyType = currencyTypeComboBox.getSelectedItem().toString();
        String currencySymbol =  symbolComboBox.getSelectedItem().toString();
        
        User user = new User(username, password);
        UserAccount useracc = new UserAccount(username, name, currencyType, currencySymbol);
        
        boolean result = false;
        if (isAllFieldsOK()) {
            try {
                result = userController.addNewUser(user, useracc);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(NewUserFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            if (result){
                JOptionPane.showMessageDialog(null, "New user created successfully", "Success", 1, null);
                LoginFrame logingFrame = new LoginFrame();
                this.dispose();
                logingFrame.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Couldn't add a new user", "ERROR", 2, null);
                nameTextFeild.setText("");
                usernameTextFeild.setText("");
                passwordFeild.setText("");
                nameTextFeild.requestFocus();
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Please fill all the feilds", "Caution", 3, null);
            if ("".equals(nameTextFeild.getText()))
                nameTextFeild.requestFocus();
            if ("".equals(usernameTextFeild.getText()))
                usernameTextFeild.requestFocus();
            if ("".equals(passwordFeild.getPassword()))
                passwordFeild.requestFocus();
        }
    }//GEN-LAST:event_saveButtonMouseClicked

   
    private void usernameTextFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameTextFeildKeyTyped
        /*if (userController.validateUsername(usernameTextFeild.getText()))
                errorMessageLabel.setText("This username already in use");
        else
            errorMessageLabel.setText("");*/
    }//GEN-LAST:event_usernameTextFeildKeyTyped

    private void usernameTextFeildPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_usernameTextFeildPropertyChange
       
    }//GEN-LAST:event_usernameTextFeildPropertyChange

    /**
     * Checks whether all the fields are filled before saving.
     */
    private boolean isAllFieldsOK(){
        boolean ok = false;
        if (!"".equals(nameTextFeild.getText()) && !"".equals(usernameTextFeild.getText()) && !"".equals(passwordFeild.getPassword())) {
            try {
                if (!userController.validateUsername(usernameTextFeild.getText()))
                    errorMessageLabel.setText("This username already in use");
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(NewUserFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            ok = true;
        }
        return ok;
    }
    /**
     * Fill the data to currency type comboBox
     */
    private void fillCurrencyTypeComboBoxes() throws ClassNotFoundException, SQLException{
        List<Currency> currencyList = userController.getCurrencyDetail();
        currencyTypeComboBox.removeAllItems();
        symbolComboBox.removeAllItems();
        
        for (Currency cur : currencyList) {
            currencyTypeComboBox.addItem(cur.getCurrencyType());
            symbolComboBox.addItem(cur.getSymbol());
        }
    }
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
            java.util.logging.Logger.getLogger(NewUserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewUserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewUserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewUserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewUserFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cancelButton;
    private javax.swing.JComboBox currencyTypeComboBox;
    private javax.swing.JLabel errorMessageLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextFeild;
    private javax.swing.JPasswordField passwordFeild;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JLabel passwordLabel2;
    private javax.swing.JLabel saveButton;
    private javax.swing.JComboBox symbolComboBox;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextFeild;
    // End of variables declaration//GEN-END:variables
}