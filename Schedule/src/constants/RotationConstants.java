package constants;
import information.ClassPeriod;
import information.Time;

//Thomas Varano
//[Program Descripion]
//Sep 12, 2017

public abstract class RotationConstants
{
   public static final int R1 = 1, R2 = 2, R3 = 3, R4 = 4, ODD_BL= 5, EVEN_BL = 6;
   public static final int HALF_R1 = 7, HALF_R3 = 8, HALF_R4 = 9, 
         DELAY_R1 = 10, DELAY_R3 = 11, DELAY_R4 = 12, DELAY_ODD = 13, DELAY_EVEN = 14;
   public static final int LUNCH = 9, PASCACK = 10;
   public static final int[] SPECIAL_CLASSES = {0, 8, PASCACK};
   
   private static final String[] NAMES = {"R1", "R2", "R3", "R4", "Odd Block", "Even Block", "R1 Half Day", 
         "R3 Half Day", "R4 Half Day", "R1 Delayed Opening", "R3 Delayed Opening", "R4 Delayed Opening"
         };
   
   public static final String getName(int rotationIndex) {
      return NAMES[rotationIndex-1];
   }
   
   public static Rotation getRotation(String name) {
      for (int i = 0; i < NAMES.length; i++) {
         if (name.equals(NAMES[i]))
            return Rotation.getFromIndex(i+1);
      }
      return null;
   }
   
   public static final ClassPeriod PERIOD_ZERO = new ClassPeriod(0, "Period 0", new Time(7,15), new Time(7,56)),
         PERIOD_EIGHT = new ClassPeriod(8, "Period 8", new Time(14,57), new Time(15,44)), 
         PASCACK_PERIOD = new ClassPeriod(RotationConstants.PASCACK, "Pascack Period", 
               Rotation.ODD_BLOCK.getTimes()[3].getStartTime(), Rotation.ODD_BLOCK.getTimes()[3].getEndTime());
   
   public static final ClassPeriod getPascack() {
      ClassPeriod retval = PASCACK_PERIOD;
      retval.setCanShowPeriod(false);
      return retval;
   }
   
}
