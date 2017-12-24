import java.util.Scanner;

//Thomas Varano
//[Program Descripion]
//Dec 22, 2016

public class Alphabetize
{
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("write and enter 3 words");
      String a = input.nextLine(); 
      String b = input.nextLine();
      String c = input.nextLine();
      String first ="", second ="", third = "";

      if (a.compareTo(b)<0 || a.compareTo(c)<0){
         first = a;
         second = a;
         if(a.compareTo(b)<0 && a.compareTo(c) <0){
            if (b.compareTo(c)<0){
               third = c;
               second = b;
            }
            else {
               second = c;
               third = b;
            }
         }
         else if (a.compareTo(b)<0){
           third = b;
           first = c;
         }
         else {
            third = c;
            first = b;
         }
      }
      else{
         third = a;
         if (b.compareTo(c)<0){
            second = c;
            first = b;
         }
         else{
            second = b;
            first = c;
         }
      }
      System.out.println(first +" "+ second +" "+ third);
   }

}
