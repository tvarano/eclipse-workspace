//Thomas Varano
//Feb 20, 2018

package main;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Restarter {
   public static final String getExec() {
      if (System.getProperty("user.dir").indexOf(".app") > 0)
         return System.getProperty("user.dir").substring(0,
               System.getProperty("user.dir").indexOf(".app")) + ".app";
      return System.getProperty("user.dir");
   }

   public static void main(String[] args) {
      System.out.println();
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Thread.sleep(100);
               Desktop.getDesktop().open(new File(getExec()));
            } catch (IOException | InterruptedException e) {
               JOptionPane.showOptionDialog(null, "Error Restarting", "ERROR",
                     JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
                     null, null, null);
            }
         }
      });
   }
}