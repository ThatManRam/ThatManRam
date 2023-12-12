/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;
import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class Maker {
        public int num;
    
  public void find() throws IOException{
      Scanner scnr = new Scanner(System.in);
      System.out.printf("%nwould you like to view or remove a user%n");
      try {
          int x = 0;
          while (x == 0){
              String dec = scnr.next();
                 FileReader FR = new FileReader("./src/project/Output.txt");
                 
                 
             Scanner myReader = new Scanner(FR);
             int y = 0;
             String line = myReader.next();
          switch(dec){
              case "view":
                  System.out.printf("%nwhat ID number would you like to view?%n");
                  x=1;
                  num = scnr.nextInt();
                  String num2 = Integer.toString(num);
                  
             while (y==0) {
                 line = myReader.next();
                 if(line.equals(num2)){
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
             
            break;
              case "remove":
                x=1;
                  System.out.printf("%nwhat ID number you would like to remove?%n");
                  num = scnr.nextInt();
                  String num3 = Integer.toString(num);
                  while (y==0) {
                 line = myReader.next();
                 if(line.equals(num3)){
                     
                    System.out.println("ID:"+line);
                    String line2 = myReader.next();
                    System.out.println(line2);
                    String line3 = myReader.next();
                    System.out.println(line3);
                    String line4 = myReader.next();
                    System.out.println(line4);
                    String line5 = myReader.next();
                    System.out.println(line5);
                    String line6 = myReader.next();
                    System.out.println(line6);
                    
                    System.out.printf("%n%nare you sure you want to remove this? Y/N%n");
                    String dec2 = scnr.next();
                    switch(dec2){
                        case "Y":
                            
                            FileReader FR2 = new FileReader("./src/project/Output.txt");
                            BufferedReader reader = new BufferedReader(FR2);
                            
                            String TempHolder = " ";
                           
                            String [] key = new String [10000];
                            int count2 = 0;
                            int b = 0;
                            int c = 0;
                           
                            
                           
                            
                            while(TempHolder != null){
                                TempHolder = reader.readLine();
                                
                                if (TempHolder.equals(line)|| count2 == 1 ||count2 == 2 ){
                                    reader.readLine();
                                    count2 = count2 +1;
                                }
                                else{
                                    
                                key[b] = TempHolder;
                                
                               System.out.print(key[b]);
                                b=b+1;
                                
                                }
                                
                                
                            }
                           
                          
                            
                           
                         
                            
                            break;
                            
                        case "N":
                            
                            break;
                    }
                    
                    
                    y=1;
                    break;
                 }
              
                  }
              default:
                 x=0;
             }
                     
              
          }
          
          
          
      }
      catch (Exception e){
          
      }
      
  }
}
