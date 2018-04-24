//Thomas Varano
//[Program Descripion]
//Dec 1, 2016
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

public class Flappy extends JPanel implements MouseListener, MouseMotionListener, KeyListener, ActionListener
{
   private static final long serialVersionUID = 1L;
   private static final int PREF_W = 1000;
   private static final int PREF_H = 800;
   private int counter;
   private Pipes pipe1;
   private Pipes pipe2;
   private Image ground, city;
   private int ground1X, ground2X, cityx, city2x;
   private int score;
   private RenderingHints hints = new RenderingHints(
      RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   private Timer jumpy;
   private boolean spacepress, gameover, initGame, clickMode, up, down;
   private Font font = new Font("Prestige Elite Std", Font.PLAIN, 25);
   private Font font2 = new Font("Prestige Elite Std", Font.BOLD, 50);
   private PlayerJump sprite;

   public Flappy() 
   {
      initGame = false;
      cityx = 0;
      city2x = PREF_W;
      counter = 0;
      ground1X = 0;
      ground2X = PREF_W;
      pipe1 = new Pipes(PREF_W,Pipes.randHeight(),175);
         pipe1.setVelocity(4);
      pipe2 = new Pipes(PREF_W+500,Pipes.randHeight(),175);
         pipe2.setVelocity(4);
//         System.out.println(pipe1.getY()+","+pipe1.getY1());
      sprite = new PlayerJump(200,450,70,70);
         sprite.setGravity(1);
         sprite.setJumpForce(11);
	         try{
	            ground = ImageIO.read(new File("src/ground.png"));
	         } catch (IOException e){
	            e.printStackTrace();
	         }
	         try{
	        	 city = ImageIO.read(new File("src/bg.png"));
	         } catch (IOException e){
	        	 e.printStackTrace();
	         }
	         
      jumpy = new Timer(20, this);
         jumpy.start();
      setBackground(new Color(0,153,204));
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

      g2.setFont(font);
      g2.drawImage(city, cityx, 300, PREF_W, PREF_H-300, null);
      g2.drawImage(city, city2x, 300, PREF_W, PREF_H-300, null);
      g2.setColor(Color.GREEN);
         g2.fillRect(pipe1.getX(), 0, 100, pipe1.getY());
         g2.fillRect(pipe1.getX(), pipe1.getY1(), 100, PREF_H - pipe1.getY1());
         
         g2.fillRect(pipe2.getX(), 0, 100, pipe2.getY());
         g2.fillRect(pipe2.getX(), pipe2.getY1(), 100, PREF_H - pipe2.getY1());
      g2.setColor(Color.YELLOW);
      g2.fillRect(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
      	g2.drawImage(ground, ground1X, PREF_H-20, PREF_W, 60, null);
      	g2.drawImage(ground, ground2X, PREF_H-20, PREF_W, 60, null);
      g2.setColor(Color.BLACK);
      g2.setFont(font2);
      g2.drawString(Score(score)+"", 25, 50);
      g2.setFont(font);
      if (initGame == false){
         g2.drawString("Press Space to Start", getWidth()/2, 400);
      }
      if (gameover){
         g2.drawString("Game Over", getWidth()/2, 400);
         g2.drawString("Press enter to continue", getWidth()/2-128, 430);
      }
   }

   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGUI() {
      JFrame frame = new JFrame("Flappy Bird");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new Flappy());
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      frame.setResizable(false);
   }
   
   private void unpause(){
         gameover = false;
         sprite.setY(450);
         pipe1.unpause(PREF_W);
         pipe2.unpause(PREF_W+500);
         score = 0;
   }
   
   public int Score(int i){
    if (pipe1.getX() == sprite.getX())
    	i++;
    if (pipe2.getX() == sprite.getX())
    	i++;
    this.score = i;
      return score;  
   }
   
   public void jumpFall() {
      if (initGame) {
         boolean jump = false;
         if (spacepress) {
            jump = true;
         }
         if (counter == 0) {
            if (jump) {
               sprite.jump();
               sprite.setFalling(true);
               counter++;
               jump = false;
            }
         }
         if (sprite.isFalling()) {
            sprite.fall();
         }
         if (sprite.getY() >= 720) {
            sprite.setFalling(false);
            sprite.stopFall();
            gameover = true;
         }
      }
   }
   
   public void movement(){
	   pipe1.move();
       pipe2.move();
       ground1X-= pipe1.getVelocity();
       ground2X-= pipe1.getVelocity();
       cityx--;
       city2x--;
   }
   
   public void resetX(){
	 if(ground1X + PREF_W <= 0)
		 ground1X = PREF_W;
	 if(ground2X + PREF_W <= 0)
		 ground2X = PREF_W;
	 if(cityx + PREF_W <= 0)
		 cityx = PREF_W;
	 if(city2x + PREF_W <= 0)
		 city2x = PREF_W;
   }
   
   private boolean checkCollision(){
      boolean xCollision1 = false;
      if (sprite.getX()+sprite.getWidth() >= pipe1.getX() && sprite.getX() <= pipe1.getX()+100)
         xCollision1 = true;
      else xCollision1 = false;
      if(sprite.getY() <= pipe1.getY() && xCollision1)
         return true;
      if (sprite.getY()+sprite.getHeight() >= pipe1.getY1() && xCollision1)
         return true;
      else return false;
   }
   private boolean checkCollision2(){
      boolean xCollision2 = false;
      if (sprite.getX()+sprite.getWidth() >= pipe2.getX() && sprite.getX()+sprite.getWidth() <= pipe2.getX()+100)
         xCollision2 = true;
      else xCollision2 = false;
      if(sprite.getY() <= pipe2.getY() && xCollision2)
         return true;
      if (sprite.getY()+sprite.getHeight() >= pipe2.getY1() && xCollision2)
         return true;
      else return false;
   }

   public void upDown(){
      if (clickMode){
         if (up)
            sprite.setUp(true);
         else
            sprite.setUp(false);
         if (down)
            sprite.setDown(true);
         else
            sprite.setDown(false);
      }
   }
   
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }
   
