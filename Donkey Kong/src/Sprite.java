import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

//Thomas Varano
//[Program Descripion]
//Mar 1, 2017

public class Sprite extends Item
{
   public static final int STILL = 0, WALK = 1, JUMP = 2, CLIMB = 3,
         HAMMER_S = 4, HAMMER_W = 5, SPECIAL_1 = 6, SPECIAL_2 = 7, ARR_SIZE = 8;
   public static final int RIGHT = 0, LEFT = 1;
   public static final int TICKS_USING_HAMMER = 1500;
   
   private double jumpHeight, standingHeight;
   private double maxSpeed,gravity, jumpForce, resistance;
   private boolean jumping, falling, usingHammer, climbing,
                  up, down, right, left, moveable, dead, fileNotWorking, paint;
   private ArrayList<Ladder> ladders = new ArrayList<Ladder>();
   private ArrayList<PlatformBreak> breaks = new ArrayList<PlatformBreak>();
   private ArrayList<Barrel> barrels = new ArrayList<Barrel>();
   private ArrayList<Item> obstacles = new ArrayList<Item>();
   private ArrayList<BufferedImage[]> sheets;
   private Ladder currentLadder;
   private Platform currentPlatform;
   private int lives, currentSheetIndex, direction, ticksWithHammer;
   private Animation animator;
   private BufferedImage mainSheet;
   
   public Sprite(double x, double y, double width, double height, double maxSpeed, double gravity, double jumpForce){
      super(x,y,width,height);
      standingHeight = height;
      jumpHeight = height*0.9;
      this.maxSpeed = maxSpeed;
      this.gravity = gravity;
      this.jumpForce = -jumpForce;
      lives = 3;
      falling = true;
      fileNotWorking = false;
      animator = new Animation(100);
      direction = RIGHT;  
      sheets = new ArrayList<BufferedImage[]>(ARR_SIZE);
      BufferedImage[] defaultSkin = {LevelOne.DEFAULT_SKIN};
      for (int i = 0; i < ARR_SIZE; i++)
         sheets.add(defaultSkin);
      try{
         mainSheet = ImageIO.read(ClassLoader.getSystemResource("anotherSheet.png"));
      } catch(IOException e){
         fileNotWorking = true;
         System.err.println("SPRITE SHEET UNREAD");
      }
      initSheets();
   } 
   public Sprite(int x, int y, int width, int height){
      this(x,y,width,height,4,LevelOne.GRAVITY,10);
   }
   public Sprite(){
      this(0,0,0,0);
   }
  
   private void initSheets(){
      for (int i = 0; i<sheets.size(); i++)
         System.out.println(i);
      if (!fileNotWorking){
         sheets.set(STILL, Animation.extractSpriteArray(mainSheet, 1, 0, 32, 64));
         sheets.set(WALK, Animation.extractSpriteArray(mainSheet, 3, 64, 32, 64));
         sheets.set(JUMP, Animation.extractSpriteArray(mainSheet, 1, 128, 32, 62));
         sheets.set(CLIMB, Animation.extractSpriteArray(mainSheet, 5, 189, 32, 62));
         sheets.set(HAMMER_S, Animation.extractSpriteArray(mainSheet, 4, 250, 64, 64));
         sheets.set(HAMMER_W, Animation.extractSpriteArray(mainSheet, 4, 250, 64, 64));
         sheets.set(SPECIAL_1,Animation.extractSpriteArray(mainSheet,4,32,16,30));
         sheets.set(SPECIAL_2,Animation.extractSpriteArray(mainSheet,1,62,16,30));
      }
      paint = !fileNotWorking;
   }
   
   
   
   public void update(){
      animator.setFrames(sheets.get(currentSheetIndex));
      if (platforms.isEmpty())
         System.err.println("SPRITE platform array is empty");
      if(!climbing){
         lateralMovement();
      }
      if (!climbing)
         verticalMovement();
      ladderMovement();
      if (itemIntersection()){
         dead = true;
      }
      if (usingHammer){
         useHammer();
      }
      animator.update();
   }
   
   //TODO this is possibly in the wrong place
   private void useHammer(){
      ticksWithHammer++;
      for (int i = 0; i<barrels.size(); i++){
         if (barrels.get(i).intersects(getHammerReach()))
            barrels.get(i).setHitWithHammer(true);
      }
      for (int i = 0; i < obstacles.size(); i++){
         if (obstacles.get(i) instanceof MiscObject)
            if (!((MiscObject) obstacles.get(i)).isPermanent() &&
                  obstacles.get(i).intersects(getHammerReach()))
               obstacles.get(i).setHitWithHammer(true);
      }
      if (ticksWithHammer >= TICKS_USING_HAMMER){
         ticksWithHammer = 0;
         usingHammer = false;
      }
   }
   
