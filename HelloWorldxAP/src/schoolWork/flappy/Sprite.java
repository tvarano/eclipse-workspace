//Thomas Varano
//Apr 16, 2018

package schoolWork.flappy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

public class Sprite {
   private double x, y, width, height, gravity, jumpStart, dy;
   private boolean jumping, falling;
   
   public Sprite(int x, int y) {
      setX(x); setY(y); setWidth(50); setHeight(getWidth());
      jumpStart = -6.2;
      gravity = 0.2;
   }

   public void draw(Graphics2D g2) {
      g2.setColor(Color.YELLOW);
      g2.fill(getBounds());
   }
   
   public boolean collide(PipeManager pm) {
      for (Pipe p : pm.getPipes())
         if (p.intersects(getBounds()))
            return true;
      return false;
   }
   
   public void update() {
      dy += gravity;
      if (y < FlappyBird.PREF_H - height)
         y += dy;
      else setY(FlappyBird.PREF_H - height);
   }

   
   public Shape getBounds() {
      Rectangle straightBounds = new Rectangle((int)x, (int)y, (int)width, (int)height);
      AffineTransform transform = new AffineTransform();
      double theta = getRotation();
      transform.rotate(theta, straightBounds.getX() + straightBounds.width/2, straightBounds.getY() + straightBounds.height/2);
      return transform.createTransformedShape(straightBounds);
   }
   
   private double getRotation() {
      return Math.toRadians(dy*3);
   }
   
   public void jump() {
      dy = jumpStart;
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
      System.out.println(y);
      this.y = y;
   }

   public double getWidth() {
      return width;
   }

   public void setWidth(double width) {
      this.width = width;
   }

   public double getHeight() {
      return height;
   }

   public void setHeight(double height) {
      this.height = height;
   }

   public double getGravity() {
      return gravity;
   }

   public void setGravity(double gravity) {
      this.gravity = gravity;
   }

   public double getJumpStart() {
      return jumpStart;
   }

   public void setJumpStart(double jumpStart) {
      this.jumpStart = jumpStart;
   }

   public double getDy() {
      return dy;
   }

   public void setDy(double dy) {
      this.dy = dy;
   }

   public boolean isJumping() {
      return jumping;
   }

   public void setJumping(boolean jumping) {
      this.jumping = jumping;
   }

   public boolean isFalling() {
      return falling;
   }

   public void setFalling(boolean falling) {
      this.falling = falling;
   }
}
