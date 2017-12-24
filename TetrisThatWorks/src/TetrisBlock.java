import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

//Thomas Varano
//Small, changeable blocks.
//Dec 26, 2016

/**
 * The smaller, modular blocks used in an {@code array} in {@link TetrisShapes}. 
 * Initialized in the other class, this class only needs to be accessed in initialization.
 * Usually all of its methods and checks are held by its parent {@code TetrisShape}
 * 
 * @author Thomas Varano
 */
public class TetrisBlock
{
   
   private int blockSize, rFromCenter, cFromCenter, r, c;
   private boolean rotatable;
   private Color color;
   private Location[][] grid;
   private Location location;
   /**
    * Constructs a single TetrisBlock on a 2D array of {@link Location} points instead of a proper x and y. 
    * Though {@code Locations} are used, a normal x and y pixel count can be used as long as it is initialized 
    * similarly in the parent. 
    * @param r
    *    
    * @param c
    * @param width
    */
   public TetrisBlock(int r, int c, int width){
      rFromCenter = 0;
      cFromCenter = 0;
      this.c = c;
      this.r = r;
      this.setColor(Color.WHITE);
      setGrid(Tetris.getGrid());
      System.out.println(r+""+c+grid);
      location = grid[r][c];
   }
   
   public void update(){
      setLocation(grid[r][c]);
   }
   
   public boolean canMoveDown(){
      return(!grid[r+1][c].isFull());
   }
   
   public boolean canMoveLeft(){
      return(!grid[r][c-1].isFull());

   }
   
   public boolean canMoveRight(){
      return (!grid[r][c+1].isFull());
   }
   
   public Rectangle getBounds(){
      return new Rectangle(location.getX(),location.getY(),blockSize,blockSize);
   }
   
   public boolean equals(TetrisBlock b){
      return (b.getR() == r && b.getC() == c && b.getBlockSize() == blockSize);
   }
   
   public boolean checkFull(int r, int c){
      return grid[r][c].isFull();
   }
   
   public void draw(Graphics2D g2){
      g2.setColor(getColor());
      g2.fill(getBounds());
      g2.setColor(Color.BLACK);
      g2.draw(getBounds());
   }
   
   public String toString(){
      return this.getClass().getName()+"[("+r+","+c+")("+rFromCenter+","+cFromCenter+")]";
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

   public int getRFromCenter() {
      return rFromCenter;
   }

   public void setRFromCenter(int rFromCenter) {
      this.rFromCenter = rFromCenter;
   }

   public int getCFromCenter() {
      return cFromCenter;
   }

   public void setCFromCenter(int cFromCenter) {
      this.cFromCenter = cFromCenter;
   }

   public Location[][] getGrid() {
      return grid;
   }

   public void setGrid(Location[][] grid) {
      this.grid = grid;
   }

   public Location getLocation() {
      return location;
   }

   public void setLocation(Location location) {
      this.location = location;
   }
   
   public void setLocation(int r, int c) {
      this.location = grid[r][c];
   }

   public int getR() {
      return r;
   }

   public void setR(int r) {
      this.r = r;
   }

   public int getC(){
      return c;
   }

   public void setC(int c) {
      this.c = c;
   }

   public boolean isRotatable() {
      return rotatable;
   }

   public void setRotatable(boolean rotatable) {
      this.rotatable = rotatable;
   }
}
