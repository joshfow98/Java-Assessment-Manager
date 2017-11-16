/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assesment.manager.UI;

import Engine.CurrentAssessmentsEngine;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author joshf
 */
public class CurrentAssessments extends javax.swing.JFrame {

    static Engine.Assessment[] a = new Engine.Assessment[0];
    /**
     * Creates new form CurrentAssessments
     */
    public CurrentAssessments() {
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

        cbAssessmentID = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tpAssessmentModule = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        taAssessmentDescription = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnCompleted = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tpAssessmentTitle = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tpDateDue = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        tpReminderDate = new javax.swing.JTextPane();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbAssessmentID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAssessmentIDItemStateChanged(evt);
            }
        });
        cbAssessmentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAssessmentIDActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(tpAssessmentModule);

        taAssessmentDescription.setColumns(20);
        taAssessmentDescription.setRows(5);
        jScrollPane2.setViewportView(taAssessmentDescription);

        jLabel1.setText("Assessment ID");

        jLabel2.setText("Assessment Module");

        jLabel3.setText("Assessment Description");

        jLabel4.setText("Assessment Due Date (yyyy-mm-dd) ");

        jLabel5.setText("Assessment Reminder Date (yyyy-mm-dd)");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCompleted.setText("Assessment Completed");
        btnCompleted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompletedActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(tpAssessmentTitle);

        jLabel6.setText("Assessment Title");

        jScrollPane3.setViewportView(tpDateDue);

        jScrollPane5.setViewportView(tpReminderDate);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6)))
                                .addComponent(cbAssessmentID, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCompleted))
                            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAssessmentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnCompleted))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExit)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbAssessmentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAssessmentIDActionPerformed
        
        /*boolean recordFound = false;
        int selectedRecord = (int) cbAssessmentID.getSelectedItem(), i = -1;
        Engine.Assessment record = new Engine.Assessment();
        
        while(i < a.length){
            
            i++;
            
            if(selectedRecord == a[i].assessmentID){
                
                record = a[i];
                System.out.println("hey");
                break;
                
            }
            
        }*/
    }//GEN-LAST:event_cbAssessmentIDActionPerformed
    
    private void cbAssessmentIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAssessmentIDItemStateChanged
        
        /*Engine.Assessment a = new Engine.Assessment();
        Calendar cal = Calendar.getInstance();
        a = Engine.CurrentAssessmentsEngine.getRecord(String.valueOf(cbAssessmentID.getSelectedItem()));
        
        tpAssessmentTitle.setText(a.getTitle());
        tpAssessmentModule.setText(a.getModule());
        taAssessmentDescription.setText(a.getDescription());
        tpDateDue.setText(a.getDue().toString());
        tpReminderDate.setText(a.getDate().toString());*/
        
        getCurrentRecord();
        
        
    }//GEN-LAST:event_cbAssessmentIDItemStateChanged

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        Engine.Assessment a = new Engine.Assessment();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String newID = tpAssessmentTitle.getText() + tpAssessmentModule.getText();
        Date dueDate, reminderDate;
        
        a.setID(String.valueOf(cbAssessmentID.getSelectedItem()));
        a.setTitle(tpAssessmentTitle.getText());
        a.setModule(tpAssessmentModule.getText());
        a.setDescription(taAssessmentDescription.getText());
        
        try{
            
            dueDate = sdf.parse(tpDateDue.getText());
            reminderDate = sdf.parse(tpReminderDate.getText());
            
            a.setDue(new java.sql.Date(dueDate.getTime()));
            a.setDate(new java.sql.Date(reminderDate.getTime()));
            
        } catch (ParseException e){
            
            System.out.println(e);
            
        }
        
        Engine.CurrentAssessmentsEngine.updateRecord(a, newID);
        //removes the old ID and sets the new one
        //only used if assesment title or module is changed 
        if(!newID.equals(cbAssessmentID.getSelectedItem())){
        
            int removeSelectedID = cbAssessmentID.getSelectedIndex();
            cbAssessmentID.removeItemAt(removeSelectedID);
        
            cbAssessmentID.addItem(newID);
        
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed
    
    public void getCurrentRecord(){
        
        Engine.Assessment a = new Engine.Assessment();
        Calendar cal = Calendar.getInstance();
        a = Engine.CurrentAssessmentsEngine.getRecord(String.valueOf(cbAssessmentID.getSelectedItem()));
        
        tpAssessmentTitle.setText(a.getTitle());
        tpAssessmentModule.setText(a.getModule());
        taAssessmentDescription.setText(a.getDescription());
        tpDateDue.setText(a.getDue().toString());
        tpReminderDate.setText(a.getDate().toString());
        
    }
    
    private void btnCompletedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompletedActionPerformed
        
        String assessmentID = String.valueOf(cbAssessmentID.getSelectedItem());
        
        Engine.CurrentAssessmentsEngine.assessmentCompleted(assessmentID);
        
        int removeSelectedID = cbAssessmentID.getSelectedIndex();
        cbAssessmentID.removeItemAt(removeSelectedID);
        
    }//GEN-LAST:event_btnCompletedActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
       
        Home h = new Home();
        
        h.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(CurrentAssessments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CurrentAssessments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CurrentAssessments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CurrentAssessments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new CurrentAssessments().setVisible(true);
                addAssessmentTitle();
            }
        });
        
        
    }

    public static void addAssessmentTitle(){
        
        CurrentAssessmentsEngine cae = new CurrentAssessmentsEngine();
        String[] assessmentIDs;
        
        assessmentIDs = cae.addIDs();

        for(int i = 0; i < assessmentIDs.length;i++){

            cbAssessmentID.addItem(assessmentIDs[i]);
            
        }
        
    }
    
   /* public static Engine.Assessment getRecord(int assessmentID){
        
        //Engine.Assessment record = new Engine.Assessment();
        boolean foundRecord = false;
        int i = -1;
        
        while(foundRecord == false || i < a.length - 1){
            
            i++;
            
            if(a[i].assessmentID == assessmentID){
                
                foundRecord = true;
               
            }
            
        }
        
       return  a[i];
       
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompleted;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private static javax.swing.JComboBox<String> cbAssessmentID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea taAssessmentDescription;
    private javax.swing.JTextPane tpAssessmentModule;
    private javax.swing.JTextPane tpAssessmentTitle;
    private javax.swing.JTextPane tpDateDue;
    private javax.swing.JTextPane tpReminderDate;
    // End of variables declaration//GEN-END:variables
}
