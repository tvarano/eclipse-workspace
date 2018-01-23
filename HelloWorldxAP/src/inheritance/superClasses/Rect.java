//Thomas Varano
//[Program Descripion]
//Jan 18, 2018

package inheritance.superClasses;

public class Rect extends GeoShape {
   private double w, h;
   public Rect(int x, int y, double w, double h) {
      super(x,y);
      this.w = w; this.h = h;
   }
   public Rect() {
      this(0,0,10,20);
   }
   
   @Override
   public double getArea() {
      return w * h;
   }
   @Override
   public double getPrerimeter() {
      return 2*w + 2*h;
   }

   public double getW() {
      return w;
   }
   public void setW(double w) {
      this.w = w;
   }
   public double getH() {
      return h;
   }
   public void setH(double h) {
      this.h = h;
   }
   public String toString() {
      return super.toString() + "w = "+w + ", h = " + h + "]";
   }
}
