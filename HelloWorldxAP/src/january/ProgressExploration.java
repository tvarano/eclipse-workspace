//Thomas Varano
//[Program Descripion]
//Jan 6, 2018

package january;

import javax.swing.ProgressMonitor;

public class ProgressExploration
{
   public static void main(String[] args) {
      ProgressMonitor m = new ProgressMonitor(null, "MES", null, 0, 100);
      m.setProgress(4);
      m.setMillisToPopup(10);
      m.setMillisToDecideToPopup(1);
      System.out.println(m.getMillisToPopup());
   }
}
