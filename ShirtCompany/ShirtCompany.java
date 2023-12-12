/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shirtcompany;


import java.time.LocalTime;
import java.util.*;

/**
 *
 * @author Admin
 */
public class ShirtCompany {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner scnr = new Scanner(System.in);
         
        HashMap<Integer, String> ProductH = new HashMap<Integer, String>();
        HashMap<Integer, String> ProductH2 = new HashMap<Integer, String>();
        HashMap<Integer, String> ProductH3 = new HashMap<Integer, String>();
        
        ArrayList<String> Names = new ArrayList<String>();
        ArrayList<String> Prices = new ArrayList<String>();
        ArrayList<String> Dates = new ArrayList<String>();
        
        ArrayList<String> pants =new ArrayList<String>();
        ArrayList<String> jeans =new ArrayList<String>();
        ArrayList<String> tshirt =new ArrayList<String>();
        ArrayList<String> shirt =new ArrayList<String>();
        
         
         
         try {
              boolean begin = true;
              boolean firstTime = true;
           while (begin){
               System.out.println("Hello! and welcome to A&R Co! \nWould you like to add or delete or sort or view the products");
               String dec = scnr.next();
               
               switch(dec){
                   case "add":
                       System.out.println("how many items would you like to add?");
                       while(firstTime){
                        String [] groups = {"pants", "jeans", "t-shirt", "shirt"};
                        Random random = new Random();
                        int select = random.nextInt(groups.length); 
                        String group = groups[select];
                        for(int i = 10000; i>0; i--){
                            int namenum = (int)Math.floor(Math.random() * (20 - 0 + 1));
                            String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                            StringBuilder s = new StringBuilder(namenum);
                            for ( int y = 0; y < namenum; y++) {
                                // generating a random number
                                int index = (int)(AlphaNumericString.length()* Math.random());
                                // add Character one by one in end of s
                                s.append(AlphaNumericString.charAt(index));
                                }
                          
                        String name = s.toString();
                       
                        double price = (double)Math.floor(Math.random() * (99.99 - 0.01 + 0.01));
                        
                        
                        
                        Product product = new Product(name,price,group);
                        product.IDchecker(ProductH);
                        ProductH.put(product.ID, product.Full);
                        ProductH2.put(product.ID, product.Full2);
                        ProductH3.put(product.ID, product.Full3);
                        Names.add(product.Full);
                        Prices.add(product.Full2);
                        Dates.add(product.Full3);
                       }
                        firstTime = false;
                       }
                       for(int i = scnr.nextInt(); i>0; i--){

                        System.out.println("what the name of this product?");
                        String name = scnr.next();
                        
                        boolean priceCheck = true;
                        double price = 0;
                        while(priceCheck){
                        System.out.println("what is the price of the product?");
                        
                        if(price >0){
                        price = scnr.nextDouble();
                        }else{
                            System.out.println("that is not a number");
                        }
                        }
                        System.out.println("what group would you like to add it pants,jeans,t-shirt,shirt");
                        boolean groupDec = true;
                        String dec2 = "";
                        Product groupP = new Product(name,price,dec2);
                        
                        LocalTime startTime_INS = LocalTime.now(); // starting time to measure insertion operation
                        //the time complexity of Hashmap insertion is O(1) and for arrayList is O(1)
                        while(groupDec){
                            dec2 = scnr.next();
                            switch(dec2){
                                case "pants":
                                case "Pants":
                                    pants.add(groupP.Full);
                                    groupDec = false;
                                    break;
                                case "jeans":
                                case "Jeans":
                                    jeans.add(groupP.Full);
                                    groupDec = false;
                                    break;
                                case "t-shirt":
                                case "T-shirt":                            
                                case "tshirt":
                                case "Tshirt":
                                   tshirt.add(groupP.Full); 
                                    groupDec = false;
                                    break;
                                case "shirt":
                                case "Shirt":
                                    tshirt.add(groupP.Full);
                                    
                                    groupDec = false;
                                    break;
                               
                                default:
                                groupDec = true;

                            }
                            LocalTime endTime_INS = LocalTime.now(); // ending time to measure search operation
                            int nanoTime_DIFF = endTime_INS.getNano() - startTime_INS.getNano();
                            System.out.println("Inserting items takes " + nanoTime_DIFF + " nanos." + "\n\n");
                        }
                        
                        Product product = new Product(name,price,dec2);
                        product.IDchecker(ProductH);
                        ProductH.put(product.ID, product.Full);
                        ProductH2.put(product.ID, product.Full2);
                        ProductH3.put(product.ID, product.Full3);
                        Names.add(product.Full);
                        Prices.add(product.Full2);
                        Dates.add(product.Full3);
                        System.out.println("the ID of this product is " + product.ID);
                       }
                       break;
                   //For searhing
                       case "view":
                           
                           // the time complexity for searching on hashmap is O(1)
                           boolean viewcheck = true;
                           while(viewcheck){
                       System.out.println("what product would you like to view");
                       int dec2 = scnr.nextInt();
                       if (ProductH.containsKey(dec2)){
                           System.out.println(ProductH.get(dec2));
                           viewcheck = false;
                       }
                       else{
                           System.out.println("this product does not exist");
                       }
                           
                           }
                           
                       break; 
                       
                       
                   case "delete":
                       LocalTime startTime_DEL = LocalTime.now(); // starting time to measure Deletion operation
                       // the time complexity for deleting in hashmap is O(1) and for array list is O(1)
                       boolean delete = true;
                       while(delete){
                           System.out.println("what ID would you like to delete?");
                           String dec5 = scnr.next();
                         if (ProductH.containsKey(Integer.valueOf(dec5))){
                             Prices.remove(ProductH2.get(Integer.valueOf(dec5)));
                             ProductH2.remove(Integer.valueOf(dec5));
                             Dates.remove(ProductH3.get(Integer.valueOf(dec5)));
                             ProductH3.remove(Integer.valueOf(dec5));
                             Names.remove(ProductH.get(Integer.valueOf(dec5)));
                             ProductH.remove(Integer.valueOf(dec5));
                             
                             delete = false;
                         }
                         else if(dec5.equals("I dont know")){
                             delete = false;
                         }
                         else{
                             System.out.println("if you do not know the ID type \"I dont know\"");
                         }
                       }
                       LocalTime endTime_DEL = LocalTime.now(); // ending time to measure search operation
                        int nanoTime_DIFF_DEL = endTime_DEL.getNano() - startTime_DEL.getNano();
                        System.out.println("Deleting items takes " + nanoTime_DIFF_DEL + " nanos." + "\n\n");
                       
                       break;
                 
                       
                   case "sort":
                       
                       // the time complexity for sorting in arrayList in ascending O(nlogn) is O(nlogn) and for decending O(logn)
                       boolean sortcheck = true;
                       while(sortcheck){
                            System.out.println("would you like to sort the products by name,date,group or price?");
                            String dec3 = scnr.next();
                            String dec4 = "";
                            if (!dec3.equals("group")){
                            System.out.println("would you like to sort the products in ascending or descending order?");
                            boolean checker = true;
                           
                            while(checker){
                                dec4 = scnr.next();
                                
                                switch (dec4) {
                                    case "ascending":
                                        checker=false;
                                        break;
                                    case "descending":
                                        checker=false;
                                        break;
                                    default:
                                        System.out.println("you did not input a valid answer");
                                        break;
                                }
                            }
                            }

                            switch(dec3){
                                case"name":
                                    if(dec4.equals("ascending")){
                                        Collections.sort(Names);

                                        System.out.println(Names);
                                        sortcheck = false;
                                    }
                                    else if(dec4.equals("descending")){
                                        Collections.sort(Names, Collections.reverseOrder()); 

                                        System.out.println(Names);
                                         sortcheck = false;
                                    }
                                    break;

                                 case"date":
                                     if(dec4.equals("ascending")){
                                        Collections.sort(Dates);

                                        System.out.println(Dates);
                                         sortcheck = false;
                                    }
                                    else if(dec4.equals("descending")){
                                        Collections.sort(Dates, Collections.reverseOrder()); 

                                        System.out.println(Dates);
                                         sortcheck = false;
                                        
                                    }
                                    break;

                                 case"group":
                                    System.out.println("what group would you like to Sort");
                                    boolean sortChecker = true;
                                    while(sortChecker){
                                    String dec6 = scnr.next();
                            switch(dec6){
                                case "pants":
                                case "Pants":
                                    Collections.sort(pants);
                                    System.out.println(pants);
                                    sortcheck = false;
                                    sortChecker = false;
                                    break;
                                case "jeans":
                                case "Jeans":
                                    Collections.sort(jeans);
                                    System.out.println(jeans);
                                    sortcheck = false;
                                    sortChecker = false;
                                    break;
                                case "t-shirt":
                                case "T-shirt":                            
                                case "tshirt":
                                case "Tshirt":
                                    Collections.sort(tshirt);
                                    System.out.println(tshirt);
                                    sortcheck = false;
                                  sortChecker = false;
                                    break;
                                case "shirt":
                                case "Shirt":
                                    Collections.sort(shirt); 
                                    System.out.println(shirt);
                                    sortcheck = false;
                                   sortChecker = false;
                                    break;
                               
                                default:
                                System.out.println("that group does not exist");

                            }
                            
                                    }
                                    break;

                                 case"price":
                                    if(dec4.equals("ascending")){
                                        Collections.sort(Prices);

                                        System.out.println(Prices);
                                    }
                                    else if(dec4.equals("descending")){
                                        Collections.sort(Prices, Collections.reverseOrder()); 

                                        System.out.println(Prices);
                                    }
                                    break;

                                 default:


                            }
                       }
                           
                       
                       break;
                   case "end":
                       begin = false;
                       
                       break;
                   default:
                       begin = true;
               }
           }
         }
         catch (Exception e){
             
             
         }

             
           
         
    }
    
}
