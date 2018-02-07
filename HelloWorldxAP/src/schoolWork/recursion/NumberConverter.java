//Thomas Varano
//Feb 5, 2018

package schoolWork.recursion;

public final class NumberConverter {
   public static void main(String[] args) {
      System.out.println(getBinary(0));
      System.out.println(getOctal(10));
      System.out.println(getHexaDecimal(15));
      System.out.println("sum"+sumAB(3,8));
   }
   
   private static String getAlphaNum() {
      String ret = "";
      for (char n = '0'; n <= '9'; n++)
         ret += n;
      for (char a = 'a'; a <= 'z'; a++)
         ret += a;
      return ret;
   }
   public static String getBinary(int dec) {
      return getBase(dec, 2);
   }
   
   private static String getBase(int dec, int base) {
      if (dec < base) return getAlphaNum().charAt(dec) + "";
      return getBase(dec / base, base) + getAlphaNum().charAt(dec % base);
   }
   
   public static String getOctal(int dec) {
      return getBase(dec, 8);      
   }
   
   public static String getHexaDecimal(int dec) {
      return getBase(dec, 16);
   }
   
   public static int sumAB(int a, int b) {
      if (a == b) return b;
      return a + sumAB(a+1, b);
   }
}
