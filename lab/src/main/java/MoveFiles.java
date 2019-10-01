import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MoveFiles extends javax.swing.JFrame {

    /**
     * Creates new form MoveFiles
     */
    public MoveFiles() {
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
        StartingPath = new javax.swing.JLabel();
        DestinationPath = new javax.swing.JLabel();
        StartingDirectoryButton = new javax.swing.JButton();
        DestinationPathButton = new javax.swing.JButton();
        AcceptButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Trasladar Archivos");

        MainMenuButton.setText("Regresar");
        MainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuButtonActionPerformed(evt);
            }
        });

        StartingDirectoryButton.setText("Directorio Inicial");
        StartingDirectoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartingDirectoryButtonActionPerformed(evt);
            }
        });

        DestinationPathButton.setText("Directorio Final");
        DestinationPathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DestinationPathButtonActionPerformed(evt);
            }
        });

        AcceptButton.setText("Trasladar");
        AcceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcceptButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(StartingDirectoryButton)
                                .addGap(18, 18, 18)
                                .addComponent(StartingPath))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DestinationPathButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DestinationPath))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(AcceptButton)
                        .addGap(18, 18, 18)
                        .addComponent(MainMenuButton)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StartingPath)
                    .addComponent(StartingDirectoryButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DestinationPath)
                    .addComponent(DestinationPathButton))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MainMenuButton)
                    .addComponent(AcceptButton))
                .addGap(43, 43, 43))
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
     * Get the starting path.
     * @param evt The event performed.
     */
    private void StartingDirectoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartingDirectoryButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            StartingPath.setText(file.getPath());
        }

    }//GEN-LAST:event_StartingDirectoryButtonActionPerformed

    /**
     * Get the destination path.
     * @param evt The event performed.
     */
    private void DestinationPathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DestinationPathButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            DestinationPath.setText(file.getPath());
        }
    }//GEN-LAST:event_DestinationPathButtonActionPerformed

    /**
     * Move the files.
     * @param evt The event performed.
     */
    private void AcceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceptButtonActionPerformed
        File startingDirectory = new File(StartingPath.getText());
        String startingPath = StartingPath.getText();
        String destinationPath = DestinationPath.getText();
        if (StartingPath.equals(destinationPath)) {
            JOptionPane.showMessageDialog(rootPane, "Los directorios no pueden ser iguales");
        } else if (startingPath.equals("") || destinationPath.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Alguno de los directorios no ha sido seleccionado");
        } else {
            List<File> files = GetFiles(new ArrayList<File>(), startingDirectory);
            boolean isCorrect = false;
            for (File file : files) {
                try {
                    Files.copy(file.toPath(), (new File(destinationPath +  file.getName())).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    isCorrect = true;
                } catch (IOException ex) {
                    isCorrect = false;
                }
            }
            if (isCorrect)
                JOptionPane.showMessageDialog(rootPane, "Ha sido un exito");
            else 
                JOptionPane.showMessageDialog(rootPane, "Ha ocurrido un error");
        }
    }//GEN-LAST:event_AcceptButtonActionPerformed

    /**
     * Get all the files inside a directory.
     * @param files The list with the files.
     * @param directory The directory to look.
     * @return A list with all the files inside a directory.
     */
    private List<File> GetFiles(List<File> files, File directory) {
        for (File file : directory.listFiles()) {
            if (file.isDirectory())
                return GetFiles(files, file);
            else
                files.add(file);
        }
        return files;
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
            java.util.logging.Logger.getLogger(MoveFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MoveFiles().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcceptButton;
    private javax.swing.JLabel DestinationPath;
    private javax.swing.JButton DestinationPathButton;
    private javax.swing.JButton MainMenuButton;
    private javax.swing.JButton StartingDirectoryButton;
    private javax.swing.JLabel StartingPath;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
