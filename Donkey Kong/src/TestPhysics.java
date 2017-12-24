import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class TestPhysics extends JPanel implements MouseListener, MouseMotionListener, KeyListener, ActionListener
{
   private static final long serialVersionUID = 1L;
   private static final int PREF_W = 1000;
   private static final int PREF_H = 800;
   private RenderingHints hints = new RenderingHints(
      RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   private Font font = new Font("Prestige Elite Std", Font.PLAIN, 25);
   private Timer timer = new Timer(5,this);
   private Sprite sprite = new Sprite(50,709,50,50,1,0.07,3);
   private ArrayList<Platform> platforms = new ArrayList<Platform>();

   public TestPhysics() {
      setBackground(Color.WHITE);
      addMouseListener(this);
      addMouseMotionListener(this);
      addKeyListener(this);
      setFocusable(true);
      requestFocus();
      platforms.add(new Platform());
      timer.start();
      sprite.setPlatforms(platforms);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHints(hints);

      g2.setFont(font);
      g2.setColor(Color.BLACK);
      g2.drawString("Mouse listening is fun (v16.11.1)", 100, 200);
      sprite.draw(g2);
   }

   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGUI() {
      JFrame frame = new JFrame("TITLEE");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new TestPhysics());
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
      if (key == KeyEvent.VK_SPACE)
         sprite.setJumping(true);
      if (key == KeyEvent.VK_LEFT)
         sprite.setLeft(true);
      if (key == KeyEvent.VK_RIGHT)
         sprite.setRight(true);
   }

   @Override
   public void keyReleased(KeyEvent e){
      int key = e.getKeyCode();
      if (key == KeyEvent.VK_LEFT)
         sprite.setLeft(false);
      if (key == KeyEvent.VK_RIGHT)
         sprite.setRight(false);
   }

   @Override
   public void actionPerformed(ActionEvent e){
      sprite.update();
      repaint();
   }
}