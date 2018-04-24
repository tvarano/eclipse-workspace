//Thomas Varano
//Mar 27, 2018

package personal.march;

import java.io.File;

public class DirCheck {
   public static void main(String[] args) {
      System.out.println(new File("/Applications/Agenda.app").isDirectory());
      System.out.println(new File("/Users/varanoth/Desktop/Agenda.app").isDirectory());
      System.out.println(new File("/Users/varanoth/Desktop/iBooks.app").canExecute());
   }
}
