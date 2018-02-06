package schoolWork.before;
//Thomas Varano
//[Program Descripion]
//Oct 26, 2017


import java.time.DayOfWeek;

public class DoNow10_26
{
   public static void main(String[] args) {
      DayOfWeek[] days = DayOfWeek.values();
      for (int i = 0; i < 8; i++)
         for (DayOfWeek day : days)
            System.out.println(day);
   }
}
