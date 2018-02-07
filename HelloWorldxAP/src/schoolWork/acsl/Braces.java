//Thomas Varano
//Feb 6, 2018

package schoolWork.acsl;

public class Braces {
   private char getInverse(char in) {
      int index = enclosures.indexOf(in);
      if (index < 0) return '~';
      if (index % 2 == 1) return enclosures.charAt(index - 1);
      return enclosures.charAt(index + 1);
   }
   private static final String enclosures = "()[] {}";
   
   private int compare(char a, char b) {
      return enclosures.indexOf(a) - enclosures.indexOf(b);
   }
   
   private char findMissing(String in) {
      for (char c : in.toCharArray())
         if (enclosures.indexOf(c) >= 0)
            if (enclosures.indexOf(getInverse(c)) < 0)
               return getInverse(c);
      return '?';
   }
   
   //{0+2*(23 - 2)/[3]
   private String getPossiblePositions(String in) {
      StringBuilder b = new StringBuilder();
      char missing = findMissing(in);
      
   }
   
}
