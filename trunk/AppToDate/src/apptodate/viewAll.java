/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package apptodate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *@author Revamp Group
 * Bacalanmo, Yra
 * Damot, Peter Paul
 * Delos Santos, Denmark
 * Flores, Jann Marie
 * Ingco, Chester
 * Lao, Charles
 * Ligos, Klarence
 * Navarro, Frances Joffany
 * Pamintuan, Louisa
 * Sanchez, Ashley
 * Toledo, Jazelle Mae
 * Venturina, Kevin 
 */

public class viewAll extends javax.swing.JFrame {

    /**
     * Creates new form viewAll
     */
    private String stringPath;
    private String[] data;
    private String[][] info;
    private String[][] info2;
    private String[][] info3; 
    
    public viewAll() {
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

        settings1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        modifyAdd = new javax.swing.JButton();
        settings = new javax.swing.JButton();
        sortByBox = new javax.swing.JComboBox();
        sortByLabel = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventsTable = new javax.swing.JTable();

        settings1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptodate/images/wrench.png"))); // NOI18N
        settings1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settings1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settings1ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(34, 34, 34));

        modifyAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptodate/images/add.png"))); // NOI18N
        modifyAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modifyAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyAddActionPerformed(evt);
            }
        });

        settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptodate/images/wrench.png"))); // NOI18N
        settings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsActionPerformed(evt);
            }
        });

        sortByBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Day", "Month", "Year" }));
        sortByBox.setToolTipText("");

        sortByLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sortByLabel.setForeground(new java.awt.Color(240, 240, 240));
        sortByLabel.setText("Sort By:");

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updateButton)
                .addGap(18, 18, 18)
                .addComponent(sortByLabel)
                .addGap(16, 16, 16)
                .addComponent(sortByBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(modifyAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sortByBox)
                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sortByLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(51, 61, 68));
        jPanel2.setPreferredSize(new java.awt.Dimension(5, 351));

        eventsTable.setBackground(new java.awt.Color(51, 61, 68));
        eventsTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        eventsTable.setForeground(new java.awt.Color(204, 204, 204));
        eventsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date Start", "Event", "DeadLine", "End Time"
            }
        ));
        eventsTable.setPreferredSize(new java.awt.Dimension(561, 440));
        jScrollPane1.setViewportView(eventsTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modifyAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyAddActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyAdd().setVisible(true);
            }
        });
    }//GEN-LAST:event_modifyAddActionPerformed

    private void settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Settings().setVisible(true);
            }
        });
    }//GEN-LAST:event_settingsActionPerformed

    private void settings1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settings1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_settings1ActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        try {
            // TODO add your handling code here:
        
        fileInfo();
        DefaultTableModel model = (DefaultTableModel) eventsTable.getModel();
        model.setRowCount(0);
       
        
        for(int count = 0; count < countFiles(); count++){
        model.addRow(new Object[]{info2[count][0], info2[count][1], info2[count][2], info2[count][3]});
        }
            } catch (IOException ex) {
            Logger.getLogger(viewAll.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_updateButtonActionPerformed
    
    private void sort(){
        int arr[];
        int sortBy = 0;
        if(sortByBox.getSelectedItem().equals("Day")){
           sortBy = 1;
        }
        if(sortByBox.getSelectedItem().equals("Month")){
           sortBy = 2;
        }
        if(sortByBox.getSelectedItem().equals("Year")){
           sortBy = 3;
        }
        
        
        arr = new int[countFiles()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(info2[i][sortBy]);
        }
        
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;
      
            int smallerNumber = arr[index]; 
            arr[index] = arr[i];
            arr[i] = smallerNumber;
            info3[index][0] = info2[i][0]; 
            info3[index][1] = info2[i][1]; 
            info3[index][2] = info2[i][2]; 
            info3[index][3] = info2[i][3]; 
        }
    }
    
    private void fileInfo() throws FileNotFoundException, IOException{
        int fileCount = countFiles();
        int counter = 0;
        data = new String[fileCount];
        File folder = new File(getPath() + "\\AppToDate\\Events");
        File[] listOfFiles = folder.listFiles();
        if(folder.exists()){
        for (int i = 0; i < listOfFiles.length; i++) {
                data[counter] = listOfFiles[i].getName();
                counter++;
            
        }
        }
        info = new String[fileCount][4];
        info2 = new String[fileCount][4];
        String[][] datePart = new String[fileCount][3];
        for(int num = 0; num < fileCount; num++){
        String[] part = data[num].split("-");
        
        info[num][0] = part[0];
        info[num][1] = part[1];
        info[num][2] = part[2];        
        info[num][3] = part[3];
        
        }
        
        
        
        for(int num = 0; num < fileCount; num++){
        BufferedReader br = new BufferedReader(new FileReader(getPath() + "\\AppToDate\\Events\\" + data[num]));
        String line = null;
        while ((line = br.readLine()) != null) {
        String[] part = line.split("\\+");
        info2[num][0] = part[0];
        info2[num][1] = part[1];
        info2[num][2] = part[2];
        info2[num][3] = part[3];        
            }
 }
    }
    
    public String getPath(){
        Path path = Paths.get("");
        Path realPath;
        try {
            realPath = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
            stringPath = realPath.toString();
            stringPath = stringPath.replace("\\","\\\\");
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        String myPathData = "";
        File file2 = new File(stringPath + "\\AppToDate\\configuration.txt");
        String myConfig = file2.toString();
        try {
            FileReader fr = new FileReader(myConfig);
            BufferedReader textRead = new BufferedReader(fr);
            
            try {
                myPathData = textRead.readLine();
            } catch (IOException ex) {
                Logger.getLogger(ModifyAdd.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModifyAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return myPathData;
    }
    private int countFiles(){
        File f = new File(getPath() + "\\AppToDate\\Events");
        int count = 0;
        if(f.exists()){
            for (File file : f.listFiles()) {
                if (file.isFile()) {
                    count++;
                    }
                }
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewAll().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable eventsTable;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton modifyAdd;
    private javax.swing.JButton settings;
    private javax.swing.JButton settings1;
    private javax.swing.JComboBox sortByBox;
    private javax.swing.JLabel sortByLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
