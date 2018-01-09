//Thomas Varano
//[Program Descripion]
//Jan 5, 2018

package inheritance.superClasses;

public class Athlete
{
   private String name, sport;
   protected int hours;
   
   public Athlete() {
      this("name", "unassigned", 0);
   }
   public Athlete(String name, String sport, int hours) {
      setName(name); setSport(sport); setHours(hours);
      System.out.println("athlete constructed");
   }
   
   public void train(double hours) {
      this.hours += hours;
      System.out.println("Athlete Training");
   }

   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getSport() {
      return sport;
   }
   public void setSport(String sport) {
      this.sport = sport;
   }
   public int getHours() {
      return hours;
   }
   public void setHours(int hours) {
      this.hours = hours;
   }
   public String toString() {
      return getClass().getName() + "[ "+name + ", sport = "+sport + ", hours = "+hours + "]";
   }
}
