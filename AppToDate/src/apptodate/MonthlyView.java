/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptodate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javazoom.jl.player.Player;

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
public class MonthlyView extends javax.swing.JFrame {

    

  

    /**
     * Creates new form MonthlyView
     */
    public int year;
    private String[][] d = new String[13][8];
    private String thePathOfFile = "";
    private String whatDayNow;
    private int lock;
    private int i;
    private int monthNum;
    private String stringPath;
    private String time;
    private String today;
    private String musicPath;
    private String data[][] = new String[99][99];
   

    
 

    public MonthlyView() {
        initComponents();
        new Thread(){
            public void run(){
                while(true){
                    Calendar cal = new GregorianCalendar();
                    int month = cal.get(Calendar.MONTH);
                    int day = cal.get(Calendar.DAY_OF_MONTH);
                    int yearClock = cal.get(Calendar.YEAR);
                    int hour = cal.get(Calendar.HOUR);
                    int min = cal.get(Calendar.MINUTE);
                    int sec = cal.get(Calendar.SECOND);
                    int AM_PM = cal.get(Calendar.AM_PM);
                    int numOfFiles = 0;
                    
                    String monthString = "";
                    if(month == 0){
                       monthString = "JAN"; 
                    }
                    if(month == 1){
                       monthString = "FEB"; 
                    }
                    if(month == 2){
                       monthString = "MAR"; 
                    }
                    if(month == 3){
                       monthString = "APR"; 
                    }
                    if(month == 4){
                       monthString = "MAY"; 
                    }
                    if(month == 5){
                       monthString = "JUN"; 
                    }
                    if(month == 6){
                       monthString = "JUL"; 
                    }
                    if(month == 7){
                       monthString = "AUG"; 
                    }
                    if(month == 8){
                       monthString = "SEP"; 
                    }
                    if(month == 9){
                       monthString = "OCT"; 
                    }
                    if(month == 10){
                       monthString = "NOV"; 
                    }
                    if(month == 11){
                       monthString = "DEC"; 
                    }
                    
                    File file = new File(getPath().replace("\\\\","\\") + "\\AppToDate\\" + yearClock + "\\" + monthString + "\\" + day) ;
                    File[] listOfFiles;
                    if(file.exists()){
              
                        if(getNumOfFiles() > 0){
                           listOfFiles = file.listFiles(); 
                            for (int j = 0; j < listOfFiles.length; j++) {
                            if (listOfFiles[j].isFile()) {
                                
                                File file2 = new File(getPath().replace("\\\\","\\") + "\\AppToDate\\" + yearClock + "\\" + monthString + "\\" + day
                                + "\\" + listOfFiles[j].getName());
                                BufferedReader br = null;
                                try{
                                    String currentData;
                                    br = new BufferedReader(new FileReader(file2));
                                    while((currentData = br.readLine()) != null){
                                        String[] parts = currentData.split("\\+");
                                        data[j][0] = parts[0];
                                        data[j][1] = parts[1];
                                        data[j][2] = parts[2];
                                        data[j][3] = parts[3];
                                        data[j][4] = parts[4];
                                        data[j][5] = parts[5];//DEADLINE TIME
                                        data[j][6] = parts[6];//DEADLINE DATE
                                        numOfFiles = j;
                                        //System.out.println(data[i][5]);
                                        //System.out.println(data[i][6]);
                                        
                                    }
                                }catch(IOException e){
                                    
                                }
                                
                                }
                            
                    
               
                            
                            
                     }                                            
                           
                        }
                    }    
                    
                    
                    
                    String day_night = "";
                    
                    if(AM_PM == 1){
                        day_night = "PM";
                    }else{
                        day_night = "AM";
                    }
                    
                    if(hour == 0){
                       hour = 12;   
                    }
                    
                    today = monthString + " " + day + ", " + year;
                    time = hour + ":" + min + ":" + sec + day_night;
                    
                   
                    //System.out.println(today + " against " + data[0][6]);
                   System.out.println(time);
                    
                  
                    
                    
                    for(int i = 0; i < numOfFiles; i++){
                    String compare = "";  
                        if(data[i][5] != null){
                    compare = data[i][5].replace(" ",":0").replace("M:0", "M");
                    } 
                     compare = compare.replace(" ", "");
                     time = time.replace(" ", "");
                     /*
                     String parts[] = compare.split(":");
                     int changeValue = Integer.parseInt(parts[0]);
                     int numberToChange = changeValue - notifyMe;
                     if(numberToChange <= 0){
                         numberToChange = numberToChange + 12;
                         
                     }
                     
                        compare = numberToChange + ":" + parts[1] + ":" + parts[2];
                     */
                     compare = compare.replace(" ", "");
                     time = time.replace(" ", "");
                     System.out.println(compare);
                     //System.out.println(time);
                    if(time.equals(compare)){
                        
                    try{
                     JOptionPane.showMessageDialog(null, "An Event is now in session");
                      FileInputStream fis = new FileInputStream(musicPath);
                      Player playMP3 = new Player(fis);
                      playMP3.play();
                         
                      
                    }catch(Exception e){
                    System.out.println(e);
                    }
                    
                        }
                            }
               
    }//Infinite loop while
            }
        
                }.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePanel = new javax.swing.JPanel();
        yearButton = new javax.swing.JButton();
        monthButton = new javax.swing.JButton();
        dayButton = new javax.swing.JButton();
        settings = new javax.swing.JButton();
        modifyAdd = new javax.swing.JButton();
        yearLabel = new javax.swing.JLabel();
        yearRightArrow = new javax.swing.JButton();
        leftYearArrow = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        dayLabel1 = new javax.swing.JLabel();
        dayLabel2 = new javax.swing.JLabel();
        dayLabel3 = new javax.swing.JLabel();
        dayLabel4 = new javax.swing.JLabel();
        dayLabel5 = new javax.swing.JLabel();
        dayLabel6 = new javax.swing.JLabel();
        dayLabel7 = new javax.swing.JLabel();
        dayButton1 = new javax.swing.JButton();
        dayButton2 = new javax.swing.JButton();
        dayButton3 = new javax.swing.JButton();
        dayButton4 = new javax.swing.JButton();
        dayButton5 = new javax.swing.JButton();
        dayButton6 = new javax.swing.JButton();
        dayButton7 = new javax.swing.JButton();
        dayButton8 = new javax.swing.JButton();
        dayButton9 = new javax.swing.JButton();
        dayButton10 = new javax.swing.JButton();
        dayButton11 = new javax.swing.JButton();
        dayButton12 = new javax.swing.JButton();
        dayButton13 = new javax.swing.JButton();
        dayButton14 = new javax.swing.JButton();
        dayButton15 = new javax.swing.JButton();
        dayButton16 = new javax.swing.JButton();
        dayButton17 = new javax.swing.JButton();
        dayButton18 = new javax.swing.JButton();
        dayButton19 = new javax.swing.JButton();
        dayButton20 = new javax.swing.JButton();
        dayButton21 = new javax.swing.JButton();
        dayButton22 = new javax.swing.JButton();
        dayButton23 = new javax.swing.JButton();
        dayButton24 = new javax.swing.JButton();
        dayButton25 = new javax.swing.JButton();
        dayButton26 = new javax.swing.JButton();
        dayButton27 = new javax.swing.JButton();
        dayButton28 = new javax.swing.JButton();
        dayButton29 = new javax.swing.JButton();
        dayButton30 = new javax.swing.JButton();
        dayButton31 = new javax.swing.JButton();
        dayButton32 = new javax.swing.JButton();
        dayButton33 = new javax.swing.JButton();
        dayButton34 = new javax.swing.JButton();
        dayButton35 = new javax.swing.JButton();
        dayButton36 = new javax.swing.JButton();
        dayButton37 = new javax.swing.JButton();
        dayButton38 = new javax.swing.JButton();
        dayButton39 = new javax.swing.JButton();
        dayButton40 = new javax.swing.JButton();
        dayButton41 = new javax.swing.JButton();
        dayButton42 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        monthLeftArrow = new javax.swing.JButton();
        monthRightArrow = new javax.swing.JButton();
        janButton = new javax.swing.JButton();
        febButton = new javax.swing.JButton();
        marButton = new javax.swing.JButton();
        aprButton = new javax.swing.JButton();
        mayButton = new javax.swing.JButton();
        junButton = new javax.swing.JButton();
        julButton = new javax.swing.JButton();
        augButton = new javax.swing.JButton();
        sepButton = new javax.swing.JButton();
        octButton = new javax.swing.JButton();
        novButton = new javax.swing.JButton();
        decButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        eventLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea1 = new javax.swing.JTextArea();
        eventLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea3 = new javax.swing.JTextArea();
        eventLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textArea2 = new javax.swing.JTextArea();
        eventButton1 = new javax.swing.JButton();
        eventButton2 = new javax.swing.JButton();
        eventButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        titlePanel.setBackground(new java.awt.Color(34, 34, 34));
        titlePanel.setForeground(new java.awt.Color(240, 240, 240));
        titlePanel.setFont(new java.awt.Font("Aldhabi", 0, 18)); // NOI18N

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

        monthButton.setBackground(new java.awt.Color(29, 114, 239));
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

        dayButton.setBackground(new java.awt.Color(34, 34, 34));
        dayButton.setContentAreaFilled(false);
        dayButton.setOpaque(true);
        dayButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        dayButton.setForeground(new java.awt.Color(240, 240, 240));
        dayButton.setText("DAY");
        dayButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButtonActionPerformed(evt);
            }
        });

        settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptodate/images/wrench.png"))); // NOI18N
        settings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsActionPerformed(evt);
            }
        });

        modifyAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptodate/images/add.png")));
        modifyAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modifyAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyAddActionPerformed(evt);
            }
        });

        yearLabel.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        yearLabel.setForeground(new java.awt.Color(240, 240, 240));
        yearLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        yearRightArrow.setBackground(new java.awt.Color(34, 34, 34));
        yearRightArrow.setForeground(new java.awt.Color(34, 34, 34));
        yearRightArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptodate/images/right_arrow.png"))); // NOI18N
        yearRightArrow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        yearRightArrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearRightArrowActionPerformed(evt);
            }
        });

        leftYearArrow.setBackground(new java.awt.Color(34, 34, 34));
        leftYearArrow.setForeground(new java.awt.Color(34, 34, 34));
        leftYearArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptodate/images/left_arrow.png"))); // NOI18N
        leftYearArrow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        leftYearArrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftYearArrowActionPerformed(evt);
            }
        });

        refreshButton.setBackground(new java.awt.Color(34, 34, 34));
        refreshButton.setContentAreaFilled(false);
        refreshButton.setOpaque(true);
        refreshButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        refreshButton.setForeground(new java.awt.Color(240, 240, 240));
        refreshButton.setText("Refresh");
        refreshButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addComponent(yearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(monthButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(dayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(leftYearArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(yearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(yearRightArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(refreshButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modifyAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftYearArrow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(yearLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(yearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(monthButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dayButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(settings, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearRightArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
            .addComponent(refreshButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        if(checkPink() == 1){
            yearButton.setBackground(new java.awt.Color(255,9 , 88));
        }else{
            yearButton.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton.setBackground(new java.awt.Color(255,9 , 88));
        }else{
            dayButton.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptodate/images/pinkWrench.png"))); // NOI18N
        }
        if(checkPink() == 1){
            modifyAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptodate/images/pinkAdd.png"))); // NOI18N
        }
        yearLabel.setText(String.valueOf(getYear()));
        if(checkPink() == 1){
            refreshButton.setBackground(new java.awt.Color(255,9 , 88));
        }else{
            refreshButton.setBackground(new java.awt.Color(34, 34, 34));
        }

        jPanel1.setBackground(new java.awt.Color(51, 61, 68));
        jPanel1.setForeground(new java.awt.Color(240, 240, 240));

        dayLabel1.setBackground(new java.awt.Color(34, 34, 34));
        dayLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dayLabel1.setForeground(new java.awt.Color(240, 240, 240));
        dayLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dayLabel1.setText("Sunday");
        dayLabel1.setOpaque(true);

        dayLabel2.setBackground(new java.awt.Color(34, 34, 34));
        dayLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dayLabel2.setForeground(new java.awt.Color(240, 240, 240));
        dayLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dayLabel2.setText("Monday");
        dayLabel2.setOpaque(true);

        dayLabel3.setBackground(new java.awt.Color(34, 34, 34));
        dayLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dayLabel3.setForeground(new java.awt.Color(240, 240, 240));
        dayLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dayLabel3.setText("Tuesday");
        dayLabel3.setOpaque(true);

        dayLabel4.setBackground(new java.awt.Color(34, 34, 34));
        dayLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dayLabel4.setForeground(new java.awt.Color(240, 240, 240));
        dayLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dayLabel4.setText("Wednesday");
        dayLabel4.setOpaque(true);

        dayLabel5.setBackground(new java.awt.Color(34, 34, 34));
        dayLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dayLabel5.setForeground(new java.awt.Color(240, 240, 240));
        dayLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dayLabel5.setText("Thursday");
        dayLabel5.setOpaque(true);

        dayLabel6.setBackground(new java.awt.Color(34, 34, 34));
        dayLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dayLabel6.setForeground(new java.awt.Color(240, 240, 240));
        dayLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dayLabel6.setText("Friday");
        dayLabel6.setOpaque(true);

        dayLabel7.setBackground(new java.awt.Color(34, 34, 34));
        dayLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dayLabel7.setForeground(new java.awt.Color(240, 240, 240));
        dayLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dayLabel7.setText("Saturday");
        dayLabel7.setOpaque(true);

        dayButton1.setBackground(new java.awt.Color(34, 34, 34));
        dayButton1.setContentAreaFilled(false);
        dayButton1.setOpaque(true);
        dayButton1.setForeground(new java.awt.Color(240, 240, 240));
        dayButton1.setText(String.valueOf(getDefaultMonth(0)));
        dayButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton1.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton1ActionPerformed(evt);
            }
        });

        dayButton2.setBackground(new java.awt.Color(34, 34, 34));
        dayButton2.setContentAreaFilled(false);
        dayButton2.setOpaque(true);
        dayButton2.setForeground(new java.awt.Color(240, 240, 240));
        dayButton2.setText(String.valueOf(getDefaultMonth(1)));
        dayButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton2.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton2ActionPerformed(evt);
            }
        });

        dayButton3.setBackground(new java.awt.Color(34, 34, 34));
        dayButton3.setContentAreaFilled(false);
        dayButton3.setOpaque(true);
        dayButton3.setForeground(new java.awt.Color(240, 240, 240));
        dayButton3.setText(String.valueOf(getDefaultMonth(2)));
        dayButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton3.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton3ActionPerformed(evt);
            }
        });

        dayButton4.setBackground(new java.awt.Color(34, 34, 34));
        dayButton4.setContentAreaFilled(false);
        dayButton4.setOpaque(true);
        dayButton4.setForeground(new java.awt.Color(240, 240, 240));
        dayButton4.setText(String.valueOf(getDefaultMonth(3)));
        dayButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton4.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton4ActionPerformed(evt);
            }
        });

        dayButton5.setBackground(new java.awt.Color(34, 34, 34));
        dayButton5.setContentAreaFilled(false);
        dayButton5.setOpaque(true);
        dayButton5.setForeground(new java.awt.Color(240, 240, 240));
        dayButton5.setText(String.valueOf(getDefaultMonth(4)));
        dayButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton5.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton5ActionPerformed(evt);
            }
        });

        dayButton6.setBackground(new java.awt.Color(34, 34, 34));
        dayButton6.setContentAreaFilled(false);
        dayButton6.setOpaque(true);
        dayButton6.setForeground(new java.awt.Color(240, 240, 240));
        dayButton6.setText(String.valueOf(getDefaultMonth(5)));
        dayButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton6.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton6.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton6ActionPerformed(evt);
            }
        });

        dayButton7.setBackground(new java.awt.Color(34, 34, 34));
        dayButton7.setContentAreaFilled(false);
        dayButton7.setOpaque(true);
        dayButton7.setForeground(new java.awt.Color(240, 240, 240));
        dayButton7.setText(String.valueOf(getDefaultMonth(6)));
        dayButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton7.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton7.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton7ActionPerformed(evt);
            }
        });

        dayButton8.setBackground(new java.awt.Color(34, 34, 34));
        dayButton8.setContentAreaFilled(false);
        dayButton8.setOpaque(true);
        dayButton8.setForeground(new java.awt.Color(240, 240, 240));
        dayButton8.setText(String.valueOf(getDefaultMonth(7)));
        dayButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton8.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton8.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton8ActionPerformed(evt);
            }
        });

        dayButton9.setBackground(new java.awt.Color(34, 34, 34));
        dayButton9.setContentAreaFilled(false);
        dayButton9.setOpaque(true);
        dayButton9.setForeground(new java.awt.Color(240, 240, 240));
        dayButton9.setText(String.valueOf(getDefaultMonth(8)));
        dayButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton9.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton9.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton9ActionPerformed(evt);
            }
        });

        dayButton10.setBackground(new java.awt.Color(34, 34, 34));
        dayButton10.setContentAreaFilled(false);
        dayButton10.setOpaque(true);
        dayButton10.setForeground(new java.awt.Color(240, 240, 240));
        dayButton10.setText(String.valueOf(getDefaultMonth(9)));
        dayButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton10.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton10.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton10.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton10ActionPerformed(evt);
            }
        });

        dayButton11.setBackground(new java.awt.Color(34, 34, 34));
        dayButton11.setContentAreaFilled(false);
        dayButton11.setOpaque(true);
        dayButton11.setForeground(new java.awt.Color(240, 240, 240));
        dayButton11.setText(String.valueOf(getDefaultMonth(10)));
        dayButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton11.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton11.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton11.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton11.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton11ActionPerformed(evt);
            }
        });

        dayButton12.setBackground(new java.awt.Color(34, 34, 34));
        dayButton12.setContentAreaFilled(false);
        dayButton12.setOpaque(true);
        dayButton12.setForeground(new java.awt.Color(240, 240, 240));
        dayButton12.setText(String.valueOf(getDefaultMonth(11)));
        dayButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton12.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton12.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton12.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton12.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton12ActionPerformed(evt);
            }
        });

        dayButton13.setBackground(new java.awt.Color(34, 34, 34));
        dayButton13.setContentAreaFilled(false);
        dayButton13.setOpaque(true);
        dayButton13.setForeground(new java.awt.Color(240, 240, 240));
        dayButton13.setText(String.valueOf(getDefaultMonth(12)));
        dayButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton13.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton13.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton13.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton13.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton13ActionPerformed(evt);
            }
        });

        dayButton14.setBackground(new java.awt.Color(34, 34, 34));
        dayButton14.setContentAreaFilled(false);
        dayButton14.setOpaque(true);
        dayButton14.setForeground(new java.awt.Color(240, 240, 240));
        dayButton14.setText(String.valueOf(getDefaultMonth(13)));
        dayButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton14.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton14.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton14.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton14.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton14ActionPerformed(evt);
            }
        });

        dayButton15.setBackground(new java.awt.Color(34, 34, 34));
        dayButton15.setContentAreaFilled(false);
        dayButton15.setOpaque(true);
        dayButton15.setForeground(new java.awt.Color(240, 240, 240));
        dayButton15.setText(String.valueOf(getDefaultMonth(14)));
        dayButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton15.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton15.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton15.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton15.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton15ActionPerformed(evt);
            }
        });

        dayButton16.setBackground(new java.awt.Color(34, 34, 34));
        dayButton16.setContentAreaFilled(false);
        dayButton16.setOpaque(true);
        dayButton16.setForeground(new java.awt.Color(240, 240, 240));
        dayButton16.setText(String.valueOf(getDefaultMonth(15)));
        dayButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton16.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton16.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton16.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton16.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton16ActionPerformed(evt);
            }
        });

        dayButton17.setBackground(new java.awt.Color(34, 34, 34));
        dayButton17.setContentAreaFilled(false);
        dayButton17.setOpaque(true);
        dayButton17.setForeground(new java.awt.Color(240, 240, 240));
        dayButton17.setText(String.valueOf(getDefaultMonth(16)));
        dayButton17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton17.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton17.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton17.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton17.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton17ActionPerformed(evt);
            }
        });

        dayButton18.setBackground(new java.awt.Color(34, 34, 34));
        dayButton18.setContentAreaFilled(false);
        dayButton18.setOpaque(true);
        dayButton18.setForeground(new java.awt.Color(240, 240, 240));
        dayButton18.setText(String.valueOf(getDefaultMonth(17)));
        dayButton18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton18.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton18.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton18.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton18.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton18ActionPerformed(evt);
            }
        });

        dayButton19.setBackground(new java.awt.Color(34, 34, 34));
        dayButton19.setContentAreaFilled(false);
        dayButton19.setOpaque(true);
        dayButton19.setForeground(new java.awt.Color(240, 240, 240));
        dayButton19.setText(String.valueOf(getDefaultMonth(18)));
        dayButton19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton19.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton19.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton19.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton19.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton19ActionPerformed(evt);
            }
        });

        dayButton20.setBackground(new java.awt.Color(34, 34, 34));
        dayButton20.setContentAreaFilled(false);
        dayButton20.setOpaque(true);
        dayButton20.setForeground(new java.awt.Color(240, 240, 240));
        dayButton20.setText(String.valueOf(getDefaultMonth(19)));
        dayButton20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton20.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton20.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton20.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton20.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton20ActionPerformed(evt);
            }
        });

        dayButton21.setBackground(new java.awt.Color(34, 34, 34));
        dayButton21.setContentAreaFilled(false);
        dayButton21.setOpaque(true);
        dayButton21.setForeground(new java.awt.Color(240, 240, 240));
        dayButton21.setText(String.valueOf(getDefaultMonth(20)));
        dayButton21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton21.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton21.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton21.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton21.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton21ActionPerformed(evt);
            }
        });

        dayButton22.setBackground(new java.awt.Color(34, 34, 34));
        dayButton22.setContentAreaFilled(false);
        dayButton22.setOpaque(true);
        dayButton22.setForeground(new java.awt.Color(240, 240, 240));
        dayButton22.setText(String.valueOf(getDefaultMonth(21)));
        dayButton22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton22.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton22.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton22.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton22.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton22ActionPerformed(evt);
            }
        });

        dayButton23.setBackground(new java.awt.Color(34, 34, 34));
        dayButton23.setContentAreaFilled(false);
        dayButton23.setOpaque(true);
        dayButton23.setForeground(new java.awt.Color(240, 240, 240));
        dayButton23.setText(String.valueOf(getDefaultMonth(22)));
        dayButton23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton23.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton23.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton23.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton23.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton23ActionPerformed(evt);
            }
        });

        dayButton24.setBackground(new java.awt.Color(34, 34, 34));
        dayButton24.setContentAreaFilled(false);
        dayButton24.setOpaque(true);
        dayButton24.setForeground(new java.awt.Color(240, 240, 240));
        dayButton24.setText(String.valueOf(getDefaultMonth(23)));
        dayButton24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton24.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton24.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton24.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton24.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton24ActionPerformed(evt);
            }
        });

        dayButton25.setBackground(new java.awt.Color(34, 34, 34));
        dayButton25.setContentAreaFilled(false);
        dayButton25.setOpaque(true);
        dayButton25.setForeground(new java.awt.Color(240, 240, 240));
        dayButton25.setText(String.valueOf(getDefaultMonth(24)));
        dayButton25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton25.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton25.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton25.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton25.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton25ActionPerformed(evt);
            }
        });

        dayButton26.setBackground(new java.awt.Color(34, 34, 34));
        dayButton26.setContentAreaFilled(false);
        dayButton26.setOpaque(true);
        dayButton26.setForeground(new java.awt.Color(240, 240, 240));
        dayButton26.setText(String.valueOf(getDefaultMonth(25)));
        dayButton26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton26.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton26.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton26.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton26.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton26ActionPerformed(evt);
            }
        });

        dayButton27.setBackground(new java.awt.Color(34, 34, 34));
        dayButton27.setContentAreaFilled(false);
        dayButton27.setOpaque(true);
        dayButton27.setForeground(new java.awt.Color(240, 240, 240));
        dayButton27.setText(String.valueOf(getDefaultMonth(26)));
        dayButton27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton27.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton27.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton27.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton27.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton27ActionPerformed(evt);
            }
        });

        dayButton28.setBackground(new java.awt.Color(34, 34, 34));
        dayButton28.setContentAreaFilled(false);
        dayButton28.setOpaque(true);
        dayButton28.setForeground(new java.awt.Color(240, 240, 240));
        dayButton28.setText(String.valueOf(getDefaultMonth(27)));
        dayButton28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton28.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton28.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton28.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton28.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton28ActionPerformed(evt);
            }
        });

        dayButton29.setBackground(new java.awt.Color(34, 34, 34));
        dayButton29.setContentAreaFilled(false);
        dayButton29.setOpaque(true);
        dayButton29.setForeground(new java.awt.Color(240, 240, 240));
        dayButton29.setText(String.valueOf(getDefaultMonth(28)));
        dayButton29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton29.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton29.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton29.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton29.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton29ActionPerformed(evt);
            }
        });

        dayButton30.setBackground(new java.awt.Color(34, 34, 34));
        dayButton30.setContentAreaFilled(false);
        dayButton30.setOpaque(true);
        dayButton30.setForeground(new java.awt.Color(240, 240, 240));
        dayButton30.setText(String.valueOf(getDefaultMonth(29)));
        dayButton30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton30.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton30.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton30.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton30.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton30ActionPerformed(evt);
            }
        });

        dayButton31.setBackground(new java.awt.Color(34, 34, 34));
        dayButton31.setContentAreaFilled(false);
        dayButton31.setOpaque(true);
        dayButton31.setForeground(new java.awt.Color(240, 240, 240));
        dayButton31.setText(String.valueOf(getDefaultMonth(30)));
        dayButton31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton31.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton31.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton31.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton31.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton31ActionPerformed(evt);
            }
        });

        dayButton32.setBackground(new java.awt.Color(34, 34, 34));
        dayButton32.setContentAreaFilled(false);
        dayButton32.setOpaque(true);
        dayButton32.setForeground(new java.awt.Color(240, 240, 240));
        dayButton32.setText(String.valueOf(getDefaultMonth(31)));
        dayButton32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton32.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton32.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton32.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton32.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton32ActionPerformed(evt);
            }
        });

        dayButton33.setBackground(new java.awt.Color(34, 34, 34));
        dayButton33.setContentAreaFilled(false);
        dayButton33.setOpaque(true);
        dayButton33.setForeground(new java.awt.Color(240, 240, 240));
        dayButton33.setText(String.valueOf(getDefaultMonth(32)));
        dayButton33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton33.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton33.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton33.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton33.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton33ActionPerformed(evt);
            }
        });

        dayButton34.setBackground(new java.awt.Color(34, 34, 34));
        dayButton34.setContentAreaFilled(false);
        dayButton34.setOpaque(true);
        dayButton34.setForeground(new java.awt.Color(240, 240, 240));
        dayButton34.setText(String.valueOf(getDefaultMonth(33)));
        dayButton34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton34.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton34.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton34.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton34.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton34ActionPerformed(evt);
            }
        });

        dayButton35.setBackground(new java.awt.Color(34, 34, 34));
        dayButton35.setContentAreaFilled(false);
        dayButton35.setOpaque(true);
        dayButton35.setForeground(new java.awt.Color(240, 240, 240));
        dayButton35.setText(String.valueOf(getDefaultMonth(34)));
        dayButton35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton35.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton35.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton35.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton35.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton35ActionPerformed(evt);
            }
        });

        dayButton36.setBackground(new java.awt.Color(34, 34, 34));
        dayButton36.setContentAreaFilled(false);
        dayButton36.setOpaque(true);
        dayButton36.setForeground(new java.awt.Color(240, 240, 240));
        dayButton36.setText(String.valueOf(getDefaultMonth(35)));
        dayButton36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton36.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton36.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton36.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton36.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton36ActionPerformed(evt);
            }
        });

        dayButton37.setBackground(new java.awt.Color(34, 34, 34));
        dayButton37.setContentAreaFilled(false);
        dayButton37.setOpaque(true);
        dayButton37.setForeground(new java.awt.Color(240, 240, 240));
        dayButton37.setText(String.valueOf(getDefaultMonth(36)));
        dayButton37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton37.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton37.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton37.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton37.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton37ActionPerformed(evt);
            }
        });

        dayButton38.setBackground(new java.awt.Color(34, 34, 34));
        dayButton38.setContentAreaFilled(false);
        dayButton38.setOpaque(true);
        dayButton38.setForeground(new java.awt.Color(240, 240, 240));
        dayButton38.setText(String.valueOf(getDefaultMonth(37)));
        dayButton38.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton38.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton38.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton38.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton38.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton38.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton38ActionPerformed(evt);
            }
        });

        dayButton39.setBackground(new java.awt.Color(34, 34, 34));
        dayButton39.setContentAreaFilled(false);
        dayButton39.setOpaque(true);
        dayButton39.setForeground(new java.awt.Color(240, 240, 240));
        dayButton39.setText(String.valueOf(getDefaultMonth(39)));
        dayButton39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton39.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton39.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton39.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton39.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton39ActionPerformed(evt);
            }
        });

        dayButton40.setBackground(new java.awt.Color(34, 34, 34));
        dayButton40.setContentAreaFilled(false);
        dayButton40.setOpaque(true);
        dayButton40.setForeground(new java.awt.Color(240, 240, 240));
        dayButton40.setText(String.valueOf(getDefaultMonth(40)));
        dayButton40.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton40.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton40.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton40.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton40.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton40ActionPerformed(evt);
            }
        });

        dayButton41.setBackground(new java.awt.Color(34, 34, 34));
        dayButton41.setContentAreaFilled(false);
        dayButton41.setOpaque(true);
        dayButton41.setForeground(new java.awt.Color(240, 240, 240));
        dayButton41.setText(String.valueOf(getDefaultMonth(40)));
        dayButton41.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton41.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton41.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton41.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton41.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton41.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton41ActionPerformed(evt);
            }
        });

        dayButton42.setBackground(new java.awt.Color(34, 34, 34));
        dayButton42.setContentAreaFilled(false);
        dayButton42.setOpaque(true);
        dayButton42.setForeground(new java.awt.Color(240, 240, 240));
        dayButton42.setText(String.valueOf(getDefaultMonth(41)));
        dayButton42.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dayButton42.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dayButton42.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        dayButton42.setMargin(new java.awt.Insets(3, 0, 0, 5));
        dayButton42.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dayButton42.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        dayButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButton42ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dayButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dayLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dayButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dayLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dayButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dayLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dayButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dayLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dayButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dayButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dayButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dayLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dayButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dayLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dayButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dayButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dayButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dayButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dayButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dayButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dayButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dayButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dayButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(dayButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dayButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dayButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dayButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        if(checkPink() == 1){
            dayLabel1.setBackground(new java.awt.Color(255,9 , 88));
        }else{
            yearButton.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayLabel2.setBackground(new java.awt.Color(255,9 , 88));
        }else{
            dayLabel2.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayLabel3.setBackground(new java.awt.Color(255,9 , 88));
        }else{
            dayLabel3.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayLabel4.setBackground(new java.awt.Color(255,9 , 88));
        }else{
            dayLabel4.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayLabel5.setBackground(new java.awt.Color(255,9 , 88));
        }else{
            dayLabel5.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayLabel6.setBackground(new java.awt.Color(255,9 , 88));
        }else{
            dayLabel6.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayLabel7.setBackground(new java.awt.Color(255,9 , 88));
        }else{
            dayLabel7.setBackground(new java.awt.Color(34, 34, 34));
        }

        if(0 == getStartingWeek()){
        }else if(1 == getStartingWeek()){
            dayLabel1.setText("Monday");
            dayLabel2.setText("Tuesday");
            dayLabel3.setText("Wednesday");
            dayLabel4.setText("Thursday");
            dayLabel5.setText("Friday");
            dayLabel6.setText("Saturday");
            dayLabel7.setText("Sunday");
        }else if(2 == getStartingWeek()){
            dayLabel1.setText("Tuesday");
            dayLabel2.setText("Wednesday");
            dayLabel3.setText("Thursday");
            dayLabel4.setText("Friday");
            dayLabel5.setText("Saturday");
            dayLabel6.setText("Sunday");
            dayLabel7.setText("Monday");
        }else if(3 == getStartingWeek()){
            dayLabel1.setText("Wednesday");
            dayLabel2.setText("Thursday");
            dayLabel3.setText("Friday");
            dayLabel4.setText("Saturday");
            dayLabel5.setText("Sunday");
            dayLabel6.setText("Monday");
            dayLabel7.setText("Tuesday");
        }else if(4 == getStartingWeek()){
            dayLabel1.setText("Thursday");
            dayLabel2.setText("Friday");
            dayLabel3.setText("Saturday");
            dayLabel4.setText("Sunday");
            dayLabel5.setText("Monday");
            dayLabel6.setText("Tuesday");
            dayLabel7.setText("Wednesday");
        }else if(5 == getStartingWeek()){
            dayLabel1.setText("Friday");
            dayLabel2.setText("Saturday");
            dayLabel3.setText("Sunday");
            dayLabel4.setText("Monday");
            dayLabel5.setText("Tuesday");
            dayLabel6.setText("Wednesday");
            dayLabel7.setText("Thursday");
        }else if(6 == getStartingWeek()){
            dayLabel1.setText("Saturday");
            dayLabel2.setText("Sunday");
            dayLabel3.setText("Monday");
            dayLabel4.setText("Tuesday");
            dayLabel5.setText("Wednesday");
            dayLabel6.setText("Thursday");
            dayLabel7.setText("Friday");
        }
        if(checkPink() == 1){
            dayButton1.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton1.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton2.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton2.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton3.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton3.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton4.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton4.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton5.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton5.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton6.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton6.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton7.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton7.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton8.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton8.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton9.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton9.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton10.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton10.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton11.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton11.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton12.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton12.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton13.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton13.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton14.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton14.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton15.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton15.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton16.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton16.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton17.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton17.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton18.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton18.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton19.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton19.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton20.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton20.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton21.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton21.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton22.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton22.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton23.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton23.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton24.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton24.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton25.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton25.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton26.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton26.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton27.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton27.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton28.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton28.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton29.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton29.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton30.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton30.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton31.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton31.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton32.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton32.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton33.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton33.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton34.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton34.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton35.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton35.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton36.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton36.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton37.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton37.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton38.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton38.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton39.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton39.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton40.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton40.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton41.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton41.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            dayButton42.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            dayButton42.setBackground(new java.awt.Color(34, 34, 34));
        }

        jPanel3.setBackground(new java.awt.Color(51, 61, 68));
        jPanel3.setForeground(new java.awt.Color(240, 240, 240));

        monthLeftArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptodate/images/left_arrow.png"))); // NOI18N
        monthLeftArrow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        monthLeftArrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthLeftArrowActionPerformed(evt);
            }
        });

        monthRightArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptodate/images/right_arrow.png"))); // NOI18N
        monthRightArrow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        monthRightArrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthRightArrowActionPerformed(evt);
            }
        });

        janButton.setBackground(new java.awt.Color(34, 34, 34));
        janButton.setContentAreaFilled(false);
        janButton.setOpaque(true);
        janButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        janButton.setForeground(new java.awt.Color(240, 240, 240));
        janButton.setText("JAN");
        janButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        janButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        janButton.setMargin(new java.awt.Insets(1, 1, 1, 1));
        janButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                janButtonActionPerformed(evt);
            }
        });

        febButton.setBackground(new java.awt.Color(34, 34, 34));
        febButton.setContentAreaFilled(false);
        febButton.setOpaque(true);
        febButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        febButton.setForeground(new java.awt.Color(240, 240, 240));
        febButton.setText("FEB");
        febButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        febButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        febButton.setMargin(new java.awt.Insets(1, 1, 1, 1));
        febButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                febButtonActionPerformed(evt);
            }
        });

        marButton.setBackground(new java.awt.Color(34, 34, 34));
        marButton.setContentAreaFilled(false);
        marButton.setOpaque(true);
        marButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        marButton.setForeground(new java.awt.Color(240, 240, 240));
        marButton.setText("MAR");
        marButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        marButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        marButton.setMargin(new java.awt.Insets(1, 1, 1, 1));
        marButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marButtonActionPerformed(evt);
            }
        });

        aprButton.setBackground(new java.awt.Color(34, 34, 34));
        aprButton.setContentAreaFilled(false);
        aprButton.setOpaque(true);
        aprButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        aprButton.setForeground(new java.awt.Color(240, 240, 240));
        aprButton.setText("APR");
        aprButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aprButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        aprButton.setMargin(new java.awt.Insets(1, 1, 1, 1));
        aprButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aprButtonActionPerformed(evt);
            }
        });

        mayButton.setBackground(new java.awt.Color(34, 34, 34));
        mayButton.setContentAreaFilled(false);
        mayButton.setOpaque(true);
        mayButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mayButton.setForeground(new java.awt.Color(240, 240, 240));
        mayButton.setText("MAY");
        mayButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mayButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mayButton.setMargin(new java.awt.Insets(1, 1, 1, 1));
        mayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mayButtonActionPerformed(evt);
            }
        });

        junButton.setBackground(new java.awt.Color(34, 34, 34));
        junButton.setContentAreaFilled(false);
        junButton.setOpaque(true);
        junButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        junButton.setForeground(new java.awt.Color(240, 240, 240));
        junButton.setText("JUN");
        junButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        junButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        junButton.setMargin(new java.awt.Insets(1, 1, 1, 1));
        junButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                junButtonActionPerformed(evt);
            }
        });

        julButton.setBackground(new java.awt.Color(34, 34, 34));
        julButton.setContentAreaFilled(false);
        julButton.setOpaque(true);
        julButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        julButton.setForeground(new java.awt.Color(240, 240, 240));
        julButton.setText("JUL");
        julButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        julButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        julButton.setMargin(new java.awt.Insets(1, 1, 1, 1));
        julButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                julButtonActionPerformed(evt);
            }
        });

        augButton.setBackground(new java.awt.Color(34, 34, 34));
        augButton.setContentAreaFilled(false);
        augButton.setOpaque(true);
        augButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        augButton.setForeground(new java.awt.Color(240, 240, 240));
        augButton.setText("AUG");
        augButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        augButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        augButton.setMargin(new java.awt.Insets(1, 1, 1, 1));
        augButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                augButtonActionPerformed(evt);
            }
        });

        sepButton.setBackground(new java.awt.Color(34, 34, 34));
        sepButton.setContentAreaFilled(false);
        sepButton.setOpaque(true);
        sepButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sepButton.setForeground(new java.awt.Color(240, 240, 240));
        sepButton.setText("SEP");
        sepButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sepButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sepButton.setMargin(new java.awt.Insets(1, 1, 1, 1));
        sepButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sepButtonActionPerformed(evt);
            }
        });

        octButton.setBackground(new java.awt.Color(34, 34, 34));
        octButton.setContentAreaFilled(false);
        octButton.setOpaque(true);
        octButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        octButton.setForeground(new java.awt.Color(240, 240, 240));
        octButton.setText("OCT");
        octButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        octButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        octButton.setMargin(new java.awt.Insets(1, 1, 1, 1));
        octButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                octButtonActionPerformed(evt);
            }
        });

        novButton.setBackground(new java.awt.Color(34, 34, 34));
        novButton.setContentAreaFilled(false);
        novButton.setOpaque(true);
        novButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        novButton.setForeground(new java.awt.Color(240, 240, 240));
        novButton.setText("NOV");
        novButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        novButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        novButton.setMargin(new java.awt.Insets(1, 1, 1, 1));
        novButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novButtonActionPerformed(evt);
            }
        });

        decButton.setBackground(new java.awt.Color(34, 34, 34));
        decButton.setContentAreaFilled(false);
        decButton.setOpaque(true);
        decButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        decButton.setForeground(new java.awt.Color(240, 240, 240));
        decButton.setText("DEC");
        decButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        decButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        decButton.setMargin(new java.awt.Insets(1, 1, 1, 1));
        decButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(monthLeftArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(janButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(febButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(marButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aprButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(junButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(julButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(augButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(octButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(novButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(monthRightArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 55, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(monthLeftArrow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthRightArrow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(febButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(janButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(marButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aprButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mayButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(junButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(julButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(augButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sepButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(octButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(novButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(decButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        if(checkPink() == 1){
            janButton.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            janButton.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            febButton.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            febButton.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            marButton.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            marButton.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            aprButton.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            aprButton.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            mayButton.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            mayButton.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            junButton.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            junButton.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            julButton.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            julButton.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            augButton.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            augButton.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            sepButton.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            sepButton.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            octButton.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            octButton.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            novButton.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            novButton.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            decButton.setBackground(new java.awt.Color(255, 9, 88));
        }else{
            decButton.setBackground(new java.awt.Color(34, 34, 34));
        }

        jPanel2.setBackground(new java.awt.Color(51, 61, 68));
        jPanel2.setForeground(new java.awt.Color(240, 240, 240));

        eventLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        eventLabel1.setForeground(new java.awt.Color(240, 240, 240));
        eventLabel1.setText("Event 1");

        textArea1.setEditable(false);
        textArea1.setBackground(new java.awt.Color(34, 34, 34));
        textArea1.setColumns(20);
        textArea1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        textArea1.setForeground(new java.awt.Color(240, 240, 240));
        textArea1.setRows(5);
        textArea1.setText("Description:");
        jScrollPane1.setViewportView(textArea1);
        if(checkPink() == 1){
            textArea1.setBackground(new java.awt.Color(255,9 , 88));
        }else{
            textArea1.setBackground(new java.awt.Color(34, 34, 34));
        }

        eventLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        eventLabel2.setForeground(new java.awt.Color(240, 240, 240));
        eventLabel2.setText("Event 2");

        textArea3.setBackground(new java.awt.Color(34, 34, 34));
        textArea3.setColumns(20);
        textArea3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        textArea3.setForeground(new java.awt.Color(240, 240, 240));
        textArea3.setRows(5);
        textArea3.setText("Description:");
        jScrollPane2.setViewportView(textArea3);
        if(checkPink() == 1){
            textArea3.setBackground(new java.awt.Color(255,9 , 88));
        }else{
            textArea3.setBackground(new java.awt.Color(34, 34, 34));
        }

        eventLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        eventLabel3.setForeground(new java.awt.Color(240, 240, 240));
        eventLabel3.setText("Event 3");

        textArea2.setEditable(false);
        textArea2.setBackground(new java.awt.Color(34, 34, 34));
        textArea2.setColumns(20);
        textArea2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        textArea2.setForeground(new java.awt.Color(240, 240, 240));
        textArea2.setRows(5);
        textArea2.setText("Description:");
        jScrollPane3.setViewportView(textArea2);
        if(checkPink() == 1){
            textArea2.setBackground(new java.awt.Color(255,9 , 88));
        }else{
            textArea2.setBackground(new java.awt.Color(34, 34, 34));
        }

        eventButton1.setBackground(new java.awt.Color(34, 34, 34));
        eventButton1.setContentAreaFilled(false);
        eventButton1.setOpaque(true);
        eventButton1.setText("IMG");
        eventButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventButton1ActionPerformed(evt);
            }
        });

        eventButton2.setBackground(new java.awt.Color(34, 34, 34));
        eventButton2.setContentAreaFilled(false);
        eventButton2.setOpaque(true);
        eventButton2.setText("IMG");
        eventButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventButton2ActionPerformed(evt);
            }
        });

        eventButton3.setBackground(new java.awt.Color(34, 34, 34));
        eventButton3.setContentAreaFilled(false);
        eventButton3.setOpaque(true);
        eventButton3.setText("IMG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(eventLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eventButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(eventLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(46, 46, 46)
                        .addComponent(eventButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(eventLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eventButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eventLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        if(checkPink() == 1){
            eventButton1.setBackground(new java.awt.Color(255,9 , 88));
        }else{
            eventButton1.setBackground(new java.awt.Color(34,34,34));
        }
        if(checkPink() == 1){
            eventButton2.setBackground(new java.awt.Color(255,9 , 88));
        }else{
            eventButton2.setBackground(new java.awt.Color(34,34,34));
        }
        if(checkPink() == 1){
            eventButton3.setBackground(new java.awt.Color(255,9 , 88));
        }else{
            eventButton3.setBackground(new java.awt.Color(34, 34, 34));
        }

        jScrollPane4.setViewportView(jPanel2);
        if(checkPink() == 1){
            jPanel2.setBackground(new java.awt.Color(255, 174, 201));
        }else{
            jPanel2.setBackground(new java.awt.Color(51, 61, 68));
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        if(checkPink() == 1){
            titlePanel.setBackground(new java.awt.Color(255, 174, 201));
        }else{
            titlePanel.setBackground(new java.awt.Color(34, 34, 34));
        }
        if(checkPink() == 1){
            jPanel1.setBackground(new java.awt.Color(255, 174, 201));
        }else{
            jPanel1.setBackground(new java.awt.Color(51, 61, 68));
        }
        if(checkPink() == 1){
            jPanel3.setBackground(new java.awt.Color(255, 174, 201));
        }else{
            jPanel3.setBackground(new java.awt.Color(51, 61, 68));
        }
        int num = Calendar.getInstance().get(Calendar.MONTH);
        monthNum = num;
        i = num;
        if(num == 0){
            janButton.setBackground(new java.awt.Color(29,114,239));
        }

        if(num == 1){
            febButton.setBackground(new java.awt.Color(29,114,239));
        }

        if(num == 2){
            marButton.setBackground(new java.awt.Color(29,114,239));
        }

        if(num == 3){
            aprButton.setBackground(new java.awt.Color(29,114,239));
        }

        if(num == 4){
            mayButton.setBackground(new java.awt.Color(29,114,239));
        }

        if(num == 5){
            junButton.setBackground(new java.awt.Color(29,114,239));
        }

        if(num == 6){
            julButton.setBackground(new java.awt.Color(29,114,239));
        }

        if(num == 7){
            augButton.setBackground(new java.awt.Color(29,114,239));
        }

        if(num == 8){
            sepButton.setBackground(new java.awt.Color(29,114,239));
        }

        if(num == 9){
            octButton.setBackground(new java.awt.Color(29,114,239));
        }

        if(num == 10){
            novButton.setBackground(new java.awt.Color(29,114,239));
        }

        if(num == 11){
            decButton.setBackground(new java.awt.Color(29,114,239));
        }
        setDayNowColor();

        File file10 = new File(getPath() + "\\AppToDate\\Notification\\music.txt");
        BufferedReader bReader = null;
        try{
            String currentData;
            bReader = new BufferedReader(new FileReader(file10));
            while((currentData = bReader.readLine()) != null){
                musicPath = currentData;

            }
        }catch (FileNotFoundException ex) {
            System.out.println(getPath());
            JOptionPane.showMessageDialog(null,
                "Music File not found","Error",
                JOptionPane.WARNING_MESSAGE);
        }catch (IOException ex){
        }

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void dayButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton1ActionPerformed
        // TODO add your handling code here:
       setTextData();
       
       String monthNow = getMonthNum(monthNum);
       lock = 0;
       String dayNow = dayButton1.getText();
       
       setEventData(monthNow, dayNow);
       
 
       
    }//GEN-LAST:event_dayButton1ActionPerformed

    private void dayButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton2ActionPerformed
        // TODO add your handling code here:
       setTextData();
       
       String monthNow = getMonthNum(monthNum);
       lock = 0;
       String dayNow = dayButton2.getText();
       
       setEventData(monthNow, dayNow);
               
    }//GEN-LAST:event_dayButton2ActionPerformed

    private void dayButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton3ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
       String monthNow = getMonthNum(monthNum);
       lock = 0;
       String dayNow = dayButton3.getText();
       
       setEventData(monthNow, dayNow);
               
    }//GEN-LAST:event_dayButton3ActionPerformed

    private void dayButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton4ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton4.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton4ActionPerformed

    private void dayButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton5ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton5.getText();
       
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton5ActionPerformed

    private void dayButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton6ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton6.getText();
       
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton6ActionPerformed

    private void dayButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton7ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton7.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton7ActionPerformed

    private void dayButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton8ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton8.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton8ActionPerformed

    private void dayButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton9ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton9.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton9ActionPerformed

    private void dayButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton10ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton10.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton10ActionPerformed

    private void dayButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton11ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton11.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton11ActionPerformed

    private void dayButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton12ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
       String monthNow = getMonthNum(monthNum);
       lock = 0;
       String dayNow = dayButton12.getText();
       
       setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton12ActionPerformed

    private void dayButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton13ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton13.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton13ActionPerformed

    private void dayButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton14ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton14.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton14ActionPerformed

    private void dayButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton15ActionPerformed
        // TODO add your handling code here:
        setTextData();
       
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton15.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton15ActionPerformed

    private void dayButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton16ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton16.getText();
       
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton16ActionPerformed

    private void dayButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton17ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton17.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton17ActionPerformed

    private void dayButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton18ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton18.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton18ActionPerformed

    private void dayButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton19ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton19.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton19ActionPerformed

    private void dayButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton20ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton20.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton20ActionPerformed

    private void dayButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton21ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton21.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton21ActionPerformed

    private void dayButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton22ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton22.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton22ActionPerformed

    private void dayButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton23ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton23.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton23ActionPerformed

    private void dayButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton24ActionPerformed
        // TODO add your handling code here:
       setTextData();
        
       String monthNow = getMonthNum(monthNum);
       lock = 0;
       String dayNow = dayButton24.getText();
       
       setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton24ActionPerformed

    private void dayButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton25ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton25.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton25ActionPerformed

    private void dayButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton26ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton26.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton26ActionPerformed

    private void dayButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton27ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton27.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton27ActionPerformed

    private void dayButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton28ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton28.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton28ActionPerformed

    private void dayButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton29ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton29.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton29ActionPerformed

    private void dayButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton30ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton30.getText();
       
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton30ActionPerformed

    private void dayButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton31ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton31.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton31ActionPerformed

    private void dayButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton32ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton32.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton32ActionPerformed

    private void dayButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton33ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);lock = 0;
        String dayNow = dayButton33.getText();
        String combine = monthNow + "-" + dayNow;
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton33ActionPerformed

    private void dayButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton34ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton34.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton34ActionPerformed

    private void dayButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton35ActionPerformed
        // TODO add your handling code here:
        setTextData();
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton35.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton35ActionPerformed

    private void dayButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton36ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton36.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton36ActionPerformed

    private void dayButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton37ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton37.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton37ActionPerformed

    private void dayButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton38ActionPerformed
        // TODO add your handling code here:
        setTextData();
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton38.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton38ActionPerformed

    private void dayButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton39ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton39.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton39ActionPerformed

    private void dayButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton40ActionPerformed
        // TODO add your handling code here:#
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton40.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton40ActionPerformed

    private void dayButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton41ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton41.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton41ActionPerformed

    private void dayButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButton42ActionPerformed
        // TODO add your handling code here:
        setTextData();
        
        String monthNow = getMonthNum(monthNum);
        lock = 0;
        String dayNow = dayButton42.getText();
        
        setEventData(monthNow, dayNow);
    }//GEN-LAST:event_dayButton42ActionPerformed

    private void janButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_janButtonActionPerformed
        // TODO add your handling code here:
        setTextData();
        i = 0;
        monthNum = i;
            if(checkPink() == 1){
            janButton.setBackground(new java.awt.Color(255,9 , 88));
            febButton.setBackground(new java.awt.Color(255,9 , 88));
            marButton.setBackground(new java.awt.Color(255,9 , 88));
            aprButton.setBackground(new java.awt.Color(255,9 , 88));
            mayButton.setBackground(new java.awt.Color(255,9 , 88));
            junButton.setBackground(new java.awt.Color(255,9 , 88));
            julButton.setBackground(new java.awt.Color(255,9 , 88));
            augButton.setBackground(new java.awt.Color(255,9 , 88));
            sepButton.setBackground(new java.awt.Color(255,9 , 88));
            octButton.setBackground(new java.awt.Color(255,9 , 88));
            novButton.setBackground(new java.awt.Color(255,9 , 88));
            decButton.setBackground(new java.awt.Color(255,9 , 88));
            }else{
            janButton.setBackground(new java.awt.Color(34, 34, 34));
            febButton.setBackground(new java.awt.Color(34, 34, 34));
            marButton.setBackground(new java.awt.Color(34, 34, 34));
            aprButton.setBackground(new java.awt.Color(34, 34, 34));
            mayButton.setBackground(new java.awt.Color(34, 34, 34));
            junButton.setBackground(new java.awt.Color(34, 34, 34));
            julButton.setBackground(new java.awt.Color(34, 34, 34));
            augButton.setBackground(new java.awt.Color(34, 34, 34));
            sepButton.setBackground(new java.awt.Color(34, 34, 34));
            octButton.setBackground(new java.awt.Color(34, 34, 34));
            novButton.setBackground(new java.awt.Color(34, 34, 34));
            decButton.setBackground(new java.awt.Color(34, 34, 34));
            }
        janButton.setBackground(new java.awt.Color(29,114,239));       
        
        dayButton1.setText(String.valueOf(getCalendarDay(0, i)));
        dayButton2.setText(String.valueOf(getCalendarDay(1, i)));
        dayButton3.setText(String.valueOf(getCalendarDay(2, i)));
        dayButton4.setText(String.valueOf(getCalendarDay(3, i)));
        dayButton5.setText(String.valueOf(getCalendarDay(4, i)));
        dayButton6.setText(String.valueOf(getCalendarDay(5, i)));
        dayButton7.setText(String.valueOf(getCalendarDay(6, i)));
        dayButton8.setText(String.valueOf(getCalendarDay(7, i)));
        dayButton9.setText(String.valueOf(getCalendarDay(8, i)));
        dayButton10.setText(String.valueOf(getCalendarDay(9, i)));
        dayButton11.setText(String.valueOf(getCalendarDay(10, i)));
        dayButton12.setText(String.valueOf(getCalendarDay(11, i)));
        dayButton13.setText(String.valueOf(getCalendarDay(12, i)));
        dayButton14.setText(String.valueOf(getCalendarDay(13, i)));
        dayButton15.setText(String.valueOf(getCalendarDay(14, i)));
        dayButton16.setText(String.valueOf(getCalendarDay(15, i)));
        dayButton17.setText(String.valueOf(getCalendarDay(16, i)));
        dayButton18.setText(String.valueOf(getCalendarDay(17, i)));
        dayButton19.setText(String.valueOf(getCalendarDay(18, i)));
        dayButton20.setText(String.valueOf(getCalendarDay(19, i)));
        dayButton21.setText(String.valueOf(getCalendarDay(20, i)));
        dayButton22.setText(String.valueOf(getCalendarDay(21, i)));
        dayButton23.setText(String.valueOf(getCalendarDay(22, i)));
        dayButton24.setText(String.valueOf(getCalendarDay(23, i)));
        dayButton25.setText(String.valueOf(getCalendarDay(24, i)));
        dayButton26.setText(String.valueOf(getCalendarDay(25, i)));
        dayButton27.setText(String.valueOf(getCalendarDay(26, i)));
        dayButton28.setText(String.valueOf(getCalendarDay(27, i)));
        dayButton29.setText(String.valueOf(getCalendarDay(28, i)));
        dayButton30.setText(String.valueOf(getCalendarDay(29, i)));
        dayButton31.setText(String.valueOf(getCalendarDay(30, i)));
        dayButton32.setText(String.valueOf(getCalendarDay(31, i)));
        dayButton33.setText(String.valueOf(getCalendarDay(32, i)));
        dayButton34.setText(String.valueOf(getCalendarDay(33, i)));
        dayButton35.setText(String.valueOf(getCalendarDay(34, i)));
        dayButton36.setText(String.valueOf(getCalendarDay(35, i)));
        dayButton37.setText(String.valueOf(getCalendarDay(36, i)));
        dayButton38.setText(String.valueOf(getCalendarDay(37, i)));
        dayButton39.setText(String.valueOf(getCalendarDay(38, i)));
        dayButton40.setText(String.valueOf(getCalendarDay(39, i)));
        dayButton41.setText(String.valueOf(getCalendarDay(40, i)));
        dayButton42.setText(String.valueOf(getCalendarDay(41, i)));
        setDayNowColor();
    }//GEN-LAST:event_janButtonActionPerformed

    private void febButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_febButtonActionPerformed
        // TODO add your handling code here:
        setTextData();
        i = 1;
        monthNum = i;
            
            
            if(checkPink() == 1){
            janButton.setBackground(new java.awt.Color(255,9 , 88));
            febButton.setBackground(new java.awt.Color(255,9 , 88));
            marButton.setBackground(new java.awt.Color(255,9 , 88));
            aprButton.setBackground(new java.awt.Color(255,9 , 88));
            mayButton.setBackground(new java.awt.Color(255,9 , 88));
            junButton.setBackground(new java.awt.Color(255,9 , 88));
            julButton.setBackground(new java.awt.Color(255,9 , 88));
            augButton.setBackground(new java.awt.Color(255,9 , 88));
            sepButton.setBackground(new java.awt.Color(255,9 , 88));
            octButton.setBackground(new java.awt.Color(255,9 , 88));
            novButton.setBackground(new java.awt.Color(255,9 , 88));
            decButton.setBackground(new java.awt.Color(255,9 , 88));
            }else{
            janButton.setBackground(new java.awt.Color(34, 34, 34));
            febButton.setBackground(new java.awt.Color(34, 34, 34));
            marButton.setBackground(new java.awt.Color(34, 34, 34));
            aprButton.setBackground(new java.awt.Color(34, 34, 34));
            mayButton.setBackground(new java.awt.Color(34, 34, 34));
            junButton.setBackground(new java.awt.Color(34, 34, 34));
            julButton.setBackground(new java.awt.Color(34, 34, 34));
            augButton.setBackground(new java.awt.Color(34, 34, 34));
            sepButton.setBackground(new java.awt.Color(34, 34, 34));
            octButton.setBackground(new java.awt.Color(34, 34, 34));
            novButton.setBackground(new java.awt.Color(34, 34, 34));
            decButton.setBackground(new java.awt.Color(34, 34, 34));
            }
        febButton.setBackground(new java.awt.Color(29,114,239));
      
        dayButton1.setText(String.valueOf(getCalendarDay(0, i)));
        dayButton2.setText(String.valueOf(getCalendarDay(1, i)));
        dayButton3.setText(String.valueOf(getCalendarDay(2, i)));
        dayButton4.setText(String.valueOf(getCalendarDay(3, i)));
        dayButton5.setText(String.valueOf(getCalendarDay(4, i)));
        dayButton6.setText(String.valueOf(getCalendarDay(5, i)));
        dayButton7.setText(String.valueOf(getCalendarDay(6, i)));
        dayButton8.setText(String.valueOf(getCalendarDay(7, i)));
        dayButton9.setText(String.valueOf(getCalendarDay(8, i)));
        dayButton10.setText(String.valueOf(getCalendarDay(9, i)));
        dayButton11.setText(String.valueOf(getCalendarDay(10, i)));
        dayButton12.setText(String.valueOf(getCalendarDay(11, i)));
        dayButton13.setText(String.valueOf(getCalendarDay(12, i)));
        dayButton14.setText(String.valueOf(getCalendarDay(13, i)));
        dayButton15.setText(String.valueOf(getCalendarDay(14, i)));
        dayButton16.setText(String.valueOf(getCalendarDay(15, i)));
        dayButton17.setText(String.valueOf(getCalendarDay(16, i)));
        dayButton18.setText(String.valueOf(getCalendarDay(17, i)));
        dayButton19.setText(String.valueOf(getCalendarDay(18, i)));
        dayButton20.setText(String.valueOf(getCalendarDay(19, i)));
        dayButton21.setText(String.valueOf(getCalendarDay(20, i)));
        dayButton22.setText(String.valueOf(getCalendarDay(21, i)));
        dayButton23.setText(String.valueOf(getCalendarDay(22, i)));
        dayButton24.setText(String.valueOf(getCalendarDay(23, i)));
        dayButton25.setText(String.valueOf(getCalendarDay(24, i)));
        dayButton26.setText(String.valueOf(getCalendarDay(25, i)));
        dayButton27.setText(String.valueOf(getCalendarDay(26, i)));
        dayButton28.setText(String.valueOf(getCalendarDay(27, i)));
        dayButton29.setText(String.valueOf(getCalendarDay(28, i)));
        dayButton30.setText(String.valueOf(getCalendarDay(29, i)));
        dayButton31.setText(String.valueOf(getCalendarDay(30, i)));
        dayButton32.setText(String.valueOf(getCalendarDay(31, i)));
        dayButton33.setText(String.valueOf(getCalendarDay(32, i)));
        dayButton34.setText(String.valueOf(getCalendarDay(33, i)));
        dayButton35.setText(String.valueOf(getCalendarDay(34, i)));
        dayButton36.setText(String.valueOf(getCalendarDay(35, i)));
        dayButton37.setText(String.valueOf(getCalendarDay(36, i)));
        dayButton38.setText(String.valueOf(getCalendarDay(37, i)));
        dayButton39.setText(String.valueOf(getCalendarDay(38, i)));
        dayButton40.setText(String.valueOf(getCalendarDay(39, i)));
        dayButton41.setText(String.valueOf(getCalendarDay(40, i)));
        dayButton42.setText(String.valueOf(getCalendarDay(41, i)));
        setDayNowColor();
    }//GEN-LAST:event_febButtonActionPerformed

    private void marButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marButtonActionPerformed
        // TODO add your handling code here:
        setTextData();
        i = 2;
        monthNum = i;        
            
            if(checkPink() == 1){
            janButton.setBackground(new java.awt.Color(255,9 , 88));
            febButton.setBackground(new java.awt.Color(255,9 , 88));
            marButton.setBackground(new java.awt.Color(255,9 , 88));
            aprButton.setBackground(new java.awt.Color(255,9 , 88));
            mayButton.setBackground(new java.awt.Color(255,9 , 88));
            junButton.setBackground(new java.awt.Color(255,9 , 88));
            julButton.setBackground(new java.awt.Color(255,9 , 88));
            augButton.setBackground(new java.awt.Color(255,9 , 88));
            sepButton.setBackground(new java.awt.Color(255,9 , 88));
            octButton.setBackground(new java.awt.Color(255,9 , 88));
            novButton.setBackground(new java.awt.Color(255,9 , 88));
            decButton.setBackground(new java.awt.Color(255,9 , 88));
            }else{
            janButton.setBackground(new java.awt.Color(34, 34, 34));
            febButton.setBackground(new java.awt.Color(34, 34, 34));
            marButton.setBackground(new java.awt.Color(34, 34, 34));
            aprButton.setBackground(new java.awt.Color(34, 34, 34));
            mayButton.setBackground(new java.awt.Color(34, 34, 34));
            junButton.setBackground(new java.awt.Color(34, 34, 34));
            julButton.setBackground(new java.awt.Color(34, 34, 34));
            augButton.setBackground(new java.awt.Color(34, 34, 34));
            sepButton.setBackground(new java.awt.Color(34, 34, 34));
            octButton.setBackground(new java.awt.Color(34, 34, 34));
            novButton.setBackground(new java.awt.Color(34, 34, 34));
            decButton.setBackground(new java.awt.Color(34, 34, 34));
            }
            marButton.setBackground(new java.awt.Color(29,114,239));
       
        
        dayButton1.setText(String.valueOf(getCalendarDay(0, i)));
        dayButton2.setText(String.valueOf(getCalendarDay(1, i)));
        dayButton3.setText(String.valueOf(getCalendarDay(2, i)));
        dayButton4.setText(String.valueOf(getCalendarDay(3, i)));
        dayButton5.setText(String.valueOf(getCalendarDay(4, i)));
        dayButton6.setText(String.valueOf(getCalendarDay(5, i)));
        dayButton7.setText(String.valueOf(getCalendarDay(6, i)));
        dayButton8.setText(String.valueOf(getCalendarDay(7, i)));
        dayButton9.setText(String.valueOf(getCalendarDay(8, i)));
        dayButton10.setText(String.valueOf(getCalendarDay(9, i)));
        dayButton11.setText(String.valueOf(getCalendarDay(10, i)));
        dayButton12.setText(String.valueOf(getCalendarDay(11, i)));
        dayButton13.setText(String.valueOf(getCalendarDay(12, i)));
        dayButton14.setText(String.valueOf(getCalendarDay(13, i)));
        dayButton15.setText(String.valueOf(getCalendarDay(14, i)));
        dayButton16.setText(String.valueOf(getCalendarDay(15, i)));
        dayButton17.setText(String.valueOf(getCalendarDay(16, i)));
        dayButton18.setText(String.valueOf(getCalendarDay(17, i)));
        dayButton19.setText(String.valueOf(getCalendarDay(18, i)));
        dayButton20.setText(String.valueOf(getCalendarDay(19, i)));
        dayButton21.setText(String.valueOf(getCalendarDay(20, i)));
        dayButton22.setText(String.valueOf(getCalendarDay(21, i)));
        dayButton23.setText(String.valueOf(getCalendarDay(22, i)));
        dayButton24.setText(String.valueOf(getCalendarDay(23, i)));
        dayButton25.setText(String.valueOf(getCalendarDay(24, i)));
        dayButton26.setText(String.valueOf(getCalendarDay(25, i)));
        dayButton27.setText(String.valueOf(getCalendarDay(26, i)));
        dayButton28.setText(String.valueOf(getCalendarDay(27, i)));
        dayButton29.setText(String.valueOf(getCalendarDay(28, i)));
        dayButton30.setText(String.valueOf(getCalendarDay(29, i)));
        dayButton31.setText(String.valueOf(getCalendarDay(30, i)));
        dayButton32.setText(String.valueOf(getCalendarDay(31, i)));
        dayButton33.setText(String.valueOf(getCalendarDay(32, i)));
        dayButton34.setText(String.valueOf(getCalendarDay(33, i)));
        dayButton35.setText(String.valueOf(getCalendarDay(34, i)));
        dayButton36.setText(String.valueOf(getCalendarDay(35, i)));
        dayButton37.setText(String.valueOf(getCalendarDay(36, i)));
        dayButton38.setText(String.valueOf(getCalendarDay(37, i)));
        dayButton39.setText(String.valueOf(getCalendarDay(38, i)));
        dayButton40.setText(String.valueOf(getCalendarDay(39, i)));
        dayButton41.setText(String.valueOf(getCalendarDay(40, i)));
        dayButton42.setText(String.valueOf(getCalendarDay(41, i)));
        setDayNowColor();
    }//GEN-LAST:event_marButtonActionPerformed

    private void aprButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aprButtonActionPerformed
        // TODO add your handling code here:
        setTextData();
        i = 3;
        monthNum = i;    
            
            if(checkPink() == 1){
            janButton.setBackground(new java.awt.Color(255,9 , 88));
            febButton.setBackground(new java.awt.Color(255,9 , 88));
            marButton.setBackground(new java.awt.Color(255,9 , 88));
            aprButton.setBackground(new java.awt.Color(255,9 , 88));
            mayButton.setBackground(new java.awt.Color(255,9 , 88));
            junButton.setBackground(new java.awt.Color(255,9 , 88));
            julButton.setBackground(new java.awt.Color(255,9 , 88));
            augButton.setBackground(new java.awt.Color(255,9 , 88));
            sepButton.setBackground(new java.awt.Color(255,9 , 88));
            octButton.setBackground(new java.awt.Color(255,9 , 88));
            novButton.setBackground(new java.awt.Color(255,9 , 88));
            decButton.setBackground(new java.awt.Color(255,9 , 88));
            }else{
            janButton.setBackground(new java.awt.Color(34, 34, 34));
            febButton.setBackground(new java.awt.Color(34, 34, 34));
            marButton.setBackground(new java.awt.Color(34, 34, 34));
            aprButton.setBackground(new java.awt.Color(34, 34, 34));
            mayButton.setBackground(new java.awt.Color(34, 34, 34));
            junButton.setBackground(new java.awt.Color(34, 34, 34));
            julButton.setBackground(new java.awt.Color(34, 34, 34));
            augButton.setBackground(new java.awt.Color(34, 34, 34));
            sepButton.setBackground(new java.awt.Color(34, 34, 34));
            octButton.setBackground(new java.awt.Color(34, 34, 34));
            novButton.setBackground(new java.awt.Color(34, 34, 34));
            decButton.setBackground(new java.awt.Color(34, 34, 34));
            }
            aprButton.setBackground(new java.awt.Color(29,114,239));
     
        
        dayButton1.setText(String.valueOf(getCalendarDay(0, i)));
        dayButton2.setText(String.valueOf(getCalendarDay(1, i)));
        dayButton3.setText(String.valueOf(getCalendarDay(2, i)));
        dayButton4.setText(String.valueOf(getCalendarDay(3, i)));
        dayButton5.setText(String.valueOf(getCalendarDay(4, i)));
        dayButton6.setText(String.valueOf(getCalendarDay(5, i)));
        dayButton7.setText(String.valueOf(getCalendarDay(6, i)));
        dayButton8.setText(String.valueOf(getCalendarDay(7, i)));
        dayButton9.setText(String.valueOf(getCalendarDay(8, i)));
        dayButton10.setText(String.valueOf(getCalendarDay(9, i)));
        dayButton11.setText(String.valueOf(getCalendarDay(10, i)));
        dayButton12.setText(String.valueOf(getCalendarDay(11, i)));
        dayButton13.setText(String.valueOf(getCalendarDay(12, i)));
        dayButton14.setText(String.valueOf(getCalendarDay(13, i)));
        dayButton15.setText(String.valueOf(getCalendarDay(14, i)));
        dayButton16.setText(String.valueOf(getCalendarDay(15, i)));
        dayButton17.setText(String.valueOf(getCalendarDay(16, i)));
        dayButton18.setText(String.valueOf(getCalendarDay(17, i)));
        dayButton19.setText(String.valueOf(getCalendarDay(18, i)));
        dayButton20.setText(String.valueOf(getCalendarDay(19, i)));
        dayButton21.setText(String.valueOf(getCalendarDay(20, i)));
        dayButton22.setText(String.valueOf(getCalendarDay(21, i)));
        dayButton23.setText(String.valueOf(getCalendarDay(22, i)));
        dayButton24.setText(String.valueOf(getCalendarDay(23, i)));
        dayButton25.setText(String.valueOf(getCalendarDay(24, i)));
        dayButton26.setText(String.valueOf(getCalendarDay(25, i)));
        dayButton27.setText(String.valueOf(getCalendarDay(26, i)));
        dayButton28.setText(String.valueOf(getCalendarDay(27, i)));
        dayButton29.setText(String.valueOf(getCalendarDay(28, i)));
        dayButton30.setText(String.valueOf(getCalendarDay(29, i)));
        dayButton31.setText(String.valueOf(getCalendarDay(30, i)));
        dayButton32.setText(String.valueOf(getCalendarDay(31, i)));
        dayButton33.setText(String.valueOf(getCalendarDay(32, i)));
        dayButton34.setText(String.valueOf(getCalendarDay(33, i)));
        dayButton35.setText(String.valueOf(getCalendarDay(34, i)));
        dayButton36.setText(String.valueOf(getCalendarDay(35, i)));
        dayButton37.setText(String.valueOf(getCalendarDay(36, i)));
        dayButton38.setText(String.valueOf(getCalendarDay(37, i)));
        dayButton39.setText(String.valueOf(getCalendarDay(38, i)));
        dayButton40.setText(String.valueOf(getCalendarDay(39, i)));
        dayButton41.setText(String.valueOf(getCalendarDay(40, i)));
        dayButton42.setText(String.valueOf(getCalendarDay(41, i)));
        setDayNowColor();
    }//GEN-LAST:event_aprButtonActionPerformed

    private void mayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mayButtonActionPerformed
        // TODO add your handling code here:
        setTextData();
        i = 4;
        monthNum = i;      
            if(checkPink() == 1){
            janButton.setBackground(new java.awt.Color(255,9 , 88));
            febButton.setBackground(new java.awt.Color(255,9 , 88));
            marButton.setBackground(new java.awt.Color(255,9 , 88));
            aprButton.setBackground(new java.awt.Color(255,9 , 88));
            mayButton.setBackground(new java.awt.Color(255,9 , 88));
            junButton.setBackground(new java.awt.Color(255,9 , 88));
            julButton.setBackground(new java.awt.Color(255,9 , 88));
            augButton.setBackground(new java.awt.Color(255,9 , 88));
            sepButton.setBackground(new java.awt.Color(255,9 , 88));
            octButton.setBackground(new java.awt.Color(255,9 , 88));
            novButton.setBackground(new java.awt.Color(255,9 , 88));
            decButton.setBackground(new java.awt.Color(255,9 , 88));
            }else{
            janButton.setBackground(new java.awt.Color(34, 34, 34));
            febButton.setBackground(new java.awt.Color(34, 34, 34));
            marButton.setBackground(new java.awt.Color(34, 34, 34));
            aprButton.setBackground(new java.awt.Color(34, 34, 34));
            mayButton.setBackground(new java.awt.Color(34, 34, 34));
            junButton.setBackground(new java.awt.Color(34, 34, 34));
            julButton.setBackground(new java.awt.Color(34, 34, 34));
            augButton.setBackground(new java.awt.Color(34, 34, 34));
            sepButton.setBackground(new java.awt.Color(34, 34, 34));
            octButton.setBackground(new java.awt.Color(34, 34, 34));
            novButton.setBackground(new java.awt.Color(34, 34, 34));
            decButton.setBackground(new java.awt.Color(34, 34, 34));
            }
            mayButton.setBackground(new java.awt.Color(29,114,239));
         
        
        dayButton1.setText(String.valueOf(getCalendarDay(0, i)));
        dayButton2.setText(String.valueOf(getCalendarDay(1, i)));
        dayButton3.setText(String.valueOf(getCalendarDay(2, i)));
        dayButton4.setText(String.valueOf(getCalendarDay(3, i)));
        dayButton5.setText(String.valueOf(getCalendarDay(4, i)));
        dayButton6.setText(String.valueOf(getCalendarDay(5, i)));
        dayButton7.setText(String.valueOf(getCalendarDay(6, i)));
        dayButton8.setText(String.valueOf(getCalendarDay(7, i)));
        dayButton9.setText(String.valueOf(getCalendarDay(8, i)));
        dayButton10.setText(String.valueOf(getCalendarDay(9, i)));
        dayButton11.setText(String.valueOf(getCalendarDay(10, i)));
        dayButton12.setText(String.valueOf(getCalendarDay(11, i)));
        dayButton13.setText(String.valueOf(getCalendarDay(12, i)));
        dayButton14.setText(String.valueOf(getCalendarDay(13, i)));
        dayButton15.setText(String.valueOf(getCalendarDay(14, i)));
        dayButton16.setText(String.valueOf(getCalendarDay(15, i)));
        dayButton17.setText(String.valueOf(getCalendarDay(16, i)));
        dayButton18.setText(String.valueOf(getCalendarDay(17, i)));
        dayButton19.setText(String.valueOf(getCalendarDay(18, i)));
        dayButton20.setText(String.valueOf(getCalendarDay(19, i)));
        dayButton21.setText(String.valueOf(getCalendarDay(20, i)));
        dayButton22.setText(String.valueOf(getCalendarDay(21, i)));
        dayButton23.setText(String.valueOf(getCalendarDay(22, i)));
        dayButton24.setText(String.valueOf(getCalendarDay(23, i)));
        dayButton25.setText(String.valueOf(getCalendarDay(24, i)));
        dayButton26.setText(String.valueOf(getCalendarDay(25, i)));
        dayButton27.setText(String.valueOf(getCalendarDay(26, i)));
        dayButton28.setText(String.valueOf(getCalendarDay(27, i)));
        dayButton29.setText(String.valueOf(getCalendarDay(28, i)));
        dayButton30.setText(String.valueOf(getCalendarDay(29, i)));
        dayButton31.setText(String.valueOf(getCalendarDay(30, i)));
        dayButton32.setText(String.valueOf(getCalendarDay(31, i)));
        dayButton33.setText(String.valueOf(getCalendarDay(32, i)));
        dayButton34.setText(String.valueOf(getCalendarDay(33, i)));
        dayButton35.setText(String.valueOf(getCalendarDay(34, i)));
        dayButton36.setText(String.valueOf(getCalendarDay(35, i)));
        dayButton37.setText(String.valueOf(getCalendarDay(36, i)));
        dayButton38.setText(String.valueOf(getCalendarDay(37, i)));
        dayButton39.setText(String.valueOf(getCalendarDay(38, i)));
        dayButton40.setText(String.valueOf(getCalendarDay(39, i)));
        dayButton41.setText(String.valueOf(getCalendarDay(40, i)));
        dayButton42.setText(String.valueOf(getCalendarDay(41, i)));
        setDayNowColor();
    }//GEN-LAST:event_mayButtonActionPerformed

    private void junButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_junButtonActionPerformed
        // TODO add your handling code here:
        setTextData();
        i = 5;
        monthNum = i;
            
            if(checkPink() == 1){
            janButton.setBackground(new java.awt.Color(255,9 , 88));
            febButton.setBackground(new java.awt.Color(255,9 , 88));
            marButton.setBackground(new java.awt.Color(255,9 , 88));
            aprButton.setBackground(new java.awt.Color(255,9 , 88));
            mayButton.setBackground(new java.awt.Color(255,9 , 88));
            junButton.setBackground(new java.awt.Color(255,9 , 88));
            julButton.setBackground(new java.awt.Color(255,9 , 88));
            augButton.setBackground(new java.awt.Color(255,9 , 88));
            sepButton.setBackground(new java.awt.Color(255,9 , 88));
            octButton.setBackground(new java.awt.Color(255,9 , 88));
            novButton.setBackground(new java.awt.Color(255,9 , 88));
            decButton.setBackground(new java.awt.Color(255,9 , 88));
            }else{
            janButton.setBackground(new java.awt.Color(34, 34, 34));
            febButton.setBackground(new java.awt.Color(34, 34, 34));
            marButton.setBackground(new java.awt.Color(34, 34, 34));
            aprButton.setBackground(new java.awt.Color(34, 34, 34));
            mayButton.setBackground(new java.awt.Color(34, 34, 34));
            junButton.setBackground(new java.awt.Color(34, 34, 34));
            julButton.setBackground(new java.awt.Color(34, 34, 34));
            augButton.setBackground(new java.awt.Color(34, 34, 34));
            sepButton.setBackground(new java.awt.Color(34, 34, 34));
            octButton.setBackground(new java.awt.Color(34, 34, 34));
            novButton.setBackground(new java.awt.Color(34, 34, 34));
            decButton.setBackground(new java.awt.Color(34, 34, 34));
            }
            junButton.setBackground(new java.awt.Color(29,114,239));
      
        
        dayButton1.setText(String.valueOf(getCalendarDay(0, i)));
        dayButton2.setText(String.valueOf(getCalendarDay(1, i)));
        dayButton3.setText(String.valueOf(getCalendarDay(2, i)));
        dayButton4.setText(String.valueOf(getCalendarDay(3, i)));
        dayButton5.setText(String.valueOf(getCalendarDay(4, i)));
        dayButton6.setText(String.valueOf(getCalendarDay(5, i)));
        dayButton7.setText(String.valueOf(getCalendarDay(6, i)));
        dayButton8.setText(String.valueOf(getCalendarDay(7, i)));
        dayButton9.setText(String.valueOf(getCalendarDay(8, i)));
        dayButton10.setText(String.valueOf(getCalendarDay(9, i)));
        dayButton11.setText(String.valueOf(getCalendarDay(10, i)));
        dayButton12.setText(String.valueOf(getCalendarDay(11, i)));
        dayButton13.setText(String.valueOf(getCalendarDay(12, i)));
        dayButton14.setText(String.valueOf(getCalendarDay(13, i)));
        dayButton15.setText(String.valueOf(getCalendarDay(14, i)));
        dayButton16.setText(String.valueOf(getCalendarDay(15, i)));
        dayButton17.setText(String.valueOf(getCalendarDay(16, i)));
        dayButton18.setText(String.valueOf(getCalendarDay(17, i)));
        dayButton19.setText(String.valueOf(getCalendarDay(18, i)));
        dayButton20.setText(String.valueOf(getCalendarDay(19, i)));
        dayButton21.setText(String.valueOf(getCalendarDay(20, i)));
        dayButton22.setText(String.valueOf(getCalendarDay(21, i)));
        dayButton23.setText(String.valueOf(getCalendarDay(22, i)));
        dayButton24.setText(String.valueOf(getCalendarDay(23, i)));
        dayButton25.setText(String.valueOf(getCalendarDay(24, i)));
        dayButton26.setText(String.valueOf(getCalendarDay(25, i)));
        dayButton27.setText(String.valueOf(getCalendarDay(26, i)));
        dayButton28.setText(String.valueOf(getCalendarDay(27, i)));
        dayButton29.setText(String.valueOf(getCalendarDay(28, i)));
        dayButton30.setText(String.valueOf(getCalendarDay(29, i)));
        dayButton31.setText(String.valueOf(getCalendarDay(30, i)));
        dayButton32.setText(String.valueOf(getCalendarDay(31, i)));
        dayButton33.setText(String.valueOf(getCalendarDay(32, i)));
        dayButton34.setText(String.valueOf(getCalendarDay(33, i)));
        dayButton35.setText(String.valueOf(getCalendarDay(34, i)));
        dayButton36.setText(String.valueOf(getCalendarDay(35, i)));
        dayButton37.setText(String.valueOf(getCalendarDay(36, i)));
        dayButton38.setText(String.valueOf(getCalendarDay(37, i)));
        dayButton39.setText(String.valueOf(getCalendarDay(38, i)));
        dayButton40.setText(String.valueOf(getCalendarDay(39, i)));
        dayButton41.setText(String.valueOf(getCalendarDay(40, i)));
        dayButton42.setText(String.valueOf(getCalendarDay(41, i)));
        setDayNowColor();
    }//GEN-LAST:event_junButtonActionPerformed

    private void julButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_julButtonActionPerformed
        // TODO add your handling code here:
        setTextData();
        i = 6;
        monthNum = i;       
            
            if(checkPink() == 1){
            janButton.setBackground(new java.awt.Color(255,9 , 88));
            febButton.setBackground(new java.awt.Color(255,9 , 88));
            marButton.setBackground(new java.awt.Color(255,9 , 88));
            aprButton.setBackground(new java.awt.Color(255,9 , 88));
            mayButton.setBackground(new java.awt.Color(255,9 , 88));
            junButton.setBackground(new java.awt.Color(255,9 , 88));
            julButton.setBackground(new java.awt.Color(255,9 , 88));
            augButton.setBackground(new java.awt.Color(255,9 , 88));
            sepButton.setBackground(new java.awt.Color(255,9 , 88));
            octButton.setBackground(new java.awt.Color(255,9 , 88));
            novButton.setBackground(new java.awt.Color(255,9 , 88));
            decButton.setBackground(new java.awt.Color(255,9 , 88));
            }else{
            janButton.setBackground(new java.awt.Color(34, 34, 34));
            febButton.setBackground(new java.awt.Color(34, 34, 34));
            marButton.setBackground(new java.awt.Color(34, 34, 34));
            aprButton.setBackground(new java.awt.Color(34, 34, 34));
            mayButton.setBackground(new java.awt.Color(34, 34, 34));
            junButton.setBackground(new java.awt.Color(34, 34, 34));
            julButton.setBackground(new java.awt.Color(34, 34, 34));
            augButton.setBackground(new java.awt.Color(34, 34, 34));
            sepButton.setBackground(new java.awt.Color(34, 34, 34));
            octButton.setBackground(new java.awt.Color(34, 34, 34));
            novButton.setBackground(new java.awt.Color(34, 34, 34));
            decButton.setBackground(new java.awt.Color(34, 34, 34));
            }
            julButton.setBackground(new java.awt.Color(29,114,239));
       
        
        dayButton1.setText(String.valueOf(getCalendarDay(0, i)));
        dayButton2.setText(String.valueOf(getCalendarDay(1, i)));
        dayButton3.setText(String.valueOf(getCalendarDay(2, i)));
        dayButton4.setText(String.valueOf(getCalendarDay(3, i)));
        dayButton5.setText(String.valueOf(getCalendarDay(4, i)));
        dayButton6.setText(String.valueOf(getCalendarDay(5, i)));
        dayButton7.setText(String.valueOf(getCalendarDay(6, i)));
        dayButton8.setText(String.valueOf(getCalendarDay(7, i)));
        dayButton9.setText(String.valueOf(getCalendarDay(8, i)));
        dayButton10.setText(String.valueOf(getCalendarDay(9, i)));
        dayButton11.setText(String.valueOf(getCalendarDay(10, i)));
        dayButton12.setText(String.valueOf(getCalendarDay(11, i)));
        dayButton13.setText(String.valueOf(getCalendarDay(12, i)));
        dayButton14.setText(String.valueOf(getCalendarDay(13, i)));
        dayButton15.setText(String.valueOf(getCalendarDay(14, i)));
        dayButton16.setText(String.valueOf(getCalendarDay(15, i)));
        dayButton17.setText(String.valueOf(getCalendarDay(16, i)));
        dayButton18.setText(String.valueOf(getCalendarDay(17, i)));
        dayButton19.setText(String.valueOf(getCalendarDay(18, i)));
        dayButton20.setText(String.valueOf(getCalendarDay(19, i)));
        dayButton21.setText(String.valueOf(getCalendarDay(20, i)));
        dayButton22.setText(String.valueOf(getCalendarDay(21, i)));
        dayButton23.setText(String.valueOf(getCalendarDay(22, i)));
        dayButton24.setText(String.valueOf(getCalendarDay(23, i)));
        dayButton25.setText(String.valueOf(getCalendarDay(24, i)));
        dayButton26.setText(String.valueOf(getCalendarDay(25, i)));
        dayButton27.setText(String.valueOf(getCalendarDay(26, i)));
        dayButton28.setText(String.valueOf(getCalendarDay(27, i)));
        dayButton29.setText(String.valueOf(getCalendarDay(28, i)));
        dayButton30.setText(String.valueOf(getCalendarDay(29, i)));
        dayButton31.setText(String.valueOf(getCalendarDay(30, i)));
        dayButton32.setText(String.valueOf(getCalendarDay(31, i)));
        dayButton33.setText(String.valueOf(getCalendarDay(32, i)));
        dayButton34.setText(String.valueOf(getCalendarDay(33, i)));
        dayButton35.setText(String.valueOf(getCalendarDay(34, i)));
        dayButton36.setText(String.valueOf(getCalendarDay(35, i)));
        dayButton37.setText(String.valueOf(getCalendarDay(36, i)));
        dayButton38.setText(String.valueOf(getCalendarDay(37, i)));
        dayButton39.setText(String.valueOf(getCalendarDay(38, i)));
        dayButton40.setText(String.valueOf(getCalendarDay(39, i)));
        dayButton41.setText(String.valueOf(getCalendarDay(40, i)));
        dayButton42.setText(String.valueOf(getCalendarDay(41, i)));
        setDayNowColor();
    }//GEN-LAST:event_julButtonActionPerformed

    private void augButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_augButtonActionPerformed
        // TODO add your handling code here:
        setTextData();
        i = 7;
        monthNum = i;
            
            if(checkPink() == 1){
            janButton.setBackground(new java.awt.Color(255,9 , 88));
            febButton.setBackground(new java.awt.Color(255,9 , 88));
            marButton.setBackground(new java.awt.Color(255,9 , 88));
            aprButton.setBackground(new java.awt.Color(255,9 , 88));
            mayButton.setBackground(new java.awt.Color(255,9 , 88));
            junButton.setBackground(new java.awt.Color(255,9 , 88));
            julButton.setBackground(new java.awt.Color(255,9 , 88));
            augButton.setBackground(new java.awt.Color(255,9 , 88));
            sepButton.setBackground(new java.awt.Color(255,9 , 88));
            octButton.setBackground(new java.awt.Color(255,9 , 88));
            novButton.setBackground(new java.awt.Color(255,9 , 88));
            decButton.setBackground(new java.awt.Color(255,9 , 88));
            }else{
            janButton.setBackground(new java.awt.Color(34, 34, 34));
            febButton.setBackground(new java.awt.Color(34, 34, 34));
            marButton.setBackground(new java.awt.Color(34, 34, 34));
            aprButton.setBackground(new java.awt.Color(34, 34, 34));
            mayButton.setBackground(new java.awt.Color(34, 34, 34));
            junButton.setBackground(new java.awt.Color(34, 34, 34));
            julButton.setBackground(new java.awt.Color(34, 34, 34));
            augButton.setBackground(new java.awt.Color(34, 34, 34));
            sepButton.setBackground(new java.awt.Color(34, 34, 34));
            octButton.setBackground(new java.awt.Color(34, 34, 34));
            novButton.setBackground(new java.awt.Color(34, 34, 34));
            decButton.setBackground(new java.awt.Color(34, 34, 34));
            }
            augButton.setBackground(new java.awt.Color(29,114,239));
       
        
        dayButton1.setText(String.valueOf(getCalendarDay(0, i)));
        dayButton2.setText(String.valueOf(getCalendarDay(1, i)));
        dayButton3.setText(String.valueOf(getCalendarDay(2, i)));
        dayButton4.setText(String.valueOf(getCalendarDay(3, i)));
        dayButton5.setText(String.valueOf(getCalendarDay(4, i)));
        dayButton6.setText(String.valueOf(getCalendarDay(5, i)));
        dayButton7.setText(String.valueOf(getCalendarDay(6, i)));
        dayButton8.setText(String.valueOf(getCalendarDay(7, i)));
        dayButton9.setText(String.valueOf(getCalendarDay(8, i)));
        dayButton10.setText(String.valueOf(getCalendarDay(9, i)));
        dayButton11.setText(String.valueOf(getCalendarDay(10, i)));
        dayButton12.setText(String.valueOf(getCalendarDay(11, i)));
        dayButton13.setText(String.valueOf(getCalendarDay(12, i)));
        dayButton14.setText(String.valueOf(getCalendarDay(13, i)));
        dayButton15.setText(String.valueOf(getCalendarDay(14, i)));
        dayButton16.setText(String.valueOf(getCalendarDay(15, i)));
        dayButton17.setText(String.valueOf(getCalendarDay(16, i)));
        dayButton18.setText(String.valueOf(getCalendarDay(17, i)));
        dayButton19.setText(String.valueOf(getCalendarDay(18, i)));
        dayButton20.setText(String.valueOf(getCalendarDay(19, i)));
        dayButton21.setText(String.valueOf(getCalendarDay(20, i)));
        dayButton22.setText(String.valueOf(getCalendarDay(21, i)));
        dayButton23.setText(String.valueOf(getCalendarDay(22, i)));
        dayButton24.setText(String.valueOf(getCalendarDay(23, i)));
        dayButton25.setText(String.valueOf(getCalendarDay(24, i)));
        dayButton26.setText(String.valueOf(getCalendarDay(25, i)));
        dayButton27.setText(String.valueOf(getCalendarDay(26, i)));
        dayButton28.setText(String.valueOf(getCalendarDay(27, i)));
        dayButton29.setText(String.valueOf(getCalendarDay(28, i)));
        dayButton30.setText(String.valueOf(getCalendarDay(29, i)));
        dayButton31.setText(String.valueOf(getCalendarDay(30, i)));
        dayButton32.setText(String.valueOf(getCalendarDay(31, i)));
        dayButton33.setText(String.valueOf(getCalendarDay(32, i)));
        dayButton34.setText(String.valueOf(getCalendarDay(33, i)));
        dayButton35.setText(String.valueOf(getCalendarDay(34, i)));
        dayButton36.setText(String.valueOf(getCalendarDay(35, i)));
        dayButton37.setText(String.valueOf(getCalendarDay(36, i)));
        dayButton38.setText(String.valueOf(getCalendarDay(37, i)));
        dayButton39.setText(String.valueOf(getCalendarDay(38, i)));
        dayButton40.setText(String.valueOf(getCalendarDay(39, i)));
        dayButton41.setText(String.valueOf(getCalendarDay(40, i)));
        dayButton42.setText(String.valueOf(getCalendarDay(41, i)));
        setDayNowColor();
    }//GEN-LAST:event_augButtonActionPerformed

    private void sepButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sepButtonActionPerformed
        // TODO add your handling code here:
        setTextData();
        i = 8;
        monthNum = i;       
            
            if(checkPink() == 1){
            janButton.setBackground(new java.awt.Color(255,9 , 88));
            febButton.setBackground(new java.awt.Color(255,9 , 88));
            marButton.setBackground(new java.awt.Color(255,9 , 88));
            aprButton.setBackground(new java.awt.Color(255,9 , 88));
            mayButton.setBackground(new java.awt.Color(255,9 , 88));
            junButton.setBackground(new java.awt.Color(255,9 , 88));
            julButton.setBackground(new java.awt.Color(255,9 , 88));
            augButton.setBackground(new java.awt.Color(255,9 , 88));
            sepButton.setBackground(new java.awt.Color(255,9 , 88));
            octButton.setBackground(new java.awt.Color(255,9 , 88));
            novButton.setBackground(new java.awt.Color(255,9 , 88));
            decButton.setBackground(new java.awt.Color(255,9 , 88));
            }else{
            janButton.setBackground(new java.awt.Color(34, 34, 34));
            febButton.setBackground(new java.awt.Color(34, 34, 34));
            marButton.setBackground(new java.awt.Color(34, 34, 34));
            aprButton.setBackground(new java.awt.Color(34, 34, 34));
            mayButton.setBackground(new java.awt.Color(34, 34, 34));
            junButton.setBackground(new java.awt.Color(34, 34, 34));
            julButton.setBackground(new java.awt.Color(34, 34, 34));
            augButton.setBackground(new java.awt.Color(34, 34, 34));
            sepButton.setBackground(new java.awt.Color(34, 34, 34));
            octButton.setBackground(new java.awt.Color(34, 34, 34));
            novButton.setBackground(new java.awt.Color(34, 34, 34));
            decButton.setBackground(new java.awt.Color(34, 34, 34));
            }
            sepButton.setBackground(new java.awt.Color(29,114,239));
       
        
        dayButton1.setText(String.valueOf(getCalendarDay(0, i)));
        dayButton2.setText(String.valueOf(getCalendarDay(1, i)));
        dayButton3.setText(String.valueOf(getCalendarDay(2, i)));
        dayButton4.setText(String.valueOf(getCalendarDay(3, i)));
        dayButton5.setText(String.valueOf(getCalendarDay(4, i)));
        dayButton6.setText(String.valueOf(getCalendarDay(5, i)));
        dayButton7.setText(String.valueOf(getCalendarDay(6, i)));
        dayButton8.setText(String.valueOf(getCalendarDay(7, i)));
        dayButton9.setText(String.valueOf(getCalendarDay(8, i)));
        dayButton10.setText(String.valueOf(getCalendarDay(9, i)));
        dayButton11.setText(String.valueOf(getCalendarDay(10, i)));
        dayButton12.setText(String.valueOf(getCalendarDay(11, i)));
        dayButton13.setText(String.valueOf(getCalendarDay(12, i)));
        dayButton14.setText(String.valueOf(getCalendarDay(13, i)));
        dayButton15.setText(String.valueOf(getCalendarDay(14, i)));
        dayButton16.setText(String.valueOf(getCalendarDay(15, i)));
        dayButton17.setText(String.valueOf(getCalendarDay(16, i)));
        dayButton18.setText(String.valueOf(getCalendarDay(17, i)));
        dayButton19.setText(String.valueOf(getCalendarDay(18, i)));
        dayButton20.setText(String.valueOf(getCalendarDay(19, i)));
        dayButton21.setText(String.valueOf(getCalendarDay(20, i)));
        dayButton22.setText(String.valueOf(getCalendarDay(21, i)));
        dayButton23.setText(String.valueOf(getCalendarDay(22, i)));
        dayButton24.setText(String.valueOf(getCalendarDay(23, i)));
        dayButton25.setText(String.valueOf(getCalendarDay(24, i)));
        dayButton26.setText(String.valueOf(getCalendarDay(25, i)));
        dayButton27.setText(String.valueOf(getCalendarDay(26, i)));
        dayButton28.setText(String.valueOf(getCalendarDay(27, i)));
        dayButton29.setText(String.valueOf(getCalendarDay(28, i)));
        dayButton30.setText(String.valueOf(getCalendarDay(29, i)));
        dayButton31.setText(String.valueOf(getCalendarDay(30, i)));
        dayButton32.setText(String.valueOf(getCalendarDay(31, i)));
        dayButton33.setText(String.valueOf(getCalendarDay(32, i)));
        dayButton34.setText(String.valueOf(getCalendarDay(33, i)));
        dayButton35.setText(String.valueOf(getCalendarDay(34, i)));
        dayButton36.setText(String.valueOf(getCalendarDay(35, i)));
        dayButton37.setText(String.valueOf(getCalendarDay(36, i)));
        dayButton38.setText(String.valueOf(getCalendarDay(37, i)));
        dayButton39.setText(String.valueOf(getCalendarDay(38, i)));
        dayButton40.setText(String.valueOf(getCalendarDay(39, i)));
        dayButton41.setText(String.valueOf(getCalendarDay(40, i)));
        dayButton42.setText(String.valueOf(getCalendarDay(41, i)));
        setDayNowColor();
    }//GEN-LAST:event_sepButtonActionPerformed

    private void octButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_octButtonActionPerformed
        // TODO add your handling code here:
        setTextData();
        i = 9;
        monthNum = i;   
            
            if(checkPink() == 1){
            janButton.setBackground(new java.awt.Color(255,9 , 88));
            febButton.setBackground(new java.awt.Color(255,9 , 88));
            marButton.setBackground(new java.awt.Color(255,9 , 88));
            aprButton.setBackground(new java.awt.Color(255,9 , 88));
            mayButton.setBackground(new java.awt.Color(255,9 , 88));
            junButton.setBackground(new java.awt.Color(255,9 , 88));
            julButton.setBackground(new java.awt.Color(255,9 , 88));
            augButton.setBackground(new java.awt.Color(255,9 , 88));
            sepButton.setBackground(new java.awt.Color(255,9 , 88));
            octButton.setBackground(new java.awt.Color(255,9 , 88));
            novButton.setBackground(new java.awt.Color(255,9 , 88));
            decButton.setBackground(new java.awt.Color(255,9 , 88));
            }else{
            janButton.setBackground(new java.awt.Color(34, 34, 34));
            febButton.setBackground(new java.awt.Color(34, 34, 34));
            marButton.setBackground(new java.awt.Color(34, 34, 34));
            aprButton.setBackground(new java.awt.Color(34, 34, 34));
            mayButton.setBackground(new java.awt.Color(34, 34, 34));
            junButton.setBackground(new java.awt.Color(34, 34, 34));
            julButton.setBackground(new java.awt.Color(34, 34, 34));
            augButton.setBackground(new java.awt.Color(34, 34, 34));
            sepButton.setBackground(new java.awt.Color(34, 34, 34));
            octButton.setBackground(new java.awt.Color(34, 34, 34));
            novButton.setBackground(new java.awt.Color(34, 34, 34));
            decButton.setBackground(new java.awt.Color(34, 34, 34));
            }
            octButton.setBackground(new java.awt.Color(29, 114, 239));
      
        
        dayButton1.setText(String.valueOf(getCalendarDay(0, i)));
        dayButton2.setText(String.valueOf(getCalendarDay(1, i)));
        dayButton3.setText(String.valueOf(getCalendarDay(2, i)));
        dayButton4.setText(String.valueOf(getCalendarDay(3, i)));
        dayButton5.setText(String.valueOf(getCalendarDay(4, i)));
        dayButton6.setText(String.valueOf(getCalendarDay(5, i)));
        dayButton7.setText(String.valueOf(getCalendarDay(6, i)));
        dayButton8.setText(String.valueOf(getCalendarDay(7, i)));
        dayButton9.setText(String.valueOf(getCalendarDay(8, i)));
        dayButton10.setText(String.valueOf(getCalendarDay(9, i)));
        dayButton11.setText(String.valueOf(getCalendarDay(10, i)));
        dayButton12.setText(String.valueOf(getCalendarDay(11, i)));
        dayButton13.setText(String.valueOf(getCalendarDay(12, i)));
        dayButton14.setText(String.valueOf(getCalendarDay(13, i)));
        dayButton15.setText(String.valueOf(getCalendarDay(14, i)));
        dayButton16.setText(String.valueOf(getCalendarDay(15, i)));
        dayButton17.setText(String.valueOf(getCalendarDay(16, i)));
        dayButton18.setText(String.valueOf(getCalendarDay(17, i)));
        dayButton19.setText(String.valueOf(getCalendarDay(18, i)));
        dayButton20.setText(String.valueOf(getCalendarDay(19, i)));
        dayButton21.setText(String.valueOf(getCalendarDay(20, i)));
        dayButton22.setText(String.valueOf(getCalendarDay(21, i)));
        dayButton23.setText(String.valueOf(getCalendarDay(22, i)));
        dayButton24.setText(String.valueOf(getCalendarDay(23, i)));
        dayButton25.setText(String.valueOf(getCalendarDay(24, i)));
        dayButton26.setText(String.valueOf(getCalendarDay(25, i)));
        dayButton27.setText(String.valueOf(getCalendarDay(26, i)));
        dayButton28.setText(String.valueOf(getCalendarDay(27, i)));
        dayButton29.setText(String.valueOf(getCalendarDay(28, i)));
        dayButton30.setText(String.valueOf(getCalendarDay(29, i)));
        dayButton31.setText(String.valueOf(getCalendarDay(30, i)));
        dayButton32.setText(String.valueOf(getCalendarDay(31, i)));
        dayButton33.setText(String.valueOf(getCalendarDay(32, i)));
        dayButton34.setText(String.valueOf(getCalendarDay(33, i)));
        dayButton35.setText(String.valueOf(getCalendarDay(34, i)));
        dayButton36.setText(String.valueOf(getCalendarDay(35, i)));
        dayButton37.setText(String.valueOf(getCalendarDay(36, i)));
        dayButton38.setText(String.valueOf(getCalendarDay(37, i)));
        dayButton39.setText(String.valueOf(getCalendarDay(38, i)));
        dayButton40.setText(String.valueOf(getCalendarDay(39, i)));
        dayButton41.setText(String.valueOf(getCalendarDay(40, i)));
        dayButton42.setText(String.valueOf(getCalendarDay(41, i)));
        setDayNowColor();
    }//GEN-LAST:event_octButtonActionPerformed

    private void novButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novButtonActionPerformed
        // TODO add your handling code here:
        setTextData();
        i = 10;
        monthNum = i;    
            
            if(checkPink() == 1){
            janButton.setBackground(new java.awt.Color(255,9 , 88));
            febButton.setBackground(new java.awt.Color(255,9 , 88));
            marButton.setBackground(new java.awt.Color(255,9 , 88));
            aprButton.setBackground(new java.awt.Color(255,9 , 88));
            mayButton.setBackground(new java.awt.Color(255,9 , 88));
            junButton.setBackground(new java.awt.Color(255,9 , 88));
            julButton.setBackground(new java.awt.Color(255,9 , 88));
            augButton.setBackground(new java.awt.Color(255,9 , 88));
            sepButton.setBackground(new java.awt.Color(255,9 , 88));
            octButton.setBackground(new java.awt.Color(255,9 , 88));
            novButton.setBackground(new java.awt.Color(255,9 , 88));
            decButton.setBackground(new java.awt.Color(255,9 , 88));
            }else{
            janButton.setBackground(new java.awt.Color(34, 34, 34));
            febButton.setBackground(new java.awt.Color(34, 34, 34));
            marButton.setBackground(new java.awt.Color(34, 34, 34));
            aprButton.setBackground(new java.awt.Color(34, 34, 34));
            mayButton.setBackground(new java.awt.Color(34, 34, 34));
            junButton.setBackground(new java.awt.Color(34, 34, 34));
            julButton.setBackground(new java.awt.Color(34, 34, 34));
            augButton.setBackground(new java.awt.Color(34, 34, 34));
            sepButton.setBackground(new java.awt.Color(34, 34, 34));
            octButton.setBackground(new java.awt.Color(34, 34, 34));
            novButton.setBackground(new java.awt.Color(34, 34, 34));
            decButton.setBackground(new java.awt.Color(34, 34, 34));
            }
            novButton.setBackground(new java.awt.Color(29,114,239));
      
        
        dayButton1.setText(String.valueOf(getCalendarDay(0, i)));
        dayButton2.setText(String.valueOf(getCalendarDay(1, i)));
        dayButton3.setText(String.valueOf(getCalendarDay(2, i)));
        dayButton4.setText(String.valueOf(getCalendarDay(3, i)));
        dayButton5.setText(String.valueOf(getCalendarDay(4, i)));
        dayButton6.setText(String.valueOf(getCalendarDay(5, i)));
        dayButton7.setText(String.valueOf(getCalendarDay(6, i)));
        dayButton8.setText(String.valueOf(getCalendarDay(7, i)));
        dayButton9.setText(String.valueOf(getCalendarDay(8, i)));
        dayButton10.setText(String.valueOf(getCalendarDay(9, i)));
        dayButton11.setText(String.valueOf(getCalendarDay(10, i)));
        dayButton12.setText(String.valueOf(getCalendarDay(11, i)));
        dayButton13.setText(String.valueOf(getCalendarDay(12, i)));
        dayButton14.setText(String.valueOf(getCalendarDay(13, i)));
        dayButton15.setText(String.valueOf(getCalendarDay(14, i)));
        dayButton16.setText(String.valueOf(getCalendarDay(15, i)));
        dayButton17.setText(String.valueOf(getCalendarDay(16, i)));
        dayButton18.setText(String.valueOf(getCalendarDay(17, i)));
        dayButton19.setText(String.valueOf(getCalendarDay(18, i)));
        dayButton20.setText(String.valueOf(getCalendarDay(19, i)));
        dayButton21.setText(String.valueOf(getCalendarDay(20, i)));
        dayButton22.setText(String.valueOf(getCalendarDay(21, i)));
        dayButton23.setText(String.valueOf(getCalendarDay(22, i)));
        dayButton24.setText(String.valueOf(getCalendarDay(23, i)));
        dayButton25.setText(String.valueOf(getCalendarDay(24, i)));
        dayButton26.setText(String.valueOf(getCalendarDay(25, i)));
        dayButton27.setText(String.valueOf(getCalendarDay(26, i)));
        dayButton28.setText(String.valueOf(getCalendarDay(27, i)));
        dayButton29.setText(String.valueOf(getCalendarDay(28, i)));
        dayButton30.setText(String.valueOf(getCalendarDay(29, i)));
        dayButton31.setText(String.valueOf(getCalendarDay(30, i)));
        dayButton32.setText(String.valueOf(getCalendarDay(31, i)));
        dayButton33.setText(String.valueOf(getCalendarDay(32, i)));
        dayButton34.setText(String.valueOf(getCalendarDay(33, i)));
        dayButton35.setText(String.valueOf(getCalendarDay(34, i)));
        dayButton36.setText(String.valueOf(getCalendarDay(35, i)));
        dayButton37.setText(String.valueOf(getCalendarDay(36, i)));
        dayButton38.setText(String.valueOf(getCalendarDay(37, i)));
        dayButton39.setText(String.valueOf(getCalendarDay(38, i)));
        dayButton40.setText(String.valueOf(getCalendarDay(39, i)));
        dayButton41.setText(String.valueOf(getCalendarDay(40, i)));
        dayButton42.setText(String.valueOf(getCalendarDay(41, i)));
        setDayNowColor();
    }//GEN-LAST:event_novButtonActionPerformed

    private void decButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decButtonActionPerformed
        // TODO add your handling code here:
        setTextData();
        i = 11;
        monthNum = i;
            
            if(checkPink() == 1){
            janButton.setBackground(new java.awt.Color(255,9 , 88));
            febButton.setBackground(new java.awt.Color(255,9 , 88));
            marButton.setBackground(new java.awt.Color(255,9 , 88));
            aprButton.setBackground(new java.awt.Color(255,9 , 88));
            mayButton.setBackground(new java.awt.Color(255,9 , 88));
            junButton.setBackground(new java.awt.Color(255,9 , 88));
            julButton.setBackground(new java.awt.Color(255,9 , 88));
            augButton.setBackground(new java.awt.Color(255,9 , 88));
            sepButton.setBackground(new java.awt.Color(255,9 , 88));
            octButton.setBackground(new java.awt.Color(255,9 , 88));
            novButton.setBackground(new java.awt.Color(255,9 , 88));
            decButton.setBackground(new java.awt.Color(255,9 , 88));
            }else{
            janButton.setBackground(new java.awt.Color(34, 34, 34));
            febButton.setBackground(new java.awt.Color(34, 34, 34));
            marButton.setBackground(new java.awt.Color(34, 34, 34));
            aprButton.setBackground(new java.awt.Color(34, 34, 34));
            mayButton.setBackground(new java.awt.Color(34, 34, 34));
            junButton.setBackground(new java.awt.Color(34, 34, 34));
            julButton.setBackground(new java.awt.Color(34, 34, 34));
            augButton.setBackground(new java.awt.Color(34, 34, 34));
            sepButton.setBackground(new java.awt.Color(34, 34, 34));
            octButton.setBackground(new java.awt.Color(34, 34, 34));
            novButton.setBackground(new java.awt.Color(34, 34, 34));
            decButton.setBackground(new java.awt.Color(34, 34, 34));
            }
            decButton.setBackground(new java.awt.Color(29,114,239));        
        
        
        dayButton1.setText(String.valueOf(getCalendarDay(0, i)));
        dayButton2.setText(String.valueOf(getCalendarDay(1, i)));
        dayButton3.setText(String.valueOf(getCalendarDay(2, i)));
        dayButton4.setText(String.valueOf(getCalendarDay(3, i)));
        dayButton5.setText(String.valueOf(getCalendarDay(4, i)));
        dayButton6.setText(String.valueOf(getCalendarDay(5, i)));
        dayButton7.setText(String.valueOf(getCalendarDay(6, i)));
        dayButton8.setText(String.valueOf(getCalendarDay(7, i)));
        dayButton9.setText(String.valueOf(getCalendarDay(8, i)));
        dayButton10.setText(String.valueOf(getCalendarDay(9, i)));
        dayButton11.setText(String.valueOf(getCalendarDay(10, i)));
        dayButton12.setText(String.valueOf(getCalendarDay(11, i)));
        dayButton13.setText(String.valueOf(getCalendarDay(12, i)));
        dayButton14.setText(String.valueOf(getCalendarDay(13, i)));
        dayButton15.setText(String.valueOf(getCalendarDay(14, i)));
        dayButton16.setText(String.valueOf(getCalendarDay(15, i)));
        dayButton17.setText(String.valueOf(getCalendarDay(16, i)));
        dayButton18.setText(String.valueOf(getCalendarDay(17, i)));
        dayButton19.setText(String.valueOf(getCalendarDay(18, i)));
        dayButton20.setText(String.valueOf(getCalendarDay(19, i)));
        dayButton21.setText(String.valueOf(getCalendarDay(20, i)));
        dayButton22.setText(String.valueOf(getCalendarDay(21, i)));
        dayButton23.setText(String.valueOf(getCalendarDay(22, i)));
        dayButton24.setText(String.valueOf(getCalendarDay(23, i)));
        dayButton25.setText(String.valueOf(getCalendarDay(24, i)));
        dayButton26.setText(String.valueOf(getCalendarDay(25, i)));
        dayButton27.setText(String.valueOf(getCalendarDay(26, i)));
        dayButton28.setText(String.valueOf(getCalendarDay(27, i)));
        dayButton29.setText(String.valueOf(getCalendarDay(28, i)));
        dayButton30.setText(String.valueOf(getCalendarDay(29, i)));
        dayButton31.setText(String.valueOf(getCalendarDay(30, i)));
        dayButton32.setText(String.valueOf(getCalendarDay(31, i)));
        dayButton33.setText(String.valueOf(getCalendarDay(32, i)));
        dayButton34.setText(String.valueOf(getCalendarDay(33, i)));
        dayButton35.setText(String.valueOf(getCalendarDay(34, i)));
        dayButton36.setText(String.valueOf(getCalendarDay(35, i)));
        dayButton37.setText(String.valueOf(getCalendarDay(36, i)));
        dayButton38.setText(String.valueOf(getCalendarDay(37, i)));
        dayButton39.setText(String.valueOf(getCalendarDay(38, i)));
        dayButton40.setText(String.valueOf(getCalendarDay(39, i)));
        dayButton41.setText(String.valueOf(getCalendarDay(40, i)));
        dayButton42.setText(String.valueOf(getCalendarDay(41, i)));
        setDayNowColor();
    }//GEN-LAST:event_decButtonActionPerformed

    private void leftYearArrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftYearArrowActionPerformed
        // TODO add your handling code here:
        setTextData();
        year = year - 1;
        yearLabel.setText(String.valueOf(year));
        dayButton1.setText(String.valueOf(getCalendarDay(0, i)));
        dayButton2.setText(String.valueOf(getCalendarDay(1, i)));
        dayButton3.setText(String.valueOf(getCalendarDay(2, i)));
        dayButton4.setText(String.valueOf(getCalendarDay(3, i)));
        dayButton5.setText(String.valueOf(getCalendarDay(4, i)));
        dayButton6.setText(String.valueOf(getCalendarDay(5, i)));
        dayButton7.setText(String.valueOf(getCalendarDay(6, i)));
        dayButton8.setText(String.valueOf(getCalendarDay(7, i)));
        dayButton9.setText(String.valueOf(getCalendarDay(8, i)));
        dayButton10.setText(String.valueOf(getCalendarDay(9, i)));
        dayButton11.setText(String.valueOf(getCalendarDay(10, i)));
        dayButton12.setText(String.valueOf(getCalendarDay(11, i)));
        dayButton13.setText(String.valueOf(getCalendarDay(12, i)));
        dayButton14.setText(String.valueOf(getCalendarDay(13, i)));
        dayButton15.setText(String.valueOf(getCalendarDay(14, i)));
        dayButton16.setText(String.valueOf(getCalendarDay(15, i)));
        dayButton17.setText(String.valueOf(getCalendarDay(16, i)));
        dayButton18.setText(String.valueOf(getCalendarDay(17, i)));
        dayButton19.setText(String.valueOf(getCalendarDay(18, i)));
        dayButton20.setText(String.valueOf(getCalendarDay(19, i)));
        dayButton21.setText(String.valueOf(getCalendarDay(20, i)));
        dayButton22.setText(String.valueOf(getCalendarDay(21, i)));
        dayButton23.setText(String.valueOf(getCalendarDay(22, i)));
        dayButton24.setText(String.valueOf(getCalendarDay(23, i)));
        dayButton25.setText(String.valueOf(getCalendarDay(24, i)));
        dayButton26.setText(String.valueOf(getCalendarDay(25, i)));
        dayButton27.setText(String.valueOf(getCalendarDay(26, i)));
        dayButton28.setText(String.valueOf(getCalendarDay(27, i)));
        dayButton29.setText(String.valueOf(getCalendarDay(28, i)));
        dayButton30.setText(String.valueOf(getCalendarDay(29, i)));
        dayButton31.setText(String.valueOf(getCalendarDay(30, i)));
        dayButton32.setText(String.valueOf(getCalendarDay(31, i)));
        dayButton33.setText(String.valueOf(getCalendarDay(32, i)));
        dayButton34.setText(String.valueOf(getCalendarDay(33, i)));
        dayButton35.setText(String.valueOf(getCalendarDay(34, i)));
        dayButton36.setText(String.valueOf(getCalendarDay(35, i)));
        dayButton37.setText(String.valueOf(getCalendarDay(36, i)));
        dayButton38.setText(String.valueOf(getCalendarDay(37, i)));
        dayButton39.setText(String.valueOf(getCalendarDay(38, i)));
        dayButton40.setText(String.valueOf(getCalendarDay(39, i)));
        dayButton41.setText(String.valueOf(getCalendarDay(40, i)));
        dayButton42.setText(String.valueOf(getCalendarDay(41, i)));
        setDayNowColor();
    }//GEN-LAST:event_leftYearArrowActionPerformed

    private void yearRightArrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearRightArrowActionPerformed
        // TODO add your handling code here:
        setTextData();
        year = year + 1;
        yearLabel.setText(String.valueOf(year));
        yearLabel.setText(String.valueOf(year));
        dayButton1.setText(String.valueOf(getCalendarDay(0, i)));
        dayButton2.setText(String.valueOf(getCalendarDay(1, i)));
        dayButton3.setText(String.valueOf(getCalendarDay(2, i)));
        dayButton4.setText(String.valueOf(getCalendarDay(3, i)));
        dayButton5.setText(String.valueOf(getCalendarDay(4, i)));
        dayButton6.setText(String.valueOf(getCalendarDay(5, i)));
        dayButton7.setText(String.valueOf(getCalendarDay(6, i)));
        dayButton8.setText(String.valueOf(getCalendarDay(7, i)));
        dayButton9.setText(String.valueOf(getCalendarDay(8, i)));
        dayButton10.setText(String.valueOf(getCalendarDay(9, i)));
        dayButton11.setText(String.valueOf(getCalendarDay(10, i)));
        dayButton12.setText(String.valueOf(getCalendarDay(11, i)));
        dayButton13.setText(String.valueOf(getCalendarDay(12, i)));
        dayButton14.setText(String.valueOf(getCalendarDay(13, i)));
        dayButton15.setText(String.valueOf(getCalendarDay(14, i)));
        dayButton16.setText(String.valueOf(getCalendarDay(15, i)));
        dayButton17.setText(String.valueOf(getCalendarDay(16, i)));
        dayButton18.setText(String.valueOf(getCalendarDay(17, i)));
        dayButton19.setText(String.valueOf(getCalendarDay(18, i)));
        dayButton20.setText(String.valueOf(getCalendarDay(19, i)));
        dayButton21.setText(String.valueOf(getCalendarDay(20, i)));
        dayButton22.setText(String.valueOf(getCalendarDay(21, i)));
        dayButton23.setText(String.valueOf(getCalendarDay(22, i)));
        dayButton24.setText(String.valueOf(getCalendarDay(23, i)));
        dayButton25.setText(String.valueOf(getCalendarDay(24, i)));
        dayButton26.setText(String.valueOf(getCalendarDay(25, i)));
        dayButton27.setText(String.valueOf(getCalendarDay(26, i)));
        dayButton28.setText(String.valueOf(getCalendarDay(27, i)));
        dayButton29.setText(String.valueOf(getCalendarDay(28, i)));
        dayButton30.setText(String.valueOf(getCalendarDay(29, i)));
        dayButton31.setText(String.valueOf(getCalendarDay(30, i)));
        dayButton32.setText(String.valueOf(getCalendarDay(31, i)));
        dayButton33.setText(String.valueOf(getCalendarDay(32, i)));
        dayButton34.setText(String.valueOf(getCalendarDay(33, i)));
        dayButton35.setText(String.valueOf(getCalendarDay(34, i)));
        dayButton36.setText(String.valueOf(getCalendarDay(35, i)));
        dayButton37.setText(String.valueOf(getCalendarDay(36, i)));
        dayButton38.setText(String.valueOf(getCalendarDay(37, i)));
        dayButton39.setText(String.valueOf(getCalendarDay(38, i)));
        dayButton40.setText(String.valueOf(getCalendarDay(39, i)));
        dayButton41.setText(String.valueOf(getCalendarDay(40, i)));
        dayButton42.setText(String.valueOf(getCalendarDay(41, i)));
        setDayNowColor();
    }//GEN-LAST:event_yearRightArrowActionPerformed

    private void yearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearButtonActionPerformed
        // TODO add your handling code here:
        close();
        YearlyView yv = new YearlyView();
        yv.setVisible(true);

    }//GEN-LAST:event_yearButtonActionPerformed

    private void modifyAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyAddActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyAdd().setVisible(true);
            }
        });
    }//GEN-LAST:event_modifyAddActionPerformed

    private void monthButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthButtonActionPerformed

    private void monthLeftArrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthLeftArrowActionPerformed
        // TODO add your handling code here:
        setTextData();
        if(checkPink() == 1){
            janButton.setBackground(new java.awt.Color(255,9 , 88));
            febButton.setBackground(new java.awt.Color(255,9 , 88));
            marButton.setBackground(new java.awt.Color(255,9 , 88));
            aprButton.setBackground(new java.awt.Color(255,9 , 88));
            mayButton.setBackground(new java.awt.Color(255,9 , 88));
            junButton.setBackground(new java.awt.Color(255,9 , 88));
            julButton.setBackground(new java.awt.Color(255,9 , 88));
            augButton.setBackground(new java.awt.Color(255,9 , 88));
            sepButton.setBackground(new java.awt.Color(255,9 , 88));
            octButton.setBackground(new java.awt.Color(255,9 , 88));
            novButton.setBackground(new java.awt.Color(255,9 , 88));
            decButton.setBackground(new java.awt.Color(255,9 , 88));
            }else{
            janButton.setBackground(new java.awt.Color(34, 34, 34));
            febButton.setBackground(new java.awt.Color(34, 34, 34));
            marButton.setBackground(new java.awt.Color(34, 34, 34));
            aprButton.setBackground(new java.awt.Color(34, 34, 34));
            mayButton.setBackground(new java.awt.Color(34, 34, 34));
            junButton.setBackground(new java.awt.Color(34, 34, 34));
            julButton.setBackground(new java.awt.Color(34, 34, 34));
            augButton.setBackground(new java.awt.Color(34, 34, 34));
            sepButton.setBackground(new java.awt.Color(34, 34, 34));
            octButton.setBackground(new java.awt.Color(34, 34, 34));
            novButton.setBackground(new java.awt.Color(34, 34, 34));
            decButton.setBackground(new java.awt.Color(34, 34, 34));
            }
        if(monthNum == 1){
            janButton.setBackground(new java.awt.Color(29,114,239));
            monthNum = monthNum - 1;
        }else if(monthNum == 2){
            febButton.setBackground(new java.awt.Color(29,114,239));
            monthNum = monthNum - 1;
        }else if(monthNum == 3){
            
            marButton.setBackground(new java.awt.Color(29,114,239));
            monthNum = monthNum - 1;   
        }else if(monthNum == 4){
            
            aprButton.setBackground(new java.awt.Color(29,114,239));
            monthNum = monthNum - 1;   
        }else if(monthNum == 5){
            
            mayButton.setBackground(new java.awt.Color(29,114,239));
            monthNum = monthNum - 1;
        }else if(monthNum == 6){
            
            junButton.setBackground(new java.awt.Color(29,114,239));
            monthNum = monthNum - 1;
        }else if(monthNum == 7){
            
            julButton.setBackground(new java.awt.Color(29,114,239));
            monthNum = monthNum - 1;

        }else if(monthNum == 8){
            
            augButton.setBackground(new java.awt.Color(29,114,239));
            monthNum = monthNum - 1;
        }else if(monthNum == 9){
                
            sepButton.setBackground(new java.awt.Color(29,114,239));
            monthNum = monthNum - 1;
        }else if(monthNum == 10){
            
            octButton.setBackground(new java.awt.Color(29,114,239));
            monthNum = monthNum - 1;
        }else if(monthNum == 11){
            
            novButton.setBackground(new java.awt.Color(29,114,239));
            monthNum = monthNum - 1;
        }else{
            janButton.setBackground(new java.awt.Color(29,114,239));
        }
        
        i = monthNum;
        dayButton1.setText(String.valueOf(getCalendarDay(0, i)));
        dayButton2.setText(String.valueOf(getCalendarDay(1, i)));
        dayButton3.setText(String.valueOf(getCalendarDay(2, i)));
        dayButton4.setText(String.valueOf(getCalendarDay(3, i)));
        dayButton5.setText(String.valueOf(getCalendarDay(4, i)));
        dayButton6.setText(String.valueOf(getCalendarDay(5, i)));
        dayButton7.setText(String.valueOf(getCalendarDay(6, i)));
        dayButton8.setText(String.valueOf(getCalendarDay(7, i)));
        dayButton9.setText(String.valueOf(getCalendarDay(8, i)));
        dayButton10.setText(String.valueOf(getCalendarDay(9, i)));
        dayButton11.setText(String.valueOf(getCalendarDay(10, i)));
        dayButton12.setText(String.valueOf(getCalendarDay(11, i)));
        dayButton13.setText(String.valueOf(getCalendarDay(12, i)));
        dayButton14.setText(String.valueOf(getCalendarDay(13, i)));
        dayButton15.setText(String.valueOf(getCalendarDay(14, i)));
        dayButton16.setText(String.valueOf(getCalendarDay(15, i)));
        dayButton17.setText(String.valueOf(getCalendarDay(16, i)));
        dayButton18.setText(String.valueOf(getCalendarDay(17, i)));
        dayButton19.setText(String.valueOf(getCalendarDay(18, i)));
        dayButton20.setText(String.valueOf(getCalendarDay(19, i)));
        dayButton21.setText(String.valueOf(getCalendarDay(20, i)));
        dayButton22.setText(String.valueOf(getCalendarDay(21, i)));
        dayButton23.setText(String.valueOf(getCalendarDay(22, i)));
        dayButton24.setText(String.valueOf(getCalendarDay(23, i)));
        dayButton25.setText(String.valueOf(getCalendarDay(24, i)));
        dayButton26.setText(String.valueOf(getCalendarDay(25, i)));
        dayButton27.setText(String.valueOf(getCalendarDay(26, i)));
        dayButton28.setText(String.valueOf(getCalendarDay(27, i)));
        dayButton29.setText(String.valueOf(getCalendarDay(28, i)));
        dayButton30.setText(String.valueOf(getCalendarDay(29, i)));
        dayButton31.setText(String.valueOf(getCalendarDay(30, i)));
        dayButton32.setText(String.valueOf(getCalendarDay(31, i)));
        dayButton33.setText(String.valueOf(getCalendarDay(32, i)));
        dayButton34.setText(String.valueOf(getCalendarDay(33, i)));
        dayButton35.setText(String.valueOf(getCalendarDay(34, i)));
        dayButton36.setText(String.valueOf(getCalendarDay(35, i)));
        dayButton37.setText(String.valueOf(getCalendarDay(36, i)));
        dayButton38.setText(String.valueOf(getCalendarDay(37, i)));
        dayButton39.setText(String.valueOf(getCalendarDay(38, i)));
        dayButton40.setText(String.valueOf(getCalendarDay(39, i)));
        dayButton41.setText(String.valueOf(getCalendarDay(40, i)));
        dayButton42.setText(String.valueOf(getCalendarDay(41, i)));
        setDayNowColor();
    }//GEN-LAST:event_monthLeftArrowActionPerformed

    private void monthRightArrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthRightArrowActionPerformed
        // TODO add your handling code here:
        setTextData();
        if(checkPink() == 1){
            janButton.setBackground(new java.awt.Color(255,9 , 88));
            febButton.setBackground(new java.awt.Color(255,9 , 88));
            marButton.setBackground(new java.awt.Color(255,9 , 88));
            aprButton.setBackground(new java.awt.Color(255,9 , 88));
            mayButton.setBackground(new java.awt.Color(255,9 , 88));
            junButton.setBackground(new java.awt.Color(255,9 , 88));
            julButton.setBackground(new java.awt.Color(255,9 , 88));
            augButton.setBackground(new java.awt.Color(255,9 , 88));
            sepButton.setBackground(new java.awt.Color(255,9 , 88));
            octButton.setBackground(new java.awt.Color(255,9 , 88));
            novButton.setBackground(new java.awt.Color(255,9 , 88));
            decButton.setBackground(new java.awt.Color(255,9 , 88));
            }else{
            janButton.setBackground(new java.awt.Color(34, 34, 34));
            febButton.setBackground(new java.awt.Color(34, 34, 34));
            marButton.setBackground(new java.awt.Color(34, 34, 34));
            aprButton.setBackground(new java.awt.Color(34, 34, 34));
            mayButton.setBackground(new java.awt.Color(34, 34, 34));
            junButton.setBackground(new java.awt.Color(34, 34, 34));
            julButton.setBackground(new java.awt.Color(34, 34, 34));
            augButton.setBackground(new java.awt.Color(34, 34, 34));
            sepButton.setBackground(new java.awt.Color(34, 34, 34));
            octButton.setBackground(new java.awt.Color(34, 34, 34));
            novButton.setBackground(new java.awt.Color(34, 34, 34));
            decButton.setBackground(new java.awt.Color(34, 34, 34));
            }
        if(monthNum == 0){
            
            
            febButton.setBackground(new java.awt.Color(29,114,239));
            monthNum = monthNum + 1;   
        }else if(monthNum == 1){
            
            marButton.setBackground(new java.awt.Color(29,114,239));
            monthNum = monthNum + 1;
        }else if(monthNum == 2){
            
            aprButton.setBackground(new java.awt.Color(29,114,239));
            monthNum = monthNum + 1;
        }else if(monthNum == 3){
            
            mayButton.setBackground(new java.awt.Color(29,114,239));
            monthNum = monthNum + 1;
        }else if(monthNum == 4){
            
            junButton.setBackground(new java.awt.Color(29,114,239));
            monthNum = monthNum + 1;
        }else if(monthNum == 5){
            
            julButton.setBackground(new java.awt.Color(29,114,239));
            monthNum = monthNum + 1;
        }else if(monthNum == 6){
            
            augButton.setBackground(new java.awt.Color(29,114,239));
            monthNum = monthNum + 1;
        }else if(monthNum == 7){
            
            sepButton.setBackground(new java.awt.Color(29,114,239));
            monthNum = monthNum + 1;
        }else if(monthNum == 8){
            
            octButton.setBackground(new java.awt.Color(29,114,239));
            monthNum = monthNum + 1;
        }else if(monthNum == 9){
            
            novButton.setBackground(new java.awt.Color(29,114,239));
            monthNum = monthNum + 1;
        }else if(monthNum == 10){
            
            decButton.setBackground(new java.awt.Color(29,114,239));
            monthNum = monthNum + 1;
        }else{
            decButton.setBackground(new java.awt.Color(29,114,239));
        }
        i = monthNum;
        dayButton1.setText(String.valueOf(getCalendarDay(0, i)));
        dayButton2.setText(String.valueOf(getCalendarDay(1, i)));
        dayButton3.setText(String.valueOf(getCalendarDay(2, i)));
        dayButton4.setText(String.valueOf(getCalendarDay(3, i)));
        dayButton5.setText(String.valueOf(getCalendarDay(4, i)));
        dayButton6.setText(String.valueOf(getCalendarDay(5, i)));
        dayButton7.setText(String.valueOf(getCalendarDay(6, i)));
        dayButton8.setText(String.valueOf(getCalendarDay(7, i)));
        dayButton9.setText(String.valueOf(getCalendarDay(8, i)));
        dayButton10.setText(String.valueOf(getCalendarDay(9, i)));
        dayButton11.setText(String.valueOf(getCalendarDay(10, i)));
        dayButton12.setText(String.valueOf(getCalendarDay(11, i)));
        dayButton13.setText(String.valueOf(getCalendarDay(12, i)));
        dayButton14.setText(String.valueOf(getCalendarDay(13, i)));
        dayButton15.setText(String.valueOf(getCalendarDay(14, i)));
        dayButton16.setText(String.valueOf(getCalendarDay(15, i)));
        dayButton17.setText(String.valueOf(getCalendarDay(16, i)));
        dayButton18.setText(String.valueOf(getCalendarDay(17, i)));
        dayButton19.setText(String.valueOf(getCalendarDay(18, i)));
        dayButton20.setText(String.valueOf(getCalendarDay(19, i)));
        dayButton21.setText(String.valueOf(getCalendarDay(20, i)));
        dayButton22.setText(String.valueOf(getCalendarDay(21, i)));
        dayButton23.setText(String.valueOf(getCalendarDay(22, i)));
        dayButton24.setText(String.valueOf(getCalendarDay(23, i)));
        dayButton25.setText(String.valueOf(getCalendarDay(24, i)));
        dayButton26.setText(String.valueOf(getCalendarDay(25, i)));
        dayButton27.setText(String.valueOf(getCalendarDay(26, i)));
        dayButton28.setText(String.valueOf(getCalendarDay(27, i)));
        dayButton29.setText(String.valueOf(getCalendarDay(28, i)));
        dayButton30.setText(String.valueOf(getCalendarDay(29, i)));
        dayButton31.setText(String.valueOf(getCalendarDay(30, i)));
        dayButton32.setText(String.valueOf(getCalendarDay(31, i)));
        dayButton33.setText(String.valueOf(getCalendarDay(32, i)));
        dayButton34.setText(String.valueOf(getCalendarDay(33, i)));
        dayButton35.setText(String.valueOf(getCalendarDay(34, i)));
        dayButton36.setText(String.valueOf(getCalendarDay(35, i)));
        dayButton37.setText(String.valueOf(getCalendarDay(36, i)));
        dayButton38.setText(String.valueOf(getCalendarDay(37, i)));
        dayButton39.setText(String.valueOf(getCalendarDay(38, i)));
        dayButton40.setText(String.valueOf(getCalendarDay(39, i)));
        dayButton41.setText(String.valueOf(getCalendarDay(40, i)));
        dayButton42.setText(String.valueOf(getCalendarDay(41, i)));
        setDayNowColor();
    }//GEN-LAST:event_monthRightArrowActionPerformed
    
    private void dayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButtonActionPerformed
        // TODO add your handling code here:
        close();
        DailyView dV = new DailyView();
        dV.setVisible(true);
    }//GEN-LAST:event_dayButtonActionPerformed

    private void eventButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventButton2ActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        close();
        new MonthlyView().setVisible(true);
      
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void eventButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventButton1ActionPerformed

    private void settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Settings().setVisible(true);
            }
        });
    }//GEN-LAST:event_settingsActionPerformed
    
    private void close(){
        this.dispose();
    }
    
    private int getYear(){
        GregorianCalendar cal = new GregorianCalendar();
        year = cal.get(Calendar.YEAR);
        return year;
    }
    
    private static int getDay(){
    GregorianCalendar cal = new GregorianCalendar();
    int day = cal.get(Calendar.DAY_OF_WEEK);
    return day;
}
    private int getMonth(){
        String stringYear = yearLabel.getText();
        int intYear = Integer.parseInt(stringYear);
        GregorianCalendar cal = new GregorianCalendar();
        Date date = new Date(intYear, i, 1);
        cal.setTime(date);
    
        int month = cal.getActualMaximum(Calendar.MONTH);
        monthNum = month;
        return month;
    }

