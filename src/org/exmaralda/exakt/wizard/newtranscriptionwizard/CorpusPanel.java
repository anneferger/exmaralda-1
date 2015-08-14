/*
 * CorpusPanel.java
 *
 * Created on 20. Februar 2008, 15:05
 */

package org.exmaralda.exakt.wizard.newtranscriptionwizard;

import java.io.File;

/**
 *
 * @author  thomas
 */
public class CorpusPanel extends javax.swing.JPanel {
    
    /** Creates new form CorpusPanel */
    public CorpusPanel() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        corpusNameLabel = new javax.swing.JLabel();
        corpusNameTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        corpusFileLabel = new javax.swing.JLabel();
        corpusFileTextField = new javax.swing.JTextField();
        corpusFileBrowseButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());
        add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        corpusNameLabel.setText("Corpus Name: ");
        corpusNameLabel.setMaximumSize(new java.awt.Dimension(90, 14));
        corpusNameLabel.setMinimumSize(new java.awt.Dimension(90, 14));
        corpusNameLabel.setPreferredSize(new java.awt.Dimension(90, 14));
        jPanel1.add(corpusNameLabel);

        corpusNameTextField.setMaximumSize(new java.awt.Dimension(600, 19));
        corpusNameTextField.setPreferredSize(new java.awt.Dimension(300, 19));
        jPanel1.add(corpusNameTextField);

        jPanel3.add(jPanel1);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        corpusFileLabel.setText("Corpus File: ");
        corpusFileLabel.setMaximumSize(new java.awt.Dimension(90, 14));
        corpusFileLabel.setMinimumSize(new java.awt.Dimension(90, 14));
        corpusFileLabel.setPreferredSize(new java.awt.Dimension(90, 14));
        jPanel4.add(corpusFileLabel);

        corpusFileTextField.setMaximumSize(new java.awt.Dimension(800, 19));
        corpusFileTextField.setPreferredSize(new java.awt.Dimension(221, 19));
        jPanel4.add(corpusFileTextField);

        corpusFileBrowseButton.setText("Browse...");
        corpusFileBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                corpusFileBrowseButtonActionPerformed(evt);
            }
        });
        jPanel4.add(corpusFileBrowseButton);

        jPanel3.add(jPanel4);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void corpusFileBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_corpusFileBrowseButtonActionPerformed
        javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
        fc.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(File f) {
                return ((f.isDirectory()) || (f.getAbsolutePath().toUpperCase().endsWith(".XML")));
            }
            public String getDescription() {
                return "XML files";
            }
        });
        fc.setDialogTitle("Choose a file for the corpus");
        int v = fc.showSaveDialog(this);
        if (v==fc.APPROVE_OPTION){
            if (fc.getSelectedFile().exists()){
                int v2 = javax.swing.JOptionPane.showConfirmDialog(this,
                        fc.getSelectedFile().getAbsolutePath() + " exists.\nOverwrite?",
                        "File exists",
                        javax.swing.JOptionPane.YES_NO_OPTION
                        );
                if (v2 == javax.swing.JOptionPane.NO_OPTION) return;
            }            
            corpusFileTextField.setText(fc.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_corpusFileBrowseButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton corpusFileBrowseButton;
    private javax.swing.JLabel corpusFileLabel;
    private javax.swing.JTextField corpusFileTextField;
    private javax.swing.JLabel corpusNameLabel;
    private javax.swing.JTextField corpusNameTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
    
}
