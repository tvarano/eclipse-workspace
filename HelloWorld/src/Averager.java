
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

//Thomas Varano
//Averager Program that actually works
//Sep 16, 2016

public class Averager
{
   
   public static void main(String[] args)
   {  
      ImageIcon Thisicon = new ImageIcon(Averager.class.getResource("imgres.jpg"));//bsave the file in the src folder,
      ImageIcon Mario = new ImageIcon(Averager.class.getResource("Mario.png"));
      ImageIcon Sponge = new ImageIcon(Averager.class.getResource("mehoy.jpg"));
      Font font1 = new Font("Times New Roman", Font.BOLD, 20);
      UIManager.put("OptionPane.messageForeground", Color.WHITE);    //Font color
      UIManager.put("Panel.background", Color.BLACK);                          //Main window background color
      UIManager.put("OptionPane.background", Color.RED);                 //Window border color
      UIManager.put("OptionPane.messageFont", font1);                          //Font for window message
      UIManager.put("TextField.font", font1);                                              //Font for inputMessageDialog boxes
            String name = (String) JOptionPane.showInputDialog(null, "Welcome to my Averager",
            "Averager",
            JOptionPane.QUESTION_MESSAGE,
            Thisicon,
                  null, 
                  "Type your name");
      String numa = (String) JOptionPane.showInputDialog(null, "Hi, " + name + ", Enter your first number.",
               "Averager",
               JOptionPane.PLAIN_MESSAGE,
               Thisicon,
               null,
               "[Enter number]");
                        double anum = Double.parseDouble(numa);

      String numb = (String) JOptionPane.showInputDialog(null, "Please enter your second number",
               "Averager",
               JOptionPane.PLAIN_MESSAGE,
               Mario,
               null,
               "[Enter another number]");
                        double bnum = Double.parseDouble(numb);
            
                JOptionPane.showMessageDialog(null, "The average is: " + (anum + bnum) / 2,
                      "Averager",
                      JOptionPane.PLAIN_MESSAGE,
                      Thisicon);
      if (anum == 23) {
         JOptionPane.showMessageDialog(null, "mehoymenoi",
               "the easter egg",
               JOptionPane.PLAIN_MESSAGE,
               Sponge);
      }
                
      System.exit(0);
      //String orange = (String) JOptionPane.showInputDialog(null,       //Parent Component... usually null
        //    "Please enter your name:",                                                        //Input prompt
          //  "This is the title of the actual frame",                                         //Frame title
            //JOptionPane.PLAIN_MESSAGE,                                               //Message type
         //   null,                                                                                            //Custom image for icon
           // null,                                                                                            //List of choices
           // null);                                                                                           //Default text for input
     
   }
}
