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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

public class DailyView extends javax.swing.JFrame {

    /**
     * Creates new form dailyView
     */
    private String[][] d = new String[13][8];
    public String thePathOfFile = "";
    private String whatDayNow = "1";
    private String stringPath;
    public String combineData;
    private int monthNum = 1;
    private int year;
    private int rowNum;
    public DailyView() {
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

        jPanel1 = new javax.swing.JPanel();
        yearButton = new javax.swing.JButton();
        monthButton = new javax.swing.JButton();
        dayButton = new javax.swing.JButton();
        leftYearArrow = new javax.swing.JButton();
        yearRightArrow = new javax.swing.JButton();
        settings = new javax.swing.JButton();
        modifyAdd = new javax.swing.JButton();
        viewAllButton = new javax.swing.JButton();
        yearLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        dayComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        monthComboBox = new javax.swing.JComboBox();
        showButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(34, 34, 34));

        yearButton.setBackground(new java.awt.Color(34, 34, 34));
        yearButton.setContentAreaFilled(false);
        yearButton.setOpaque(true);
        yearButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        yearButton.setForeground(new java.awt.Color(240, 240, 240));
        yearButton.setText("YEAR");
        yearButton.setBorder(null);
        yearButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        yearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearButtonActionPerformed(evt);
            }
        });

        monthButton.setBackground(new java.awt.Color(34,34,34));
        monthButton.setContentAreaFilled(false);
        monthButton.setOpaque(true);
        monthButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        monthButton.setForeground(new java.awt.Color(240, 240, 240));
        monthButton.setText("MONTH");
        monthButton.setBorder(null);
        monthButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        monthButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthButtonActionPerformed(evt);
            }
        });

        dayButton.setBackground(new java.awt.Color(29, 114, 239));
        dayButton.setContentAreaFilled(false);
        dayButton.setOpaque(true);
        dayButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        dayButton.setForeground(new java.awt.Color(240, 240, 240));
        dayButton.setText("DAY");
        dayButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        leftYearArrow.setBackground(new java.awt.Color(34, 34, 34));
        leftYearArrow.setForeground(new java.awt.Color(34, 34, 34));
        leftYearArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptodate/images/left_arrow.png"))); // NOI18N
        leftYearArrow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        leftYearArrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftYearArrowActionPerformed(evt);
            }
        });

        yearRightArrow.setBackground(new java.awt.Color(34, 34, 34));
        yearRightArrow.setForeground(new java.awt.Color(34, 34, 34));
        yearRightArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptodate/images/right_arrow.png"))); // NOI18N
        yearRightArrow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        yearRightArrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearRightArrowActionPerformed(evt);
            }
        });

        settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptodate/images/wrench.png"))); // NOI18N
        settings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsActionPerformed(evt);
            }
        });

        modifyAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptodate/images/add.png"))); // NOI18N
        modifyAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modifyAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyAddActionPerformed(evt);
            }
        });

        viewAllButton.setBackground(new java.awt.Color(29, 114, 239));
        viewAllButton.setContentAreaFilled(false);
        viewAllButton.setOpaque(true);
        viewAllButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        viewAllButton.setForeground(new java.awt.Color(240, 240, 240));
        viewAllButton.setText("VIEW ALL");
        viewAllButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllButtonActionPerformed(evt);
            }
        });

        yearLabel.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        yearLabel.setForeground(new java.awt.Color(240, 240, 240));
        yearLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(yearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(monthButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(dayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewAllButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(leftYearArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(yearRightArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(modifyAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(yearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(monthButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dayButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(yearRightArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(leftYearArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(modifyAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(viewAllButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(yearLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        if(checkPink() == 1){
            yearButton.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            yearButton.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            monthButton.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            monthButton.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptodate/images/pinkWrench.png"))); // NOI18N
        }
        if(checkPink() == 1){
            modifyAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptodate/images/pinkAdd.png"))); // NOI18N
        }
        if(checkPink() == 1){
            viewAllButton.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            viewAllButton.setBackground(new java.awt.Color(34, 34, 34));
        }
        yearLabel.setText(String.valueOf(getYear()));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel2.setBackground(new java.awt.Color(34, 34, 34));

        jTable1.setBackground(new java.awt.Color(34, 34, 34));
        jTable1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTable1.getTableHeader().setReorderingAllowed(Boolean.FALSE);
        jTable1.setForeground(new java.awt.Color(240, 240, 240));
        String[][] d = new String[24][8];

        for(int cntr = 0; cntr < 24; cntr++ ){
            for(int cntr2 = 0; cntr2 < 8; cntr2++){
                d[cntr][cntr2] = "";
            }
        }
        for(int cntr = 0; cntr < getNumOfFiles(); cntr++){
            try {
                d[cntr][0] = getData(cntr, 0);
                d[cntr][1] = getData(cntr, 1);
                d[cntr][2] = getData(cntr, 2);
                d[cntr][3] = getData(cntr, 3);
                d[cntr][4] = getData(cntr, 4);
                d[cntr][5] = getData(cntr, 5);
                d[cntr][6] = getData(cntr, 6);
                d[cntr][7] = thePathOfFile;
            } catch (IOException ex) {
                Logger.getLogger(DailyView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {d[0][0], d[0][1], d[0][2], d[0][3], d[0][4], d[0][5], d[0][6]},
                {d[1][0], d[1][1], d[1][2], d[1][3], d[1][4], d[1][5], d[1][6]},
                {d[2][0], d[2][1], d[2][2], d[2][3], d[2][4], d[2][5], d[2][6]},
                {d[3][0], d[3][1], d[3][2], d[3][3], d[3][4], d[3][5], d[3][6]},
                {d[4][0], d[4][1], d[4][2], d[4][3], d[4][4], d[4][5], d[4][6]},
                {d[5][0], d[5][1], d[5][2], d[5][3], d[5][4], d[5][5], d[5][6]},
                {d[6][0], d[6][1], d[6][2], d[6][3], d[6][4], d[6][5], d[6][6]},
                {d[7][0], d[7][1], d[7][2], d[7][3], d[7][4], d[7][5], d[7][6]},
                {d[8][0], d[8][1], d[8][2], d[8][3], d[8][4], d[8][5], d[8][6]},
                {d[9][0], d[9][1], d[9][2], d[9][3], d[9][4], d[9][5], d[9][6]},
                {d[10][0], d[10][1], d[10][2], d[10][3], d[10][4], d[10][5], d[10][6]},
                {d[11][0], d[11][1], d[11][2], d[11][3], d[11][4], d[11][5], d[11][6]},
                {d[12][0], d[12][1], d[12][2], d[12][3], d[12][4], d[12][5], d[12][6]},
                {d[13][0], d[13][1], d[13][2], d[13][3], d[13][4], d[13][5], d[13][6]},
                {d[14][0], d[14][1], d[14][2], d[14][3], d[14][4], d[14][5], d[14][6]},
                {d[15][0], d[15][1], d[15][2], d[15][3], d[15][4], d[15][5], d[15][6]},
                {d[16][0], d[16][1], d[16][2], d[16][3], d[16][4], d[16][5], d[16][6]},
                {d[17][0], d[17][1], d[17][2], d[17][3], d[17][4], d[17][5], d[17][6]},
                {d[18][0], d[18][1], d[18][2], d[18][3], d[18][4], d[18][5], d[18][6]},
                {d[19][0], d[19][1], d[19][2], d[19][3], d[19][4], d[19][5], d[19][6]},
                {d[20][0], d[20][1], d[20][2], d[20][3], d[20][4], d[20][5], d[20][6]},
                {d[21][0], d[21][1], d[21][2], d[21][3], d[21][4], d[21][5], d[21][6]},
                {d[22][0], d[22][1], d[22][2], d[22][3], d[22][4], d[22][5], d[22][6]},
                {d[13][0], d[23][1], d[23][2], d[23][3], d[23][4], d[23][5], d[23][6]},
            },
            new String [] {
                "Event Title", "Description", "Subject", "Started Time", "From", "Until Time", "Until"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setDragEnabled(true);
        jTable1.setIntercellSpacing(new java.awt.Dimension(4, 4));
        jTable1.setRowHeight(26);
        jScrollPane1.setViewportView(jTable1);
        if(checkPink() == 1){
            jTable1.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            jTable1.setBackground(new java.awt.Color(34, 34, 34));
        }

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("DAY:");

        dayComboBox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        dayComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("MONTH:");

        monthComboBox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        monthComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboBoxActionPerformed(evt);
            }
        });

        showButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        showButton.setText("SHOW");
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        clearButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dayComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(monthComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(807, 807, 807))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel2);
        if(checkPink() == 1){
            jPanel2.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            jPanel2.setBackground(new java.awt.Color(34, 34, 34));
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2))
        );

        if(checkPink() == 1){
            jPanel1.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            jPanel1.setBackground(new java.awt.Color(34, 34, 34));
        }

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void close(){
        this.dispose();
        for(int cntr = 0; cntr < getNumOfFiles(); cntr++){
    
            
}
    }
       
    private void yearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearButtonActionPerformed
        // TODO add your handling code here:
        close();
        YearlyView yv = new YearlyView();
        yv.setVisible(true);
    }//GEN-LAST:event_yearButtonActionPerformed

    private void monthButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthButtonActionPerformed
        // TODO add your handling code here:
        close();
        MonthlyView mv = new MonthlyView();
        mv.setVisible(true);
    }//GEN-LAST:event_monthButtonActionPerformed

    private void leftYearArrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftYearArrowActionPerformed
        // TODO add your handling code here:
        year = year - 1;
        yearLabel.setText(String.valueOf(year));
        
    }//GEN-LAST:event_leftYearArrowActionPerformed

    private void yearRightArrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearRightArrowActionPerformed
        // TODO add your handling code here:
        year = year + 1;
        yearLabel.setText(String.valueOf(year));
        yearLabel.setText(String.valueOf(year));
        
    }//GEN-LAST:event_yearRightArrowActionPerformed

    private void settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Settings().setVisible(true);
            }
        });
    }//GEN-LAST:event_settingsActionPerformed
         
        private int getYear(){
        GregorianCalendar cal = new GregorianCalendar();
        year = cal.get(Calendar.YEAR);
        return year;
    }
        
    private void modifyAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyAddActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyAdd().setVisible(true);
            }
        });
    }//GEN-LAST:event_modifyAddActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        rowNum = jTable1.getSelectedRow();
        String theRow = (String) model.getValueAt(rowNum, 7);
        File file = new File(theRow);
        if(file.exists()){
            file.delete();
        }
        
        
        if(file.exists()){
            String string1 = (String) model.getValueAt(rowNum, 0);
            String string2 = (String) model.getValueAt(rowNum, 6);
            string1 = string1.trim();
            string2 = string2.trim();
            string2 = string2.replaceAll(" ","-");
            string2 = string2.replaceAll(",","");
            string1 = string1 + "-";
            
            String pathOfEvent = getPath().replace("\\\\", "\\");
            file = new File(pathOfEvent + "\\AppToDate\\Events\\" + string1 + string2 + ".txt");
            file.delete();
            
             JOptionPane.showMessageDialog(null, "DELETING...", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
 
            try {
                Thread.sleep(5000);
                JOptionPane.showMessageDialog(null, "FINISH", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);

            } catch (InterruptedException ex) {
                Logger.getLogger(DailyView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        

        
        
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    
    private void dayComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayComboBoxActionPerformed
        // TODO add your handling code here:
        whatDayNow = (String) dayComboBox.getSelectedItem();
        System.out.println(whatDayNow);
    }//GEN-LAST:event_dayComboBoxActionPerformed

    private void monthComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthComboBoxActionPerformed
        // TODO add your handling code here:
        String item = "";
        item = (String) monthComboBox.getSelectedItem();
        monthNum = Integer.parseInt(item);
        System.out.println(monthNum);

    }//GEN-LAST:event_monthComboBoxActionPerformed

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        // TODO add your handling code here:
           
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for(int cntr = 0; cntr < getNumOfFiles(); cntr++){
try {
        d[cntr][0] = getData(cntr, 0);
        d[cntr][1] = getData(cntr, 1);
        d[cntr][2] = getData(cntr, 2);
        d[cntr][3] = getData(cntr, 3);
        d[cntr][4] = getData(cntr, 4);
        d[cntr][5] = getData(cntr, 5);
        d[cntr][6] = getData(cntr, 6);
        d[cntr][7] = thePathOfFile;
        model.setValueAt(d[cntr][0], cntr, 0);
        model.setValueAt(d[cntr][1], cntr, 1);
        model.setValueAt(d[cntr][2], cntr, 2);
        model.setValueAt(d[cntr][3], cntr, 3);
        model.setValueAt(d[cntr][4], cntr, 4);
        model.setValueAt(d[cntr][5], cntr, 5);
        model.setValueAt(d[cntr][6], cntr, 6);

        
    } catch (IOException ex) {
                Logger.getLogger(DailyView.class.getName()).log(Level.SEVERE, null, ex);
            }

}
        
    }//GEN-LAST:event_showButtonActionPerformed

    private void viewAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllButtonActionPerformed
        // TODO add your handling code here:
        viewAll va = new viewAll();
        va.setVisible(true);
    }//GEN-LAST:event_viewAllButtonActionPerformed

    private void dayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for(int cntr = 0; cntr < 24; cntr++){
            d[cntr][0] = "";
            d[cntr][1] = "";
            d[cntr][2] = "";
            d[cntr][3] = "";
            d[cntr][4] = "";
            d[cntr][5] = "";
            d[cntr][6] = "";
            d[cntr][7] = "";
            model.setValueAt(d[cntr][0], cntr, 0);
            model.setValueAt(d[cntr][1], cntr, 1);
            model.setValueAt(d[cntr][2], cntr, 2);
            model.setValueAt(d[cntr][3], cntr, 3);
            model.setValueAt(d[cntr][4], cntr, 4);
            model.setValueAt(d[cntr][5], cntr, 5);
            model.setValueAt(d[cntr][6], cntr, 6);
        }
    }//GEN-LAST:event_clearButtonActionPerformed
    
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
     
     public String getData(int num, int num2) throws FileNotFoundException, IOException{
        int j = 0;
        String combineAll = "";
        String[] splitString = new String[5];
        File file = new File(getPath() + "\\AppToDate\\" + yearLabel.getText() 
                + "\\" + getMonthNum(monthNum) + "\\" + whatDayNow + "\\" + getFileNames(num));
        FileReader read = new FileReader(getPath() + "\\AppToDate\\" + yearLabel.getText() 
                + "\\" + getMonthNum(monthNum) + "\\" + whatDayNow + "\\" + getFileNames(num));
        BufferedReader br = new BufferedReader(read);
        String[] descData = new String[100];
        if(file.exists()){
        j = 0;    
            while((descData[j] = br.readLine()) != null) { 

            j++;
            } 
            br.close();
        for(int k = 0; k <= j; k++){
            combineAll = combineAll + descData[k];
        }
        splitString = combineAll.split("\\+");
        }
        thePathOfFile = getPath() + "\\AppToDate\\" + yearLabel.getText() 
                + "\\" + getMonthNum(monthNum) + "\\" + whatDayNow + "\\" + getFileNames(num);
    
        return splitString[num2];
    }
      
    public String getDataInfo(){
        return this.combineData;
    }    
    
    public String getFileNames(int num){
        String thePathFile[] = new String[1000];
        String filePath = getPath();
        File folder = new File(filePath + "\\AppToDate\\" + yearLabel.getText() + "\\" + getMonthNum(monthNum) + "\\" + whatDayNow);
        File[] listOfFiles = folder.listFiles();
      if(folder.exists()){
    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
        thePathFile[i] = listOfFiles[i].getName();
      }
    }
      }else if(!folder.exists()){
          thePathFile[num] = "NONE";
      }
    return thePathFile[num];
    }
    
    public String getMonthNum(int num){
        String stringMonth = "";
        num = num - 1;
        if(num == 0){
            stringMonth = "JAN";
        }
        
        if(num == 1){
            stringMonth = "FEB";
        }
        
        if(num == 2){
            stringMonth = "MAR";
        }
        
        if(num == 3){
            stringMonth = "APR";
        }
        
        if(num == 4){
            stringMonth = "MAY";
        }
        
        if(num == 5){
            stringMonth = "JUN";
        }
        
        if(num == 6){
            stringMonth = "JUL";
        }
        
        if(num == 7){
            stringMonth = "AUG";
        }
        
        if(num == 8){
            stringMonth = "SEP";
        }
        
        if(num == 9){
            stringMonth = "OCT";
        }
        
        if(num == 10){
            stringMonth = "NOV";
        }
        
        if(num == 11){
            stringMonth = "DEC";
        }
        
        return stringMonth;
    }
   
    public int getNumOfFiles(){
        String thePathFile[] = new String[1000];
        String filePath = getPath();
        File folder = new File(filePath + "\\AppToDate\\" + yearLabel.getText() + "\\" + getMonthNum(monthNum) + "\\" + whatDayNow) ;
        File[] listOfFiles = folder.listFiles();
        int numFiles = 0;
    if(folder.exists()){
       
    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
        thePathFile[i] = listOfFiles[i].getName();
        
      } 
      if(i == listOfFiles.length - 1){
          numFiles = listOfFiles.length;
      }
    }
    }else if(!folder.exists()){
        numFiles = 0;
    }
    return numFiles;
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
     
    public void setDataInfo(String data){
        this.combineData = data;
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
            java.util.logging.Logger.getLogger(DailyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DailyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DailyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DailyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DailyView().setVisible(true);
            }
        });
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JButton dayButton;
    private javax.swing.JComboBox dayComboBox;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton leftYearArrow;
    private javax.swing.JButton modifyAdd;
    private javax.swing.JButton monthButton;
    private javax.swing.JComboBox monthComboBox;
    private javax.swing.JButton settings;
    private javax.swing.JButton showButton;
    private javax.swing.JButton viewAllButton;
    private javax.swing.JButton yearButton;
    private javax.swing.JLabel yearLabel;
    private javax.swing.JButton yearRightArrow;
    // End of variables declaration//GEN-END:variables
}
