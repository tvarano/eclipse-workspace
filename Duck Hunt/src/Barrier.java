//Thomas Varano
//[Program Descripion]
//Jun 26, 2017

public class Barrier extends Item
{
   public Barrier(double x, double y, double z, double width, double height) {
      super(x, y, z, width, height);
   }
   
   public void intersect(Bullet b) {
      b.setRemove(true);
   }

}
