//Thomas Varano
//[Program Descripion]
//Dec 5, 2016
public class PlayerJump
{
   private int x, y, width, height;
   double dx, dy;
   private double jumpForce, gravity;
   private boolean falling, up, down;
   
   public double getDx()
   {
      return dx;
   }
   public void setDx(double dx)
   {
      this.dx = dx;
   }
   public double getDy()
   {
      return dy;
   }
   public void setDy(double dy)
   {
      this.dy = dy;
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
   public int getWidth()
   {
      return width;
   }
   public void setWidth(int width)
   {
      this.width = width;
   }
   public int getHeight()
   {
      return height;
   }
   public void setHeight(int height)
   {
      this.height = height;
   }
   public double getJumpForce()
   {
      return jumpForce;
   }
   public void setJumpForce(double jumpForce)
   {
      this.jumpForce = jumpForce;
   }
   public double getGravity()
   {
      return gravity;
   }
   public void setGravity(double gravity)
   {
      this.gravity = gravity;
   }
   public boolean isFalling()
   {
      return falling;
   }
   public void setFalling(boolean falling)
   {
      this.falling = falling;
   }

   public boolean isUp() {
      return up;
   }
   public void setUp(boolean up) {
      this.up = up;
   }
   public boolean isDown() {
      return down;
   }
   public void setDown(boolean down) {
      this.down = down;
   }
   public PlayerJump(int x,int y,int width,int height){
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.dy = 0;
      this.dx = 0;
      gravity = 1;
      jumpForce = 10;
      falling = false;
   }

   public void jump(){
      dy = 0-jumpForce;
      setY(y+=dy);
   }

   public void fall(){
      if (falling){
      dy += gravity;
      y+=dy;
      setY(y);
      }
   }
   
   public void move(){
      if (up){
         y--;
      }
      if (down)
         y++;
   }

   public void stopFall(){
      setDy(0);
      setFalling(false);
   }
 
}