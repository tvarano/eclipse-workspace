import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.Timer;

//Thomas Varano
//[Program Descripion]
//Feb 20, 2017

public class TetrisGUI
   extends JFrame
   implements ActionListener, KeyListener
{
   private int counter = 0;
   private Timer timer = new Timer(20, this);
   private Tetris game = new Tetris();
   private TetrisMenu menu = new TetrisMenu();
   
   private static final long serialVersionUID = 1L;

   public TetrisGUI() {
      super("Tetris");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new BorderLayout());
      getContentPane().add(menu, BorderLayout.CENTER);
      JTextPane pane = new JTextPane();
      add(pane, BorderLayout.SOUTH);
      pane.setText("Up to rotate. Down to speed up. Enter to hold. Space to drop. ESC to pause.");
      pane.setBackground(new Color(0,0,0,0));
      pane.setForeground(getForeground());
      pane.setFont(Tetris.smallFont);
      pane.setEditable(false);
      pack();
      setLocationRelativeTo(null);
      setVisible(true);
      setResizable(false);
      setSize(new Dimension(Tetris.PREF_W, Tetris.PREF_H));
      timer.start();
      System.out.println("soiadfbpiosdfubapoisdf");
      }
      


   public static void main(String[] args) {
      new TetrisGUI();
   }

   public void setMenu(){
    getContentPane().remove(game);
    getContentPane().add(menu);
    pack();
   }
   
   public void setGame(){
      getContentPane().remove(menu);
      getContentPane().add(game);
      pack(); 
   }

   public void update() {
      if (menu.initGame){
         setGame();
         game.setInitGame(true);
      }
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      update();
   }



   @Override
   public void keyTyped(KeyEvent e) {
   }



   @Override
   public void keyPressed(KeyEvent e) {
      System.out.println("gueiguei");
   }



   @Override
   public void keyReleased(KeyEvent e) {
   }
}
