/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shirtcompany;
import java.util.*;
/**
 *
 * @author Admin
 */
public class Product {
    long millis=System.currentTimeMillis(); 
    java.sql.Date date = new java.sql.Date(millis);       
    
    
    
    private String name;
    private double Price;
    public String Group;
    public int ID ;
    public String Full;
    public String Full2;
    public String Full3;

   public Product(String Name, double price, String group){ 
           
      name = Name;
      Price = price;
      Group = group;
      ID = (int)Math.floor(Math.random() * (9999999 - 0 + 1));
      
      Full = "\n"+"Name:" + name + "-Price:" + Price + "-Group:" + Group + "-ID:" + ID + "-Date added:" + date.toString() + "\n";
      Full2 = "\n"+"Price:" + Price + "-Name:" + name + "-Group:" + Group + "-ID:" + ID + "-Date added:" + date.toString() + "\n";
      Full3 = "\n"+"Date added:" + date.toString() + "-Price:" + Price + "-Name:" + name + "-Group:" + Group + "-ID:" + ID + "\n";     
   }
   public void IDchecker(HashMap hash){
       
       while(hash.containsKey(ID)){
           ID = ID++;
       }
   }
    
}

 


