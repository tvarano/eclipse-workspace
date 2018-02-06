//Thomas Varano
//[Program Descripion]
//Feb 1, 2018

package main;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.management.ManagementFactory;
import java.util.List;

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
   
   public static void findArgs() {
      setLog();
      // java binary
      String java = System.getProperty("java.home") + "/bin/java";
      // vm arguments
      List<String> vmArguments = ManagementFactory.getRuntimeMXBean()
            .getInputArguments();
      StringBuffer vmArgsOneLine = new StringBuffer();
      for (String arg : vmArguments) {
         // if it's the agent argument : we ignore it otherwise the
         // address of the old application and the new one will be in
         // conflict
         if (!arg.contains("-agentlib")) {
            vmArgsOneLine.append(arg);
            vmArgsOneLine.append(" ");
         }
      }
      // init the command to execute, add the vm args
      final StringBuffer cmd = new StringBuffer(
            "\"" + java + "\" " + vmArgsOneLine);

      // program main and program arguments
      String[] mainCommand = System.getProperty(SUN_JAVA_COMMAND).split(" ");
      // program main is a jar
      if (mainCommand[0].endsWith(".jar")) {
         // if it's a jar, add -jar mainJar
         cmd.append("-jar " + new File(mainCommand[0]).getPath());
      } else {
         // else it's a .class, add the classpath and mainClass
         cmd.append("-cp \"" + System.getProperty("java.class.path") + "\" "
               + mainCommand[0]);
      }
      // finally add program arguments
      for (int i = 1; i < mainCommand.length; i++) {
         cmd.append(" ");
         cmd.append(mainCommand[i]);
      }

      System.out.println(cmd.toString());
      JFrame f = new JFrame("oi");
      f.setVisible(true);
      f.setSize(100, 100);
   }

   public static void main(String[] args) {
      TestRestart.main(args);
   }
}
