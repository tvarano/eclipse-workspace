package schoolWork.before;
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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class NestedLoopGUI extends JPanel implements MouseListener, KeyListener
{
   private static final long serialVersionUID = 1L;
   private RenderingHints hints = new RenderingHints(
         RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   private static JFrame frame;
   public int click, loop, move;
   
   public NestedLoopGUI()
   {
      click = 0;
      loop = 0;
      move = 0;

      this.setBackground(Color.WHITE);
      addMouseListener(this);
      addKeyListener(this);
      setFocusable(true);
      requestFocus();
   }
   
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHints(hints);

      g2.setFont(new Font("Cooper Black", Font.PLAIN, 40));
      loop = 0;
      if(click>20) {click=0; move++;}
      else if (click < 0) {click = (move == 0) ? 0 : 20; move--;}
      if (move < 0) move = 0;
      g2.drawString("CLIKS"+click, 0, 40);
      if(click>=0)
      {
         if(move<1) rowMajorRectangle(g2);
         else if(move<2) rowMajorReverseRectangle(g2);
         else if(move<3) columnMajorRectangle(g2);
         else if(move<4) columnMajorReverseRectangle(g2);
         else if(move<5) upperLeftTri(g2);
         else if(move<6) upperRightTri(g2);
         else if(move<7) lowerLeftTri(g2);
         else if(move<8) lowerRightTri(g2);
         else {
            g2.drawString("FINISHED!", getWidth()/2 - 100, getHeight()/2);
            frame.setTitle("ur dun");
         }
      }
    }
   
   public void rowMajorRectangle(Graphics2D g2)
   {
      frame.setTitle("rowMajorRectangle");
      g2.drawString("rowMajorRectangle", 100, getHeight() - 50);
      
/*1*/ for(int r=0 ; r<4; r++)   //MUST USE r HERE...just change values/conditions
      {
/*2*/    for(int c=0; c<5; c++) //MUST USE c HERE...just change values/conditions
         {
            if(loop < click)
               drawBox(g2, r, c);
            loop++;
         }
      }
   }
   
   public void rowMajorReverseRectangle(Graphics2D g2)
   {
      frame.setTitle("rowMajorReverseRectangle");
      g2.drawString("rowMajorReverseRectangle", 20, getHeight() - 50);

/*3*/ for(int r=3; r>=0; r--)   //MUST USE r HERE...just change values/conditions
      {
/*4*/    for(int c=4; c>=0; c--) //MUST USE c HERE...just change values/conditions
         {
            if(loop < click)
               drawBox(g2, r, c);
            loop++;
         }
      }
   }
   
   public void columnMajorRectangle(Graphics2D g2)
   {
      frame.setTitle("columnMajorRectangle");
      g2.drawString("columnMajorRectangle", 60, getHeight() - 50);
      
/*5*/ for(int c=0 ; c<5; c++)   //MUST USE c HERE...just change values/conditions
      {
/*6*/    for(int r=0; r<4; r++) //MUST USE r HERE...just change values/conditions
         {
            if(loop < click)
               drawBox(g2, r, c);
            loop++;
         }
      }
   }
   
   public void columnMajorReverseRectangle(Graphics2D g2)
   {
      frame.setTitle("columnMajorReverseRectangle");
      g2.drawString("columnMajorReverseRectangle", 0, getHeight() - 50);
      
/*7*/ for(int c=4; c>=0; c--)   //MUST USE c HERE...just change values/conditions
      {
/*8*/    for(int r=3; r>=0; r--) //MUST USE r HERE...just change values/conditions
         {
            if(loop < click)
               drawBox(g2, r, c);
            loop++;
         }
      }
   }
   
   public void upperRightTri(Graphics2D g2)
   {
      frame.setTitle("upperRightTri");
      g2.drawString("upperRightTri", 50, getHeight() - 50);

/*11*/ for(int r=0; r<5; r++)   //MUST USE r HERE...just change values/conditions
      {
/*12*/   for(int c=4; c>=r; c--) //MUST USE c HERE...just change values/conditions
         {
            if(loop < click)
               drawBox(g2, r, c);
            loop++;
         }
      }
   }
   
   public void upperLeftTri(Graphics2D g2)
   {
      frame.setTitle("upperLeftTri");
      g2.drawString("upperLeftTri", 250, getHeight() - 50);

/*9*/for(int r=0 ; r<5; r++)   //MUST USE r HERE...just change values/conditions
      {
/*10*/   for(int c=0; c<5-r; c++) //MUST USE c HERE...just change values/conditions
         {
            if(loop < click)
               drawBox(g2, r, c);
            loop++;
         }
      }
   }
   
   public void lowerLeftTri(Graphics2D g2)
   {
      frame.setTitle("lowerLeftTri");
      g2.drawString("lowerLeftTri", 250, 100);

/*13*/for(int r=4; r>=0; r--)   //MUST USE r HERE...just change values/conditions
      {
/*14*/   for(int c=0; c<=r; c++) //MUST USE c HERE...just change values/conditions
         {
            if(loop < click) 
               drawBox(g2, r, c);
            loop++;
         }
      }
   }
   
   public void lowerRightTri(Graphics2D g2)
   {
      frame.setTitle("lowerRightTri");
      g2.drawString("lowerRightTri", 50, 100);

/*15*/for(int r=4; r>=0; r--)   //MUST USE r HERE...just change values/conditions
      {
/*16*/   for(int c=4-r; c<5; c++) //MUST USE c HERE...just change values/conditions
         {
   // for (int c = 4; c >= 4-r; c--)
            if(loop < click)
               drawBox(g2, r, c);
            loop++;
         }
      }
   }
   
   public void drawBox(Graphics2D g2, int r, int c)
   {
      g2.setFont(new Font("Arial", Font.PLAIN, 15));
      g2.setColor(new Color(10+20*r, 100+10*c, 100+20*r));
      g2.fillRect(50+c*100, 55+r*100, 90, 90);
      g2.setColor(Color.WHITE);
      g2.drawString("r="+r+", c="+c, 65+c*100, 80+r*100);
      g2.setFont(new Font("Cooper Black", Font.PLAIN, 30));
      g2.drawString(""+(loop+1), 80+c*100, 120+r*100);
   }
   
   private static void createAndShowGUI() {
      frame = new JFrame("Click and Draw!");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new NestedLoopGUI());
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }
   
   public Dimension getPreferredSize() {
      return new Dimension(600, 600);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }
   
   @Override
   public void mouseClicked(MouseEvent e){
      click++;
      repaint();
   }

   @Override
   public void mousePressed(MouseEvent e) {}

   @Override
   public void mouseReleased(MouseEvent e){}

   @Override
   public void mouseEntered(MouseEvent e){}

   @Override
   public void mouseExited(MouseEvent e){}

   @Override
   public void keyTyped(KeyEvent e){}

   @Override
   public void keyPressed(KeyEvent e)
   {
      int key = e.getKeyCode();
      
      if (e.isShiftDown()) {
         if(key == KeyEvent.VK_RIGHT) {move++; click = 0;}
         if(key == KeyEvent.VK_LEFT) {move--; click = 0;}
      }
      else {
         if(key == KeyEvent.VK_RIGHT) click++;
         if(key == KeyEvent.VK_LEFT) click--;         
      }
      
      
      repaint();
   }

   @Override
   public void keyReleased(KeyEvent e){}
}