//Thomas Varano
//Pipes
//Dec 6, 2016

public class Pipes
{
   private int x, y1, y, distBetween, topHeight;
   private double velocity;
   private boolean intersection;
   private final int WIDTH = 100;
   
   public int getX()
   {
      return x;
   }
   public void setX(int x)
   {
      this.x = x;
   }
   public int getY1()
   {
      return y1;
   }
   public void setY1(int y1)
   {
      this.y1 = y1;
   }
   public int getY()
   {
      return y;
   }
   public void setY(int y)
   {
      this.y = y;
   }
   public int getDistBetween()
   {
      return distBetween;
   }
   public void setDistBetween(int distBetween)
   {
      this.distBetween = distBetween;
   }
   public int getTopHeight()
   {
      return topHeight;
   }
   public void setTopHeight(int topHeight)
   {
      this.topHeight = topHeight;
   }
   public double getVelocity()
   {
      return velocity;
   }
   public void setVelocity(double velocity)
   {
      this.velocity = velocity;
   }  
   public boolean isIntersection()
   {
      return intersection;
   }
   public void setIntersection(boolean intersection)
   {
      this.intersection = intersection;
   }
   public int getWIDTH()
   {
      return WIDTH;
   }

   public Pipes(int x,int y,int distBetween){
      this.x = x;
      this.y = y;
      this.distBetween = distBetween;
      this.y1 = (this.y + this.distBetween);
      this.velocity = 0;
   }
   
   public void move(){
      this.x -= velocity;
   }
   
   public static int randHeight(){
      System.out.println((int)(MyStaticMethods.roundTo(Math.random(), 3)*1000%650));
      return (int)(MyStaticMethods.roundTo(Math.random(), 3)*1000%600);
   }
   
   public void reset(int windowWidth){
      if (getX() + WIDTH == 0){
         setX(windowWidth);
         setY(randHeight());
         setY1(getY()+distBetween);
      }
   }
   
   public void unpause(int windowWidth){
      setX(windowWidth);
      setY(randHeight());
      setY1(getY()+distBetween);
   }
}