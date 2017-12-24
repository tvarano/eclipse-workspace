import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

//Thomas Varano
//[Program Descripion]
//Jan 11, 2017
/**
 * A simple x,y coordinate used for placing in a 2D array. Utilized in a grid, it can be painted as a rectangle
 * with its color and distanceInGrid parameters
 * @author Thomas Varano
 */
public class Location
{
   private int x, y, distanceInGrid;
   private boolean full;
   private Color color;
   
   /**
    * Constructs the location.
    * 
    * @param x
    *    the x coordinate in pixels on the screen
    * @param y
    *    the y coordinate in pixels on the screen
    */
   public Location(int x, int y){
      this.x = x;
      this.y = y;
      full = false;
      color = Color.WHITE;
      distanceInGrid = 40;
   }
   
   public void draw(Graphics2D g2){
      g2.setColor(color);
      g2.fill(getBounds());
      if(full){
         g2.setColor(Color.BLACK);
         g2.draw(getBounds());
      }
   }
   
   public boolean equals(Location l){
      return (l.getX() == x && l.getY() == y);
   }

   public boolean equalsWithFull(Location l){
      return (l.getX() == x && l.getY() == y && l.isFull() == full);
   }
   
   public String toString(){
      return this.getClass().getName()+"("+x+","+y+") full="+full;
   }
   
   public Rectangle getBounds(){
      return new Rectangle(x,y,distanceInGrid,distanceInGrid);
   }

   public int getX() {
      return x;
   }

   public void setX(int x) {
      this.x = x;
   }

   public int getY() {
      return y;
   }

   public void setY(int y) {
      this.y = y;
   }

   public boolean isFull() {
      return full;
   }

   public void setFull(boolean full) {
      this.full = full;
   }

   public Color getColor() {
      return color;
   }

   public void setColor(Color color) {
      this.color = color;
   }

   public int getDistanceInGrid() {
      return distanceInGrid;
   }

   public void setDistanceInGrid(int distanceInGrid) {
      this.distanceInGrid = distanceInGrid;
   }
}
