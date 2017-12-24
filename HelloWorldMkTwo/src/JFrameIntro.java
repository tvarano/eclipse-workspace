import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

//Thomas Varano
//NO MAKE A PANELELELE
//Feb 23, 2017

public class JFrameIntro extends JFrame
   implements ActionListener, MouseListener, MouseMotionListener, KeyListener
{
   private static final long serialVersionUID = 1L;
   
   public static final int PREF_W = 1000;
   public static final int PREF_H = 820;
   private JButton[] buttons = {
         new JButton("1"),new JButton("2"),new JButton("3"),new JButton("4"),new JButton("5"),new JButton("6"),};
   private JTextArea textBox = new JTextArea();
   
   public JFrameIntro(){
      super("TITLE");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      pack();
      setLocationRelativeTo(null);
      setResizable(false);
      setLayout(new GridLayout(2,3,30,50));
      
      add(buttons[0]); add(buttons[1]); add(buttons[2]); add(buttons[3]); add(buttons[4]); add(textBox);
   }
   
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public static void main(String[] args) {
      new JFrameIntro().setVisible(true);
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
   public void actionPerformed(ActionEvent e) {
   }

}
