/*
 *  CalendarModel.fx - 
 *  The model behind a compiled JavaFX calendar program
 *
 *  Developed 2008 by James L. Weaver (jim.weaver at lat-inc.com)
 *  to serve as a compiled JavaFX Script example.
 */

import javafx.xml.*;
import java.text.SimpleDateFormat;
import java.lang.System;
import java.util.Calendar;
import java.util.GregorianCalendar;
 
class CalendarModel {
  attribute calendarFeedURI =
    "http://www.google.com/calendar/feeds/james.l.weaver%40gmail.com/public/full";
  attribute docBuilder =
    DocumentBuilder {
      namespaceAware:true
      validating:true
      ignoringComments:false
    }; 
  attribute document = 
    docBuilder.parseURI(calendarFeedURI);
  attribute calEntries:CalendarEntry[];
  attribute selectedGregCal:GregorianCalendar = new GregorianCalendar();
  attribute utilGregCal:GregorianCalendar = new GregorianCalendar();
  attribute selectedMonth:Integer;
  attribute selectedYear:Integer;
  attribute dayInMonthFmt = new SimpleDateFormat("d");
  attribute monthFmt = new SimpleDateFormat("MMMM");
  attribute yearFmt = new SimpleDateFormat("yyyy");
  attribute cellNumber:Integer;
  attribute selectedDayInMonthStr:String;
  attribute selectedMonthStr:String;
  attribute selectedYearStr:String;
  
  postinit {
    var calElements = document.getElementsByTagName("entry");
    calEntries = for (calElement in calElements)
      CalendarEntry {
        title: calElement.queryString("title")
        startTimeStr: calElement.queryString("when/@startTime")
        endTimeStr: calElement.queryString("when/@endTime")
        location: calElement.queryString("where/@valueString")
      };
    populateDateParts();
  }
  
  function prevMonth():Void {
    selectedGregCal.add(Calendar.MONTH, -1);
    selectedMonth = selectedGregCal.get(Calendar.MONTH);
    populateDateParts();
  }

  function nextMonth():Void {
    selectedGregCal.add(Calendar.MONTH, 1);
    selectedMonth = selectedGregCal.get(Calendar.MONTH);
    populateDateParts();
  }

  function prevYear():Void {
    selectedGregCal.add(Calendar.YEAR, -1);
    selectedYear = selectedGregCal.get(Calendar.YEAR);
    populateDateParts();
  }

  function nextYear():Void {
    selectedGregCal.add(Calendar.YEAR, 1);
    selectedYear = selectedGregCal.get(Calendar.YEAR);
    populateDateParts();
  }

  function populateDateParts():Void {
    var selDate = selectedGregCal.getTime();
    selectedDayInMonthStr = dayInMonthFmt.format(selDate);
    selectedMonthStr = monthFmt.format(selDate);
    selectedYearStr = yearFmt.format(selDate);
  }
  
  function getDateForCell(cellNumber:Integer):GregorianCalendar {
    utilGregCal.set(Calendar.YEAR, selectedYear); 
    utilGregCal.set(Calendar.MONTH, selectedMonth); 
    utilGregCal.set(Calendar.DAY_OF_MONTH, 1); 
    var firstDayOffset = utilGregCal.get(Calendar.DAY_OF_WEEK);
    utilGregCal.add(Calendar.DAY_OF_MONTH, firstDayOffset * -1 + cellNumber);
    return utilGregCal;
  }

  function getDayInMonthStrForCell(cellNumber:Integer):String {
    utilGregCal.set(Calendar.YEAR, selectedYear); 
    utilGregCal.set(Calendar.MONTH, selectedMonth); 
    utilGregCal.set(Calendar.DAY_OF_MONTH, 1); 
    var firstDayOffset = utilGregCal.get(Calendar.DAY_OF_WEEK);
    utilGregCal.add(Calendar.DAY_OF_MONTH, firstDayOffset * -1 + cellNumber);
    dayInMonthFmt.format(utilGregCal.getTime());
  }
}
