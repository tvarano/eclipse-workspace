//Thomas Varano
//[Program Descripion]
//Dec 14, 2017

package personal.december;

import java.io.File;
import java.io.IOException;

public class FileMovement
{
   public static void main(String[] args) {
      String oldR = System.getProperty("user.home")+ "/Desktop/oldDir";
      String newR = System.getProperty("user.home")+ "/Desktop/TestDir/newDir";
//      new File(System.getProperty("user.home")+ "/Desktop/TestDir").mkdirs();
      new File(oldR).mkdirs();
//      try {
//         new File(oldR + "/file.txt").createNewFile();
//      } catch (IOException e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//      }
      new File(oldR).renameTo(new File(newR));
   }
}
