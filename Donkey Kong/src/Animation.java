
import java.awt.image.BufferedImage;

//Thomas Varano
//Program Description
//Dec 20, 2016

public class Animation
{
   private BufferedImage[] frames;
   private int currentFrame;
   private long startTime, delay;
   private boolean runBackwards, pause;
 
   public Animation(long delay) {
      this.delay = delay;
      currentFrame = 0;
   }
   public Animation(){
      this(-1);
   }

   public void setFrames(BufferedImage[] images) {
      frames = images;
      if(currentFrame >= frames.length) currentFrame = 0;
   }
 
   public void setDelay(long d){
      delay = d;
   }
 
   public static BufferedImage[] extractSpriteArray(
         BufferedImage sheet, int amountImages, int y, int width, int height){
      return extractSpriteArray(sheet, amountImages, y, width, 0, height);
//      BufferedImage[] frames = new BufferedImage[amountImages];
//      for (int i = 0; i<frames.length; i++){
//         frames[i] = sheet.getSubimage(width*i, y, width, height);
//      }
//      return frames;
   }
   
   public static BufferedImage[] extractSpriteArray(
         BufferedImage sheet, int amountImages, int y, int width, int space, int height){
      BufferedImage[] frames = new BufferedImage[amountImages];
      for (int i = 0; i<frames.length; i++){
         frames[i] = sheet.getSubimage((width+space)*i, y, width, height);
      }
      return frames;
   }
 
   public BufferedImage[] extractAndSetSpriteArray(BufferedImage sheet, int amountImages, int y, int width, int height){
      BufferedImage[] frames = extractSpriteArray(sheet, amountImages, y, width, height);
      this.frames = frames;
      return frames;
      //      BufferedImage[] frames = new BufferedImage[amountImages];
//      for (int i = 0; i<frames.length; i++){
//         frames[i] = sheet.getSubimage(width*i, y, width, height);
//      }
//      this.frames = extractSpriteArray(sheet, amountImages, y, width, height);
//      return frames;
   }
   
   public void manualShift(){
      if (!runBackwards){
         currentFrame++;
         if (currentFrame==frames.length)
            currentFrame = 0;
      }
      else{
         currentFrame--;
         if (currentFrame==0)
            currentFrame = frames.length-1;
      }
   }

   public void update() {
      if (!pause){
         if(delay == -1) return;
         long elapse = (System.nanoTime() - startTime) / 1000000;
         if(!runBackwards){
            if(elapse > delay) {
               currentFrame++;
               startTime = System.nanoTime();
            }
            if(currentFrame == frames.length){
               currentFrame = 0;
            }
         }
         else {
            if(elapse > delay) {
               currentFrame--;
               startTime = System.nanoTime();
            }
            if(currentFrame < 0){
               currentFrame = frames.length-1;
            }
         }
      }
   }
   
   public BufferedImage updateAndGetImage(){
      update();
      return getImage();
   }
   
   public void stop(){
      pause = true;
   }
   
   public void resume(){
      pause = false;
   }

   public BufferedImage getImage(){
      return frames[currentFrame];
    }
   public boolean isRunBackwards() {
      return runBackwards;
   }
   public void setRunBackwards(boolean runBackwards) {
      this.runBackwards = runBackwards;
   }
   public BufferedImage[] getFrames() {
      return frames;
   }
   public long getDelay(){
      return delay;
   }
   public int getIndex(){
      return currentFrame;
   }
   public void setIndex(int currentFrame) {
      this.currentFrame = currentFrame;
   }
}
