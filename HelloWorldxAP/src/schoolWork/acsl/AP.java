//Thomas Varano
//May 15, 2018

package schoolWork.acsl;

public class AP {
   public static void main(String[] args) {
      int[][] test = {{1, 2, 3, 4},
                      {4, 5, 6, 7}, 
                      {8, 9, 0, 1}};
      for (int[] row : test) {
         for (int i = 0; i < row.length; i++)
            if (i == 2)
               row[i] = 10;
      }
      for (int[] row : test) {
         for (int i : row)
            System.out.print(i + 
                  " ");
         System.out.println();
      }
   }
}
