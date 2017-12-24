import java.awt.Point;
import java.util.ArrayList;

//Thomas Varano
//[Program Descripion]
//Jul 17, 2017

public class Player
{
   private double x,y;
   private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
   
   public Player(double x, double y) {
      this.x = x; this.y = y;
   }
   
   public void update() {
      for (int i = bullets.size()-1; i >= 0; i--) {
         Bullet b = bullets.get(i);
         b.update();
         if (b.isRemove()) {
            bullets.remove(i);
         }
      }
   }
   
   //when fired, have different guns poss. each gun has an uncertainty / accuracy and each bullet can go that far off
   public void fire(){
      bullets.add(new Bullet(x,y,0));
   }
   
   public Point getPoint() {
      return new Point((int)x,(int)y);
   }
}
