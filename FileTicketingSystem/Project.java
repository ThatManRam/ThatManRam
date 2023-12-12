/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;

/**
 *
 * @author Admin
 */
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedReader;

/**
 *
 * @author RPeyton1058
 */



public class Project {

   
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        File file = new File("./src/project/Output.txt");
        File file2 = new File("./src/project/Passcode.txt");
        
       
        
        String [] key = new String [10000];
        String [] key2 = new String [10000];
        int b = 0;
        int c = 0;
        int d = 0;
                if (file.exists()){
             
             FileReader FR = new FileReader(file);
             BufferedReader reader = new BufferedReader(FR);
             String line = reader.readLine();
           
            
             while (line != null) {
        key[b] = line;
        line = reader.readLine();
        
        b= b+1;
             }
    
          
             
        }
        else{
            
            file.createNewFile();
            
        }
       PrintWriter outFS = new PrintWriter(file);
       if (key[0] != null){
           while (b>0){
               
       outFS.println(key[c]);
       b= b-1;
       c=c+1;
               
           }
           c = c-5;
        d = Integer.parseInt(key[c]);
        d = d+1;
      
           
       }
       b = 0;
       c = 0;
       
        if (file2.exists()){
            
             FileReader FR2 = new FileReader(file2);
             BufferedReader reader = new BufferedReader(FR2);
             String line = reader.readLine();
           
            
             while (line != null) {
        key2[b] = line;
        line = reader.readLine();
        
        b= b+1;
             }
    
          
             
        }
        else{
            
            file2.createNewFile();
            
        }
        PrintWriter outFS2 = new PrintWriter(file2);
        
         if (key2[0] != null){
           while (b>0){
               
       outFS2.println(key2[c]);
       b= b-1;
       c=c+1;
               
           }      
       }
       
        String [] FirstName = new String [10000];
        String [] LastName = new String [10000];
        String [] Birth = new String [10000];
        String [] Phone = new String [10000];
        String [] format = new String [10000];
        String [] Passcode = new String [10000];
        
        FirstName[1] = "Your Name";
        LastName[1] = "Your Name";
        Birth[1] =  "Your DOB";
        Phone[1] = "Your phone number";
        
        
        int i = 1;
        
         System.out.println("WELCOME TO THE MOVIES");
     System.out.printf("%nIf you would like to book a ticket press 1 %nIf you would like to view your ticket press 2 %n");
    int dec =  scnr.nextInt();
     switch(dec){
     case 1:
         System.out.printf("How many people would you like?");
         int count = scnr.nextInt();
         while(0<count){
         System.out.println("What is your First Name and last name");
         FirstName[i] = scnr.next();
         LastName[i] = scnr.next();
         System.out.println("What is your DOB");
         Birth[i] = scnr.next();
         System.out.println("What is your phone number");
         Phone[i] = scnr.next();
         System.out.println("what would you like your Password to be");
         Passcode[i]=scnr.next();
         
         format[i] = Format(FirstName[i],LastName[i],Birth[i],Phone[i],d);
         
         outFS.append(format[i]);
         outFS2.printf(Integer.toString(d) + "%n");
         outFS2.append("Pass: " + Passcode[i]);
         i= i+1;
         d= d+1;
         count= count-1;
         }
         break;
     case 2:
         outFS.close();
         outFS2.close();
         System.out.println("what is your ID:");
         try {
             String InputID = scnr.next();
             System.out.println("what is the password:");
             String inputpassword = scnr.next();
             FileReader FR2 = new FileReader("./src/project/Passcode.txt");
             BufferedReader reader = new BufferedReader(FR2);
             String TempHolder = " ";
             
             while(TempHolder != null){
                 TempHolder = reader.readLine();
                 
                 if (TempHolder.equals(InputID)){
                     TempHolder = reader.readLine();
                     
                     if (TempHolder.equals("Pass: " + inputpassword)){
                         
                         Scanner myReader = new Scanner(file);
                     String line = myReader.next();
                     System.out.println("-------------------------------");
                     int y = 0;
                         while (y==0) {
                 line = myReader.next();
                 if(line.equals(InputID)){
                    System.out.println("ID:"+line);
                    line = myReader.next();
                    System.out.println(line);
                    line = myReader.next();
                    System.out.println(line);
                    line = myReader.next();
                    System.out.println(line);
                    line = myReader.next();
                    System.out.println(line);
                    line = myReader.next();
                    System.out.println(line);
                    y=1;
                    
                 }
                     }
                     
                 }
                     else if(TempHolder == null){
                         System.out.println("Password incorrect");
                     }
                   
             } else if (TempHolder == null){
                  System.out.println("ID does not exist");
             }
                
         }
         }
         catch (Exception e){
             
         }
         break;
   
         
     case 12345:
         System.out.printf("%nWelcome Moderator");
         outFS.close();
         Maker maker = new Maker();
         maker.find();
         
     }
       
        
        outFS.close();
        outFS2.close();
    }
    
    public static String Format(String firstname, String lastname, String birth, String phone, int acc) {
        String f;
         f = String.format("------------------------------- %n%d%n  Name:%s %s%n Birth:%s %n Phone:%s%n-------------------------------%n", acc, lastname, firstname, birth, phone );
        
        return f;
    }
    
    
}