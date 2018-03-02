//Thomas Varano
//Feb 22, 2018

package schoolWork.sorting;

public class Sorting {
   public static void main(String[] args) {
      int[] sort = {5, 7, 3, 1, 8, 6, 7, 8, 9, 2};
      int[] search = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      print(sortInsert(sort));
      System.out.println(Searcher.binarySearch(search, 4));
   }

   public static void print(int[] in) {
      for (int i : in) {
         System.out.print(i + ", ");
      }
      System.out.println();
   }

   public static int[] sortSelection(int[] arg) {
      int min = 0;
      for (int i = 0; i < arg.length; i++) {
         min = i;
         for (int j = i; j < arg.length; j++) {
            if (arg[min] > arg[j]) {
               min = j;
            }
         }
         int temp = arg[i];
         arg[i] = arg[min];
         arg[min] = temp;
      }
      return arg;
   }

   public static int[] sortInsert(int[] arr) {
      for (int i = 1; i < arr.length; i++) {
         int index = i;
         while (index > 0 && arr[index] < arr[index - 1]) {
            int temp = arr[index];
            arr[index] = arr[index - 1];
            arr[index - 1] = temp;
            index--;
         }
      }
      return arr;
   }

   public static void merge(int arr[], int l, int m, int r) {
      // Find sizes of two subarrays to be merged
      int n1 = m - l + 1;
      int n2 = r - m;

      /* Create temp arrays */
      int L[] = new int[n1];
      int R[] = new int[n2];

      /* Copy data to temp arrays */
      for (int i = 0; i < n1; ++i)
         L[i] = arr[l + i];
      for (int j = 0; j < n2; ++j)
         R[j] = arr[m + 1 + j];

      /* Merge the temp arrays */

      // Initial indexes of first and second subarrays
      int i = 0, j = 0;

      // Initial index of merged subarry array
      int k = l;
      while (i < n1 && j < n2) {
         if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
         } else {
            arr[k] = R[j];
            j++;
         }
         k++;
      }

      /* Copy remaining elements of L[] if any */
      while (i < n1) {
         arr[k] = L[i];
         i++;
         k++;
      }

      /* Copy remaining elements of R[] if any */
      while (j < n2) {
         arr[k] = R[j];
         j++;
         k++;
      }
   }

   // Main function that sorts arr[l..r] using
   // merge()
   public static void sortQuick(int arr[], int l, int r) {
      if (l < r) {
         // Find the middle point
         int m = (l + r) / 2;

         // Sort first and second halves
         sortQuick(arr, l, m);
         sortQuick(arr, m + 1, r);

         // Merge the sorted halves
         merge(arr, l, m, r);
      }
   }

}
