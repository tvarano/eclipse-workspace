//Thomas Varano
//[Program Descripion]
//Apr 6, 2017

public class Average2DArray
{
   public static void main(String[] args) {
      int[][] arrInt = {
            {94,78,82,95,87,81},
            {86,83,91,88,94,89},
            {92,89,80,93,79,91},
            {90,84,85,89,81,76}
            };
      System.out.println(getAverage(arrInt));
            
      }
      
   public static double getAverage(int[][] arr){
      double sum = 0;
      for (int[] r: arr){
         for(int c : r){
            sum+=c;
         }
      }
      return sum/(arr.length*arr[0].length);
   }
}
