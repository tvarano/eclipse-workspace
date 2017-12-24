//Thomas Varano
//[Program Descripion]
//Jun 26, 2017

public class Bullet extends Item
{
   public static final int STANDARD_W = 3, STANDARD_H = 3;
   public static final double VELOCITY = 10;
   private boolean move, remove;

   public Bullet(double x, double y, double z, double width, double height) {
      super(x, y, z, width, height);
      move = true;
   }
   
   public Bullet(double x, double y, double z) {
      this(x,y,z,STANDARD_W,STANDARD_H);
   }
   
   public void update() {
      move();
   }
   
   public void move() {
      z += VELOCITY;
      
   }

}
