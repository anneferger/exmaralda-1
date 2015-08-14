/*
 * StratifyTierDialog.java
 *
 * Created on 13. Juni 2002, 10:42
 */

package org.exmaralda.partitureditor.jexmaraldaswing;

import org.exmaralda.common.helpers.Internationalizer;
import org.exmaralda.partitureditor.jexmaralda.Tier;
import org.exmaralda.partitureditor.jexmaralda.Timeline;
import org.exmaralda.partitureditor.jexmaralda.AbstractEventTier;
import org.exmaralda.partitureditor.jexmaralda.*;
/**
 *
 * @author  Thomas
 */
public class StratifyTierDialog extends JEscapeDialog {

    Tier tier;
    Timeline timeline;
    Tier[] additionalTiers;
    
    /** Creates new form StratifyTierDialog */
    public StratifyTierDialog(java.awt.Frame parent, boolean modal, Tier t, Timeline tl) {
        super(parent, modal);
        initComponents();
        this.getRootPane().setDefaultButton(okButton);        
        tier = t;
        timeline = tl;
        message1Label.setText("Tier " + tier.getID() + " (type='" + tier.getType() + "', category='" + tier.getCategory() + "')\n");
        /*if ((tier.getType().equals("t")) || (tier.getType().equals("a"))) {stratByDelRadioButton.setSelected(true);}
        else {stratByDisRadioButton.setSelected(true);}*/
        Internationalizer.internationalizeDialogToolTips(this);
    }


    public Tier[] getAdditionalTiers(){
        return additionalTiers;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        message1Label = new javax.swing.JLabel();
        message2Label = new javax.swing.JLabel();
        message3Label = new javax.swing.JLabel();
        stratByDelRadioButton = new javax.swing.JRadioButton();
        stratByDisRadioButton = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();

        setTitle("Stratify Tier");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(5, 1));

        message1Label.setText("jLabel1");
        jPanel1.add(message1Label);

        message2Label.setText("is not stratified (i.e. it contains overlapping events). ");
        jPanel1.add(message2Label);

        message3Label.setText("Please choose a method for stratifying this tier. ");
        jPanel1.add(message3Label);

        buttonGroup1.add(stratByDelRadioButton);
        stratByDelRadioButton.setText("Stratify by deletion");
        jPanel1.add(stratByDelRadioButton);

        buttonGroup1.add(stratByDisRadioButton);
        stratByDisRadioButton.setSelected(true);
        stratByDisRadioButton.setText("Stratify by distribution");
        jPanel1.add(stratByDisRadioButton);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        jPanel2.add(okButton);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // changed on 19-06-2008
        short method;
        if (stratByDelRadioButton.isSelected()) {method = AbstractEventTier.STRATIFY_BY_DELETION;}
        else {method = AbstractEventTier.STRATIFY_BY_DISTRIBUTION;}
        Tier[] at = tier.stratify(timeline, method);
        if (at!=null) {
            additionalTiers = new Tier[at.length];
            for (int pos=0; pos<at.length; pos++){
                //AbstractEventTier abstractTier = at[pos];
                Tier newTier = at[pos];
                /*for (int i=0; i<abstractTier.getNumberOfEvents(); i++){
                    newTier.addEvent(abstractTier.getEventAt(i));
                }*/
                newTier.setSpeaker(tier.getSpeaker());
                newTier.setType(tier.getType());
                newTier.setCategory(tier.getCategory());
                newTier.setDisplayName(tier.getDisplayName());
                additionalTiers[pos] = newTier;
            }
        }
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
        //new StratifyTierDialog(new javax.swing.JFrame(), true).show();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel message1Label;
    private javax.swing.JLabel message2Label;
    private javax.swing.JLabel message3Label;
    private javax.swing.JButton okButton;
    private javax.swing.JRadioButton stratByDelRadioButton;
    private javax.swing.JRadioButton stratByDisRadioButton;
    // End of variables declaration//GEN-END:variables

    public boolean stratifyTier(){
        java.awt.Dimension dialogSize = this.getPreferredSize();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenSize.width/2 - dialogSize.width/2, screenSize.height/2 - dialogSize.height/2);
        show();
        return true;
    }
}
