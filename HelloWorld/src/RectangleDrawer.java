import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Thomas Varano
//Drawing a bunch of things
//Nov 9, 2016
public class RectangleDrawer extends JPanel implements MouseListener, MouseMotionListener
{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private static int dragx, dragy, pressx, pressy, distance, distx, disty, mousex, mousey;
   private static boolean rectbuttonx, rectbuttony, rectbuttonpress, 
                          circbuttonx, circbuttony, circbuttonpress,
                          linebuttonx, linebuttony, linebuttonpress,
                          ovalbuttonx, ovalbuttony, ovalbuttonpress,
                          starbuttonx, starbuttony, starbuttonpress;
   private static Font prestige = new Font ("Prestige Elite Std", Font.BOLD, 20);
   private static Color thisblue = new Color (100,120,150);   
   private static Image star;
   
   
   public RectangleDrawer()
   {   
      this.setBackground(thisblue);  //sets background
      this.addMouseListener(this);
      this.addMouseMotionListener(this);
      
      try
      {
         star = ImageIO.read(new File("src/Five-pointed_star.svg.png"));
      } catch (IOException e)
      {
         e.printStackTrace();
      }
      
   }
   
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setStroke(new BasicStroke(2));
      g2.setFont(prestige);
      g2.setColor(Color.WHITE);
      g2.drawString(mousex+","+mousey, mousex, mousey);
      if (rectbuttonpress == true){
         g2.setColor(Color.BLACK);
         if (distx > 0 && disty > 0){
            g2.drawRect(pressx, pressy, distx, disty);}
         else if (distx > 0 && disty < 0){
            g2.drawRect(pressx, pressy - Math.abs(disty), distx, Math.abs(disty));}
         else if (distx < 0 && disty > 0){
            g2.drawRect(pressx - Math.abs(distx), pressy, Math.abs(distx), disty);}
         else if (distx < 0 && disty < 0){
            g2.drawRect(pressx - Math.abs(distx), pressy - Math.abs(disty), Math.abs(distx), Math.abs(disty));
         }
         else
            g2.drawString("VALUE IS ZERO", 101, 35);
      }
      
