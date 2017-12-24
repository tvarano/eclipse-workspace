
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

//Thomas Varano
//Coding Assignment
//Sep 19, 2016

     //a) The first window displays your name, a message and a custom icon
     //b) The second window asks the user for a word
     //c) The third window displays the user's word in a different font then the previous windows
     //d) The fourth and fifth windows request two integer inputs using the original font
     //e) The sixth window displays the sum, product and quotient of the two input values

     //At least two different icons should be used to create your program.
     //Use a consistent color and font theme throughout the program.
     //Create a jar file from the completed code.

public class JOptionOne
{
   public static void main(String[] args)
   {
      ImageIcon Icon1 = new ImageIcon(JOptionOne.class.getResource("gifart1.gif"));
      ImageIcon Icon2 = new ImageIcon(JOptionOne.class.getResource("jacketman.gif"));
      Font prestige = new Font ("Prestige Elite Std", Font.BOLD, 20);
      Font caslon = new Font ("Big Caslon", Font.BOLD, 20);
              UIManager.put("OptionPane.messageForeground", Color.WHITE);    
              UIManager.put("Panel.background", Color.BLACK);                         
              UIManager.put("OptionPane.background", new Color (180,180,180));                 
              UIManager.put("OptionPane.messageFont", prestige);
              UIManager.put("TextField.font", prestige);           
      JOptionPane.showMessageDialog(null, "\n\tHi, I'm Thomas Varano, and this is \n\tmy JOptionPane Project.\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tWelcome!!",
                                    "Thomas Varano's Project",
                                    JOptionPane.PLAIN_MESSAGE,
                                    null); //PUT A THING
      
      String word1 = (String) JOptionPane.showInputDialog(null, "Please type a word.",
                                                "Thomas Varano's Project",
                                                JOptionPane.PLAIN_MESSAGE,
                                                Icon1,
                                                null,
                                                "Enter Word Here");
      
               UIManager.put("OptionPane.messageFont", caslon);
               UIManager.put("TextField.font", caslon);     
      
      JOptionPane.showMessageDialog(null, "Your word is:\n" + word1 +".\nCome up with something\ncreative next time.",
                                                "Thomas Varano's Project",
                                                JOptionPane.PLAIN_MESSAGE,
                                                Icon1);
    
               UIManager.put("OptionPane.messageFont", caslon);
               UIManager.put("TextField.font", caslon); 
               
      String int1 = (String) JOptionPane.showInputDialog(null, "Please type an integer.",
                                                "Thomas Varano's Project",
                                                JOptionPane.PLAIN_MESSAGE,
                                                Icon2,
                                                null,
                                                "Enter a number.");
                     double tin1 = Double.parseDouble(int1);

      String int2 = (String) JOptionPane.showInputDialog(null, "Please type another integer.",
                                                "Thomas Varano's Project",
                                                JOptionPane.PLAIN_MESSAGE,
                                                Icon2,
                                                null,
                                                "Enter a number.");
                     double tin2 = Double.parseDouble(int2);
                     
      JOptionPane.showMessageDialog(null, "The sum of your numbers is: " + (tin1+tin2) +
                                           "\nThe product of your numbers is: " + (tin1*tin2) + 
                                           "\nThe quotient of your numbers is " + (tin1/tin2)
                                           +"\n"+tin1+" + "+tin2+" = "+ (tin1+tin2),
                                             "Thomas Varano's Project",
                                             JOptionPane.PLAIN_MESSAGE,
                                             Icon2);
      
        if ((tin1+tin2) == 50) JOptionPane.showConfirmDialog(null, "You failed. Continue?","HWHE", JOptionPane.PLAIN_MESSAGE);
                     
         
                     
      
   }
}
