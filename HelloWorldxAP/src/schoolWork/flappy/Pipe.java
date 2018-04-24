//Thomas Varano
//Apr 19, 2018

package schoolWork.flappy;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

public class Pipe {
   private int x, gapY, width;
   private final int innerVGap = 150, outerVGap = 40;
   private double dx;
   
   public Pipe(int width, int x) {
      this.x = x; this.width = width;
      dx = -2;
      calcGap();
   }
   
   public int calcGap() {
      gapY = (int) (Math.random() * (FlappyBird.PREF_H - (outerVGap*2 + innerVGap)) + outerVGap);
//      System.out.println((FlappyBird.PREF_H - outerVGap * 2 - innerVGap) + outerVGap);
//      System.out.println(FlappyBird.PREF_H);
//      System.out.println(gapY);
      return gapY;
   }
   
   public static void main(String[] args) {
      for (int i = 0; i < 50; i++) {
      int gapY = (int) (Math.random() * (FlappyBird.PREF_H - 80 - 150) + 40);
      System.out.println(gapY);
      }
   }
   
   public boolean intersects(Shape s) {
      Rectangle b = new Rectangle(x, 0, width, gapY);
      if (b.intersects(s.getBounds())) return true;
      b = new Rectangle(x, gapY + innerVGap, width, FlappyBird.PREF_H);
      if (b.intersects(s.getBounds())) return true;
      return false;
   }
   
   public void draw(Graphics2D g2) {
      g2.fillRect(x, 0, width, gapY);
      g2.fillRect(x, gapY + innerVGap, width, FlappyBird.PREF_H);
   }
   
   public void update() {
      x += dx;
   }
   
   public int getX() {
      return x;
   }
   public void setX(int x) {
      this.x = x;
   }
   public int getGapY() {
      return gapY;
   }
   public void setGapY(int gapY) {
      this.gapY = gapY;
   }
   public int getWidth() {
      return width;
   }
   public void setWidth(int width) {
      this.width = width;
   }
}
