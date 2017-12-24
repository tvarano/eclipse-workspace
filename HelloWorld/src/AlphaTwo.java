import java.util.Scanner;

//Thomas Varano
//[Program Descripion]
//Dec 22, 2016

public class AlphaTwo
{
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("write and enter 3 words");
      String[] strArray = new String[3];
      String[] numArray = new String[10];
      
      strArray[0] = numArray[0] = input.nextLine(); 
      strArray[1] = numArray[1] = input.nextLine(); 
      strArray[2] = numArray[2] = input.nextLine(); 
      
      for(int i =0; i<strArray.length; i++){
         for(int j=0; j<strArray.length; j++){
            if (strArray[j].compareTo(strArray[i])<0)
               numArray[j+1] = strArray[j];
         }
      }
      System.out.println(numArray[0]+numArray[1]+numArray[2]);
   }

}
