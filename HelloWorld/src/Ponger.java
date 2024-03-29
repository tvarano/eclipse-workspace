import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Ponger extends JPanel implements MouseListener, MouseMotionListener, KeyListener
{
   private static final long serialVersionUID = 1L;
   private static final int PREF_W = 1000;
   private static final int PREF_H = 800;
   private RenderingHints hints = new RenderingHints(
      RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   private Font font = new Font("Prestige Elite Std", Font.PLAIN, 25);
   private PongPaddle left = new PongPaddle(50,400,150,20, getHeight());
   private PongPaddle right = new PongPaddle(getHeight()-100,400,150,20, getHeight());
   private PongBall ball = new PongBall(getWidth()/2,getHeight()/2, 20, 20, 2);

   public Ponger() 
   {
      setBackground(Color.BLACK);
      addMouseListener(this);
      addMouseMotionListener(this);
      addKeyListener(this);
      setFocusable(true);
      requestFocus();
      
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHints(hints);

      g2.setFont(font);
      g2.setColor(Color.WHITE);
      g2.drawRect(left.getX(), left.getY(), left.getWidth(), left.getHeight());
      g2.drawRect(right.getX(), right.getY(), right.getWidth(), right.getHeight());
      g2.drawString(ball.scoreCountLeft()+":"+ball.scoreCountRight(), getWidth()/2, 50);
   }

   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGUI() {
      JFrame frame = new JFrame("Pong");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new Ponger());
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }

   @Override
   public void mouseDragged(MouseEvent e)
   {
      System.out.println("dragging the mouse");
   }

   @Override
   public void mouseMoved(MouseEvent e){}

   @Override
   public void mouseClicked(MouseEvent e){}

   @Override
   public void mousePressed(MouseEvent e)
   {
      System.out.println("pressing the mouse");
   }

   @Override
   public void mouseReleased(MouseEvent e){}

   @Override
   public void mouseEntered(MouseEvent e){}

   @Override
   public void mouseExited(MouseEvent e){}

   @Override
   public void keyTyped(KeyEvent e)
   {
   }

   @Override
   public void keyPressed(KeyEvent e)
   {
      System.out.println("keypress"+e.getKeyCode());
      System.out.println(left.getY());
      repaint();
      int key = e.getKeyCode();
      if(key == KeyEvent.VK_UP){
         left.setY(left.getY()-15);
      }
      
      if(key == KeyEvent.VK_DOWN){
         left.setY(left.getY()+15);
      }
      
      if(key == KeyEvent.VK_W){
         right.setY(right.getY()-15);
      }
      
      if(key == KeyEvent.VK_S){
         right.setY(right.getY()+15);
      }
   
   //stay on screen
      if (left.checkIfOffPage() == false){
         if (left.getY() < 0){
            left.setY(0);
         }
         if (left.getY()+left.getHeight() > getHeight()){
            left.setY(getHeight() - left.getHeight());
         }
      }
      if (right.checkIfOffPage() == false){
         if (right.getY() < 0){
            right.setY(0);
         }
         if (right.getY()+right.getHeight() > getHeight()){
            right.setY(getHeight() - right.getHeight());
         }
      }
   }

   @Override
   public void keyReleased(KeyEvent e)
   {
   }
}