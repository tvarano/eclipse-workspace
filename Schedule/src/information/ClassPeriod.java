package information;
import java.io.Serializable;

import constants.Lab;
import constants.RotationConstants;

//Thomas Varano
//Aug 31, 2017

/**
 * Class to define a class period. Pretty simple, just name, start / end time and the slot its in. 
 * @author varanoth
 *
 */
public class ClassPeriod implements Comparable<ClassPeriod>, Serializable
{
   private static final long serialVersionUID = -8853513886388469596L;
   public static final String NO_TEACH = "Teacher Name";
   public static final String NO_ROOM = "000";
   private int slot;
   private String roomNumber;
   private boolean showName, canShowPeriod;
   private static boolean debug = false;
   private String name, teacher;
   private Time startTime, endTime, duration;
   
   /**
    * Creates ClassPeriod. Would have called it {@link Class} but can't because it exists.
    * @param slot 
    *    the period slot the class is in 
    * @param name 
    *    name of the class. i.e. "CP US History I"
    * @param startTime
    *    time it starts
    * @param endTime
    *    time it ends
    */
   public ClassPeriod(int slot, String name, Time startTime, Time endTime, String teacher, String roomNumber) {
      setSlot(slot); setName(name); setStartTime(startTime); setEndTime(endTime); 
      setTeacher(teacher); setRoomNumber(roomNumber); setShowName(true); 
      setCanShowPeriod(slot != RotationConstants.LUNCH && slot != RotationConstants.PASCACK);
      if (debug)
         System.out.println("INITIALIZED"+getInfo());
      duration = Time.calculateDuration(startTime, endTime);  
   }
   
   public ClassPeriod(int slot, String name, String teacher, String roomNumber) {
      this(slot, name, new Time(), new Time(), teacher, roomNumber);
   }
   
   public ClassPeriod(int slot, String name, Time startTime, Time endTime) {
      this(slot, name, startTime, endTime, NO_TEACH, NO_ROOM);
   }
   public ClassPeriod(int slot) {
      this(slot, "Period "+slot, NO_TEACH, NO_ROOM);
   }
   
   public ClassPeriod(String name, Time startTime, Time endTime) {
      this(-1, name, startTime, endTime);
   }
   
   public ClassPeriod(ClassPeriod anchor) {
      this(anchor.getSlot(), anchor.getName(), anchor.getStartTime(), anchor.getEndTime(), anchor.getTeacher(),
            anchor.getRoomNumber());
      
   }
   
   //FIXME careful with contains. <= for endtime?
   public boolean contains(Time t) {
      return (t.getTotalMins() >= startTime.getTotalMins() && t.getTotalMins() < endTime.getTotalMins());
   }
   public ClassPeriod() {
      this(" ", new Time(), new Time());
   }
   
   
   public static String trimString(String s, int len) {
      if (s.length() > len)
         return s.substring(0, len)+"...";
      return s;
   }
   public String getInfo() {
    return getClass().getName()+"[" + name + " slot="+slot+"("+startTime+"-"+endTime+") Rm." +roomNumber+ " showName="+showName+"]";

   }
   public void setTimeTemplate(ClassPeriod c) {
      if (c == null) return;
      setStartTime(c.getStartTime()); setEndTime(c.getEndTime());
   }
   public boolean isIncomplete() {
      return (slot == -1 || name.equals(" ") || teacher.equals(NO_TEACH) || roomNumber == NO_ROOM);
   }
   public String toString() {
      return trimString((showName || !canShowPeriod) ? name : "Period "+slot, 15);
   }
   public int getSlot() {
      return slot;
   }
   public void setSlot(int slot) {
      this.slot = slot;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public Time getStartTime() {
      return startTime;
   }
   public void setStartTime(Time startTime) {
      this.startTime = startTime;
   }
   public Time getEndTime() {
      return endTime;
   }
   public void setEndTime(Time endTime) {
      this.endTime = endTime;
   }
   public Time getDuration() {
      return duration;
   }
   public String getRoomNumber() {
      return roomNumber;
   }
   public void setRoomNumber(String roomNumber) {
      this.roomNumber = roomNumber;
   }
   public String getTeacher() {
      return teacher;
   }
   public void setTeacher(String teacher) {
      this.teacher = teacher;
   }
   public boolean isShowName() {
      return showName;
   }
   public void setShowName(boolean showName) {
      this.showName = showName;
   }
   public boolean canShowPeriod() {
      return canShowPeriod;
   }
   public void setCanShowPeriod(boolean canShowPeriod) {
      this.canShowPeriod = canShowPeriod;
   }
   public void setData(ClassPeriod c) {
      setName(c.getName()); setRoomNumber(c.getRoomNumber()); setTeacher(c.getTeacher()); setSlot(c.getSlot());
   }
   
   public boolean equals(ClassPeriod c) {
      if (c == null)
         return false;
      return c.getName() == name 
            && c.getSlot() == slot &&
            c.getStartTime().equals(startTime) && c.getEndTime().equals(endTime) && 
            c.getTeacher().equals(teacher)
            ;
      }

   @Override
   public int compareTo(ClassPeriod c) {
      return getSlot() - c.getSlot();
   }

   public static class LabPeriod extends ClassPeriod implements Serializable{
      private static final long serialVersionUID = 1L;
      private Lab lab;
      
      public LabPeriod(Lab l, ClassPeriod anchor) {
         super(anchor);
         setName("LAB");
         setLab(l);
      }
      
      public LabPeriod (int slot, String name, Time startTime, Time endTime, Lab l) {
         super(slot, name, startTime, endTime);
         setLab(l);
      }

      public Lab getLab() {
         return lab;
      }
      public void setLab(Lab lab) {
         this.lab = lab;
      }
   }
}
