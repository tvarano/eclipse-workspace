import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

//Thomas Varano
//[Program Descripion]
//Mar 13, 2017

public class InGameNPC extends Item
{
   public static final int NORMAL = 0, CLIMB = 1, ARR_SIZE = 2; 
   private boolean left, right, up, down, jumping, trigger;
   private ArrayList<Ladder> ladders;
   private int currentSheetIndex;
   private ArrayList<BufferedImage[]> sheets;
   private Animation animator = new Animation();
   private int level;
   
   public InGameNPC(double x, double y, double width, double height){
      super(x,y,width,height);
      sheets = new ArrayList<BufferedImage[]>();
      BufferedImage[] defaultSkin = {LevelOne.DEFAULT_SKIN};
      for (int i = 0; i < ARR_SIZE; i++)
         sheets.add(defaultSkin);
      currentSheetIndex = 0;
      animator.setFrames(sheets.get(currentSheetIndex));

   }
   
   public void draw(Graphics2D g2){
      if (paint)
         g2.drawImage(animator.getImage(), (int)x, (int)y, (int)width, (int)height, null);
      else
         drawBounds(g2);
   }
   
   public void cycleSheet(){
      animator.manualShift();
   }
   
   public void endOfLvlOne(){
      x = LevelOne.SECTION_W*3;
      y-=0.5;
      currentSheetIndex = CLIMB;
   }
   
   public void update(){
      animator.setFrames(sheets.get(currentSheetIndex));
      x+=dx;
      y+=dy;
      if (level == 1)
         if (trigger)
            endOfLvlOne();
   }
   public boolean isLeft() {
      return left;
   }
   public void setLeft(boolean left) {
      this.left = left;
   }
   public boolean isRight() {
      return right;
   }
   public void setRight(boolean right) {
      this.right = right;
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
   public boolean isJumping() {
      return jumping;
   }
   public void setJumping(boolean jumping) {
      this.jumping = jumping;
   }
   public boolean isTrigger() {
      return trigger;
   }
   public void setTrigger(boolean trigger) {
      this.trigger = trigger;
   }
   public ArrayList<Ladder> getLadders() {
      return ladders;
   }
   public void setLadders(ArrayList<Ladder> ladders) {
      this.ladders = ladders;
   }
   public int getCurrentSheetIndex() {
      return currentSheetIndex;
   }
   public void setCurrentSheetIndex(int currentSheetIndex) {
      this.currentSheetIndex = currentSheetIndex;
   }
   public ArrayList<BufferedImage[]> getSheets() {
      return sheets;
   }
   public void setSheets(ArrayList<BufferedImage[]> sheets) {
      System.out.println("sheetsSetTo: "+sheets);
      BufferedImage[] defaultSkin = {LevelOne.DEFAULT_SKIN};
      System.out.println("BUT: "+defaultSkin);
      while (sheets.size()<ARR_SIZE){
         sheets.add(defaultSkin);
         System.out.println("added a sheet InGameNPC");
      }
      while (sheets.size() > ARR_SIZE) {
         sheets.remove(sheets.size()-1);
         System.out.println("removed sheet InGameNPC");
      }
      this.sheets = sheets;
      paint = true;
   }
   public Animation getAnimator() {
      return animator;
   }
}
