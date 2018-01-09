//Thomas Varano
//[Program Descripion]
//Dec 18, 2017

package inheritance.interfaces;

public class Cooking
{
   public static void main(String[] args) {
      Turkey t = new Turkey(20, 325);
      t.bake();
      Casserole c = new Casserole("water", 350);
      c.bake();
   }
}
