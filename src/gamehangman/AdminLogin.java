
package gamehangman;

import javax.swing.JOptionPane;


public class AdminLogin extends javax.swing.JFrame {

     String nameAdmin = "admin";
    String passwordAdmin = "hangman";
   
    public AdminLogin() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        adminName = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        login = new javax.swing.JButton();
        passField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        title.setFont(new java.awt.Font("Viner Hand ITC", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(153, 102, 0));
        title.setText("       HANG MAN");
        getContentPane().add(title);
        title.setBounds(170, 0, 360, 70);

        password.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        password.setForeground(new java.awt.Color(153, 102, 0));
        password.setText("Password");
        getContentPane().add(password);
        password.setBounds(40, 220, 241, 50);

        adminName.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        adminName.setForeground(new java.awt.Color(153, 102, 0));
        adminName.setText("Admin Name");
        getContentPane().add(adminName);
        adminName.setBounds(40, 150, 158, 39);

        usernameField.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        usernameField.setForeground(new java.awt.Color(255, 51, 51));
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(usernameField);
        usernameField.setBounds(310, 150, 230, 40);

        login.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        login.setForeground(new java.awt.Color(0, 102, 0));
        login.setText("Login");
        login.setContentAreaFilled(false);
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login);
        login.setBounds(240, 320, 150, 70);

        passField.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        passField.setForeground(new java.awt.Color(255, 51, 51));
        passField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFieldActionPerformed(evt);
            }
        });
        getContentPane().add(passField);
        passField.setBounds(310, 220, 230, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gamehangman/34320wide.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        String check = usernameField.getText();
        char[] check1 = passField.getPassword();
        String check2 = new String (check1);
        if(nameAdmin.equals(check)==true && passwordAdmin.equals(check2)==true)
        {
            AdminCategories ctg= new AdminCategories();
            ctg.setTitle("Hangman Gmae");
            ctg.setSize(700,550);
            ctg.setVisible(true);
            this.dispose();
        }
        else
        {

            JOptionPane.showMessageDialog(null,"Wrong Admin Name or Password",
                "Error", JOptionPane.INFORMATION_MESSAGE);
            usernameField.setText("");
            passField.setText("");

        }
    }//GEN-LAST:event_loginActionPerformed

    private void passFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passFieldActionPerformed

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
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel password;
    private javax.swing.JLabel title;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
