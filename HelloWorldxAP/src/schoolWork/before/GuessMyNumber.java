package schoolWork.before;
import java.util.Scanner;

//Thomas Varano
//[Program Descripion]
//Oct 10, 2017

public class GuessMyNumber
{
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      do {
         int totalTries = 4; boolean win = false; 
         String target = (int)(Math.random()*10+1)+"";
         System.out.println(target);
         for (int amtTries = 0; amtTries < totalTries && !win; amtTries++) {
            System.out.println("Guess the number"); 
            String guess = s.nextLine();
            win = guess.equals(target);
            System.out.println((win)
                  ? "GUESS CORRECT"
                  : (Integer.parseInt(guess) > Integer.parseInt(target)
                        ? "too high"
                        : "Too Low"));
         }
         System.out.println((win) ? "You won! play again?" : "you lost. it was "+target+". play again?");
      } while (s.nextLine().equalsIgnoreCase("Y"));
      s.close();
   }
}

