//Thomas Varano
//Mar 9, 2018

package personal.march;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;

public class ReadHtml {
   public static void main(String[] args) {
//      setLog();
      try {
         System.out.println(readHtml(new URL("https://students.pascack.k12.nj.us/genesis/parents?tab1=studentdata&tab2=studentsummary&studentid=808219&action=form")));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   private static final String LOG_ROUTE = "/Users/varanoth/Desktop/phills.txt";
   private static void setLog() {
      try {
         File log = new File(LOG_ROUTE);
         PrintStream logStream = new PrintStream(log);
         System.setOut(logStream);
         System.setErr(logStream);
      } catch (java.io.FileNotFoundException e) {
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
