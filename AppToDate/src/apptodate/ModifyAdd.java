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
public class ModifyAdd extends javax.swing.JFrame {

    /**
     * Creates new form ModifyAdd
     */
    public String stringPath;
    public ModifyAdd() {
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
        eventLabel = new javax.swing.JLabel();
        eventArea = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descArea = new javax.swing.JTextArea();
        descLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        fromLabel = new javax.swing.JLabel();
        untilLabel = new javax.swing.JLabel();
        fromHour = new javax.swing.JComboBox();
        untilHour = new javax.swing.JComboBox();
        fromMinute = new javax.swing.JComboBox();
        untilMinute = new javax.swing.JComboBox();
        fromAmpm = new javax.swing.JComboBox();
        untilAmpm = new javax.swing.JComboBox();
        wholeDayEvent = new javax.swing.JRadioButton();
        fromLabel1 = new javax.swing.JLabel();
        untilLabel1 = new javax.swing.JLabel();
        untilMonth = new javax.swing.JComboBox();
        fromMonth = new javax.swing.JComboBox();
        fromDay = new javax.swing.JComboBox();
        untilDay = new javax.swing.JComboBox();
        fromYear = new javax.swing.JComboBox();
        untilYear = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        subectLabel = new javax.swing.JLabel();
        subjectText = new javax.swing.JTextField();
        imagesLabel = new javax.swing.JLabel();
        imgBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(34, 34, 34));
        jPanel1.setForeground(new java.awt.Color(240, 240, 240));

        eventLabel.setBackground(new java.awt.Color(34, 34, 34));
        eventLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        eventLabel.setForeground(new java.awt.Color(240, 240, 240));
        eventLabel.setText("Event Name:");
        eventLabel.setOpaque(false);

        eventArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventAreaActionPerformed(evt);
            }
        });

        descArea.setColumns(20);
        descArea.setRows(5);
        jScrollPane1.setViewportView(descArea);

        descLabel.setBackground(new java.awt.Color(34, 34, 34));
        descLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        descLabel.setForeground(new java.awt.Color(240, 240, 240));
        descLabel.setText("Description:");
        descLabel.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eventLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(eventArea))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eventArea)
                    .addComponent(eventLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(descLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(51, 61, 68));

        okButton.setText("OK!");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("CANCEL!");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(34, 34, 34));

        fromLabel.setBackground(new java.awt.Color(34, 34, 34));
        fromLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fromLabel.setForeground(new java.awt.Color(240, 240, 240));
        fromLabel.setText("From:");
        fromLabel.setOpaque(false);

        untilLabel.setBackground(new java.awt.Color(34, 34, 34));
        untilLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        untilLabel.setForeground(new java.awt.Color(240, 240, 240));
        untilLabel.setText("Until:");
        untilLabel.setOpaque(false);

        fromHour.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        fromHour.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        untilHour.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        untilHour.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        fromMinute.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        fromMinute.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        untilMinute.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        untilMinute.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        fromAmpm.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        fromAmpm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AM", "PM" }));

        untilAmpm.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        untilAmpm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AM", "PM" }));

        wholeDayEvent.setBackground(new java.awt.Color(34, 34, 34));
        wholeDayEvent.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        wholeDayEvent.setForeground(new java.awt.Color(240, 240, 240));
        wholeDayEvent.setText("Whole Day Event");
        wholeDayEvent.setOpaque(false);

        fromLabel1.setBackground(new java.awt.Color(34, 34, 34));
        fromLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fromLabel1.setForeground(new java.awt.Color(240, 240, 240));
        fromLabel1.setText("From:");
        fromLabel1.setOpaque(false);

        untilLabel1.setBackground(new java.awt.Color(34, 34, 34));
        untilLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        untilLabel1.setForeground(new java.awt.Color(240, 240, 240));
        untilLabel1.setText("Until:");
        untilLabel1.setOpaque(false);

        untilMonth.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        untilMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" }));

        fromMonth.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        fromMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" }));

        fromDay.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        fromDay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        untilDay.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        untilDay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        fromYear.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        fromYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100" }));

        untilYear.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        untilYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(untilLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fromLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fromLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(untilLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(fromHour, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fromMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fromAmpm, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(wholeDayEvent))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(untilHour, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(untilMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(untilAmpm, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(untilMonth, 0, 65, Short.MAX_VALUE)
                            .addComponent(fromMonth, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(fromDay, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fromYear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(untilDay, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(untilYear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fromLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fromHour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromAmpm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wholeDayEvent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(untilLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(untilHour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(untilMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(untilAmpm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fromLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fromMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromDay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromYear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(untilLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(untilMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(untilDay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(untilYear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        jPanel4.setBackground(new java.awt.Color(34, 34, 34));

        subectLabel.setBackground(new java.awt.Color(34, 34, 34));
        subectLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        subectLabel.setForeground(new java.awt.Color(240, 240, 240));
        subectLabel.setText("Subject:");

        subjectText.setText("Subject!");
        subjectText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectTextActionPerformed(evt);
            }
        });

        imagesLabel.setBackground(new java.awt.Color(34, 34, 34));
        imagesLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        imagesLabel.setForeground(new java.awt.Color(240, 240, 240));
        imagesLabel.setText("Images:");

        imgBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Assignment.png", "Exam.png", "Meeting.png", "Presentation.png", "Quiz.png" }));
        imgBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imgBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subjectText)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imagesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(imgBox, 0, 166, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(subectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subjectText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        if(checkPink() == 1){
            jPanel1.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            jPanel1.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            jPanel2.setBackground(new java.awt.Color(255, 174, 201));
        }else{
            jPanel2.setBackground(new java.awt.Color(51, 61, 88));
        }
        if(checkPink() == 1){
            jPanel3.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            jPanel3.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            jPanel4.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            jPanel4.setBackground(new java.awt.Color(34, 34, 34));
        }

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eventAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventAreaActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        close();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:        
        String eventTitle = eventArea.getText();
        String desc = descArea.getText();
        String subj = subjectText.getText();
        String fromH = fromHour.getSelectedItem().toString();
        String fromM = fromMinute.getSelectedItem().toString();
        String Fampm = fromAmpm.getSelectedItem().toString();
        String untilH = untilHour.getSelectedItem().toString();
        String untilM = untilMinute.getSelectedItem().toString();
        String Uampm = untilAmpm.getSelectedItem().toString();
        String frMonth = fromMonth.getSelectedItem().toString();
        String fromD = fromDay.getSelectedItem().toString();
        String fromYr = (String) fromYear.getSelectedItem();
        String unMonth = untilMonth.getSelectedItem().toString();
        String untilD = untilDay.getSelectedItem().toString();
        String untilYr = (String) untilYear.getSelectedItem();
        String imgPath = imgBox.getSelectedItem().toString();
        
        Path path = Paths.get("");
        Path realPath;
        try {
            realPath = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
            stringPath = realPath.toString();
            stringPath = stringPath.replace("\\","\\\\");
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        File file2 = new File(stringPath + "\\AppToDate\\configuration.txt");
        String myConfig = file2.toString();
        
        String myPathData = "";
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
        System.out.println(myPathData);
            File file3 = new File(myPathData + "\\AppToDate");
            if(!file3.exists()){
                file3.mkdir();
            }
            
            File file4 = new File(myPathData + "\\AppToDate\\" + fromYr + "\\");
            if(!file4.exists()){
                file4.mkdir();
            }
            
              File file42 = new File(myPathData + "\\AppToDate\\" + fromYr + "\\" + frMonth);
            if(!file42.exists()){
                file42.mkdir();
            }
            
            File file43 = new File(myPathData + "\\AppToDate\\" + fromYr + "\\" + frMonth + "\\" + fromD);
            if(!file43.exists()){
                file43.mkdir();
            }
            if(wholeDayEvent.isSelected()){
                fromH = "12";
                fromM = "00";
                Fampm = "AM";
                untilH = "11";
                untilM = "59";
                Uampm = "PM";
            }
            
            File file5 = new File(myPathData + "\\AppToDate\\" + fromYr + "\\" + frMonth 
                    + "\\" + fromD + "\\" + frMonth + "-" + fromD + "-" + eventTitle + ".txt");
            if(!file5.exists()){
            try{
               Writer write = new BufferedWriter(new FileWriter(myPathData + "\\AppToDate\\" + fromYr + "\\" + frMonth + "\\" 
                       + fromD + "\\" + frMonth + "-" + fromD + "-" + eventTitle + ".txt", false));
               write.append(eventTitle + " + "); 
               write.append(desc + " + ");
               write.append(subj + " + ");
               write.append(fromH + ":");
               write.append(fromM);
               write.append(Fampm + " + ");
               write.append(frMonth + " ");
               write.append(fromD + ", ");
               write.append(fromYr + "+");
               write.append(untilH + ":");
               write.append(untilM);
               write.append(Uampm + " + ");
               write.append(unMonth + " ");
               write.append(untilD + ", ");
               write.append(untilYr + " + ");
               write.append("\\apptodate\\images\\" + imgPath);
               
               
               write.close();
               }catch(IOException e){
               }
        }
            File file6 = new File(myPathData + "\\AppToDate\\Events");
            if(!file6.exists()){
                file6.mkdir();
            }
            
            if(file6.exists()){
               try{
               Writer write = new BufferedWriter(new FileWriter(myPathData + "\\AppToDate\\Events\\" + eventTitle + "-" 
                       + unMonth + "-" + untilD + "-" + untilYr + ".txt", false));
               write.append(frMonth + " ");
               write.append(fromD + ", ");
               write.append(fromYr + "+");
               write.append(eventTitle + " + "); 
               write.append(unMonth + " ");
               write.append(untilD + ", ");
               write.append(untilYr + " + "); 
               write.append(untilH + ":");
               write.append(untilM);
               write.append(Uampm + " + ");
               write.close();
               }catch(IOException e){
               } 
            }
            close();
    }//GEN-LAST:event_okButtonActionPerformed

    private void subjectTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectTextActionPerformed

    private void imgBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imgBoxActionPerformed

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
    
    private void close(){
        this.dispose();
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
            java.util.logging.Logger.getLogger(ModifyAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextArea descArea;
    private javax.swing.JLabel descLabel;
    private javax.swing.JTextField eventArea;
    private javax.swing.JLabel eventLabel;
    private javax.swing.JComboBox fromAmpm;
    private javax.swing.JComboBox fromDay;
    private javax.swing.JComboBox fromHour;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JLabel fromLabel1;
    private javax.swing.JComboBox fromMinute;
    private javax.swing.JComboBox fromMonth;
    private javax.swing.JComboBox fromYear;
    private javax.swing.JLabel imagesLabel;
    private javax.swing.JComboBox imgBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel subectLabel;
    private javax.swing.JTextField subjectText;
    private javax.swing.JComboBox untilAmpm;
    private javax.swing.JComboBox untilDay;
    private javax.swing.JComboBox untilHour;
    private javax.swing.JLabel untilLabel;
    private javax.swing.JLabel untilLabel1;
    private javax.swing.JComboBox untilMinute;
    private javax.swing.JComboBox untilMonth;
    private javax.swing.JComboBox untilYear;
    private javax.swing.JRadioButton wholeDayEvent;
    // End of variables declaration//GEN-END:variables
}
