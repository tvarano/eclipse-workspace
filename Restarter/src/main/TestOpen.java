//Thomas Varano
//[Program Descripion]
//Feb 1, 2018

package main;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class TestOpen {
   public static void main(String[] args) {
      try {
         Desktop.getDesktop().open(new File("/Applications/Agenda.app"));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
