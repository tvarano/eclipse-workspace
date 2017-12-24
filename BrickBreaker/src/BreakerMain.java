import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class BreakerMain extends JPanel implements MouseListener, MouseMotionListener, KeyListener, ActionListener
{
   private static final long serialVersionUID = 1L;
   public static final int PREF_W = 1000;
   public static final int PREF_H = 800;
   private RenderingHints hints = new RenderingHints(
      RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   private Font font = new Font("Prestige Elite Std", Font.PLAIN, 25);
   private Paddle player;
   private PongBall ball;
   private Timer timer = new Timer(5,this);

   public BreakerMain() {
      setBackground(Color.WHITE);
      addMouseListener(this);
      addMouseMotionListener(this);
      addKeyListener(this);
      setFocusable(true);
      requestFocus();
      player = new Paddle(0,600,100,10);
      ball = new PongBall(PREF_W/2, PREF_H/2, 20, 20, 1, 1, new Rectangle(0,0,PREF_W,PREF_H));
      
      timer.start();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHints(hints);

      g2.setFont(font);
      g2.setColor(Color.BLACK);
      player.draw(g2);
      ball.drawBall(g2);      
      System.out.println(ball.getX());
   }

   public void update(){
      player.update();
      player.collide(ball);
      ball.update();
   }
   
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }
   private static void createAndShowGUI() {
      JFrame frame = new JFrame("BB");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new BreakerMain());
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
   public void mouseDragged(MouseEvent e){
      System.out.println("dragging the mouse");
   }

   @Override
   public void mouseMoved(MouseEvent e){}

   @Override
   public void mouseClicked(MouseEvent e){}

   @Override
   public void mousePressed(MouseEvent e){
      System.out.println("pressing the mouse");
   }

   @Override
   public void mouseReleased(MouseEvent e){}

   @Override
   public void mouseEntered(MouseEvent e){}

   @Override
   public void mouseExited(MouseEvent e){}

   @Override
   public void keyTyped(KeyEvent e){
      
   }

   @Override
   public void keyPressed(KeyEvent e){
      System.out.println("keypress"+e.getKeyCode());
      int key = e.getKeyCode();
      if (key == KeyEvent.VK_LEFT)
         player.setLeft(true);
      else if (key == KeyEvent.VK_RIGHT)
         player.setRight(true);
   }

   @Override
   public void keyReleased(KeyEvent e){
      int key = e.getKeyCode();
      if (key == KeyEvent.VK_LEFT)
         player.setLeft(false);
      else if (key == KeyEvent.VK_RIGHT)
         player.setRight(false);
   }

   @Override
   public void actionPerformed(ActionEvent e){
      update();
      repaint();
   }
}