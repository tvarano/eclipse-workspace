//Thomas Varano
//[Program Descripion]
//Jan 23, 2018

package inheritance.superClasses.Animals;

public class Puppy extends Dog {
   @Override
   public void feed() {
      System.out.println(getName() + " eating puppy food");
   }
}
