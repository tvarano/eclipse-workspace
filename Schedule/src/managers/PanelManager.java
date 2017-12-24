package managers;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

import display.DisplayMain;
import information.Schedule;
import input.InputMain;

//Thomas Varano
//[Program Descripion]
//Sep 20, 2017

public class PanelManager
{
   private Main parent;
   private JFrame f;
   private DisplayMain display;
   private InputMain input;
   public static final JTextField disclaimer = new JTextField("ALPHA BUILD. REPORT ERRORS.");
   public PanelManager(Main parent, JFrame f) {
      setF(f); setParent(parent);
      display = new DisplayMain(this);  display.setName("display");
      input = new InputMain(this);  input.setName("input");
      parent.setLayout(new CardLayout());
//      JScrollPane inputScroll = new JScrollPane(input); inputScroll.setName(input.getName()+" scrollPane");
//      inputScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
//      inputScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      parent.add(display, display.getName());
      parent.add(input, input.getName());
   }
   
   public void setCurrentPane(boolean inputting) {
      if (inputting)
          ((CardLayout) parent.getLayout()).show(parent, input.getName());
      else 
         ((CardLayout) parent.getLayout()).show(parent, display.getName());
   }
   
   public void startInput(Schedule s) {
      display.stop();
      input.setBeginningSchedule(s);
      setCurrentPane(true);
   }
   
   public void finishInputting() {
      display.reinitialize();
      setCurrentPane(false);
   }
   
   public Main getParent() {
      return parent;
   }
   public void setParent(Main parent) {
      this.parent = parent;
   }
   public JFrame getF() {
      return f;
   }
   public void setF(JFrame f) {
      this.f = f;
   }
}