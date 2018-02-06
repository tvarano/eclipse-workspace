package schoolWork.before;
import java.awt.Color;
import java.awt.Point;

//Thomas Varano
//[Program Descripion]
//Sep 5, 2017

public class Line
{
   private static final int DEFAULT_THICKNESS = 3;
   private Point pointOne, pointTwo;
   private int thickness;
   private Color color;
   private boolean selected;
   
   public Line(Point p1, Point p2, int thickness, Color color) {
      setPointOne(p1); setPointTwo(p2); setThickness(thickness); setColor(color);
      selected = false;
   }
   
   public Line(Point p1, Point p2) {
      this(p1, p2, DEFAULT_THICKNESS, Color.WHITE);
   }
   
   public Line(int x1, int y1, int x2, int y2, int thickness, Color color) {
      this(new Point(x1,y1), new Point(x2,y2), thickness, color);
   }
   
   public Line(int x1, int y1, int x2, int y2, int thickness) {
      this(x1,y1,x2,y2, thickness, Color.WHITE);
   }
   
   public Line (int x1, int y1, int x2, int y2) {
      this(x1, y1, x2, y2, DEFAULT_THICKNESS);
   }

   public double getSlope() {
      return (pointTwo.getY()-pointOne.getY())/(pointTwo.getX()-pointOne.getX());
   }
   
//   public double getYIntercept() {
//      
//   }
//   
//   public double getXIntercept() {
//      
//   }
//   
//   
//   
//   public String toString() {
//      return 
//   }
   
   public Point getPointOne() {
      return pointOne;
   }

   public void setPointOne(Point pointOne) {
      this.pointOne = pointOne;
   }

   public Point getPointTwo() {
      return pointTwo;
   }

   public void setPointTwo(Point pointTwo) {
      this.pointTwo = pointTwo;
   }

   public int getThickness() {
      return thickness;
   }

   public void setThickness(int thickness) {
      this.thickness = thickness;
   }

   public Color getColor() {
      return color;
   }

   public void setColor(Color color) {
      this.color = color;
   }

   public boolean isSelected() {
      return selected;
   }

   public void setSelected(boolean selected) {
      this.selected = selected;
   }

   public static double getDefaultThickness() {
      return DEFAULT_THICKNESS;
   }
}
