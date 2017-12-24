import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//Thomas Varano
//[Program Descripion]
//Mar 1, 2017

public class CutsceneNPC
{
   private final int RIGHT = 0, LEFT = 1, STILL = 2;
   public static final int AMOUNT_SHEET = 5;
   private int direction, trigger;
   private double x, y,width,height,dx,dy, maxSpeed;
   private boolean jumping, falling, doneWorking,commandsDone;
   private Color color;
   private BufferedImage[] stillSheet, horizontalSheet, jumpSheet, verticalSheet, specialSheet;
   private final BufferedImage[] defaultSheet = {LevelOne.DEFAULT_SKIN};
   private Animation animator;
   private BufferedImage sheet;
   private Scanner reader;
   private File script;
   private Command[] commands;
   private double gravity;
      
   public CutsceneNPC(double x, double y, double width, double height, double maxSpeed, File script){
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.setMaxSpeed(maxSpeed);
      jumping = falling = false;
      commandsDone = true;
      animator = new Animation(100);
      this.setScript(script);
      try {
         reader = new Scanner(script);
      } catch (FileNotFoundException e) {
         System.err.println("ERROR: UNABLE TO READ SCRIPT");
         doneWorking = true;
      } catch (NullPointerException e) {
         System.err.println("ERROR: SCRIPT = NULL");
         doneWorking = true;
      }
      BufferedImage[] defArray = {Level.DEFAULT_SKIN};
      stillSheet = horizontalSheet = jumpSheet = verticalSheet = specialSheet = defArray;
      animator.setFrames(defArray);
   }
   
   public void jump(double jumpForce, double stopY, int index){
      if(!commands[index].isDoneSwitch()){
         if(!falling){
            dy -=jumpForce;
            falling = true;
         }
         else{
            dy+=gravity;
         }
         if (y>=stopY && dy>0){
            dy = 0;
            y = stopY;
            falling = false;
            commands[index].setDone(true);
         }
         y+=dy;
      }
   }
   
   private void moveVertical(double distance, long ticksTiming, int index){
      dy = distance/ticksTiming;
      if (!commands[index].isDoneTicks()){
         commands[index].addTick();
         y+=dy;
      }
      else{
         dy = 0;
      }
   }
   
   private void moveHorizontal(double distance, long ticksTiming, int index){
      dx = distance/ticksTiming;
      if (!commands[index].isDoneTicks ()){
         commands[index].addTick();
         x+=dx;
      }
      else{
         dx = 0;
      }
   }
   
   public boolean isAnimating(){
//      System.out.println(stillSheet+","+horizontalSheet+","+jumpSheet+","+verticalSheet+","+specialSheet);
      return(stillSheet!=null && horizontalSheet!=null && jumpSheet!=null && verticalSheet!=null);
   }
   
