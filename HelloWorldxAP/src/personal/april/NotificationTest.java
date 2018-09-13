//Thomas Varano
//Jun 4, 2018

package personal.april;

import java.io.IOException;

public class NotificationTest {
   public static void main(String[] args) {
      try {
         Runtime.getRuntime().exec(new String[] { "osascript", "-e", "display notification \"This is a message\" with title \"Title\" subtitle \"Subtitle\" sound name \"Funk\"" });
      } catch (IOException e) {
         e.printStackTrace();
      }

   }
}
