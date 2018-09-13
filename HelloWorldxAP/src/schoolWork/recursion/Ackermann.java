//Thomas Varano
//Feb 13, 2018

package schoolWork.recursion;

public class Ackermann {
   public static long ackermann(long m, long n) {
      if (n >= 4 && m >= 4)
         throw new StackOverflowError("inputs too large for program");
      if (m == 0) {
         return n + 1;
      } else if (m > 0 && n == 0) {
         return ackermann(m - 1, 1);
      } else {
         return ackermann(m - 1, ackermann(m, n -1));
      }
   }
   
   public static void main(String[] args) {
      System.out.println(ackermann(5,4));
   }
}
