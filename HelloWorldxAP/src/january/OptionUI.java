//Thomas Varano
//[Program Descripion]
//Jan 15, 2018

package january;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class OptionUI {

   public static void main(String[] args) {
      UIManager.put("OptionPane.messageForeground", Color.RED);
      UIManager.put("OptionPane.foreground", Color.GREEN);
      JOptionPane.showMessageDialog(null, "hi");
   }
}
