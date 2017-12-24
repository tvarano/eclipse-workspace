//Thomas Varano
//[Program Descripion]
//Mar 23, 2017

public class TryingSorting
{

   public static void main(String[] args) {
      int[] mainArr = new int[100];
      for (int i = 0; i<mainArr.length; i++)
         mainArr[i] = (int)(Math.random()*100+1);
      for (int i : mainArr)
         System.out.print(i+",");
      sortSelection(mainArr);
      System.out.println();
      for (int i : sortSelection(mainArr))
         System.out.print(i+",");
      
   }
   
   public static int[] sortBubble(int[] array){
      int current;
      int currentIndex;
      int[] output = new int[array.length];
      boolean goingUp = true;
      current = array[0];
      if (goingUp){
         for (int i = 0; i<array.length; i++){
            if (i == array.length-1){
               goingUp = false;
               current = array[i-1];
            }
         }
      }
      else {
         
      }
      return output;
   }
   
   public static int[] sortSelection(int[] array) {
      int currentSwapperIndex = 0, currentNum;
      for (int i = 0; i < array.length; i++) {
         currentSwapperIndex = i;
         currentNum = array[i];
         for (int j = i; j < array.length; j++) {
            if (array[currentSwapperIndex] > array[j]) {
               currentSwapperIndex = j;
            }
         }
         array[i] = array[currentSwapperIndex];
         array[currentSwapperIndex] = currentNum;
      }
      return array;
   }
}
