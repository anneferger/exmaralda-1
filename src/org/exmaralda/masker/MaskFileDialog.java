/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.exmaralda.masker;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import org.exmaralda.folker.utilities.Constants;
import org.exmaralda.folker.utilities.FOLKERInternationalizer;
import org.exmaralda.folker.utilities.PreferencesUtilities;

/**
 *
 * @author Schmidt
 */
public class MaskFileDialog extends javax.swing.JDialog {

    public boolean approved = false;
    
    /**
     * Creates new form MaskFileDialog
     */
    public MaskFileDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public void setFile(String mediaPath) {
        sourceFileTextField.setText(mediaPath);
        File f = new File(mediaPath);
        String name = f.getName();
        if (name.toUpperCase().endsWith(".WAV")){
            name = name.substring(0, name.lastIndexOf("."));
        }
        File f2 = new File(f.getParentFile(), name + "_mask.WAV");
        targetFileTextField.setText(f2.getAbsolutePath());
        checkIfReady();
    }
    
    public void setMethod(int method){
        methodComboBox.setSelectedIndex(method);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        sourceFilePanel = new javax.swing.JPanel();
        sourceFileLabel = new javax.swing.JLabel();
        sourceFileTextField = new javax.swing.JTextField();
        sourceFileBrowseButton = new javax.swing.JButton();
        targetFilePanel = new javax.swing.JPanel();
        targetFileLabel = new javax.swing.JLabel();
        targetFileTextField = new javax.swing.JTextField();
        targetFileBrowseButton = new javax.swing.JButton();
        methodPanel = new javax.swing.JPanel();
        methodLabel = new javax.swing.JLabel();
        methodComboBox = new javax.swing.JComboBox();
        okCancelPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        maskLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(FOLKERInternationalizer.getString("masker.maskAudioTitle"));

        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.Y_AXIS));

        sourceFilePanel.setLayout(new javax.swing.BoxLayout(sourceFilePanel, javax.swing.BoxLayout.LINE_AXIS));

        sourceFileLabel.setText(FOLKERInternationalizer.getString("masker.sourcefile"));
        sourceFileLabel.setMaximumSize(new java.awt.Dimension(80, 14));
        sourceFileLabel.setMinimumSize(new java.awt.Dimension(80, 14));
        sourceFileLabel.setPreferredSize(new java.awt.Dimension(80, 14));
        sourceFilePanel.add(sourceFileLabel);

        sourceFileTextField.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        sourceFileTextField.setPreferredSize(new java.awt.Dimension(400, 24));
        sourceFilePanel.add(sourceFileTextField);

        sourceFileBrowseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/exmaralda/folker/tangoicons/tango-icon-theme-0.8.1/16x16/actions/document-open.png"))); // NOI18N
        sourceFileBrowseButton.setText(FOLKERInternationalizer.getString("masker.browse"));
        sourceFileBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceFileBrowseButtonActionPerformed(evt);
            }
        });
        sourceFilePanel.add(sourceFileBrowseButton);

        mainPanel.add(sourceFilePanel);

        targetFilePanel.setLayout(new javax.swing.BoxLayout(targetFilePanel, javax.swing.BoxLayout.LINE_AXIS));

        targetFileLabel.setText(FOLKERInternationalizer.getString("masker.targetfile"));
        targetFileLabel.setMaximumSize(new java.awt.Dimension(80, 14));
        targetFileLabel.setMinimumSize(new java.awt.Dimension(80, 14));
        targetFileLabel.setPreferredSize(new java.awt.Dimension(80, 14));
        targetFilePanel.add(targetFileLabel);

        targetFileTextField.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        targetFileTextField.setPreferredSize(new java.awt.Dimension(400, 24));
        targetFilePanel.add(targetFileTextField);

        targetFileBrowseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/exmaralda/folker/tangoicons/tango-icon-theme-0.8.1/16x16/actions/document-save-as.png"))); // NOI18N
        targetFileBrowseButton.setText(FOLKERInternationalizer.getString("masker.browse"));
        targetFileBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                targetFileBrowseButtonActionPerformed(evt);
            }
        });
        targetFilePanel.add(targetFileBrowseButton);

        mainPanel.add(targetFilePanel);

        methodPanel.setLayout(new javax.swing.BoxLayout(methodPanel, javax.swing.BoxLayout.LINE_AXIS));

        methodLabel.setText(FOLKERInternationalizer.getString("masker.method"));
        methodLabel.setMaximumSize(new java.awt.Dimension(80, 14));
        methodLabel.setMinimumSize(new java.awt.Dimension(80, 14));
        methodLabel.setPreferredSize(new java.awt.Dimension(80, 14));
        methodPanel.add(methodLabel);

        methodComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Silence", "Brownian Noise (Generated)", "Brownian Noise (Copied)" }));
        methodComboBox.setMaximumSize(new java.awt.Dimension(200, 24));
        methodComboBox.setPreferredSize(new java.awt.Dimension(200, 24));
        methodPanel.add(methodComboBox);

        mainPanel.add(methodPanel);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        okCancelPanel.setLayout(new javax.swing.BoxLayout(okCancelPanel, javax.swing.BoxLayout.LINE_AXIS));

        okButton.setText("OK");
        okButton.setEnabled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        okCancelPanel.add(okButton);

        cancelButton.setText(FOLKERInternationalizer.getString("error.cancel"));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        okCancelPanel.add(cancelButton);

        getContentPane().add(okCancelPanel, java.awt.BorderLayout.SOUTH);

        maskLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/exmaralda/folker/tangoicons/othericons/mask_black.png"))); // NOI18N
        jPanel1.add(maskLabel);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sourceFileBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceFileBrowseButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        JLabel imageLabel = new JLabel("");
        imageLabel.setIcon(new Constants().getIcon(Constants.BIG_RECORDING_ICON));
        fileChooser.setAccessory(imageLabel);
        fileChooser.setAcceptAllFileFilterUsed(false);        
        fileChooser.setFileFilter(new org.exmaralda.folker.utilities.WaveFileFilter());
        fileChooser.setCurrentDirectory(new File(PreferencesUtilities.getProperty("workingDirectory", "")));
        int retValue = fileChooser.showOpenDialog(this);
        if (retValue==JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();
            sourceFileTextField.setText(f.getAbsolutePath());
            checkIfReady();
        }
    }//GEN-LAST:event_sourceFileBrowseButtonActionPerformed

    private void targetFileBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_targetFileBrowseButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        JLabel imageLabel = new JLabel("");
        imageLabel.setIcon(new Constants().getIcon(Constants.BIG_RECORDING_ICON));
        fileChooser.setAccessory(imageLabel);
        fileChooser.setAcceptAllFileFilterUsed(false);        
        fileChooser.setFileFilter(new org.exmaralda.folker.utilities.WaveFileFilter());
        fileChooser.setCurrentDirectory(new File(PreferencesUtilities.getProperty("workingDirectory", "")));
        int retValue = fileChooser.showSaveDialog(this);
        if (retValue==JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();
            targetFileTextField.setText(f.getAbsolutePath());
            checkIfReady();
        }
    }//GEN-LAST:event_targetFileBrowseButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        approved=true;
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
       dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void checkIfReady(){
        okButton.setEnabled(sourceFileTextField.getText().length()>0
                && targetFileTextField.getText().length()>0);
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
            java.util.logging.Logger.getLogger(MaskFileDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaskFileDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaskFileDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaskFileDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MaskFileDialog dialog = new MaskFileDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel maskLabel;
    private javax.swing.JComboBox methodComboBox;
    private javax.swing.JLabel methodLabel;
    private javax.swing.JPanel methodPanel;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel okCancelPanel;
    private javax.swing.JButton sourceFileBrowseButton;
    private javax.swing.JLabel sourceFileLabel;
    private javax.swing.JPanel sourceFilePanel;
    private javax.swing.JTextField sourceFileTextField;
    private javax.swing.JButton targetFileBrowseButton;
    private javax.swing.JLabel targetFileLabel;
    private javax.swing.JPanel targetFilePanel;
    private javax.swing.JTextField targetFileTextField;
    // End of variables declaration//GEN-END:variables

    public File getSourceFile() {
        return new File(sourceFileTextField.getText());
    }

    public File getTargetFile() {
        return new File(targetFileTextField.getText());
    }
    
    public int getMethod(){
        return methodComboBox.getSelectedIndex();
    }


}
