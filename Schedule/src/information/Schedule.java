package information;
import java.io.Serializable;

import constants.ErrorID;
import constants.Lab;
import constants.Rotation;
import constants.RotationConstants;
import display.ScheduleList;

//Thomas Varano
//Aug 31, 2017

/**
 * gonna hold everything. array of classes, lab day
 * @author varanoth
 * 
 */
public class Schedule implements Serializable
{ 
   private static final long serialVersionUID = -3898901184816193456L;
   public static final int NORMAL_AMT_DAYS = 7;
   private ClassPeriod[] classes;
   private ClassPeriod schoolDay, pascackPreferences; 
   private Lab[] labs;
   private boolean debug;
   private String name;
   
   public Schedule(int amountClasses, Lab[] labSlots) {
      this(new ClassPeriod[amountClasses], labSlots);
   }
   
   public Schedule (ClassPeriod[] classes, Lab[] labSlots) {
      this(classes, labSlots, new ClassPeriod());
   }
   
   public Schedule(ClassPeriod[] classes, Lab[] labSlots, ClassPeriod pascackPreferences) {
      init(classes, labSlots, pascackPreferences);
   }
   
   public Schedule(ClassPeriod[] classes, Lab labSlot) {
      this(classes, new Lab[]{labSlot});
   }
   
   public Schedule(int amountClasses, Lab labSlot) {
      this(new ClassPeriod[amountClasses], labSlot);
   }
   
   public Schedule() {
      this(0,Lab.LAB1);
   }
   
   protected void init(ClassPeriod[] classes, Lab[] labSlots, ClassPeriod pascackPreferences) {
      setClasses(classes); setLabs(labSlots);
      calculateSchoolDay();
      setPascackPreferences(pascackPreferences);
      init();
      if (debug) System.out.println("SCHED INITIALIZED:size="+classes.length);
   }
   
   public void init() {
      debug = false;
      calculateSchoolDay();
      if (name == null)
         name = "unNamedSchedSize"+classes.length;
   }
   
   /**
    * @deprecated I'm pretty sure we dont need this.
    * The reader does pretty much everything
    * @param rotation
    * @param names
    * @param labSlot
    * @param zeroPeriod
    * @param periodEight
    * @return
    */
   public static ClassPeriod[] createSchedule(
         Rotation rotation, String[] names, Lab labSlot, boolean zeroPeriod, boolean periodEight) {
      ClassPeriod[] retval = new ClassPeriod[NORMAL_AMT_DAYS];
      if(zeroPeriod)
         retval = new ClassPeriod[retval.length+1];
      if (periodEight)
         retval = new ClassPeriod[retval.length+1];
      int rotationIndex = 0;
      for (int slot = 0; slot < retval.length; slot++) {
         if (zeroPeriod && slot == 0) 
            retval[slot] = new ClassPeriod(slot, names[slot], 
                  RotationConstants.PERIOD_ZERO.getStartTime(), RotationConstants.PERIOD_ZERO.getEndTime());
         if (periodEight && slot == 8)
            retval[slot] = new ClassPeriod(slot, names[slot], 
                  RotationConstants.PERIOD_EIGHT.getStartTime(), RotationConstants.PERIOD_EIGHT.getEndTime());
         else {
            retval[slot] = new ClassPeriod(slot, names[slot],
                  rotation.getTimes()[rotationIndex].getStartTime(), rotation.getTimes()[rotationIndex].getEndTime());
            rotationIndex++;
         }
      }
      return retval;
   }
   
   public ClassPeriod classAt(Time t) {
      for (ClassPeriod c : classes)
         if (c.contains(t))
            return c;
      return null;
   }
   
   public void setLunchLab(Rotation r) {
      if (get(RotationConstants.LUNCH) == null)
         return;
      if (debug) System.out.println(getName() + "has lunch lab on"+r);
      for (int i = 0; i <labs.length; i++) {
         if (labs[i].getRotation().equals(r)) {
            if (debug) System.out.println(getName()+" lunch:"+get(RotationConstants.LUNCH).getInfo());
            else System.out.println("HOLUP "+getName());
            get(RotationConstants.LUNCH).setName("Lunch (Lab)");
         }
         else if (i == labs.length-1)
            get(RotationConstants.LUNCH).setName("Lunch");
      }
   }
   
