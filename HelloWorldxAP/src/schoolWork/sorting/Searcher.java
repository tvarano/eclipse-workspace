//Thomas Varano
//Feb 21, 2018

package schoolWork.sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Searcher {
   
   public static String[] readListFromFile(String path) throws FileNotFoundException {
      Scanner s = new Scanner(new File(path));
      int amt = 0;
      while(s.hasNextLine()) {
         s.nextLine();
         amt++;
      }
      s.close();
      String[] entries = new String[amt];
      s = new Scanner(new File(path));
      for (int i = 0; i < amt; i++) {
         entries[i] = s.nextLine();
      }
      s.close();
      return entries;
   }
   
   public static int indexOf(String target, String[] list) {
      for (int i = 0; i < list.length; i++)
         if (list[i].equalsIgnoreCase(target))
            return i;
      return -1;
   }
   
   public static int binarySearch(int[] nums, int target) {
      return binarySearch(nums, target, 0, nums.length-1);
   }
   
   public static int binarySearch(int[] nums, int target, int low, int high) {
      if (high < low) return -1;
      int mid = (low + high) / 2;
      if (nums[mid] == target) return mid;
      if (nums[mid] < target)
         return binarySearch(nums, target, mid + 1, high);
      return binarySearch(nums, target, low, mid - 1);
   }
   
   public static int binarySearch(String[] nums, String target, int low, int high) {
      if (high < low) return -1;
      int mid = (low + high) / 2;
      if (nums[mid].equals(target)) return mid;
      if (nums[mid].compareTo(target) < 0)
         return binarySearch(nums, target, mid + 1, high);
      return binarySearch(nums, target, low, mid - 1);
   }
   
   public static void main(String[] args) {
      try {
         System.out.println(indexOf("bird", readListFromFile("src/schoolWork/sorting/wordlist.txt")));
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   }
}
