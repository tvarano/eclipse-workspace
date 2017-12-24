import java.util.HashMap;

//Thomas Varano
//[Program Descripion]
//Mar 1, 2017

public class SystemBenchmark
{

   public static void main(String[] args) {
      long startTime = System.currentTimeMillis();
      int time = 100000;
      HashMap<Integer, Object> map = new HashMap<Integer, Object>();
      for (int i = 0; i < time; i++) {
         System.out.println("looping..."+i);
      }
      long endTime = System.currentTimeMillis();
      long score = endTime-startTime;
      System.out.println(score);
   }

}
