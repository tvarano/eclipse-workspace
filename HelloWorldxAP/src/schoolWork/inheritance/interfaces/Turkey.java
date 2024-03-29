//Thomas Varano
//[Program Descripion]
//Dec 18, 2017

package schoolWork.inheritance.interfaces;

public class Turkey implements Bakeable
{
   private int weight, temp;

   public Turkey(int weight, int temp) {
      this.weight = weight;
      this.temp = temp;
   }

   public int getWeight() {
      return weight;
   }
   public void setWeight(int weight) {
      this.weight = weight;
   }
   public int getTemp() {
      return temp;
   }
   public void setTemp(int temp) {
      this.temp = temp;
   }

   @Override
   public void bake() {
      System.out.println("Baking for " +(weight*20) + " minutes at " + temp + " degrees");
   }
}
