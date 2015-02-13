/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptodate;

import java.io.FileInputStream;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.player.Player;

/**
 * This application is a free-time scheduler calendar that is dedicated
 * to students. The application is consist of a calendar that can be set with
 * to do lists or events with its corresponding notification or alarms.
 * 
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

public class AppToDate {

    private static String stringPath;
    private static String musicPath;
    
    
    /**
     * @param args the command line arguments
     */
    
    Thread t = new Thread(new PlayerThread(musicPath));
    
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                /*if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }*/
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
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
            java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MonthlyView().setVisible(true);
            }
        });
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            Calendar date = Calendar.getInstance();
            String[] cal;
            cal = new String[8];
            for(int i = 0; i < 8;i++){
            cal[i] = format.format(date.getTime());
            date.add(Calendar.DATE  , 1);
            }
            
            String parts[][] = new String[8][3];
            String splitPart[];
            for(int i = 0; i < 8; i++){
                splitPart = cal[i].split("/");
                parts[i][0] = splitPart[0];
                parts[i][1] = splitPart[1];
                parts[i][2] = splitPart[2];
                
                if(parts[i][0].equals("01") || parts[i][0].equals("1")){
                parts[i][0] = "JAN";        
                }
                if(parts[i][0].equals("02")  || parts[i][0].equals("2")){
                parts[i][0] = "FEB";        
                }
                if(parts[i][0].equals("03")  || parts[i][0].equals("3")){
                parts[i][0] = "MAR";        
                }
                if(parts[i][0].equals("04")  || parts[i][0].equals("4")){
                parts[i][0] = "APR";        
                }
                if(parts[i][0].equals("05")  || parts[i][0].equals("5")){
                parts[i][0] = "MAY";        
                }
                if(parts[i][0].equals("06")  || parts[i][0].equals("6")){
                parts[i][0] = "JUN";        
                }
                if(parts[i][0].equals("07")  || parts[i][0].equals("7")){
                parts[i][0] = "JUL";        
                }
                if(parts[i][0].equals("08")  || parts[i][0].equals("8")){
                parts[i][0] = "AUG";        
                }
                if(parts[i][0].equals("09")  || parts[i][0].equals("9")){
                parts[i][0] = "SEP";        
                }
                if(parts[i][0].equals("10")){
                parts[i][0] = "OCT";        
                }
                if(parts[i][0].equals("11")){
                parts[i][0] = "NOV";        
                }
                if(parts[i][0].equals("12")){
                parts[i][0] = "DEC";        
                }
                
                if(parts[i][1].equals("1")){
                parts[i][1] = "01";        
                }
                if(parts[i][1].equals("2")){
                parts[i][1] = "02";        
                }
                if(parts[i][1].equals("3")){
                parts[i][1] = "03";        
                }
                if(parts[i][1].equals("4")){
                parts[i][1] = "04";        
                }
                if(parts[i][1].equals("5")){
                parts[i][1] = "05";        
                }
                if(parts[i][1].equals("6")){
                parts[i][1] = "06";        
                }
                if(parts[i][1].equals("7")){
                parts[i][1] = "07";        
                }
                if(parts[i][1].equals("8")){
                parts[i][1] = "08";        
                }
                if(parts[i][1].equals("9")){
                parts[i][1] = "09";        
                }
              
            }
            
            Frame frame = null;
            JOptionPane.showMessageDialog(frame,"Events Coming up: \n"
            +  "Today's  Event: " + getNOF(parts[0][0],parts[0][1],parts[0][2]) +"\n"
            + parts[1][0] + "\\" + parts[1][1] + "\\" + parts[1][2] + ": " + getNOF(parts[1][0],parts[1][1],parts[1][2]) +"\n"
            + parts[2][0] + "\\" + parts[2][1] + "\\" + parts[2][2] + ": " + getNOF(parts[2][0],parts[2][1],parts[2][2]) +"\n"
            + parts[3][0] + "\\" + parts[3][1] + "\\" + parts[3][2] + ": " + getNOF(parts[3][0],parts[3][1],parts[3][2]) +"\n"
            + parts[4][0] + "\\" + parts[4][1] + "\\" + parts[4][2] + ": " + getNOF(parts[4][0],parts[4][1],parts[4][2]) +"\n"
            + parts[5][0] + "\\" + parts[5][1] + "\\" + parts[5][2] + ": " + getNOF(parts[5][0],parts[5][1],parts[5][2]) +"\n"
            + parts[6][0] + "\\" + parts[6][1] + "\\" + parts[6][2] + ": " + getNOF(parts[6][0],parts[6][1],parts[6][2]) +"\n"
            + parts[7][0] + "\\" + parts[7][1] + "\\" + parts[7][2] + ": "  + getNOF(parts[7][0],parts[7][1],parts[7][2]));
            
    /*        
    try{
    FileInputStream fis = new FileInputStream("C:\\Users\\TONETTE\\Desktop\\Rise Against - Behind Closed Doors.mp3");
    Player playMP3 = new Player(fis);
    musicPath = "C:\\Users\\TONETTE\\Desktop\\Rise Against - Behind Closed Doors.mp3";
    playMP3.play();
    }catch(Exception e){
        System.out.println(e);
    }
    */        
        }
    
    public static int getNOF(String m, String d, String y){ //Get Number of Files
        String thePathFile[] = new String[1000];
        String filePath = getPath();
        File folder = new File(filePath + "\\AppToDate\\" + y + "\\" + m + "\\" + d) ;
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
    
    public static String getPath(){
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
    
}

