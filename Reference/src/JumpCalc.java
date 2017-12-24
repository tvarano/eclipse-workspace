
/**
 * Have you ever been making a game and wondered, <i>"Hey! I want to jump a certain height, but don't know what to use!"</i>
 * Well, friend, your struggle is over! Welcome to JumpCalc -- A class with static methods to find certain parameters of 
 * gravity, jump force, and the ticks of a timer needed to complete the jump. 
 * @author Thomas Varano
 *
 */
public abstract class JumpCalc
{
   public static void main(String[] args){
      double f = -30;
      double g = 0.5;
      double height = howHigh(f,g);
      System.out.println(g);
      System.out.println(calcJumpForce(g, height));
      System.out.println(howManyTicks(f,g, false));
      System.out.println(calcGravity(-30,howHigh(f,g), howManyTicks(f,g, false)));
   }
   
   /**
    * calculates the height of a jump given its force and gravity,
    * @param jumpForce double (presumably negative)
    * @param gravity double (presumably positive)
    * @return the height of the arc in which a sprite jumps using the gravity
    */
   public static double howHigh(double jumpForce, double gravity) {
      double height = 0;
      double dy = jumpForce;
      for (; dy < 0; height+=dy) {
         dy += gravity;
      }
      return -height;
   }
   
   /**
    * given the jump force and gravity, can either find how many times the method will have to be called to complete the jump.
    * </br> can either find this for half or all of the jump.
    * @param jumpForce double (presumably negative)
    * @param gravity double (presumably positive)
    * @param wholeJump if the desired return value is to the peak of the jump or the whole jump
    * @return the amount of ticks in a timer that will take a sprite to reach the peak of its jump 
    * @see howHigh
    */
   public static int howManyTicks(double jumpForce, double gravity, boolean wholeJump) {
      int retval = 0;
      double dy = jumpForce;
      double y = 0;
      if (!wholeJump){
         for (; dy < 0; retval++)
            dy+=gravity;
      }
      else{
         for (; y <= 0; retval++) {
            dy += gravity;
            y+=dy;
         }
      }
      return retval;
   }
   
   /**
    * given the jump force, the desired height, and length of the jump in time, finds the gravity needed</br>
    * <b> NOTE!! The calculation is not perfect, so there is a bit of roundoff error. The calculated height
    *  will not be more than 0.1 pixels off of the desired height, but it will not be perfect. </b>
    * @param jumpForce double (presumably negative)
    * @param desiredHeight double (presumably positive)
    * @param ticksToTake int (must be positive)
    * @return double gravity (positive)
    */
   public static double calcGravity(double jumpForce, double desiredHeight, int ticksToTake){
      double idealG = 0;
      double height;
      double dy = -jumpForce;
      double errorAllowance = 0.1;
      do {
         height = 0;
         dy = -jumpForce;
         for (int i = 0; i < ticksToTake; i++) {
            height += dy;
            dy -= idealG;
         }
         idealG+=0.0001;
      } while (idealG < 0.8 && Math.abs(height - desiredHeight) > errorAllowance);
      //just round out the small decimals
      return Math.round(idealG*10000)/10000.0;
   }
   
   /**
    * given the gravity and desired height, the jump force will be calculated. 
    * @param gravity 
    * @param desiredHeight
    * @return the required jumpForce to meet the requirements given of gravity and desired height
    */
   public static double calcJumpForce(double gravity, double desiredHeight) {
      double dy = 0;
      double height = desiredHeight;
      for (; height >= 0; height-=dy){
         dy+=gravity;
      }
      return -dy;
   }
}
