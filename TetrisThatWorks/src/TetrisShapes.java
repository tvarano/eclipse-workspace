import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

//Thomas Varano
//Larger blocks that are actually used
//Dec 26, 2016

/**
 * TetrisShapes do the majority of the work and calculations in the game {@link Tetris}. 
 * {@code movement}, {@code Color}, and user input are all used here to determine what to do and how to execute.
 * Features of this specific variant of Tetris Shapes include an ability to speed up, drop instantly
 * (sort of), hover and allow for a small amount of user input before becoming locked.
 * <p>
 * The TetrisShapes are made of smaller {@link TetrisBlock}s held in an {@link ArrayList}.
 *  Each block and the wh
 * </p>
 * @author Thomas Varano 
 */
public class TetrisShapes
{
   private int c, r, blockAmount, blockSize, resetTime, maxRotation;
   public int position;
   public Location location;
   private long pacer;
   private boolean left, right, speedUp, rotate, collided, still, dropped,
         moveableRight, moveableLeft, moveableDown;
   private ArrayList<TetrisBlock> blocks;
   private String label;
   private Color color;
   private Location[][] grid;
   
   /**
    * The main class of shapes in Tetris. Created from an 
    * 
    * @param r
    *           the row in which the main y is on the specified <code>grid</code>. Each block bases its r off
    *           of this variable.
    * @param c
    *           the column in which the main x is on the specified <code>grid</code>. Each block bases its c off
    *           of this variable.
    * @param blockAmount
    *           the amount of TetrisBlocks needed to make the shape
    */
   public TetrisShapes(int r, int c, int blockAmount) {
      this.r = r;
      this.c = c;
      setBlocks(new ArrayList<TetrisBlock>());
      left = right = speedUp = false;
      setLabel("noLabel");
      this.blockAmount = blockAmount;
      position = 0;
      resetTime = 1;
      color = Color.WHITE;
      moveableDown = moveableLeft = moveableRight = true;
      grid = null;
      location = new Location(r,c);
      still = collided = false;
      maxRotation = 4;
   }
   /**
    * Initializes the array of {@link TetrisBlock}s to work in cohesion as a
    * shape. This object will not function without running this method.</br>
    * Though not in the constructor, these parameters are necessary for running this method.
    * 
    * @param grid
    *           the 2D array each TetrisShape is based on. not configurable with
    *           X and Y, this must be configured in a 2D array
    * @param color
    *           defaults white
    * @param blockSize
    *           the width and height of each block, assuming they are squares. 
    * @param resetTime
    *           finds how many ticks to wait in a <code>Timer</code> until another movement down is
    *           fired. Defaults to 1.
    * 
    */
   public void init() {
      for (int i = 0; i < blockAmount; i++) {
         blocks.add(new TetrisBlock(r, c, blockSize));
      }
      for (int i = 0; i < blocks.size(); i++) {
         blocks.get(i).setColor(color);
         blocks.get(i).setBlockSize(blockSize);
         blocks.get(i).setGrid(grid);
      }
   }

   /**
    * used when the block is not active, but is waiting to be used and is shown
    * in the "next" field
    * 
    * @param r the row in which the block should be kept
    * @param c the column
    */
   public void still(int r, int c, Location[][] grid, Graphics2D g2) {
      setStill(true);
      setR(r);
      setC(c);
      setGrid(grid);
      for (int i = 0; i < blocks.size(); i++) {
         blocks.get(i).setGrid(grid);
         blocks.get(i).setC(c + blocks.get(i).getCFromCenter());
         blocks.get(i).setR(r + blocks.get(i).getRFromCenter());
         grid[blocks.get(i).getR()][blocks.get(i).getC()].setColor(color);
         grid[blocks.get(i).getR()][blocks.get(i).getC()].setFull(true);
      }
   }

   /**
    * where everything happens basically
    */
   public void update() {
      pacer++;
      if (still){
         stillToUpdate();
      }
      
      else {
         for (int i = 0; i < blocks.size(); i++) {
               blocks.get(i).update();
         }
         
         checkMovement();
         rotation();
         move();
      }
   }
 
