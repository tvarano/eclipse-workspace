//Thomas Varano
//May 15, 2018

package personal.april;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalTime;

public class ArgTest {

   public static void main(String[] args) {
      try {
         System.setOut(new PrintStream(new FileOutputStream(new File(System.getProperty("user.home") + "/Desktop/argsTest.txt"))));
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
      System.out.println(LocalTime.now() + " argsSize: "+args.length);
      
      for (String s : args)
         System.out.println(s);
   }

}
