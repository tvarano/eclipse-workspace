import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Finland extends JPanel implements MouseListener, MouseMotionListener, KeyListener, ActionListener
{
   private static final long serialVersionUID = 1L;
   private static final int PREF_W = 1000;
   private static final int PREF_H = 800;
   private RenderingHints hints = new RenderingHints(
      RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   private Font font = new Font("Prestige Elite Std", Font.BOLD, 20);
   private Timer timer = new Timer(5,this);
   private Image finland, otherThing;
   private boolean printFin;

   public Finland() {
      setBackground(Color.WHITE);
      addMouseListener(this);
      addMouseMotionListener(this);
      addKeyListener(this);
      setFocusable(true);
      requestFocus();
      try {
         finland = ImageIO.read(new File("src/FINAWIFIN.gif"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      try {
         otherThing = ImageIO.read(new File("src/FINANOFIN.jpg"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      printFin = true;
      timer.start();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHints(hints);
      g2.setColor(Color.WHITE);
      g2.setFont(font);
      if (printFin){
         g2.drawImage(finland, 0, 0, PREF_W, PREF_H, this);
         g2.drawString("PRESS SPACE TO SHOW THE TRUTH", 20, 30);
      }
      else 
         g2.drawImage(otherThing, 0, 0, PREF_W, PREF_H, this);

   }

   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGUI() {
      JFrame frame = new JFrame("The Truth Behind Finland");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new Finland());
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
         printFin = !printFin;
      repaint();
   }

   @Override
   public void keyReleased(KeyEvent e){
   }

   @Override
   public void actionPerformed(ActionEvent e){
   }
}