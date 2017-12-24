import java.awt.Rectangle;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;


//Thomas Varano
//[Program Descripion]
//Nov 7, 2016
public class MyStaticMethods
{
   public static final int MEANING_OF_EM = 32;
   
   public static double doubleThisNumber (double x)
   {
    return 2*x;  
   }
   
   public static double roundTo(double num, int places){
     double mult = Math.round(num*(Math.pow(10, places)));
     double product = mult/Math.pow(10,places);
      return product;
   }
   
   public static void printTime() {
      Calendar c = Calendar.getInstance(); //now

     String full = c.getTime().toString(); 
     String justtime = full.substring(0, 0);
     System.out.println(justtime);
   }
   
   public static String easterDate(int year){ 
      int a = year%19;
      int b = year/100;
      int c = year%100;
      int d = b/4;
      int e = b%4;
      int g = (8*b+13)/25;
      int h = (19*a+b-d-g+15)%30;
      int j = c/4;
      int k = c%4;
      int m = (a+11*h)/319;
      int r = (2*e+2*j-k-h+m+32)%7;
      int n = (h-m+r+90)/25;
      int p = (h-m+r+n+19)%32;
      String month;
      if (n == 4)
         month = "April ";
      else if (n == 3) 
         month = "March ";
      else 
         month = "ERROR";
      return month+" "+p;
   }
   
   public static double getSlope(double x1, double y1, double x2, double y2){
      double ydif = y1-y2;
      double xdif = x1-x2;
      return ydif/xdif;
   }
   
   public static String getFirstName(String fullname)
   {
      String firstname = fullname.substring(0,fullname.indexOf(' '));
      return firstname;
   }
   
   public static String getLastName(String fullname)
   {
      String lastname = fullname.substring(fullname.indexOf(' ')+1);
      return lastname;
   }
   
   public static String getLastFirst(String fullname)
   {
      String firstname = fullname.substring(0,fullname.indexOf(' '));
      String lastname = fullname.substring(fullname.indexOf(' ')+1);
      return lastname+","+firstname;
   }
   
   public static double getAverage (double numa, double numb)
   {return (numa + numb)/2;
   }
   
   public static String time(){
    //Time
    while(true){
       long dayssince = (long) ((System.currentTimeMillis() - 14400000)/8.64e+7);
   
       long millis = (long)(System.currentTimeMillis());
          int overallsec = (int) (millis/1000%864600);
          long overall = ((millis/1000)%(dayssince*86400)%86400);
          int hours = (int) (overall/3600%3600-4)-1;
          int min =  (int) (overall%3600/60);
          int sec = (overallsec%3600%60);
        
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
      return hours+":"+outputMin+":"+outputSec;
     }
    }
   
//   public static double getPosQuad(double )
   {}
}
   

