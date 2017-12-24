package beforeGreatFire;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

//Thomas Varano
//[Program Descripion]
//Aug 30, 2017

public class SpringExercise extends JFrame
{
   private static final long serialVersionUID = 1L;
   public SpringExercise(){
      super("Trying Spring Layout");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      executeLayout();
      getContentPane().add(new JPanel());
      pack();
      setLocationRelativeTo(null);
      setVisible(true);
   }
   
   private void executeLayout() {
      Container cp = getContentPane();
      SpringLayout layout = new SpringLayout();
      cp.setLayout(layout);
//      JLabel[] labels = {new JLabel("label1"), new JLabel("label2"), 
//            new JLabel("label3"), new JLabel("label4"), new JLabel("label5"), new JLabel("label6")}; 
      
      JLabel[] labels = new JLabel[5];
      for (int i = 0; i < labels.length; i++) {
         labels[i] = new JLabel("label"+(i+1));
         cp.add(labels[i]);
      }
      JTextField[] fields = new JTextField[labels.length];
      for (int i = 0; i < fields.length; i++) {
         fields[i] = new JTextField("field"+(i+1));
         cp.add(fields[i]);
      }
      
      for (int i = 0; i < labels.length; i++) {
         boolean zero = (i == 0);
         String northernBoundDirectionLabel = (zero) ? SpringLayout.NORTH : SpringLayout.VERTICAL_CENTER;
         String northernBoundDirectionField = (zero) ? SpringLayout.NORTH : SpringLayout.SOUTH;
         Component northBoundField = (zero) ? cp: fields[i-1];
         Component northBoundLabel = (zero) ? cp: fields[i];
         
         layout.putConstraint(SpringLayout.NORTH, fields[i], 15, northernBoundDirectionField, northBoundField);
         layout.putConstraint(SpringLayout.NORTH, labels[i], 15, northernBoundDirectionLabel, northBoundLabel);
         layout.putConstraint(SpringLayout.EAST, labels[i], -15, SpringLayout.WEST, fields[i]);
         layout.putConstraint(SpringLayout.WEST, fields[i], 15, SpringLayout.HORIZONTAL_CENTER, cp);
         layout.putConstraint(SpringLayout.EAST, fields[i], -5, SpringLayout.EAST, cp);
//         layout.putConstraint(SpringLayout., c1, pad, e2, c2);
         
      }
   }
   public Dimension getPreferredSize() {
      return new Dimension(300,400);
   }
   public static void main(String[] args) {
      new SpringExercise();
   }
}
