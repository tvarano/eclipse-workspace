//Thomas Varano
//[Program Descripion]
//Jan 22, 2018

package inheritance.superClasses.Animals;

public abstract class Animal implements Careable {
   public static final String DEF_BDAY = "01-01-2016";
   private String species, bday;
   private double weight;
   
   public Animal(String species, String bday, double weight) {
      setSpecies(species); setBday(bday); setWeight(weight);
   }
   
   public Animal() {
      this("undef", DEF_BDAY, 0);
   }
   
   @Override
   public abstract void feed();
   @Override
   public abstract void groom();
   @Override
   public abstract void checkUp();
   public String getSpecies() {
      return species;
   }
   public void setSpecies(String species) {
      this.species = species;
   }
   public String getBday() {
      return bday;
   }
   public void setBday(String bday) {
      this.bday = bday;
   }
   public double getWeight() {
      return weight;
   }
   public void setWeight(double weight) {
      this.weight = weight;
   }
   
   public String toString() {
      return "[Species: " + species + ", Born: "+bday + ", Weight: " + weight + "]";
   }
}
