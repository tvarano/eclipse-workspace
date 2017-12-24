import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

//Thomas Varano
//[Program Descripion]
//Mar 1, 2017
   
/*
 * TODO
 * finish inputting ladders DONE
 * make final spot DONE
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

public class LevelOne
extends Level
implements ActionListener, MouseListener, KeyListener, MouseMotionListener
{
   private static final long serialVersionUID = 1L;   
   private BufferedImage barrelPile = Level.bigSheet.getSubimage(0, 0, 30, 32);
   
   public LevelOne(){
      super();
   }
   
   public void init(){
      initPlatforms();
      player = new Sprite(50,platforms.get(0).getY()-50,30,50,1,GRAVITY,SPRITE_JUMP);
      player.setPlatforms(platforms);
      player.setLadders(ladders);
      player.setBarrels(barrels);
      
      boss = new InGameNPC(SECTION_W*1.5,platforms.get(6).getY()-SECTION_W*2,SECTION_W*3,SECTION_W*2);
      boss.setPlatforms(platforms);
      boss.setLadders(ladders);
      princessBounds = new Rectangle(
            platforms.get(8).getX(),platforms.get(8).getY()-SECTION_W,(int)(SECTION_W*0.75),SECTION_W);
      System.out.println("peachx = "+princessBounds.getX()+" y="+princessBounds.getY());
      
      oilBarrel = new MiscObject(5,platforms.get(0).getY()-SECTION_W*1.5,SECTION_W,SECTION_W*1.5,0);
      bonus = 5000;
      boardImage = new GameBoardPainter(player.getLives(), score, highScore, 1, "LvlOne");
      boardImage.setLadders(ladders);
      boardImage.setPlatforms(platforms);
      boardImage.setShowBonus(true);
      initBarrel();
      shake();
      super.skin();
      boss.getAnimator().setIndex(1);
   }
   
//   public void init(int lives){
//      init();
//      player.setLives(lives);
//   }

   public void initHammers(){
      hammers.add(new Hammer(
            SECTION_W,platforms.get(6).getMaxY()+15,SECTION_W/1.5,SECTION_W/1.5));
      hammers.add(new Hammer(
            SECTION_W*10.5, platforms.get(3).getY()+10, SECTION_W/1.5,SECTION_W/1.5));
      for(int i = 0; i<hammers.size(); i++)
         hammers.get(i).setPlayer(player);
   }
   
   @Override
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
            SECTION_W,platforms.get(2).getY()-75,GOD_PLATFORM.getWidth(),GOD_PLATFORM.getHeight()));
      platforms.get(3).setDegreeRotation(-2);
      //4
      platforms.add(new Platform(
            0,platforms.get(3).getY()-145,GOD_PLATFORM.getWidth(),GOD_PLATFORM.getHeight()));
      platforms.get(4).setDegreeRotation(2);
      //5
      platforms.add(new Platform(
            SECTION_W,platforms.get(4).getY()-75,GOD_PLATFORM.getWidth(),GOD_PLATFORM.getHeight()));
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
      System.out.println("peach"+platforms.get(8));

      for (int i = 0; i<platforms.size(); i++){
         platforms.get(i).setColor(GOD_PLATFORM.getColor());
      }
   }
   
   @Override
   public void initLadders(){
      int ladderWidth = 25;
      ladders.add(new Ladder(
            SECTION_W*5,ladderWidth,15,Ladder.BOUND_UP,platforms.get(2).getSection(5)));
      ladders.add(new Ladder(
            SECTION_W*5,ladderWidth,30,Ladder.BOUND_DOWN,platforms.get(0)));
      ladders.add(new Ladder(
            //section_w*12
            platforms.get(1).getSection(6).getX(),30,
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
      //endless ladders (17 and 18 respectively)
      ladders.add(new Ladder(
            platforms.get(8).getX(),ladderWidth,150,Ladder.BOUND_DOWN,platforms.get(6),true));
      ladders.add(new Ladder(
            SECTION_W*4,ladderWidth,150,Ladder.BOUND_DOWN,platforms.get(6)));
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
   }
  
   public void initBarrel(){
      barrels.add(new Barrel(
            10,GOD_BARREL.getY(),GOD_BARREL.getWidth(), 0, Barrel.DIR_NULL));
      barrels.get(barrels.size()-1).skin(GOD_BARREL.getRollingSheet(), GOD_BARREL.getDownLadderSheet());

   }
 
   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHints(hints);
      if (pacer > 0) {
         for (Hammer h : hammers)
            h.draw(g2);
         g2.drawImage(
               barrelPile, 5, platforms.get(6).getY()- (int)(SECTION_W*2), SECTION_W*2, (int)(SECTION_W*2), null);
         boardImage.draw(g2);
         boss.draw(g2);
         player.draw(g2);
         if (boss.getCurrentSheetIndex() != InGameNPC.CLIMB)
            g2.drawImage(princess, princessBounds.x, princessBounds.y, 
                  princessBounds.width, princessBounds.height, null);
         for (Barrel b : barrels)
            b.draw(g2);
         oilBarrel.draw(g2);
         if (player.isUsingHammer()) {
            g2.setColor(Color.RED);
            g2.fillRect(500, 30, (Sprite.TICKS_USING_HAMMER-player.getTicksWithHammer())/10, 15);
         }
      }
      if (pause)
         g2.drawString("pause", 0, 25);
   }
   
   public void shake(){
      for (int i = 1; i<6; i++){
         platforms.get(i).rotateAndBreakWithStep(3,SECTION_W);
      }
      platforms.get(7).rotateAndBreakWithStep(3,SECTION_W);
      System.out.println(platforms.get(4));
      initLadders();
      initHammers();
      boardImage.repaint();
   }
   
//   public void barrelHitByHammer(int index){
//      Barrel b = barrels.get(index);
//      long startTime = System.currentTimeMillis();
//      while (System.currentTimeMillis()-startTime <= Barrel.REMOVAL_TIME){
//         //flash a lil
//            b.setColor(Color.BLUE);
//         repaint();
//         System.out.println("repaint");
//         try {
//            Thread.sleep(300);
//         } catch (InterruptedException e) {
//            e.printStackTrace();
//         }
//            b.setColor(Color.WHITE);
//         repaint();
//         System.out.println("repaint");
//      }
//      System.out.println("REMOVING BARREL");
//      barrels.remove(index);
//      addScore(300,true);
//   }
   
   public void addBarrel() {
      barrels.add(new Barrel(GOD_BARREL.getX(), GOD_BARREL.getY(),
            GOD_BARREL.getWidth(), GOD_BARREL.getSpeed(), Barrel.DIR_RIGHT));
      barrels.get(barrels.size()-1).setPlatforms(platforms);
      barrels.get(barrels.size()-1).setLadders(ladders);
      barrels.get(barrels.size()-1).skin(GOD_BARREL.getRollingSheet(), GOD_BARREL.getDownLadderSheet());
;
   }
   
   public void addAndRemoveBarrel(){
      if(pacer%(BARREL_ADD_TIME/4) == 0)
         boss.cycleSheet();
      if (pacer%BARREL_ADD_TIME == 0){
         addBarrel();
      }
      for (int i = barrels.size()-1; i>=0; i--){
         if (barrels.get(i).getY()>PREF_H){
            barrels.remove(i);
         }
         else if (barrels.get(i).isHitWithHammer()){
            barrelHitByHammer(i);
         }
      }
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
      if (player.currentPlatform()!=null && player.currentPlatform().equals(platforms.get(8))){
         score+=bonus;
         endLevel();
         levelComplete = true;
      }
      if (player.isDead()){
         deathSequence();
      }
      pacer++;
   }
   
   //FIXME death sequence 
            //use for loop NO use other thing embedded if, keep timer running.
//   public void deathSequence(){
//      super.deathSequence();
//   }
   
   public void endLevel(){
      super.endLevel();
      player.setX(ladders.get(16).getX());
      player.setDy(0);
      player.setDirection(Sprite.LEFT);
      player.setCurrentSheetIndex(Sprite.STILL);
      if (songFlag)
         boss.endOfLvlOne();
      if (boss.getY()<=SECTION_W){
         done = true;
      }
   }
   
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }
   
//   private static void createAndShowGUI() {
//      JFrame frame = new JFrame("Donkey Kong");
//      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      frame.getContentPane().add(new LevelOne());
//      frame.pack();
//      frame.setLocationRelativeTo(null);
//      frame.setVisible(true);   
//   }
//   public static void main(String[] args) {
//      SwingUtilities.invokeLater(new Runnable() {
//         public void run() {
//            createAndShowGUI();
//         }
//      });
//   }

   
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
   
   @Override
   public void actionPerformed(ActionEvent e) {
      update();
      repaint();
      frameRate("lvlOne");
   }

}
