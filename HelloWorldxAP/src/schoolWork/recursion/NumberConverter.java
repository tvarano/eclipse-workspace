//Thomas Varano
//Feb 5, 2018

package schoolWork.recursion;

public final class NumberConverter {
   public static void main(String[] args) {
      System.out.println(getBinary(25));
      System.out.println(getOctal(10));
      System.out.println(getHexaDecimal(15));
   }
   
   private static char[] getAlphaNum() {
      char[] ret = new char[36];
      int index = 0;
      for (char n = '0'; n <= '9'; n++, index++)
         ret[index] = n;
      for (char a = 'a'; a <= 'z'; a++, index++)
         ret[index] = a;
      return ret;
   }
   public static String getBinary(int dec) {
      return getBase(dec, 2);
   }
   
   private static String getBase(int dec, int base) {
      if (dec < base) return getAlphaNum()[dec % base] + "";
      return getBase(dec / base, base) + getAlphaNum()[dec % base];
   }
   
   public static String getOctal(int dec) {
      return getBase(dec, 8);      
   }
   
   public static String getHexaDecimal(int dec) {
      return getBase(dec, 16);
   }
}
