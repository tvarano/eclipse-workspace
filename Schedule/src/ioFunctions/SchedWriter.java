package ioFunctions;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import information.Schedule;

//Thomas Varano
//[Program Descripion]
//Oct 19, 2017

public class SchedWriter
{
   private ObjectOutputStream outStream;
   private FileOutputStream fileStream;
   public static final String FILE_ROUTE = 
//         System.getProperty("user.home")+"/Documents/"+Main.APP_NAME+"Document.txt";
   System.getProperty("user.home")+"/Documents/SerialTestDocument.txt";
   private boolean debug;
   
   public SchedWriter() {
      init();
   }
   
   private void init() {
      fileStream = null;
      try {
         fileStream = new FileOutputStream(FILE_ROUTE);
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
      try {
         outStream = new ObjectOutputStream(fileStream);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   public void write(Schedule s) {
      if (s == null) {
         if (debug) System.err.println("written schedule is null");
         return;
      }
      try {
         outStream.writeObject(s);
      } catch (IOException e) {
         e.printStackTrace();
      }
      close();
   }
   
   public void close() {
      try {
      fileStream.close();
      outStream.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   public void transfer() {
      write(new OldReader().readDefaultSchedule());
   }
   
   public static void main(String[] args) {
      SchedWriter w = new SchedWriter();
      w.transfer();
//      w.write(new Schedule(Rotation.R1.getTimes(), Lab.LAB0));
      System.out.println("aight");
   }
}
