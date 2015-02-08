/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptodate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;

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
public class Settings extends javax.swing.JFrame {
    private String path;
    private String stringPath;
    private String fileName;
    private String confValue = "";
    private String confPath;
    private String chosenConf;
    /**
     * Creates new form Settings
     */
    public Settings() {
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

        configurePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        confTextField = new javax.swing.JTextField();
        confButton = new javax.swing.JButton();
        whatToDoPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        customizeViewPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        startWeek = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        changeTheme = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        configurePanel.setBackground(new java.awt.Color(34, 34, 34));

        jLabel1.setBackground(new java.awt.Color(34, 34, 34));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Files Destination: ");
        jLabel1.setOpaque(false);

        Path path = Paths.get("");
        Path realPath;

        try {
            realPath = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
            stringPath = realPath.toString();
            stringPath = stringPath.replace("\\","\\\\");
            } catch (IOException ex) {
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            }
            File fileNow = new File(stringPath + "\\AppToDate\\configuration.txt");
            if(fileNow.exists()){

                try {
                    FileReader fr = new FileReader(fileNow);
                    BufferedReader br = new BufferedReader(fr);
                    while((chosenConf = br.readLine()).matches(stringPath + "(.*)")) {
                    }
                    fr.close();
                    confTextField.setText(chosenConf.replace("\\\\","\\"));
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                confTextField.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        confTextFieldActionPerformed(evt);
                    }
                });

