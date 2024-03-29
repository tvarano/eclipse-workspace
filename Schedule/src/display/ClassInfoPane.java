package display;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import information.ClassPeriod;
import information.Time;

//Thomas Varano
//[Program Descripion]
//Sep 10, 2017

public class ClassInfoPane extends JTextPane
{
   private static final long serialVersionUID = 1L;
   private ClassPeriod c;
   private boolean thinConstraints, debug;
   
   public ClassInfoPane(ClassPeriod c) {
      super();
      debug = false;
      setName("unNamedInfoPane");
      this.setEditable(false);
      this.setClassPeriod(c);
      this.setMinimumSize(new Dimension(60,60));
   }
   
   private void createClassDetailPane() {
      if (debug) System.out.println(getName() + "Parent"+getParent());
      if (c == null) {
         if (getParent() instanceof CurrentClassPane) {
            if (((CurrentClassPane) getParent()).isInSchool())
               setText("In Between Classes. \nNext Class is:\n"+((CurrentClassPane) getParent()).findNextClass());
            else
               setText("Not in school");
         }
         else 
            setText("Class not selected");
         return;
      }
      this.setText("");
      String newLine = "\n";
      String tab = (thinConstraints) ?"     ":"";
      if (debug)
         System.out.println(c);
      String teacher = (thinConstraints) ? "Teacher: " + c.getTeacher() + newLine 
            : "Teacher: " + c.getTeacher() + newLine;
      String classLength = (thinConstraints) ? 
            "Class Length:"+ newLine +c.getDuration().getHour12()+" hours, "+c.getDuration().getMinute()+" minutes" : 
         "Class Length: "+c.getDuration().getHour12()+" hours, "+c.getDuration().getMinute()+" minutes";
      String[] uneditedText = {
            tab + "Rm. " + c.getRoomNumber()+newLine, 
            tab + teacher,
            tab + c.getStartTime() + " - " + c.getEndTime()+newLine,
            tab + classLength
      };
      String[] styles = {
            "plain", 
            "plain",
            "bold",
            "italic"
      };
      StyledDocument styleDoc = getStyledDocument();
      initStyles(styleDoc);
      try {
         for (int i=0; i < uneditedText.length; i++) {
            styleDoc.insertString(styleDoc.getLength(), uneditedText[i],
                  styleDoc.getStyle(styles[i]));
         }
     } catch (BadLocationException e) {
         System.err.println("Couldn't insert initial text into text pane.");
     }
   }
   
   private void initStyles(StyledDocument doc) {
      Style def = StyleContext.getDefaultStyleContext().
            getStyle(StyleContext.DEFAULT_STYLE);

      Style regular = doc.addStyle("regular", def);
      StyleConstants.setFontFamily(def, "SansSerif");
      
      Style s = doc.addStyle("italic", regular);
      StyleConstants.setItalic(s, true);
      
      s = doc.addStyle("bold", regular);
      StyleConstants.setBold(s, true);
   }

   public ClassPeriod getClassPeriod() {
      return c;
   }
   
   public void setClassPeriod(ClassPeriod c) {
      this.c = c;
      createClassDetailPane();
   }

   public boolean isThinConstraints() {
      return thinConstraints;
   }

   public void setThinConstraints(boolean thinConstraints) {
      this.thinConstraints = thinConstraints;
   }

   public static void main(String[] args) {
      JFrame frame = new JFrame("InfoPaneTest");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(new ClassInfoPane(new ClassPeriod(2, "PeriodText", new Time(13,00), new Time(15,00))));
      frame.pack();
      frame.setVisible(true);
   }
}
