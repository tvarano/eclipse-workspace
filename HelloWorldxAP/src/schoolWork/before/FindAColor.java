package schoolWork.before;
import java.awt.Color;

import javax.swing.JColorChooser;

//Thomas Varano
//[Program Descripion]
//Nov 2, 2017

public class FindAColor
{
   public static void main(String[] args) {
      Color c = JColorChooser.showDialog(null, "ColorChoser", Color.WHITE);
      System.out.println(c);
   }
}
