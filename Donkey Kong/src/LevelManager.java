import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.Timer;

//Thomas Varano
//[Program Descripion]
//Apr 15, 2017

public class LevelManager
implements ActionListener
{
   public static final String CUTSCENE = "cutscene", LVLONE = "level1", LVLTWO = "level2"; 
   public static final String LVLOPEN = "openingHighSong", MAIN = "arcade", ALT = "smoothJazz", HAM = "lolly", 
         WIN = "kirby", DEAD = "dododoMarioDead";
   public static final String[] SOUNDS = {LVLOPEN, MAIN, CUTSCENE, ALT, HAM, WIN, DEAD};
   public static final String[] NON_LOOP_SOUNDS = {LVLOPEN, HAM, WIN, DEAD};
   public static String mainSong;
   public final String highScoreFile = System.getProperty("user.home")+"/Documents/DonkeyKongHighScore.txt";
   private KongFrame frame;
   private int level, lives, score, highScore;
   private boolean firstPlay, gameOver, resetCutscene;
   public static boolean mute;
   private OpeningCutscene cutscene;
   private long counter;
   private LevelOne lvlOne;
   private LevelTwo lvlTwo;
   private Timer timer = new Timer(50,this);
   
   public LevelManager(KongFrame frame){
      this.frame = frame;
      level = 0;
      lives = 3;
      score = 0;
      firstPlay = resetCutscene = true;
      initSounds();
      lvlOne = new LevelOne();
      lvlTwo = new LevelTwo();
      readHighScore();
      cutscene = new OpeningCutscene(level,firstPlay);
      cutscene.setHeader(level+1, lives, score, highScore);
      
      mainSong = ALT;
      
      frame.c.setLayout(frame.layout);
      frame.c.add(CUTSCENE,cutscene); frame.c.add(LVLONE,lvlOne); frame.c.add(LVLTWO, lvlTwo);
      frame.layout.show(frame.c, CUTSCENE);
      cutscene.requestFocus();
      frame.pack();
      timer.start();
   }
   
   public void initSounds(){
      WavPlayer.init();
      WavPlayer.load("DKHowHigh3.wav", LVLOPEN);      
      WavPlayer.load("dkMain.wav", MAIN);
      WavPlayer.load("kelpyGLoopable.wav", ALT);
      WavPlayer.load("kirbyLolly.wav", HAM);
      WavPlayer.load("kirbyVictory.wav", WIN);
      WavPlayer.load("openingScene.wav", CUTSCENE);
      WavPlayer.load("marioDeath.wav", DEAD);
      for (String s : SOUNDS) {
         WavPlayer.setVolume(s,0);
      }
   }
   
   public static void resetSounds(){
      for(String s : NON_LOOP_SOUNDS)
         WavPlayer.resetPosition(s);
   }
   
   public static void toggleMute() {
      mute = !mute;
      if (mute) 
         for (String s : SOUNDS) 
            WavPlayer.mute(s);
      else 
         for (String s : SOUNDS) 
            WavPlayer.unMute(s);
      System.out.println("mute toggled to: "+ mute);
   }
   
   public void die(){
      Level l = (level == 1) ? lvlOne : lvlTwo;
      System.out.println("DEAD");
      if (resetCutscene){
         cutscene.restart();
         lives--;
         resetCutscene = false;
      }
      cutscene.setHeader(level, lives, score, highScore);
      frame.layout.show(frame.c, CUTSCENE);
      if(cutscene.isDone()){
         counter = 0;
         l.restart();
         l.setHeader(lives, score, highScore);
         frame.layout.show(frame.c, "level"+level);
         cutscene.restart();
         resetCutscene = true;
      }
   }
   
   public void operations(){
      Level l = (level == 1) ? lvlOne : lvlTwo;
      if (counter == 0){
         System.out.println("COUNTERNOW");
         l.restart();
         WavPlayer.loop(mainSong);
      }
      else if (counter == 1){
         l.setHeader(lives, score, highScore);
      }
      if (counter>1 && l.isDead()){
         die();
         l.getPlayer().setLives(lives);
      }
      else if (l.done){
         Level next = (level+1 == 2) ? lvlTwo : null;
         WavPlayer.stop(mainSong);
         if (resetCutscene){
            cutscene.restart();
            cutscene.setLevel(level+1);
            resetCutscene = false;
         }
         score += l.score;
         score = l.getScore();
         frame.layout.show(frame.c,CUTSCENE);
         l.getTimer().stop();
         if (cutscene.isDone()){
            level++;
            counter = 0;
            next.restart(lives);
            next.setHeader(lives, score, highScore);
            frame.layout.show(frame.c, "level"+level);
            next.getTimer().start();
            WavPlayer.stop(LVLOPEN);
            System.out.println("level"+level);
            resetCutscene = true;
         }
      }
      counter++;
   }
   
   public void update(){
      gameOver = (lives == 0);
      if (gameOver)
         System.out.println("gameover");
      
      if (level == 0){
         if (cutscene.isDone()){
            level++;
            frame.layout.show(frame.c, LVLONE);
            firstPlay = false;
            cutscene.setFirstPlay(firstPlay);
         }
      }
      
      if (level == 1){
         lvlOne.requestFocus();
         operations();
      }
      if (level == 2){
         lvlTwo.requestFocus();
         operations();
      }
   }
   
   public void readHighScore()
   {     
      File filePath = new File(highScoreFile);
      try{
         System.out.println("Reading high score.");
         @SuppressWarnings("resource")
         Scanner dataGetter = new Scanner(filePath);
         highScore = dataGetter.nextInt();
      }
      catch (FileNotFoundException e){
         System.out.println("Creating high score file.");
         try
         {
            PrintWriter pw = new PrintWriter(new FileWriter(highScoreFile, false));
            pw.println(0);
            pw.close();
            highScore = 0;
         } catch (IOException e1){e1.printStackTrace();}
      }
   }

   public void setScores()
   {
      if(score>highScore){
         highScore = score;
//         String userName = (String)JOptionPane.showInputDialog(null, "You got a High Score!\nWrite your name.",
//               "High Score!",
//               JOptionPane.PLAIN_MESSAGE,
//               null,
//               null,
//               "----");
         try
         {
            System.out.println("Writing high score.");
            PrintWriter pw = new PrintWriter(new FileWriter(highScoreFile, false));
            pw.println(highScore);
//            pw.println(userName);
            pw.close();
         } catch (IOException e1){e1.printStackTrace();}
      }
   }
   
   public void methodSoIGetNoErrors(){
      System.out.println("aight");
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      update();
   }
}
