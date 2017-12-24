//Thomas Varano
//[Program Descripion]
//Dec 9, 2016

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
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

	public class Platformer extends JPanel implements MouseListener, MouseMotionListener, KeyListener, ActionListener
	{
			   private static final long serialVersionUID = 1L;
			   private static final int PREF_W = 1000;
			   private static final int PREF_H = 800;
			   private RenderingHints hints = new RenderingHints(
			      RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			   private Font font = new Font("Prestige Elite Std", Font.PLAIN, 25);
			private SpriteOne sprite;
			private Rectangle rectPla;
			private Timer primary;
			private boolean spacepress;

	   public Platformer() 
	   {
	      sprite = new SpriteOne(500,200,50,50);
		   primary = new Timer(10,this);
		      primary.start();
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

	      g2.setFont(font);
	      g2.setColor(Color.BLACK);
	      g2.fill(rectPla);
	      g2.fill(sprite.getBounds());
	      g2.drawLine(0, sprite.getGround()+sprite.getHeight(), PREF_W, sprite.getGround()+sprite.getHeight());
	   }

	   public Dimension getPreferredSize() {
	      return new Dimension(PREF_W, PREF_H);
	   }

	   private static void createAndShowGUI() {
	      JFrame frame = new JFrame("Frame Game");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.getContentPane().add(new Platformer());
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

	   public void update(){
	      System.out.println(sprite.getDy());
	      
         if (sprite.getX() >= PREF_W){
            sprite.setX(1);
         }
         if (sprite.getX() <= 0)
            sprite.setX(PREF_W-1);
         
         if (sprite.checkCollision(rectPla)){
            sprite.setDy(0);
            if(sprite.getY()+sprite.getHeight()>rectPla.getY()+rectPla.getHeight()){
               sprite.setDy(sprite.getGravity());
               sprite.setFalling(true);
               
            }
            
            else{
               sprite.setFalling(true);
               sprite.setY((int)rectPla.getY()-sprite.getHeight());
            }
            System.out.println(sprite.getY()+sprite.getHeight()>rectPla.getY());
         }
         else if(sprite.getY()!=sprite.getGround())
            sprite.setFalling(true);
	   }
	   
	   @Override
	   public void mouseDragged(MouseEvent e)
	   {
	      System.out.println("dragging the mouse");
	   }

	   @Override
	   public void mouseMoved(MouseEvent e){}

	   @Override
	   public void mouseClicked(MouseEvent e){}

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
	      //FIXME only jumps when dy is 0, but if held down, dy is 0 at the peak of the jump\
	      int key = e.getKeyCode();
	      if (key == KeyEvent.VK_SPACE){
	    	  sprite.setJumping(true);
	      }
	      if (key == KeyEvent.VK_LEFT){
	    	  sprite.setLeft(true);
	      }
	      if (key == KeyEvent.VK_RIGHT){
	    	  sprite.setRight(true);
	      }
	   }

	   @Override
	   public void keyReleased(KeyEvent e)
	   {
		     int key = e.getKeyCode();
		      if (key == KeyEvent.VK_SPACE){
		    	  spacepress = false;
		      }
		      if (key == KeyEvent.VK_LEFT){
		    	  sprite.setLeft(false);
		      }
		      if (key == KeyEvent.VK_RIGHT){
		    	  sprite.setRight(false);
		      }
	   }

	   @Override
	   public void actionPerformed(ActionEvent e)
	   {
		   sprite.update();
		   update();
		   repaint();
	   }
}

