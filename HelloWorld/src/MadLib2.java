import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

//Thomas Varano
//JOption Mad Lib
//Oct 6, 2016

public class MadLib2
{
   public static void main(String[] args)
   {
             Font prestige = new Font ("Prestige Elite Std", Font.BOLD, 20);
               ImageIcon jack = new ImageIcon(MadLib2.class.getResource("jack.jpg"));
               ImageIcon adam1 = new ImageIcon(MadLib2.class.getResource("adam1.jpg"));
               ImageIcon adam2 = new ImageIcon(MadLib2.class.getResource("adam2.jpg"));
               ImageIcon adam3 = new ImageIcon(MadLib2.class.getResource("adam6.jpg"));
               ImageIcon adam4 = new ImageIcon(MadLib2.class.getResource("adam5.jpg"));
               UIManager.put("OptionPane.messageForeground", Color.WHITE);    
               UIManager.put("Panel.background", new Color (128,128,128));                         
               UIManager.put("OptionPane.background", new Color (60,191,225));                 
               UIManager.put("OptionPane.messageFont", prestige);
               UIManager.put("TextField.font", prestige);           

      String noun1 = (String) JOptionPane.showInputDialog(null, "Enter a noun.",
             "Mad Libs", JOptionPane.PLAIN_MESSAGE, adam1, null, "-----");
      String container = (String) JOptionPane.showInputDialog(null, "Enter a name of a container.",
            "Mad Libs", JOptionPane.PLAIN_MESSAGE, adam2, null, "-----");
      String liquid = (String) JOptionPane.showInputDialog(null, "Enter a liquid.",
            "Mad Libs", JOptionPane.PLAIN_MESSAGE, adam3, null, "-----");
      String noun2 = (String) JOptionPane.showInputDialog(null, "Enter a noun.",
            "Mad Libs", JOptionPane.PLAIN_MESSAGE, adam4, null, "-----");
      String person = (String) JOptionPane.showInputDialog(null, "Enter a celebrity.",
            "Mad Libs", JOptionPane.PLAIN_MESSAGE, adam1, null, "-----");
               noun1 = noun1.toUpperCase();
               container = container.toUpperCase();
               liquid = liquid.toUpperCase();
               noun2 = noun2.toUpperCase();
               person = person.toUpperCase();
      JOptionPane.showMessageDialog(null, "Jack and Jill went up the " + noun1 + " to fetch a(n) " + container + " of\n" + liquid + 
            ". Jack fell down and broke his " + noun2 +", and\n" + person + " came tumbling after.",
                        "Mad Libs", JOptionPane.PLAIN_MESSAGE, jack);
          
      System.exit(0);
      
   }
}