   private void ladderMovement(){
      if (ladderIntersection() && !usingHammer){
         if (up){
            animator.resume();
            currentSheetIndex = CLIMB;
            animator.setRunBackwards(false);
            y-=0.4;
            climbing = true;
         }
         else if (down){
            animator.resume();
            currentSheetIndex = CLIMB;
            animator.setRunBackwards(true);
            y+=0.4;
            climbing = true;
            if (platformIntersection() && currentPlatform == currentLadder.getLowerBound()){
               System.out.println("release");
               climbing = false;
            }
         }

         
         else if (climbing){
            right = false;
            left = false;
            jumping = false;
            animator.stop();
         }
      }
      else{
         climbing = false;
         animator.resume();
         animator.setRunBackwards(false);
      }
   }

   public boolean ladderIntersection(){
      for (Ladder currentLadder : ladders){
         if (currentLadder.isGrabbed(getFeet())){
            this.currentLadder = currentLadder;
            return true;
         }
      }
      currentLadder = null;
      return false;
   }
   
   public boolean itemIntersection(){
      for (Barrel b : barrels){
         if (b.intersects(getBounds()))
            return true;
      }
      for (Item i : obstacles){
         if (i.intersects(getBounds()))
            return true;
      }
      return false;
   }
   
   @Override
   public boolean platformIntersection(){
      for (int i = 0; i<platforms.size(); i++){
         CollidedPlatform currentPlatformIntersection = platforms.get(i).getIntersection(getFeet());
         if (currentPlatformIntersection.isCollided() && dy >= 0){
            currentPlatform = currentPlatformIntersection.getPlatformCollided();
            return true;
         }
      }
      return false;
   }
  
   public boolean jumpedOverItem(){
      if (falling){
         for(Barrel b : barrels){
            if (b.getCenterX() > x-3 && b.getCenterX() < x+3)
               if (y+width-b.getY()<10 && y+width-b.getY()>0){
                  System.out.println("jumpover");
                  return true;
               }
         }
         for(Item o : obstacles){
            if (o.getCenterX() > x-1 && o.getCenterX() < x+1)
               if (y+width-o.getY()<8 && getBounds().getMaxY()-o.getY()>0){
                  System.out.println("jumpover");
                  return true;
               }
         }
      }
      return false;
   }
   
   private void verticalMovement(){
      if (jumping && platformIntersection()){
         if (climbing || usingHammer|| !platformIntersection()){
            jumping = false;
            dy = 0;
         }
         else {
            currentSheetIndex = JUMP;
            falling = true;
            height = jumpHeight;
            y-=1;
            dy = jumpForce;
            moveable = false;
            jumping = false;
         }
      }
      else 
         jumping = false;
      if (platformIntersection()){
         if (dy>2)
            setDead(true);
         dy = 0;
         falling = false;
         height = standingHeight;
         y = currentPlatform.getY()-height+1;
         moveable = true;
      }
      else{
         dy+=gravity;
      }
      y+=dy;
   }
   
   private void lateralMovement(){
      if(moveable){
         if (platformIntersection())
            resistance = currentPlatform.getDx();
         if (right){
            direction = RIGHT;
            if (usingHammer)
               currentSheetIndex = HAMMER_W;
            else
               currentSheetIndex = WALK;
            if(x+width<LevelOne.PREF_W)
               dx = maxSpeed+resistance;
            if ((breakIntersection() && platformIntersection()) && currentBreak().isRightOf(this)){
               dx = 0;
            }
         }
         else if (left){
            direction = LEFT;
            if (usingHammer)
               currentSheetIndex = HAMMER_W;
            else
               currentSheetIndex = WALK;
            if(x>0)
               dx = -maxSpeed+resistance;
            if ((breakIntersection() && platformIntersection()) && currentBreak().isLeftOf(this))
               dx = 0;
         }
         else{
            if (platformIntersection()){
               dx = resistance;
            }
            if (dx == resistance && platformIntersection()){
               if (usingHammer)
                  currentSheetIndex = HAMMER_S;
               else
                  currentSheetIndex = STILL;
               }       
         }
      }
      if (x<3 && dx<0)
         dx = 0;
      if (x+width>KongFrame.PREF_W-3 && dx>0)
         dx = 0;
      x+=dx;
   }
   
   public ArrayList<PlatformBreak> getBreaks() {
      return breaks;
   }
   public void setBreaks(ArrayList<PlatformBreak> breaks) {
      this.breaks = breaks;
   }
   public boolean breakIntersection(){
      for (PlatformBreak b : breaks){
         if (b.intersects(getFeet()))
            return true;
      }
      return false;
   }
   
   public PlatformBreak currentBreak(){
      for (int i = 0; i < breaks.size(); i++){
         if (breaks.get(i).intersects(getFeet()))
            return breaks.get(i);
      }
      return null;
   }
   
   public void drawBounds(Graphics2D g2){
      Color previous = g2.getColor();
      g2.setColor(Color.RED);
      g2.fill(getBounds());
      g2.setColor(Color.GREEN);
      g2.fill(getFeet());
      g2.setColor(previous);
   }
   
