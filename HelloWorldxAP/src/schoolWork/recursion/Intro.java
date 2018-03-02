//Thomas Varano
//[Program Descripion]
//Feb 2, 2018

package schoolWork.recursion;

public class Intro {
   public static void main(String[] args) {
      System.out.println(reverse("abcdefg"));
   }
   
   public static int recur(int x) {
      return 2*recur(x);
   }
   
   public static String reverse(String s) {
      if (s.length() < 2) return s;
      return s.charAt(s.length() - 1) + reverse(s.substring(1, s.length() - 1)) + s.charAt(0);
   }
}
