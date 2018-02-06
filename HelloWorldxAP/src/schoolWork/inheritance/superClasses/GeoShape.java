//Thomas Varano
//[Program Descripion]
//Jan 18, 2018

package schoolWork.inheritance.superClasses;

public abstract class GeoShape implements Comparable<GeoShape>{
   private int x, y;
   
   protected GeoShape() {
      x = 0; y = 0;
   }
   
   protected GeoShape(int x, int y) {
      this.x = x; this.y = y;
   }
   
   public abstract double getArea();
   
   public abstract double getPrerimeter();

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
   public int compareTo(GeoShape o) {
      return (int)(getArea()-o.getArea());
   }
   public String toString() {
      return getClass().getName() + "[x = "+getX() + ", y = "+getY() + ", " + "a = "+getArea() + ", ";
   }
}
