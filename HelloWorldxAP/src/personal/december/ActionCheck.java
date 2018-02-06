//Thomas Varano
//[Program Descripion]
//Dec 11, 2017

package personal.december;

import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class ActionCheck
{
   public static void main(String[] args) {
      JTextPane j = new JTextPane();
      JFrame f = new JFrame("a");
      f.getContentPane().add(j);
      f.setVisible(true);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      j.addInputMethodListener(new InputMethodListener() {
         @Override
         public void caretPositionChanged(InputMethodEvent arg0) {
            System.out.println("caret changed");
         }

         @Override
         public void inputMethodTextChanged(InputMethodEvent arg0) {
            System.out.println("input changed");
         }
      });
      j.addKeyListener(new KeyListener() {
         @Override
         public void keyPressed(KeyEvent arg0) {
         }

         @Override
         public void keyReleased(KeyEvent arg0) {
         }

         @Override
         public void keyTyped(KeyEvent arg0) {
         }
         
      });
      j.addHyperlinkListener(new HyperlinkListener() {

         @Override
         public void hyperlinkUpdate(HyperlinkEvent arg0) {
            System.out.println("WHEN IS THIS");
         }
         
      });
   }
}