   public void draw(Graphics2D g2){
      double x = this.x; double y = this.y;
      double width = this.width; double height = this.height;
//      if (isUsingHammer()){
//         Color previous = g2.getColor();
//         g2.setColor(new Color(255,255,255,100));
//         g2.fill(getHammerReach());
//         g2.setColor(previous);
//      }
      if (sheets.isEmpty() || !paint){
        drawBounds(g2);
      }
      else{
         if (isUsingHammer()){
            width = getHammerReach().getWidth();
            height = getHammerReach().getHeight();
            x = getHammerReach().getX();
            y = getHammerReach().getY();
         }   
         if (direction == RIGHT)
            g2.drawImage(animator.getImage(), (int)x, (int)y, (int)width, (int)height, null);
         else
            g2.drawImage(animator.getImage(), (int)(x+width), (int)y, (int)-width, (int)height, null);
      }
   }
   
   public Rectangle getHammerReach(){
      if (direction == RIGHT){
         return new Rectangle((int)x,(int)(y-height),(int)(width*2),(int)(height*2));
      }
      else if (direction == LEFT){
         return new Rectangle(
               (int)(x-width),(int)(y-height),(int)(width*2),(int)(height*2));
      }
      return getBounds();
   }
   
   public Rectangle getFeet(){
      return new Rectangle((int)x,(int)(y+standingHeight-4),(int)width,4);
   }
   
   public int getLives() {
      return lives;
   }
   public void setLives(int lives) {
      this.lives = lives;
   }
   public double getMaxSpeed() {
      return maxSpeed;
   }
   public void setMaxSpeed(double maxSpeed) {
      this.maxSpeed = maxSpeed;
   }
   public double getGravity() {
      return gravity;
   }
   public void setGravity(double gravity) {
      this.gravity = gravity;
   }
   public boolean isJumping() {
      return jumping;
   }
   public void setJumping(boolean jumping) {
      this.jumping = jumping;
   }
   public boolean isFalling() {
      return falling;
   }
   public void setFalling(boolean falling) {
      this.falling = falling;
   }
   public boolean isUsingHammer() {
      return usingHammer;
   }
   public void setUsingHammer(boolean usingHammer) {
      this.usingHammer = usingHammer;
   }
   public boolean isClimbing() {
      return climbing;
   }
   public void setClimbing(boolean climbing) {
      this.climbing = climbing;
   }
   public boolean isRight() {
      return right;
   }
   public void setRight(boolean right) {
      this.right = right;
   }
   public boolean isLeft() {
      return left;
   }
   public void setLeft(boolean left) {
      this.left = left;
   }
   public double getJumpForce() {
      return jumpForce;
   }
   public void setJumpForce(double jumpForce) {
      this.jumpForce = jumpForce;
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
   public ArrayList<Ladder> getLadders() {
      return ladders;
   }
   public void setLadders(ArrayList<Ladder> ladders) {
      this.ladders = ladders;
   }
   public ArrayList<Barrel> getBarrels() {
      return barrels;
   }
   public void setBarrels(ArrayList<Barrel> barrels) {
      this.barrels = barrels;
   }
   public ArrayList<BufferedImage[]> getSheets() {
      return sheets;
   }
   public void setSheets(ArrayList<BufferedImage[]> sheets) {
      this.sheets = sheets;
   }
   public void addSheet(BufferedImage[] sheet){
      sheets.add(sheet);
   }
   public void removeSheet(int index){
      sheets.remove(index);
   }
   public boolean isMoveable() {
      return moveable;
   }
   public void setMoveable(boolean moveable) {
      this.moveable = moveable;
   }
   public boolean isDead() {
      return dead;
   }
   public void setDead(boolean dead) {
      this.dead = dead;
   }
   public int getCurrentSheetIndex() {
      return currentSheetIndex;
   }
   public void setCurrentSheetIndex(int currentSheetIndex) {
      this.currentSheetIndex = currentSheetIndex;
   }
   public Ladder getCurrentLadder() {
      return currentLadder;
   }
   public int getDirection(){
      return direction;
   }
   public void setDirection(int direction){
      this.direction = direction;
   }
   public Animation getAnimator(){
      return animator;
   }
   public double getStandingHeight() {
      return standingHeight;
   }
   public void setStandingHeight(double standingHeight) {
      this.standingHeight = standingHeight;
   }
   public double getJumpHeight() {
      return jumpHeight;
   }
   public void setJumpHeight(double jumpHeight) {
      this.jumpHeight = jumpHeight;
   }
   public boolean isPaint() {
      return paint;
   }
   public void setPaint(boolean paint) {
      this.paint = paint;
   }
   public ArrayList<Item> getObstacles() {
      return obstacles;
   }
   public void setObstacles(ArrayList<Item> obstacles) {
      this.obstacles = obstacles;
   }
   public BufferedImage getMainSheet() {
      return mainSheet;
   }
   public void setMainSheet(BufferedImage mainSheet) {
      this.mainSheet = mainSheet;
   }
   public boolean isFileNotWorking() {
      return fileNotWorking;
   }
   public int getTicksWithHammer() {
      return ticksWithHammer;
   }
   public double getResistance(){
      return resistance;
   }
   public void setResistance(double resistance){
      this.resistance = resistance;
   }
}
