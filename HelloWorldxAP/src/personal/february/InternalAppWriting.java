//Thomas Varano
//Feb 13, 2018

package personal.february;

import java.io.File;

public class InternalAppWriting {
   public static void main(String[] args) {
      File dir = new File("/Users/varanoth/Desktop/PathTwo.app/Contents/Resources/");
      for (File f : dir.listFiles())
         System.out.println(f);
   }
}
