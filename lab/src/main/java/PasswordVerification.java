import javax.swing.JOptionPane;

public class PasswordVerification extends javax.swing.JFrame {

    /**
     * Creates new form PasswordVerification
     */
    public PasswordVerification() {
        initComponents();
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
        MainMenuButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        PasswordInput = new javax.swing.JTextField();
        VerifyButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Verificar Contraseña");

        MainMenuButton.setText("Regresar");
        MainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Contraseña:");

        VerifyButton.setText("Verificar");
        VerifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerifyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(VerifyButton)
                            .addGap(18, 18, 18)
                            .addComponent(MainMenuButton))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(PasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(PasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VerifyButton)
                    .addComponent(MainMenuButton))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Go back to the main menu view.
     * @param evt The event performed.
     */
    private void MainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuButtonActionPerformed
        MainView mainView = new MainView();
        mainView.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_MainMenuButtonActionPerformed

    /**
     * Verify the password.
     * @param evt The event performed.
     */
    private void VerifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerifyButtonActionPerformed
        String password = PasswordInput.getText();
        if (!password.equals("")) {
            if (password.length() < 6) {
                JOptionPane.showMessageDialog(rootPane, "La contraseña no debe de ser menor a 6 caracteres");
            } else {
                int points = 3 * password.length();
                points += 2 * CountUppercase(password);
                points += CountLetters(password) + 1;
                points += CountNumbers(password) + 2;
                points += CountSymbols(password) * (password.length() + 4);
                if (CountNumbers(password) == 0)
                    points -= 6;
                if (CountLetters(password) == 0)
                    points -= 3;
                
                if (points > 20 && points <= 30)
                    JOptionPane.showMessageDialog(rootPane, "Su contraseña es muy poco segura.");
                else if (points > 30 && points <= 45)
                    JOptionPane.showMessageDialog(rootPane, "Su contraseña es segura.");
                else if (points >= 46)
                    JOptionPane.showMessageDialog(rootPane, "Su contraseña es muy segura.");
                else
                    JOptionPane.showMessageDialog(rootPane, "Su contraseña es muy insegura.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Por favor ingresa la contraseña");
        }
    }//GEN-LAST:event_VerifyButtonActionPerformed

    /**
     * Get the number of uppercase letters in the strings.
     * @param text The text to count the letters.
     * @return The number of uppercase letters in the string.
     */
    private int CountUppercase(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i)))
                count++;
        }
        return count;
    }
    
    /**
     * Get the number of letters in the string.
     * @param text The text to count the letters.
     * @return The number of letters in the string.
     */
    private int CountLetters(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i)))
                count++;
        }
        return count;
    }
    
    /**
     * Get the number of numbers in the string.
     * @param text The text to count the numbers.
     * @return The number of numbers in the string.
     */
    private int CountNumbers(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i)))
                count++;
        }
        return count;
    }
    
    /**
     * Get the number of symbols in the string.
     * @param text The text to count the symbols.
     * @return The number of symbols in the string.
     */
    private int CountSymbols(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i)) && Character.isLetter(text.charAt(i)))
                count++;
        }
        return count;
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasswordVerification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PasswordVerification().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MainMenuButton;
    private javax.swing.JTextField PasswordInput;
    private javax.swing.JButton VerifyButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
