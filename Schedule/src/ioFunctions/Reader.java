package ioFunctions;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JOptionPane;

import constants.ErrorID;
import constants.Lab;
import constants.Rotation;
import constants.RotationConstants;
import information.ClassPeriod;
import information.Schedule;

public class Reader {
   private ObjectInputStream reader;
   private FileInputStream fileStream;
   private boolean debug;
   
   public Reader() {
      debug = false;
      init();
   }
   
   private void init() {
      fileStream = null;
      try {
         fileStream = new FileInputStream(SchedWriter.FILE_ROUTE);
         reader = new ObjectInputStream(fileStream);
      } catch (IOException e) {
         if (debug) e.printStackTrace();
         reWriteSched();
         init();
      }
   }
   
   public Schedule readSched() {
      init();
      Schedule ret = null;
      try {
         ret = (Schedule) reader.readObject();
      } catch (ClassNotFoundException | EOFException e) {
         reWriteSched();
         System.err.println(e.getMessage());
         ErrorID.showError(ErrorID.FILE_TAMPER, true);
         return readSched();
      } catch (IOException e) {
         e.printStackTrace();
      }
      try {
         reader.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
      close();
      return formatSchedule(ret);
   }
   
   public Schedule formatSchedule(Schedule in) {
      Schedule retval = assignLabClassRooms(setTimes(checkSpecialPeriods(in)));
      retval.init();
      return retval;
   }
   
   private Schedule setTimes(Schedule in) {
      ClassPeriod[] template = Rotation.R1.getTimes();
      ClassPeriod[] ret = in.getClasses();
      boolean skip;
      int tempIndex = 0;
      for (int index = 0; index < ret.length; index++) {
         skip = false;
         for (int i : RotationConstants.SPECIAL_CLASSES)
            if (ret[index].getSlot() == i) {
               skip = true;
            }
         if (skip)
            continue;
         try {
            ret[index].setTimeTemplate(template[tempIndex]);
         } catch(ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.err.println("PROBLEM READING");
         }
         tempIndex++;
      }
      in.calculateSchoolDay();
      return in;
   }
   
   private Schedule checkSpecialPeriods(Schedule in) {
      for (ClassPeriod c : in.getClasses()) {
         if (c.getSlot() == 0)
            c.setTimeTemplate(RotationConstants.PERIOD_ZERO);
         else if (c.getSlot() == 8)
            c.setTimeTemplate(RotationConstants.PERIOD_EIGHT);
         else if (c.getSlot() == RotationConstants.PASCACK)
            c.setTimeTemplate(RotationConstants.PASCACK_PERIOD);
         else if (c.getSlot() == RotationConstants.LUNCH)
            c.setName("Lunch");
      }
      return in;
   }
   
   private Schedule assignLabClassRooms(Schedule in) {
      in.setLabs(findLabClassRooms(in.getLabs(), in));
      return in;
   }
   
   private Lab[] findLabClassRooms(Lab[] labs, Schedule in) {
      for (Lab l : labs) {
         if (debug) System.out.println(l + " called "+in.get(l.getClassSlot()));
         l.setClassPreferences(in.get(l.getClassSlot()));
         if (debug) System.out.println(l + "=" + l.getTimeAtLab().getInfo());
      }
      return labs;
   }
   
   public Schedule readAndOrderSchedule(Rotation r) {
      Schedule s = readSched();
      return OrderUtility.reorderClasses(r, s, s.getClasses());
   }
   
   private void close() {
      try {
         fileStream.close();
         reader.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   public void reWriteSched() {
      if (debug) System.out.println("rewriting sched");
      SchedWriter w = new SchedWriter();
      w.write(new Schedule(Rotation.R1.getTimes(), Lab.LAB1));
   }
   
   public static void main(String[] args) {
      Reader r = new Reader();
      System.out.println(r.readSched().getLabs());
   } 
}