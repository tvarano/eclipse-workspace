import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

//Thomas Varano
//[Program Descripion]
//Mar 15, 2017

public class OpeningCutscene
extends JPanel
implements ActionListener, KeyListener
{
   private static final long serialVersionUID = 1L;
   private final static int PREF_W = 700;
   private final static int PREF_H = 800;
   public final static int MIN_FR = 50;
   private static BufferedImage levelImage, bigSheet;
   private static final int SECTION_W = 50;
   private final Platform GOD_PLATFORM = new Platform(0,0,SECTION_W*13,25);
   private final Ladder GOD_LADDER = new Ladder(0,0,25,Ladder.BOUND_UP,GOD_PLATFORM);
   private static RenderingHints hints = new RenderingHints(
         RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   private static Font howHighFont = new Font("Courier",Font.PLAIN, 40);
   
   private GameBoardPainter boardImage;
   private boolean firstRun, playedSong, done, drawPrincess;
   private File bossScript = new File("src/bossScript.txt");
   private File peachScript = new File("src/peachScript.txt");
   private ArrayList<Ladder> ladders = new ArrayList<Ladder>(), openingLadders = new ArrayList<Ladder>();
   private ArrayList<Platform> platforms = new ArrayList<Platform>();
   private int levelScreenTimer;
   
   private int lives, score, highScore, level, bonus;   
   private CutsceneNPC boss, princess;
   private Timer mainTimer = new Timer(15,this);
   private boolean drawLevelScreen, firstPlay;
   
   private long startTimeFR, amountFrames;
   
   public OpeningCutscene(int level, boolean firstPlay){
      setBackground(Color.BLACK);
      setForeground(Color.WHITE);
      GOD_PLATFORM.setColor(Color.RED);
      GOD_LADDER.setColor(Color.CYAN);
      //double x, double y, double width, double height, double maxSpeed, File script
      boss = new CutsceneNPC(
            SECTION_W*6.5,PREF_H-SECTION_W*2,SECTION_W*3,SECTION_W*2,5,bossScript);
      boss.setGravity(0.4);
      int peachX = 275, peachY = 97;
      princess = new CutsceneNPC(
            peachX, peachY,SECTION_W*0.75,SECTION_W,5,peachScript); 
      firstRun = true;
      this.firstPlay = firstPlay;
      try{
         levelImage = ImageIO.read(ClassLoader.getSystemResource("kongSprite.png"));      
      } catch (IOException e){
         levelImage = LevelOne.DEFAULT_SKIN;
         System.err.println("unable to read kong sprite for level screen");
      }
      try {
         bigSheet = ImageIO.read(ClassLoader.getSystemResource("dk-sprites.png"));
      } catch (IOException e){
         System.err.println("ERROR: MAIN SHEET UNREAD");
         e.printStackTrace();
      }
      playedSong = false;
      boardImage = new GameBoardPainter("Cutscene");
      boardImage.setLadders(openingLadders);
      boardImage.setShowBonus(false);
      boardImage.setPlatforms(platforms);
      skin();
      done = false;
      this.level = level;
      addKeyListener(this);
      setFocusable(true);
      playedSong = false;
      mainTimer.start();
   }
   
   public void skin() {
      boss.setStillSheet(Animation.extractSpriteArray(bigSheet, 1, 32, 39, 32));
      boss.setHorizontalSheet(boss.getStillSheet());
      boss.setJumpSheet(boss.getStillSheet());
      boss.setVerticalSheet(Animation.extractSpriteArray(bigSheet, 2, 64, 39, 32));
      boss.setSpecialSheet(new BufferedImage[] {levelImage});
      boss.getAnimator().setDelay(250);
      
      princess.setStillSheet(Animation.extractSpriteArray(bigSheet, 1, 164, 16, 21));
      princess.getAnimator().setDelay(-1);
   }
   
   protected void paintComponent(Graphics g){
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHints(hints);
      if (!drawLevelScreen){
         if(drawPrincess)
            princess.draw(g2);
         boardImage.drawBody(g2);
         boss.draw(g2);
      }
      else
         drawBeforeLevel(g2);
      boardImage.drawHeader(g2);
   }
   
   public void shake(int platformIndex){
      boardImage.setLadders(ladders);
      platformIndex = platforms.size()-1-platformIndex;
      if (platformIndex == 6)
         platformIndex--;
      platforms.get(platformIndex).rotateAndBreakWithStep(3, SECTION_W);
      if (platformIndex == 0 || platformIndex == 1)
         initLadders();
      boardImage.repaint();
   }
   
   public void drawBeforeLevel(Graphics2D g2){
      if (!playedSong){
         WavPlayer.play(LevelManager.LVLOPEN);
         playedSong = true;
      }
      g2.drawImage(getLevelScreen(level), 0, 0, PREF_W,PREF_H, null);
   }
   
   public static BufferedImage getLevelScreen(int level){
      BufferedImage mainImage = new BufferedImage(PREF_W, PREF_H, BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2 = mainImage.createGraphics();
      g2.setRenderingHints(hints);
      g2.setColor(Color.BLACK);
      g2.drawRect(0, 0, PREF_W, PREF_H);
      g2.setColor(Color.WHITE);
      g2.setFont(howHighFont);
      g2.drawString("HOW HIGH CAN YOU GET?", PREF_W/2-("HOW HIGH CAN YOU GET?".length()/2*25), PREF_H-25);
      if (level >= 0){
         g2.drawImage(levelImage, (int)(PREF_W/2-SECTION_W), 625, SECTION_W*3, SECTION_W*2, null);
         g2.drawString("25m", (int)(PREF_W/2-175), 715);
      }
      if (level >= 2){
         g2.drawImage(levelImage, (int)(PREF_W/2-SECTION_W), 625-SECTION_W*2, SECTION_W*3, SECTION_W*2, null);
         g2.drawString("50m", (int)(PREF_W/2-175), 715-SECTION_W*2);
      }
      if (level >= 3){
         g2.drawImage(levelImage, (int)(PREF_W/2-SECTION_W), 625-SECTION_W*4, SECTION_W*3, SECTION_W*2, null);
         g2.drawString("75m", (int)(PREF_W/2-175), 715-SECTION_W*4);
      }
      if (level >= 4){
         g2.drawImage(levelImage, (int)(PREF_W/2-SECTION_W), 625-SECTION_W*6, SECTION_W*3, SECTION_W*2, null);
         g2.drawString("100m", (int)(PREF_W/2-175), 715-SECTION_W*6);
      }
      return mainImage;
   }

   public void drawDeathScreen(Graphics2D g2){
      g2.drawImage(getDeathScreen(), 0, 0, PREF_W, PREF_H, null);
   }
   
   public BufferedImage getDeathScreen(){
      BufferedImage mainImage = new BufferedImage(PREF_W, PREF_H, BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2 = mainImage.createGraphics();
      g2.setRenderingHints(hints);
      g2.setColor(Color.BLACK);
      g2.drawRect(0, 0, PREF_W, PREF_H);
      g2.setColor(Color.WHITE);
      g2.drawString("GAME OVER", 100, 250);
      g2.drawImage(levelImage, (int)(PREF_W/2-SECTION_W), 625-SECTION_W*3, SECTION_W*3, SECTION_W*2, null);
      g2.drawString("SCORE: "+score, 100, 450);
      g2.drawString("HIGHSCORE", 100, 500);
      return mainImage;
   }
   
   
   public void initPlatforms(){
      //0
      platforms.add(new Platform(
            0,PREF_H-25,SECTION_W*6,GOD_PLATFORM.getHeight()));
      //1
      platforms.add(new Platform(
            platforms.get(0).getWidth(),platforms.get(0).getY(),SECTION_W*8,GOD_PLATFORM.getHeight()));
      platforms.get(1).setDegreeRotation(-2);
      //2
      platforms.add(new Platform(
            0,platforms.get(1).getY()-128,GOD_PLATFORM.getWidth(),GOD_PLATFORM.getHeight()));
      platforms.get(2).setDegreeRotation(2);
      //3
      platforms.add(new Platform(
            SECTION_W,platforms.get(2).getY()-70,GOD_PLATFORM.getWidth(),GOD_PLATFORM.getHeight()));
      platforms.get(3).setDegreeRotation(-2);
      //4
      platforms.add(new Platform(
            0,platforms.get(3).getY()-145,GOD_PLATFORM.getWidth(),GOD_PLATFORM.getHeight()));
      platforms.get(4).setDegreeRotation(2);
      //5
      platforms.add(new Platform(
            SECTION_W,platforms.get(4).getY()-70,GOD_PLATFORM.getWidth(),GOD_PLATFORM.getHeight()));
      platforms.get(5).setDegreeRotation(-2);
      //6
      platforms.add(new Platform(
            0,platforms.get(5).getY()-120,SECTION_W*8,GOD_PLATFORM.getHeight()));
      //7
      platforms.add(new Platform(
            platforms.get(6).getWidth(),platforms.get(6).getY(),SECTION_W*5,GOD_PLATFORM.getHeight()));
      platforms.get(7).setDegreeRotation(2);
      //8 (peach's platform)
      platforms.add(new Platform(
            (int)(SECTION_W*5.5),platforms.get(6).getY()-85,SECTION_W*3,GOD_PLATFORM.getHeight()));

      for (Platform currentPlatform : platforms){
         currentPlatform.setColor(GOD_PLATFORM.getColor());
      }
   }
   
   public void initLadders(){
      int ladderWidth = 25;
      ladders.add(new Ladder(
            SECTION_W*5,ladderWidth,15,Ladder.BOUND_UP,platforms.get(2).getSection(5)));
      ladders.add(new Ladder(
            SECTION_W*5,ladderWidth,30,Ladder.BOUND_DOWN,platforms.get(0)));
      ladders.add(new Ladder(
            //section_w*12
            platforms.get(1).getSection(6).getX(),25,
            platforms.get(1).getSection(5),platforms.get(2).getSection(11),true));
      ladders.add(new Ladder(
            SECTION_W*6,ladderWidth,platforms.get(2).getSection(6),platforms.get(3).getSection(5)));
      ladders.add(new Ladder(
            SECTION_W*2,ladderWidth,platforms.get(2).getSection(2),platforms.get(3).getSection(1)));
      ladders.add(new Ladder(
            SECTION_W*4,ladderWidth,20,Ladder.BOUND_UP,platforms.get(4).getSection(4)));
      ladders.add(new Ladder(
            SECTION_W*4,ladderWidth,30,Ladder.BOUND_DOWN,platforms.get(3).getSection(3)));
      ladders.add(new Ladder(
            SECTION_W*7,ladderWidth,platforms.get(3).getSection(6),platforms.get(4).getSection(7)));
      ladders.add(new Ladder(
            SECTION_W*12,ladderWidth,platforms.get(3).getSection(10),platforms.get(4).getSection(11),true));
      ladders.add(new Ladder(
            SECTION_W*11,ladderWidth,30,Ladder.BOUND_DOWN,platforms.get(4).getSection(10),true));
      ladders.add(new Ladder(
            SECTION_W*11,ladderWidth,20,Ladder.BOUND_UP,platforms.get(5).getSection(9),true));
      ladders.add(new Ladder(
            SECTION_W*5,ladderWidth,platforms.get(4).getSection(4),platforms.get(5).getSection(3),true));
      ladders.add(new Ladder(
            SECTION_W*2,ladderWidth,platforms.get(4).getSection(2),platforms.get(5).getSection(1)));
      ladders.add(new Ladder(
            SECTION_W*6,ladderWidth,40,Ladder.BOUND_DOWN,platforms.get(5).getSection(4),true));
      ladders.add(new Ladder(
            SECTION_W*6,ladderWidth,15,Ladder.BOUND_UP,platforms.get(6),true));
      ladders.add(new Ladder(
            SECTION_W*12,ladderWidth,platforms.get(5).getSection(10),platforms.get(7).getSection(3),true));
      ladders.add(new Ladder(
            platforms.get(8).getX()+platforms.get(8).getWidth(),
            ladderWidth,platforms.get(7).getSection(0),platforms.get(8),true));
      //endless ladders
      ladders.add(new Ladder(
            platforms.get(8).getX(),ladderWidth,150,Ladder.BOUND_DOWN,platforms.get(6),true));
      ladders.add(new Ladder(
            SECTION_W*4,ladderWidth,150,Ladder.BOUND_DOWN,platforms.get(6)));
      
      BufferedImage ladderSkin = null;
      try {
         ImageIO.read(ClassLoader.getSystemResource("ladderSkinLevelOne.png"));
      } catch (IOException e){
         e.printStackTrace();
      }

      for (Ladder currentLadder : ladders){
         currentLadder.setColor(GOD_LADDER.getColor());
         currentLadder.setSkin(ladderSkin);
      }
      
      boardImage.repaint();
   }
   
   public void initOpeningLadders(){
      openingLadders.add(new Ladder(
            platforms.get(8).getX()+platforms.get(8).getWidth(),25,500,Ladder.BOUND_UP,platforms.get(6),true));
      openingLadders.add(new Ladder(
            openingLadders.get(0).getX()-SECTION_W,25,500,Ladder.BOUND_UP,platforms.get(6)));
      openingLadders.get(0).setY(openingLadders.get(0).getY()+GOD_PLATFORM.getHeight());
      openingLadders.get(1).setY(openingLadders.get(1).getY()+GOD_PLATFORM.getHeight());
      BufferedImage ladderSkin = null;
      try {
        ladderSkin = ImageIO.read(ClassLoader.getSystemResource("ladderSkinLevelOne.png"));;
      } catch (IOException e){
         e.printStackTrace();
      }
      for (int i = 0; i < openingLadders.size(); i++){
         openingLadders.get(i).setColor(Color.CYAN);
         openingLadders.get(i).setSkin(ladderSkin);
      }
   }
  
   public void update(){
      if (level == 0 || level == 1 && firstPlay){
         int oldBossTrigger = boss.getTrigger();
         if (!playedSong){ 
            System.out.println("play");
            WavPlayer.play(LevelManager.CUTSCENE);
         }
         if (firstRun){
            initPlatforms();
            initOpeningLadders();
            boardImage.repaint();
            firstRun = false;
         }
         playedSong = true;
         boss.update();
         princess.update();
         if ((boss.getTrigger() != 0 && boss.getTrigger()<8) && oldBossTrigger!=boss.getTrigger())
            shake(boss.getTrigger());
         drawLevelScreen = boss.isDoneWorking();
         if (boss.getTrigger() == 1)
            drawPrincess = true;
            
         if (boss.isDoneWorking())
            boss.setX(75.0);
      }
      else {
         playedSong = drawLevelScreen = true;
      }
      if (drawLevelScreen){
         levelScreenTimer++;
      }
      done = (levelScreenTimer>=200);
   }
   
   public void restart(){
      this.restart(level, firstPlay);
   }
   
   public void restart(int level, boolean firstPlay){
      this.level = level;
      this.firstPlay = firstPlay;
      this.firstRun = true;
      levelScreenTimer = 0;
      playedSong = false;
      done = false;
      if (!openingLadders.isEmpty())
         openingLadders.removeAll(openingLadders);
      if (!platforms.isEmpty())
         platforms.removeAll(platforms);
      if (!ladders.isEmpty())
         ladders.removeAll(ladders);
      boss = new CutsceneNPC(
            SECTION_W*6.5,PREF_H-SECTION_W*2,SECTION_W*3,SECTION_W*2,5,bossScript);
      boss.setGravity(0.4);
      WavPlayer.resetPosition(LevelManager.LVLOPEN);
      WavPlayer.resetPosition(LevelManager.CUTSCENE);
      playedSong = drawPrincess = false;
   }
   
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }
   
   public ArrayList<Ladder> getLadders() {
      return ladders;
   }

   public void setLadders(ArrayList<Ladder> ladders) {
      this.ladders = ladders;
   }

   public ArrayList<Platform> getPlatforms() {
      return platforms;
   }

   public void setPlatforms(ArrayList<Platform> platforms) {
      this.platforms = platforms;
   }

   public int getLives() {
      return lives;
   }

   public void setLives(int lives) {
      this.lives = lives;
   }

   public int getScore() {
      return score;
   }

   public void setScore(int score) {
      this.score = score;
   }

   public int getHighScore() {
      return highScore;
   }

   public void setHighScore(int highScore) {
      this.highScore = highScore;
   }

   public int getLevel() {
      return level;
   }

   public void setLevel(int level) {
      this.level = level;
   }

   public int getBonus() {
      return bonus;
   }

   public void setBonus(int bonus) {
      this.bonus = bonus;
   }

   public boolean isFirstPlay() {
      return firstPlay;
   }

   public void setFirstPlay(boolean firstPlay) {
      this.firstPlay = firstPlay;
   }

   public boolean isDone() {
      return done;
   }

   public void setDone(boolean done) {
      this.done = done;
   }
   
   public void setHeader(int level, int lives, int score, int highScore){
      this.lives = lives;
      this.score = score; 
      this.highScore = highScore;
      this.level = level;
      boardImage.setHeader(lives, score, highScore, level);
   }
   
   public String toString(){
      return (getClass().getName()+"[l="+level+",firstPlay="+firstPlay+"]");
   }
   
   public void frameRate(){
      if (startTimeFR == 0)
         startTimeFR = System.currentTimeMillis();
      if (System.currentTimeMillis()-startTimeFR<1000)
         amountFrames++;
      if (System.currentTimeMillis()-startTimeFR>=1000){
         System.out.println("cutscene FR:"+amountFrames);
         if (amountFrames<MIN_FR){
            System.err.println("LOW FRAMERATE");
         }
         startTimeFR = System.currentTimeMillis();
         amountFrames = 0;
      }
   }

   @Override
   public void keyTyped(KeyEvent e) {
   }

   @Override
   public void keyPressed(KeyEvent e) {
      System.out.println("hey?");
      if (e.getKeyCode() == KeyEvent.VK_M)
         LevelManager.toggleMute();
   }

   @Override
   public void keyReleased(KeyEvent e) {
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      update();
      repaint();
      frameRate();
   }
}
