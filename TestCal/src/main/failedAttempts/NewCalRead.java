//Thomas Varano
//[Program Descripion]
//Jan 21, 2018

package main.failedAttempts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class NewCalRead {
   public static void main(String[] args) {
      try {
         URL site = new URL("https://icsfiletest.weebly.com");
         System.out.println(readHtml(site));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   private static String readHtml(URL site) throws IOException {
      BufferedReader in = null;
      in = new BufferedReader(
            new InputStreamReader(site.openStream()));
      StringBuilder b = new StringBuilder();
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
         b.append(inputLine);
      }
      in.close();
      return b.toString();
   }
}
