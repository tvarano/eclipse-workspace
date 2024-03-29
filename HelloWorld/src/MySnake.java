import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Thomas Varano
//[Program Descripion]
//Nov 16, 2016
public class MySnake extends JPanel implements KeyListener
{
   public static int foodx = 80; 
   public static int foody = 80;
   public static int snakelength = 1;
   private static boolean foodeat;
   private static boolean walltouch;
   private boolean leftDirection = false;
   private boolean rightDirection = true;
   private boolean upDirection = false;
   private boolean downDirection = false;
   public static int spriteheadx = 60;
   public static int spriteheady = 60;
   public static void spriteHead(int x,int y){
      x = spriteheadx;
      y = spriteheady;
      
   }
   
   public MySnake()
   {   
      this.setBackground(Color.WHITE);  //sets background
      this.addKeyListener(this);

   }
   
   public void paintComponent(Graphics g)
   {

      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setStroke(new BasicStroke(1));   //stroke size
      g2.fillRect(0, 0, getWidth(), 20);
      g2.fillRect(getWidth()-20, 0, 20, getHeight());
      g2.fillRect(0, getHeight()-20, getWidth(), 20);
      g2.fillRect(0, 0, 20, getHeight());
      g2.setColor(Color.RED);
      g2.fillRect(foodx, foody, 20, 20);
      //snake
      g2.setColor(Color.YELLOW);
      g2.fillRect(spriteheadx, spriteheady, 20, 20);
      try
      {
         Thread.sleep(100);
      } catch (InterruptedException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
     //TODO have more boxes come out when things are eaten   
      g2.fillRect(spriteheadx, spriteheady, 20, 20);
   }
   
   
   public Dimension getPreferredSize(){
      return new Dimension(1000, 800); //change to size
   }
   public static void main(String[] args)
   {
      MySnake panel = new MySnake();
      JFrame frame = new JFrame("Snake Game");
      frame.getContentPane().add(panel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   @Override
   public void keyTyped(KeyEvent e)
   {
      System.out.println(e.getKeyCode());
      
   }

   @Override
   public void keyPressed(KeyEvent e)
   {
      System.out.println(e.getKeyCode());
      if (e.getKeyCode() == KeyEvent.VK_LEFT) {
         leftDirection = true;
         upDirection = false;
         downDirection = false;
         repaint();
     }

     if (e.getKeyCode() == KeyEvent.VK_RIGHT)  {
         rightDirection = true;
         upDirection = false;
         downDirection = false;
         repaint();
     }

     if (e.getKeyCode() == KeyEvent.VK_UP){
         upDirection = true;
         rightDirection = false;
         leftDirection = false;
         repaint();
     }

     if (e.getKeyCode() == KeyEvent.VK_DOWN) {
         downDirection = true;
         rightDirection = false;
         leftDirection = false;
         repaint();
      }
      if (foodeat == true){
      foodx = (int)((10+MyStaticMethods.roundTo(Math.random(),4)*1000%getWidth()-40)/20*20);
      foody = (int)((10+MyStaticMethods.roundTo(Math.random(),4)*1000%getHeight()-40)/20*20);
      snakelength = snakelength + 3;
      repaint();
      System.out.println("food"+foodx+","+foody);
      }
      
      if (downDirection == true){
         spriteheady = spriteheady - 20;
         try
         {
            Thread.sleep(100);
         } catch (InterruptedException e1)
         {
            e1.printStackTrace();
         }
         System.out.println(spriteheady);
         repaint();
      }
   }

   @Override
   public void keyReleased(KeyEvent e)
   {
   }
}

