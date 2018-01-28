//Thomas Varano
//[Program Descripion]
//Jan 25, 2018

package main.currentAttempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Calendar;

import jfxtras.icalendarfx.components.VEvent;
import jfxtras.icalendarfx.VCalendar;

//import net.fortuna.ical4j.data.CalendarBuilder;
//import net.fortuna.ical4j.data.ParserException;
//import net.fortuna.ical4j.model.Calendar;

public class NewLibTwo {
   public static void main(String[] args) {
      URL url;
      try {
         url = new URL(
               "https://calendar.google.com/calendar/ical/8368c5a91jog3s32oc6k22f4e8%40group.calendar.google.com/public/basic.ics");
//          "https://calendar.google.com/calendar/ical/pascack.k12.nj.us_aokhhjok65pj1busp13ccrpjvk%40group.calendar.google.com/private-96479cea673a0aa69ff8d9247bf34861/basic.ics");
         String str = readHtml(url);
         System.out.println(str);
//         VEvent v = new VEvent();
//         v.setURL(url);
//         VCalendar vcal = VCalendar.parse(new InputStreamReader(url.openStream()));
      } catch (IOException e) {
         e.printStackTrace();
      }
      /*
       * String man = "BEGIN:VCALENDAR\n" +
       * "PRODID:-//Google Inc//Google Calendar 70.9054//EN\n" + "VERSION:2.0\n"
       * + "CALSCALE:GREGORIAN\n" + "METHOD:PUBLISHX-WR-CAL\n" +
       * "NAME:SchoolX-WR-\n" + "TIMEZONE:America/New_YorkX-WR-\n" +
       * "CALDESC:\n" + "END:VCALENDAR\n";
       * 
       * StringReader sin = new StringReader(man); CalendarBuilder builder = new
       * CalendarBuilder(); try { Calendar calendar = builder.build(sin);
       * System.out.println("OK"); } catch (IOException | ParserException e) {
       * e.printStackTrace(); }
       */
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
   
   //rfc 5545
   public Calendar formatCal(String s) {
      VCalendar ret = new VCalendar();
      ret.getVEvents();

      
   }
}
