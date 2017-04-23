/*
Title:

Name: Neil Pasricha

Class: 

Date: 

*/
import java.util.*;


/*
Author: Neil Pasricha & Chris Williams
E-mail: nvp5119@psu.edu & ckw5071@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment #4
Due date: 4/28/2016
File: Driver.java
References: http://www.tutorialspoint.com/swing/swing_component_listener.htm - for helping build the GUI
Purpose: The Driver class extends the Math class, and is at the bottom of the Calculator family line. It simply contains the main method for starting the program. 
         It creates an instance of the Calculator class as well as the Math class, to generate the GUI as well as generate a random math problem to solve. 
         
/**
 *
 * @author Neil
 */
public class Driver extends Math {
    
     public static void main(String[] args){
        //Creates instance of Calculator class 
        Calculator c1 = new Calculator();
        //Creates instance of Math class 
        Math m1 = new Math();
         //Calls upon the prepareGUI() method which generates the GUI for the program
         c1.prepareGUI();
         //Calls upon the randomNumGen() method which generates the type of equation as well as the variables to be used in the program.
         //randomNumGen() will call upon other methods in order to allow the program to proceed
         m1.randomNumGen();
       
    }
    
}
