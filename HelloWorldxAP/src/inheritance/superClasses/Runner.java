//Thomas Varano
//[Program Descripion]
//Jan 5, 2018

package inheritance.superClasses;

public class Runner extends Athlete
{
   private int numRaces;
   
   public Runner(String name, String sport, int hours) {
      super(name, sport, hours);
   }

   public void race() {
      numRaces++;
      hours++;
   }
   
   public int getNumRaces() {
      return numRaces;
   }
   public void setNumRaces(int numRaces) {
      this.numRaces = numRaces;
   }

}
