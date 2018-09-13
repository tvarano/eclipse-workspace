//Thomas Varano
//May 24, 2018

package personal.april;

import javax.swing.JOptionPane;

public class Option {
   public static void main(String[] args) {
      JOptionPane j = new JOptionPane("hello", JOptionPane.PLAIN_MESSAGE);
      j.setVisible(true);
      try {
         Thread.sleep(1000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      j.setVisible(false);
      
   }
}