   public void collide() {
      dropped = false;
      for (int i = 0; i < blocks.size(); i++) {
         if (!blocks.get(i).canMoveDown()) {
            moveableDown = false;
            break;
         } else {
            if (i == blocks.size() - 1) {
               moveableDown = true;
               System.out.println("MOVEDOWNMOEDOWNMOVEOWN");
            } else
               continue;
         }
      }
        for (int i = 0; i<blocks.size(); i++){
         if (!isMoveableDown()) {
            if ((pacer + 1) % resetTime == 0) {
               Tetris.getGrid()[blocks.get(i).getR()][blocks.get(i).getC()]
                     .setFull(true);
               Tetris.getGrid()[blocks.get(i).getR()][blocks.get(i).getC()]
                     .setColor(color);
               collided = true;
            }
         }
      }
   }
   
   public boolean isRotatable(){
      for (int i = 0; i<blocks.size(); i++){
         if(maxRotation>0){
            if (position == 0) {
             blocks.get(i).setRotatable(!blocks.get(i).checkFull(
                   r + blocks.get(i).getCFromCenter(),
                   c - blocks.get(i).getRFromCenter()));
            } else if (position == 1) {
             blocks.get(i).setRotatable(!blocks.get(i).checkFull(
                   r - blocks.get(i).getRFromCenter(),
                   c - blocks.get(i).getCFromCenter()));

            } else if (position == 2) {
             blocks.get(i).setRotatable(!blocks.get(i).checkFull(
                   r - blocks.get(i).getCFromCenter(),
                   c + blocks.get(i).getRFromCenter()));

            }else if (position == 3) {
               blocks.get(i).setRotatable(!blocks.get(i).checkFull(
                     r + blocks.get(i).getRFromCenter(),
                     c + blocks.get(i).getCFromCenter()));
            }
         }
      }
      for (int i = 0; i<blocks.size(); i++){
         if (!blocks.get(i).isRotatable()) {
            return false;
         }
      }
      return true;
   }
   
   public void checkMovement(){
      for (int i = 0; i < blocks.size(); i++) {
         if(!blocks.get(i).canMoveDown()){
            moveableDown = false;
         }
      }
      for (int i = 0; i<blocks.size(); i++){
         if (!blocks.get(i).canMoveRight()) {
            moveableRight = false;
            break;
         } else {
            if (i == blocks.size() - 1) 
               moveableRight = true;
            else
               continue;
         }
      }
      for (int i = 0; i<blocks.size(); i++){
         if (!blocks.get(i).canMoveLeft()) {
            moveableLeft = false;
            break;
         } else {
            if (i == blocks.size() - 1)
               moveableLeft = true;
            else
               continue;
         }
      }
   }
   
   public void move() {
      int resetter = resetTime;
      if (speedUp) {
         resetter = resetTime / 5;
      } else if (dropped) {
         resetter = 2;
      } else {
         resetter = resetTime;
      }
      
      if (pacer % resetter == 0 && moveableDown) {
         setR(getR() + 1);
      }
      if (right && moveableRight) {
         System.out.println("right");
         setC(getC() + 1);
         right = false;
      }
      if (left && moveableLeft) {
         System.out.println("left");
         setC(getC() - 1);
         left = false;
      }
   }
   
   public void removeBlock(int i){
      blocks.remove(i);
   }
   
   public void stillToUpdate(){
      setR(4);
      setC(7);
      setStill(false);
      for (int i = 0; i<blocks.size(); i++){
         grid[blocks.get(i).getR()][blocks.get(i).getC()].setColor(Color.WHITE);
         grid[blocks.get(i).getR()][blocks.get(i).getC()].setFull(false);
      }
      setGrid(Tetris.getGrid());
      for (int i = 0; i<blocks.size(); i++){
         blocks.get(i).setGrid(grid);
      }
   }

