/*
Author: Neil Pasricha & Chris Williams
E-mail: nvp5119@psu.edu & ckw5071@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment #4
Due date: 4/28/2016
File: Calculator.java
References: http://www.tutorialspoint.com/swing/swing_component_listener.htm - for helping build the GUI
Purpose: The Calculator class is the Super class to which all other classes inherit from. It creates the GUI and allows other classes to change some of the properties of it. 
         The program generates a random equation which can be either addition, subtraction, or multiplication. It then generates two random numbers between 1 and 10 to be the variables
         of that equation. It contains input validation checks for the JTextfield, and will generate a new equation with random variables upon the press of the "New Problem" button.
         The equations use integers only, and will prompt the user to only enter integers if other forms of input are found.
/**
 *
 * @author Neil
 */
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
public class Calculator extends JFrame {
    
    public final int WIDTH=400;
    public final int HEIGHT =200;
    public final int NUMBER_OF_DIGITS=3;
    public static int num1=0, num2=0, mathType=0, tryCounter=1;
    public JFrame mainFrame;
    public static JLabel headerLabel = new JLabel("", JLabel.CENTER);
    public static JLabel prompt= new JLabel("Please enter your answer.");
    public JPanel controlPanel;
    public JPanel buttonPanel;
    public JTextField enterAnswer;
  
    
    //Creates the GUI
    public void prepareGUI(){
       
        //Creates the JFrame with the title of "Math Tutor", sets the grid layout and default close operation
        mainFrame = new JFrame("Math Tutor");
        mainFrame.setSize(WIDTH,HEIGHT);
        mainFrame.setLayout(new GridLayout(3,1));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       //Control Panel adds the prompt and textBox, with a cyan background
       controlPanel = new JPanel();
       controlPanel.setLayout(new FlowLayout());
       controlPanel.setBackground(Color.CYAN);
       
       
       //Button Panel adds the "New Problem" button
       buttonPanel = new JPanel();
       buttonPanel.setLayout(new FlowLayout());
       buttonPanel.setBackground(Color.CYAN);
       
        //Adds New Problem button and adds a listener for it under the class SubmitButton
        JButton newProblem = new JButton("New Problem");
        NewProblem listener1 = new NewProblem(newProblem);
        newProblem.addActionListener(listener1);
        
        //Adds the text field and adds a listener for it under the class keyEnter
        JTextField userText = new JTextField(5);
        keyEnter listener = new keyEnter(userText);
        userText.addActionListener(listener);
        
        //Adds the prompt, textbox, and newProblem buttons to the control/button panels
        controlPanel.add(prompt);
        controlPanel.add(userText);
        buttonPanel.add(newProblem,BorderLayout.SOUTH);
       
        //Adds the headerLabel, controlPanel, and buttonPanel to the mainframe
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(buttonPanel);
        
        //Sets the background color of the mainFrame to cyan
        mainFrame.getContentPane().setBackground(Color.CYAN);
        //Makes the mainframe visible
        mainFrame.setVisible(true);
        
    }
    
    
    
}