   public Schedule clone(boolean showName) {
      if (debug) System.out.println(name+" cloned. showName:"+showName);
      Schedule retval = new Schedule();
      retval.setClasses(classes);
      retval.setLabs(getLabs());
      retval.setName(getName()+"(Clone)");
      return retval;
   }
   
   public Schedule cloneAndTrim(boolean showName) {
      Schedule s = clone(showName);
      s.trimStrings();
      return s;
   }
   
   public Schedule clone() {
     return clone(true);
   }
   
   public void setData(Schedule s) {
      setClasses(s.getClasses());
      setLabs(s.getLabs());
      setPascackPreferences(s.getPascackPreferences());
      calculateSchoolDay();
   }
   
   public static void trimStrings(ClassPeriod[] classes) {
      for (ClassPeriod c : classes) {
         c.setName(ClassPeriod.trimString(c.getName(),20));
         c.setTeacher(ClassPeriod.trimString(c.getTeacher(),15));
         c.setRoomNumber(ClassPeriod.trimString(c.getRoomNumber(),10));
      }
   }
   
   public void setPascackData() {
      if (get(RotationConstants.PASCACK) != null) {
         get(RotationConstants.PASCACK).setData(pascackPreferences);
      }
   }
   
   public ClassPeriod getPascack() {
      ClassPeriod ret = RotationConstants.getPascack();
      ret.setData(pascackPreferences);
      return ret;
   }
   
   public void trimStrings() {
      trimStrings(classes);
   }
   
   public ClassPeriod get(String name) {
      for (ClassPeriod c : classes) 
         if (c.getName().equalsIgnoreCase(name))
            return c;
      return null;
   }
   
   public ClassPeriod get(int slot) {
      for (ClassPeriod c : classes) {
         if (c == null)
            ErrorID.showError(ErrorID.SCHEDULE_NULL, false);
         if (debug) System.out.println(getName()+" searchign through" + c);
         if (c.getSlot() == slot) {
            return c;
         }
      }
      return null;
   }
   
   public int indexOf(ClassPeriod c) {
      for (int i = 0; i < classes.length; i++)
         if (c == classes[i])
            return i;
      return -1;
   }
   
   public int indexOf(int slot) {
      for (int i = 0; i <classes.length; i++)
         if (classes[i].getSlot() == slot)
            return i;
      return -1;
   }
   
   public String classInfoString() {
      String retval = "";
      for (ClassPeriod c : classes)
         retval += c.getInfo() + ", ";
      return retval;
   }
   
   public void setShowName(boolean showName) {
      for (ClassPeriod c : classes) {
         c.setShowName(showName);
      }
   }
   
   public String classString(boolean newLine) {
      String retval = "";
      String newLn = (newLine) ? "\n" : "";
      String tab = (newLine) ? "\t" : "";
      for (ClassPeriod c : classes)
         retval += tab+c.toString() +", "+newLn;
      return retval;
   }
   
   public String toString() {
      return getClass().getName()+"[amtClasses="+classes.length+" starts:"+schoolDay.getStartTime()
      +" ends:"+schoolDay.getEndTime()+"]";
   }
   
   public void calculateSchoolDay() {
      if (classes.length > 0)
         schoolDay = new ClassPeriod(
            -1, "schoolDay", classes[0].getStartTime(), 
            classes[classes.length-1].getEndTime(), ClassPeriod.NO_TEACH, ClassPeriod.NO_ROOM);
      else
         schoolDay = new ClassPeriod();
   }
   
   public ClassPeriod[] getClasses() {
      return classes;
   }
   public void setClasses(ClassPeriod[] classes) {
      this.classes = classes;
   }
   public Lab[] getLabs() {
      return labs;
   }
   public void setLabs(Lab[] labs) {
      this.labs = labs;
   }
   public static int getNormalAmtDays() {
      return NORMAL_AMT_DAYS;
   }
   public ClassPeriod getSchoolDay() {
      return schoolDay;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public ClassPeriod getPascackPreferences() {
      return pascackPreferences;
   }
   public void setPascackPreferences(ClassPeriod pascackPreferences) {
      this.pascackPreferences = pascackPreferences;
   }
}
