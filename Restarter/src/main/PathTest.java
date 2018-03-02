//Thomas Varano
//[Program Descripion]
//Feb 1, 2018

package main;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JFrame;

public class PathTest {
   public static final String SUN_JAVA_COMMAND = "sun.java.command";
   public static final String ROUTE = System.getProperty("user.home")
         + "/Desktop/Restarter/LogFile.txt";

   public static void setLog() {
      try {
         File log = new File(ROUTE);
         PrintStream logStream = new PrintStream(log);
         System.setOut(logStream);
         System.setErr(logStream);
         System.out.println("logs set");
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {
      JFrame f = new JFrame("path test");
      f.setVisible(true);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLog();
      System.out.println("user.dir" + System.getProperty("user.dir"));
      System.out.println("java.home" + System.getProperty("java.home"));
      System.out.println("java.class.path" + System.getProperty("java.class.path"));
      
   }
}
