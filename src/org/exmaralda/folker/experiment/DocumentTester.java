/*
 * DocumentTester.java
 *
 * Created on 8. April 2008, 12:17
 */

package org.exmaralda.folker.experiment;

import java.io.IOException;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;

/**
 *
 * @author  thomas
 */
public class DocumentTester extends javax.swing.JFrame implements javax.swing.event.DocumentListener {
    
    String TEXT1 =   "Ich lag am Strand, der Rest ";
    String TEXT2 =   " ist unbekannt. ";
    String TEXT3 =   " Da kam Bratislav Metulski des Weges, in seinem Mund eine Meerschaumpfeife, in der Hand einen knorzigen Wanderstock. ";
    String TEXT4 =   " Er roch aus dem Hals. ";
    
    /** Creates new form DocumentTester */
    public DocumentTester() {
        initComponents();
        try {
            
            javax.swing.text.StyledEditorKit sek = new javax.swing.text.StyledEditorKit();
            jTextPane1.setEditorKit(sek);
            jTextPane1.getDocument().insertString(0, TEXT1, null);
            jTextPane1.insertComponent(button1);        
            jTextPane1.getDocument().insertString(jTextPane1.getCaretPosition(), TEXT2, null);            
            jTextPane1.insertComponent(button2);        
            jTextPane1.getDocument().insertString(jTextPane1.getCaretPosition(), TEXT3, null);
            jTextPane1.insertIcon(new javax.swing.ImageIcon(getClass().getResource("/sound/Clock.gif")));
            jTextPane1.getDocument().insertString(jTextPane1.getCaretPosition(), TEXT4, null);
            jTextPane1.getDocument().addDocumentListener(this);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        button1 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        button1.setFont(new java.awt.Font("Tahoma", 0, 10));
        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sound/Clock.gif")));
        button1.setToolTipText("00:45:23.2");
        button1.setAlignmentY(0.9F);
        button1.setIconTextGap(0);
        button1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        button2.setFont(new java.awt.Font("Tahoma", 0, 10));
        button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sound/Clock.gif")));
        button2.setToolTipText("00:45:23.2");
        button2.setAlignmentY(0.9F);
        button2.setIconTextGap(0);
        button2.setMargin(new java.awt.Insets(0, 0, 0, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 400));
        jScrollPane1.setViewportView(jTextPane1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jButton1.setText("Information pleeeze!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        getContentPane().add(jButton1, java.awt.BorderLayout.NORTH);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int startSel = jTextPane1.getSelectionStart();
        int endSel = jTextPane1.getSelectionEnd();
        
        javax.swing.text.StyledDocument sd = (javax.swing.text.StyledDocument)(jTextPane1.getDocument());
        
        String text = "Start selection: " + startSel + "\n"
                        +   "End selection: " + endSel + "\n"
                        + "Selection text :" + jTextPane1.getSelectedText() + "\n"
                        + "Style attributes :" +  sd.getCharacterElement(startSel).getAttributes().toString();
        jTextArea1.setText(text);
                      
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DocumentTester().setVisible(true);
            }
        });
    }

    public void changedUpdate(DocumentEvent e) {
        System.out.println("changedUpdate " + e.toString());
        System.out.println("Offset " + e.getOffset());
        System.out.println("Length " + e.getLength());
        try {
            System.out.println(e.getDocument().getText(e.getOffset(),e.getLength()));
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    public void insertUpdate(DocumentEvent e) {
        System.out.println("insertUpdate " + e.toString());
        System.out.println("Offset " + e.getOffset());
        System.out.println("Length " + e.getLength());
        try {
            System.out.println(e.getDocument().getText(e.getOffset(),e.getLength()));
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    public void removeUpdate(DocumentEvent e) {
        System.out.println("removeUpdate " +  e.toString());
        System.out.println("Offset " + e.getOffset());
        System.out.println("Length " + e.getLength());
        try {
            System.out.println(e.getDocument().getText(e.getOffset(),e.getLength()));
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
    
}
