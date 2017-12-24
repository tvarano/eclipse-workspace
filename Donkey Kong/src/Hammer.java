import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

//Thomas Varano
//[Program Descripion]
//Mar 24, 2017

public class Hammer
{
   private double x,y,width,height;
   private Sprite player;
   private BufferedImage skin;
   private boolean animationError;
   private boolean remove;
   
   public Hammer(double x, double y, double width, double height){
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      skin = LevelOne.DEFAULT_SKIN;
      remove = false;
   }
   
   public void update(){
      if (player.getBounds().intersects(getBounds())){
         player.setUsingHammer(true);
         remove = true;
      }
   }

   public Rectangle getBounds(){
      return new Rectangle((int)x,(int)y, (int)width, (int)height);
   }
   public void drawBounds(Graphics2D g2) {
      g2.fill(getBounds());
   }
   public void draw(Graphics2D g2){
//      g2.fill(getBounds());
      g2.drawImage(skin, (int)x, (int)y, (int)width, (int)height, null);
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

   public Sprite getPlayer() {
      return player;
   }

   public void setPlayer(Sprite player) {
      this.player = player;
   }

   public BufferedImage getSkin() {
      return skin;
   }

   public void setSkin(BufferedImage skin) {
      if(animationError && skin!=null)
         animationError = false;
      this.skin = skin;
   }

   public boolean isRemove() {
      return remove;
   }

   public void setRemove(boolean remove) {
      this.remove = remove;
   }
}
