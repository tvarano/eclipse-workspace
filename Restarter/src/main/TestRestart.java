//Thomas Varano
//[Program Descripion]
//Feb 1, 2018

package main;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

public class TestRestart {

   public static void restartApp() {
      try {
         Desktop.getDesktop().open(new File("/Applications/Agenda.app"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      System.exit(0);
   }
   
   public static void main(String[] args) {
      PathTest.setLog();
      JFrame f = new JFrame("Restarter");
      f.setVisible(true);
      f.setSize(100,100);
      try {
         Thread.sleep(500);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      restartApp();
   }
}
