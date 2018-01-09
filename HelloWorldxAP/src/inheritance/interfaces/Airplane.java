//Thomas Varano
//[Program Descripion]
//Dec 21, 2017

package inheritance.interfaces;

public class Airplane implements Flier
{
   public Airplane() {
      super();
   }

   @Override
   public void fly() {
      System.out.println("using jet engine to fly");
   }
   
   public void getSnack() {
      System.out.println("eat pretzels");
   }
}
