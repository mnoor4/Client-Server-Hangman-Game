package gamehangman;

public class LoseScreen extends javax.swing.JFrame {

    int score;
    String player;
    public LoseScreen(int scoreX,String name) {
        score=scoreX;
        player=name;
        String num=String.valueOf(score);
        initComponents();
        nameField.setText(player);
        pointField.setText(num);
    }

    private LoseScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lost = new javax.swing.JLabel();
        figure = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        scoreLose = new javax.swing.JLabel();
        nameField = new javax.swing.JLabel();
        playerName = new javax.swing.JLabel();
        pointField = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lost.setFont(new java.awt.Font("Viner Hand ITC", 1, 36)); // NOI18N
        lost.setForeground(new java.awt.Color(153, 102, 0));
        lost.setText("HANGED!!");
        getContentPane().add(lost);
        lost.setBounds(70, 100, 230, 90);

        figure.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        figure.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gamehangman/man6.png"))); // NOI18N
        getContentPane().add(figure);
        figure.setBounds(340, 100, 310, 390);

        title.setFont(new java.awt.Font("Viner Hand ITC", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(153, 102, 0));
        title.setText("       HANG MAN");
        getContentPane().add(title);
        title.setBounds(170, 0, 360, 70);

        scoreLose.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        scoreLose.setForeground(new java.awt.Color(255, 102, 102));
        scoreLose.setText("Score:");
        getContentPane().add(scoreLose);
        scoreLose.setBounds(20, 260, 110, 70);

        nameField.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        nameField.setForeground(new java.awt.Color(51, 153, 0));
        nameField.setText("name");
        getContentPane().add(nameField);
        nameField.setBounds(140, 200, 210, 60);

        playerName.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        playerName.setForeground(new java.awt.Color(255, 102, 102));
        playerName.setText("Player:");
        getContentPane().add(playerName);
        playerName.setBounds(20, 200, 110, 70);

        pointField.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        pointField.setForeground(new java.awt.Color(51, 153, 0));
        pointField.setText("points");
        getContentPane().add(pointField);
        pointField.setBounds(140, 270, 210, 60);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gamehangman/34320wide.jpg"))); // NOI18N
        background.setText("jLabel1");
        getContentPane().add(background);
        background.setBounds(0, 0, 700, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LoseScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoseScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoseScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoseScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoseScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel figure;
    private javax.swing.JLabel lost;
    private javax.swing.JLabel nameField;
    private javax.swing.JLabel playerName;
    private javax.swing.JLabel pointField;
    private javax.swing.JLabel scoreLose;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
