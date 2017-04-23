/*
Author: Neil Pasricha & Chris Williams
E-mail: nvp5119@psu.edu & ckw5071@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment #4
Due date: 4/28/2016
File: NewProblem.java
References: http://www.tutorialspoint.com/swing/swing_component_listener.htm - for helping build the GUI
Purpose: The NewProblem class extends the Calculator and implements the ActionListener and KeyListener. It's whole purpose is to handle the actions from pressing the 
         "New Problem" button. When the button is pressed it generates new variables and operands, as well as a new title in order to generate a new problem as a whole.
/**
 *
 * @author Neil
 */
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;


public class NewProblem extends Calculator implements ActionListener, KeyListener {

   public static JTextField answerInput;
   public JButton newProb;
   public static boolean didAnswer; 
   
   //Constructor with parameters
   public NewProblem(JButton newButton){
       newProb = newButton;
   }
   //Default constructor so NewProblem may be called from other classes
    public NewProblem(){}
    
    //actionPerformed goes through when the user clicks the button "New Problem". It triggers the randomNumGen() to create a new problem, and changes the JLabel next to it to
    //"Please enter your answer".
    @Override
    public void actionPerformed(ActionEvent newProblem) {
        Math math1 = new Math();
       String actionCommand = newProblem.getActionCommand();
       if(actionCommand.equals("New Problem")){
          didAnswer=false;
          tryCounter=1;
          prompt.setText("Please enter your answer.");
           math1.randomNumGen();
        }
       else
           System.exit(0);
        
    }
    
    
    //For overriding KeyListener 
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            
        }
    }
    //For overriding KeyListener 
    @Override
    public void keyReleased(KeyEvent arg0) {}
    //For overriding KeyListener     
    @Override
    public void keyTyped(KeyEvent arg0) {}
    
}
