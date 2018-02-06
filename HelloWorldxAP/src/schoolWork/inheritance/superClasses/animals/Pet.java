//Thomas Varano
//[Program Descripion]
//Jan 22, 2018

package schoolWork.inheritance.superClasses.animals;

public class Pet extends Animal {
   private String name;
   public Pet(String name, String species, String bday, double weight) {
      super(species, bday, weight);
      setName(name);
   }
   public Pet() {
      super();
      setName("Default");
   }

   @Override
   public void feed() {
      System.out.println(name + " eating " + getSpecies() + " food.");
   }
   @Override
   public void groom() {
      System.out.println("groom");
   }
   @Override
   public void checkUp() {
      System.out.println("checkup");
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   //[Species: dog, Born: 01-01-2016, Weight: 0.0][Name: Default Dog][License# 10000]
   public String toString() {
      return super.toString() + "[Name: " + name + "]";
   }
}
