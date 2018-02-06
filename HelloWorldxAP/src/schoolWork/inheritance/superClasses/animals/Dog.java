//Thomas Varano
//[Program Descripion]
//Jan 22, 2018

package schoolWork.inheritance.superClasses.animals;

public class Dog extends Pet {
   private static int licenseAvailable = 10000;
   private int license;
   public Dog(String name, String bday, double weight) {
      super(name, "dog", bday, weight);
      setLicense(licenseAvailable);
      licenseAvailable++;
   }
   public Dog(String name) {
      this(name, Animal.DEF_BDAY, 0);
   }
   public Dog() {
      this("Defualt Dog", Animal.DEF_BDAY, 0);
   }
   
   @Override
   public void groom() {
      System.out.println(getName() + " getting a bath and clipping nails.");
   }
   @Override
   public void checkUp() {
      System.out.println(getName() + " getting dog stuff examined.");
   }
   public int getLicense() {
      return license;
   }
   public void setLicense(int license) {
      this.license = license;
   }
   public static int getLicenseAvailable() {
      return licenseAvailable;
   }
   public String toString() {
      return super.toString() +  "[License# "+license + "]";
   }
}
