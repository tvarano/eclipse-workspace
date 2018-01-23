/*
 *  CalendarEntry.fx - 
 *  A calendar entry, which is part of the model.
 *
 *  Developed 2008 by James L. Weaver (jim.weaver at lat-inc.com)
 *  to serve as a compiled JavaFX Script example.
 */

import java.lang.System;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Calendar;
import java.util.Date;
 
class CalendarEntry {
  private attribute sdf = new SimpleDateFormat
      ("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
  attribute title:String;
  attribute startTime:Calendar;
  attribute endTime:Calendar;
  attribute startTimeStr:String on replace {
    //TODO: Accommodate all-day events
    var d:Date = sdf.parse("{startTimeStr.substring(0, 26)}{startTimeStr.substring(27)}");
    var cal:Calendar = Calendar.getInstance();
    cal.setTime(d);
    startTime = cal;
  };
  attribute endTimeStr:String on replace {
    var d:Date = sdf.parse("{endTimeStr.substring(0, 26)}{endTimeStr.substring(27)}");
    var cal:Calendar = Calendar.getInstance();
    cal.setTime(d);
    endTime = cal;
  };
  attribute location:String;
}