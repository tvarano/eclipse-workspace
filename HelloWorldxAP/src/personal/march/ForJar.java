//Thomas Varano
//Mar 28, 2018

package personal.march;

import java.awt.EventQueue;

public class ForJar {
   // addPlayer
   public static void main(String[] args) {
      System.out.println("one");
      EventQueue.invokeLater(new Thread() {
         public void run() {
            System.out.println("oias");
            for (int i = 0; i < 5; i++)
               System.out.println(i);
            int four = (4);
         }
      });
      System.out.println("after thread");
   }
}
