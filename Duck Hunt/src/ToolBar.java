import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

//Thomas Varano
//[Program Descripion]
//Aug 2, 2017

//DO NOT USE THIS
/**
 * @deprecated DO NOT USE
 * @see {@link JToolBar}
 * @author varanoth
 */
public class ToolBar extends JPanel implements ActionListener
{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private double x, y, width, height;
   private ArrayList<JButton> buttons = new ArrayList<JButton>();
   public String currentTool;
//might not have to do this
//   public static boolean[] tools = {
//         //spawn
//         false,
//         //barrier
//         false,
//         //groundLevel,
//         false,
//         //timeOfDay
//         false,
//         //text
//         false,
//         //goToScriptWriter
//         false};
   GridLayout layout;
   public ToolBar(double x, double y, double width, double height){
      super();
      setSize((int)width, (int)height); 
      buttons.add(new JButton("Spawn")); buttons.add(new JButton("Barrier")); buttons.add(new JButton("GroundLevel"));
      buttons.add(new JButton("Time")); buttons.add(new JButton("Text")); buttons.add(new JButton("Script"));
      layout = new GridLayout(1,buttons.size());
      setLayout(layout);
   }
   
   
   @Override
   public void actionPerformed(ActionEvent e) {
      //HOW DO I KNOW WHICH BUTTON WAS CLICKED
      currentTool = buttons.get(1).getName();
   }
   
}
