import java.util.Scanner;

//Thomas Varano
//Practice Do/While loops
//Mar 3, 2017

public class WhilePractice
{
   public static void main(String[] args) {
      zZBonus();
   }
   
   public static void exceeds100(){
      Scanner input = new Scanner(System.in);
      double sum = 0;
      int amount = 0;
      boolean negative = false;
      do{
         System.out.println("enter a number");
         double next = input.nextDouble();
         sum+=next;
         amount++;
         if (next<0)
            negative = true;
      }while(sum<100);
      System.out.println("sum: "+sum);
      System.out.println("amount of nums: "+amount);
      System.out.println("negative: "+negative);
      input.close();
   }
   
   public static void vowelFoul(){
      Scanner input = new Scanner(System.in);
      String entered = "";
      String vowels = "aeiouAEIOU";
      int amount = -1;
      char entry;
      do{
         System.out.println("enter a char");
         String next = input.nextLine();
         entry = next.toLowerCase().charAt(0);
         amount++;
         entered+=entry;
      } while (vowels.indexOf(entry)<0);
      System.out.println(entered.substring(0,entered.length()-1));
      System.out.println("amount= "+amount); 
      input.close();
   }
   
   public static void zzStop(){
      String output = "";
      char nextChar;
      nextChar = (char)(Math.random()*26+97);
      output+=nextChar;
      do{
         nextChar = (char)(Math.random()*26+97);
         output+=nextChar;
         System.out.println(nextChar);
      } while (!output.substring(output.length()-2).equals("zz"));
   }
   
   public static void quitter(){      
      Scanner scanner = new Scanner(System.in);
      do {
         String input = "";
         String output = "";
         do{
            System.out.println("enter a string");
            input = scanner.nextLine();
            output+=input;
         }while (!input.equalsIgnoreCase("quit"));
         System.out.println("string = "+output.substring(0,output.length()-4));
         System.out.println("try again??");
      } while (scanner.nextLine().equalsIgnoreCase("y"));
      scanner.close();
   }
   
   public static void zZBonus() {
      String output = "";
      String possChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
      char nextChar;
      nextChar = (char)(possChar.charAt((int) (Math.random()*52)));
      System.out.println(nextChar);
      output+=nextChar;
      do{
         nextChar = (char)(possChar.charAt((int) (Math.random()*52)));
         System.out.println(nextChar);
         output+=nextChar;
      } while (!output.substring(output.length()-2).equalsIgnoreCase("zz"));
   }
}