private int getCalendarDay(int dayButton ,int i){
    String stringYear = yearLabel.getText();
    int intYear = Integer.parseInt(stringYear);
    int addNum = 0;
    GregorianCalendar cal = new GregorianCalendar();
    Date date = new Date(intYear, i, 1);
    cal.setTime(date);
    
    int max = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    Calendar c = Calendar.getInstance();
    c.set(intYear, i, 1);
    int day = c.get(Calendar.DAY_OF_WEEK);
    int store[] = new int[42];
    
    day = day - 1;
    if(day - getStartingWeek() > 0){
       day = day - getStartingWeek(); 
    }else if(day - getStartingWeek() < 0){
       day = 7 + (day - getStartingWeek());
    }else if(day - getStartingWeek() == 0){
        day = 0;
    }
    
    int counter = 0;
        while(counter < day){
        store[counter] = 0; 
        counter++;
        }
        
        for(int j = 1; j <= max; j++){
            store[counter] = j;
            counter++;
        }
        
        while(counter <= 41){
            store[counter] = 0;
            counter++;
            addNum++;
        }
    return store[dayButton];
}

private int getDefaultMonth(int dayButton){
    String stringYear = yearLabel.getText();
    int intYear = Integer.parseInt(stringYear);
    int addNum = 0;
    GregorianCalendar cal = new GregorianCalendar();
    
    int month = cal.get(Calendar.MONTH);
    Date date = new Date(intYear, month, 1);
    cal.setTime(date);
    
    int max = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    Calendar c = Calendar.getInstance();
    c.set(intYear, month, 1);
    int day = c.get(Calendar.DAY_OF_WEEK);
    int store[] = new int[42];

    day = day - 1;
    if(day - getStartingWeek() > 0){
       day = day - getStartingWeek(); 
    }else if(day - getStartingWeek() < 0){
       day = 7 + (day - getStartingWeek());
    }else if(day - getStartingWeek() == 0){
        day = 0;
    }
    
    int counter = 0;
        while(counter < day){
        store[counter] = 0; 
        counter++;
        }
        
        for(int j = 1; j <= max; j++){
            store[counter] = j;
            counter++;
        }
        
        while(counter <= 41){
            store[counter] = 0; //1 + addNum;
            counter++;
            addNum++;
        } 
    return store[dayButton];
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
    
    private String getDesc(int num) throws FileNotFoundException, IOException{
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
        return splitString[1];
    }
    
        private String getImagePath(int num) throws FileNotFoundException, IOException{
        int j = 0;
        String combineAll = "";
        String[] splitString = new String[6];
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
        splitString[7] = splitString[7].replaceAll("null", "");
        return splitString[7];
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
    
    private int getStartingWeek(){
        Path path = Paths.get("");
        Path realPath;
        int weekCounter = 0;
        try {
            realPath = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
            stringPath = realPath.toString();
            stringPath = stringPath.replace("\\","\\\\");
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int counter = 0; counter < 7; counter++){
        File week = new File(stringPath + "\\AppToDate\\" + counter + ".txt");
        if(week.exists()){
           weekCounter = counter;
        }
        }
        return weekCounter;
    }
    
    public String getMonthNum(int num){
        String stringMonth = "";
        
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
    
    private int getNow(int num){
    Calendar now = Calendar.getInstance();
    int[] current = new int[3];
    int yearNow = now.get(Calendar.YEAR);
    int monthNow = now.get(Calendar.MONTH);
    int dayNow = now.get(Calendar.DAY_OF_MONTH);
    
    current[0] = monthNow;
    current[1] = dayNow;
    current[2] = yearNow;
   
    return current[num];
    }
    
    private void setDayNowColor(){
        if(checkPink() == 1){
        dayButton1.setBackground(new java.awt.Color(255, 9, 88));
        dayButton2.setBackground(new java.awt.Color(255, 9, 88));
        dayButton3.setBackground(new java.awt.Color(255, 9, 88));
        dayButton4.setBackground(new java.awt.Color(255, 9, 88));
        dayButton5.setBackground(new java.awt.Color(255, 9, 88));
        dayButton6.setBackground(new java.awt.Color(255, 9, 88));
        dayButton7.setBackground(new java.awt.Color(255, 9, 88));
        dayButton8.setBackground(new java.awt.Color(255, 9, 88));
        dayButton9.setBackground(new java.awt.Color(255, 9, 88));
        dayButton10.setBackground(new java.awt.Color(255, 9, 88));
        dayButton11.setBackground(new java.awt.Color(255, 9, 88));
        dayButton12.setBackground(new java.awt.Color(255, 9, 88));
        dayButton13.setBackground(new java.awt.Color(255, 9, 88));
        dayButton14.setBackground(new java.awt.Color(255, 9, 88));
        dayButton15.setBackground(new java.awt.Color(255, 9, 88));
        dayButton16.setBackground(new java.awt.Color(255, 9, 88));
        dayButton17.setBackground(new java.awt.Color(255, 9, 88));
        dayButton18.setBackground(new java.awt.Color(255, 9, 88));
        dayButton19.setBackground(new java.awt.Color(255, 9, 88));
        dayButton20.setBackground(new java.awt.Color(255, 9, 88));
        dayButton21.setBackground(new java.awt.Color(255, 9, 88));
        dayButton22.setBackground(new java.awt.Color(255, 9, 88));
        dayButton23.setBackground(new java.awt.Color(255, 9, 88));
        dayButton24.setBackground(new java.awt.Color(255, 9, 88));
        dayButton25.setBackground(new java.awt.Color(255, 9, 88));
        dayButton26.setBackground(new java.awt.Color(255, 9, 88));
        dayButton27.setBackground(new java.awt.Color(255, 9, 88));
        dayButton28.setBackground(new java.awt.Color(255, 9, 88));
        dayButton29.setBackground(new java.awt.Color(255, 9, 88));
        dayButton30.setBackground(new java.awt.Color(255, 9, 88));
        dayButton31.setBackground(new java.awt.Color(255, 9, 88));
        dayButton32.setBackground(new java.awt.Color(255, 9, 88));
        dayButton33.setBackground(new java.awt.Color(255, 9, 88));
        dayButton34.setBackground(new java.awt.Color(255, 9, 88));
        dayButton35.setBackground(new java.awt.Color(255, 9, 88));
        dayButton36.setBackground(new java.awt.Color(255, 9, 88));
        dayButton37.setBackground(new java.awt.Color(255, 9, 88));
        dayButton38.setBackground(new java.awt.Color(255, 9, 88));
        dayButton39.setBackground(new java.awt.Color(255, 9, 88));
        dayButton40.setBackground(new java.awt.Color(255, 9, 88));
        dayButton41.setBackground(new java.awt.Color(255, 9, 88));
        dayButton42.setBackground(new java.awt.Color(255, 9, 88));

        }else{
        dayButton1.setBackground(new java.awt.Color(34, 34, 34));
        dayButton2.setBackground(new java.awt.Color(34, 34, 34));
        dayButton3.setBackground(new java.awt.Color(34, 34, 34));
        dayButton4.setBackground(new java.awt.Color(34, 34, 34));
        dayButton5.setBackground(new java.awt.Color(34, 34, 34));
        dayButton6.setBackground(new java.awt.Color(34, 34, 34));
        dayButton7.setBackground(new java.awt.Color(34, 34, 34));
        dayButton8.setBackground(new java.awt.Color(34, 34, 34));
        dayButton9.setBackground(new java.awt.Color(34, 34, 34));
        dayButton10.setBackground(new java.awt.Color(34, 34, 34));
        dayButton11.setBackground(new java.awt.Color(34, 34, 34));
        dayButton12.setBackground(new java.awt.Color(34, 34, 34));
        dayButton13.setBackground(new java.awt.Color(34, 34, 34));
        dayButton14.setBackground(new java.awt.Color(34, 34, 34));
        dayButton15.setBackground(new java.awt.Color(34, 34, 34));
        dayButton16.setBackground(new java.awt.Color(34, 34, 34));
        dayButton17.setBackground(new java.awt.Color(34, 34, 34));
        dayButton18.setBackground(new java.awt.Color(34, 34, 34));
        dayButton19.setBackground(new java.awt.Color(34, 34, 34));
        dayButton20.setBackground(new java.awt.Color(34, 34, 34));
        dayButton21.setBackground(new java.awt.Color(34, 34, 34));
        dayButton22.setBackground(new java.awt.Color(34, 34, 34));
        dayButton23.setBackground(new java.awt.Color(34, 34, 34));
        dayButton24.setBackground(new java.awt.Color(34, 34, 34));
        dayButton25.setBackground(new java.awt.Color(34, 34, 34));
        dayButton26.setBackground(new java.awt.Color(34, 34, 34));
        dayButton27.setBackground(new java.awt.Color(34, 34, 34));
        dayButton28.setBackground(new java.awt.Color(34, 34, 34));
        dayButton29.setBackground(new java.awt.Color(34, 34, 34));
        dayButton30.setBackground(new java.awt.Color(34, 34, 34));
        dayButton31.setBackground(new java.awt.Color(34, 34, 34));
        dayButton32.setBackground(new java.awt.Color(34, 34, 34));
        dayButton33.setBackground(new java.awt.Color(34, 34, 34));
        dayButton34.setBackground(new java.awt.Color(34, 34, 34));
        dayButton35.setBackground(new java.awt.Color(34, 34, 34));
        dayButton36.setBackground(new java.awt.Color(34, 34, 34));
        dayButton37.setBackground(new java.awt.Color(34, 34, 34));
        dayButton38.setBackground(new java.awt.Color(34, 34, 34));
        dayButton39.setBackground(new java.awt.Color(34, 34, 34));
        dayButton40.setBackground(new java.awt.Color(34, 34, 34));
        dayButton41.setBackground(new java.awt.Color(34, 34, 34));
        dayButton42.setBackground(new java.awt.Color(34, 34, 34));
    }
        if(checkDayNow()){
            int confirmDay = Integer.parseInt(dayButton1.getText());
            if(getNow(1) == confirmDay){
                dayButton1.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton2.getText());
            if(getNow(1) == confirmDay){
                dayButton2.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton3.getText());
            if(getNow(1) == confirmDay){
                dayButton3.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton4.getText());
            if(getNow(1) == confirmDay){
                dayButton4.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton5.getText());
            if(getNow(1) == confirmDay){
                dayButton5.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton6.getText());
            if(getNow(1) == confirmDay){
                dayButton6.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton7.getText());
            if(getNow(1) == confirmDay){
                dayButton7.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton8.getText());
            if(getNow(1) == confirmDay){
                dayButton8.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton9.getText());
            if(getNow(1) == confirmDay){
                dayButton9.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton10.getText());
            if(getNow(1) == confirmDay){
                dayButton10.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton11.getText());
            if(getNow(1) == confirmDay){
                dayButton11.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton12.getText());
            if(getNow(1) == confirmDay){
                dayButton12.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton13.getText());
            if(getNow(1) == confirmDay){
                dayButton13.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton14.getText());
            if(getNow(1) == confirmDay){
                dayButton14.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton15.getText());
            if(getNow(1) == confirmDay){
                dayButton15.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton16.getText());
            if(getNow(1) == confirmDay){
                dayButton16.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton17.getText());
            if(getNow(1) == confirmDay){
                dayButton17.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton18.getText());
            if(getNow(1) == confirmDay){
                dayButton18.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton19.getText());
            if(getNow(1) == confirmDay){
                dayButton19.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton20.getText());
            if(getNow(1) == confirmDay){
                dayButton20.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton21.getText());
            if(getNow(1) == confirmDay){
                dayButton21.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton22.getText());
            if(getNow(1) == confirmDay){
                dayButton22.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton23.getText());
            if(getNow(1) == confirmDay){
                dayButton23.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton24.getText());
            if(getNow(1) == confirmDay){
                dayButton24.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton25.getText());
            if(getNow(1) == confirmDay){
                dayButton25.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton26.getText());
            if(getNow(1) == confirmDay){
                dayButton26.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton27.getText());
            if(getNow(1) == confirmDay){
                dayButton27.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton28.getText());
            if(getNow(1) == confirmDay){
                dayButton28.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton29.getText());
            if(getNow(1) == confirmDay){
                dayButton29.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton30.getText());
            if(getNow(1) == confirmDay){
                dayButton30.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton31.getText());
            if(getNow(1) == confirmDay){
                dayButton31.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton32.getText());
            if(getNow(1) == confirmDay){
                dayButton32.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton33.getText());
            if(getNow(1) == confirmDay){
                dayButton33.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton34.getText());
            if(getNow(1) == confirmDay){
                dayButton34.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton35.getText());
            if(getNow(1) == confirmDay){
                dayButton35.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton36.getText());
            if(getNow(1) == confirmDay){
                dayButton36.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton37.getText());
            if(getNow(1) == confirmDay){
                dayButton37.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton38.getText());
            if(getNow(1) == confirmDay){
                dayButton38.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton39.getText());
            if(getNow(1) == confirmDay){
                dayButton39.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton40.getText());
            if(getNow(1) == confirmDay){
                dayButton40.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton41.getText());
            if(getNow(1) == confirmDay){
                dayButton41.setBackground(new java.awt.Color(29, 114, 239));
            }
            confirmDay = Integer.parseInt(dayButton42.getText());
            if(getNow(1) == confirmDay){
                dayButton42.setBackground(new java.awt.Color(29, 114, 239));
            }
    }
        }
    
    private boolean checkDayNow(){
        if(getNow(2) == year){
            if(getNow(0) == monthNum){
                    return true;
                }
            }
            return false;
        }
    
    private void setTextData(){
        eventLabel1.setText("Event 1");
        eventLabel2.setText("Event 2"); 
        eventLabel3.setText("Event 3");
        textArea1.setText("Description:");
        textArea2.setText("Description:");
        textArea3.setText("Description:");
        eventButton1.setIcon(null);
        eventButton2.setIcon(null);
        eventButton3.setIcon(null);
        eventButton1.setText("Img");
        eventButton2.setText("Img");
        eventButton3.setText("Img");
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
        
        
    private void setEventData(String monthNow, String dayNow){
       String combine = monthNow + "-" + dayNow;
       whatDayNow = dayNow;
       int numOfFiles = getNumOfFiles();
       if(numOfFiles == 0){
          eventLabel1.setText("Event 1");
          eventLabel2.setText("Event 2"); 
          eventLabel3.setText("Event 3"); 
          eventButton1.setIcon(null);
          eventButton2.setIcon(null);
          eventButton3.setIcon(null);
          eventButton1.setText("Img");
          eventButton2.setText("Img");
          eventButton3.setText("Img");
       }
       if(numOfFiles != 0){
        String string = getFileNames(0);
        String[] parts = string.split("-");
        String part1 = parts[0]; 
        String part2 = parts[1]; 
        String part3 = parts[2]; 
        String combine2 = part1 + "-" + part2;
         if(combine.equals(combine2)){
           eventLabel1.setText(part3.replace(".txt",""));
           try {
               textArea1.setText(getDesc(0));
               eventButton1.setText("");
               String ImgRsc = getImagePath(0).replace("\\", "/");
               ImgRsc = ImgRsc.replace(" ", "");
               eventButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource(ImgRsc))); // NOI18N
            } catch (IOException ex) {
                Logger.getLogger(MonthlyView.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
         }
      
       if(numOfFiles == 2 || numOfFiles >= 3){
        String string = getFileNames(1);
        String[] parts = string.split("-");
        String part1 = parts[0]; 
        String part2 = parts[1]; 
        String part3 = parts[2]; 
        String combine2 = part1 + "-" + part2;
         if(combine.equals(combine2)){
           eventLabel2.setText(part3.replace(".txt",""));
           try {
               textArea2.setText(getDesc(1));
               eventButton2.setText("");
               String ImgRsc = getImagePath(1).replace("\\", "/");
               ImgRsc = ImgRsc.replace(" ", "");
               eventButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource(ImgRsc))); // NOI18N
            } catch (IOException ex) {
                Logger.getLogger(MonthlyView.class.getName()).log(Level.SEVERE, null, ex);
            }
       }  
       }
       
       if(numOfFiles >= 3){
        String string = getFileNames(2);
        String[] parts = string.split("-");
        String part1 = parts[0]; 
        String part2 = parts[1]; 
        String part3 = parts[2]; 
        String combine2 = part1 + "-" + part2;
         if(combine.equals(combine2)){
           eventLabel3.setText(part3.replace(".txt",""));
           try {
               textArea3.setText(getDesc(2));
               eventButton3.setText("");
               String ImgRsc = getImagePath(2).replace("\\", "/");
               ImgRsc = ImgRsc.replace(" ", "");
               eventButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource(ImgRsc))); // NOI18N
            } catch (IOException ex) {
                Logger.getLogger(MonthlyView.class.getName()).log(Level.SEVERE, null, ex);
            }
       }  
       }
       
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
            java.util.logging.Logger.getLogger(MonthlyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MonthlyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MonthlyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonthlyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MonthlyView().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aprButton;
    private javax.swing.JButton augButton;
    private javax.swing.JButton dayButton;
    private javax.swing.JButton dayButton1;
    private javax.swing.JButton dayButton10;
    private javax.swing.JButton dayButton11;
    private javax.swing.JButton dayButton12;
    private javax.swing.JButton dayButton13;
    private javax.swing.JButton dayButton14;
    private javax.swing.JButton dayButton15;
    private javax.swing.JButton dayButton16;
    private javax.swing.JButton dayButton17;
    private javax.swing.JButton dayButton18;
    private javax.swing.JButton dayButton19;
    private javax.swing.JButton dayButton2;
    private javax.swing.JButton dayButton20;
    private javax.swing.JButton dayButton21;
    private javax.swing.JButton dayButton22;
    private javax.swing.JButton dayButton23;
    private javax.swing.JButton dayButton24;
    private javax.swing.JButton dayButton25;
    private javax.swing.JButton dayButton26;
    private javax.swing.JButton dayButton27;
    private javax.swing.JButton dayButton28;
    private javax.swing.JButton dayButton29;
    private javax.swing.JButton dayButton3;
    private javax.swing.JButton dayButton30;
    private javax.swing.JButton dayButton31;
    private javax.swing.JButton dayButton32;
    private javax.swing.JButton dayButton33;
    private javax.swing.JButton dayButton34;
    private javax.swing.JButton dayButton35;
    private javax.swing.JButton dayButton36;
    private javax.swing.JButton dayButton37;
    private javax.swing.JButton dayButton38;
    private javax.swing.JButton dayButton39;
    private javax.swing.JButton dayButton4;
    private javax.swing.JButton dayButton40;
    private javax.swing.JButton dayButton41;
    private javax.swing.JButton dayButton42;
    private javax.swing.JButton dayButton5;
    private javax.swing.JButton dayButton6;
    private javax.swing.JButton dayButton7;
    private javax.swing.JButton dayButton8;
    private javax.swing.JButton dayButton9;
    private javax.swing.JLabel dayLabel1;
    private javax.swing.JLabel dayLabel2;
    private javax.swing.JLabel dayLabel3;
    private javax.swing.JLabel dayLabel4;
    private javax.swing.JLabel dayLabel5;
    private javax.swing.JLabel dayLabel6;
    private javax.swing.JLabel dayLabel7;
    private javax.swing.JButton decButton;
    private javax.swing.JButton eventButton1;
    private javax.swing.JButton eventButton2;
    private javax.swing.JButton eventButton3;
    private javax.swing.JLabel eventLabel1;
    private javax.swing.JLabel eventLabel2;
    private javax.swing.JLabel eventLabel3;
    private javax.swing.JButton febButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton janButton;
    private javax.swing.JButton julButton;
    private javax.swing.JButton junButton;
    private javax.swing.JButton leftYearArrow;
    private javax.swing.JButton marButton;
    private javax.swing.JButton mayButton;
    private javax.swing.JButton modifyAdd;
    private javax.swing.JButton monthButton;
    private javax.swing.JButton monthLeftArrow;
    private javax.swing.JButton monthRightArrow;
    private javax.swing.JButton novButton;
    private javax.swing.JButton octButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton sepButton;
    private javax.swing.JButton settings;
    private javax.swing.JTextArea textArea1;
    private javax.swing.JTextArea textArea2;
    private javax.swing.JTextArea textArea3;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JButton yearButton;
    private javax.swing.JLabel yearLabel;
    private javax.swing.JButton yearRightArrow;
    // End of variables declaration//GEN-END:variables
}
