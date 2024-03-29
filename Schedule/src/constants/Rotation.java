package constants;

import java.time.DayOfWeek;

import information.ClassPeriod;
import information.Time;

//Thomas Varano
//[Program Descripion]
//Sep 3, 2017

public enum Rotation
{
   R1 (getSchedule(1), DayType.NORMAL, RotationConstants.R1),
   R2 (getSchedule(2), DayType.NORMAL, RotationConstants.R2),
   R3 (getSchedule(3), DayType.NORMAL, RotationConstants.R3),
   R4 (getSchedule(4), DayType.NORMAL, RotationConstants.R4),
   ODD_BLOCK (getSchedule(5), DayType.BLOCK, RotationConstants.ODD_BL), 
   EVEN_BLOCK (getSchedule(6), DayType.BLOCK, RotationConstants.EVEN_BL),
   //TODO fix getSchedule 
   HALF_R1 (getSchedule(1), DayType.NORMAL, RotationConstants.R1),
   HALF_R3 (getSchedule(1), DayType.NORMAL, RotationConstants.R1),
   HALF_R4 (getSchedule(1), DayType.NORMAL, RotationConstants.R1),
   DELAY_R1 (getSchedule(1), DayType.NORMAL, RotationConstants.R1),
   DELAY_R3 (getSchedule(1), DayType.NORMAL, RotationConstants.R1),
   DELAY_R4 (getSchedule(1), DayType.NORMAL, RotationConstants.R1),
//   DELAY_ODD (getSchedule(RotationConstants.DELAY_ODD), DayType.DELAY_BLOCK, RotationConstants.DELAY_ODD),
//   DELAY_EVEN (getSchedule(RotationConstants.DELAY_EVEN), DayType.DELAY_BLOCK, RotationConstants.DELAY_EVEN)
   ;
      
   private final int lunchSlot;
   private final ClassPeriod[] times;
   private final DayType dayType;
   private final Time labSwitch;
   private final int index;
   private final static boolean debug = false;
   
   private Rotation(ClassPeriod[] times, DayType dt, int index) {
      this.times = times; this.labSwitch = dt.getLabSwitch(); this.dayType = dt;
      this.index = index; lunchSlot = calcLunchSlot(); 
      if (debug)
         System.out.println("rotation "+index+" created");
   }
   
   public static int[] getSlotRotation (Rotation r) {
      return getSlotRotation(r.index);
   }
   
   private int calcLunchSlot() {
      DayType dt = getDayType();
      if (dt.equals(DayType.BLOCK)) 
         return 2;
      if (dt.equals(DayType.NORMAL))
         return 4;
      return -1;
   }
   
   public static Rotation getFromIndex(int rotationIndex) {
      return values()[rotationIndex-1];
   }
   
   public static Rotation toDelay(Rotation r) {
      switch (r) {
         case R1 : return DELAY_R1;
         case R3 : return DELAY_R3;
         case R4 : return DELAY_R4;
         default : return DELAY_R1;
      }
   }
   
   public static Rotation toHalf(Rotation r) {
      switch (r) {
         case R1 : return HALF_R1;
         case R3 : return HALF_R3;
         case R4 : return HALF_R4;
         default : return HALF_R1;
      }
   }
   
   private static int[] getSlotRotation (int rotationDay) {
      final int lunch = RotationConstants.LUNCH;
      switch (rotationDay) {
         case RotationConstants.R1 :
            return new int[]{1, 2, 3, 4, lunch, 5, 6, 7};
         case RotationConstants.R2 :
            return new int[]{2, 3, 4, 1, lunch, 5, 6, 7};
         case RotationConstants.R3 :
            return new int[]{3, 4, 1, 2, lunch, 6, 7, 5};
         case RotationConstants.R4 :
            return new int[]{4, 1, 2, 3, lunch, 7, 5, 6};
         case RotationConstants.ODD_BL :
            return new int[]{3, 1, lunch, 5, 7};
         case RotationConstants.EVEN_BL :
            return new int[]{2, 4, lunch,
                  RotationConstants.PASCACK, 6};
         case RotationConstants.HALF_R1 :
         case RotationConstants.DELAY_R1 :
            return new int[]{1, 2, 3, lunch, 4, 5, 6, 7};
         case RotationConstants.HALF_R3 :
         case RotationConstants.DELAY_R3 :
            return new int[]{3, 4, 1, 2, lunch, 6, 7, 5};
         case RotationConstants.HALF_R4 :
         case RotationConstants.DELAY_R4 :
            return new int[]{4, 1, 2, 3, lunch, 7, 5, 6};
         case RotationConstants.DELAY_ODD :
            return new int[]{3, 1, lunch, 5, 7};
         case RotationConstants.DELAY_EVEN :
            return new int[]{2, 4, lunch, RotationConstants.PASCACK, 6};
         default :
            return new int[0];
      }
   }
   
   private static DayType getType(int rotationType) {
      switch(rotationType) {
         case RotationConstants.R1 : case RotationConstants.R2 : case RotationConstants.R3  : case RotationConstants.R4 : 
            return DayType.NORMAL;
         case RotationConstants.ODD_BL : case RotationConstants.EVEN_BL :
            return DayType.BLOCK;
         case RotationConstants.HALF_R1 : case RotationConstants.HALF_R3 : case RotationConstants.HALF_R4 : 
            return DayType.HALF_DAY;
         case RotationConstants.DELAY_R1 : case RotationConstants.DELAY_R3 : case RotationConstants.DELAY_R4 : 
         case RotationConstants.DELAY_ODD : case RotationConstants.DELAY_EVEN :
            return DayType.DELAYED_OPEN;
      }
      return null;
   }

   private static ClassPeriod[] getSchedule(int rotationIndex) {
      if (debug) System.out.println("index="+rotationIndex);
      DayType dt = getType(rotationIndex);
      int[] slots = getSlotRotation(rotationIndex);
      ClassPeriod[] retval = new ClassPeriod[slots.length];
      String name = "";
      for (int i = 0; i < retval.length; i++){
         retval[i] = new ClassPeriod(slots[i]);
         if (slots[i] == RotationConstants.LUNCH) {
            name = "Lunch";
            retval[i].setRoomNumber("Cafe");
         }
         else if (slots[i] == RotationConstants.PASCACK)
            name = "Pascack Period";
         else 
            name = "Period " + slots[i];
         retval[i].setName(name); retval[i].setStartTime(
               dt.getStartTimes()[i]); 
         retval[i].setEndTime(dt.getEndTimes()[i]);
      }
      return retval;
   }
   
   public ClassPeriod get(String name) {
      for (ClassPeriod c : times) 
         if (c.getName().equalsIgnoreCase(name))
            return c;
      return null;
   }
   
   public static Rotation getRotation(DayOfWeek day) {
      switch (day) {
         case MONDAY : return R1;
         case TUESDAY : return ODD_BLOCK;
         case WEDNESDAY : return EVEN_BLOCK;
         case THURSDAY : return R4;
         case FRIDAY : return R3;
         default : return R1;
      }
   }
   
   public ClassPeriod[] getTimes() {
      return times;
   }
   public Time getLabSwitch() {
      return labSwitch;
   }
   public int getIndex() {
      return index;
   }
   public int getLunchSlot() {
      return lunchSlot;
   }

   public DayType getDayType() {
      return dayType;
   }
   

   
}