//Thomas Varano
//Feb 6, 2018

package schoolWork.acsl;

import java.util.Scanner;

public class Braces {
   
   private static char getInverse(char in) {
      int index = enclosures.indexOf(in);
      if (index < 0) return '~';
      if (index % 2 == 1) return enclosures.charAt(index - 1);
      return enclosures.charAt(index + 1);
   }
   
   private static final String enclosures = "()[]{}";
   private static final String opens = "([{";
   private static final String closes = ")]}";
   private static final String operators = "/*+-";
   
   
   private static int compare(char a, char b) {
      return enclosures.indexOf(a) - enclosures.indexOf(b);
   }
   
   private static boolean openBrace(char b) {
      return enclosures.indexOf(b) % 2 == 0;
   }
   
   private static char findMissing(String in) {
      for (char c : enclosures.toCharArray())
         if (in.indexOf(c) >= 0)
            if (in.indexOf(getInverse(c)) < 0)
               return getInverse(c);
      return '?';
   }
   
   private static boolean isNumber(char in) {
      return enclosures.indexOf(in) < 0 && operators.indexOf(in) < 0;
   }
   
   private static boolean canPlace(char brace, int index, String equ) {
      if (openBrace(brace)) {
         if (equ.indexOf(getInverse(brace)) > index) {
            if (heirarchyGood(brace, index, equ))
               if (!isNumber(equ.charAt(index-1))) 
                  if (operatorsInside(brace, index, equ)) {
//                     System.out.println(equ.substring(0, index) + "X" + equ.substring(index));
                     return true;
               }
         }
      } else {
         if (equ.indexOf(getInverse(brace)) < index) {
            if (heirarchyGood(brace, index, equ)) {
               if (index == equ.length()-1 || !isNumber(equ.charAt(index))) 
                  if (operatorsInside(brace, index, equ)) {
//                     System.out.println(equ.substring(0, index) + "X" + equ.substring(index));
                     return true;
               }
            }
         }
      }
      return false;
   }
   
   private static boolean heirarchyHigh(char brace, int index, String equ) {
      if (openBrace(brace)) {
         for (char c : opens.toCharArray()) {
            if (compare(brace, c) < 0) {
               if (equ.indexOf(c) >= index)
                  return false;
            }
         }
      } else {
         for (char c : closes.toCharArray()) {
            if (compare(brace, c) < 0) {
               if (equ.indexOf(c) <= index && equ.indexOf(c) > 0) return false;
            }
         }
      }
      return true;
   }
   
   private static boolean heirarchyGood(char brace, int index, String equ) {
      return heirarchyLow(brace, index, equ) && heirarchyHigh(brace, index, equ);
   }
   
   private static boolean heirarchyLow(char brace, int index, String equ) {
      if (openBrace(brace)) {
         for (char c : opens.toCharArray()) {
            if (compare(brace, c) > 0) {
               if (equ.indexOf(c) < index)
                  return false;
            } else if (compare(brace, c) < 0) {
               if (equ.indexOf(c) >= index)
                  return false;
            }
         }
      } else {
         for (char c : closes.toCharArray()) {
            if (compare(brace, c) > 0) {
               if (equ.indexOf(c) > index) {
                  return false;
               } else if (compare(brace, c) < 0) {
                  if (equ.indexOf(c) <= index  && equ.indexOf(c) > 0)
                     return false;
               }
            }
         }
      }
      return true;
   }
   
   /**
    * needs to be ok up until now. last thing to do.
    */
   private static boolean operatorsInside(char bracket, int index, String equ) {
      String sub;
      if (openBrace(bracket)) 
         sub = equ.substring(index, (equ.indexOf(getInverse(bracket))));
       else
         sub = equ.substring(equ.indexOf(getInverse(bracket)), index);
      for (char c : operators.toCharArray())
         if (sub.indexOf(c) >= 0)
            return true;
      return false;
   }
   
   //{0+2*(23 - 2)/[3]
   private static String getPossiblePositions(String in) {
      StringBuilder b = new StringBuilder();
      char missing = findMissing(in);
      for (int i = 0; i < in.length(); i++) {
         if (canPlace(missing, i, in))
            b.append((i+1) + ", ");
      }
      return b.toString().substring(0, b.length() - 2);
   }
   
   
   public static void main(String[] args) {
      System.out.println(getPossiblePositions("{[(2+3)*6/10}"));
      System.out.println(getPossiblePositions("{[7*25/5+14)*51]+6}"));
      System.out.println(getPossiblePositions("{60+[15*(520-505)]/5-23"));
      System.out.println(getPossiblePositions("{32*510+(8/4)*2+43]/24}"));
      System.out.println(getPossiblePositions("{[(24+900/300*64]}"));
   }
   
   public static void run() {
      Scanner in = new Scanner(System.in);
      String line;
      do {
         System.out.println("print your equation. type q to quit");
         line = in.nextLine();
         System.out.println(getPossiblePositions(line));
      } while(line.equalsIgnoreCase("q"));
      in.close();
   }
}
