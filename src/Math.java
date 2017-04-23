/* 
Author: Neil Pasricha & Chris Williams
E-mail: nvp5119@psu.edu & ckw5071@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment #4
Due date: 4/28/2016
File: Math.java
References: http://www.tutorialspoint.com/swing/swing_component_listener.htm - for helping build the GUI
Purpose: The Math class handles the arithmetic behind the program. It extends the keyEnter class and is therefore in the family tree of the Calculator class.
         It generates numbers to be used in the 3 types of equations and handles the sum checking to ensure the user entered answer is correct. 
/**
 *
 * @author Neil
 */

import java.util.Random;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.*;
public class Math extends keyEnter{
   
   
  //randomNumGen() begins by generating a number from 1-3 to pick which type of problem (addition, subtraction, multiplication), and then proceeds to generate 2 more numbers
  //ranging from 1-10. These two numbers are the operands to be used in the problems. It pulls from the java.util.Random in order to generate these numbers.
  //Once the numbers have been generated it calls upon the whichType method to proceed.
    public void randomNumGen(){
         
        Random typeRand = new Random();
        int type = typeRand.nextInt(3)+1;
        Random opeRand1 = new Random();
        int operRand1 = opeRand1.nextInt(10)+1;
        Random opeRand2 = new Random();
        int operRand2 = opeRand2.nextInt(10)+1;
        num1=operRand1;
        num2=operRand2;
       
       whichType(type, operRand1, operRand2);
        
    }
    
    //The whichType method takes as input the three randomly generated numbers, setting the type of problem number to x and the other two to y and z. 
    //If the number 1-3 for type is 1 it will call upon the additionHeader, 2 for the subtractionHeader, and 3 for the multiplicationHeader.
    public void whichType(int x, int y, int z){
          if(x==1){
             AdditionHeader(y,z);
            mathType=1;
        }
        else if (x==2){
            SubtractionHeader(y,z);
            mathType=2;
        }
        else if(x==3){
            MultiplicationHeader(y,z);
            mathType=3;
        }
         
      
            
    }
    
    //The AdditionHeader changes the header at the top (the equation) to reflect the randomly generated numbers for the variables. The order of the variables does not matter
    //but they are by default arranged as variable1 + variable2
    public void AdditionHeader(int variable1, int variable2){
       
        headerLabel.setText("How much is " + variable1 + " plus " + variable2 + "?");
        
        
    }
    
    //The SubtractionHeader changes the header at the top (the equation) to reflect the randomly generated numbers for the variables. 
    //The order of this equation however does matter and as such it will set the variables in the header based on the higher number. 
    //If the first number is greater than the second, it will be shown first (ex. 7-5 instead of 5-7), if the second number is greater than 
    //the first, it will be shown first instead to ensure a valid subtraction equation.
    public void SubtractionHeader(int variable1, int variable2){
       
        if(variable1>=variable2){
         headerLabel.setText("How much is " + variable1 + " minus " + variable2 + "?");
        }
        else if(variable2>=variable1){
            headerLabel.setText("How much is " + variable2 + " minus " + variable1 + "?");
        }
         
       
    }
    //The MultiplicationHeader changes the header at the top (the equation) to reflect the randomly generated numbers for the variables. The order of the variables does not matter
    //but they are by default arranged as variable1 * variable2
    public void MultiplicationHeader(int variable1, int variable2){
         
         headerLabel.setText("How much is " + variable1 + " times " + variable2 + "?");
         
         
    }
    
    //The Addition method is the arithmetic method for checking the user input sum for the equation. 
    //If the user enters the correct answer (userSum==sum), it will change the JLabel to reflect that. 
    //If not (userSum!=sum), it will change the JLabel to reflect that as well as increase the tryCounter+1.
    public void Addition(int variable1, int variable2, int userSum){
        int sum = variable1+variable2;
       
        if(userSum==sum){
            if(tryCounter>1){
            prompt.setText("Very good! It only took you " + tryCounter + " tries");
            tryCounter=1;
            didAnswer=true;
            }
            else if (tryCounter==1){
                prompt.setText("Very good! It only took you " + tryCounter + " try");
            tryCounter=1;
            didAnswer=true;
            }
        }
        else if(userSum!=sum){
            prompt.setText("I'm sorry, but no. Please try again.");
            tryCounter++;
                
        }
        
    }
    
    //The Subtraction method is the arithmetic method for checking the user input difference for the equation. 
    //If the user enters the correct answer (userSum==sum), it will change the JLabel to reflect that. 
    //If not (userSum!=sum), it will change the JLabel to reflect that as well as increase the tryCounter+1.
    //If variable 1 is greater than variable 2, it handles the difference as variable1-variable2, and vice versa.
    public void Subtraction(int variable1, int variable2, int userDifference){
       
        int difference;
        
        if(variable1>=variable2){
        difference=variable1-variable2;
         }
        else {
            difference=variable2-variable1;
        }
        
        if(userDifference==difference){
            if(tryCounter>1){
            prompt.setText("Very good! It only took you " + tryCounter + " tries");
            tryCounter=1;
            didAnswer=true;
            }
            else if (tryCounter==1){
            prompt.setText("Very good! It only took you " + tryCounter + " try");
            tryCounter=1;
            didAnswer=true;
            }
        }
        else if(userDifference!=difference){
            prompt.setText("I'm sorry, but no. Please try again.");
            tryCounter++;
                
        }
        
    }
    
    //The Multiplication method is the arithmetic method for checking the user input product for the equation. 
    //If the user enters the correct answer (userSum==sum), it will change the JLabel to reflect that. 
    //If not (userSum!=sum), it will change the JLabel to reflect that as well as increase the tryCounter+1.
    public void Multiplication(int variable1, int variable2, int userProduct){
        int product = variable1*variable2;
        
        if(userProduct==product){
            if(tryCounter>1){
            prompt.setText("Very good! It only took you " + tryCounter + " tries");
            tryCounter=1;
            didAnswer=true;
            }
            else if (tryCounter==1){
                prompt.setText("Very good! It only took you " + tryCounter + " try");
            tryCounter=1;
            didAnswer=true;
            }
        }
        else if(userProduct!=product){
            prompt.setText("I'm sorry, but no. Please try again.");
            tryCounter++;
            
                   
        }
        
    }
    
}