   private void rotation() {
      if (rotate && isRotatable() && (maxRotation>0)) {
         position++;
         setRotate(false);
      }
      else if (rotate && !isRotatable() || !(maxRotation>0))
         setRotate(false);
      if (position == maxRotation) {
         position = 0;
      }
      for (int i = 0; i < blocks.size(); i++) {
         if (position == 0) {
            blocks.get(i).setR(r + blocks.get(i).getRFromCenter());
            blocks.get(i).setC(c + blocks.get(i).getCFromCenter());
         }
         if (position == 1) {
            blocks.get(i).setR(r + blocks.get(i).getCFromCenter());
            blocks.get(i).setC(c - blocks.get(i).getRFromCenter());
         }
         if (position == 2) {
            blocks.get(i).setR(r - blocks.get(i).getRFromCenter());
            blocks.get(i).setC(c - blocks.get(i).getCFromCenter());
         }
         if (position == 3) {
            blocks.get(i).setR(r - blocks.get(i).getCFromCenter());
            blocks.get(i).setC(c + blocks.get(i).getRFromCenter());
         }
      }
   }   
   
   public void draw(Graphics2D g2) {
         for (int i = 0; i < blocks.size(); i++) {
            blocks.get(i).draw(g2);
         }
   }
      
   public String toString() {
      return this.getClass().getName() + "[" + label + "(" + r + "," + c
            + "),size=" + blockSize + "p=" + position + "]";
   }

   public boolean labelEquals(String label){
      return this.label.equals(label);
   }
   
   /**
    * @return the row in which the shape is based in a 2D array
    */
   public int getR() {
      return r;
   }
   public void setR(int r) {
      this.r = r;
   }
   /**
    * @return the column in which the shape is based in a 2D array
    */
   public int getC() {
      return c;
   }
   public void setC(int c) {
      this.c = c;
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
   public boolean isSpeedUp() {
      return speedUp;
   }
   public void setSpeedUp(boolean speedUp) {
      this.speedUp = speedUp;
   }
   public String getLabel() {
      return label;
   }
   public void setLabel(String label) {
      this.label = label;
   }
   public ArrayList<TetrisBlock> getBlocks() {
      return blocks;
   }
   public void setBlocks(ArrayList<TetrisBlock> blocks) {
      this.blocks = blocks;
   }
   public Color getColor() {
      return color;
   }
   public void setColor(Color color) {
      this.color = color;
   }
   public int getBlockSize() {
      return blockSize;
   }
   public void setBlockSize(int blockSize) {
      this.blockSize = blockSize;
   }
   public int getPosition() {
      return position;
   }
   public void setPosition(int i) {
      this.position = i;
   }
   public int getBlockAmount() {
      return blockAmount;
   }

   public void setBlockAmount(int blockAmount) {
      this.blockAmount = blockAmount;
   }

   public boolean isCollided() {
      return collided;
   }

   public void setCollided(boolean collided) {
      this.collided = collided;
   }

   public int getResetTime() {
      return resetTime;
   }

   public void setResetTime(int resetTime) {
      this.resetTime = resetTime;
   }

   public boolean isRotate() {
      return rotate;
   }

   public void setRotate(boolean rotate) {
      this.rotate = rotate;
   }

   public Location[][] getGrid() {
      return grid;
   }
   
   public String getGridToString(){
      return "[rows= "+grid.length+" columns = "+grid[0].length+"]";
   }

   public void setGrid(Location[][] grid) {
      this.grid = grid;
   }
   public Location getLocation() {
      if (location == null) {
         return new Location(r, c);
      } else
         return location;
   }
   public void setLocation(Location l) {
      this.location = l;
   }
   public void setLocation(int r, int c) {
      this.location = grid[r][c];
   }

   public boolean isMoveableRight() {
      return moveableRight;
   }

   public void setMoveableRight(boolean moveableRight) {
      this.moveableRight = moveableRight;
   }

   public boolean isMoveableLeft() {
      return moveableLeft;
   }

   public void setMoveableLeft(boolean moveableLeft) {
      this.moveableLeft = moveableLeft;
   }

   public boolean isMoveableDown() {
      return moveableDown;
   }

   public void setMoveableDown(boolean moveableDown) {
      this.moveableDown = moveableDown;
   }

   public boolean isStill() {
      return still;
   }

   public void setStill(boolean still) {
      this.still = still;
   }
   public int getMaxRotation() {
      return maxRotation;
   }
   public void setMaxRotation(int r) {
      this.maxRotation = r;
   }
   public boolean isDropped() {
      return dropped;
   }
   public void setDropped(boolean dropped) {
      this.dropped = dropped;
   }
}
