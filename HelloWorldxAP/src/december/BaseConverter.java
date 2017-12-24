//Thomas Varano
//[Program Descripion]
//Dec 12, 2017

package december;

public final class BaseConverter
{
   private static final String VALUES = "0123456789abcdef"; 
   public static String fromBase10(long in, int toBase) {
      if (toBase <= 1)
         return in + "";
      String retval = "";
      do {
         int newAdd = (int)(in % toBase);
         String addStr = VALUES.substring(newAdd, newAdd+1) + ""; 
         in /= toBase;
         retval = addStr + retval;
      } while (in > 0);
      return retval;
   }

   public static long toBase10(String in) {
      long retval = 0;
      for (int i = 0; i < in.length(); i++) {
         String digit = in.substring(i, i+1);
         retval+= VALUES.indexOf(digit);
      }
      return retval;
   }
   
   public static void main(String[] args) {
      System.out.println(fromBase10(3213423343411L,16));
   }
}
