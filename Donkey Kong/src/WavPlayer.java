// Global audio player class.
// Call init() as soon as possible to instantiate
// the clips HashMap.

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.HashMap;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;

public class WavPlayer {
   
   private static HashMap<String, Clip> clips;
   private static int gap;
   public static final float STANDARD_VOL = 0;
   
   // Creates new clips HashMap.
   public static void init() {
      clips = new HashMap<String, Clip>();
      gap = 0;
   }
   
   // Loads up audio located at path "s" and stores
   // it in the HashMap with key "n".
   public static void load(String s, String n) {
      if(clips.get(n) != null) return;
      Clip clip;
      try {
         InputStream in = WavPlayer.class.getResourceAsStream(s);
         InputStream bin = new BufferedInputStream(in);
         AudioInputStream ais =
            AudioSystem.getAudioInputStream(bin);
         AudioFormat baseFormat = ais.getFormat();
         AudioFormat decodeFormat = new AudioFormat(
            AudioFormat.Encoding.PCM_SIGNED,
            baseFormat.getSampleRate(),
            16,
            baseFormat.getChannels(),
            baseFormat.getChannels() * 2,
            baseFormat.getSampleRate(),
            false
         );
         AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
         clip = AudioSystem.getClip();
         clip.open(dais);
         clips.put(n, clip);
      }
      catch(Exception e) {
         e.printStackTrace();
      }
      System.out.println("Loaded: " + s);
   }
   
   private static boolean isNull(String s) {
      return (clips.get(s) == null);
   }
   private static boolean isNull(Clip c){
      return (c == null);
   }
   
   public static void play(String s, int startFrame) {
      Clip c = clips.get(s);
      if (isNull(c)) return;
      c.setFramePosition(startFrame);
      while(!c.isRunning()) c.start();
      System.out.println("Playing "+s);
   }
   
   public static void play(String s) {
      Clip c = clips.get(s);
      if (isNull(c)) return;
      while (!c.isRunning()) c.start();
      System.out.println("Playing "+s);
      if (c.getFramePosition() == c.getFrameLength() - 1)
         System.out.println("clip "+ s +" needs to be reset");
   }
   
   public static void pause(String s) {
      Clip c = clips.get(s);
      if (isNull(c)) return;
      if (c.isRunning())
         c.stop();
   }
   
   public static void resetPosition(String s) {
      setPosition(s, 0);
   }
   
   public static void stop(String s) {
      pause(s);
      resetPosition(s);
   }
   
   public static void loop(String s, int startFrame, int endFrame, int amount) {
      Clip c = clips.get(s);
      if (isNull(c)) return;
      c.setLoopPoints(startFrame, endFrame);
      c.loop(amount);
      System.out.println("loop "+s);
   }
   
   public static void loop(String s, int startFrame, int endFrame) {
      loop(s,startFrame,endFrame,Clip.LOOP_CONTINUOUSLY);
   }
   
   public static void loop(String s, int amount) {
      Clip c = clips.get(s);
      if (isNull(c)) return;
      loop(s, gap, c.getFrameLength() - 1, amount);
   }
   
   public static void loop(String s) {
      loop(s, Clip.LOOP_CONTINUOUSLY);
   }
   
   public static void setPosition(String s, int frame) {
      clips.get(s).setFramePosition(frame);
   }
   
   public static int getFrames(String s) { return clips.get(s).getFrameLength(); }
   public static int getPosition(String s) { return clips.get(s).getFramePosition(); }
   
   public static void close(String s) {
      stop(s);
      clips.get(s).close();
   }
   
   public static void open(String s) {
      Clip c = clips.get(s);
      if (isNull(c)) return;
      if (c.isOpen()) return;
      try {
         clips.get(s).open();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
   }
   
   public static void setVolume(String s, float f) {
      Clip c = clips.get(s);
      if(isNull(c)) return;
      FloatControl vol = (FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN);
      vol.setValue(f);
   }
   
   public static void mute(String s) {
      setVolume(s,-80);
   }
   
   public static void unMute(String s) {
      setVolume(s, STANDARD_VOL);
   }
   
   public static boolean isPlaying(String s) {
      Clip c = clips.get(s);
      if(isNull(c)) return false;
      if (c.getFramePosition() <= c.getFrameLength() - 2) return false;
      return c.isRunning();
   }
   
   public static boolean isDone (String s) {
      Clip c = clips.get(s);
      if(isNull(c)) return false;
      return (c.getFramePosition() >= c.getFrameLength() - 2);
   }
   
   public static void main(String[] args)
   {
      WavPlayer.init();
   // load music
      WavPlayer.load("splash.wav", "music");
      WavPlayer.setVolume("music", 5);
      WavPlayer.loop("music", 1000, 1000, WavPlayer.getFrames("music") - 1000);
      
      WavPlayer.play("music");
      try
      {
         Thread.sleep(1000);
      } catch (InterruptedException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   
}