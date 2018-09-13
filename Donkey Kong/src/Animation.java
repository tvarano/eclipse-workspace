
import java.awt.image.BufferedImage;

//Thomas Varano
//Dec 20, 2016

/**
 * An animation class for GUI applications. Cycles through frames in a {@linkplain BufferedImage}
 *  array and returns them for animation based on a certain delay
 * @author Thomas Varano
 *
 */
public class Animation
{
   protected BufferedImage[] frames;
   private int currentFrame;
   private long startTime, delay;
   private boolean runBackwards;
   protected boolean pause;
 
   /**
    * Creates an animation class object with no images
    * @param delay how long the animation takes between frames
    */
   public Animation(long delay) {
      this.delay = delay;
      currentFrame = 0;
   }
   /**
    * default constructor. gives -1, does not animate
    */
   public Animation(){
      this(-1);
   }

   /**
    * set the frames to run through with the animation
    * @param images the BufferedImage array to run through. 
    * if wanted, current would need to be set to 0 to start from the beginning (using {@link #setIndex(int)})
    */
   public void setFrames(BufferedImage[] images) {
      frames = images;
      if(currentFrame >= frames.length) currentFrame = 0;
   }
 
   /**
    * sets the delay between frames in milliseconds
    */
   public void setDelay(long d){
      delay = d;
   }
 
   /**
    * extracts the sprite array without a gap
    * @see #extractSpriteArray(BufferedImage, int, int, int, int, int)
    */
   public static BufferedImage[] extractSpriteArray(
         BufferedImage sheet, int amountImages, int y, int width, int height){
      return extractSpriteArray(sheet, amountImages, y, width, 0, height);
   }
   
   /**
    * from an image (png, jpg, etc), extract and array of subimages to use in a sprite array. 
    * all images in the array must be on the same row when taken. 
    * @param sheet the image containing all frames
    * @param amountImages how many images to be taken
    * @param y where the y (top right) of the images are. 
    * @param width width of each image.
    * @param space the gap between images
    * @param height height of each image
    * @return a bufferedImage array to be used in animation
    * @see #extractAndSetSpriteArray(BufferedImage, int, int, int, int) for use without a gap
    */
   public static BufferedImage[] extractSpriteArray(
         BufferedImage sheet, int amountImages, int y, int width, int space, int height){
      BufferedImage[] frames = new BufferedImage[amountImages];
      for (int i = 0; i<frames.length; i++){
         frames[i] = sheet.getSubimage((width+space)*i, y, width, height);
      }
      return frames;
   }
 
   /**
    * Extracts the sprite array and sets the frames of animation to said frames.
    * @return the frames extracted
    * @see Animation#extractSpriteArray(BufferedImage, int, int, int, int, int)
    */
   public BufferedImage[] extractAndSetSpriteArray(BufferedImage sheet, int amountImages, int y, int width, int height){
      BufferedImage[] frames = extractSpriteArray(sheet, amountImages, y, width, height);
      this.frames = frames;
      return frames;
   }
   
   /**
    * move the animation one frame. practically only done if not animating otherwise.
    * will move backwards or forwards, depending on specification
    * <br><strong>
    * {@linkplain #frames} must be set before running this method using {@linkplain #setFrames(BufferedImage[])}
    * </strong>
    */
   public void manualShift(){
      if (!runBackwards){
         currentFrame++;
         if (currentFrame == frames.length)
            currentFrame = 0;
      }
      else {
         currentFrame--;
         if (currentFrame==0)
            currentFrame = frames.length-1;
      }
   }

   /**
    * update the animation on a timer, animating according to the specified
    * delay. <br>
    * will run backwards, depending on specification <br>
    * if delay is -1, will not animate <br>
    * <strong> {@linkplain #frames} must be set before running this method using
    * {@linkplain #setFrames(BufferedImage[])} </strong>
    */
   public void update() {
      if (pause) return;
      if (delay == -1) return;
      long elapse = (System.nanoTime() - startTime) / 1_000_000;
      if (runBackwards) {
         if (elapse > delay) {
            currentFrame--;
            startTime = System.nanoTime();
         }
         if (currentFrame < 0) 
            currentFrame = frames.length - 1;
      } else {
         if (elapse > delay) {
            currentFrame++;
            startTime = System.nanoTime();
         }
         if (currentFrame == frames.length) currentFrame = 0;
      }
   }

   /**
    * updates the animation and gets the frame currently shown for the animation
    * @return {@link #getImage()} the image in frames to be shown after the update.
    */
   public BufferedImage updateAndGetImage(){
      update();
      return getImage();
   }
   
   /**
    * Pause or play the animation
    * @param pause
    */
   public void setPause(boolean pause) {
      if (pause) stop();
      else resume();
   }
   
   /**
    * pause the animation
    * 
    * @see #setPause(boolean)
    */
   @Deprecated
   public void stop(){
      pause = true;
   }
   
   /**
    * resume the animation
    * @see #setPause(boolean)
    */
   @Deprecated
   public void resume(){
      pause = false;
   }

   /**
    * the image currently to be shown from the animation
    * @return
    */
   public BufferedImage getImage(){
      return frames[currentFrame];
    }
   /**
    * specifies if the animation running backwards
    */
   public boolean isRunningBackwards() {
      return runBackwards;
   }
   /**
    * @param runBackwards true if the desired effect is to have the animation run backwards
    */
   public void setRunBackwards(boolean runBackwards) {
      this.runBackwards = runBackwards;
   }
   /**
    * the frames used for animation
    * @return a bufferedImage array of images used for animating
    */
   public BufferedImage[] getFrames() {
      return frames;
   }
   /**
    * @return the delay between each frame in milliseconds
    */
   public long getDelay(){
      return delay;
   }
   /**
    * @return the current index in {@linkplain #getFrames()} that is used to get the current image
    */
   public int getIndex(){
      return currentFrame;
   }
   /**
    * Manually set the index to which {@linkplain #getImage()} retrieves
    * @param currentFrame the index desired
    */
   public void setIndex(int currentFrame) {
      this.currentFrame = currentFrame;
   }
}
