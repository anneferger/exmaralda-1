/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.exmaralda.partitureditor.jexmaraldaswing;

import com.klg.jclass.table.JCTableEnum;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.exmaralda.common.ExmaraldaApplication;
import org.exmaralda.partitureditor.jexmaralda.BasicTranscription;
import org.exmaralda.partitureditor.jexmaralda.JexmaraldaException;
import org.exmaralda.partitureditor.jexmaralda.Speaker;
import org.exmaralda.partitureditor.jexmaralda.Tier;
import org.exmaralda.partitureditor.jexmaralda.TierFormatTable;
import org.exmaralda.partitureditor.jexmaraldaswing.fileFilters.MediaFileFilter;
import org.exmaralda.partitureditor.partiture.PartiturEditor;
import org.exmaralda.partitureditor.partiture.PartitureTableWithActions;
import org.xml.sax.SAXException;

/**
 *
 * @author Schmidt
 */
public class QuickMediaOpenDialog extends javax.swing.JDialog {

    PartitureTableWithActions partiturTable;
    java.util.prefs.Preferences settings;
    /**
     * Creates new form QuickMediaOpenDialog
     */
    public QuickMediaOpenDialog(java.awt.Frame parent, PartitureTableWithActions p, boolean modal) {
        super(parent, modal);
        initComponents();
        partiturTable = p;   
        settings = java.util.prefs.Preferences.userRoot().node(((ExmaraldaApplication)parent).getPreferencesNode());            
        String mediaDir = settings.get("QUICK-OPEN-MEDIA-DIR", System.getProperty("user.dir"));
        String transcriptDir = settings.get("QUICK-OPEN-TRANSCRIPT-DIR", System.getProperty("user.dir"));
        mediaDirectoryTextField.setText(mediaDir);
        transcriptionDirectoryTextField.setText(transcriptDir);
        refreshMediaList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        centerPanel = new javax.swing.JPanel();
        mediaListScrollPane = new javax.swing.JScrollPane();
        mediaList = new javax.swing.JList();
        topPanel = new javax.swing.JPanel();
        mediaDirectoryPanel = new javax.swing.JPanel();
        mediaDirectoryLabel = new javax.swing.JLabel();
        mediaDirectoryTextField = new javax.swing.JTextField();
        mediaDirectoryBrowseButton = new javax.swing.JButton();
        transcriptionDirectoryPanel = new javax.swing.JPanel();
        transcriptionDirectoryLabel = new javax.swing.JLabel();
        transcriptionDirectoryTextField = new javax.swing.JTextField();
        transcriptionDirectoryBrowseButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quick Media Open");

        centerPanel.setLayout(new java.awt.BorderLayout());

        mediaList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        mediaList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mediaListMouseClicked(evt);
            }
        });
        mediaListScrollPane.setViewportView(mediaList);

        centerPanel.add(mediaListScrollPane, java.awt.BorderLayout.CENTER);

        getContentPane().add(centerPanel, java.awt.BorderLayout.CENTER);

        topPanel.setLayout(new java.awt.GridLayout(2, 1));

        mediaDirectoryPanel.setLayout(new javax.swing.BoxLayout(mediaDirectoryPanel, javax.swing.BoxLayout.LINE_AXIS));

        mediaDirectoryLabel.setText("Media Directory: ");
        mediaDirectoryLabel.setMaximumSize(new java.awt.Dimension(116, 14));
        mediaDirectoryLabel.setMinimumSize(new java.awt.Dimension(116, 14));
        mediaDirectoryLabel.setPreferredSize(new java.awt.Dimension(116, 14));
        mediaDirectoryPanel.add(mediaDirectoryLabel);

        mediaDirectoryTextField.setMaximumSize(new java.awt.Dimension(400, 20));
        mediaDirectoryTextField.setMinimumSize(new java.awt.Dimension(400, 20));
        mediaDirectoryTextField.setPreferredSize(new java.awt.Dimension(400, 20));
        mediaDirectoryPanel.add(mediaDirectoryTextField);

        mediaDirectoryBrowseButton.setText("Browse...");
        mediaDirectoryBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediaDirectoryBrowseButtonActionPerformed(evt);
            }
        });
        mediaDirectoryPanel.add(mediaDirectoryBrowseButton);

        topPanel.add(mediaDirectoryPanel);

        transcriptionDirectoryPanel.setLayout(new javax.swing.BoxLayout(transcriptionDirectoryPanel, javax.swing.BoxLayout.LINE_AXIS));

        transcriptionDirectoryLabel.setText("Transcription Directory: ");
        transcriptionDirectoryPanel.add(transcriptionDirectoryLabel);

        transcriptionDirectoryTextField.setMaximumSize(new java.awt.Dimension(400, 20));
        transcriptionDirectoryTextField.setMinimumSize(new java.awt.Dimension(400, 20));
        transcriptionDirectoryTextField.setPreferredSize(new java.awt.Dimension(400, 20));
        transcriptionDirectoryPanel.add(transcriptionDirectoryTextField);

        transcriptionDirectoryBrowseButton.setText("Browse...");
        transcriptionDirectoryBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transcriptionDirectoryBrowseButtonActionPerformed(evt);
            }
        });
        transcriptionDirectoryPanel.add(transcriptionDirectoryBrowseButton);

        topPanel.add(transcriptionDirectoryPanel);

        getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mediaDirectoryBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediaDirectoryBrowseButtonActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = jfc.showOpenDialog(jfc);
        if (result!=JFileChooser.APPROVE_OPTION) return;
        File f = jfc.getSelectedFile();
        mediaDirectoryTextField.setText(f.getAbsolutePath());
        refreshMediaList();
    }//GEN-LAST:event_mediaDirectoryBrowseButtonActionPerformed

    private void transcriptionDirectoryBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transcriptionDirectoryBrowseButtonActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = jfc.showOpenDialog(jfc);
        if (result!=JFileChooser.APPROVE_OPTION) return;
        File f = jfc.getSelectedFile();
        transcriptionDirectoryTextField.setText(f.getAbsolutePath());
        settings.put("QUICK-OPEN-TRANSCRIPT-DIR", f.getAbsolutePath());
    }//GEN-LAST:event_transcriptionDirectoryBrowseButtonActionPerformed

    private void mediaListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mediaListMouseClicked
        if (evt.getClickCount()==2){
            try {
                openMedia();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(partiturTable, ex);
            } 
        }
    }//GEN-LAST:event_mediaListMouseClicked

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
            java.util.logging.Logger.getLogger(QuickMediaOpenDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuickMediaOpenDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuickMediaOpenDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuickMediaOpenDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuickMediaOpenDialog dialog = new QuickMediaOpenDialog(new javax.swing.JFrame(), null, true);
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
    private javax.swing.JPanel centerPanel;
    private javax.swing.JButton mediaDirectoryBrowseButton;
    private javax.swing.JLabel mediaDirectoryLabel;
    private javax.swing.JPanel mediaDirectoryPanel;
    private javax.swing.JTextField mediaDirectoryTextField;
    private javax.swing.JList mediaList;
    private javax.swing.JScrollPane mediaListScrollPane;
    private javax.swing.JPanel topPanel;
    private javax.swing.JButton transcriptionDirectoryBrowseButton;
    private javax.swing.JLabel transcriptionDirectoryLabel;
    private javax.swing.JPanel transcriptionDirectoryPanel;
    private javax.swing.JTextField transcriptionDirectoryTextField;
    // End of variables declaration//GEN-END:variables

    private void refreshMediaList() {
        File mediaDirectory = new File(mediaDirectoryTextField.getText());
        if ((!mediaDirectory.isDirectory())){
            JOptionPane.showMessageDialog(centerPanel, "Cannot read " + mediaDirectoryTextField.getText());
        }
        settings.put("QUICK-OPEN-MEDIA-DIR", mediaDirectory.getAbsolutePath());
        File[] mediaFiles = mediaDirectory.listFiles(new FileFilter(){
            @Override
            public boolean accept(File f) {
                for (String s : MediaFileFilter.ACCEPTED_SUFFIXES){
                    if (f.getName().toLowerCase().endsWith(s)){
                        return true;
                    }
                }
                return false;
            }            
        });
        
        DefaultListModel listModel = new DefaultListModel();
        if (mediaFiles!=null){
            for (File f : mediaFiles){
                listModel.addElement(f);
            }
        }
        mediaList.setModel(listModel);
    }

    private void openMedia() throws SAXException, JexmaraldaException, IOException {
        if (mediaList.getSelectedIndex()<0) return;
        File mediaFile = (File)(mediaList.getSelectedValue());
        String nakedName = mediaFile.getName().substring(0, mediaFile.getName().lastIndexOf("."));
        File transcriptionFile = new File(new File(transcriptionDirectoryTextField.getText()), nakedName + ".exb");
        boolean proceed = true;
        // check if the user wants to save changes
        if (partiturTable.transcriptionChanged){proceed = partiturTable.checkSave();}
        // if user has cancelled or something's gone wrong with saving, stop here
        if (!proceed) return;
        
        BasicTranscription newTranscription = null;
        if (transcriptionFile.exists()){
            newTranscription = new BasicTranscription(transcriptionFile.getAbsolutePath());
            
        } else {
            newTranscription = new BasicTranscription();
            try {
                Speaker speaker = new Speaker();
                speaker.setID("SPK0");
                speaker.setAbbreviation("X");
                newTranscription.getHead().getSpeakertable().addSpeaker(speaker);
                newTranscription.getBody().getCommonTimeline().addTimelineItem();
                newTranscription.getBody().getCommonTimeline().addTimelineItem();
                Tier tier = new Tier("TIE0","SPK0","v","t");
                newTranscription.getBody().addTier(tier);
                newTranscription.makeDisplayNames();
            } catch (JexmaraldaException ex){}
            
            newTranscription.getHead().getMetaInformation().setReferencedFile(mediaFile.getAbsolutePath());
            newTranscription.writeXMLToFile(transcriptionFile.getAbsolutePath(), "none");
        }
        // ... stratify the new transcription
        partiturTable.stratify(newTranscription);
        // ... make hidden tiers reappear...
        partiturTable.setRowHidden(JCTableEnum.ALLCELLS, false);
        //added 16-08-2012
        partiturTable.saveTierFormatTable = newTranscription.getTierFormatTable()!=null;            
        // ...set the transcription for the partitur to the newly read transcription...
        partiturTable.getModel().setTranscription(newTranscription);
        // ...update the filename...
        partiturTable.homeDirectory = transcriptionFile.getAbsolutePath();
        partiturTable.setFilename(transcriptionFile.getAbsolutePath());
        // make the changes to the media panel (i.e. set the media file if there is one)
        partiturTable.setupMedia();
        // make the changes to the praat panel (version 1.3. and later)
        partiturTable.setupPraatPanel();
        partiturTable.transcriptionChanged = false;
        partiturTable.formatChanged = false;            

        partiturTable.status("Transcription " + transcriptionFile.getAbsolutePath() + " opened");
            
            
    }
}
