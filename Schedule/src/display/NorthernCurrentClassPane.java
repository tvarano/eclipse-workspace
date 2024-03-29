package display;
import java.time.LocalTime;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import information.ClassPeriod;
import information.Time;

//Thomas Varano
//[Program Descripion]
//Sep 14, 2017

public class NorthernCurrentClassPane extends JPanel
{
   private static final long serialVersionUID = 1L;
   private CurrentInfo field;
   private ClassPeriod classPeriod;
   private CurrentClassPane parentPanel;
   private Time time;
   private boolean inSchool;
   private boolean debug = false;
   
   public NorthernCurrentClassPane(ClassPeriod c, CurrentClassPane parent) {
      if (debug)
         System.out.println("northParent: "+parent);
      inSchool = (c == null);
      setClassPeriod(c); setParentPane(parent); setName(parent.getName()+" north pane");
      time = new Time(LocalTime.now().getHour(), LocalTime.now().getMinute());
      field = new CurrentInfo(c, this);
      int gap = 7;
      field.setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));
      if (debug)
         System.out.println("time: "+time);
      setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
      add(field);
      setVisible(true);
   }
   
   public Time getTimeLeft() {
      if (inSchool)
         return classPeriod.getEndTime().minus(time);
      else return new Time();
   }
   public void pushCurrentTime(Time t) {
      inSchool = parentPanel.checkInSchool();
      setTime(t);
      field.repaintText();
   }
   
   public void update() {
      
   }
   
   public void pushClassPeriod(ClassPeriod c) {
      setClassPeriod(c);
      field.pushClassPeriod(c);
      field.repaint();
   }

   public Time getTime() {
      return time;
   }
   public void setTime(Time time) {
      this.time = time;
   }
   public ClassPeriod getClassPeriod() {
      return classPeriod;
   }
   public void setClassPeriod(ClassPeriod classPeriod) {
      this.classPeriod = classPeriod;
   }
   public CurrentClassPane getParentPane() {
      return parentPanel;
   }
   public void setParentPane(CurrentClassPane parentPane) {
      this.parentPanel = parentPane;
   }
   public boolean isInSchool() {
      return inSchool;
   }
   
}
