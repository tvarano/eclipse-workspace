import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

//Thomas Varano
//[Program Descripion]
//Feb 27, 2017

/*
 * GUI QUESTIONS
 *    add more than one panel
 *    jeditor pane
 *       URL
 *          txt file
 *    
 */

public class WorkingFrame
   extends JFrame 
   implements KeyListener, MouseListener, MouseMotionListener
   
{
   private static final long serialVersionUID = 1L;
   public static int PREF_W = 1000;
   public static int PREF_H = 800;

   public WorkingFrame(){
      super("frame");
      setSize(PREF_W,PREF_H);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      add(new BackgroundPane());
      add(new TryPanes());
      pack();
      setVisible(true);
   }

   public static void main(String[] args) {
      new WorkingFrame();
   }

   @Override
   public void mouseDragged(MouseEvent e) {
   }

   @Override
   public void mouseMoved(MouseEvent e) {
   }

   @Override
   public void mouseClicked(MouseEvent e) {
   }

   @Override
   public void mousePressed(MouseEvent e) {
   }

   @Override
   public void mouseReleased(MouseEvent e) {
   }

   @Override
   public void mouseEntered(MouseEvent e) {
   }

   @Override
   public void mouseExited(MouseEvent e) {
   }

   @Override
   public void keyTyped(KeyEvent e) {
   }

   @Override
   public void keyPressed(KeyEvent e) {
   }

   @Override
   public void keyReleased(KeyEvent e) {
   }

}
