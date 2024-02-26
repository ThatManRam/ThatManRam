/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package windowtest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author Admin
 */
public class DVDBouncer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        createBouncyWindow();
        quit();
        
      
        
    }
    
    private static void createBouncyWindow() { 
        
    JFrame frame = new JFrame("Bouncing Box");
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLabel textLabel = new JLabel("watch me bounce",SwingConstants.CENTER);
    textLabel.setPreferredSize(new Dimension(300, 100));
    frame.getContentPane().add(textLabel, BorderLayout.CENTER);
    
    Container c = frame.getContentPane();

c.setBackground(Color.red);
    frame.setLocationRelativeTo(null);
    frame.pack();
    frame.setVisible(true);
    
    frame.setLocation(0, 0);
    Timer timer = new Timer(1, new ActionListener() {
        int x = 0;
    int y = 0;
    int count = 0;
    int bouncespeed = 7;
    boolean hitbottom = false;
    boolean hitright = false;
    Random rd = new Random();
    
        @Override
        public void actionPerformed(ActionEvent e) {
       
        if(hitbottom == true){
            y -= rd.nextInt(bouncespeed);
            if (y<=0){
                hitbottom = false;
            }
        }
        else{
             y+=rd.nextInt(bouncespeed);
            if (y >= 700){
                hitbottom = true;
            }
        }
        
        if ( hitright ==true){
            x-=rd.nextInt(bouncespeed);
            if (x<=0){
                hitright = false;
            }
        }
        else {
            
            x+=rd.nextInt(bouncespeed);
            if (x >= 1300){
                hitright = true;
            }
        }
        
        if (count == 10){
        c.setBackground(Color.getHSBColor(rd.nextFloat(255), rd.nextFloat(255), rd.nextFloat(255)));
        duplicate(x,y);
        count = 0;
        }
        frame.setAlwaysOnTop (true);
        frame.setLocation(x, y);
       
        
        
        count = count+1;
        
        
        
        }

    });
    
     timer.start();
    
    
    }
    
    private static void duplicate(int x, int y){
        JFrame frame2 = new JFrame("Duplicate");
        
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLabel textLabel = new JLabel("watch me bounce",SwingConstants.CENTER);
    textLabel.setPreferredSize(new Dimension(300, 100));
    frame2.getContentPane().add(textLabel, BorderLayout.CENTER);
    
    frame2.setLocationRelativeTo(null);
    Container c  = frame2.getContentPane();
Random rd = new Random();

c.setBackground(Color.getHSBColor(rd.nextFloat(255), rd.nextFloat(255), rd.nextFloat(255)));
    frame2.pack();
    frame2.setVisible(true);
    
    
    frame2.setLocation(x, y);
   frame2.setAlwaysOnTop (true);
    Timer timer = new Timer(1000, new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent evt) {
        frame2.dispose();
    }
});
timer.setRepeats(false);
timer.start();
        
    
    
}
    
    
    
    private static void quit(){
        
        JFrame frame = new JFrame("quit");
        frame.setPreferredSize(new Dimension(400, 100));
        JButton button = new JButton("if you want to quit press me");
    
    
  
    frame.setLocation(700, 300);
    frame.add(button);
  
  
  frame.pack();
    frame.setVisible(true);
  
     button.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
            System.exit(0);
        }  
    });  
  
   
      
        
      
} 

    
        
    }
    

