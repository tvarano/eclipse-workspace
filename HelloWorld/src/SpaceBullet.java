import java.awt.Rectangle;

//Thomas Varano
//[Program Descripion]
//Nov 19, 2016

public class SpaceBullet
{
   public int x;
   public int y;
   public int width;
   public int height;
   public int velocity;
   
   public SpaceBullet(int x,int y, int velocity){
      this.x = x;
      this.y = y;
      this.velocity = velocity;
   }

   public SpaceBullet(int x,int y, int width, int height, int velocity){
      this.x = x;
      this.y = y;
      this.velocity = velocity;
      this.width = width;
      this.height = height;
   }
  
   
   public SpaceBullet()
   {
      x = 0;
      y = 0;
      velocity = 0;
   }
   

   public void moveUp(){
      setY(getY() -  velocity);
   }
   
   public Rectangle getBounds(){
      return new Rectangle(getX(),getY(),getWidth(),getHeight());
   }
   
   public boolean checkIfOffPage(int width, int height){
      if (x < width && x + this.width > 0 && y < height && y + this.height > 0)
          return false;
      else
         return true;
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
   public int getVelocity() {
      return velocity;
   }
   public void setVelocity(int velocity) {
      this.velocity = velocity;
   }
}