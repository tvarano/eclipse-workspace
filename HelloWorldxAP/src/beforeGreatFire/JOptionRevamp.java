package beforeGreatFire;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

//Thomas Varano
//[Program Descripion]
//Oct 23, 2017

public class JOptionRevamp
{
   
   
   public static void main(String[] args) {
      String[] buttons = {"one", "towo", "the", "fo", "fai"};
      JOptionPane.showInputDialog(null, 
            "oi", 
            "titless",
            JOptionPane.PLAIN_MESSAGE,
            null, new String[]{"one", "twi", "twreee"}, null);
     UIManager.put("Button.light", Color.GREEN);
     JOptionPane.showOptionDialog(null, 
           "options", 
           "titless", 
           JOptionPane.YES_NO_CANCEL_OPTION, 
           JOptionPane.NO_OPTION, null, buttons, buttons[0]);
   }
}
