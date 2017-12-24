import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

//Thomas Varano
//[Program Descripion]
//May 3, 2017

public class MiscObject extends Item
{
   private ArrayList<BufferedImage> skins = new ArrayList<BufferedImage>();
   private Animation a;
   private boolean permanent;
   protected boolean animate;
   
   public MiscObject(double x, double y, double width, double height, long delay){
      super(x,y,width,height);
      skins.add(LevelOne.DEFAULT_SKIN);
      a = new Animation(delay);
      a.setFrames(skins.toArray(new BufferedImage[skins.size()]));
      animate = (delay == 0);
   }
   public MiscObject(Location l, double width, double height, long delay){
      this(l.x,l.y,width,height,delay);
   }
   
   public void draw(Graphics2D g2){
      BufferedImage image = (animate) ? a.getImage() : skin;
      g2.drawImage(image, (int)x, (int)y, (int)width, (int)height, null);
   }
   
   public void update(){
      x+=dx; y+=dy;
      a.update();
   }

   public ArrayList<BufferedImage> getSkins() {
      return skins;
   }

   public void setSkins(ArrayList<BufferedImage> skins) {
      this.skins = skins;
      animate = (skins!=null && !skins.isEmpty());
      a.setFrames(skins.toArray(new BufferedImage[skins.size()]));
   }

   public Animation getAnimator() {
      return a;
   }
   public String toString(){
      return getClass().getName()+"[("+x+","+y+") w="+width+", h="+height+"]";
   }
   public boolean isPermanent() {
      return permanent;
   }
   public void setPermance(boolean permanent) {
      this.permanent = permanent;
   }
   public void setHitWithHammer(boolean hitWithHammer){
      if (!permanent)
         this.hitWithHammer = hitWithHammer;
   }
}
