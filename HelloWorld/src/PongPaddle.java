import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Thomas Varano
//[Program Descripion]
//Nov 22, 2016
public class PongPaddle implements KeyListener
{
   private int height, width, x, y, frameheight;
   
   public PongPaddle(int x, int y, int height, int width, int frameheight){
      this.height = height;
      this.width = width;
      this.x = x;
      this.y = y;
   }
   
   public PongPaddle(){
      this.x = 0;
      this.y = 0;
   }
   
   public boolean checkIfOffPage(){
      boolean onpage;
      if (y < frameheight && y > 0)
         onpage = true;
      else
         onpage = false;
         return onpage;
   }


   public int getHeight()
   {
      return height;
   }

   public void setHeight(int height)
   {
      this.height = height;
   }

   public int getWidth()
   {
      return width;
   }

   public void setWidth(int width)
   {
      this.width = width;
   }

   public int getX()
   {
      return x;
   }

   public void setX(int x)
   {
      this.x = x;
   }

   public int getY()
   {
      return y;
   }

   public void setY(int y)
   {
      this.y = y;
   }

   @Override
   public void keyTyped(KeyEvent e)
   {
   }

   @Override
   public void keyPressed(KeyEvent e)
   {
//      int key = e.getKeyCode();
//      if(key == KeyEvent.VK_UP){
//         y -= 5;
//      }
//      if(key == KeyEvent.VK_DOWN){
//         y += 5;  
//      }
//   
//   //stay on screen
//      if (checkIfOffPage() == false){
//         if (y < 0){
//            y = 0;
//         }
//         if (y+height > frameheight){
//            y = frameheight - height;
//         }
//      }
   }

   @Override
   public void keyReleased(KeyEvent e)
   {
   }
   
}
