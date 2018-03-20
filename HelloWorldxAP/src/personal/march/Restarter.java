//Thomas Varano
//Feb 25, 2018

package personal.march;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Restarts the application if in jar or classpath mode.
 * @author Thomas Varano
 *
 */
public class Restarter {
   /**
    * Sun property pointing the main class and its arguments. Might not be defined
    * on non Hotspot VM implementations.
    */
   public static final String SUN_JAVA_COMMAND = "sun.java.command";

   /**
    * Restart the current Java application
    * however, only if the program is run through eclipse or with a classPath
    * 
    * @param runBeforeRestart
    *            some custom code to be run before restarting
    * @throws IOException
    */
   private static void restartCP(Runnable runBeforeRestart) {
      try {
         // java binary
         String java = System.getProperty("java.home") + "/bin/java";
         // vm arguments
         List<String> vmArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
         StringBuffer vmArgsOneLine = new StringBuffer();
         for (String arg : vmArguments) {
            // if it's the agent argument : we ignore it otherwise the
            // address of the old application and the new one will be in conflict
            if (!arg.contains("-agentlib")) {
               vmArgsOneLine.append(arg);
               vmArgsOneLine.append(" ");
            }
         }
         // init the command to execute, add the vm args
         final StringBuffer cmd = new StringBuffer("" + java + " " + vmArgsOneLine);

         // program main and program arguments
         String[] mainCommand = System.getProperty(SUN_JAVA_COMMAND).split(" ");
         // only running if its a classpath
         cmd.append("-cp " + System.getProperty("java.class.path") + " " + mainCommand[0]);
         // finally add program arguments
         for (int i = 1; i < mainCommand.length; i++) {
            cmd.append(" ");
            cmd.append(mainCommand[i]);
         }
         // execute the command in a shutdown hook, to be sure that all the
         // resources have been disposed before restarting the application
         Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
               try {
                  Runtime.getRuntime().exec(cmd.toString());
               } catch (IOException e) {
                  e.printStackTrace();
               }
            }
         });
         // execute some custom code before restarting
         if (runBeforeRestart != null) {
            runBeforeRestart.run();
         }
         // exit
         System.exit(0);
      } catch (Exception e) {
         // something went wrong
         e.printStackTrace();
      }
   }
  
   /**
    * 
    * @param runBeforeRestart custom code to run right before you restart. can be <code>null</code>
    * @param mainClass the class containing the main method you are looking to start
    */
   public static void restart(Runnable runBeforeRestart, Class<?> mainClass) {
      final String javaBin = System.getProperty("java.home") + File.separator
            + "bin" + File.separator + "java";
      File currentJar = null;
      try {
         currentJar = new File(mainClass.getProtectionDomain()
               .getCodeSource().getLocation().toURI());
      } catch (URISyntaxException e) {
        e.printStackTrace();
      }

      // if not a jar, restart using the classpath way
      if (!currentJar.getName().endsWith(".jar")) {
         restartCP(runBeforeRestart);
      }
      // Build command: java -jar application.jar
      final ArrayList<String> command = new ArrayList<String>();
      command.add(javaBin);
      command.add("-jar");
      command.add(currentJar.getPath());

      final ProcessBuilder builder = new ProcessBuilder(command);
      try {
         builder.start();
      } catch (IOException e) {
         e.printStackTrace();
      }
      // execute the command in a shutdown hook, to be sure that all the
      // resources have been disposed before restarting the application
      Runtime.getRuntime().addShutdownHook(new Thread() {
         @Override
         public void run() {
            try {
               Runtime.getRuntime().exec(builder.toString());
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      });
      // run the custom code
      if (runBeforeRestart != null) {
         runBeforeRestart.run();
      }
     System.exit(0);
   }

}
