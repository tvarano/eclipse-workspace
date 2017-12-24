//Thomas Varano
//[Program Descripion]
//Dec 18, 2017

package december;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;

public class Virus
{
   public static void main(String[] args)
         throws IOException, URISyntaxException {
      JFrame f = new JFrame("hell0");
      f.setVisible(true);
      for (int i = 0; i < 10; i++)
         if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(new URI("https://google.com"));
         }
      System.exit(0);
   }
}
