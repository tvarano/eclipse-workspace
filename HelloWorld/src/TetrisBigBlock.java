import java.awt.Color;
import java.util.ArrayList;

//Thomas Varano
//[Program Descripion]
//Dec 26, 2016

public class TetrisBigBlock
{
    private int x, y, dx, blockAmount, blockSize;
    public short position;
    private double speed, fastSpeed;
    private boolean left, right, speedUp, rotate;
    private ArrayList<TetrisBlock> blocks;
    private String label;
    private Color color;
    
    public TetrisBigBlock(int x, int y, int blockAmount, double speed){
       this.x = x;
       this.y = y;
       this.speed = speed;
       this.fastSpeed = speed + 10;
       setBlocks(new ArrayList<TetrisBlock>());
       left = right = speedUp = rotate = false;
       setLabel("");
       this.blockAmount = blockAmount;
       position = 0;
       dx = blockSize;
    }
    
    public void init(){
       for (int i = 0; i<blockAmount; i++){
          blocks.add(new TetrisBlock(x,y,blockSize,speed));
       }
       for(int i = 0; i<blocks.size(); i++){
          blocks.get(i).setSpeed(speed);
          blocks.get(i).setFastSpeed(fastSpeed);
          blocks.get(i).setDx(dx);
          blocks.get(i).setColor(color);
          blocks.get(i).setBlockSize(blockSize);
       }
    }
    
    public void update(){
       if (position == 4)
          setPosition((short) 0);
       for (int i = 0; i<blocks.size(); i++){
          if (right){
             blocks.get(i).setLeft(false);
             blocks.get(i).setRight(true);
          }
          else if (left){
             blocks.get(i).setRight(false);
             blocks.get(i).setLeft(true);
          }
          if (speedUp){
             blocks.get(i).setSpeedUp(true);
          }
          else
             blocks.get(i).setSpeedUp(false);
          
          blocks.get(i).update();
          
          if(rotate){
             if (position == 0){
                blocks.get(i).setX(blocks.get(i).getX()+(this.blockSize*i));
                blocks.get(i).setY(blocks.get(i).getY()+(this.blockSize*i));
                position++;
             }
             if (position == 1){
                blocks.get(i).setX(blocks.get(i).getX()-(this.blockSize*i));
                blocks.get(i).setY(blocks.get(i).getY()+(this.blockSize*i));
                position++;
             }
             if (position == 2){
                blocks.get(i).setX(blocks.get(i).getX()-(this.blockSize*i));
                blocks.get(i).setY(blocks.get(i).getY()-(this.blockSize*i));
                position++;
             }
             if (position == 3){
                blocks.get(i).setX(blocks.get(i).getX()+(this.blockSize*i));
                blocks.get(i).setY(blocks.get(i).getY()-(this.blockSize*i));
                position++;
             }
          }
       }
    }
    
    public int getX() {
       return x;
    }
    public void setX(int x) {
       this.x = x;
    }
    public int getY() {
       return y;
    }
    public void setY(int y) {
       this.y = y;
    }
    public double getSpeed() {
       return speed;
    }
    public void setSpeed(double speed) {
       this.speed = speed;
    }
    public double getFastSpeed() {
       return fastSpeed;
    }
    public void setFastSpeed(double fastSpeed) {
       this.fastSpeed = fastSpeed;
    }
    public boolean isLeft() {
       return left;
    }
    public void setLeft(boolean left) {
       this.left = left;
    }
    public boolean isRight() {
       return right;
    }
    public void setRight(boolean right) {
       this.right = right;
    }
    public boolean isSpeedUp() {
       return speedUp;
    }
    public void setSpeedUp(boolean speedUp) {
       this.speedUp = speedUp;
    }
   public String getLabel() {
      return label;
   }

   public void setLabel(String label) {
      this.label = label;
   }

   public ArrayList<TetrisBlock> getBlocks() {
      return blocks;
   }

   public void setBlocks(ArrayList<TetrisBlock> blocks) {
      this.blocks = blocks;
   }

   public Color getColor() {
      return color;
   }

   public void setColor(Color color) {
      this.color = color;
   }

   public int getBlockSize() {
      return blockSize;
   }

   public void setBlockSize(int blockSize) {
      this.blockSize = blockSize;
   }

   public boolean isRotate() {
      return rotate;
   }

   public void setRotate(boolean rotate) {
      this.rotate = rotate;
   }

   public int getPosition() {
      return position;
   }

   public void setPosition(short position) {
      this.position = position;
   }
}
