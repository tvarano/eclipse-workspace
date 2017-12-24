import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;

//Thomas Varano
//[Program Descripion]
//Mar 16, 2017

public class KongFrame
extends JFrame
{
   private static final long serialVersionUID = 1L;
   public static final int PREF_W = 700, PREF_H = 800;
   public CardLayout layout;
   public Container c;
   private LevelManager manager;
   
   public KongFrame(){
      super("Kong Main");
      c = getContentPane();
      layout = new CardLayout(0,0);
      manager = new LevelManager(this);
      
      this.setLayout(layout);
      setResizable(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      pack();
      setLocationRelativeTo(null);
      setVisible(true);
      manager.methodSoIGetNoErrors();
   }
      
   public static void main(String[] args) {
      new KongFrame();
   }
   
}
