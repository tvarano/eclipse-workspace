//Thomas Varano
//[Program Descripion]
//Dec 19, 2016

public class StringComparisons
{
   public static void main(String[] args) {
      String a = "Xan";
      String b = "Ryan";
      String c = "Edward";
      
      if (a.compareTo(b)>0)
         System.out.println(a+" comes before "+b);
      else if (a.compareTo(b)<0)
         System.out.println(b+" comes before "+a);
      else
         System.out.println("same");
   }
}
