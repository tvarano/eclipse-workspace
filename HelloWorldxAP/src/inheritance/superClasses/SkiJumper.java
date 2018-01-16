//Thomas Varano
//[Program Descripion]
//Jan 5, 2018

package inheritance.superClasses;

public class SkiJumper extends Athlete
{
   public SkiJumper() {
      super("name", "Ski Jump", 0);
   }
   
   public SkiJumper(String name, int hours) {
      super(name, "Ski Jump", hours);
   }
   
   public void train(double hours) {
      super.train(hours);
      System.out.println("he jumpen");
   }
}
