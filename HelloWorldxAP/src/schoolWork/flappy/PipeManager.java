//Thomas Varano
//Apr 19, 2018

package schoolWork.flappy;

import java.awt.Graphics2D;
import java.util.ArrayList;


public class PipeManager {
   private ArrayList<Pipe> pipes;
   private int pipeWidth = 75;
   private int hGap;
   
   public PipeManager(int screenWidth, int hGap) {
      this.hGap = hGap + pipeWidth;
      pipes = new ArrayList<Pipe>();
      pipes.add(new Pipe(pipeWidth, screenWidth));
   }
   
   
   public void update() {
      for (int i = 0; i < pipes.size(); i++) {
         pipes.get(i).update();
         if (FlappyBird.PREF_W - pipes.get(i).getX() > hGap && i == pipes.size() - 1) {
            pipes.add(new Pipe(pipeWidth, FlappyBird.PREF_W));
         }
         if (pipes.get(i).getX() <= -pipeWidth)
            pipes.remove(i);
      }
   }
   
   public void draw(Graphics2D g2) {
      for (Pipe p : pipes)
         p.draw(g2);
   }
   
   public ArrayList<Pipe> getPipes() {
      return pipes;
   }
   
}
