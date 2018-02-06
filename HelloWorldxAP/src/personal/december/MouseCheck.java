//Thomas Varano
//[Program Descripion]
//Dec 6, 2017

package personal.december;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class MouseCheck
{
   public static void main(String[] args) {
      JFrame f = new JFrame("heyo");
      f.addMouseListener(new MouseListener() {
         @Override
         public void mouseClicked(MouseEvent arg0) {}
         @Override
         public void mouseEntered(MouseEvent arg0) {
            System.out.println("ENTERERD");
         }

         @Override
         public void mouseExited(MouseEvent arg0) {
            System.out.println("EXIT");
         }
         @Override
         public void mousePressed(MouseEvent arg0) {}
         @Override
         public void mouseReleased(MouseEvent arg0) {}
      });
      f.setVisible(true);
   }
}
