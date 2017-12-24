import java.awt.Color;
import java.awt.Rectangle;

//Thomas Varano
//the blocker things
//Dec 18, 2016

public class Blocker
{
   private int x, y, width, height, hits, totalLife;
   private Color color;
   
   public Blocker(int x, int y, int width, int height){
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.color = Color.GREEN;
      this.setTotalLife(20);
   }
   
   public Rectangle getBounds(){
      return(new Rectangle(x,y,width,height));
   }
   
   public boolean getCollision(SpaceBullet b){
      return getBounds().contains(b.getX(), b.getY());
   }

   public boolean getCollision(AliensMove a){
      if (getBounds().contains(a.getX(),a.getY())||
          getBounds().contains(a.getX(),a.getY()+a.getWidth())||
          getBounds().contains(a.getX()+a.getWidth(),a.getY())||
          getBounds().contains(a.getX()+a.getWidth(),a.getY()+a.getHeight())){
         return true;
      }
      else
         return false;
   }
   
   public void update(){
      if (hits<=totalLife/3){
         color = Color.GREEN;
      }
      else if (hits<=(totalLife/3)*2){
         color = Color.YELLOW;
      }
      else if (hits<=totalLife){
         color = Color.RED;
      }
      else
         setX(-201);
   }
  
   public int getX() {
      return x;
   }
   public void setX(int x) {
      this.x = x;
   }
   public int getY() {
      return y;
   }
   public void setY(int y) {
      this.y = y;
   }
   public int getWidth() {
      return width;
   }
   public void setWidth(int width) {
      this.width = width;
   }
   public int getHeight() {
      return height;
   }
   public void setHeight(int height) {
      this.height = height;
   }
   public int getHits() {
      return hits;
   }
   public void setHits(int hits) {
      this.hits = hits;
   }
   public Color getColor() {
      return color;
   }
   public void setColor(Color color) {
      this.color = color;
   }
   public int getTotalLife() {
      return totalLife;
   }
   public void setTotalLife(int totalLife) {
      this.totalLife = totalLife;
   }
}
