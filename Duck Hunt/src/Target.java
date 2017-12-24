
//Thomas Varano
//[Program Descripion]
//Jun 26, 2017

public class Target extends Item
{
   private static final long serialVersionUID = 1L;
   public static final int RIGHT = 0, LEFT = 1, UP = 2, DOWN = 3, UP_DOWN = 4, 
         DOWN_UP = 5, LEFT_RIGHT = 6, RIGHT_LEFT = 7, TOTAL_DIR = 8;
   public static final int[] CONT_DIR = {UP_DOWN, LEFT_RIGHT, RIGHT_LEFT, DOWN_UP};
   private Spawn s;
   private int direction, distance, timeOut, timeCounted;
   private double speed, startX, startY;

   public Target(double x, double y, double z, double width, double height,
         int direction, int distance, int timeOut, double speed) {
      super(x, y, z, width, height);
      this.direction = direction;
      this.distance = distance;
      this.timeOut = timeOut;
      this.speed = speed;
   }
   
   public Target(Spawn s, double width, double height, int direction, int distance, int timeOut, double speed){
      this(s.getX(), s.getY(), s.getZ(), width, height, direction, distance, timeOut, speed);
   }
   
   public Target(double x, double y, double z, double width, double height, int direction, double speed) {
      this(x,y,z,width,height,direction,-1,-1,speed);
      if (!directionContinuous(direction))
         throw new Error("Specified direction requires timeOut and distance");
   }
   
   public Target(Spawn s, double width, double height, int direction, double speed) {
      this(s.getX(), s.getY(), s.getZ(), width, height, direction, speed);
   }
   //FIXME continuous?
   public static boolean directionContinuous(int direction) {
      for (int i : CONT_DIR) 
         if (direction == i)
            return true;
      return false;
   }
   
   public static boolean directionAcceptable(int direction) {
      return (direction >= RIGHT && direction > TOTAL_DIR);
   }
   
   public void update(){
      if (directionContinuous(direction))
         moveContinuously();
   }
   
   private void moveContinuously(){
      if (direction == LEFT)
         x -= speed;
      else if (direction == RIGHT)
         x += speed;
   }
   
   private boolean hold() {
      if (timeCounted < timeOut) {
         timeCounted++;
         return true;
      }
      return false;
   }
   
   //UP_DOWN = 4, DOWN_UP = 5, LEFT_RIGHT = 6, RIGHT_LEFT = 7
   private void moveAndReturn() {
      int movement = 0;
      double original = 0;
      if (direction == LEFT_RIGHT || direction == RIGHT_LEFT) {
         movement = x;
         original = startX;
      }
      else if (direction == UP_DOWN || direction == DOWN_UP) {
         movement = y;
         original = startY;
      }
      if ((int) Math.abs(movement - original) > distance) {
         if (!hold())
            
      }
   }
   
   public void show(){
      
   }
}