   public void update(){
       if (commandsDone){
         if (reader.hasNextLine()){
            commands = getCommandArray(reader.nextLine());
            System.out.println("\tarray retrieval successful");
            dy = dx = 0;
            commandsDone = false;
         }
      }
      else{
         executeCommands(commands);
      }
      if (!reader.hasNextLine()){
         doneWorking = true;
      }
      if (isAnimating())
         animator.update() ;
   }
   public static Command[] getCommandArray(String commandString){
      System.out.println("getting command array...");
      int currentAmountSteps = -1;
      int[] punctuationIndex;
      int currentIndex = 0;
      String[] commandStringArray;
      for (char currentChar : commandString.toCharArray()){
         if(currentChar == ';' || currentChar == '*' || currentChar == '$'){
            currentAmountSteps++;
         }
      }
      punctuationIndex = new int[currentAmountSteps+1];
      for (int i = 0; i<commandString.toCharArray().length; i++){
         if (commandString.toCharArray()[i] == ';' ||
               commandString.toCharArray()[i] == '*' ||
               commandString.toCharArray()[i] == '$'){
            punctuationIndex[currentIndex] = i;
            currentIndex++;
         }
      }
      currentIndex = 0;
      commandStringArray = new String[currentAmountSteps];
      Command[] commandArray = new Command[currentAmountSteps];
      for (int i = 0; i<currentAmountSteps; i++){
         commandStringArray[i] = commandString.substring(
               punctuationIndex[currentIndex],punctuationIndex[currentIndex+1]);
         currentIndex++;
      }
      
      String currentString;
      for (int i = 0; i<commandStringArray.length; i++){
         currentString = commandStringArray[i];
         if (currentString.charAt(0) == '*'){
            commandArray[i] = new Command(currentString.substring(1, currentString.indexOf('(')),
                  Double.parseDouble(currentString.substring(currentString.indexOf('(')+1, 
                        currentString.indexOf(','))),
                  Double.parseDouble(currentString.substring(currentString.indexOf(',')+1)));
         }
         else if (currentString.charAt(0) == '$'){
            commandArray[i] = new Command(currentString.substring(1, currentString.indexOf('(')),
                  currentString.substring(currentString.indexOf('(')+1));
         }
         else if (currentString.charAt(0) ==';'){
            commandArray[i] = new Command(currentString.substring(1, currentString.indexOf('(')),
                  Double.parseDouble(currentString.substring(currentString.indexOf('(')+1, 
                        currentString.indexOf(','))),
                  Long.parseLong(currentString.substring(currentString.indexOf(',')+1)));
         }
      }
      return commandArray;
   }  
   
   private void executeCommands(Command[] commandArray){
      for(int i = 0; i<commandArray.length; i++){
         if (!commandArray[i].isDone())
            readAndExecuteCommand(commandArray[i], i);
      }
      for (int i = 0; i<commandArray.length; i++){
         if (!commandArray[i].isDoneSwitch() && !commandArray[i].isDoneTicks()){
            commandsDone = false;
            break;
         }
         else{
            if (i == commandArray.length-1)
               commandsDone = true;
         }
      }
   }
  
   public void readAndExecuteCommand(Command c, int index){
      if (c.getLabel().equals("vertical")){
         moveVertical(c.getParameterOne(),c.getMillisTiming(),index);
      }
      else if(c.getLabel().equals("horizontal")){
         moveHorizontal(c.getParameterOne(),c.getMillisTiming(),index);
      }
      else if(c.getLabel().equals("jump")){
         jump(c.getParameterOne(),c.getParameterTwo(),index);
      }
      else if (c.getLabel().equals("switchSheet")){
         animator.setFrames(switchForSheet(c.getStringParam()));
         commands[index].setDone(true);
      }
      else if (c.getLabel().equals("setTrigger")){
         trigger = Integer.parseInt(c.getStringParam());
         commands[index].setDone(true);
      }
      else{
         System.out.println("IMPROPPER COMMAND");
         doneWorking = true;
      }
   }
   
   public BufferedImage[] switchForSheet(String sheet){
      if (isAnimating()){
         System.out.println("sheet:" + sheet);
         switch (sheet){
            case "still" : {
               animator.setRunBackwards(false);
               direction = STILL;
               return stillSheet;
            }
            case "left" : {
               animator.setRunBackwards(false);
               direction = LEFT;
               return horizontalSheet;
            }
            case "right" : {
               animator.setRunBackwards(false);
               direction = RIGHT;
               return horizontalSheet;
            }
            case "jump" : {
               animator.setRunBackwards(false);
               direction = STILL;
               return jumpSheet;
            }
            case "up" : {
               animator.setRunBackwards(false);
               direction = STILL;
               return verticalSheet;
            }
            case "down" : { 
               animator.setRunBackwards(true);
               direction = STILL;
               return verticalSheet;
            }
            case "special" : {
               animator.setRunBackwards(true);
               direction = STILL;
               return specialSheet;
            }
            default : {
               animator.setRunBackwards(true);
               direction = STILL;
               return defaultSheet;
            }
         }
      }
      return defaultSheet;
   }
   
