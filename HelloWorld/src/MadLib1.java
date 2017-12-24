import java.util.Scanner;

//Thomas Varano
//Mad Libs Console
//Oct 5, 2016
public class MadLib1
{
   public static void main(String[] args)
   {
   @SuppressWarnings("resource")
   Scanner input = new Scanner(System.in);
      System.out.println("Enter a noun");
      String noun1 = input.nextLine().toUpperCase();
      System.out.println("Enter an adjective");
      String adj1 = input.nextLine().toUpperCase();
      System.out.println("Enter an animal");
      String animal = input.nextLine().toUpperCase();
      System.out.println("Enter a noun");
      String noun2 = input.nextLine().toUpperCase();
      System.out.println("Enter an adjective");
      String adj2 = input.nextLine().toUpperCase();

      
      System.out.println("Old Mother Hubbard went to the "+noun1 + " to get her " + adj1
            + "\n" + animal + " a " + noun2 + ". When she got there, the\n"
            + noun1 + " was " + adj2 + ", and so her poor " + animal + "\nhad none.");
   }
}
