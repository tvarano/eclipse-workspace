//Thomas Varano
//[Program Descripion]
//Feb 1, 2018

package personal.january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadDoc {
   
   public static void main(String[] args) {
      try {
         System.out.println(readHtml(new URL("http://agendapascack.x10host.com/DayTypes/")));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   private static String readHtml(URL site) throws IOException {
      BufferedReader in = null;
      in = new BufferedReader(new InputStreamReader(site.openStream()));
      StringBuilder b = new StringBuilder();
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
         b.append(inputLine);
         b.append("\n");
      }
      in.close();
      return b.toString();
   }
}
