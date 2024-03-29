import java.io.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * things to ask
 * textbox
 *    JEditorPane
 *    URL input
 *    then also how to overlay it onto the jframe
 * that will bring up a new gui class, so you need to do that. 
 * parent/child interaction
 *    i want a shape/block to know their parent
 */

/**
 * Similar to the old arcade game. Falling pieces, or {@link TetrisShapes} move down 
 * and the user must use the arrow keys to navigate them into place on the board.
 * The user can see which three next blocks are coming up next. There is a <code>hold</code> function
 * implemented to store one block for later.
 * <p>
 * {@link TetrisShapes} are essentially {@link ArrayList}s of {@link TetrisBlock}s, but are in charge of 
 * everything involving the shape. </br>
 * The game is built on a <code>2D Array</code> of {@link Location}s, which are points holding an x, y, color, 
 * and fullness attribute. The Shapes check if each <code>Location</code> is <code>full</code> 
 * and reacts to the information by restricting the user to certain movements.
 * </p>
 * 
 * @author Thomas Varano
 *
 */
public class Tetris extends JPanel
      implements
         MouseListener,
         MouseMotionListener,
         KeyListener,
         ActionListener
{
   private static final long serialVersionUID = 1L;
   public static final int PREF_W = 1000;
   public static final int PREF_H = 800;
   public final int MIN_PLAY_R = 5;
   public final int MAX_PLAY_R = 21;
   public final int MIN_PLAY_C = 3;
   public final int MAX_PLAY_C = 12;
   private long counter = 0;
   private RenderingHints hints = new RenderingHints(
         RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   private Timer timer = new Timer(5, this);
   private Font testFont = new Font("Prestige Elite Std", Font.PLAIN, 10);
   public static Font font = new Font("Prestige Elite Std", Font.PLAIN, 50);
   public static Font smallFont = font.deriveFont((float) 20.0);
   public static Color background = new Color(50,50,50);
   public static Rectangle nextBoard = new Rectangle(700, 50, 180, 300);
   public static Rectangle nextBoardInlay = new Rectangle(710, 60, 160, 280);
   public static Rectangle holdBoard = new Rectangle(490, 50, 180, 180);
   public static Rectangle pauseCover = new Rectangle(0, 0, PREF_W, PREF_H);
   
   private boolean initGame, pause, holding;
   private TetrisShapes nextShapeOne, nextShapeTwo, nextShapeThree, playerShape, holdShape;
   private BlockPresets presetter;
   private int inputPacer, score, highScore;
   public Location[][] grid, nextShapeGrid, holdGrid;
   private Location nextTwo, nextThree;
   private Random random;
   public String highScoreFile = System.getProperty("user.home")+"/Documents/TetrisHighScore.txt";
   private String highScoreUser;
   private ArrayList<Integer> linesToRemove;

   public Tetris() {
      this.addMouseListener(this);
      this.addMouseMotionListener(this);
      this.addKeyListener(this);
      setFocusable(true);
      this.setBackground(background);
      this.setForeground(Color.CYAN);
      grid = new Location[24][16];
      holdGrid = new Location[5][4];
      nextShapeGrid = new Location[5][4];
      initGrid();
      nextTwo = new Location(nextShapeGrid[3][1].getX(), nextShapeGrid[3][1].getY()+55);
      nextThree = new Location(nextShapeGrid[3][1].getX(), nextShapeGrid[3][1].getY()+110);
      inputPacer = score = 0;
      presetter = new BlockPresets(grid, 40, 100);
      random = new Random();
      holdShape = null;
      linesToRemove = new ArrayList<Integer>();
      initGame = holding = false;
      timer.start();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHints(hints);
      g2.setFont(font);
      g2.setColor(getForeground());
      if(initGame){
         g2.fill(nextBoard);
         g2.setColor(Color.WHITE);
         g2.fill(nextBoardInlay);
         g2.setColor(getForeground());
         g2.drawString("Next", (int)nextBoard.getX()+30, (int)nextBoard.getMaxY()+40);
         g2.fill(holdBoard);
         g2.drawString("Hold", (int)holdBoard.getX()+30, (int)holdBoard.getMaxY()+40);
         for (int i = MIN_PLAY_R; i < MAX_PLAY_R+1; i++) {   
            for (int j = MIN_PLAY_C; j <= MAX_PLAY_C; j++) {
               grid[i][j].draw(g2);
            }
         }
         
         g2.setFont(testFont);
/*
         for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
               g2.setColor(Color.GREEN);
               if (grid[i][j].isFull())
                  g2.setColor(Color.RED);
               g2.drawRect(grid[i][j].getX(), grid[i][j].getY(), 40, 40);
               g2.drawString(i + "," + j, grid[i][j].getX(),
                     grid[i][j].getY() + 15);
            }
         }
         
         g2.setColor(Color.GREEN);
         for (int i = 0; i < nextShapeGrid.length; i++) {
            for (int j = 0; j < nextShapeGrid[i].length; j++) {
               g2.drawRect(nextShapeGrid[i][j].getX(), nextShapeGrid[i][j].getY(),
                     40, 40);
               g2.drawString(i + "," + j, nextShapeGrid[i][j].getX(),
                     nextShapeGrid[i][j].getY() + 15);
            }
         }
         for (int i = 0; i < holdGrid.length; i++) {
            for (int j = 0; j < holdGrid[i].length; j++) {
               g2.drawRect(holdGrid[i][j].getX(), holdGrid[i][j].getY(),
                     40, 40);
               g2.drawString(i + "," + j, holdGrid[i][j].getX(),
                     holdGrid[i][j].getY() + 15);
            }
         }
*/

         for (int i = 0; i<nextShapeGrid.length; i++){
            for (int j = 0; j<nextShapeGrid[i].length; j++){
               nextShapeGrid[i][j].draw(g2);
               if (i<4)
                  holdGrid[i][j].draw(g2);
            }
         }
         
         if (holdShape!=null)
            holdShape.still(1,1,holdGrid, g2);
         nextShapeOne.still(1,1, nextShapeGrid, g2);
         nextTwo.draw(g2);
         nextThree.draw(g2);
         playerShape.draw(g2);
         
         g2.setFont(font);
         g2.setColor(Color.WHITE);
         g2.drawString("Score: "+score, 500, 500);
      } else if (!initGame) {
//         g2.setFont(font);
//         g2.drawString("Welcome to Tetris", PREF_W/2-260, 100);
//         g2.drawString("by Thomas Varano", PREF_W/2-245, 200);
//         g2.fill(startButton);
//         g2.setColor(Color.BLACK);
//         g2.drawString("Click Here", (int)startButton.getX()+15, (int)(startButton.getY()+60));
//         g2.drawString("To Play", (int)startButton.getX()+15, (int)(startButton.getY()+150));
      }
      if (isGameOver()) {
         g2.setColor(new Color(100,100,100,240));
         g2.fill(pauseCover);
         g2.setColor(getForeground());
         g2.drawString("Game Over", PREF_W/2-139, PREF_H/2-100);
         g2.drawString("Score: "+score, PREF_W/2-139, PREF_H/2-25);
         g2.drawString("High Score:", PREF_W/2-139, PREF_H/2+40);
         if((highScoreUser.length()+6)*31>PREF_W)
            g2.setFont(new Font("Prestige Elite Std", Font.PLAIN, 20));
         g2.drawString(highScoreUser+"- "+highScore, 
               PREF_W/2-highScoreUser.length()*g2.getFont().getSize()/2
               , PREF_H/2+100);
         g2.setFont(font);
      } else if (pause) {
         g2.setColor(new Color(100,100,100,240));
         g2.fill(pauseCover);
         g2.setColor(getForeground());
         g2.drawString("PAUSE", PREF_W/2-75, PREF_H/2);
         g2.drawString("Press Enter to Restart", PREF_W/2-341, PREF_H/2+40);
      }
   }

   public void initGrid() {
      for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[i].length; j++) {
            grid[i][j] = new Location(j * 40 - 50, i * 40 - 130);
         }
      }
      for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[i].length; j++) {
            grid[i][MIN_PLAY_C-3].setFull(true);
            grid[i][MIN_PLAY_C-2].setFull(true);
            grid[i][MIN_PLAY_C-1].setFull(true);
            grid[i][MAX_PLAY_C+1].setFull(true);
            grid[i][MAX_PLAY_C+2].setFull(true);
            grid[i][MAX_PLAY_C+3].setFull(true);
            if (i == 21) {
               grid[MAX_PLAY_R+1][j].setFull(true);
               grid[MAX_PLAY_R+2][j].setFull(true);
            }
         }
      }
      for (int i = 0; i<nextShapeGrid.length; i++){
         for (int j = 0; j<nextShapeGrid[i].length;j++){
            nextShapeGrid[i][j] = new Location(
                  j * 40 + (int)nextBoard.getX()+10, i * 40 +(int)nextBoard.getY()+10);
            holdGrid[i][j] = new Location(
                  j * 40 + (int)holdBoard.getX()+10, i * 40 +(int)holdBoard.getY()+10);
         }
      }
   }
   public boolean isInitGame() {
      return initGame;
   }
   public void setInitGame(boolean initGame){
      this.initGame = initGame;
   }
   public Location[][] getGrid() {
      return grid;
   }
   public void setGrid(Location[][] grid) {
      this.grid = grid;
   }
   public Location[][] getNextShapeGrid() {
      return nextShapeGrid;
   }
   public void setNextShapeGrid(Location[][] grid) {
      nextShapeGrid = grid;
   }

   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

