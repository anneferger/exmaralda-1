/*
 * PartiturParametersDialog.java
 *
 * Created on 26. Maerz 2002, 15:55
 */

package org.exmaralda.partitureditor.jexmaraldaswing;

import org.exmaralda.common.helpers.Internationalizer;
import org.exmaralda.partitureditor.interlinearText.swing.HTMLParametersPanel;
import org.exmaralda.partitureditor.interlinearText.RTFParameters;
import org.exmaralda.partitureditor.interlinearText.swing.SVGParametersPanel;
import org.exmaralda.partitureditor.interlinearText.PrintParameters;
import org.exmaralda.partitureditor.interlinearText.HTMLParameters;
import org.exmaralda.partitureditor.interlinearText.swing.BreakParametersPanel;
import org.exmaralda.partitureditor.interlinearText.swing.OutputParametersPanel;
import org.exmaralda.partitureditor.interlinearText.swing.RTFParametersPanel;
import org.exmaralda.partitureditor.interlinearText.SVGParameters;
import org.exmaralda.partitureditor.interlinearText.swing.*;
import org.exmaralda.partitureditor.interlinearText.*;
/**
 *
 * @author  Thomas
 */
public class PartiturParametersDialog extends JEscapeDialog {

    OutputParametersPanel outputParametersPanel = new OutputParametersPanel();
    BreakParametersPanel breakParametersPanel = new BreakParametersPanel();
    RTFParametersPanel rtfParametersPanel= new RTFParametersPanel();
    HTMLParametersPanel htmlParametersPanel= new HTMLParametersPanel();
    SVGParametersPanel svgParametersPanel = new SVGParametersPanel();

    /** Creates new form PartiturParametersDialog */
    public PartiturParametersDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** Creates new form PartiturParametersDialog */
    public PartiturParametersDialog(java.awt.Frame parent, boolean modal, 
                                    PrintParameters pp, RTFParameters rp, 
                                    HTMLParameters hp, SVGParameters sp) {
        super(parent, modal);
        outputParametersPanel = new OutputParametersPanel(pp);
        breakParametersPanel = new BreakParametersPanel(pp);  
        rtfParametersPanel= new RTFParametersPanel(rp);
        htmlParametersPanel= new HTMLParametersPanel(hp);
        svgParametersPanel = new SVGParametersPanel(sp);
        initComponents();
        this.getRootPane().setDefaultButton(okButton);      
        Internationalizer.internationalizeDialogToolTips(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jTabbedPane1 = new javax.swing.JTabbedPane();
        breakTabbedPanel = new javax.swing.JPanel();
        breakTabbedPanel.add(breakParametersPanel);
        outputTabbedPanel = new javax.swing.JPanel();
        outputTabbedPanel.add(outputParametersPanel);
        rtfTabbedPanel = new javax.swing.JPanel();
        rtfTabbedPanel.add(rtfParametersPanel);
        htmlTabbedPanel = new javax.swing.JPanel();
        htmlTabbedPanel.add(htmlParametersPanel);
        svgTabbedPanel = new javax.swing.JPanel();
        svgTabbedPanel.add(svgParametersPanel);
        jPanel4 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setTitle("Partitur parameters");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jTabbedPane1.addTab("Break", null, breakTabbedPanel, "");

        jTabbedPane1.addTab("General", null, outputTabbedPanel, "");

        jTabbedPane1.addTab("RTF", null, rtfTabbedPanel, "");

        jTabbedPane1.addTab("HTML", null, htmlTabbedPanel, "");

        jTabbedPane1.addTab("SVG", svgTabbedPanel);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jPanel4.add(okButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jPanel4.add(cancelButton);

        getContentPane().add(jPanel4, java.awt.BorderLayout.SOUTH);

        pack();
    }
    // </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // Add your handling code here:
        setVisible(false);        
        dispose();        
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // Add your handling code here:
        change=true;
        setVisible(false);        
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);        
        dispose();
    }//GEN-LAST:event_closeDialog

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        new PartiturParametersDialog(new javax.swing.JFrame(), true).show();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel breakTabbedPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel htmlTabbedPanel;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel outputTabbedPanel;
    private javax.swing.JPanel rtfTabbedPanel;
    private javax.swing.JPanel svgTabbedPanel;
    // End of variables declaration//GEN-END:variables

    public PrintParameters getPrintParameters(){
        PrintParameters result = new PrintParameters();
        breakParametersPanel.modifyParameters(result);
        outputParametersPanel.modifyParameters(result);
        return result;
    }
    
    public RTFParameters getRTFParameters(){
        RTFParameters result = new RTFParameters();
        breakParametersPanel.modifyParameters(result);
        outputParametersPanel.modifyParameters(result);
        rtfParametersPanel.modifyParameters(result);
        return result;
    }

    public HTMLParameters getHTMLParameters(){
        HTMLParameters result = new HTMLParameters();
        breakParametersPanel.modifyParameters(result);
        outputParametersPanel.modifyParameters(result);
        htmlParametersPanel.modifyParameters(result);
        return result;
    }
    
    public SVGParameters getSVGParameters(){
        SVGParameters result = new SVGParameters();
        breakParametersPanel.modifyParameters(result);
        outputParametersPanel.modifyParameters(result);
        svgParametersPanel.modifyParameters(result);
        return result;
    }

    public boolean editPartiturParameters(){
        java.awt.Dimension dialogSize = this.getPreferredSize();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenSize.width/2 - dialogSize.width/2, screenSize.height/2 - dialogSize.height/2);
        show();
        return change;
    }

}
