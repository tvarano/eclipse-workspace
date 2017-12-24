import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Thomas Varano
//[Program Descripion]
//Oct 26, 2016
public class FrameLab extends JPanel implements MouseListener,MouseMotionListener
{
   
  
   private static final long serialVersionUID = 1L;
   private Image pic;
   private Rectangle rect;
   private AffineTransform transform = new AffineTransform();
   private Shape transformed;
 
      public FrameLab()                            //constructor
      {   
         this.setBackground(new Color (100,120,150));  //sets background
         this.addMouseListener(this);                  //mouse listener
         this.addMouseMotionListener(this);            //mouse motion
         rect = new Rectangle(100,200,500,30);
         transform.rotate(Math.toRadians(10), rect.getX() + rect.getWidth()/2, getY() + rect.width/2);
         transformed = transform.createTransformedShape(rect);

         try{
            pic = ImageIO.read(new File("src/gifart1.gif"));
         } catch (IOException e){
            e.printStackTrace();
         }
         
      }
      
      public void paintComponent(Graphics g)
      {
         double scalefactor = getWidth()/1000;
         super.paintComponent(g);
         Graphics2D g2 = (Graphics2D)g;
         g2.drawImage(pic, 0,0, getWidth(),getHeight(), null);               //image
         g2.setColor(new Color(100, 20, 150));
         g2.setStroke(new BasicStroke(10));
         g2.setColor(Color.YELLOW);
         g2.fillOval(150,50,500,500);                    //head
         g2.setColor(Color.BLACK);
         g2.drawOval(150,50,500,500);                    //head
         g2.drawArc(275, 400, 250, 100, 180, 180);       //smile
         
         //drawing triangle/polygon
         int[] xs ={400,425,375};
         int[] ys ={350,375,375};
         g2.setColor(Color.BLUE);
         g2.drawPolygon(xs, ys, 3);                      //nose
         g2.setColor(Color.ORANGE);
         g2.fillPolygon(xs, ys, 3);
         
         g2.setColor(new Color (240,240,240));
         g2.fillOval(290, 100, 100, 250);                //left eye
         g2.fillOval(410, 100, 100, 250);                //right eye
         g2.setColor(Color.BLACK);
         g2.drawOval(290, 100, 100, 250);                //left eye outline
         g2.drawOval(410, 100, 100, 250);                //right eye outline}
         g2.drawOval((int)(getWidth()/2-(250*scalefactor)), 
               (int)(getHeight()/2-(250*scalefactor)), (int)(500*scalefactor), (int)(500*scalefactor)); 
         g2.setColor(Color.WHITE);
         g2.fill(transformed.getBounds());
         g2.setColor(Color.PINK);
         g2.fill(transformed);
         

//         TODO print x location in thing
       


//         g2.drawString(mouseat, 0, 50);
      }
      
      
      public Dimension getPreferredSize(){
         return new Dimension(800, 600);
      }
      public static void main(String[] args)
      {
         FrameLab panel = new FrameLab();
         JFrame frame = new JFrame("Intro Frame");
         frame.getContentPane().add(panel);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setSize(800, 600);
         frame.pack();
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);


         
   }

      @Override
      public void mouseClicked(MouseEvent e)
      {
//         System.out.println("CLICKED MOUSE");
      }

      @Override
      public void mousePressed(MouseEvent e)
      {
         System.out.print("PRESSED MOUSE:");
         System.out.println();
      }

      @Override
      public void mouseReleased(MouseEvent e)
      {
         System.out.println("RELEASED MOUSE");
         System.out.println(transformed.contains(e.getPoint()));
         repaint();
      }

      @Override
      public void mouseEntered(MouseEvent e)
      {
         System.out.println("mouse entered");
         java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
         Image image = toolkit.getImage("mario.png");
         Cursor a = toolkit.createCustomCursor(image , new Point(this.getX(),this.getY()), "");
         this.setCursor (a);
      }

      @Override
      public void mouseExited(MouseEvent e)
      {
         System.out.println("mouseexited");
      }

      @Override
      public void mouseDragged(MouseEvent e)
      {
      }

      @Override
      public void mouseMoved(MouseEvent e)
      {
      
      }
      
      
      // set cursor for frame and its component
      //  this is the current frame you are using .
      //  You can change the this keyword with your frame name .

     
}
