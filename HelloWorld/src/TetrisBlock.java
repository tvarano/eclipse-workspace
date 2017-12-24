import java.awt.Color;

//Thomas Varano
//[Program Descripion]
//Dec 26, 2016

public class TetrisBlock
{
   
   private int x, y, dx, blockSize;
   private double speed, fastSpeed;
   private boolean left, right, down, speedUp;
   private Color color;
   public TetrisBlock(int x, int y, int width, double speed){
      this.x = x;
      this.y = y;
      this.speed = speed;
      this.fastSpeed = speed + 10;
      left = right = down = speedUp = false;
      this.setColor(Color.WHITE);
   }
   
   public void update(){
      if (speedUp){
         y+=fastSpeed;
      }
      else
         y += speed;
      
      if (right){
         x+=dx;
      }
      else if (left){
         x-=dx;
      }
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
   public double getSpeed() {
      return speed;
   }
   public void setSpeed(double speed) {
      this.speed = speed;
   }
   public double getFastSpeed() {
      return fastSpeed;
   }
   public void setFastSpeed(double fastSpeed) {
      this.fastSpeed = fastSpeed;
   }
   public boolean isLeft() {
      return left;
   }
   public void setLeft(boolean left) {
      this.left = left;
   }
   public boolean isRight() {
      return right;
   }
   public void setRight(boolean right) {
      this.right = right;
   }
   public boolean isDown() {
      return down;
   }
   public void setDown(boolean down) {
      this.down = down;
   }
   public boolean isSpeedUp() {
      return speedUp;
   }
   public void setSpeedUp(boolean speedUp) {
      this.speedUp = speedUp;
   }

   public int getDx() {
      return dx;
   }

   public void setDx(int dx) {
      this.dx = dx;
   }

   public Color getColor() {
      return color;
   }

   public void setColor(Color color) {
      this.color = color;
   }

   public int getBlockSize() {
      return blockSize;
   }

   public void setBlockSize(int blockSize) {
      this.blockSize = blockSize;
   }
}
