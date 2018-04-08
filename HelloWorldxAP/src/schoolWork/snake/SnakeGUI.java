//Thomas Varano
//Mar 29, 2018

package schoolWork.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakeGUI extends JPanel implements KeyListener{
   private static final long serialVersionUID = 1L;

   public static final int PREF_W = 800, PREF_H = 600;
   
   private Snake snake1;
   private Timer timer;
   
   public SnakeGUI() {
      this.addKeyListener(this);
      setFocusable(true);
      snake1 = new Snake(PREF_W / 2, PREF_H / 2, 25, 25, Snake.SPEED, 0, PREF_W, PREF_H, Color.BLUE);
      timer = new Timer(20, new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            update();
            repaint();
         }
      });
      timer.start();
   }
   
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
      g2.setColor(Color.WHITE);
      g2.fillRect(0, 0, getWidth(), getHeight());
      snake1.drawSnake(g2);
   }
   
   public void update() {
      snake1.update();
   }
   
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W,PREF_H);
   }
   
   private static void createAndShowGUI() {
      JFrame f = new JFrame("Snake");
      f.getContentPane().add(new SnakeGUI());
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.pack();
      f.setLocationRelativeTo(null);
      f.setVisible(true);
   }
   
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }

   @Override
   public void keyPressed(KeyEvent arg0) {
      int key = arg0.getKeyCode();
      snake1.keyPressed(key);
   }

   @Override
   public void keyReleased(KeyEvent arg0) {}

   @Override
   public void keyTyped(KeyEvent arg0) {}
}
