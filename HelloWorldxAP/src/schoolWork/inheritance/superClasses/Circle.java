//Thomas Varano
//[Program Descripion]
//Jan 18, 2018

package schoolWork.inheritance.superClasses;

public class Circle extends GeoShape {
   private double r;
   
   public Circle(int x, int y, double r) {
      super(x, y);
      this.r = r;
   }
   
   public Circle() {
      this(0, 0, 10);
   }

   @Override
   public double getArea() {
      return Math.PI * Math.pow(r, 2);
   }
   @Override
   public double getPrerimeter() {
      return 2 * Math.PI * r;
   }
   public double getR() {
      return r;
   }
   public void setR(double r) {
      this.r = r;
   } 
   public String toString() {
      return super.toString() + "r = "+r + "]";
   }
}
