//Thomas Varano
//[Program Descripion]
//Jan 18, 2018

package inheritance.superClasses;

public class Square extends Rect {
   public Square(int x, int y, double s) {
      super(x, y, s, s);
   }
   public Square() {
      this(0, 0, 10);
   }
   public void setSide(double s) {
      setW(s); setH(s);
   }
   public double getSide() {
      return getW();
   }
}
