import java.lang.Math;

public class ClassName
{
   public static void main(String[] args) {
      //Message
      String message;
      message = "hello";
      System.out.println(message);
      
      //Math
      int x = 0;
      x++;
      double answer = Math.sqrt((x*35)+14);
      
      //Booleans and Logic
      if (x > 20) {
         System.out.println("x is greater than 20");
      }
      else {
         System.out.println("x is less than 20");
      }
      
      boolean condition = true;
      if (condition == true) {
         answer = x+299;
      }
      
      System.out.println(answer);
   }
}


