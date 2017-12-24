import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

//Thomas Varano
//JFrame Intro
//Oct 20, 2016
public class FrameIntro extends JPanel implements MouseListener
{
   private static final long serialVersionUID = 1L;
   private String text;
   
   public FrameIntro()
   {   
      text = "HelloWorld";
      this.setBackground(new Color (100,120,150));  //sets background
      
      this.addMouseListener(this); 
   }
   
   public void paintComponent(Graphics g)
   {

      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setColor(new Color(100, 20, 150));                      //sets color
      g2.setFont(new Font("Courier New" , Font.PLAIN , 50));     //picks the font
      g2.drawString("Hello World!", getWidth()/2-125 , 50);      //print out text
      g2.setColor(Color.GREEN);                 //sets colors
      g2.fillRect(100, 100, 50, 50);            //makes a rectangle
      g2.setColor(Color.BLACK);
      g2.setStroke(new BasicStroke(5));         //sets thickness of stroke
      g2.drawOval(150, 100, 500, 500);          //x,y,width,height
      g2.setColor(Color.YELLOW);   
      g2.fillOval(150, 100, 500, 500);
      g2.setColor(Color.WHITE);                  //change color
      g2.fillOval(175, 175, 200, 200);           //white of eye
      g2.fillOval(425, 175, 200, 200);           //white of eye
      g2.setColor(Color.BLACK);                  
      g2.fillOval(250, 250, 50, 60);             //pupil
      g2.fillOval(500, 250, 50, 60);             //pupil
      g2.drawArc(275, 375, 250, 150, 180, -180); //mouth curve
      g2.setColor(Color.MAGENTA);
      g2.fillArc(275, 375, 250, 150, 180, -180); //draw the mouth curve (x,y,width,height,start angle,arc angle)
      g2.setColor(Color.BLACK);                  //change color
      g2.drawLine(280, 451, 525, 451);           //line of the mouth
      g2.setFont(new Font("Ariel" , Font.PLAIN , 55));           //picks the font again for the lines below
      g2.drawString(text, getWidth()/2-115 , 600);         //print out text
     
   }
   
   
   public Dimension getPreferredSize(){
      return new Dimension(800, 600);
   }
   public static void main(String[] args)
   {
      FrameIntro panel = new FrameIntro();
      JFrame frame = new JFrame("Intro Frame");
      frame.getContentPane().add(panel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      frame.setSize(800, 600);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
    
   
      
//      System.out.println(month+" "+(monthDay)+", "+yearNow);}
      
   }

   @Override
   public void mouseClicked(MouseEvent e)
   {
   }

   @Override
   public void mousePressed(MouseEvent e)
   {
   }

   @Override
   public void mouseReleased(MouseEvent e)
   {
   }

   @Override
   public void mouseEntered(MouseEvent e)
   {
   }

   @Override
   public void mouseExited(MouseEvent e)
   {
   }
}
