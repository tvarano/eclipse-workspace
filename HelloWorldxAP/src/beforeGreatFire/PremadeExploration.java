package beforeGreatFire;
import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.colorchooser.AbstractColorChooserPanel;

//Thomas Varano
//[Program Descripion]
//Oct 26, 2017

public class PremadeExploration
{
   public static void main(String[] args) {
      JFileChooser f = new JFileChooser();
      f.showOpenDialog(null);
      
      JColorChooser c  = new JColorChooser();
//      JColorChooser.createDialog(null, "TITLE", false, c, null, null);
//      AbstractColorChooserPanel[] panels = {new ColorChooserPanel()}
//      c.setChooserPanels(panels);
      JColorChooser.showDialog(null, "what", Color.WHITE);
      
   }
}
