//Thomas Varano
//[Program Descripion]
//Jan 21, 2018

package main.currentAttempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.scene.media.Media;
//import javafx.scene.media.Media;
import jfxtras.icalendarfx.VCalendar;

public class JFXWay {
   public static void main(String[] args) {
      Path p;
      try {
         Media a = new Media("https://calendar.google.com/calendar/ical/pascack.k12.nj.us_aokhhjok65pj1busp13ccrpjvk%40group.calendar.google.com/private-96479cea673a0aa69ff8d9247bf34861/basic.ics");
         URL url = new URL("https://calendar.google.com/calendar/ical/pascack.k12.nj.us_aokhhjok65pj1busp13ccrpjvk%40group.calendar.google.com/private-96479cea673a0aa69ff8d9247bf34861/basic.ics");
         System.out.println(readHtml(url));
         try {
            System.out.println(url.toURI());
            p = Paths.get(new URI(a.));
         } catch (URISyntaxException e) {
            e.printStackTrace();
         }
         String manual = "BEGIN:VCALENDAR\n"
               + "PRODID:-//Google Inc//Google Calendar 70.9054//\n"
               + "ENVERSION:2.0\n"
               + "CALSCALE:GREGORIAN\n"
               + "METHOD:PUBLISHX-WR-\n"
               + "CALNAME:SchoolX-WR-\n"
               + "TIMEZONE:America/New_YorkX-WR-CAL\n"
               + "DESC:\n"
               + "END:VCALENDAR";
         VCalendar v = VCalendar.parse(manual);
         System.out.println(v.getVEvents());
      } catch (/*URISyntaxException |*/IOException e) {
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
