//Thomas Varano
//[Program Descripion]
//Feb 2, 2018

package schoolWork.recursion;

public class Intro {
   public static void main(String[] args) {
      System.out.println(recur(2));
   }
   
   public static int recur(int x) {
      return 2*recur(x);
   }
}
