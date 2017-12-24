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


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *<body>
 *    <p>
 *     A game based off the original Atari version sharing the same title. Involves a single player mode, 
 *     difficulty settings,</br>
 *     and geometry based on {@link Paddle} shape and point of contact.
 *     @author varanoth
 *     @see {@link PongBall}, {@link Paddle}, {@link AutoPaddle}
 *    </p>
 * </body>
 */
public class Pong extends JPanel implements MouseListener, MouseMotionListener, KeyListener, ActionListener
{
   private static final long serialVersionUID = 1L;
   protected static final int PREF_W = 1000;
   protected static final int PREF_H = 800;
   private RenderingHints hints = new RenderingHints(
      RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   private Font font = new Font("Prestige Elite Std", Font.PLAIN, 25);
   private Timer timer = new Timer(5,this);
   private int scoreL, scoreR, maxScore, difficulty;
   private PongBall ball;
   private Paddle leftPaddle,rightPaddle;
   private boolean initGame, singlePlayer, twoPlayer, pause, gameOver;
   private AutoPaddle auto;
   private Rectangle onePlayerRect, twoPlayerRect, scoreSelecter, maxUpRect, maxDownRect, goButton, 
                     easyRect, mediumRect, hardRect, impossRect;
   private Image start, arrows; 

   public Pong() {
      setBackground(Color.BLACK);
      addMouseListener(this);
      addMouseMotionListener(this);
      addKeyListener(this);
      setFocusable(true);
      requestFocus();
      auto = new AutoPaddle(50,PREF_H/2,10,100);
      rightPaddle = new Paddle(50,PREF_H/2,10,100);
      leftPaddle = new Paddle(PREF_W-50,PREF_H/2,10,100);
      ball = new PongBall(PREF_W/2-15,PREF_H/2-15,30,30,4,4,new Rectangle(0,0,PREF_W,PREF_H));
         onePlayerRect = new Rectangle(50,150,150,50);
         twoPlayerRect = new Rectangle(50,225,150,50);
         scoreSelecter = new Rectangle(325,175,200, 50);
         maxUpRect = new Rectangle(370,250,50,50);
         maxDownRect = new Rectangle(430,250,50,50);
         easyRect = new Rectangle(700,200,155,50);
         mediumRect = new Rectangle(700,275,155,50);
         hardRect = new Rectangle(700,350,155,50);
         impossRect = new Rectangle(700,425,155,50);
         goButton = new Rectangle(PREF_W/2-150,PREF_H/2,250,125);
         try{
            start = new ImageIcon(this.getClass().getResource("playButton.png")).getImage();
         } catch (NullPointerException e){
            e.printStackTrace();
         }
         try{
            arrows = new ImageIcon(this.getClass().getResource("arrows.png")).getImage();
         } catch (NullPointerException e){
            e.printStackTrace();
         }
       timer.start();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHints(hints);
      g2.setFont(font);
      g2.setColor(Color.WHITE);
      if (initGame){
         ball.drawBall(g2);
         if (singlePlayer){
            auto.draw(g2);
            leftPaddle.draw(g2);
            g2.drawString(scoreL+":"+scoreR, PREF_W/2-23, 70);
            if (pause){
               g2.drawString("Pause", PREF_W/2-20, PREF_H/2);
            }
         }
         else if (twoPlayer){
            leftPaddle.draw(g2);
            rightPaddle.draw(g2);
            g2.drawString(scoreL+":"+scoreR, PREF_W/2-24, 70);
            if (pause){
               g2.drawString("Pause", PREF_W/2-20, PREF_H/2);
            }
         }
      }
      else{
         g2.drawString("WELCOME TO PONG!", PREF_W/2-120, 70);
         g2.drawString("By Thomas Varano", PREF_W/2-120, 100);
         g2.draw(onePlayerRect);
         g2.drawString("1 Player", (int)onePlayerRect.getX()+7, (int)onePlayerRect.getMaxY()-15);
         g2.draw(twoPlayerRect);
         g2.drawString("2 Player", (int)twoPlayerRect.getX()+7, (int)twoPlayerRect.getMaxY()-15);
         if (singlePlayer){
            g2.setColor(Color.LIGHT_GRAY);
            g2.fill(onePlayerRect);
         }
         else if (twoPlayer){
            g2.setColor(Color.LIGHT_GRAY);
            g2.fill(twoPlayerRect);
         }
         if (singlePlayer || twoPlayer){
            g2.setColor(Color.WHITE);
            g2.draw(scoreSelecter);
            g2.drawString("Play to: "+maxScore, (int)scoreSelecter.getX()+7, (int)scoreSelecter.getMaxY()-15);
//            g2.fill(maxUpRect);
//            g2.fill(maxDownRect);
            g2.drawImage(arrows, (int)maxUpRect.getX(), (int)maxUpRect.getY(), 
                  (int)(maxDownRect.getMaxX()-maxUpRect.getX()), (int)maxUpRect.getHeight(), null);
            g2.draw(goButton);
            g2.drawImage(start, (int)goButton.getX(), (int)goButton.getY(), 
                  (int)goButton.getWidth(), (int)goButton.getHeight(),null);
            g2.draw(easyRect);
               g2.drawString("Easy", (int)easyRect.getX()+7, (int)easyRect.getMaxY()-15);
            g2.draw(mediumRect);
               g2.drawString("Medium", (int)mediumRect.getX()+7, (int)mediumRect.getMaxY()-15);
            g2.draw(hardRect);
               g2.drawString("Hard", (int)hardRect.getX()+7, (int)hardRect.getMaxY()-15);
            g2.draw(impossRect);
               g2.drawString("Impossible", (int)impossRect.getX()+2, (int)impossRect.getMaxY()-15);
            getDifficulty(difficulty, g2);
         }
      }
      if (gameOver){
         g2.drawString("Game Over.", PREF_W/2-80, PREF_H/2);
         g2.drawString("Press Space To Restart.", PREF_W/2-184, PREF_H/2+30);
         g2.drawString("Press Enter To Reset.", PREF_W/2-168, PREF_H/2+50);
      }
//      g2.draw(ball.getTrajectory());
   }

   public void update(){
      if (initGame && !gameOver && !pause) {
         ball.update();
         if (singlePlayer) {
            runSinglePlayer();
         } else if (twoPlayer) {
            runTwoPlayer();
         }
         isScore();
      }
   }
   
   public void runSinglePlayer(){
      auto.update(ball);
      auto.collide(ball);
      leftPaddle.update();
      leftPaddle.collide(ball);
   }
   
   public void runTwoPlayer(){
      rightPaddle.update();
      rightPaddle.collide(ball);
      leftPaddle.update();
      leftPaddle.collide(ball);
   }
   
   public void isScore(){
      if (ball.isCollideEast()) {
         scoreR++;
         ball.setX(500);
         ball.setY(500);
         ball.setDy(0);
         if (difficulty == 1){
            ball.setDx(2);
         } 
         else{
            ball.setDx(4);
         }
      } else if (ball.isCollideWest()) {
         scoreL++;
         ball.setX(500);
         ball.setY(500);
         ball.setDy(0);
         ball.setDx(-2);
      }
      if (scoreL == maxScore || scoreR == maxScore) {
         gameOver = true;
      }
   }
   
   /**
    * Resets not only the game locations, but also its parameters.</br>
    * Returns the game to its home screen to reset parameters.
    */
   public void reset(){
      initGame = false;
      auto = new AutoPaddle(50,PREF_H/2,10,100);
      rightPaddle = new Paddle(50,PREF_H/2,10,100);
      leftPaddle = new Paddle(PREF_W-50,PREF_H/2,10,100);
      ball = new PongBall(PREF_W/2-15,PREF_H/2-15,30,30,4,4,new Rectangle(0,0,PREF_W,PREF_H));
      scoreL = 0;
      scoreR = 0;
      difficulty = 0;
      maxScore = 0;
      singlePlayer = twoPlayer = gameOver = false;
   }
   
   /**
    * Restarts the game as normal, but keeps parameters and skips menu.</br>
    * Instead of navigating the menu again, the user is returned to another round of the game 
    * they have already specified.
    */
   public void restart(){
      auto = new AutoPaddle(50,PREF_H/2,10,100);
      rightPaddle = new Paddle(50,PREF_H/2,10,100);
      leftPaddle = new Paddle(PREF_W-50,PREF_H/2,10,100);
      ball = new PongBall(PREF_W/2-15,PREF_H/2-15,30,30,4,4,new Rectangle(0,0,PREF_W,PREF_H));
      getDifficulty(difficulty);
      scoreL = 0;
      scoreR = 0;
      gameOver = false;
   }
   /**
    * initializes the difficulty settings based on user inputs from 1-4, inclusive.</br>
    * Sets the parameters for the specified difficulty, and paints the menu settings in the main menu.
    * @param d the difficulty setting expressed as an int, from 1-4 inclusive.
    * @param g2 the {@link Graphics2D} {@link Object} required to paint the rectangles on the main menu.
    * @see {@link getDifficulty(int d)}</br>
    * to be able to achieve the setting of difficulty without a necessary {@link Graphics2D} 
    */
   public void getDifficulty(int d, Graphics2D g2) {
      g2.setColor(Color.LIGHT_GRAY);
      if (d == 1) {
         auto.setDyMax(1);
         ball.setDx(2.5);
         ball.setDy(2.5);
         ball.setdSum(5);
         g2.fill(easyRect);
      } else if (d == 2) {
         auto.setDyMax(2);
         ball.setDx(3.5);
         ball.setDy(3.5);
         ball.setdSum(7);
         g2.fill(mediumRect);
      } else if (d == 3) {
         auto.setDyMax(4);
         ball.setDx(4.5);
         ball.setDy(4.5);
         ball.setdSum(9);
         g2.fill(hardRect);
      } else if (d == 4) {
         auto.setDyMax(8);
         ball.setDx(8);
         ball.setDy(8);
         ball.setdSum(16);
         g2.fill(impossRect);
      }
   }
   /**
    * initializes the difficulty settings based on user inputs from 1-4, inclusive.</br>
    * Sets the parameters for the specified difficulty, including {@link PongBall} dx and dy and 
    * {@link Paddle} dyMax.
    * @param d the difficulty setting expressed as an it, from 1-4 inclusive.
    * @see getDifficulty(int d, <code>Graphics2D</code> g2)</br>
    * to write the difficulty and paint the necessary objects on the coordinating menu <code>Graphics2D</code> 
    */
   public void getDifficulty(int d) {
      if (d == 1) {
         auto.setDyMax(1);
         ball.setDx(2.5);
         ball.setDy(2.5);
         ball.setdSum(5);
      } else if (d == 2) {
         auto.setDyMax(2);
         ball.setDx(3.5);
         ball.setDy(3.5);
         ball.setdSum(7);
      } else if (d == 3) {
         auto.setDyMax(4);
         ball.setDx(4.5);
         ball.setDy(4.5);
         ball.setdSum(9);
      } else if (d == 4) {
         auto.setDyMax(8);
         ball.setDx(8);
         ball.setDy(8);
         ball.setdSum(16);
      }
   }
   
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGUI() {
      JFrame frame = new JFrame("Pong");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new Pong());
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);  
      frame.setResizable(false);
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
   }

   @Override
   public void mouseMoved(MouseEvent e){
   }

   @Override
   public void mouseClicked(MouseEvent e){
      if (!initGame) {
         if (onePlayerRect.contains(e.getPoint())) {
            singlePlayer = true;
            twoPlayer = false;
         } else if (twoPlayerRect.contains(e.getPoint())) {
            twoPlayer = true;
            singlePlayer = false;
         }
         if (singlePlayer || twoPlayer) {
            System.out.println("saoidubf");
            if (maxUpRect.contains(e.getX(), e.getY())) {
               maxScore++;
               } else if (maxDownRect.contains(e.getX(), e.getY())) {
                  maxScore--;
               }
            if (easyRect.contains(e.getPoint())){
               difficulty = 1;
            } else if (mediumRect.contains(e.getPoint())){
               difficulty = 2;
            } else if (hardRect.contains(e.getPoint())){
               difficulty = 3;
            } else if (impossRect.contains(e.getPoint())){
               difficulty = 4;
            }
            if (maxScore>0 && goButton.contains(e.getPoint()) && difficulty>0)
               initGame = true;
            }
         }
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
      int key = e.getKeyCode();
      if (initGame && !pause && !gameOver) {
         if (singlePlayer) {
            if (key == KeyEvent.VK_UP) {
               leftPaddle.setUp(true);
            } else if (key == KeyEvent.VK_DOWN) {
               leftPaddle.setDown(true);
            }

         } else if (twoPlayer) {
            if (key == KeyEvent.VK_W) {
               rightPaddle.setUp(true);
            } else if (key == KeyEvent.VK_S) {
               rightPaddle.setDown(true);
            }
            if (key == KeyEvent.VK_UP) {
               leftPaddle.setUp(true);
            } else if (key == KeyEvent.VK_DOWN) {
               leftPaddle.setDown(true);
            }
         }
         if (key == KeyEvent.VK_ESCAPE) {
            pause = !pause;
         }
      }
      if (gameOver) {
         if (key == KeyEvent.VK_SPACE){
            restart();
         }
         else if (key == KeyEvent.VK_ENTER){
            reset();
         }
      }
   }

   @Override
   public void keyReleased(KeyEvent e){
      int key = e.getKeyCode();
      if (initGame) {
         if (!pause) {
            if (singlePlayer) {
               if (key == KeyEvent.VK_UP) {
                  leftPaddle.setUp(false);
               } else if (key == KeyEvent.VK_DOWN) {
                  leftPaddle.setDown(false);
               }

            } else if (twoPlayer) {
               if (key == KeyEvent.VK_W) {
                  rightPaddle.setUp(false);
               } else if (key == KeyEvent.VK_S) {
                  rightPaddle.setDown(false);
               }
               if (key == KeyEvent.VK_UP) {
                  leftPaddle.setUp(false);
               } else if (key == KeyEvent.VK_DOWN) {
                  leftPaddle.setDown(false);
               }
            }
         }
      }
   }

   @Override
   public void actionPerformed(ActionEvent e){
      update();
      repaint();
   }
}
