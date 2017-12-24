import java.awt.GraphicsEnvironment;

//Thomas Varano
//[Program Descripion]
//Sep 21, 2016
public class UsableFonts
{
   public static void main(String[] args)
   {
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      String[] fontNames = ge.getAvailableFontFamilyNames();
      for (int index = 0; index < fontNames.length; index++)
      {
         System.out.println(fontNames[index]);
      }
   }
}
