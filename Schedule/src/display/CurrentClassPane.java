package display;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalTime;

import javax.swing.JPanel;

import information.ClassPeriod;
import information.Schedule;
import information.Time;

//Thomas Varano
//[Program Descripion]
//Sep 14, 2017

public class CurrentClassPane extends JPanel
{
   private static final long serialVersionUID = 1L;
   private ClassInfoPane info;
   private JPanel parentPane;
   private Time currentTime;
   private NorthernCurrentClassPane northPane;
   private SouthernCurrentClassPane southPane;
   private ClassPeriod classPeriod;
   private Schedule sched;
   private boolean inSchool; 
   private boolean debug = false;
   
   public CurrentClassPane(ClassPeriod c, Schedule s, JPanel parent) {
      setName("currentClassPane");
      currentTime = new Time(LocalTime.now().getHour(), LocalTime.now().getMinute());
      inSchool = (c == null);
      setClassPeriod(c); setSched(s); setParentPane(parent);
      if (debug) {
         System.out.println("classPane class:"+c);
         System.out.println("classPane sched:"+getSched());
      }
      setLayout(new GridLayout(2,1));
      northPane = new NorthernCurrentClassPane(c, this);
      southPane = new SouthernCurrentClassPane(c, s, this);
      add(northPane);
      add(southPane);
   }

   /**
    * assumes the user is in between classes
    * @return
    */
   public ClassPeriod findNextClass() {
      if (inSchool)
         return sched.classAt(new Time(currentTime.getTotalMins()+5));
      return null;
   }
   
   public ClassPeriod findPreviousClass() {
      if (inSchool)
         return sched.classAt(new Time(currentTime.getTotalMins()-5));
      return null;
   }
   
   public Time timeUntilNextClass() {
      if (inSchool)
         return currentTime.getTimeUntil(findNextClass().getStartTime());
      return new Time();
   }
   
   //TODO checkInSchool method
   public boolean checkInSchool() {
      inSchool = sched.getSchoolDay().contains(currentTime);
      return inSchool;
   }
   
   public Time timeUntilSchool() {
      return currentTime.getTimeUntil(sched.getSchoolDay().getStartTime());
   }
   public void update() {
      southPane.update();
      northPane.update();
      revalidate();
   }
   
   public Dimension getMinimumSize() {
      return new Dimension(100, 200);
   }
   public Dimension getPreferredSize() {
      return new Dimension(550, (int) parentPane.getPreferredSize().getHeight());
   }
   public void pushCurrentTime(Time t) {
      setCurrentTime(t);
      checkInSchool();
      northPane.pushCurrentTime(t);
   }
   public void pushClassPeriod(ClassPeriod c) {
      if (debug) System.out.println(getName() + " pushed " +c);
      checkInSchool();
      setClassPeriod(c);
      northPane.pushClassPeriod(c);
      southPane.pushClassPeriod(c);
         
   }
   public void pushTodaySchedule(Schedule s) {
      setSched(s);
      southPane.pushTodaySchedule(s);
   }   
   
   public boolean isInSchool() {
      return inSchool;
   }
   public void setInSchool(boolean inSchool) {
      this.inSchool = inSchool;
   }
   public void setSched(Schedule sched) {
      this.sched = sched;
   }
   public Schedule getSched() {
      return sched;
   }
   public ClassPeriod getClassPeriod() {
      return classPeriod;
   }
   public void setClassPeriod(ClassPeriod classPeriod) {
      this.classPeriod = classPeriod;
   }
   public ClassInfoPane getInfo() {
      return info;
   }
   public NorthernCurrentClassPane getNorthPane() {
      return northPane;
   }
   public JPanel getParentPane() {
      return parentPane;
   }
   public void setParentPane(JPanel parent) {
      this.parentPane = parent;
   }
   public Time getCurrentTime() {
      return currentTime;
   }
   public void setCurrentTime(Time currentTime) {
      this.currentTime = currentTime;
   }
}
