//Thomas Varano
//[Program Descripion]
//Dec 21, 2017

package inheritance.interfaces;

public class Bird implements Flier
{
   public Bird() {
      super();
   }

   @Override
   public void fly() {
      System.out.println("Flapping wings to fly");
   }
   
   public void getSnack() {
      System.out.println("eat a worm");
   }
}
