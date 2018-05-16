//Thomas Varano
//May 1, 2018

package schoolWork.acsl;

public class CrosswordAnswers {

   /**
    * part A
    * 
    * label a square if the square above it or to its left is black (or does not exist)
    */
   private boolean toBeLabeled(int r, int c, boolean[][] blackSquares) {
      if (blackSquares[r][c]) return false;
      //every square is white here
      if (r == 0 || c == 0) return true;
      return blackSquares[r-1][c] || blackSquares[r][c-1];
   }

   
   
   
   private Square[][] puzzle;

   /**
    * part B
    * 
    * create a crossword puzzle
    */ 
   public void Crossword(boolean[][] blackSquares) {
      puzzle = new Square[blackSquares.length][blackSquares[0].length];
      int label = 1;
      for (int r = 0; r < puzzle.length; r++) {
         for (int c = 0; c < puzzle[r].length; c++) {
            if (toBeLabeled(r, c, blackSquares)) {
               puzzle[r][c] = new Square(false, label);
               label++;
            } else {
               puzzle[r][c] = new Square(blackSquares[r][c], 0);
            }
         }
      }
   }
}
