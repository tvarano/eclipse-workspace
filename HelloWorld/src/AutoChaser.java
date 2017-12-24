//Thomas Varano
//[Program Descripion]
//Dec 23, 2016

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

public class AutoChaser extends JPanel implements MouseListener, MouseMotionListener, KeyListener, ActionListener
{
   public class Sprite
   {
      private int x,y,width,height;
      private double speed;
      private boolean left, right, up, down;
      public Sprite(int x, int y, int width, int height, double speed){
         this.x = x;
         this.y = y;
         this.width = width;
         this.height = height;
         this.speed = speed;
         left = false;
         right = false;
         up = false;
         down = false;
      }
      public void update(){
         if (right){
            x += speed;
         }
         else if (left){
            x-= speed;
         }
         if (up){
            y-=speed;
         }
         else if(down){
            y+=speed;
         }
      }
      
      public Rectangle getBounds(){
         return new Rectangle(x,y,width,height);
      }
      
      public int getX() {
         return x;
      }
      public void setX(int x) {
         this.x = x;
      }
      public int getY() {
         return y;
      }
      public void setY(int y) {
         this.y = y;
      }
      public int getWidth() {
         return width;
      }
      public void setWidth(int width) {
         this.width = width;
      }
      public int getHeight() {
         return height;
      }
      public void setHeight(int height) {
         this.height = height;
      }
      public double getSpeed() {
         return speed;
      }
      public void setSpeed(double speed) {
         this.speed = speed;
      }
      public boolean isLeft() {
         return left;
      }
      public void setLeft(boolean left) {
         this.left = left;
      }
      public boolean isRight() {
         return right;
      }
      public void setRight(boolean right) {
         this.right = right;
      }
      public boolean isUp() {
         return up;
      }
      public void setUp(boolean up) {
         this.up = up;
      }
      public boolean isDown() {
         return down;
      }
      public void setDown(boolean down) {
         this.down = down;
      }

   }

   public class Chaser
   {
      private int x,y,width, height;
      private double speed;
      private boolean left, right,up,down;
      private Sprite sprite;
      public Chaser(int x, int y, int width, int height, double speed){
         this.x = x;
         this.y = y;
         this.width = width;
         this.height = height;
         this.speed = speed;
         this.sprite = null;
         left = false;
         right = false;
         up = false;
         down = false;
      }
      
      public void update(){
         if (sprite.getX() > this.getX()){
            if (!sprite.isLeft())
            this.x+=this.speed;
         }
         else if (sprite.getX() < this.getX()){
            if (!sprite.isRight())
               this.x-=this.speed;
         }
         if (sprite.getY() > this.getY()){
            if (!sprite.isUp())
               this.y+=this.speed;
         }
         else if (sprite.getY() < this.getY()){
            if (!sprite.isDown())
               this.y-=this.speed;
         }
      }
      public Rectangle getBounds(){
         return new Rectangle(x,y,width,height);
      }
      
      public int getX() {
         return x;
      }
      public void setX(int x) {
         this.x = x;
      }
      public int getY() {
         return y;
      }
      public void setY(int y) {
         this.y = y;
      }
          public int getWidth() {
         return width;
      }
      public void setWidth(int width) {
         this.width = width;
      }
      public int getHeight() {
         return height;
      }
      public void setHeight(int height) {
         this.height = height;
      }
      public double getSpeed() {
         return speed;
      }
      public void setSpeed(double speed) {
         this.speed = speed;
      }
      public boolean isLeft() {
         return left;
      }
      public void setLeft(boolean left) {
         this.left = left;
      }
      public boolean isRight() {
         return right;
      }
      public void setRight(boolean right) {
         this.right = right;
      }
      public boolean isUp() {
         return up;
      }
      public void setUp(boolean up) {
         this.up = up;
      }
      public boolean isDown() {
         return down;
      }
      public void setDown(boolean down) {
         this.down = down;
      }

      public Sprite getSprite() {
         return sprite;
      }

      public void setSprite(Sprite sprite) {
         this.sprite = sprite;
      }
   }

   private static final long serialVersionUID = 1L;
   private static final int PREF_W = 1000;
   private static final int PREF_H = 800;
   private RenderingHints hints = new RenderingHints(
      RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   private Font font = new Font("Prestige Elite Std", Font.PLAIN, 25);
   private Timer timer = new Timer(5,this);
   private Sprite player;
   private Chaser chaser;

   public AutoChaser() {
      player = new Sprite(500,500,40,40,3);
      chaser = new Chaser(300,300,40,40,2.25);
      chaser.setSprite(player);
      setBackground(Color.WHITE);
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
      g2.setColor(Color.BLACK);
      g2.fill(player.getBounds());
      g2.setColor(Color.RED);
      g2.fill(chaser.getBounds());
      if (player.getBounds().intersects(chaser.getBounds()))
         g2.drawString("DED", player.getX(), player.getY());
   }

   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGUI() {
      JFrame frame = new JFrame("Chaser");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new AutoChaser());
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
      
      if (key == KeyEvent.VK_UP)
         player.setUp(true);
      else if (key == KeyEvent.VK_DOWN)
         player.setDown(true);
      else if (key == KeyEvent.VK_LEFT)
         player.setLeft(true);
      else if (key == KeyEvent.VK_RIGHT)
         player.setRight(true);
   }

   @Override
   public void keyReleased(KeyEvent e){
      int key = e.getKeyCode();
      if (key == KeyEvent.VK_UP)
         player.setUp(false);
      else if (key == KeyEvent.VK_DOWN)
         player.setDown(false);
      else if (key == KeyEvent.VK_LEFT)
         player.setLeft(false);
      else if (key == KeyEvent.VK_RIGHT)
         player.setRight(false);
   }

   @Override
   public void actionPerformed(ActionEvent e){
      player.update();
      chaser.update();
      repaint();
   }
}