import java.util.ArrayList;

//Thomas Varano
//[Program Descripion]
//Sep 23, 2016
public class StringExploring
{
   public static void main(String[] args)
   {
      int counter = 0;
      ArrayList<String> beck = new ArrayList<String>();
      while (true){
      while(true){
         counter++;
         if (counter%10000 == 0)
            beck.add("hello");
         break;
      }
      for(int i = 0; i<beck.size(); i++){
         System.out.println(beck.get(i)+i);
         System.out.println("\t\t\tSIZE"+beck.size());
      }
      }
   }
}
