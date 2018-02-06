//Thomas Varano
//[Program Descripion]
//Dec 21, 2017

package schoolWork.inheritance.interfaces;

import java.util.ArrayList;

public class FlyTest
{
   public static void main(String[] args)
   {
      ArrayList<Flier> fliers = new ArrayList<Flier>();
      fliers.add(new Airplane());
      fliers.add(new Airplane());
      fliers.add(new Bird());
      fliers.add(new Bird());

      flyAway(fliers);
      System.out.println();
      feed(fliers);
   }
   
   public static void flyAway(ArrayList<Flier> fls) {
      for (Flier f : fls) {
         f.fly();
      }
   }
   
   public static void feed(ArrayList<Flier> fls) {
      for (Flier f : fls) {
         if (f instanceof Bird)
            ((Bird) f).getSnack();
         if (f instanceof Airplane)
            ((Airplane) f).getSnack();
      }
   }
}
