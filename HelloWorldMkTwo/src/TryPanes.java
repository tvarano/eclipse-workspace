import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

//Thomas Varano
//[Program Descripion]
//Feb 24, 2017

public class TryPanes
   extends JPanel
   implements ActionListener
{
   private static final long serialVersionUID = 1L;
   private RenderingHints hints = new RenderingHints(
         RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   private JButton[] buttons = new JButton[6];
   private JButton button = new JButton("HEY");
   
   public TryPanes(){
      setFocusable(true);
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      for (int i = 0; i<buttons.length; i++){
         buttons[i] = (new JButton("CLICK"));
         buttons[i].addActionListener(this);
         this.add(buttons[i]);
      }
      
   }
   
   @Override
   protected void paintComponent(Graphics g){
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.addRenderingHints(hints);
      
   }
   
   public static void main(String[] args) {

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      System.out.println("HerhEH");
   }

}
