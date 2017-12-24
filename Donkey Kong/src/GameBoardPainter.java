import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

//Thomas Varano
//[Program Descripion]
//Mar 26, 2017

public class GameBoardPainter
{
   //TODO would be much cooler to create a method in another thing, paint it there, then return an image. but whatevs.
   public static BufferedImage LIFE_IMAGE;
   private BufferedImage bodyImage, header, bonusBoard;
   private int lives, score, highScore, level, bonus;   
   private static final int SECTION_W = 50;
   private static Font font = new Font("Courier",Font.PLAIN, 35);
   private RenderingHints hints = new RenderingHints(
         RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   private String label;

   public int PREF_W = 700, PREF_H = 800;
   private ArrayList<Platform> platforms;
   private ArrayList<Ladder> ladders;
   private Color primaryColor, secondaryColor;
   private boolean showBonus;
   
   public GameBoardPainter(int lives, int score, int highScore, int level, String label){
      this.lives = lives;
      this.score = score;
      this.highScore = highScore;
      this.level = level;
      this.label = label;
      bodyImage = new BufferedImage(PREF_W, PREF_H, BufferedImage.TYPE_INT_ARGB);
      try {
         bonusBoard = ImageIO.read(new File("src/scoreBoard.png"));
      } catch(IOException e){
         e.printStackTrace();
      }
      try {
         LIFE_IMAGE = ImageIO.read(new File("src/life image.png"));
      } catch (IOException e){
         LIFE_IMAGE = LevelOne.DEFAULT_SKIN;
         e.printStackTrace();
      }
      bonus = 5000;
      primaryColor = Color.RED;
      secondaryColor = Color.CYAN;
      repaint();
   }
   public GameBoardPainter(int score, int highScore, String label){
      this(3,score,highScore,1,label);
   }
   public GameBoardPainter(String label) {
      this (0,0,label);
   }
   public GameBoardPainter(){
      this("noParent");
   }
   
   public void draw(Graphics2D g2){
      drawBody(g2);
      drawHeader(g2);
   }
   
   public void drawBody(Graphics2D g2){
      g2.drawImage(bodyImage, 0,0,bodyImage.getWidth(), bodyImage.getHeight(),null);
   }
   
   public void drawHeader(Graphics2D g2){
      g2.drawImage(header, 0,0,header.getWidth(), header.getHeight(),null);
   }
   
   public void repaintBody(){
      System.out.println(label+": repaint the body");
      bodyImage = new BufferedImage(PREF_W, PREF_H, BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2 = bodyImage.createGraphics();
      g2.setRenderingHints(hints);
      if (ladders!=null)
         for (int i = 0; i < ladders.size(); i++)
            ladders.get(i).draw(g2);
      if (platforms!=null)
         for (int i = 0; i<platforms.size(); i++)
            platforms.get(i).draw(g2); 
   }
   
   public void repaint(){
      repaintBody();
      repaintHeader();
   }
   
   public void repaintHeader(){
      header = new BufferedImage(PREF_W,300, BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2 = header.createGraphics();
      g2.setRenderingHints(hints);
      g2.setFont(font);
      g2.setColor(Color.RED);
      g2.drawString("HIGH SCORE", PREF_W/2-("HIGH SCORE".length()/2*20), 25);
      g2.drawString("1UP", 10+("00".length()*20), 25);
      g2.setColor(Color.WHITE);
      String scoreOutput = "";
      for (int i = (int)Math.log10(this.score+1)+1;i<6;i++)
         scoreOutput+="0";
      scoreOutput+=score;
      String highScoreOutput = "";
      for (int i = (int)Math.log10(this.highScore+1)+1;i<6;i++)
         highScoreOutput+="0";
      highScoreOutput+=highScore;
      String bonusOutput = "";
      for (int i = (int)Math.log10(this.bonus+1)+1; i<4; i++)
         bonusOutput+=" ";
      bonusOutput+=bonus;
      g2.drawString(scoreOutput, 10, 50);
      g2.drawString(highScoreOutput, PREF_W/2-highScoreOutput.length()*11, 50);
      if (showBonus){
         g2.drawImage(bonusBoard, (int)(SECTION_W*10.5), 100, SECTION_W*3, (int)(SECTION_W*1.5),null);
         g2.setColor(primaryColor);
         g2.drawString(bonusOutput, (int)(SECTION_W*10.5)+33, 175-20);
      }
      int firstLifeX = 10, spacing = 25;
      for (int i = 0; i<lives; i++){
         g2.drawImage(LIFE_IMAGE, firstLifeX+spacing*i, 55, spacing, spacing, null);
      }
      
      g2.setColor(Color.BLUE);
      g2.drawString("L=0"+level, (int)(SECTION_W*10.5), 75);
   }

   public BufferedImage getBodyImage(){
      return bodyImage;
   }
   
   public void setHeader(int lives, int score, int highScore, int level){
      this.lives = lives;
      this.score = score;
      this.highScore = highScore;
      this.level = level;
      repaintHeader();
   }
   
   public ArrayList<Platform> getPlatforms() {
      return platforms;
   }

   public void setPlatforms(ArrayList<Platform> platforms) {
      this.platforms = platforms;
      }

   public ArrayList<Ladder> getLadders() {
      return ladders;
   }

   public void setLadders(ArrayList<Ladder> ladders) {
      this.ladders = ladders;
   }
   public int getPREF_W() {
      return PREF_W;
   }
   public void setPREF_W(int PREF_W) {
      this.PREF_W = PREF_W;
   }
   public int getPREF_H() {
      return PREF_H;
   }
   public void setPREF_H(int PREF_H) {
      this.PREF_H = PREF_H;
   }
   public int getLives() {
      return lives;
   }
   public void setLives(int lives) {
      this.lives = lives;
      repaintHeader();
   }
   public int getScore() {
      return score;
   }
   public void setScore(int score) {
      this.score = score;
      repaintHeader();
   }
   public int getHighScore() {
      return highScore;
   }
   public void setHighScore(int highScore) {
      this.highScore = highScore;
      repaintHeader();
   }
   public int getLevel() {
      return level;
   } 
   public void setLevel(int level) {
      this.level = level;
      repaintHeader();
   }
   public BufferedImage getHeader() {
      return header;
   }
   public int getBonus() {
      return bonus;
   }
   public void setBonus(int bonus) {
      this.bonus = bonus;
      repaintHeader();
   }
   public Color getPrimaryColor() {
      return primaryColor;
   }
   public void setPrimaryColor(Color primaryColor) {
      this.primaryColor = primaryColor;
      repaint();
   }
   public Color getSecondaryColor() {
      return secondaryColor;
   }
   public void setSecondaryColor(Color secondaryColor) {
      this.secondaryColor = secondaryColor;
      repaint();
   }
   public boolean isShowBonus() {
      return showBonus;
   }
   public void setShowBonus(boolean showBonus) {
      this.showBonus = showBonus;
   }
   public String getLabel() {
      return label;
   }
   public void setLabel(String label) {
      this.label = label;
   }
}
