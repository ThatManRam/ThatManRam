/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.imagegenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


/**
 *
 * @author Ram
 */
public class ImageGenerator {

    public static void main(String[] args) throws IOException {
        Random rd  = new Random();
System.out.print("What is the file path of the original image you would like to change"); 

final String OriginalImage = "./src/main/java/com/mycompany/imagegenerator/Dog.jpg";

   
String imagetype = "jpg";

 File file = new File("outputImage.jpg");
 
 if(!file.exists()){
     file.createNewFile();
 }

    JFrame frame = new JFrame("Bouncing Box");
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    frame.setVisible(true);
    frame.setSize(500, 500);
    JButton button = new JButton("would you like to change the images color");
    frame.add(button);
       button.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent a){ 
    
    int color = rd.nextInt();
    
    
try  {
           
    file.createNewFile();
            FileInputStream fileInputStream;
            
            fileInputStream = new FileInputStream(OriginalImage);

            // Load the image metadata to create a BufferedImage
            BufferedImage originalImage = ImageIO.read(fileInputStream);
            
          
            // Process the image
            processImage(originalImage,color);
            
            // Write the processed image to file
            ImageIO.write(originalImage, imagetype, new File(file.getPath()));
                 JFrame frame = new JFrame("Picture");
        frame.setSize(600, 600);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
         ImageIcon image1 = new ImageIcon(file.getPath());
        
         
        frame.add(new JLabel(image1));
        frame.setVisible(true); 
       
                
            
        } catch (IOException e) {
            e.printStackTrace();
        }
//        
           
                
                
       
         
        }  
    }); 

       
       
    }
    private static void processImage(BufferedImage image, int color) {
        int width = image.getWidth();
        int height = image.getHeight();
        int temp;
       
        
        // Process the image pixel by pixel
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                temp = image.getRGB(x, y);
               
                
                image.setRGB(x, y,temp+color);//(temp >> color)
                //10 is cool
            }
        }
        
    }
    
}
