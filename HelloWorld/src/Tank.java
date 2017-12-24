import java.awt.Color;
import java.awt.Rectangle;

//Thomas Varano
//[Program Descripion]
//Dec 15, 2016

public class Tank
{
   private int x, y, width, height, nozzleW, nozzleH, life;
   private boolean shot, right, left;
   private Color color;
  
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
   public int getNozzleW() {
      return nozzleW;
   }
   public void setNozzleW(int nozzleW) {
      this.nozzleW = nozzleW;
   }
   public int getNozzleH(){
      return nozzleH;
   }
   public void setNozzleH(int nozzleH){
      this.nozzleH = nozzleH;
   }
   public int getLife() {
      return life;
   }
   public void setLife(int life) {
      this.life = life;
   }
   public boolean isShot() {
      return shot;
   }
   public void setShot(boolean shot) {
      this.shot = shot;
   }
   public boolean isRight() {
      return right;
   }
   public void setRight(boolean right) {
      this.right = right;
   }
   public boolean isLeft() {
      return left;
   }
   public void setLeft(boolean left) {
      this.left = left;
   }
   
   public Color getColor() {
      return color;
   }
   public void setColor(Color color) {
      this.color = color;
   }
   public Tank(){
      x = 0;
      y = 0;
      width = 0;
      height = 0;
      nozzleW = 0;
      shot = left = right = false;
      setColor(Color.GREEN);
   }
   
   public Tank(int x,int y,int width,int height,int nozzleW, int nozzleH){
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.nozzleW = nozzleW;
      this.nozzleH = nozzleH;
      setColor(Color.GREEN);
   }
   
   public void update(){
      if (left){
         setX(this.getX()-2);
         
      }
      if (right){
         setX(this.getX()+2);
      }
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
   
   public void explode(){
      
   }
}
