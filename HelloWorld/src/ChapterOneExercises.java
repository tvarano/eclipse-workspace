import java.time.Duration;
import java.time.ZoneId;
import java.util.Calendar;

//Thomas Varano Period 2
   //finding date

public class ChapterOneExercises
{  
   public static void main(String[] args) throws InterruptedException
   {
      while (true){
       //date
         long dayssince = (long) ((System.currentTimeMillis() - 14400000)/8.64e+7);
         int years = (int) ((int)dayssince/365.25);
         int days = (int)((dayssince-years*365.25)%365.25);
         String month = null;
         Object monthDay = null;
         int yearNow = 1970+years;
         while ((yearNow)%4 != 0)
               {if (days<=31)
                  month = "January";
               else if(days >31 && days <= 59)
                   month = "February";
               else if (days >59 && days <=90)
                   month = "March";
               else if (days > 90 && days <= 120)
                  month = "April";
               else if (days >120 && days <=151)
                  month = "May";
               else if (days >151 && days <=181)
                  month = "June";
               else if (days >181 && days <=212)
                  month = "July";
               else if (days >212 && days <=243)
                  month = "August";
               else if (days >243 && days <=273)
                  month = "September";
               else if (days >273 && days <=304)
                  month = "October";
               else if (days >304 && days <=334)
                  month = "November";
               else if (days >334 && days <=365)
                  month = "December";
            if (month == "January")
               monthDay = days;
            else if (month == "February")
               monthDay = days - 31;
            else if (month == "March")
               monthDay = days - 58;
            else if (month == "April")
               monthDay = days - 89;
            else if (month == "May")
               monthDay = days - 119;
            else if (month == "June")
               monthDay = days - 150;
            else if (month == "July")
               monthDay = days - 180;
            else if (month == "August")
               monthDay = days - 211;
            else if (month == "September")
               monthDay = days - 242;
            else if (month == "October")
               monthDay = days - 272;
            else if (month == "November")
               monthDay = days - 303;
            else if (month == "December")
               monthDay = days - 333;
               break;}
         while ((yearNow)%4 == 0)
              {if (days<=31)
                  month = "January";
               else if(days >31 && days <= 60)
                   month = "February";
               else if (days >60 && days <=91)
                   month = "March";
               else if (days > 91 && days <= 121)
                  month = "April";
               else if (days >121 && days <=152)
                  month = "May";
               else if (days >152 && days <=182)
                  month = "June";
               else if (days >182 && days <=213)
                  month = "July";
               else if (days >213 && days <=244)
                  month = "August";
               else if (days >244 && days <=274)
                  month = "September";
               else if (days >274 && days <=305)
                  month = "October";
               else if (days >305 && days <=335)
                  month = "November";
               else if (days >335 && days <=366)
                  month = "December";
              if (month == "January")
                 monthDay = days;
              else if (month == "February")
                 monthDay = days - 31;
              else if (month == "March")
                 monthDay = days - 59;
              else if (month == "April")
                 monthDay = days - 90;
              else if (month == "May")
                 monthDay = days - 120;
              else if (month == "June")
                 monthDay = days - 151;
              else if (month == "July")
                 monthDay = days - 181;
              else if (month == "August")
                 monthDay = days - 212;
              else if (month == "September")
                 monthDay = days - 243;
              else if (month == "October")
                 monthDay = days - 273;
              else if (month == "November")
                 monthDay = days - 304;
              else if (month == "December")
                 monthDay = days - 333;
               break;}
         
         //Time
         //seconds done
         
         long millis = (long)(System.currentTimeMillis());
            int overallsec = (int) (millis/1000%864600);
            long overall = ((millis/1000)%(dayssince*86400)%86400);
            int hours = (int) (overall/3600%3600-4)-1;
            int min =  (int) (overall%3600/60);
            int sec = (overallsec%3600%60);
           //DST
            //just change the code
//            boolean DST = false;
//            if (DST = true)
//                 hours = hours + 1;
           
            Calendar c = Calendar.getInstance(); //now

            System.out.println(c.getTimeInMillis());
            System.out.println(System.currentTimeMillis());
            System.out.println(c.getTime());
            
            hours = hours%12;
            System.out.println(overall);
            String outputSec =
         null;
            if (sec < 10)
              outputSec = "0"+sec;
            else 
               outputSec = ""+sec;
            String outputMin=
                  null;
            if (min < 10)
               outputMin = "0"+min;
            else 
               outputMin = ""+min;
            
            
//            System.out.println(years+":"+days+"+"+((years+2)%4));
//            System.out.println("HELP:" + (years+2)%4);            
//            System.out.println("hour"+hours+"\nsecs"+sec+"\nmin"+min);
//            System.out.println("millis"+millis);
//                     System.out.println("overall "+overall);
//                     System.out.println("dayssince *86400 ="+ dayssince*86400);
//                     System.out.println("seconds"+millis/1000);
//                     System.out.println("years"+years);
                     
            System.out.println(days);
        System.out.println(month+" "+((int)monthDay+1)+", "+yearNow);
        System.out.println(hours+":"+outputMin+":"+outputSec);
        
         Thread.sleep(1000);
        // String months = {January, February, March, April, May, June, July, August, September, October, November, December};
      }
   }
}
