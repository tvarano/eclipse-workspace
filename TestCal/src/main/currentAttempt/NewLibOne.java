//Thomas Varano
//[Program Descripion]
//Jan 25, 2018

package main.currentAttempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.model.Calendar;

public class NewLibOne {
   
   public static void main(String[] args) {
      System.out.println("OI");
      URL url;
      try {
         url = new URL(
               "https://calendar.google.com/calendar/ical/8368c5a91jog3s32oc6k22f4e8%40group.calendar.google.com/public/basic.ics");
         String myCalendarString = readHtml(url);
         
         StringReader sin = new StringReader(myCalendarString);
         CalendarBuilder builder = new CalendarBuilder();
         Calendar calendar = builder.build(sin);
         calendar.conformToRfc5545();
      } catch (MalformedURLException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (net.fortuna.ical4j.data.ParserException e) {
         e.printStackTrace();
      } catch (IllegalAccessException e) {
         e.printStackTrace();
      } catch (IllegalArgumentException e) {
         e.printStackTrace();
      } catch (InvocationTargetException e) {
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
      }
      in.close();
      return b.toString();
   }
}