      else if (circbuttonpress == true){
         g2.setColor(Color.BLACK);
         g2.drawOval(pressx - distance, pressy - distance, distance*2, distance*2);
         }
      else if (linebuttonpress == true){
         g2.setColor(Color.BLACK);
         g2.drawLine(pressx, pressy, dragx, dragy);
      }
      else if (ovalbuttonpress == true){
         g2.setColor(Color.BLACK);
         g2.drawString(distx+","+disty, dragx, dragy);
         if (distx > 0 && disty > 0){
            g2.drawOval(pressx, pressy, distx, disty);}
         else if (distx > 0 && disty < 0){
            g2.drawOval(pressx, pressy - Math.abs(disty), distx, Math.abs(disty));}
         else if (distx < 0 && disty > 0){
            g2.drawOval(pressx - Math.abs(distx), pressy, Math.abs(distx), disty);}
         else if (distx < 0 && disty < 0){
            g2.drawOval(pressx - Math.abs(distx), pressy - Math.abs(disty), Math.abs(distx), Math.abs(disty));}
         else
            g2.drawString("VALUE IS ZERO", 101, 125);
      }
      else if (starbuttonpress == true){
         g2.setColor(Color.BLACK);
         if (distx > 0 && disty > 0){
            g2.drawImage(star, pressx, pressy, distx, disty, null);}
         else if (distx > 0 && disty < 0){
            g2.drawImage(star, pressx, pressy - Math.abs(disty), distx, Math.abs(disty),null);}
         else if (distx < 0 && disty > 0){
            g2.drawImage(star, pressx - Math.abs(distx), pressy, Math.abs(distx), disty, null);}
         else if (distx < 0 && disty < 0){
            g2.drawImage(star, pressx - Math.abs(distx), pressy - Math.abs(disty), Math.abs(distx), Math.abs(disty), null);}
         else
            g2.drawString("VALUE IS ZERO", 101, 155);
      }
      else{ 
         g2.setColor(Color.RED);
         g2.drawString("PLEASE CLICK YOUR DESIRED SHAPE", getWidth()/2-185, 25);}
//      g2.drawImage(star, 0, 0, 200, 200, null);
//      g2.drawLine(0, 78, 200, 78);
//      g2.drawLine(39, 198, 100, 8);
//      g2.drawLine(162, 198, 100, 8);
//      g2.drawLine(0, 78, 162, 198);
//      g2.drawLine(200, 78, 39, 198);
      
//menu   
    //rect
      g2.setColor(Color.BLACK);
      g2.drawRect(20, 20, 80, 20);
      if (rectbuttonpress == true)
         g2.setColor(Color.RED);
      else
         g2.setColor(thisblue);
      g2.fillRect(20, 20, 80, 20);
      g2.setColor(Color.BLACK);
      g2.drawString("rect", 21, 35);
    //circ
      if (circbuttonpress == true)
         g2.setColor(Color.RED);
      else
         g2.setColor(thisblue);
      g2.fillRect(20, 50, 80, 20);
     g2.setColor(Color.BLACK);
     g2.drawRect(20, 50, 80, 20);
      g2.drawString("circle", 21, 65);
    //line
    if (linebuttonpress == true) 
      g2.setColor(Color.RED);
    else
       g2.setColor(thisblue);
      g2.fillRect(20, 80, 80, 20);
      g2.setColor(Color.BLACK);
      g2.drawRect(20, 80, 80, 20);
      g2.drawString("line", 21, 95); 
   //oval
      if (ovalbuttonpress == true)
         g2.setColor(Color.RED);
      else 
         g2.setColor(thisblue);
      g2.fillRect(20, 110, 80, 20);
      g2.setColor(Color.BLACK);
      g2.drawRect(20, 110, 80, 20);
      g2.drawString("oval", 21, 125);  
   //star
      if (starbuttonpress == true)
         g2.setColor(Color.RED);
      else 
         g2.setColor(thisblue);
      g2.fillRect(20, 140, 80, 20);
      g2.setColor(Color.BLACK);
      g2.drawRect(20, 140, 80, 20);
      g2.drawString("star", 21, 155);  
   }
   
   public Dimension getPreferredSize(){
      return new Dimension(800, 600);
   }
  
   public static void main(String[] args)
   {
      RectangleDrawer panel = new RectangleDrawer();
      JFrame frame = new JFrame("Draw!");
      frame.getContentPane().add(panel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   @Override
   public void mouseClicked(MouseEvent e)//500
   {

        dragx = -10;
        dragy = -10;
        pressx = -10;
        pressy = -10;
        distance = 0;
        distx = 0;
        disty = 0;
        repaint();
     //rect
        if (e.getX() > 20 && e.getX() < 100){
           rectbuttonx = true;}
        else 
              rectbuttonx = false;
        if (e.getY() > 20 && e.getY() < 40){
           rectbuttony = true;}
        else 
           rectbuttony = false;
        if (rectbuttony == true && rectbuttonx == true)
           rectbuttonpress = true;
        else 
           rectbuttonpress = false;
        repaint();
      //circle
        if (e.getX() > 20 && e.getX() < 100)
           circbuttonx = true;
        else 
           circbuttonx = false;
        if (e.getY() > 50 && e.getY() < 70)
           circbuttony = true;
        else 
           circbuttony = false;
        if (circbuttony == true && circbuttonx == true)
           circbuttonpress = true;
        else 
           circbuttonpress = false;
        repaint();
     //line
        if (e.getX() > 20 && e.getX() < 100)
           linebuttonx = true;
        else 
           linebuttonx = false;
        if (e.getY() > 80 && e.getY() < 100)
           linebuttony = true;
        else 
           linebuttony = false;
        if (linebuttony == true && linebuttonx == true)
           linebuttonpress = true;
        else 
           linebuttonpress = false;
        repaint();
     //oval
        if (e.getX() > 20 && e.getX() < 100)
           ovalbuttonx = true;
        else
           ovalbuttonx = false;
        if (e.getY() > 110 && e.getY() < 130)
           ovalbuttony = true;
        else
           ovalbuttony = false;
        if (ovalbuttonx == true && ovalbuttony == true)
           ovalbuttonpress = true;
        else
           ovalbuttonpress = false;
      //star
        if (e.getX() > 20 && e.getX() < 100)
           starbuttonx = true;
        else
           starbuttonx = false;
        if (e.getY() > 140 && e.getY() < 160)
           starbuttony = true;
        else
           starbuttony = false;
        if (starbuttonx == true && starbuttony == true)
           starbuttonpress = true;
        else
           starbuttonpress = false;
        
        System.out.println("rect "+rectbuttonx+","+rectbuttony+":"+rectbuttonpress);
        System.out.println("circ "+circbuttonx+","+circbuttony+":"+circbuttonpress);
        System.out.println("line "+linebuttonx+","+linebuttony+":"+linebuttonpress);
        System.out.println("oval "+ovalbuttonx+","+ovalbuttony+":"+ovalbuttonpress);
        System.out.println("star "+starbuttonx+","+starbuttony+":"+starbuttonpress);
        repaint();  
      
      System.out.println("click"+e.getID()); 
   }

   @Override
   public void mousePressed(MouseEvent e)
   {
      System.out.println("press"+e.getID());  //501    
      pressx = e.getX();
      pressy = e.getY();
   }

   @Override
   public void mouseReleased(MouseEvent e)
   {
      System.out.println("release"+e.getID());  //502 
   }

   @Override
   public void mouseEntered(MouseEvent e) //504
   {
   }

   @Override
   public void mouseExited(MouseEvent e) //505
   {
   }
   
   @Override
   public void mouseDragged(MouseEvent e)  //506
   {
      dragx = e.getX();
      dragy = e.getY();
      distx = e.getX() - pressx;
      disty = e.getY() - pressy;
      distance = (int) Math.sqrt(Math.pow(pressx-dragx, 2)+Math.pow(pressy-dragy, 2));
      repaint();
      System.out.println(distance);
   }
   
   @Override
   public void mouseMoved(MouseEvent e) //503
   {
      mousex = e.getX();
      mousey = e.getY();
      repaint();
   }
}