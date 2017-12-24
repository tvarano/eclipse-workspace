import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

//Thomas Varano
//[Program Descripion]
//Mar 1, 2017

public class Barrel extends Item
{
   public static final int DIR_RIGHT = 1;
   public static final int DIR_LEFT = 2;
   public static final int DIR_NULL = 0;
   public static final int REMOVAL_TIME = 600;

   private double speed, gravity;
   private boolean drop, droppingOnLadder;
   private ArrayList<Ladder> ladders = new ArrayList<Ladder>();
   private double currentSlope;
   private BufferedImage[] rolling, downLadder;
   private Animation animator;
   
   public Barrel(double x, double y, double diameter, double speed, int initialDirection){
      super(x,y,diameter,diameter);
      this.speed = speed;
      gravity = 0.25;
      animator = new Animation(100);
      if(initialDirection == DIR_LEFT)
         dx = -speed;
      else if (initialDirection == DIR_RIGHT)
         dx = speed;
      else if (initialDirection == DIR_NULL)
         drop = true;
      else
         throw new NullPointerException("direction not valid");
      color = Color.WHITE;
      rolling = downLadder = new BufferedImage[1];
      rolling[0] = downLadder[0] = LevelOne.DEFAULT_SKIN;
      paint = true;
      animator.setFrames(rolling);
   }
   
   public void skin(BufferedImage[] rollingSheet, BufferedImage[] downLadder) {
      this.rolling = rollingSheet;
      this.downLadder = downLadder;
      paint = true;
   }
   
   public void skin(BufferedImage sheet){
      setRollingSheet(Animation.extractSpriteArray(sheet, 4, 193, 12, 12));
      setDownLadderSheet(Animation.extractSpriteArray(sheet, 1, 205, 16, 10));
      paint = true;
   }
   
   private Ladder currentLadder(){
      for (Ladder current : ladders){
         if (current.intersects(getBounds())){
            return current;
         }
      }
      return null;
   } 
   
   private boolean ladderIntersection(){
      for (Ladder current : ladders){
         if (current.intersects(getBounds())){
            return true;
         }
      }
      return false;
   }
   
   public void dropLadder(){
      animator.setFrames(downLadder);
      if (y<currentLadder().getY()+currentLadder().getUpperBound().getHeight()+5){
         droppingOnLadder = true;
         dx = 0;
         dy = speed;
      }
      else 
         droppingOnLadder = false;
   }
  
   private void roll(){
      animator.setFrames(rolling);
      if (platformIntersection()){
         if (currentSlope<0){
            animator.setRunBackwards(false);
            dx = -speed;
         }
         else if (currentSlope>0){
            animator.setRunBackwards(true);
            dx = speed;
         }
      }
      x+=dx;
   }
   
   private boolean dropOnLadder(){
      int possibilities = 100;
      if (!droppingOnLadder){
         if (x >= currentLadder().getCenterX()- 3 && x<= currentLadder().getCenterX()+3)
         if (currentLadder().getPosition() == Ladder.BOUND_NEUTRAL && currentLadder().getY()>y){
               possibilities = (int)(Math.random()*25);
            if (possibilities<9){
               return true;
            }
         }
         return false;
      }
      return droppingOnLadder;
   }
   
   public void update(){
      animator.update();
      if (currentPlatform()!=null)
         currentSlope = currentPlatform().getDegreeRotation();
      else 
         currentSlope = 0;
      if (drop){
         y+=2;
         dy = 0;
      }
      else if (ladderIntersection() && dropOnLadder()){
         dropLadder();
      }
      else{
         roll();
      }
      if (platformIntersection()&&!droppingOnLadder){
         y = currentPlatform().getY()-height;
         dy = 0;
      }
      else if (!droppingOnLadder)
         dy+=gravity;
      y+=dy;     
   }
   
   @Override
   public void draw(Graphics2D g2) {
      Shape bound = getBarrelBounds();
      if (paint) {
         g2.drawImage(animator.getImage(), (int)bound.getBounds().x, (int)bound.getBounds().y, 
               (int)bound.getBounds().getWidth(), (int)bound.getBounds().height, null);
      }
      else
         drawBounds(g2);
   }
   
   @Override
   public void drawBounds(Graphics2D g2){
      Color prevColor = g2.getColor();
      g2.setColor(color);
      g2.fill(getBarrelBounds());
      g2.setColor(prevColor);
   }
   
   public Barrel(){
      this(0,0,0,0,0);
   }

   public Shape getBarrelBounds(){
      if (!droppingOnLadder)
         return new Ellipse2D.Double(x,y,width,height);
      return new Rectangle((int)(x-20),(int)y,(int)(width+20),(int)height);
      
   }
   
   @Override
   public boolean intersects(Rectangle r){
      Rectangle bound = getBarrelBounds().getBounds();
      return r.intersects(bound);
   }
   
   public Point getCenter(){
      return new Point((int)(x+width/2),(int)(y+height/2));
   }
   
   public double getSpeed() {
      return speed;
   }

   public void setSpeed(double speed) {
      this.speed = speed;
   }

   public double getGravity() {
      return gravity;
   }

   public void setGravity(double gravity) {
      this.gravity = gravity;
   }

   public ArrayList<Ladder> getLadders() {
      return ladders;
   }

   public void setLadders(ArrayList<Ladder> ladders) {
      this.ladders = ladders;
   }
   
   public void setRollingSheet(BufferedImage[] rolling) {
      this.rolling = rolling;
   }
   
   public BufferedImage[] getRollingSheet() {
      return rolling;
   }
   
   public void setDownLadderSheet(BufferedImage[] downLadder) {
      this.downLadder = downLadder;
   }
   
   public BufferedImage[] getDownLadderSheet() {
      return downLadder;
   }
}