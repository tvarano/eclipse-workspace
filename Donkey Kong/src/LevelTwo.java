//Thomas varano
//[Program Descripion]
//Apr 15, 2017

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//Thomas Varano
//[Program Descripion]
//Mar 1, 2017
   
/*
 * TODO
 * finish inputting ladders
 * make final spot
 * code for climbing DONE
 * make barrels DONE
 *    ensure they roll DONE
 *    ensure detection DONE
 *    work on how to make them start rolling DONE
 *       **NOTE** study algorithm for timing of barrels DONE
 *make npcs DONE
 *intro/other screens DONE
 *scoring ALMOST DONE
 *fire guys
 *skin everything
 *sprite animation DONE
 *level two
 */

/*
 * TODO level 2
 * the conveyor belts move independently
 * moving ladders
 * hammers
 * fire guys??
 * outro
 * moving right over a break
 */

public class LevelTwo
extends Level
implements ActionListener, MouseListener, KeyListener, MouseMotionListener
{
   private static final long serialVersionUID = 1L;
   private ArrayList<Location> pieSpawns = new ArrayList<Location>();
//   private ArrayList<Item> items = new ArrayList<Item>();
   public static final MiscObject GOD_PIE = new MiscObject(0,0,SECTION_W,25,1000);
   private Ladder[] movingLadders = new Ladder[2];   
   
   public LevelTwo(){
      super();
      GOD_PLATFORM.setColor(Color.RED);
      try {
         GOD_PLATFORM.setSkin(ImageIO.read(ClassLoader.getSystemResource("platformImageLvlTwo.png")));
      } catch (IOException e) {
         e.printStackTrace();
      }
      GOD_LADDER.setColor(Color.CYAN);
      GOD_BARREL.setPlatforms(platforms);
      GOD_BARREL.setLadders(ladders);
      
//      timer.start();

   }
   
   public void init(){
      player = new Sprite(50,0,30,50,1,GRAVITY,SPRITE_JUMP);
      initPlatforms();
      initPieSpawns();
      player.setY(platforms.get(0).getY()-50);
      player.setPlatforms(platforms);
      player.setLadders(ladders);
      
      boss = new InGameNPC(SECTION_W*1.5,platforms.get(7).getY()-SECTION_W*2+2,SECTION_W*3,SECTION_W*2);
      boss.setPlatforms(platforms);
      boss.setLadders(ladders);
//      princess = new InGameNPC(platforms.get(8).getX(),platforms.get(8).getY()-SECTION_W,SECTION_W*0.75,SECTION_W);
      initItems();
      initHammers();
      
      boardImage = new GameBoardPainter(player.getLives(), score, highScore, 1, "LvlTwo");
      bonus = 5000;
      boardImage.setPrimaryColor(Color.ORANGE);
      boardImage.setSecondaryColor(Color.YELLOW);
      boardImage.setLadders(ladders);
      boardImage.setPlatforms(platforms);
      boardImage.setShowBonus(true);
      initLadders();
      super.skin();
      boss.getAnimator().setIndex(3);
   }
   
   public void init(int lives){
      init();
      player.setLives(lives);
   }

   public void initHammers(){
      hammers.add(new Hammer(
            SECTION_W*6.5, platforms.get(3).getMaxY()+5, GOD_HAMMER.getWidth(), GOD_HAMMER.getHeight()));
      hammers.add(new Hammer(
            SECTION_W, platforms.get(5).getMaxY()+10, GOD_HAMMER.getWidth(), GOD_HAMMER.getHeight()));
//      hammers.add(new Hammer(
//            SECTION_W,platforms.get(6).getMaxY()+15, GOD_HAMMER.getWidth(), GOD_HAMMER.getHeight()));
//      hammers.add(new Hammer(
//            SECTION_W*10.5, platforms.get(3).getY()+10, GOD_HAMMER.getWidth(), GOD_HAMMER.getHeight()));
      for(int i = 0; i<hammers.size(); i++)
         hammers.get(i).setPlayer(player);
   }
   
   public void initPlatforms(){
      double conveyorStrength = 0.8;
      //0
      platforms.add(new Platform(
            0,PREF_H-25,SECTION_W*14,GOD_PLATFORM.getHeight()));
      //1
      platforms.add(new ConveyorBelt(
            0,platforms.get(0).getY()-128,SECTION_W*14,GOD_PLATFORM.getHeight(),conveyorStrength));
      //2
      platforms.add(new Platform(
            0,platforms.get(1).getY()-128,SECTION_W*3,GOD_PLATFORM.getHeight()));
      //3
      platforms.add(new Platform(
            (int)(platforms.get(2).getMaxX()+SECTION_W), 
            platforms.get(2).getY(), SECTION_W*6, GOD_PLATFORM.getHeight()));
      //4
      platforms.add(new Platform(
            (int)(platforms.get(3).getMaxX()+SECTION_W),
            platforms.get(2).getY(), SECTION_W*3, GOD_PLATFORM.getHeight()));
      //5 (left of oil)
      platforms.add(new ConveyorBelt(
            0, platforms.get(4).getY()-128,(int)(SECTION_W*6.5),GOD_PLATFORM.getHeight(),conveyorStrength));
      //6
      platforms.add(new ConveyorBelt(
            (int)(platforms.get(5).getMaxX()+SECTION_W),
            platforms.get(5).getY(), (int)(SECTION_W*6.5), GOD_PLATFORM.getHeight(),conveyorStrength));
      //7
      platforms.add(new ConveyorBelt(
            0,platforms.get(6).getY()-128,SECTION_W*14,GOD_PLATFORM.getHeight(), conveyorStrength));
      //8 (peach platform)
      platforms.add(new Platform(
            PEACH_P.getX(), PEACH_P.getY(), PEACH_P.getWidth(), PEACH_P.getHeight()));
      for (int i = 0; i<platforms.size(); i++){
         platforms.get(i).setColor(GOD_PLATFORM.getColor());
      }
      for (int i = 0; i<platforms.size(); i++){
         if (!(platforms.get(i) instanceof ConveyorBelt))
            platforms.get(i).setSkin(GOD_PLATFORM.skin);
      }
      System.out.println("size"+platforms.size());
      initBreaks();
   }
   
   public void initBreaks(){
      breaks.add(new PlatformBreak(platforms.get(2),platforms.get(3)));
      breaks.add(new PlatformBreak(platforms.get(3),platforms.get(4)));
      player.setBreaks(breaks);
   }
   
   public void initLadders(){
      ladders.removeAll(ladders);
      int ladderWidth = 25;
      //fake ones
//      ladders.add(new Ladder(
//            0,ladderWidth, platforms.get(0), platforms.get(1)));
//      ladders.add(new Ladder(
//            50, ladderWidth, platforms.get(1),platforms.get(2)));
//      ladders.add(new Ladder(
//            0, ladderWidth, platforms.get(2),platforms.get(5)));
      //real ones
      //0
      ladders.add(new Ladder(
            SECTION_W*2, ladderWidth, platforms.get(0),platforms.get(1), true));
      //1
      ladders.add(new Ladder(
            SECTION_W*5, ladderWidth, platforms.get(0),platforms.get(1)));
      //2
      ladders.add(new Ladder(
            SECTION_W*9, ladderWidth, platforms.get(0), platforms.get(1), true));
      //3
      ladders.add(new Ladder(
            SECTION_W*12, ladderWidth, platforms.get(0), platforms.get(1)));
      //4
      ladders.add(new Ladder(
            platforms.get(3).getX(), ladderWidth, platforms.get(1), platforms.get(3)));
      //5
      ladders.add(new Ladder(
            (int) platforms.get(3).getMaxX(), ladderWidth, platforms.get(1), platforms.get(3),true));
      //6
      ladders.add(new Ladder(
            SECTION_W*2, ladderWidth, platforms.get(2), platforms.get(5),true));
      //7
      ladders.add(new Ladder(
            platforms.get(3).getX()+SECTION_W, ladderWidth, platforms.get(3), platforms.get(5)));
      //8
      ladders.add(new Ladder(
            (int) platforms.get(3).getMaxX()-SECTION_W, ladderWidth, platforms.get(3), platforms.get(6)));
      //9
      ladders.add (new Ladder(
            SECTION_W*12, ladderWidth, platforms.get(4), platforms.get(6)));
      
      int height = (int)((platforms.get(5).getY()-platforms.get(7).getMaxY())/2);
      //10
      ladders.add(new Ladder(
            SECTION_W, ladderWidth, height+15, Ladder.BOUND_DOWN, platforms.get(5)));
      //11
      ladders.add(new Ladder(
            SECTION_W*13, ladderWidth, height+15, Ladder.BOUND_DOWN, platforms.get(6),true));
      //peach ladder
      ladders.add(new Ladder(
            platforms.get(8).getX()+platforms.get(8).getWidth(),
            ladderWidth,platforms.get(7).getSection(0),platforms.get(8),true));
      //endless ladders
      ladders.add(new Ladder(
            platforms.get(8).getX(),ladderWidth,175,Ladder.BOUND_DOWN,platforms.get(7),true));
      ladders.add(new Ladder(
            SECTION_W*4,ladderWidth,175,Ladder.BOUND_DOWN,platforms.get(7)));
      
      movingLadders[0] = new Ladder(
            SECTION_W-3, ladderWidth+6, height, Ladder.BOUND_UP, platforms.get(7));
      movingLadders[1] = new Ladder(
            ladders.get(11).getX()-3, ladderWidth+6, height, Ladder.BOUND_UP, platforms.get(7));
      
      BufferedImage ladderSkin = null;
      try {
        ladderSkin = ImageIO.read(ClassLoader.getSystemResource("ladderSkinLevelOne.png"));
      } catch (IOException e){
         e.printStackTrace();
      }
      
      for (int i = 0; i<ladders.size(); i++){
         ladders.get(i).setColor(GOD_LADDER.getColor());
         ladders.get(i).setSkin(ladderSkin);
      }
      boardImage.repaint();
      ladders.add(movingLadders[0]);
      movingLadders[0].setSkin(ladderSkin);
      ladders.add(movingLadders[1]);
      movingLadders[1].setSkin(ladderSkin);
   }
   
   public void initPieSpawns(){
      pieSpawns.removeAll(pieSpawns);
      pieSpawns.add(new Location(
            platforms.get(5).getX()-GOD_PIE.getWidth()+3, platforms.get(5).getY()-GOD_PIE.getHeight()+2));
      pieSpawns.add(new Location(
            platforms.get(1).getX()-GOD_PIE.getWidth()+3, platforms.get(1).getY()-GOD_PIE.getHeight()+2));
      pieSpawns.add(new Location(platforms.get(6).getEdgeR()-3, platforms.get(6).getY()-GOD_PIE.getHeight()+2));
      pieSpawns.add(new Location(platforms.get(1).getMaxX()-3,platforms.get(1).getY()-GOD_PIE.getHeight()+2));
   }
   
   public void initItems(){
      oilBarrel = new MiscObject(
            platforms.get(5).getMaxX(),platforms.get(5).getY()-SECTION_W, SECTION_W, SECTION_W*2, 250);
      //FIXME
      ArrayList<Sprite> sp = new ArrayList<Sprite>();
      sp.add(player);
      if (!pies.isEmpty())
         for (Item i : pies)
            if (i instanceof MiscObject)
               i.setPlatforms(
                  this.platforms);
      for (Platform p : platforms){
         if (p instanceof ConveyorBelt){
            p.setSprites(sp);
//            FIXME
//            p.setItems(pies);
            ((ConveyorBelt) p).getItems().add(boss);
         }
      }
      player.setObstacles(pies);
      player.getObstacles().add(oilBarrel);
   }
   
   public void refreshItems(){
      for (Platform p : platforms) {
         if (p instanceof ConveyorBelt){
            p.setItems(pies);
            ((ConveyorBelt) p).getItems().add(boss);
         }
      }
   }
 
   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHints(hints);
      if (pacer>0){
         for (Ladder l : movingLadders)
            l.draw(g2);
         boardImage.draw(g2);
         player.drawBounds(g2);
         player.draw(g2);
//         for (PlatformBreak b : breaks)
//            b.drawBounds(g2);
         for(Hammer h : hammers)
            h.drawBounds(g2);
         boss.draw(g2);
//         if (boss.getCurrentSheetIndex() != InGameNPC.CLIMB)
//            princess.draw(g2);
      for (Item p : pies)
         if (p instanceof MiscObject)
            ((MiscObject)p).draw(g2);
      oilBarrel.draw(g2);
      if (pause)
         g2.drawString("pause", 0, 25);
      }
   }
   
   public void pieHitByHammer(int index){
      Item p = pies.get(index);
      long startTime = System.currentTimeMillis();
      while (System.currentTimeMillis()-startTime <= Barrel.REMOVAL_TIME){
         //flash a lil
            p.setColor(Color.BLUE);
         repaint();
         System.out.println("repaint");
         try {
            Thread.sleep(300);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
            p.setColor(Color.WHITE);
         repaint();
         System.out.println("repaint");
      }
      System.out.println("REMOVING BARREL");
      pies.remove(index);
      addScore(300,true);
      refreshItems();
   }
   
   public void addPie(int location) {
      Location spawn = pieSpawns.get(location);
      pies.add(new MiscObject(spawn.x, spawn.y,
            GOD_PIE.getWidth(), GOD_PIE.getHeight(), GOD_PIE.getAnimator().getDelay()));
      pies.get(pies.size()-1).setPlatforms(platforms);
   }
   
   public void addAndRemovePie(){
      if (pacer%BARREL_ADD_TIME == 0){
         if (((ConveyorBelt) platforms.get(1)).getDirection() == ConveyorBelt.RIGHT)
            addPie((int)(Math.random()*2));
         else
            addPie((int)(Math.random()*2)+2);
            
         refreshItems();
      }
      for (int i = pies.size()-1; i>=0; i--){
         if (pies.get(i).getX()>=PREF_W || pies.get(i).getX()<=-GOD_PIE.getWidth()){
            pies.remove(i);
            refreshItems();
         }
         else if (pies.get(i).isHitWithHammer()){
            pieHitByHammer(i);
         }
      }
   }
  
   public void removeHammer(){
      for (int i = hammers.size()-1; i>=0; i--){
         if (hammers.get(i).isRemove())
            hammers.remove(i);
      }
   }
   @Override
   public void update(){
      if (pacer == 0){
         init();
      }
      if (!levelComplete){
         if (!pause && !player.isDead()){
            player.update();
            boss.update();
            for (int i = 0; i<pies.size(); i++){
               if (pies.get(i) instanceof MiscObject)
                  ((MiscObject) pies.get(i)).update();
            }
            if (boss.getBounds().getMaxX() >= PREF_W-3){
               for (Platform p : platforms)
                  if (p instanceof ConveyorBelt)
                     ((ConveyorBelt) p).setDirection(ConveyorBelt.LEFT);
               for (Ladder l : movingLadders) {
                  l.setDown(false);
                  l.setUp(true);
               }
            }
            else if (boss.getX() <= 3){
               for (Platform p : platforms)
                  if (p instanceof ConveyorBelt)
                     ((ConveyorBelt) p).setDirection(ConveyorBelt.RIGHT);
               for (Ladder l : movingLadders) {
                  l.setUp(false);
                  l.setDown(true);  
               }
            }
            for (Ladder l : movingLadders)
               l.move();
            for (Platform p : platforms)
               p.update();
            addAndRemovePie();
            for (Hammer h : hammers)
               h.update();
            removeHammer();
            if (pacer%500 == 0){
               bonus-=100;
               boardImage.setBonus(bonus);
            }
            if (player.jumpedOverItem())
               addScore(100,true);
         }
      }
//      if (player.currentPlatform()!=null && player.currentPlatform().equals(platforms.get(8))){
//         score+=bonus;
//         endLevel();
//         levelComplete = true;
//      }
      if (player.isDead()){
         deathSequence();
      }
      pacer++;
   }
   
   //FIXME death sequence 
            //use for loop NO use other thing embedded if, keep timer running.
      //USE JUKEBOX AND ANIMATE UNTIL DONE
   public void deathSequence(){
      for (int i = 0; i<4; i++){
         player.getAnimator().setDelay(500);
         player.setCurrentSheetIndex(Sprite.SPECIAL_1);
         if (!pies.isEmpty())
            pies.removeAll(pies);
         //do nothing in a while loop??
      }
      player.setCurrentSheetIndex(Sprite.SPECIAL_2);
      dead = true;
   }
   
   public void endLevel(){
      System.out.println("level over");
      boardImage.setScore(score);
      bonus = 0;
      player.setX(ladders.get(16).getX());
      player.setDy(0);
      player.setDirection(Sprite.LEFT);
      player.setCurrentSheetIndex(Sprite.STILL);
      boss.endOfLvlOne();
      if (boss.getY()<=SECTION_W*2)
         done = true;
   }
   
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }
   
   private static void createAndShowGUI() {
      JFrame frame = new JFrame("Donkey Kong");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new LevelTwo());
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
      super.keyPressed(e);
   }

   @Override
   public void keyReleased(KeyEvent e) {
      super.keyReleased(e);
   }
   
   @Override
   public void mouseClicked(MouseEvent e) {
      System.out.println("mouse"+e.getPoint().toString());
   }

   @Override
   public void mousePressed(MouseEvent e) {}

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
   public void actionPerformed(ActionEvent e) {
      update();
      repaint();
      frameRate("lvlTwo");
   }
}
