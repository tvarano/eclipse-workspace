import java.util.Scanner;

//Thomas Varano
//[Program Descripion]
//Mar 13, 2017

public class NumberGuesser
{

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int bound = 100;
      int theNumber = randomNumber(100);
      int maxGuesses = (int)(Math.log(bound)+1);
      int guess;
      boolean correct;
      int amountGuesses = 0;
      System.out.println("guess the number!! you have "+maxGuesses+" guesses");
      do{
         System.out.print("your guess: ");
         guess = input.nextInt();
         amountGuesses++;
         correct = (guess == theNumber);
         System.out.print("you have "+ (maxGuesses-amountGuesses)+" guesses left. your guess needs to be ");
         if (theNumber>guess)
            System.out.println("higher");
         else if (theNumber<guess){
            System.out.println("lower");
         }
      }while(!correct && amountGuesses<maxGuesses);
      if (correct)
         System.out.println("you win!");
      else
         System.out.println("you lose. the number was "+ theNumber);
      input.close();
   }

   public static int randomNumber(int bound){
      return (int) (Math.random()*bound+1);
   }
   
}
