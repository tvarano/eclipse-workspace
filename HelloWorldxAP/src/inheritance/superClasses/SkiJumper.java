//Thomas Varano
//[Program Descripion]
//Jan 5, 2018

package inheritance.superClasses;

public class SkiJumper extends Athlete
{

   public SkiJumper(String name, String sport, int hours) {
      super(name, sport, hours);
   }
   
   public void train(double hours) {
      super.train(hours);
      System.out.println("he jumpen");
   }
}
