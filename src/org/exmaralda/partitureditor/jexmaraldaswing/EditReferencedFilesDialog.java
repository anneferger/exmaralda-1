/*
 * EditReferencedFilesDialog.java
 *
 * Created on 6. Oktober 2008, 17:42
 */

package org.exmaralda.partitureditor.jexmaraldaswing;


import java.util.*;
import javax.swing.DefaultListModel;
import java.io.*;
import javax.swing.event.ListSelectionEvent;
/**
 *
 * @author  thomas
 */
public class EditReferencedFilesDialog extends javax.swing.JDialog implements javax.swing.event.ListSelectionListener {

    DefaultListModel listModel;
    public String defaultDirectory = "";
    
    /** Creates new form EditReferencedFilesDialog */
    public EditReferencedFilesDialog(java.awt.Frame parent, boolean modal, Vector<String> rf) {
        super(parent, modal);
        initComponents();
        listModel = new DefaultListModel();
        for (String fn : rf){
            if (fn.trim().length()>0){
                listModel.addElement(fn);
            }
        }
        fileList.setModel(listModel);
        fileList.addListSelectionListener(this);
        fileList.setCellRenderer(new RecordingsListCellRenderer());
    }


    
    public Vector<String> getReferencedFiles(){
        Vector<String> retValue = new Vector<String>();
        for (int pos=0; pos<listModel.getSize(); pos++){
            retValue.addElement((String)(listModel.elementAt(pos)));
        }
        return retValue;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        fileList = new javax.swing.JList();
        buttonsPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        topButton = new javax.swing.JButton();
        upButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        okPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit media files");

        jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 300));

        fileList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        fileList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(fileList);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        buttonsPanel.setLayout(new javax.swing.BoxLayout(buttonsPanel, javax.swing.BoxLayout.Y_AXIS));

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/exmaralda/folker/tangoicons/tango-icon-theme-0.8.1/16x16/actions/list-add.png"))); // NOI18N
        addButton.setText("Add...");
        addButton.setMaximumSize(new java.awt.Dimension(110, 25));
        addButton.setMinimumSize(new java.awt.Dimension(110, 25));
        addButton.setPreferredSize(new java.awt.Dimension(110, 25));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(addButton);

        removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/exmaralda/folker/tangoicons/tango-icon-theme-0.8.1/16x16/actions/list-remove.png"))); // NOI18N
        removeButton.setText("Remove");
        removeButton.setMaximumSize(new java.awt.Dimension(110, 25));
        removeButton.setMinimumSize(new java.awt.Dimension(110, 25));
        removeButton.setPreferredSize(new java.awt.Dimension(110, 25));
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(removeButton);
        buttonsPanel.add(jSeparator1);

        topButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/exmaralda/folker/tangoicons/tango-icon-theme-0.8.1/16x16/actions/go-top.png"))); // NOI18N
        topButton.setText("Top");
        topButton.setMaximumSize(new java.awt.Dimension(110, 25));
        topButton.setMinimumSize(new java.awt.Dimension(110, 25));
        topButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(topButton);

        upButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/exmaralda/folker/tangoicons/tango-icon-theme-0.8.1/16x16/actions/go-up.png"))); // NOI18N
        upButton.setText("Up");
        upButton.setMaximumSize(new java.awt.Dimension(110, 25));
        upButton.setMinimumSize(new java.awt.Dimension(110, 25));
        upButton.setPreferredSize(new java.awt.Dimension(110, 25));
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(upButton);

        downButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/exmaralda/folker/tangoicons/tango-icon-theme-0.8.1/16x16/actions/go-down.png"))); // NOI18N
        downButton.setText("Down");
        downButton.setMaximumSize(new java.awt.Dimension(110, 25));
        downButton.setMinimumSize(new java.awt.Dimension(110, 25));
        downButton.setPreferredSize(new java.awt.Dimension(110, 25));
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(downButton);

        getContentPane().add(buttonsPanel, java.awt.BorderLayout.EAST);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        okPanel.add(okButton);

        getContentPane().add(okPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
    fc.setFileFilter(new org.exmaralda.partitureditor.jexmaraldaswing.fileFilters.MediaFileFilter());
    fc.setMultiSelectionEnabled(true);
    if ((listModel.getSize()>0) && (((String)(listModel.get(0))).length()>0)){
        fc.setCurrentDirectory(new File((String)(listModel.get(0))).getParentFile());
    } else {
        fc.setCurrentDirectory(new File(defaultDirectory));
    }
    int ret = fc.showOpenDialog(this);
    if (ret==javax.swing.JFileChooser.APPROVE_OPTION){
        //listModel.addElement(fc.getSelectedFile().getAbsolutePath());
        for (File f : fc.getSelectedFiles()){
            listModel.addElement(f.getAbsolutePath());
        }
    }
}//GEN-LAST:event_addButtonActionPerformed

private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
    //int index = fileList.getSelectedIndex();
    int[] indices = fileList.getSelectedIndices();
    //if (index<0) return;
    if (indices.length==0) return;
    int retValue = 
        javax.swing.JOptionPane.showConfirmDialog(rootPane, "Are you sure?", "Remove a media file reference", javax.swing.JOptionPane.YES_NO_OPTION);
    if (retValue==javax.swing.JOptionPane.NO_OPTION) return;
    //listModel.removeElementAt(index);
    listModel.removeRange(indices[0], indices[indices.length-1]);
}//GEN-LAST:event_removeButtonActionPerformed

private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
    int index = fileList.getSelectedIndex();
    if (index<1) return;
    Object toBeMovedUp = listModel.getElementAt(index);
    listModel.removeElementAt(index);
    listModel.insertElementAt(toBeMovedUp, index-1);
    fileList.setSelectedIndex(index-1);
}//GEN-LAST:event_upButtonActionPerformed

private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
    int index = fileList.getSelectedIndex();
    if ((index<0) || (index>listModel.size()-2)) return;
    Object toBeMovedUp = listModel.getElementAt(index);
    listModel.removeElementAt(index);
    listModel.insertElementAt(toBeMovedUp, index+1);
    fileList.setSelectedIndex(index+1);
}//GEN-LAST:event_downButtonActionPerformed

private void topButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topButtonActionPerformed
    int index = fileList.getSelectedIndex();
    if (index<1) return;
    Object toBeMovedUp = listModel.getElementAt(index);
    listModel.removeElementAt(index);
    listModel.insertElementAt(toBeMovedUp, 0);
    fileList.setSelectedIndex(0);
}//GEN-LAST:event_topButtonActionPerformed

private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
    setVisible(false);
}//GEN-LAST:event_okButtonActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditReferencedFilesDialog dialog = new EditReferencedFilesDialog(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton downButton;
    private javax.swing.JList fileList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel okPanel;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton topButton;
    private javax.swing.JButton upButton;
    // End of variables declaration//GEN-END:variables

    public void valueChanged(ListSelectionEvent e) {
        int index = fileList.getSelectedIndex();
        removeButton.setEnabled(index>=0);
        upButton.setEnabled(index>0);
        topButton.setEnabled(index>0);
        downButton.setEnabled((index>=0) && (index<listModel.size()-1));
    }

}