   public void draw(Graphics2D g2){
      if(isAnimating()){
         if (direction == RIGHT || direction == STILL)
            g2.drawImage(animator.getImage(),(int)x,(int)y,(int)width,(int)height,null);
         else if (direction == LEFT)
            g2.drawImage(animator.getImage(),(int)x,(int)(y+width),(int)-width,(int)height,null);
      }
      else
         g2.fill(getBounds());
   }
   
   public Rectangle getBounds(){
      return new Rectangle((int)x,(int)y,(int)width,(int)height);
   }
   
   public double getX() {
      return x;
   }
   public void setX(double x) {
      this.x = x;
   }
   public double getY() {
      return y;
   }
   public void setY(double y) {
      this.y = y;
   }
   public double getWidth() {
      return width;
   }
   public void setWidth(double width) {
      this.width = width;
   }
   public double getHeight() {
      return height;
   }

   public BufferedImage[] getStillSheet() {
      return stillSheet;
   }

   public void setStillSheet(BufferedImage[] stillSheet) {
      this.stillSheet = stillSheet;
   }

   public BufferedImage[] getWalkSheet() {
      return horizontalSheet;
   }

   public void setWalkSheet(BufferedImage[] horizontalSheet) {
      this.horizontalSheet = horizontalSheet;
   }

   public BufferedImage[] getJumpSheet() {
      return jumpSheet;
   }

   public void setJumpSheet(BufferedImage[] jumpSheet) {
      this.jumpSheet = jumpSheet;
   }

   public BufferedImage[] getVerticalSheet() {
      return verticalSheet;
   }

   public void setVerticalSheet(BufferedImage[] verticalSheet) {
      this.verticalSheet = verticalSheet;
   }

   public void setHeight(double height) {
      this.height = height;
   }
   public double getDx() {
      return dx;
   }
   public void setDx(double dx) {
      this.dx = dx;
   }
   public double getDy() {
      return dy;
   }
   public void setDy(double dy) {
      this.dy = dy;
   }
   public boolean isJumping() {
      return jumping;
   }
   public void setJumping(boolean jumping) {
      this.jumping = jumping;
   }
   public boolean isFalling() {
      return falling;
   }
   public void setFalling(boolean falling) {
      this.falling = falling;
   }
   public Color getColor() {
      return color;
   }
   public void setColor(Color color) {
      this.color = color;
   }
   public double getMaxSpeed() {
      return maxSpeed;
   }
   public void setMaxSpeed(double maxSpeed) {
      this.maxSpeed = maxSpeed;
   }
   public BufferedImage getSheet() {
      return sheet;
   }
   public void setSheet(BufferedImage sheet) {
      this.sheet = sheet;
   }
   public boolean isDoneWorking() {
      return doneWorking;
   }
   public void setDoneWorking(boolean doneWorking) {
      this.doneWorking = doneWorking;
   }
   public File getScript() {
      return script;
   }
   public void setScript(File script) {
      this.script = script;
   }
   public double getGravity() {
      return gravity;
   }
   public void setGravity(double gravity) {
      this.gravity = gravity;
   }

   public int getTrigger() {
      return trigger;
   }

   public void setTrigger(int trigger) {
      this.trigger = trigger;
   }

   public BufferedImage[] getHorizontalSheet() {
      return horizontalSheet;
   }

   public void setHorizontalSheet(BufferedImage[] horizontalSheet) {
      this.horizontalSheet = horizontalSheet;
   }

   public BufferedImage[] getSpecialSheet() {
      return specialSheet;
   }

   public void setSpecialSheet(BufferedImage[] specialSheet) {
      this.specialSheet = specialSheet;
   }
   public Animation getAnimator() {
      return animator;
   }
}
