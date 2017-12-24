import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;

//Thomas Varano
//[Program Descripion]
//Jul 17, 2017

public class PlayerOptimization
{
   private static int gap;
   private static ArrayList<String> labels;
   private static ArrayList<Clip> clips;
   public static final float STANDARD_VOL = 0;
   public static final float MUTE_VOL = -80;
   
   
   public static void init(){
      gap = 0;
      clips = new ArrayList<Clip>();
      labels = new ArrayList<String>();
   }
   
   public static Clip get(String s) {
      if (isNull(s)) return null;
      return clips.get(labels.indexOf(s));
   }
   
   private static int checkIndex(String s) {
      return labels.indexOf(s);
   }
   
   private static boolean isNull(String s) {
      return (labels.indexOf(s) == -1);
   }
   
   private static boolean isNull(Clip c) {
      return (c == null);
   }
      
   public static int load(String s, String label) {
      for (String n : labels)
         if (label.equals(n)) {
            System.err.println("label \""+label+"\" is already taken");
            return -1;
         }
      Clip clip;
      int index = clips.size();
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
         clips.add(clip);
         labels.add(label);
      }
      catch(Exception e) {
         e.printStackTrace();
      }
      System.out.println("Loaded: " + s);
      return index;
   }
   
   public static void remove(String s){
      if (isNull(s)) return;
      clips.remove(checkIndex(s));
      labels.remove(checkIndex(s));
   }
   
   public static void remove(int i){
      if (i < clips.size()) {
         clips.remove(i);
         labels.remove(i);
      }
   }
   
   public static void play(String s, int startFrame) {
      Clip c = get(s);
      if (isNull(c)) return;
      c.setFramePosition(startFrame);
      while(!c.isRunning()) c.start();
      System.out.println("Playing "+s);
   }
   
   public static void play(String s) {
      Clip c = get(s);
      if (isNull(c)) return;
      while (!c.isRunning()) c.start();
      System.out.println("Playing "+s);
      if (c.getFramePosition() == c.getFrameLength() - 1)
         System.out.println("clip "+ s +" needs to be reset");
   }
   
   public static void pause(String s) {
      Clip c = get(s);
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
      Clip c = get(s);
      if (isNull(c)) return;
      c.setLoopPoints(startFrame, endFrame);
      c.loop(amount);
      System.out.println("loop "+s);
   }
   
   public static void loop(String s, int startFrame, int endFrame) {
      loop(s,startFrame,endFrame,Clip.LOOP_CONTINUOUSLY);
   }
   
   public static void loop(String s, int amount) {
      Clip c = get(s);
      if (isNull(c)) return;
      loop(s, gap, c.getFrameLength() - 1, amount);
   }
   
   public static void loop(String s) {
      loop(s, Clip.LOOP_CONTINUOUSLY);
   }
   
   public static void setPosition(String s, int frame) {
      get(s).setFramePosition(frame);
   }
   
   public static int getFrames(String s) { return get(s).getFrameLength(); }
   public static int getPosition(String s) { return get(s).getFramePosition(); }
   
   public static void close(String s) {
      stop(s);
      get(s).close();
   }
   
   public static void open(String s) {
      Clip c = get(s);
      if (isNull(c)) return;
      if (c.isOpen()) return;
      try {
         get(s).open();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
   }
   
   public static void setVolume(String s, float f) {
      Clip c = get(s);
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
      Clip c = get(s);
      if(isNull(c)) return false;
      if (c.getFramePosition() <= c.getFrameLength() - 2) return false;
      return c.isRunning();
   }
   
   public static boolean isDone (String s) {
      Clip c = get(s);
      if(isNull(c)) return false;
      return (c.getFramePosition() >= c.getFrameLength() - 2);
   }
   
   
   
   
}
