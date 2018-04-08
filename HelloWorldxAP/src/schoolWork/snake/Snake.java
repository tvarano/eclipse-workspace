package schoolWork.snake;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;

//Jarrett Bierman
//Program Description
//Mar 27, 2018

public class Snake
{
   public static final int SPEED = 5;
   private int x, y, w, h, dx, dy;
   private Color color;
   public Snake(int x, int y, int w, int h, int dx, int dy, int xMax, int yMax, Color color)
   {
      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
      this.dx = dx;
      this.dy = dy;
      this.color = color;
   }
   
   public void update()
   {
      x += dx;
      y += dy;
   }
   
   public void keyPressed(int key)
   {
      if(key == KeyEvent.VK_UP){
         dx = 0;
         dy = -SPEED;
      }
      if(key == KeyEvent.VK_DOWN){
         dx = 0;
         dy = SPEED;
      }
      if(key == KeyEvent.VK_LEFT){
         dx = -SPEED;
         dy = 0;
      }
      if(key == KeyEvent.VK_RIGHT){
         dx = SPEED;
         dy = 0;
      }
   }
   
   public Ellipse2D.Double getBounds()
   {
      return new Ellipse2D.Double(x, y, w, h);
   }
   
   public void drawSnake(Graphics2D g2)
   {
      g2.setColor(color);
      g2.fill(getBounds());
      g2.setColor(Color.BLACK);
      g2.setStroke(new BasicStroke(3));
      g2.draw(getBounds());
      
   }
  
   public int getX()
   {
      return x;
   }
   public void setX(int x)
   {
      this.x = x;
   }
   public int getY()
   {
      return y;
   }
   public void setY(int y)
   {
      this.y = y;
   }
   public int getW()
   {
      return w;
   }
   public void setW(int w)
   {
      this.w = w;
   }
   public int getH()
   {
      return h;
   }
   public void setH(int h)
   {
      this.h = h;
   }
   public int getDx()
   {
      return dx;
   }
   public void setDx(int dx)
   {
      this.dx = dx;
   }
   public int getDy()
   {
      return dy;
   }
   public void setDy(int dy)
   {
      this.dy = dy;
   }
   //when you set it do like level.requestFocus(). idk if that will work 
   public Color getColor()
   {
      return color;
   }
   public void setColor(Color color)
   {
      this.color = color;
   }
   
}