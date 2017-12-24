import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

//Thomas Varano
//[Program Descripion]
//Jun 26, 2017

public class Level extends JPanel 
   implements MouseListener, MouseMotionListener, KeyListener
{
   public static final int PREF_W = 1400, PREF_H = 800;
   public static final long serialVersionUID = 1L;
   private ArrayList<Item> items = new ArrayList<Item>();
   public static final double GRAVITY = 0.1;
   private Player playerOne;
   private LevelReader reader;
   
   //order the items from back to front so they print in the correct order;
   public Level(String levelDocName){
      playerOne = new Player(PREF_W/2, PREF_H/2);
      reader = new LevelReader(levelDocName, this);
   }
   
   public void orderItems(){
      double[] zArray = new double[items.size()];
      for (int i = 0; i < items.size(); i++) {
         zArray[i] = items.get(i).getZ();
      }
      
      //no idea if this works
      //it doesnt
      int currentSwapperIndex = 0;
      double currentNum;
      for (int i = 0; i < zArray.length; i++) {
         currentSwapperIndex = i;
         currentNum = zArray[i];
         for (int j = i; j < zArray.length; j++) {
            if (zArray[currentSwapperIndex] > zArray[j]) {
               currentSwapperIndex = j;
            }
         }
         zArray[i] = zArray[currentSwapperIndex];
         items.set(i, items.get(currentSwapperIndex));
         zArray[currentSwapperIndex] = currentNum;
//         items.set(currentSwapperIndex, items.get(currentNum));
      }  
   }
   
   
   public int[] sortSelection(int[] array) {
      int currentSwapperIndex = 0, currentNum;
      for (int i = 0; i < array.length; i++) {
         currentSwapperIndex = i;
         currentNum = array[i];
         for (int j = i; j < array.length; j++) {
            if (array[currentSwapperIndex] > array[j]) {
               currentSwapperIndex = j;
            }
         }
         array[i] = array[currentSwapperIndex];
         array[currentSwapperIndex] = currentNum;
      }
      return array;
   }
   
   @Override
   public void mouseDragged(MouseEvent e){
      System.out.println("dragging the mouse");
   }

   @Override
   public void mouseMoved(MouseEvent e){}

   @Override
   public void mouseClicked(MouseEvent e){}

   @Override
   public void mousePressed(MouseEvent e){
      System.out.println("pressing the mouse");
   }

   @Override
   public void mouseReleased(MouseEvent e){}

   @Override
   public void mouseEntered(MouseEvent e){}

   @Override
   public void mouseExited(MouseEvent e){}

   @Override
   public void keyTyped(KeyEvent e){
   }

   @Override
   public void keyPressed(KeyEvent e){
      System.out.println("keypress"+e.getKeyCode());
   }

   @Override
   public void keyReleased(KeyEvent e){
   }
}
