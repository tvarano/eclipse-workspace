//Thomas Varano
//[Program Descripion]
//Dec 27, 2017

package personal.december;

import schoolWork.acsl.Cards;

public class ClassPrinting
{
   public static void main(String[] args) {
      printClass(ClassPrinting.class);
      printClass(Cards.class);
   }
   
   public static void printClass(Class x) {
      System.out.println(x);
   }
}
