//Thomas Varano
//[Program Descripion]
//Jan 22, 2018

package schoolWork.inheritance.superClasses.animals;

public class Bird extends Pet {
   private boolean exotic;
   public Bird(String name, String bday, double weight, boolean exotic) {
      super(name, "bird", bday, weight);
      setExotic(exotic);
   }
   public Bird(String name) {
      this(name, Animal.DEF_BDAY, 00, false);
   }
   public Bird() {
      this("Default Bird");
   }
   @Override
   public void groom() {
      System.out.println(getName() + " taking a bird bath and filing beak.");
   }
   @Override
   public void checkUp() {
      System.out.println(getName() + "  getting bird parts examined.");
   }
   
   
   public boolean isExotic() {
      return exotic;
   }
   public void setExotic(boolean exotic) {
      this.exotic = exotic;
   }
   public String toString() {
      return super.toString() + "[Exotic: "+exotic + "]";
   }
}