//   private static void createAndShowGUI() {
//      JFrame frame = new JFrame("Tetris");
//      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      frame.getContentPane().add(new Tetris());
//      frame.pack();
//      frame.setLocationRelativeTo(null);
//      frame.setVisible(true);
//      frame.setResizable(false);
//   }

   public TetrisShapes intToShape(int a) {
      switch (a) {
         case 0 :
            return presetter.getIBlock(4,7);
         case 1 :
            return presetter.getLBlock(4,7);
         case 2 :
            return presetter.getJBlock(4,7);
         case 3 :
            return presetter.getOBlock(4,7);
         case 4 :
            return presetter.getZBlock(4,7);
         case 5 :
            return presetter.getTBlock(4,7);
         case 6 :
            return presetter.getSBlock(4,7);
         default :
            return null;
      }
   }
   
   public int shapeToInt(TetrisShapes s){
      if(s.labelEquals(presetter.getIBlock(0, 0).getLabel()))
         return 0;
      else if(s.labelEquals(presetter.getLBlock(0, 0).getLabel()))
         return 1;
      else if(s.labelEquals(presetter.getJBlock(0, 0).getLabel()))
         return 2;
      else if(s.labelEquals(presetter.getOBlock(0, 0).getLabel()))
         return 3;
      else if(s.labelEquals(presetter.getZBlock(0, 0).getLabel()))
         return 4;
      else if(s.labelEquals(presetter.getTBlock(0, 0).getLabel()))
         return 5;
      else if(s.labelEquals(presetter.getSBlock(0, 0).getLabel()))
         return 6;
      return 10;
   }

   public void init() {
      nextShapeOne = intToShape(random.nextInt(7));
      nextShapeTwo = intToShape(random.nextInt(7));
      nextShapeThree = intToShape(random.nextInt(7));
      playerShape = intToShape(random.nextInt(7));
      holdShape = null;
   }

   public void addNew() {
      playerShape = nextShapeOne;
      playerShape.stillToUpdate();
      nextShapeOne = nextShapeTwo;
      nextShapeTwo = nextShapeThree;
      nextShapeThree = intToShape(random.nextInt(7));
   }

   public void update() {
      if(initGame){
         if (counter == 0) {
            init();
            counter++;
         } else {
            if(!isGameOver() && !pause){
               playerShape.update();
               nextShapeOne.setGrid(nextShapeGrid);
                  
               if (!playerShape.isMoveableDown()) {
                  playerShape.collide();
                  if(playerShape.isCollided())
                     addNew();
               }
               lineIsClear();
               clearLine();
               nextTwo.setColor(nextShapeTwo.getColor());
               nextThree.setColor(nextShapeThree.getColor());
            } else
               endGame();
         }
      }
   }
   
   public void lineIsClear() {
      for (int i = 0; i < grid.length-2; i++) 
         for (int j = 0; j < grid[i].length; j++) {
            if (!grid[i][j].isFull()) {
               break;
            } else {
               if (j == grid[i].length - 1) {
                  linesToRemove.add(i);
                  System.out.println("CLEAR THE LINE "+i);
               } else
                  continue;
            }
         }
   }

   public void clearLine() {      
      if(!linesToRemove.isEmpty()){
         for (int i = 0; i<linesToRemove.size(); i++)
            for (int j = linesToRemove.get(i); j>1; j--)
               for (int k = MIN_PLAY_C; k<MAX_PLAY_C+1; k++){
                  grid[j][k].setColor(grid[j-1][k].getColor());
                  grid[j][k].setFull(grid[j-1][k].isFull());
               }
            
            int newScore = 100*(3*(linesToRemove.size()-1)+1);
            score += newScore;
            System.out.println(score);
         System.out.println("CLEARINGGGG");
         linesToRemove.clear();
      }
   }
   
   public void reset(){
      initGame = false;
      holding = false;
      initGrid();
      init();
      counter = 0;
      score = 0; 
   }
   
   public boolean isGameOver(){
      for(int i = MIN_PLAY_C; i<=MAX_PLAY_C; i++)
         if (grid[5][i].isFull())
            return true;
      return false;
   }
   
   public void endGame(){
      readHighScore();
      setScores();
      System.out.println(score+":"+highScore);
      System.out.println(highScoreUser);
   }
   
   public void hold(){
      if(!holding){
         System.out.println("addingHold");
         holdShape = playerShape;
         playerShape = nextShapeOne;
         nextShapeOne = nextShapeTwo;
         nextShapeTwo = nextShapeThree;
         nextShapeThree = intToShape(random.nextInt(7));
         holding = true;
      } else {
         System.out.println("takingHold");
         System.out.println(holdShape);
         nextShapeThree = nextShapeTwo;
         nextShapeOne.stillToUpdate();
         nextShapeTwo = nextShapeOne;
         nextShapeOne = playerShape;
         playerShape = holdShape;
         holdShape = null;
         holding = false;
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
         dataGetter.nextLine();
         highScoreUser = dataGetter.nextLine();

      }
      catch (FileNotFoundException e){
         System.out.println("Creating high score file.");
         try
         {
            PrintWriter pw = new PrintWriter(new FileWriter(highScoreFile, false));
            pw.println(0);
            pw.close();
         } catch (IOException e1){e1.printStackTrace();}
      }
   }

   public void setScores()
   {
      if(score>highScore){
         highScore = score;
         String userName = (String)JOptionPane.showInputDialog(null, "You got a High Score!\nWrite your name.",
               "High Score!",
               JOptionPane.PLAIN_MESSAGE,
               null,
               null,
               "----");
         try
         {
            System.out.println("Writing high score.");
            PrintWriter pw = new PrintWriter(new FileWriter(highScoreFile, false));
            pw.println(highScore);
            pw.println(userName);
            pw.close();
         } catch (IOException e1){e1.printStackTrace();}
      }
   }
   
