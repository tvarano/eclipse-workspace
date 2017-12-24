package beforeGreatFire;
import java.util.ArrayList;

//Thomas Varano
//[Program Description]
//Sep 9, 2017

public class Statistics
{
   private String description;
   private ArrayList<Integer> values;

   public Statistics(ArrayList<Integer> intArray) {
      description = "A test for the Statistics Class";
      values = intArray;
   }

   public Statistics(String description, ArrayList<Integer> values) {
      this.description = description;
      this.values = values;
   }

   public int getMean() {
      int sum = 0;
      for (int i = 0; i < values.size(); i++) {
         sum += values.get(i);
      }
      return sum / values.size();
   }

   public int getMedian() {
      values.sort(null);
      if (values.size() % 2 == 0)
         return (values.get(values.size() / 2)
               + values.get(values.size() / 2 - 1)) / 2;
      else
         return values.get(values.size() / 2);
   }

   public int getMode() {
      values.sort(null);
      int modeNumber = values.get(0), amountMode = 1, currentNum = 0, amountCurrent = 0;
      for (int i = 1; i < values.size(); i++) {
         if (values.get(i) == modeNumber)
            amountMode++;
         else if (values.get(i) == currentNum)
            amountCurrent++;
         else {
            amountCurrent = 1;
            currentNum = values.get(i);
         }
         if (amountCurrent > amountMode) {
            modeNumber = currentNum;
            amountMode = amountCurrent;
         }
      }
      if (amountMode == 1)
         return -1;
      return modeNumber;
   }

   public int getMin() {
      int x = Integer.MAX_VALUE;
      for (int i = 0; i < values.size(); i++) {
         if (values.get(i) < x)
            x = values.get(i);
      }
      return x;
   }

   public int getMax() {
      int x = -Integer.MAX_VALUE;
      for (int i = 0; i < values.size(); i++) {
         if (values.get(i) > x)
            x = values.get(i);
      }
      return x;
   }

   public int getRange() {
      return getMax() - getMin();
   }

   public void addDataValue(int value) {
      values.add(value);
   }

   @Override
   public String toString() {
      return "Statistics [description=" + description + ", values=" + values
            + "]";
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public ArrayList<Integer> getValues() {
      return values;
   }

   public void setValues(ArrayList<Integer> values) {
      this.values = values;
   }

   public static void main(String[] args) {
      ArrayList<Integer> values = new ArrayList<Integer>();
      values.add(2);
      values.add(2);
      values.add(2);
      values.add(2);
      values.add(2);
      values.add(4);
      values.add(4);
      values.add(4);
      values.add(5);
      values.add(5);
      Statistics s = new Statistics(values);
      System.out.println(s.getMode());
   }

}