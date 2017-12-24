package beforeGreatFire;
import java.util.Random;

//Thomas Varano
//[Program Descripion]
//Sep 25, 2017

public class MyString
{
   public static int compareString(String a, String b) {
      int smallerAmt = Math.min(a.length(), b.length());
      for (int i = 0; i < smallerAmt; i++) 
         if (a.charAt(i) != b.charAt(i))
            return a.charAt(i) - b.charAt(i);
      return a.length() - b.length();
   }
   
   public static String randomString(int len) {
      Random gen = new Random();
      String letters = "abcdefghijklmnopqrstuvwxyz";
      String word = ""; 
      for (int i = 0; i < len; i++) {
         word+=letters.charAt(gen.nextInt(letters.length()));
      }
      return word;
   }
   
   public static String replace(String phrase, String target, String repl) {
      if (phrase.indexOf(target) == -1)
         return phrase;
      return phrase.substring(0,phrase.indexOf(target)) + repl + phrase.substring(phrase.indexOf(target)+target.length());
   }
   
   public static String remove(String phrase, String target) {
      if (phrase.indexOf(target) == -1)
         return phrase;
      return phrase.substring(0, phrase.indexOf(target)) + phrase.substring(phrase.indexOf(target)+target.length());
   }
   
   public static void main(String[] args) {
      String repl = replace("this is my word", "word", "your");
      System.out.println(repl);
   }
}
