package schoolWork.flappy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class FlappyBird extends JPanel implements KeyListener
{
   private static final long serialVersionUID = 1L;
   public static final int PREF_W = 600;
   public static final int PREF_H = 900;
   private static final int DELAY = 10;
   private RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                                                                RenderingHints.VALUE_ANTIALIAS_ON);
   private Sprite player;
   private PipeManager pm;
   
   public FlappyBird() {
      addKeyListener(this);
      setFocusable(true);

      player = new Sprite(PREF_W/2, PREF_H/2);
      pm = new PipeManager(PREF_W, 200); 
      setBackground(Color.CYAN);

      new Timer(DELAY, new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            update();
            repaint();
         }
      }).start();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHints(hints);
//      g2.setBackground(Color.CYAN);

      player.draw(g2);
      if (collision()) g2.setColor(Color.RED);
      else g2.setColor(Color.GREEN);
      pm.draw(g2);
   }

   public void update() {
      player.update();
      pm.update();
      
   }

   public boolean collision() {
      
       return player.collide(pm);
   }
   
   @Override
   public void keyPressed(KeyEvent e) {
      int key = e.getKeyCode();
      if(key == KeyEvent.VK_SPACE)
         player.jump();
   }

   @Override
   public void keyReleased(KeyEvent e){}

   @Override
   public void keyTyped(KeyEvent arg0){}

   private static void createAndShowGUI() {
      FlappyBird gamePanel = new FlappyBird();

      JFrame frame = new JFrame("Frame Game");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(gamePanel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }
}