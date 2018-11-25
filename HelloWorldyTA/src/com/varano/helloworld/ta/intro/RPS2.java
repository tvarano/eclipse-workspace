package com.varano.helloworld.ta.intro;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

//Mr. Uhl
//Program description: 
//Oct 25, 2018

public class RPS2
{
   public static void rpsColors()
   {
      Font font1 = new Font("Cooper Black", Font.PLAIN, 30);
      Font font2 = new Font("Curlz MT", Font.PLAIN, 36);

      ImageIcon myIcon = new ImageIcon(RPS2.class.getResource("rps_1.jpeg"));
      ImageIcon myIcon1 = new ImageIcon(RPS2.class.getResource("rps_end.jpeg"));
      
      UIManager.put("OptionPane.messageForeground", Color.BLUE);   //Font color
      UIManager.put("Panel.background", Color.WHITE);              //Main window background color
      UIManager.put("OptionPane.background", Color.WHITE);         //Window border color
      UIManager.put("OptionPane.messageFont", font1);              //Font for window message
      UIManager.put("TextField.font", font2);                      //Font for inputMessageDialog boxes

      int entry;
      do
      {
         int computerChoice;
         int playerChoice;
         String message = "A GAME BY ME!\nChoose your weapon!";
         do
         {
            computerChoice = (int)(Math.random()*3);
            String[] options = {"SCISSOR", "PAPER", "ROCK"};
            playerChoice = JOptionPane.showOptionDialog(null, 
                  message,
                  "ROCK-PAPER-SCISSOR",
                  JOptionPane.YES_NO_OPTION,
                  JOptionPane.NO_OPTION,
                  myIcon,
                  options,
                  options[(int)(Math.random()*3)]);
            
            message = "<html>Your choice: <span><font color = \"RED\">" 
                  + options[playerChoice]
                  + "<br></span>Computer chooses: <font color = \"RED\">" 
                  + options[computerChoice] + "</html>";
            
            if(computerChoice == playerChoice)
               message += "\n\n<html><span><font color = \"PURPLE\">It's a TIE!</span></html>\n\nChoose again.";
            
         } while(computerChoice == playerChoice);   
         //scissors = 0, paper =1, rock = 2
         if (playerChoice - computerChoice == -1
               || playerChoice - computerChoice == 2)
            message += "\n\n<html><span><font color = \"GREEN\">YOU WIN!</span></html>\n\nPLAY AGAIN?";
         else
            message += "\n\n<html><span><font color = \"RED\">YOU LOSE!</span></html>\n\nPLAY AGAIN?";
         
         String[] options1 = {"PLAY AGAIN", "QUIT"};
         entry = JOptionPane.showOptionDialog(null, message,
               "GAME OVER",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.NO_OPTION,
               myIcon1,
               options1,
               options1[0]);
         
      } while(entry==0);
      System.exit(0);
   }
   
   public static void main(String[] args)
   {
      rpsColors();
   }
}