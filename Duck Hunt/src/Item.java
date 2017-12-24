import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

//Thomas Varano
//[Program Descripion]
//Jun 26, 2017

public abstract class Item extends Rectangle
{
   private static final long serialVersionUID = 1L;
   protected double z, initialW, initialH;
   protected Color color;
   protected BufferedImage skin;
   private boolean paint;
   
   public Item(double x, double y, double z, double width, double height) {
      super((int)x, (int)y, (int)width, (int)height);
      this.initialH = height;
      this.initialW = width;
      this.z = z;
      calculateAndTranslateSize();
      color = Color.WHITE;
      skin = LevelManager.DEFAULT_SKIN;
      paint = false;
   }
   
   private Rectangle calculateAndTranslateSize() {
      double scale = z/3;
      width /= scale;
      height /= scale;
      return new Rectangle(x, y, width, height);
   }
   
   public void draw(Graphics2D g2) {
      if (paint)
         g2.drawImage(skin, x, y, width, height, null);
      else {
         Color prev = g2.getColor();
         g2.setColor(color);
         g2.fill(this);
         g2.setColor(prev);
      }
   }
   
//   public boolean intersects(Item i) {
//      return intersects(i.getBounds());
//   }
   
   public void intersect(Bullet b){}
   
   public void update(){}

   public double getZ() {
      return z;
   }

   public void setZ(double z) {
      this.z = z;
   }

   public Color getColor() {
      return color;
   }

   public void setColor(Color color) {
      this.color = color;
   }

   public BufferedImage getSkin() {
      return skin;
   }

   public void setSkin(BufferedImage skin) {
      this.skin = skin;
   }
   
}
