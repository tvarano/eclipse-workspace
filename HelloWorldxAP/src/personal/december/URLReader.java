package personal.december;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class URLReader {
   public static URL rotationDataSite;
   
    public static void main(String[] args) throws Exception {

        rotationDataSite = new URL("https://sites.google.com/pascack.k12.nj.us/agenda/home");
        String totalHtml = retrieveHtml();
        
        ArrayList<String> events = findTypes(0, "ltr;\">", "</p>", "</div", totalHtml);
        ArrayList<String> dates = findTypes(0, "right;\">", "</p>", "</div", totalHtml);
        
        System.out.println("\n"+events.toString());
        System.out.println("\n"+ dates.toString());

    }
    
    private static String retrieveHtml() {
       BufferedReader in;
      try {
         in = new BufferedReader(
                new InputStreamReader(rotationDataSite.openStream()));
         StringBuilder b = new StringBuilder();
         String inputLine;
         while ((inputLine = in.readLine()) != null) {
            b.append(inputLine);
         }
         in.close();
         return b.toString();
      } catch (IOException e) {
         //TODO errorID
         e.printStackTrace();
         return null;
      }
    }
    
    public static ArrayList<String> getEvents(String totalHtml) {
       return findTypes(0, "ltr;\">", "</p>", "</div", totalHtml);
    }
    
    public static ArrayList<String> getDates(String totalHtml) {
       return findTypes(0, "right;\">", "</p>", "</div", totalHtml);
    }
    
   private static ArrayList<String> findTypes(int startIndex, String beginKey,
         String endKey, String breakKey, String totalHtml) {
      ArrayList<String> retval = new ArrayList<String>();
      int dIndex = startIndex;
      int first = 0;
      do {
         boolean isFirst = dIndex == startIndex;
         dIndex = totalHtml.indexOf(beginKey, dIndex);
         if (isFirst)
            first = dIndex;
         String addition = (totalHtml.substring(dIndex + beginKey.length(),
               totalHtml.indexOf(endKey, dIndex)));
         dIndex += beginKey.length() + addition.length() + 10;
         retval.add(addition);
      } while (dIndex < totalHtml.indexOf(breakKey, first) && dIndex != -1);
      return retval;
   }

   public static void createFrame(URL oracle) throws IOException {
       JFrame f = new JFrame("oi");
       //zfr3Q
       f.getContentPane().add(new JScrollPane(new JEditorPane(oracle)));
//       f.getContentPane().add(new JEditorPane("html","<iframe src=\"https://calendar.google.com/calendar/embed?showPrint=0&amp;showCalendars=0&amp;showTz=0&amp;mode=WEEK&amp;height=600&amp;wkst=1&amp;bgcolor=%23FFFFFF&amp;src=8368c5a91jog3s32oc6k22f4e8%40group.calendar.google.com&amp;color=%23691426&amp;ctz=America%2FNew_York\" style=\"border-width:0\" width=\"800\" height=\"600\" frameborder=\"0\" scrolling=\"no\"></iframe>"));
       f.pack();
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f.setVisible(true);
    }
}