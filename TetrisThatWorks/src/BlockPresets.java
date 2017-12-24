import java.awt.Color;

//Thomas Varano
//[Program Descripion]
//Jan 3, 2017
/**
 * A simple object creating the standard shapes for {@link Tetris}
 * 
 * @author varanoth
 */
public class BlockPresets
{
   private Location[][] grid;
   private int blockSize, resetTime; 
   public BlockPresets(Location[][] grid, int blockSize, int resetTime){
      this.grid = grid;
      this.blockSize = blockSize;
      this.resetTime = resetTime;
   }
   
   public TetrisShapes getIBlock(int r, int c){
      TetrisShapes block = new TetrisShapes(r,c,4);
      block.setGrid(grid);
      block.setBlockSize(blockSize);
      block.setLabel("Straight");
      block.setColor(Color.ORANGE);
      block.setResetTime(resetTime);
      block.setMaxRotation(2);
      block.init();
      block.getBlocks().get(1).setRFromCenter(-1);
      block.getBlocks().get(2).setRFromCenter(1);
      block.getBlocks().get(3).setRFromCenter(2);
      return block;
   }
   
   public TetrisShapes getLBlock(int r, int c){
      TetrisShapes block = new TetrisShapes(r,c,4);
      block.setGrid(grid);
      block.setBlockSize(blockSize);
      block.setLabel("J Block");
      block.setColor(Color.BLUE);
      block.setResetTime(resetTime);
      block.init();
      block.getBlocks().get(1).setCFromCenter(-1);
      block.getBlocks().get(1).setRFromCenter(-1);
      block.getBlocks().get(2).setRFromCenter(-1);
      block.getBlocks().get(3).setRFromCenter(1);
      return block;
   }
   
   public TetrisShapes getJBlock(int r, int c){
      TetrisShapes block = new TetrisShapes(r,c,4);
      block.setGrid(grid);
      block.setBlockSize(blockSize);
      block.setLabel("L Block");
      block.setColor(new Color(204,0,255));
      block.setResetTime(resetTime);
      block.init();
      block.getBlocks().get(1).setCFromCenter(1);
      block.getBlocks().get(1).setRFromCenter(-1);
      block.getBlocks().get(2).setRFromCenter(-1);
      block.getBlocks().get(3).setRFromCenter(1);
      return block;
   }
   
   public TetrisShapes getOBlock(int r, int c){
      TetrisShapes block = new TetrisShapes(r,c,4);
      block.setGrid(grid);
      block.setBlockSize(blockSize);
      block.setLabel("O Block");
      block.setColor(Color.DARK_GRAY);
      block.setResetTime(resetTime);
      block.setMaxRotation(0);
      block.init();
      block.getBlocks().get(1).setCFromCenter(1);
      block.getBlocks().get(2).setRFromCenter(1);
      block.getBlocks().get(3).setCFromCenter(1);
      block.getBlocks().get(3).setRFromCenter(1);
      return block;
   }
   
   public TetrisShapes getZBlock(int r, int c){
      TetrisShapes block = new TetrisShapes(r,c,4);
      block.setGrid(grid);
      block.setBlockSize(blockSize);
      block.setLabel("Z Block");
      block.setColor(Color.CYAN);
      block.setResetTime(resetTime);
      block.setMaxRotation(2);
      block.init();
      block.getBlocks().get(1).setCFromCenter(1);
      block.getBlocks().get(2).setRFromCenter(1);
      block.getBlocks().get(3).setRFromCenter(1);
      block.getBlocks().get(3).setCFromCenter(-1);
      return block;
   }
   
   public TetrisShapes getTBlock(int r, int c){
      TetrisShapes block = new TetrisShapes(r,c,4);
      block.setGrid(grid);
      block.setBlockSize(blockSize);
      block.setLabel("T Block");
      block.setColor(Color.YELLOW);
      block.setResetTime(resetTime);
      block.init();
      block.getBlocks().get(1).setRFromCenter(1);
      block.getBlocks().get(2).setCFromCenter(1);
      block.getBlocks().get(3).setCFromCenter(-1);
      return block;
   }
   
   public TetrisShapes getSBlock(int r, int c){
      TetrisShapes block = new TetrisShapes(r,c,4);
      block.setBlockSize(blockSize);
      block.setGrid(grid);
      block.setLabel("S Block");
      block.setColor(Color.GREEN);
      block.setResetTime(resetTime);
      block.setMaxRotation(2);
      block.init();
      block.getBlocks().get(1).setRFromCenter(-1);
      block.getBlocks().get(2).setCFromCenter(1);
      block.getBlocks().get(3).setRFromCenter(-1);
      block.getBlocks().get(3).setCFromCenter(-1);
      return block;
   }
}
