//Thomas Varano
//[Program Descripion]
//Feb 24, 2017

public class TimesTable
{

   public static void main(String[] args) {
      System.out.println(getTable(10));
   }

   public static void printTableFormat(int amount){
      int columnSpace = Integer.toString(amount*amount).length()+1;
      String spaceControl = "%"+columnSpace+"s";
      for (int s = 0; s<columnSpace; s++){
         System.out.print(" ");
      }
      for (int i = 1; i<=amount; i++){
         System.out.printf(spaceControl, i);
      }
      System.out.println();
      for (int s = 0; s<=columnSpace; s++){
         System.out.print(" ");
      }
      for (int i = 1; i<=amount; i++){
         //space
         for (int s = 0; s<columnSpace-1; s++){
            System.out.print("-");
         }
         System.out.print(" ");
      }
      System.out.println();
      for (int r = 1; r<= amount; r++){
         System.out.printf(spaceControl, r+"|");
         for (int c = 1; c<=amount; c++){
            System.out.printf(spaceControl, r*c);
         }
         System.out.println();
      }
   }
   
   public static void printTable(int amount){
      int columnSpace = Integer.toString(amount*amount).length()+1;
      for (int s = 0; s<columnSpace; s++){
         System.out.print(" ");
      }
      for (int i = 1; i<=amount; i++){
         System.out.print(i);
         //space
         for (int s = 0; s<columnSpace-(Integer.toString(i).length()); s++){
            System.out.print(" ");
         }
      }
      System.out.println();
      for (int s = 0; s<columnSpace; s++){
         System.out.print(" ");
      }
      for (int i = 1; i<=amount; i++){
         //space
         for (int s = 0; s<columnSpace-1; s++){
            System.out.print("-");
         }
         System.out.print(" ");
      }
      System.out.println();
      for (int r = 1; r<= amount; r++){
         System.out.print(r+"|");
         //space
         for (int s = 0; s<columnSpace-(Integer.toString(r).length())-1; s++){
            System.out.print(" ");
         }
         for (int c = 1; c<=amount; c++){
            System.out.print(r*c);
            //space
            for (int s = 0; s<columnSpace-(Integer.toString(r*c).length()); s++){
               System.out.print(" ");
            }
         }
         System.out.println();
      }
   }
   
   public static String getTable(int amount){
      int columnSpace = Integer.toString(amount*amount).length()+1;
      String output = "";
      output+= getSpace(columnSpace,0);
      for (int i = 1; i<=amount; i++){
         output+=i;
         output+= getSpace(columnSpace,Integer.toString(i).length());
      }
      output+="\n";
      output+=getSpace(columnSpace, 0);
      for (int i = 1; i<=amount; i++){
         //space
         for (int s = 0; s<columnSpace-1; s++){
            output+="-";
         }
         output+=" ";
      }
      output+="\n";
      for (int r = 1; r<= amount; r++){
         output+=(r+"|");
         output+= getSpace(columnSpace, (Integer.toString(r).length())-1);
         for (int c = 1; c<=amount; c++){
            output+=(r*c);
            output+=getSpace(columnSpace, Integer.toString(r*c).length());
         }
         output+="\n";
      }
      return output;
   }
   
   public static String getSpace(int columnSpace, int contentLength){
      String output = "";
      for (int s = 0; s<columnSpace-contentLength; s++){
         output+=" ";
      }
      return output;
   }
}
