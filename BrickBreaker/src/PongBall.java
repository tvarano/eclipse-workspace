import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

//Thomas Varano
//[Program Descripion]
//Jan 18, 2017

public class PongBall
{
   private int x, y, upBound, downBound, width, height;
   private double dx, dy, dSum;
   private Rectangle gameBoard;

   public PongBall(int x, int y, int width, int height, double dx, double dy,
         Rectangle gameBoard) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.gameBoard = gameBoard;
      this.dx = dx;
      this.dy = dy;
      setdSum(dx + dy);
   }
   public PongBall(int x, int y, int width, int height, Rectangle gameBoard) {
      this(x, y, width, height, 0, 0, gameBoard);
   }
   public PongBall() {
      this(0, 0, 0, 0, 0, 0, null);
   }

   public void drawBall(Graphics2D g2) {
      g2.setColor(Color.BLACK);
      g2.fillOval(x, y, width, height);
   }

   public void update() {
      if (isCollideNorth()) {
         dy = -dy;
      }
       if (isCollideEast() || isCollideWest()){
       dx = -dx;
       }
      x += dx;
      y += dy;
   }
   /**
    * @return a <code>Line2D</code> completing the trajectory of the ball<br/>used for single player component
    */
   public Line2D getTrajectory(){
      if (dx<0)
         //TODO this should work
         return (new Line2D.Double(getX(),getY()+height/2,50,y-(x-50)*(dy/dx)+height/2));
      else 
         return (new Line2D.Double(getX(),getY()+height/2,
               BreakerMain.PREF_W-50,y+(BreakerMain.PREF_W-x)*(dy/dx)+height/2));
   }
   public boolean isCollideNorth() {
      return (y <= gameBoard.getMinY());
   }
   public boolean isCollideSouth() {
      return (y + height >= gameBoard.getMaxY());
   }
   public boolean isCollideWest() {
      return (x + width >= gameBoard.getMaxX());
   }
   public boolean isCollideEast() {
      return (x <= gameBoard.getMinX());
   }
   public Ellipse2D.Double getBounds() {
      return new Ellipse2D.Double(x, y, width, height);
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
   public int getUpBound() {
      return upBound;
   }
   public void setUpBound(int upBound) {
      this.upBound = upBound;
   }
   public int getDownBound() {
      return downBound;
   }
   public void setDownBound(int downBound) {
      this.downBound = downBound;
   }
   public int getWidth() {
      return width;
   }
   public void setWidth(int width) {
      this.width = width;
   }
   public int getHeight() {
      return height;
   }
   public void setHeight(int height) {
      this.height = height;
   }
   public double getDx() {
      return dx;
   }
   public void setDx(double dx) {
      this.dx = dx;
   }
   public double getDy() {
      return dy;
   }
   public void setDy(double dy) {
      this.dy = dy;
   }
   public Rectangle getGameBoard() {
      return gameBoard;
   }
   public void setGameBoard(Rectangle gameBoard) {
      this.gameBoard = gameBoard;
   }
   public double getdSum() {
      return dSum;
   }
   public void setdSum(double dSum) {
      this.dSum = dSum;
   }
}
