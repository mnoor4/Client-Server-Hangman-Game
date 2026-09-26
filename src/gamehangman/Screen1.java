/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehangman;

/**
 *
 * @author Maryam
 */
public class Screen1 extends javax.swing.JFrame {

    /**
     * Creates new form Screen1
     */
    public Screen1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        admin = new javax.swing.JButton();
        playGame = new javax.swing.JButton();
        backGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Title.setFont(new java.awt.Font("Viner Hand ITC", 1, 36)); // NOI18N
        Title.setForeground(new java.awt.Color(153, 102, 0));
        Title.setText("     HANG MAN ");
        getContentPane().add(Title);
        Title.setBounds(180, 0, 300, 70);

        admin.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        admin.setForeground(new java.awt.Color(255, 51, 51));
        admin.setText("ADMIN");
        admin.setContentAreaFilled(false);
        admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminActionPerformed(evt);
            }
        });
        getContentPane().add(admin);
        admin.setBounds(240, 170, 200, 70);

        playGame.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        playGame.setForeground(new java.awt.Color(255, 51, 51));
        playGame.setText("PLAY GAME");
        playGame.setContentAreaFilled(false);
        playGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playGameActionPerformed(evt);
            }
        });
        getContentPane().add(playGame);
        playGame.setBounds(240, 290, 200, 70);

        backGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gamehangman/34320wide.jpg"))); // NOI18N
        getContentPane().add(backGround);
        backGround.setBounds(0, 0, 700, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playGameActionPerformed
        // TODO add your handling code here:
        Screen2 screen=new Screen2();
        screen.setTitle("HangMan Game");
        screen.setSize(700,580);
        screen.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_playGameActionPerformed

    private void adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminActionPerformed
        // TODO add your handling code here:
        AdminLogin login=new AdminLogin();
        login.setTitle("HangMan Game");
        login.setSize(700,580);
        login.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_adminActionPerformed

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
            java.util.logging.Logger.getLogger(Screen1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Screen1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Screen1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Screen1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Screen1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JButton admin;
    private javax.swing.JLabel backGround;
    private javax.swing.JButton playGame;
    // End of variables declaration//GEN-END:variables
}
