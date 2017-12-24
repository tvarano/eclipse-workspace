import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

//Thomas Varano
//[Program Descripion]
//Nov 22, 2016
public class PongBall implements ActionListener
{
   private int x;
   private int y;
   private int width;
   private int height;
   private double momentum;
   private boolean ony, onx;
   private boolean contact;
   private int scorecountright,scorecountleft = 0;
   private ActionListener mon;
   
   
//   public PongBall(int x, int y, int width, int height){
//      this.x = x;
//      this.y = y;
//      this.width = width;
//      this.height = height;
//   }
   
    public PongBall(int x, int y, int width, int height, int momentum){
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.momentum = momentum;  
   }
   
   public void checkIfContact(int x, int y){
      if (ony = false){
         contact = true;
               momentum = 0-momentum;
      }
   }
   
   public void moveBall(){
      Timer mom = new Timer(50, mon);
      
   }
   
   public boolean checkIfOffY(int width, int height){
      boolean ony;
      if (y < height && y > 0)
         ony = true;
      else
         ony = false;
      this.ony = ony;
         return this.ony;
   }
   public boolean checkIfOffX(int width, int height){
      boolean onx;
      if (x + this.width < width && x > 0)
         onx = true;
         else onx = false;
      this.onx = onx;
      return onx;
   }
   
   public int scoreCountRight(){
      if (x < 0){
         scorecountright ++;
      }
      return scorecountright;
   }
   
   public int scoreCountLeft(){
      if (x + this.width > width){
         scorecountleft ++;
      }
      return scorecountleft;
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

   public int getWidth()
   {
      return width;
   }

   public void setWidth(int width)
   {
      this.width = width;
   }

   public int getHeight()
   {
      return height;
   }

   public void setHeight(int height)
   {
      this.height = height;
   }

   public double getMomentum()
   {
      return momentum;
   }

   public void setMomentum(int momentum)
   {
      this.momentum = momentum;
   }

   public boolean isOnX()
   {
      return onx;
   }

   public void setOnX(boolean onscreen)
   {
      this.onx = onscreen;
   }
   
   public boolean isOnY()
   {
      return ony;
   }
   
   public void setOnY(boolean onscreen)
   {
      this.ony = onscreen;
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      mon.notifyAll();
         
   }

}
