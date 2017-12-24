//Thomas Varano
//[Program Descripion]
//Dec 7, 2016
public class RichterTester
{
   public static void main(String[] args)
   {
      System.out.println(getOutcome(2.3432));
   }
   
   public static String getOutcome(double r){
      if (r < 0){
         return "Please enter a positive number";
      }
      else if (r < 3.5){
         return "Generally not felt";
      }
      else if (r < 4.5){
         return "felt, no destruction";
      }
      else if (r < 6.0){
         return "damage to weak buildings";
      }
      else if (r < 7.0){
         return "considerable collapse";
      }
      else if (r < 8.0){
         return "many buildings destroyed";
      }
      else if (r >= 8.0){
         return "that's a spicy meatball";
      }
      else 
         return "what";
      
   }
}
