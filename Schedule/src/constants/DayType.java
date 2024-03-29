package constants;
import information.Time;

//Thomas Varano
//[Program Descripion]
//Sep 4, 2017

public enum DayType
{
   NORMAL (new Time[]{new Time(8,00), new Time(8,52), new Time(9,46), new Time(10,38), new Time(11,30), new Time(12,21),
               new Time(13,13), new Time(14,05)}, 
         new Time[] {new Time(8,48), new Time(9,42), new Time(10,34), new Time(11,26), new Time(12,17), new Time(13,9),
               new Time(14,1), new Time(14,53)}, 
         new Time(11,53)
   ),
   BLOCK (new Time[]{new Time(8,00), new Time(9,31), new Time(11,04), new Time(11,55), new Time(13,26)}, 
         new Time[]{new Time(9,27), new Time(11,00), new Time(11,51), new Time(13,22), new Time(14,53)},
         new Time(11,27)
   ),
   //FIXME wrong times after this
   HALF_DAY(new Time[] {new Time(8,00), new Time(8,35), new Time(9,12), new Time(9,47), new Time(10,22), new Time(10,56), 
         new Time(11,30)},
         new Time[] {new Time(8,31), new Time(9,8), new Time(9,43), new Time(10,18), new Time(10,52), new Time(11,26), 
               new Time(12,00)}), 
   DELAYED_OPEN (NORMAL.getStartTimes(), NORMAL.getEndTimes(), new Time()), 
   DELAY_BLOCK(DELAYED_OPEN.getStartTimes(), DELAYED_OPEN.getEndTimes(), new Time());
   
   public static final Time NO_LAB = new Time();
   private final Time[] startTimes, endTimes;
   private final Time labSwitch;
   
   private DayType(Time[] startTimes, Time[] endTimes, Time labSwitch) {
      this.startTimes = startTimes; this.endTimes = endTimes; this.labSwitch = labSwitch;
   }
   
   private DayType(Time[] startTimes, Time[] endTimes) {
      this(startTimes, endTimes, null);
   }

   public boolean equals(DayType otherDT) {
      for (int i = 0; i < startTimes.length; i++) {
         if(!startTimes[i].equals(otherDT.getStartTimes()[i]) || !endTimes[i].equals(otherDT.getEndTimes()[i]))
            return false;
      }
      return true;
   }
   
   public Time getDayDuration() {
      return Time.calculateDuration(startTimes[0], endTimes[endTimes.length-1]);
   }
   
   public Time[] getStartTimes() {
      return startTimes;
   }
   public Time[] getEndTimes() {
      return endTimes;
   }
   public Time getLabSwitch() {
      return labSwitch;
   }
}
