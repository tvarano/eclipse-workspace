//Thomas Varano
//[Program Descripion]
//Jan 18, 2018

package inheritance.superClasses;

import java.util.ArrayList;
import java.util.Collections;

public class GeoTest {
   public static void main(String[] args) {
      ArrayList<GeoShape> s = new ArrayList<GeoShape>();
      
      for (int i = 0; i < 3; i++) {
         s.add(new Rect(coord(600), coord(800), length(), length()));
         s.add(new Circle(coord(600), coord(800), length()));
         s.add(new Square(coord(600), coord(800), length()));
      }
      
      for (GeoShape a : s)
         System.out.println(a);
      
      Collections.sort(s);
      System.out.println();
       
      for (GeoShape a : s)
         System.out.println(a);
   }
   private static int coord(int till) {
      return (int)(Math.random()*till);
   }
   private static double length() {
      return Math.random() * 100;
   }
}
