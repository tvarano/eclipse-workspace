import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

//Thomas Varano
//[Program Descripion]
//Jun 26, 2017

public class LevelManager
{
   public static boolean debug;
   public static BufferedImage DEFAULT_SKIN;
   public LevelManager(Frame parent){
      try {
         DEFAULT_SKIN = ImageIO.read(ClassLoader.getSystemResource("missingTexture"));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
