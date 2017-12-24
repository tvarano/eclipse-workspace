import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//Thomas Varano
//[Program Descripion]
//Jun 26, 2017

public class LevelWriter
{
   private String docName;
   private PrintWriter writer;
   public static final String[] ACC_BARRIERS = {"tree", "log", "bush", "rock"};
   public static final String[] ACC_TARGETS = {"target", "deer", "rabbit", "duck"};
   //more?
   public static String[] ACC_OBJECTS = new String[(ACC_BARRIERS.length + ACC_TARGETS.length)];
   
   public LevelWriter(String docName, String location) {
      this.docName = docName;
      String docFileName = System.getProperty("user.home")+"/"+location+"/"+docName+".txt";
      
      File filePath = new File(docFileName);
      try{
         if (LevelManager.debug)
            System.out.println("Reading for test");
         @SuppressWarnings("resource")
         Scanner test = new Scanner(filePath);
         throw new Error("File Name Exists");
      }
      catch (FileNotFoundException e){
         if (LevelManager.debug)
            System.out.println("Creating file.");
         try
         {
            writer = new PrintWriter(new FileWriter(docFileName, false));
         } catch (IOException e1){e1.printStackTrace();}
      }
      
//      // throw error if file already exists
//      //catch it in level creator, bring up popup saying that the name was already used
//      try
//      {
//         writer = new PrintWriter(new FileWriter(docFileName, false));
//      } catch (IOException e1){e1.printStackTrace();}
       
      
   }
   
   private boolean barrierAcc(String object) {
      for (int i = 0; i<ACC_BARRIERS.length; i++) {
         if (object.equals(ACC_BARRIERS[i]))
            return true;
      }
      return false;
   }
   
   private boolean targetAcc(String object) {
      for (int i = 0; i<ACC_TARGETS.length; i++) {
         if (object.equals(ACC_TARGETS[i]))
            return true;
      }
      return false;
   }
   
   public LevelWriter(String docName){
      this(docName, "Documents");
   }
   
   public void spawnBarrier(String object, int x, int y, double z, double width, double height) {
      if (barrierAcc(object))
         writer.println("create:"+object+"("+x+","+y+","+z+")"+width+","+height+";");
   }
   public void spawnTarget(String object, int x, int y, int z, double width, double height,
         int direction, int distance, int timeOut, double speed) {
      String orders;
      String standard;
      boolean continuous = Target.directionContinuous(direction);
      if (targetAcc(object)) {
         if () {
            orders = "CONT";
         }
         else {
            orders = "STOP";
         }
         standard = "spawn:"+object+orders+"("+x+","+y+","+z+")"+width+","+height+"|"+direction+","+speed+";";
         
      }
   }
}