                confButton.setText("Configure");
                confButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        confButtonActionPerformed(evt);
                    }
                });

                javax.swing.GroupLayout configurePanelLayout = new javax.swing.GroupLayout(configurePanel);
                configurePanel.setLayout(configurePanelLayout);
                configurePanelLayout.setHorizontalGroup(
                    configurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(configurePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(configurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(confButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(configurePanelLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(confTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(26, Short.MAX_VALUE))
                );
                configurePanelLayout.setVerticalGroup(
                    configurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(configurePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(configurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(confTextField))
                        .addGap(25, 25, 25)
                        .addComponent(confButton)
                        .addContainerGap())
                );

                whatToDoPanel.setBackground(new java.awt.Color(34, 34, 34));

                okButton.setText("OK!");
                okButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        okButtonActionPerformed(evt);
                    }
                });

                cancelButton.setText("Cancel");
                cancelButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        cancelButtonActionPerformed(evt);
                    }
                });

                javax.swing.GroupLayout whatToDoPanelLayout = new javax.swing.GroupLayout(whatToDoPanel);
                whatToDoPanel.setLayout(whatToDoPanelLayout);
                whatToDoPanelLayout.setHorizontalGroup(
                    whatToDoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, whatToDoPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okButton)
                        .addContainerGap())
                );
                whatToDoPanelLayout.setVerticalGroup(
                    whatToDoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, whatToDoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(whatToDoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(okButton, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                        .addContainerGap())
                );

                customizeViewPanel.setBackground(new java.awt.Color(34, 34, 34));

                jLabel2.setBackground(new java.awt.Color(34, 34, 34));
                jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(240, 240, 240));
                jLabel2.setText("Customize View:");

                try {
                    realPath = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
                    stringPath = realPath.toString();
                    stringPath = stringPath.replace("\\","\\\\");
                    } catch (IOException ex) {
                        Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    startWeek.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" }));
                    for(int counter = 0; counter < 7; counter++){
                        File checkWeek = new File(stringPath + "\\AppToDate\\" + counter + ".txt");
                            if(checkWeek.exists()){
                                startWeek.setSelectedIndex(counter);
                            }
                        }
                        startWeek.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                startWeekActionPerformed(evt);
                            }
                        });

                        jLabel3.setBackground(new java.awt.Color(34, 34, 34));
                        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
                        jLabel3.setText("Select Week Starts on:");
                        jLabel3.setOpaque(false);

                        jLabel4.setBackground(new java.awt.Color(34, 34, 34));
                        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
                        jLabel4.setText("Change Theme:");
                        jLabel4.setOpaque(false);

                        try {
                            realPath = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
                            stringPath = realPath.toString();
                            stringPath = stringPath.replace("\\","\\\\");
                            } catch (IOException ex) {
                                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            changeTheme.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BLACK", "PINK" }));
                            File pink = new File(stringPath + "\\AppToDate\\pink.txt");
                            if(pink.exists()){
                                changeTheme.setSelectedIndex(1);
                            }
                            changeTheme.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    changeThemeActionPerformed(evt);
                                }
                            });

                            javax.swing.GroupLayout customizeViewPanelLayout = new javax.swing.GroupLayout(customizeViewPanel);
                            customizeViewPanel.setLayout(customizeViewPanelLayout);
                            customizeViewPanelLayout.setHorizontalGroup(
                                customizeViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(customizeViewPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(customizeViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(customizeViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(customizeViewPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(changeTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(customizeViewPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(startWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            );
                            customizeViewPanelLayout.setVerticalGroup(
                                customizeViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(customizeViewPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(customizeViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(startWeek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                    .addGap(21, 21, 21)
                                    .addGroup(customizeViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(changeTheme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(16, Short.MAX_VALUE))
                            );

                            jPanel4.setBackground(new java.awt.Color(34, 34, 34));

                            javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
                            jPanel4.setLayout(jPanel4Layout);
                            jPanel4Layout.setHorizontalGroup(
                                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 0, Short.MAX_VALUE)
                            );
                            jPanel4Layout.setVerticalGroup(
                                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 112, Short.MAX_VALUE)
                            );

                            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                            getContentPane().setLayout(layout);
                            layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(configurePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(whatToDoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(customizeViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            );
                            layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(configurePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(2, 2, 2)
                                    .addComponent(customizeViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(2, 2, 2)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(2, 2, 2)
                                    .addComponent(whatToDoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            );

                            if(checkPink() == 1){
                                configurePanel.setBackground(new java.awt.Color(255, 9, 88));
                            }else{
                                configurePanel.setBackground(new java.awt.Color(34, 34, 34));
                            }
                            if(checkPink() == 1){
                                whatToDoPanel.setBackground(new java.awt.Color(255, 9, 88));
                            }else{
                                whatToDoPanel.setBackground(new java.awt.Color(34, 34, 34));
                            }
                            if(checkPink() == 1){
                                customizeViewPanel.setBackground(new java.awt.Color(255, 9, 88));
                            }else{
                                customizeViewPanel.setBackground(new java.awt.Color(34, 34, 34));
                            }
                            if(checkPink() == 1){
                                jPanel4.setBackground(new java.awt.Color(255, 9, 88));
                            }else{
                                jPanel4.setBackground(new java.awt.Color(34, 34, 34));
                            }

                            pack();
                        }// </editor-fold>//GEN-END:initComponents

    private void confTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confTextFieldActionPerformed
        // TODO add your handlind code here:
    }//GEN-LAST:event_confTextFieldActionPerformed

    private void confButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confButtonActionPerformed
        // TODO add your handling code here:
        Path path = Paths.get("");
        Path realPath;
        try {
            realPath = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
            stringPath = realPath.toString();
            stringPath = stringPath.replace("\\","\\\\");
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }

        File file = new File(stringPath + "\\AppToDate" + "\\");  
        
        if(!file.exists()){
               file.mkdir();
               }
        
        
        JFileChooser choose = new JFileChooser();
        choose.setApproveButtonText("OK");
        choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        choose.setDialogTitle("Choose Directory");
        choose.setAcceptAllFileFilterUsed(false);
        choose.showOpenDialog(null);
        
        file = choose.getSelectedFile();
        fileName = file.getAbsolutePath();
        confPath = fileName.replace("\\","\\\\");
        confTextField.setText(fileName);
        
        
        File file2 = new File(stringPath + "\\AppToDate\\Settings.txt");
        if(!file2.exists()){
        try{
               Writer write = new BufferedWriter(new FileWriter(stringPath + "\\AppToDate\\Settings.txt", false));
               write.append(stringPath);
               write.close();
               }catch(IOException e){
               }
        }
        File file3 = new File(stringPath + "\\AppToDate\\configuration.txt");
        if(!file3.exists()){
        try{
               Writer write = new BufferedWriter(new FileWriter(stringPath + "\\AppToDate\\configuration.txt", false));
               write.append(confPath);
               write.close();
               }catch(IOException e){
               }
        }        
    }//GEN-LAST:event_confButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        Path path = Paths.get("");
        Path realPath;
        File file = new File(stringPath + "\\AppToDate\\pink.txt");
        File pink = new File(stringPath + "\\AppToDate\\pink.txt");
        file.delete();
        try {
            realPath = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
            stringPath = realPath.toString();
            stringPath = stringPath.replace("\\","\\\\");
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if(changeTheme.getSelectedIndex() == 1){
            file = new File(stringPath + "\\AppToDate\\pink.txt");
        if(!file.exists()){
        try{
        Writer write = new BufferedWriter(new FileWriter(stringPath + "\\AppToDate\\pink.txt", true));   
        write.close();
        }catch(IOException e){
               }  
        }else{
            file.delete();
        }
            }else{
                file = new File(stringPath + "\\AppToDate\\pink.txt");
            if(file.exists()){
                file.delete();
                pink.delete();

            }
            }
            
              if(changeTheme.getSelectedItem().equals("BLACK")){
                pink.delete();
            }
            
            
            try {    
                File week0 = new File(stringPath + "\\AppToDate\\0.txt");
                File week1 = new File(stringPath + "\\AppToDate\\1.txt");
                File week2 = new File(stringPath + "\\AppToDate\\2.txt");
                File week3 = new File(stringPath + "\\AppToDate\\3.txt");
                File week4 = new File(stringPath + "\\AppToDate\\4.txt");
                File week5 = new File(stringPath + "\\AppToDate\\5.txt");
                File week6 = new File(stringPath + "\\AppToDate\\6.txt");
            if(startWeek.getSelectedItem().equals("SUNDAY")){
                Writer sun = new BufferedWriter(new FileWriter(stringPath + "\\AppToDate\\0.txt", true));
                sun.close();
                if(week0.exists()){
                    week1.delete();
                    week2.delete();
                    week3.delete();
                    week4.delete();
                    week5.delete();
                    week6.delete();
                }
            
            }else if(startWeek.getSelectedItem().equals("MONDAY")){
                Writer mon = new BufferedWriter(new FileWriter(stringPath + "\\AppToDate\\1.txt", true));
                mon.close();
                 if(week1.exists()){
                    week0.delete();
                    week2.delete();
                    week3.delete();
                    week4.delete();
                    week5.delete();
                    week6.delete();
                }
            }else if(startWeek.getSelectedItem().equals("TUESDAY")){
                Writer tues = new BufferedWriter(new FileWriter(stringPath + "\\AppToDate\\2.txt", true));
                tues.close();
                if(week2.exists()){
                    week0.delete();
                    week1.delete();
                    week3.delete();
                    week4.delete();
                    week5.delete();
                    week6.delete();
                }
            }else if(startWeek.getSelectedItem().equals("WEDNESDAY")){
            Writer wed = new BufferedWriter(new FileWriter(stringPath + "\\AppToDate\\3.txt", true));
                wed.close();
                if(week3.exists()){
                    week0.delete();
                    week1.delete();
                    week2.delete();
                    week4.delete();
                    week5.delete();
                    week6.delete();
                }
            }else if(startWeek.getSelectedItem().equals("THURSDAY")){
             Writer thur = new BufferedWriter(new FileWriter(stringPath + "\\AppToDate\\4.txt", true));
                thur.close();
                if(week4.exists()){
                    week0.delete();
                    week1.delete();
                    week2.delete();
                    week3.delete();
                    week5.delete();
                    week6.delete();
                }
            }else if(startWeek.getSelectedItem().equals("FRIDAY")){
            Writer fri = new BufferedWriter(new FileWriter(stringPath + "\\AppToDate\\5.txt", true));
                fri.close();
                 if(week5.exists()){
                    week0.delete();
                    week1.delete();
                    week2.delete();
                    week3.delete();
                    week4.delete();
                    week6.delete();
                }
            }else if(startWeek.getSelectedItem().equals("SATURDAY")){
            Writer sat = new BufferedWriter(new FileWriter(stringPath + "\\AppToDate\\6.txt", true));
                sat.close();
                 if(week6.exists()){
                    week0.delete();
                    week1.delete();
                    week2.delete();
                    week3.delete();
                    week4.delete();
                    week5.delete();
                }
            }} catch (IOException ex) {
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        close();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        close();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void startWeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startWeekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startWeekActionPerformed

    private void changeThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeThemeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changeThemeActionPerformed

    private void close(){
        this.dispose();
    }
    
    private int checkPink(){
        Path path = Paths.get("");
        Path realPath;
        int check = 0;
        try {
            realPath = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
            stringPath = realPath.toString();
            stringPath = stringPath.replace("\\","\\\\");
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        File pink = new File(stringPath + "\\AppToDate\\pink.txt");
        if(pink.exists()){
            check = 1;
        }
        return check;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])throws IOException {
        /* Set the Nimbus look and feel */
  
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                /*if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }*/
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            }
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
   
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Settings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox changeTheme;
    private javax.swing.JButton confButton;
    private javax.swing.JTextField confTextField;
    private javax.swing.JPanel configurePanel;
    private javax.swing.JPanel customizeViewPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox startWeek;
    private javax.swing.JPanel whatToDoPanel;
    // End of variables declaration//GEN-END:variables
}