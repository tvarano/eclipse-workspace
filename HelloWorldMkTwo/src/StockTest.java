public class StockTest {
     
  public static void main(String[] args) {
    int[] list = {17, 11, 60, 25, 150, 75, 31, 120};
    System.out.println("Buy on " + bestDays(list)[0]+".\n"
      +"Sell on"+ bestDays(list)[1]+".\n Profit is:"+ bestDays(list)[2]);
  }
   
   public static int[] bestDays(int[] list) {
      int bestSpread = 0, smIndex = 0, nextSmIndex = 0, larIndex = 0;
      for (int i = 0; i< list.length; i++) {
         if (list[i] < list[nextSmIndex])
            nextSmIndex = i;
         if (list[i] > list[larIndex]) {
            larIndex = i;
            smIndex = nextSmIndex;
            bestSpread = list[larIndex]-list[smIndex]; 
      }
         else if (list[i]-list[nextSmIndex] > bestSpread) {
            larIndex = i;
            smIndex = nextSmIndex;
            bestSpread = list[larIndex] - list[smIndex];
         }
      }
      return new int[] {smIndex, larIndex, bestSpread};
   }
}