import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

//Thomas Varano
//[Program Descripion]
//Mar 1, 2017

public abstract class Level
extends JPanel
implements ActionListener, MouseListener, KeyListener, MouseMotionListener
{
   private static final long serialVersionUID = 1L;
   public static final int PREF_W = 700, PREF_H = 800;
   public static final double GRAVITY  = 0.018, SPRITE_JUMP = 1.23;
   public static final int SECTION_W = 50, BARREL_ADD_TIME = 650, MIN_FR = 70;
   public static BufferedImage DEFAULT_SKIN, bigSheet;
   //650
   protected RenderingHints hints = new RenderingHints(
         RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      
   protected GameBoardPainter boardImage;
   public int pacer, bonus, score, highScore, deadTimer;
   protected InGameNPC boss;
   protected BufferedImage princess;
   protected Rectangle princessBounds;
   protected Sprite player;
   protected boolean pause, restarting, paint;
   public boolean levelComplete, done, dead, songFlag;
   protected MiscObject oilBarrel;

   protected final Platform GOD_PLATFORM = new Platform(0,0,SECTION_W*13,25);
   protected final Platform PEACH_P = new Platform(275, 147, 150, 25);
   protected final Ladder GOD_LADDER = new Ladder(0,0,25,Ladder.BOUND_UP,GOD_PLATFORM);
   protected final Barrel GOD_BARREL = new Barrel(SECTION_W*4,SECTION_W*4,35,1.5,Barrel.DIR_RIGHT);
   protected final Hammer GOD_HAMMER = new Hammer(0,0,SECTION_W/1.5,SECTION_W/1.5);
   
   protected ArrayList<Platform> platforms = new ArrayList<Platform>();
   protected ArrayList<PlatformBreak> breaks = new ArrayList<PlatformBreak>();
   protected ArrayList<Ladder> ladders = new ArrayList<Ladder>();
   protected ArrayList<Hammer> hammers = new ArrayList<Hammer>();
   protected ArrayList<Barrel> barrels = new ArrayList<Barrel>();
   protected ArrayList<Item> pies = new ArrayList<Item>();
   
  protected long startTimeFR, amountFrames, frameRate;
  protected Timer timer = new Timer(5,this);
   
   
   public Level(){
      setBackground(Color.BLACK);
      setForeground(Color.WHITE);
      addMouseListener(this);
      addMouseMotionListener(this);
      addKeyListener(this);
      try {
         DEFAULT_SKIN = ImageIO.read(ClassLoader.getSystemResource("missingTexture.jpg"));
      } catch (IOException e) {
         System.err.println("ERROR: DEFAULT IMAGES UNREAD");
         DEFAULT_SKIN = null;
         e.printStackTrace();
      }
      try {
         bigSheet = ImageIO.read(ClassLoader.getSystemResource("dk-sprites.png"));
         GOD_BARREL.setRollingSheet(Animation.extractSpriteArray(bigSheet, 4, 195, 12, 12));
         GOD_BARREL.setDownLadderSheet(Animation.extractSpriteArray(bigSheet, 1, 207, 16, 10));
         paint = true;
      } catch (IOException e){
         paint = false;
         System.err.println("ERROR: MAIN SHEET UNREAD");
         e.printStackTrace();
      }
      player = new Sprite();
      
      GOD_PLATFORM.setColor(Color.RED);
      GOD_LADDER.setColor(Color.CYAN);
      GOD_BARREL.setPlatforms(platforms);
      GOD_BARREL.setLadders(ladders);
      setFocusable(true);
      requestFocus();
   }
   
   public void init(){
      initPlatforms();
      initLadders();
      initBarrel();
   }
   
   public void init(int lives){
      init();
      player.setLives(lives);
   }
   
   public void skin(){
      if (paint){
         ArrayList<BufferedImage[]> bossSkins = new ArrayList<BufferedImage[]>();
         int inGameY = 132, inGameH = 32;
         bossSkins.add(new BufferedImage[] {
               bigSheet.getSubimage(0, inGameY, 43, inGameH),
               bigSheet.getSubimage(43, inGameY, 41, inGameH),
               bigSheet.getSubimage(84, inGameY, 43, inGameH),
               bigSheet.getSubimage(127, inGameY, 39, inGameH)
               });
         bossSkins.add(Animation.extractSpriteArray(bigSheet, 2, 32, 39, 32));
         boss.setSheets(bossSkins);
         princess = bigSheet.getSubimage(0, 164, 16, 22);
         for (Hammer h : hammers)
            h.setSkin(bigSheet.getSubimage(0, 186, 9, 9));
         for (Barrel b : barrels)
            b.skin(GOD_BARREL.getRollingSheet(), GOD_BARREL.getDownLadderSheet());
         
         oilBarrel.setSkin(bigSheet.getSubimage(0, 217, 17, 29));
         //oil 17x29, 217
      }
   }

   public void initHammers(){}
   
   public void initPlatforms(){
      initBreaks();
   }
   
   public void initBreaks(){}
   
   public void initLadders(){}
  
   public void initBarrel(){}
 
   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
   }
   
   public void barrelHitByHammer(int index){
      Barrel b = barrels.get(index);
      long startTime = System.currentTimeMillis();
      while (System.currentTimeMillis()-startTime <= Barrel.REMOVAL_TIME){
         //flash a lil
            b.setColor(Color.BLUE);
         repaint();
         System.out.println("repaint");
         try {
            Thread.sleep(300);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
            b.setColor(Color.WHITE);
         repaint();
         System.out.println("repaint");
      }
      System.out.println("REMOVING BARREL");
      barrels.remove(index);
      addScore(300,true);
   }
     
   public void addAndRemoveBarrel(){}
   
   public void removeHammer(){
      for (int i = hammers.size()-1; i>=0; i--){
         if (hammers.get(i).isRemove())
            hammers.remove(i);
      }
   }
   
   public void restart(){
      dead = false;
      done = false;
      if(!barrels.isEmpty())
         barrels.removeAll(barrels);
      if (!pies.isEmpty())
         pies.removeAll(pies);
      pacer = 0;
      if (!hammers.isEmpty())
         hammers.removeAll(hammers);
      if (!platforms.isEmpty())
         platforms.removeAll(platforms);
      LevelManager.resetSounds();
      timer.restart();
   }
   
   public void restart(int lives){
      restart();
      restarting = true;
      player.setLives(lives);
   }
   
   //TODO float the score
   public void addScore(int score, boolean floatScore){
      this.score+=score;
      boardImage.setScore(this.score);
   }

   public void update(){
      if (pacer == 0){
         init();
      }
      if (!levelComplete){
         if (!pause && !player.isDead()){
            player.update();
            boss.update();
            for (int i = 0; i<barrels.size(); i++){
               barrels.get(i).update();
            }
            addAndRemoveBarrel();
            for (int i = 0; i<hammers.size(); i++)
               hammers.get(i).update();
            removeHammer();
            if (pacer%500 == 0){
               bonus-=100;
               boardImage.setBonus(bonus);
            }
            if (player.jumpedOverItem())
               addScore(100,true);
         }
      }
      if (playerWins()){
         score+=bonus;
         endLevel();
         levelComplete = true;
      }
      if (player.isDead()){
         deathSequence();
      }
      pacer++;
   }
   
   protected boolean playerWins(){
      return false;
   }
   
   public void deathSequence(){
      System.out.println("called");
      WavPlayer.pause(LevelManager.mainSong);
      if (!barrels.isEmpty())
         barrels.removeAll(barrels);
      if (!pies.isEmpty())
         pies.removeAll(pies);
      if (!songFlag && !dead && !WavPlayer.isPlaying(LevelManager.DEAD)){
         WavPlayer.play(LevelManager.DEAD);
         songFlag = true;
      }
      else if (songFlag && !dead && WavPlayer.isDone(LevelManager.DEAD))
         songFlag = false;
      if (songFlag){
         player.getAnimator().setDelay(500);
         player.setCurrentSheetIndex(Sprite.SPECIAL_1);
         System.out.println("runningSheet");
      }      
      dead = !songFlag;
      System.out.println("dead =" + dead);
   }
   
   public void endLevel(){
      System.out.println("called" + songFlag);
      WavPlayer.stop(LevelManager.mainSong);
      //TODO calls in the wrong order
      if (!songFlag)
         WavPlayer.play(LevelManager.WIN);
      if (!songFlag && !WavPlayer.isPlaying(LevelManager.WIN))
         songFlag = true;
      boardImage.setScore(score);
      bonus = 0;
   }
   
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
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
      if (key == KeyEvent.VK_RIGHT)
         player.setRight(true);
      else if (key == KeyEvent.VK_LEFT)
         player.setLeft(true);
      if (key == KeyEvent.VK_SPACE)
         player.setJumping(true);
      if (key == KeyEvent.VK_UP)
         player.setUp(true);
      else if (key == KeyEvent.VK_DOWN)
         player.setDown(true);
      if (key == KeyEvent.VK_P)
         pause = !pause;
      if (key == KeyEvent.VK_M)
         LevelManager.toggleMute();
   }

   @Override
   public void keyReleased(KeyEvent e) {
      int key = e.getKeyCode();
      if (key == KeyEvent.VK_RIGHT)
         player.setRight(false);
      else if (key == KeyEvent.VK_LEFT)
         player.setLeft(false);
      if (key == KeyEvent.VK_UP)
         player.setUp(false);
      else if (key == KeyEvent.VK_DOWN)
         player.setDown(false);
   }

   public void setHeader(int lives, int score, int highScore){
      player.setLives(lives);
      this.score = score; 
      this.highScore = highScore;
      boardImage.setHeader(lives, score, highScore, 1);
   }
   
   
   public int getLives(){
      return player.getLives();
   }
   
   public int getScore(){
      return score;
   }
   
   public int getHighScore(){
      return highScore;
   }
   
   public Timer getTimer(){
      return timer;
   }
   
   public Sprite getPlayer(){
      return player;
   }
   
   public boolean isDead(){
      return dead;
   }
   
   @Override
   public void mouseClicked(MouseEvent e) {
      System.out.println(e.getPoint().toString());
   }

   @Override
   public void mousePressed(MouseEvent e) {
      System.out.println("MOUSE"+e.getX()+","+e.getY());
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
   
   public void frameRate(String name){
      if (startTimeFR == 0)
         startTimeFR = System.currentTimeMillis();
      if (System.currentTimeMillis()-startTimeFR<1000)
         amountFrames++;
      if (System.currentTimeMillis()-startTimeFR>=1000){
         frameRate = amountFrames;
         System.out.println(name+" FR:"+frameRate);
         if (amountFrames<MIN_FR){
            System.err.println("LOW FRAMERATE");
         }
         startTimeFR = System.currentTimeMillis();
         amountFrames = 0;
      }
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      update();
      repaint();
      frameRate("lvlOne");
   }

}
