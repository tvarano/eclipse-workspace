//Thomas Varano
//[Program Descripion]
//Nov 16, 2016
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

   public class PointTester extends JPanel implements MouseListener, MouseMotionListener, KeyListener
   {
      private static final long serialVersionUID = 1L;
      private static final int PREF_W = 1000;
      private static final int PREF_H = 800;
      boolean dragging;
      private Point p1;
      private RenderingHints hints = new RenderingHints(
         RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      private Font font = new Font("Prestige Elite Std", Font.PLAIN, 25);

      public PointTester() 
      {  
         p1 = new Point(200,200,"p1");
         setBackground(Color.WHITE);
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
         g2.drawString("Mouse listening is fun (v16.11.1)", 100, 200);

         g2.setFont(font);
         g2.setColor(Color.BLACK);
         if (dragging)
            g2.setColor(Color.PINK);
         else
            g2.setColor(Color.BLUE);
         g2.drawOval(p1.getX()-5, p1.getY()-5, 10, 10);
      }

      public Dimension getPreferredSize() {
         return new Dimension(PREF_W, PREF_H);
      }

      private static void createAndShowGUI() {
         JFrame frame = new JFrame("Poitn Class");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.getContentPane().add(new PointTester());
         frame.pack();
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
         
      }

      public static void main(String[] args) {
         Point p1 = new Point(400,300);
         Point p2 = new Point();
         Point p3 = new Point(40,60,"label");
         p2.setX(10);
         System.out.println(p1.distanceToOrigin());
         System.out.println(p1.getMidpointWith(500, 400));
         System.out.println(p3.getLabel());
      
         SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               createAndShowGUI();
            }
         });
      }

      @Override
      public void mouseDragged(MouseEvent e)
      {
         System.out.println(p1.getX()+","+p1.getY());
         p1.setX(e.getX());
         p1.setY(e.getY());
         if (p1.getX() - 5 < 0)
            p1.setX(5);
         if (p1.getX()+5 > getWidth())
            p1.setX(getWidth()-5);
         if (p1.getY()-5 < 0)
            p1.setY(5);
         if (p1.getY()+5 > 800)
            p1.setX(getHeight()-5);
         repaint();
      }

      @Override
      public void mouseMoved(MouseEvent e){}

      @Override
      public void mouseClicked(MouseEvent e){}

      @Override
      public void mousePressed(MouseEvent e)
      {
         System.out.println("pressing the mouse");
         dragging = true;
         repaint();
      }

      @Override
      public void mouseReleased(MouseEvent e){
         dragging = false;
         repaint();
      }

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
      }

      @Override
      public void keyReleased(KeyEvent e)
      {
      }
}
