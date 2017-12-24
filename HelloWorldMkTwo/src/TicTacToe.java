import java.util.InputMismatchException;
import java.util.Scanner;

//Thomas Varano
//[Program Descripion]
//Apr 7, 2017

public class TicTacToe
{
   public static final String P1 = "X", P2 = "O";
   public static String[][] board = new String[3][3];
   public static String currentPlayer = P1;
   
   public static void initBoard(){
      int counter = 1;
      for (int r = 0; r<board.length; r++){
         for (int c = 0; c<board[r].length; c++){
            board[r][c] = counter+"";
            counter++;
         }
      }
   }
   
   public static void showBoard(){
      for (int r = 0; r<board.length; r++){
         for (int c = 0; c<board[r].length; c++){
            System.out.print(board[r][c]+" ");
         }
         System.out.println("");
      }
      System.out.println();
   }
   
   public static void getMove(int space){
      int r = (int)(space/3);
      int c = (space%3);
      space++;
      if (!board[r][c].equals(P1) && !board[r][c].equals(P2)){
         if (currentPlayer == P1){
            board[r][c] = P1;
            currentPlayer = P2;
         }
         else if (currentPlayer == P2){
            board[r][c] = P2;
            currentPlayer = P1;
         }
      }
   }
   
   public static boolean gameOver(){
      return (boardFull() || checkDiag() || checkColsRows());
   }
   
   public static boolean checkDiag(){
      int c = 0;
      for (int r = 0; r<board.length; r++){
         if (!board[r][c].equals(currentPlayer))
            return false;
         c++;
      }
      c = 2;
      
      for (int r = 0; r<board.length; r++){
         if (!board[r][c].equals(currentPlayer))
            return false;
         c--;
      }
      return true;
   }
   
   public static boolean checkCol(int c){
      for (int r = 0; r<board.length; r++) {
         if (!board[r][c].equals(currentPlayer))
            return false;
      }
      return true;
   }
   
   public static boolean checkColsRows(){
      for (int c = 0; c<board[0].length; c++)
         if (checkCol(c))
            return true;
      for (int r = 0; r<board.length; r++)
         if (checkRow(r))
            return true;
      return false;
   }
   
   public static boolean isWinner(){
      return (checkDiag() || checkColsRows());
   }
   
   public static boolean boardFull(){
      for (int r = 0; r<board.length; r++){
         for (int c = 0; c<board[r].length; c++){
            if (board[r][c].equals(((c+1)+((r)*3))+""))
               return false;
         }
      }
      return true;
   }
   
   public static boolean checkRow(int r){
      for (int c = 0; c<board[r].length; c++){
         if (!board[r][c].equals(currentPlayer))
            return false;
      }
      return true;
   }
   
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      String errorCatcher;
      int moveIndex = -1;
      initBoard();
      do {
         showBoard();
         System.out.print("Player "+currentPlayer+", Enter your space:");
         try {
            moveIndex = input.nextInt()-1;
         } catch (InputMismatchException e){
            moveIndex = 100;
            errorCatcher = input.nextLine();
            System.out.println("\t\tPlease enter a number");
         }
         if(moveIndex>=0 && moveIndex<=8)
            getMove(moveIndex);
         else
            System.out.println("enter a number between 1 and 9");;
      } while(!gameOver());
      
      showBoard();
      System.out.println("gameover");
      
      if (isWinner())
         System.out.println("winner is: "+currentPlayer);
      else
         System.out.println("tie");
      input.close();
   }

}