   public void update(){
      if(initGame){
       if (gameover){
          clickMode = false;
       }
       if (!clickMode)
          jumpFall();
       else if (clickMode)
          upDown();
         if (!gameover){
            movement();
         }
         
         if (checkCollision()||checkCollision2()){
            gameover = true;
         }
         resetX();
         pipe1.reset(PREF_W);
         pipe2.reset(PREF_W);
      }
//      System.out.println(ground1X+","+ground2X);
   }

   @Override
   public void mouseDragged(MouseEvent e){
   }

   @Override
   public void mouseMoved(MouseEvent e){}

   @Override
   public void mouseClicked(MouseEvent e){
      
         if (gameover){
            unpause();
            clickMode = true;
         }
   }

   @Override
   public void mousePressed(MouseEvent e)
   {
      System.out.println("pressing the mouse");
   }

   @Override
   public void mouseReleased(MouseEvent e){}

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
         if (e.getKeyCode() == KeyEvent.VK_SPACE){
            if (gameover == false)
               spacepress = true;
            initGame = true;
         }
         if (e.getKeyCode() == KeyEvent.VK_UP){
            if (clickMode)
               up = true;
         }
         if (e.getKeyCode() == KeyEvent.VK_DOWN){
            if (clickMode)
               down = true;
         }
         
         if (e.getKeyCode() == KeyEvent.VK_ENTER){
            if (gameover){
               unpause();
               spacepress = true;
            }
         }
      System.out.println("keypress"+e.getKeyCode());
   }

   @Override
   public void keyReleased(KeyEvent e)
   {
      if (e.getKeyCode() == KeyEvent.VK_SPACE){
         spacepress = false;
         counter =0;
      }
      else if (e.getKeyCode() == KeyEvent.VK_ENTER){
         spacepress = false;
         counter = 0;
      }
      if (e.getKeyCode() == KeyEvent.VK_UP){
            up = false;
      }
      if (e.getKeyCode() == KeyEvent.VK_DOWN){
            down = false;
      }
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      update();
      repaint();
   }
}

