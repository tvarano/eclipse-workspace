
//Thomas Varano
//[Program Descripion]
//Jun 26, 2017

public class Spawn
{
   private double x, y, z;
   /**
    * Each spawn will be labeled using a number. This number will also be its index in an array, so it is set 
    * elsewhere.
    */
   private int label;
   
   public Spawn (double x, double y, double z) {
      this.x = x;
      this.y = y;
      this.setZ(z);
   }

   public double getX() {
      return x;
   }

   public void setX(double x) {
      this.x = x;
   }

   public double getY() {
      return y;
   }

   public void setY(double y) {
      this.y = y;
   }

   public double getZ() {
      return z;
   }

   public void setZ(double z) {
      this.z = z;
   }
}
