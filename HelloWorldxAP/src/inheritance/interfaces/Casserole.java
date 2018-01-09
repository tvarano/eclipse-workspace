//Thomas Varano
//[Program Descripion]
//Dec 18, 2017

package inheritance.interfaces;

public class Casserole implements Bakeable
{
   private String flavor;
   private int temp;
   
   public Casserole(String flavor, int temp) {
      this.flavor = flavor;
      this.temp = temp;
   }
   
   
   public String getFlavor() {
      return flavor;
   }


   public void setFlavor(String flavor) {
      this.flavor = flavor;
   }


   public int getTemp() {
      return temp;
   }


   public void setTemp(int temp) {
      this.temp = temp;
   }


   @Override
   public void bake() {
      System.out.println("Baking a " + flavor + "casserole for 60 minutes at " + temp);
   }
   
}
