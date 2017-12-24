import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

//Thomas Varano
//[Program Descripion]
//Aug 3, 2017

public class ToolAction extends AbstractAction
{
   private static final long serialVersionUID = 1L;
//   private String value;
   public static final String KEY = "value";
   
   public ToolAction(String value) {
      putValue(KEY, value);
   }
   
//   public String getValue() {
//      return null;
//   }

   @Override
   public void actionPerformed(ActionEvent e) {
      LevelCreator.currentTool = (String) getValue(KEY);
   }
   
}
