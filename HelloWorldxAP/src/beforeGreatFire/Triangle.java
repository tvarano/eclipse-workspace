package beforeGreatFire;
import java.awt.Graphics2D;
import java.awt.Point;

//Thomas Varano
//[Program Descripion]
//Oct 26, 2017

public class Triangle
{
   private Point a, b, c;
   
   public Triangle (Point a, Point b, Point c) {
      setVertexA(a); setVertexB(b); setVertexC(c); 
   }

   public Triangle (int ax, int ay, int bx, int by, int cx, int cy) {
      this(new Point(ax,ay), new Point(bx,by), new Point(cx,cy));
   }
   
   private double getSide(Point a, Point b) {
      return Math.sqrt(Math.pow((a.getX()-b.getX()), 2) + Math.pow((a.getY()-b.getY()), 2));
   }
   
   public void draw(Graphics2D g2) {
      int[] xs = {(int)a.getX(), (int)b.getX(), (int)c.getX()};
      int[] ys = {(int)a.getY(), (int)b.getY(), (int)c.getY()};
      g2.drawPolygon(xs, ys, 3);
      
      int ovalR = 3;
      g2.fillOval((int)a.getX()-ovalR, (int)a.getY()-ovalR, ovalR*2, ovalR*2);
      g2.fillOval((int)b.getX()-ovalR, (int)b.getY()-ovalR, ovalR*2, ovalR*2);
      g2.fillOval((int)c.getX()-ovalR, (int)c.getY()-ovalR, ovalR*2, ovalR*2);
   }
   
   //finds angle of point a
   private double getAngle(Point a, Point b, Point c) {
      //a^2 = b^2 + c^2 - 2bc cosA
      return Math.toDegrees(Math.acos((Math.pow(getSide(b,c), 2) - Math.pow(getSide(a,c), 2) - Math.pow(getSide(a,b), 2)) / 
            (2*getSide(a,c)*getSide(a,b))));
   }
   
   public double getSideA() {
      return getSide(b,c);
   }
   
   public double getSideB() {
      return getSide(a,c);
   }
   
   public double getSideC() {
      return getSide(b,a);
   }
   
   public double getPerimeter() {
      return getSideA()+getSideB()+getSideC();
   }
   
   public double getArea() {
      return 0.5 * getSideA() * getSideB() * Math.sin(Math.toRadians(getAngleC()));
   }
   
   public double getAngleA() {
      return getAngle(a,b,c);
   }
   
   public double getAngleB() {
      return getAngle(b,a,c);
   }
   
   public double getAngleC() {
      return getAngle(c,a,b);
   }
   
   public Point getVertexA() {
      return a;
   }
   public void setVertexA(Point a) {
      this.a = a;
   }
   public Point getVertexB() {
      return b;
   }
   public void setVertexB(Point b) {
      this.b = b;
   }
   public Point getVertexC() {
      return this.c;
   }
   public void setVertexC(Point c) {
      this.c = c;
   }
   
   
   public static void main(String[] args) {
      Triangle t = new Triangle(new Point(0,0),new Point(4,0),new Point(4,3));
      System.out.println(t.getAngleA());
      System.out.println(t.getAngleB());
      System.out.println(t.getSideA() + ","+t.getSideB()+","+t.getSideC());
      System.out.println(t.getArea());
   }
}
