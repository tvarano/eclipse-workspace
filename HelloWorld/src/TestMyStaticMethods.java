
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

//Thomas Varano
//[Program Descripion]
//Nov 7, 2016
public class TestMyStaticMethods
{
      public static void main(String[] args) throws InterruptedException
      {
         double num = MyStaticMethods.doubleThisNumber(72.5);
         System.out.println(num);
      System.out.println(MyStaticMethods.MEANING_OF_EM);
      MyStaticMethods.printTime();
      System.out.println(MyStaticMethods.getAverage(8, 99));
MyStaticMethods.printTime();



System.out.println(MyStaticMethods.roundTo(3.14159,3));
ArrayList<Image> rightSheet = new ArrayList<Image>();
Image broc = null;
//while(true){
try{
   broc = ImageIO.read(new File("src/adam1.jpg"));
} catch (IOException e){
   e.printStackTrace();
}
rightSheet.add(broc);
Pipes.randHeight();
//   System.out.println(Math.random());
//      }
System.out.println(broc.toString());
System.out.println(rightSheet.get(0));

      }
}
