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

public class TetrisMenu extends JPanel implements MouseListener, MouseMotionListener, KeyListener, ActionListener
{
   private static final long serialVersionUID = 1L;
   private static final int PREF_W = 1000;
   private static final int PREF_H = 800;
   public static Rectangle startButton = new Rectangle(PREF_W/2-200, 350, 400, 200);
   public boolean initGame;
   private RenderingHints hints = new RenderingHints(
      RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   private Font font = Tetris.font;
   private Timer timer = new Timer(5,this);

   public TetrisMenu() {
      setBackground(Tetris.background);
      setForeground(Color.CYAN);
      addMouseListener(this);
      addMouseMotionListener(this);
      addKeyListener(this);
      setFocusable(true);
      requestFocus();
      timer.start();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHints(hints);

      g2.setFont(font);
    g2.drawString("Welcome to Tetris", PREF_W/2-260, 100);
    g2.drawString("by Thomas Varano", PREF_W/2-245, 200);
    g2.fill(startButton);
    g2.setColor(Color.BLACK);
    g2.drawString("Click Here", (int)startButton.getX()+15, (int)(startButton.getY()+60));
    g2.drawString("To Play", (int)startButton.getX()+15, (int)(startButton.getY()+150));
   }

   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

//   private static void createAndShowGUI() {
//      JFrame frame = new JFrame("TITLEE");
//      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      frame.getContentPane().add(new JFrameTemplate());
//      frame.pack();
//      frame.setLocationRelativeTo(null);
//      frame.setVisible(true);   
//   }

   public static void main(String[] args) {
//      SwingUtilities.invokeLater(new Runnable() {
//         public void run() {
//            createAndShowGUI();
//         }
//      });
      new TetrisMenu();
   }

   @Override
   public void mouseDragged(MouseEvent e){
      System.out.println("dragging the mouse");
   }

   @Override
   public void mouseMoved(MouseEvent e){}

   @Override
   public void mouseClicked(MouseEvent e){
      initGame = (startButton.contains(e.getPoint()));
   }

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
      System.out.println("STILL IN MENU");
   }

   @Override
   public void keyReleased(KeyEvent e){
   }

   @Override
   public void actionPerformed(ActionEvent e){
   }
}