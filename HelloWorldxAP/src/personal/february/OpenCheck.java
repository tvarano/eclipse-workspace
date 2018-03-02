//Thomas Varano
//Feb 16, 2018

package personal.february;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenCheck {
   public static void main(String[] args) {
      try {
         Desktop.getDesktop().open(new File("/Users/varanoth/Desktop/Java Files/Java EXEs/VaranoTetris.jar"));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
