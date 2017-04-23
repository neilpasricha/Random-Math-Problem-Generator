/*
Author: Neil Pasricha & Chris Williams
E-mail: nvp5119@psu.edu & ckw5071@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment #4
Due date: 4/28/2016
File: KeyEnter.java
References: http://www.tutorialspoint.com/swing/swing_component_listener.htm - for helping build the GUI
Purpose: The KeyEnter class is a child of the NewProblem class, therefore is a grandchild of the Calculator class. It handles the operations when the user presses the enter key to input
         their answer into the JTextfield box. If the user has already answered the question correctly, it prompts the user to press the "New Problem" button upon the user pressing the enter
         key more times. If the user enters nothing into the textbox (blank space), or letters, it tells the user to enter numbers only. It keeps track of how many times the user has 
         unsuccessfully tried to input the answer, and displays the total in the JLabel to the left once the problem has been solved. Pressing enter when there are letters or blank space will
         not add to the tryCounter [which keeps track of how many attempt sthe user has made at solving the problem].
         
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


public class keyEnter extends NewProblem implements ActionListener, KeyListener {

   public static JTextField answerInput;
   public int hasAnswered=0;
   
   //Constructor with parameters
   public keyEnter(JTextField textfield){
        answerInput = textfield;
    }
    
   //Default constructor for calling keyEnter from other classes
    public keyEnter(){
        
    }
    
    //The actionPerformed handles the solution to the equation generated which the user types into the textbox. This is triggered when the user presses the enter key. 
    //There is a counter to tell the program which type of math problem it is, and depending on which problem header was used to generate the problem, the actionPerformed
    //calls upon the actual methods of those problem types to handle the calculations. If the user enters nothing or blank space the JLabel will change to tell the user to 
    //enter numbers only. If the user successfully completes the problem, the actionPerformed will change the JLabel to tell the user to press the New Problem button and
    //generate a new question.
    @Override
    public void actionPerformed(ActionEvent submitClicked) {
        Math math1 = new Math();
        String enteredAnswer = answerInput.getText();
        
        //Tries to parse the answer as an Integer. If successful it continues with the if/else statements.
        try{
        int intAnswer = Integer.parseInt(enteredAnswer);
        
        if(didAnswer==false){
             if(mathType==1){
            math1.Addition(super.num1, super.num2, intAnswer);
            
            }
            else if(mathType==2){
            math1.Subtraction(super.num1, super.num2, intAnswer);
             }
            else if(mathType==3){
            math1.Multiplication(super.num1, super.num2, intAnswer);
            }
        
          }
        
        else if(didAnswer==true){
                prompt.setText("Please press the New Problem Button");
          }
        }
        
        //If the user inputted answer cannot be parsed as an Intger, it will change the JLabel to show "Please enters numbers only."
        catch(Exception e){
            prompt.setText("Please enter integers only.");
            
        }
        
        
        
    }
    
    //Overrides the KeyListener
    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }
    
    //Overrides the KeyListener
    @Override
    public void keyTyped(KeyEvent arg0) {

    }
}
