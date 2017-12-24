import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

//Thomas Varano
//[Program Descripion]
//May 3, 2017

public class ConveyorBelt extends Platform
{
   public static final int STILL = 0, LEFT = 1, RIGHT = 2;
   private double strength;
   private int direction;
   private boolean go;
   private ArrayList<Item> items = new ArrayList<Item>();
   private ArrayList<Sprite> sprites = new ArrayList<Sprite>();
   private BufferedImage conveySkin;
   private Animation a = new Animation(300);

   public ConveyorBelt(int x, int y, int width, int height, double strength) {
      super(x, y, width, height);
      this.strength = strength;
      conveying = true;
      try {
//         conveySkin = ImageIO
//               .read(ClassLoader.getSystemResource("conveySkinSheet.png"));
         conveySkin = ImageIO
               .read(ClassLoader.getSystemResource("convey2.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      this.setSkin(conveySkin);
      BufferedImage[] skins = {conveySkin};
//      BufferedImage[] skins = a.extractSpriteArray(conveySkin, 2, 0, 160, 80);
      a.setFrames(skins);
      direction = RIGHT;
   }
   @Override
   public void draw(Graphics2D g2){
      if (paint){
         for (Platform p : sections){
            for (int i = 0; i< (int)(p.width/(SECTION_W/2)); i++){
               g2.drawImage(a.getImage(), p.x+(SECTION_W/2)*i, p.y, (SECTION_W/2), p.height, null);
            }
         }
      }
      else {
         drawBounds(g2);
      }
   }

   @Override
   public void update() {
      setSkin(a.getImage());
      double dx = 0;
      boolean left = (direction == LEFT);
      boolean right = (direction == RIGHT);
      if (left || right) {
         if (left) {
            dx = -strength;
            a.setRunBackwards(true);
         } else if (right) {
            dx = strength;
            a.setRunBackwards(false);
         }
         //FIXME
         for (int i = 0; i < items.size(); i++) {
            if (items.get(i).platformIntersection() && items.get(i).currentPlatform().equals(this))
               items.get(i).setDx(dx);
         }
//         for (Sprite s : sprites) {
//            if (s.platformIntersection() && s.currentPlatform()!=null && s.currentPlatform().equals((Platform)this)) {
//               s.setResistance(dx);
//               if (s.isRight())
//                  s.setDx(dx + s.getMaxSpeed());
//               else if (s.isLeft())
//                  s.setDx(dx - s.getMaxSpeed());
//               else
//                  s.setDx(dx);
//            }
//         }
      } else
         dx = 0;
   }

   public void stop() {
      go = false;
      direction = STILL;
   }

   public void go(int direction) {
      go = true;
      if (direction != STILL)
         this.direction = direction;
      else
         stop();
   }

   public double getStrength() {
      return strength;
   }
   public void setStrength(double strength) {
      this.strength = strength;
   }
   public int getDirection() {
      return direction;
   }
   public void setDirection(int direction) {
      this.direction = direction;
   }
   public ArrayList<Item> getItems() {
      return items;
   }
   public void setItems(ArrayList<Item> items) {
      this.items = items;
   }
   public ArrayList<Sprite> getSprites() {
      return sprites;
   }
   public void setSprites(ArrayList<Sprite> sprites) {
      this.sprites = sprites;
   }
   public BufferedImage getConveySkin() {
      return conveySkin;
   }
   public void setConveySkin(BufferedImage conveySkin) {
      this.conveySkin = conveySkin;
   }
   public boolean isGo() {
      return go;
   }
   public Animation getA() {
      return a;
   }
   public double getDx(){
      if (direction == LEFT)
         return -strength;
      else if (direction == RIGHT)
         return strength;
      else
         return 0;
   }
}
