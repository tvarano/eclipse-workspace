import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

//Thomas Varano
//[Program Descripion]
//May 16, 2017

public class PlatformBreak extends Rectangle 
{
   private static final long serialVersionUID = 1L;
   private static final int HEIGHT = 10;

   public PlatformBreak(int x, int y, int width){
      super(x,y,width,HEIGHT);
   }
   public PlatformBreak(Platform leftBound, Platform rightBound){
      super(leftBound.edgeR, leftBound.getY(), rightBound.getEdgeL() - leftBound.getEdgeR(), HEIGHT);
   }
   
   public boolean isLeftOf(Item i){
      return (x+(width/2)<=i.getCenterX());
   }
   
   public boolean isRightOf(Item i){
      return (x+(width/2)>=i.getCenterX());
   }
   
   public void drawBounds(Graphics2D g2){
      Color prev = g2.getColor();
      g2.setColor(Color.YELLOW);
      g2.fill(this);
      g2.setColor(prev);
   }
}