//   public static void main(String[] args) {
//      SwingUtilities.invokeLater(new Runnable() {
//         public void run() {
//            createAndShowGUI();
//         }
//      });
//      new Tetris();
//   }

   @Override
   public void mouseDragged(MouseEvent e) {
      System.out.println("dragging the mouse");
   }

   @Override
   public void mouseMoved(MouseEvent e) {
   }

   @Override
   public void mouseClicked(MouseEvent e) {
//      if(!initGame){
//         initGame = (startButton.contains(e.getPoint()));
//      }
   }

   @Override
   public void mousePressed(MouseEvent e) {
      System.out.println("pressing the mouse");
   }

   @Override
   public void mouseReleased(MouseEvent e) {
   }

   @Override
   public void mouseEntered(MouseEvent e) {
   }

   @Override
   public void mouseExited(MouseEvent e) {
   }

   @Override
   public void keyTyped(KeyEvent e) {
   }

   @Override
   public void keyPressed(KeyEvent e) {
      System.out.println("GAME");
      int key = e.getKeyCode();
      if(initGame){
         if (!isGameOver()){
            if(!pause){
               if (key == KeyEvent.VK_RIGHT) {
                  playerShape.setRight(true);
               } else if (key == KeyEvent.VK_LEFT) {
                  playerShape.setLeft(true);
               }
               if (inputPacer == 0) {
                  if (key == KeyEvent.VK_UP) {
                     playerShape.setRotate(true);
                     inputPacer = 1;
                  } else if (key == KeyEvent.VK_ENTER){
                     hold();
                     inputPacer = 1;
                  }
               }
               if (key == KeyEvent.VK_DOWN) 
                  playerShape.setSpeedUp(true);
               else if (key == KeyEvent.VK_SPACE)
                  playerShape.setDropped(true);
            } else {
               if (key == KeyEvent.VK_ENTER){
                  pause = false;
                  endGame();
                  reset();
               }
            }
            if (key == KeyEvent.VK_ESCAPE)
               pause = !pause;
         }
         else{
            if (key == KeyEvent.VK_SPACE)
               reset();
         }
      }
   }

   @Override
   public void keyReleased(KeyEvent e) {
      int key = e.getKeyCode();
      if(initGame){
         if (key == KeyEvent.VK_RIGHT)
            playerShape.setRight(false);
         else if (key == KeyEvent.VK_LEFT)
            playerShape.setLeft(false);
        
         if (key == KeyEvent.VK_UP || key == KeyEvent.VK_ENTER) 
            inputPacer = 0;
         if (key == KeyEvent.VK_DOWN) 
            playerShape.setSpeedUp(false);
      }
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      update();
      repaint();
   }
}