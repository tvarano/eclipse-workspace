import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/*   what do i want to do
 * ok so you want to have the aliens move differently
 *    i think i can do that 
 *    have the aliens recognize if they hit the side, and then switch. i think thats possible.
 *    have down left right variable and set if collides with predetermined point
 */

//Thomas Varano
//Space Invaders
//Nov 17, 2016
public class SpaceInvadersOne extends JPanel
      implements
         MouseMotionListener,
         MouseListener,
         KeyListener,
         ActionListener
{
   private static final long serialVersionUID = 1L;
   private static final int PREF_H = 800;
   private static final int PREF_W = 1000;
   private final int SHOT_X = -201;
   private long count, whenpressed;
   private Image alien;
   private boolean pause, spacepress, q, restart, initGame, left, right, down;
   public boolean alienshot, youWin, tankCollision, gameOver, playerShot;
   private SpaceBullet godBullet, godAlienBullet;
   private AliensMove godAlien;
   private ArrayList<AliensMove> aliens;
   private ArrayList<SpaceBullet> bullets;
   private ArrayList<SpaceBullet> alienBullets;
   private int[] col0 = {36, 27, 18, 9, 0};
   private int[] col1 = {37, 28, 19, 10, 1};
   private int[] col2 = {38, 29, 20, 11, 2};
   private int[] col3 = {39, 30, 21, 12, 3};
   private int[] col4 = {40, 31, 22, 13, 4};
   private int[] col5 = {41, 32, 23, 14, 5};
   private int[] col6 = {42, 33, 24, 15, 6};
   private int[] col7 = {43, 34, 25, 16, 7};
   private int[] col8 = {44, 35, 26, 17, 8};
   private ArrayList<int[]> columns;
   private ArrayList<Blocker> blockers;

   private Timer painter;
   private int deadAliens;
   private Tank player;

   public SpaceInvadersOne() {
      columns = new ArrayList<int[]>();
      columns.add(col0);
      columns.add(col2);
      columns.add(col3);
      columns.add(col4);
      columns.add(col5);
      columns.add(col6);
      columns.add(col7);
      columns.add(col8);
      count = 0;
      deadAliens = 0;
      whenpressed = 0;
      initGame = false;
      restart = false;
      player = new Tank(500, PREF_H - 80, 80, 40, 20, 30);
         player.setLife(3);
      godAlien = new AliensMove(50, 20, 50, 35);
      bullets = new ArrayList<SpaceBullet>();
      aliens = new ArrayList<AliensMove>();
      blockers = new ArrayList<Blocker>();
      godBullet = new SpaceBullet(player.getX(), PREF_H - 110, 5, 30, 8);
      alienBullets = new ArrayList<SpaceBullet>();
      godAlienBullet = new SpaceBullet(0, 0, 5, 30, -8);
      try {
         alien = ImageIO.read(new File("src/Space-medium-invader.sh.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      this.setBackground(Color.BLACK); // sets background
      this.addMouseListener(this);
      this.addMouseMotionListener(this);
      this.addKeyListener(this);
      setFocusable(true);
      
      requestFocus();
      painter = new Timer(5, this);
      painter.start();
   }

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setStroke(new BasicStroke(1));
      if (initGame) {
         g2.setColor(player.getColor());
         g2.fillRect(player.getX(), player.getY(), player.getWidth(),
               player.getHeight()); // tank
         g2.fillRect(player.getX() + 30, player.getY() - player.getNozzleH(),
               player.getNozzleW(), player.getNozzleH()); // gun
         g2.setColor(Color.GREEN);
         for (int i = 0; i < bullets.size(); i++) {
            g2.fillRect(bullets.get(i).getX(), bullets.get(i).getY(), //player bullets
                  godBullet.width, godBullet.height);
         }
         g2.setColor(Color.WHITE);
         for (int i = 0; i < alienBullets.size(); i++) {
            g2.fillRect(alienBullets.get(i).getX(), alienBullets.get(i).getY(),  //alien bullets
                  godAlienBullet.width, godAlienBullet.height);
         }
         for (int i = 0; i < aliens.size(); i++) {
            g2.setColor(Color.WHITE);
            g2.drawRect(aliens.get(i).getX(), aliens.get(i).getHeight(), godAlien.getWidth(), godAlien.getHeight());
            g2.drawImage(alien, aliens.get(i).getX(), aliens.get(i).getY(),  //paint aliens
                  godAlien.width, godAlien.height, null);
            g2.setColor(Color.RED);
//            g2.drawString(i + "", aliens.get(i).getX(),    //alien numbers in array
//                  aliens.get(i).getY() + 10);
         }
         g2.setColor(Color.GREEN);
         for (int i = 0; i < blockers.size(); i++) {
            g2.setColor(blockers.get(i).getColor());
            g2.fillRect(blockers.get(i).getX(), blockers.get(i).getY(),    //blockers
                  blockers.get(i).getWidth(), blockers.get(i).getHeight());
         }
//         g2.drawLine(20, 0, 20, PREF_H);
//         g2.drawLine(PREF_W - 30, 0, PREF_W - 30, PREF_H);
         g2.setColor(Color.WHITE);  //INFO
         g2.drawString("Score: "+deadAliens * 20, 5, 25);   //score
         g2.drawString("Lives: "+player.getLife(), 5, PREF_H-20);   //lives left
         if (pause) {
            g2.setColor(Color.GREEN);
            g2.drawString("PAUSE", getWidth() / 2 - 20, getHeight() / 2);
         }

         if (youWin) {
            g2.setColor(Color.GREEN);
            g2.drawString("YOU WIN! Press Enter to go again", PREF_W / 2-100, PREF_H / 2);
         }
         if (gameOver) {
            g2.setColor(Color.RED);
            g2.drawString("game over", PREF_W / 2 - 100,
                  PREF_H / 2);
         }
      } else { //opening screen
         //TODO make a few levels? 
         g2.setColor(Color.GREEN);
         g2.drawString("Welcome To SPACE INVADERS by Thomas Varano",
               PREF_W / 2 - 150, PREF_H / 2 - 40);
         g2.drawString("Press Space to Start", PREF_W / 2 - 70, PREF_H / 2);
      }
   }

   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H); // change to size
   }
   public static void main(String[] args) {
      SpaceInvadersOne panel = new SpaceInvadersOne();
      JFrame frame = new JFrame("Space Invaders");
      frame.getContentPane().add(panel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   //initialize alien array
   public void alienInit() {
      for (int i = 0; i < 45; i++) {
         int alienStartY = 0;
         int alienStartX = 10;

         if (i < 9) {
            alienStartY = 20;
         } else if (i < 18) {
            alienStartY = 60;
         } else if (i < 27) {
            alienStartY = 100;
         } else if (i < 36) {
            alienStartY = 140;
         } else if (i < 45) {
            alienStartY = 180;
         }

         alienStartX = i % 9 * 100 + 20;

         aliens.add(new AliensMove(alienStartX, alienStartY, godAlien.width,
               godAlien.height));
         aliens.get(i).setRight(true);
      }
   }

   //initialize blocker array
   public void blockerInit() {
      for (int i = 0; i < 4; i++) {
         System.out.println("added" + i);
         int blockY = PREF_H - 200;
         int blockX = 100;
         int blockW = 115;
         int blockH = 50;
         blockers.add(new Blocker(blockX + 225 * i, blockY, blockW, blockH));
      }
      for (int i = 0; i <blockers.size(); i++){
         blockers.get(i).setTotalLife(15);
      }
   }

   //check if aliens are cleared to fire
   public void checkLowest() {
      if (initGame) {
         for (int i = 0; i < columns.size(); i++) {
            if (!aliens.get(columns.get(i)[0]).isShot()) {
               aliens.get(columns.get(i)[0]).setFire(true);
            } else if (!aliens.get(columns.get(i)[1]).isShot()) {
               aliens.get(columns.get(i)[1]).setFire(true);
            } else if (!aliens.get(columns.get(i)[2]).isShot()) {
               aliens.get(columns.get(i)[2]).setFire(true);
            } else if (!aliens.get(columns.get(i)[3]).isShot()) {
               aliens.get(columns.get(i)[3]).setFire(true);
            } else if (!aliens.get(columns.get(i)[4]).isShot()) {
               aliens.get(columns.get(i)[4]).setFire(true);
            }
         }
      }
   }

   //actually fire with the aliens
   public void alienFire() {
      if (initGame) {
         int x = AliensMove.randOverall();
         if (aliens.get(x).isFire()) {
            alienBullets.add(new SpaceBullet(
                  aliens.get(x).getX() + aliens.get(x).getWidth() / 2,
                  aliens.get(x).getY(), godAlienBullet.getWidth(),
                  godAlienBullet.getHeight(), godAlienBullet.getVelocity()));
         }
      }
   }

   //player bullets
   public void bulletUpdate() {
      if (initGame) {
         if (!gameOver)
            if (!pause) {
               if (spacepress) {
                  if (whenpressed == 75)
                     whenpressed = 0;
                  if (whenpressed == 0) {
                     bullets.add(new SpaceBullet(player.getX() + 38,
                           player.getY() - player.getNozzleH(),
                           godBullet.velocity));
                  }
                  whenpressed++;
               }
               //check if off page, if so, delete from array
               for (int i = 0; i < bullets.size(); i++) {
                  if (bullets.get(i).checkIfOffPage(getWidth(), getHeight())) {
                     bullets.remove(bullets.get(i));
                     bullets.trimToSize();
                     System.out.println("bullet removed");
                  }
               }
               for (int i = 0; i < bullets.size(); i++) {
                  bullets.get(i).moveUp();
               }
            }
      }
   }

   //move the aliens in an array
   public void alienUpdate() {
      if (initGame) {
         if (!gameOver) {
            if (!pause) {
               checkLowest();
               if (q) {
                  aliens.add(new AliensMove(50, 20, godAlien.width,
                        godAlien.height));
               }

               if (count % 15 == 0) {
                  alienFire();
               }
               
               //FIXME right here
               if (count % 200 == 0) {
                  for (int i = 0; i < aliens.size(); i++) {
                     if (!aliens.get(i).isShot())
                        aliens.get(i).move(); 
//                        aliens.get(i).moveTwo(20, PREF_W - 30);
                           if (aliens.get(i).isDown()){
                              down = true;
                              left = false;
                              right = false;
                           }
                           else if (aliens.get(i).isRight()){
                              left = false;
                              down = false;
                              right = true;
                           }
                           else if (aliens.get(i).isLeft()){
                              left = true;
                              down = false;
                              right = false;
                           }
                           System.out.println(
                                 aliens.get(i).isLeft()+","+aliens.get(i).isRight()+","+aliens.get(i).isDown());
                  }
               }
               if (right)
                  for (int i = 0; i < aliens.size(); i++) {
                     aliens.get(i).setLeft(false);
                     aliens.get(i).setDown(false);
                     aliens.get(i).setRight(true);
                  }
               else if (left)
                  for (int i = 0; i < aliens.size(); i++) {
                     aliens.get(i).setRight(false);
                     aliens.get(i).setDown(false);
                     aliens.get(i).setLeft(true);
                  }
               else if (down)
                  for (int i = 0; i < aliens.size(); i++) {
                     aliens.get(i).setY(aliens.get(i).getY()+godAlien.getHeight());
                  }
            }
         }
      }
   }

   public void update() {
      if (restart) {
         count = 0;
         deadAliens = 0;
         blockers.removeAll(blockers);
         aliens.removeAll(aliens);
         bullets.removeAll(bullets);
         alienBullets.removeAll(alienBullets);
         player.setX(500);
         gameOver = false;
         restart = false;
         player.setLife(3);
         youWin = false;
      }
      if (initGame) {
         count++;
         if (count == 1) {
            alienInit();
            blockerInit();
         }
         if (!pause) {
            player.update();
            if (player.getX() < 0)
               player.setX(0);
            else if (player.getX() > getWidth() - player.getWidth())
               player.setX(PREF_W - player.getWidth());

            if (bullets.size() != 0) {
               for (int m = 0; m < bullets.size(); m++) {
                  if (bullets.size() != 0) {
                     for (int j = 0; j < aliens.size(); j++) {

                        if (aliens.get(j).getX() > bullets.get(m).getX() - 200
                              && aliens.get(j).getX() < bullets.get(m).getX()
                                    + 200) {
                           System.out.println(j + "," + m);
                           if (aliens.get(j).getCollision(bullets.get(m))) {
                              System.out.println("alien shot");
                              aliens.get(j).setX(SHOT_X);
                              aliens.get(j).setShot(true);
                              deadAliens++;
                              bullets.remove(bullets.get(m));
                              bullets.trimToSize();
                              break;
                           }
                        }
                     }
                  }
               }
            }
            if (alienBullets.size() != 0)
               for (int i = 0; i < alienBullets.size(); i++) {
                  if (alienBullets.get(i).getY() > 200) {
                     if (player.getCollision(alienBullets.get(i))) {
                        alienBullets.remove(i);
                        alienBullets.trimToSize();
                        playerShot = true;
                        player.setLife(player.getLife()-1);
                     }
                  }
               }
            if (playerShot){
               player.setColor(Color.BLACK);
               playerShot = false;
            }
            else
               player.setColor(Color.GREEN);
            if (player.getLife() == 0)
               gameOver = true;
            for (int i = 0; i < aliens.size(); i++) {
               if (aliens.get(i).getX() != SHOT_X) {
                  for (int j = 0; j < blockers.size(); j++) {
                     if (blockers.get(j).getCollision(aliens.get(i))) {
                        gameOver = true;
                     }
                  }
               }
            }
            for (int i = 0; i < alienBullets.size(); i++) {
               alienBullets.get(i).moveUp();
            }
            for (int i = 0; i < alienBullets.size(); i++) {
               if (alienBullets.get(i).checkIfOffPage(getWidth(),
                     getHeight())) {
                  alienBullets.remove(alienBullets.get(i));
                  alienBullets.trimToSize();
                  System.out.println("bullet removed");
               }
            }
            for (int i = 0; i < blockers.size(); i++) {
               blockers.get(i).update();
               for (int j = 0; j < alienBullets.size(); j++) {
                  if (blockers.get(i).getCollision(alienBullets.get(j))) {
                     alienBullets.remove(alienBullets.get(j));
                     alienBullets.trimToSize();
                     blockers.get(i).setHits(blockers.get(i).getHits()+1);
                     System.out.println("bullet removed");
                  }
               }
               for (int j = 0; j < bullets.size(); j++) {
                  if (blockers.get(i).getCollision(bullets.get(j))) {
                     bullets.remove(bullets.get(j));
                     bullets.trimToSize();
                     blockers.get(i).setHits(blockers.get(i).getHits()+1);
                     System.out.println("bullet removed");
                  }
               }
            }
          if (deadAliens == 45){
             youWin = true;
          }
         }
      }
   }

   @Override
   public void mouseClicked(MouseEvent e) {
      System.out.print("click");
      System.out.println(e.getX() + "," + e.getY());
   }
   @Override
   public void mousePressed(MouseEvent e) {
   }
   @Override
   public void mouseReleased(MouseEvent e) {
   }
   @Override
   public void mouseEntered(MouseEvent e) {
   }
   @Override
   public void mouseExited(MouseEvent e) {
   }
   @Override
   public void mouseDragged(MouseEvent e) {
   }
   @Override
   public void mouseMoved(MouseEvent e) {
   }
   @Override
   public void keyTyped(KeyEvent e) {
   }
   @Override
   public void keyPressed(KeyEvent e) {
      int key = e.getKeyCode();
      if (initGame) {
         if (!gameOver) {
            if (!pause) {
               if (key == KeyEvent.VK_LEFT) {
                  player.setLeft(true);
               }
               if (key == KeyEvent.VK_RIGHT) {
                  player.setRight(true);
               }

               if (e.getKeyCode() == KeyEvent.VK_SPACE) {

                  spacepress = true;
               }

               if (key == KeyEvent.VK_Q) {
                  q = true;
                  System.out.println("q");
               }

               if (key == KeyEvent.VK_ESCAPE) {
                  bullets.clear();
                  pause = true;
               }

            } else if (pause == true) {
               if (key == KeyEvent.VK_ESCAPE) {
                  pause = false;
               }
            }
         } else if (gameOver||youWin) {
            if (key == KeyEvent.VK_ENTER) {
               initGame = false;
               restart = true;
            }
         }
      } else {
         if (key == KeyEvent.VK_SPACE) {
            initGame = true;
         }
      }
      System.out.println("press");
   }
   @Override
   public void keyReleased(KeyEvent e) {
      int key = e.getKeyCode();
      System.out.println("releasekey");
      if (key == KeyEvent.VK_LEFT) {
         player.setLeft(false);
      }
      if (key == KeyEvent.VK_RIGHT) {
         player.setRight(false);
      }
      if (key == KeyEvent.VK_Q) {
         q = false;
      }

      if (e.getKeyCode() == KeyEvent.VK_SPACE) {
         spacepress = false;
         whenpressed = 0;

      }
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      update();
      bulletUpdate();
      alienUpdate();
      repaint();
   }
}