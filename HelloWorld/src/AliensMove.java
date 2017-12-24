import java.awt.Rectangle;
import java.util.Random;


//Thomas Varano
//Aliens
//Nov 18, 2016
public class AliensMove
{
   public int x;
   public int y;
   public int width;
   public int height;
   private int counter;
   private int ticker;
   private boolean shot, fire, left, right, down;
   private static Random gen;

   
   
   public AliensMove(int x,int y){
      this.x = x;
      this.y = y;
      this.width = 1;
      this.height = 1;
      this.shot = false;
      this.counter = 0;
      this.ticker = 1;
      this.fire = false;
      gen = new Random();
   }
   
   public AliensMove(int x, int y, int width, int height){
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.shot = false;
      this.counter = 0;
      this.ticker = 1;
      this.fire = false;
      gen = new Random();
   }
   
   public boolean checkIfOffPage(int width, int height){
      boolean onpage;
      if (x < width && y < height)
         onpage = true;
      else
         onpage = false;
         return onpage;
   }
   
   
   public int setWidth(int width){
      this.width = width;
      return 0;
   }
 
   public boolean getCollision(SpaceBullet b){
      if (getBounds().contains(b.getX(),b.getY()))
         return true;
      else if (getBounds().contains(b.getX()+b.getWidth(),b.getY()))
         return true;
      else
         return false;
   }
    
   
   public Rectangle getBounds(){
      return new Rectangle(getX(),getY(),getWidth(),getHeight());
   }
   
   public boolean getBounce(int x1){
      if (getBounds().intersectsLine(x1, 0, x1, 800))
         return true;
      else
         return false;
   }
   
   public void moveTwo(int x1,int x2){
      if (right){
         setX(getX()+width); 
         if(getBounce(x2)){
            setDown(true);
         }
      }
      else if (left){
         setX(getX()-width);
         if (getBounce(x1)){
            setDown(true);
         }
      }
      if (down){
         left = right = false;
         setY(getY()+height);
         if (getBounce(x1)){
            setRight(true);
         }
         else if (getBounce(x2)){
            setLeft(true);
         }
         setDown(false);
      }
   }
   
   public void move(){
         if (ticker == 1 || ticker == 2) {
            setX(getX()+width);
            ticker++;
            }

         else if (ticker == 4 || ticker == 5) {
            setX(getX()-width);
            ticker++;
            }
          else if (ticker == 3 || ticker == 6) {
             setY(getY()+height);
            ticker++;
         }
         System.out.println(ticker);
         if (ticker == 7)
            ticker = 1;
   }
   
   public static int randTime(){
      return 200+gen.nextInt(500);
   }
   
   public static int randPlace(){
      return gen.nextInt(5);
   }
   
   public static int randCol(){
      return gen.nextInt(9);
   }
   
   public static int randOverall(){
      return gen.nextInt(45);
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
   public int getHeight()
   {
      return height;
   }
   public void setHeight(int height)
   {
      this.height = height;
   }
   public int getWidth()
   {
      return width;
   }
   public int getCounter() {
      return counter;
   }
   public void setCounter(int counter) {
      this.counter = counter;
   }
   public boolean isShot() {
      return shot;
   }
   public void setShot(boolean shot) {
      this.shot = shot;
   }
   public boolean isFire() {
      return fire;
   }
   public void setFire(boolean fire) {
      this.fire = fire;
   }

   public int getTicker() {
      return ticker;
   }

   public void setTicker(int ticker) {
      this.ticker = ticker;
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
}

  