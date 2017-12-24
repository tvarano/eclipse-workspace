package ioFunctions;
import constants.Rotation;
import constants.RotationConstants;
import information.ClassPeriod;
import information.Schedule;

//Thomas Varano
//[Program Descripion]
//Oct 20, 2017

public class OrderUtility
{
   private static boolean debug = true, statusU = true;
   
   public static Schedule reorderClasses(Rotation r, Schedule s, ClassPeriod[] template) {
      if (statusU) System.out.println("ordering schedule: "+s.getName());
      ClassPeriod[] newArray = reorderClasses(r, s.getClasses());
      s.setClasses(newArray);
      s.setPascackData();
      return s;
   }
   
   public static Schedule reorderAndClone(Rotation r, Schedule s, ClassPeriod[] template) {
      return reorderClasses(r, s.clone(), template);
   }
   
   public static ClassPeriod[] reorderClasses(Rotation r, ClassPeriod[] unOrderedArray) {
      if (statusU) System.out.println("**********\nordering class array...");
      if (debug) printData(r, unOrderedArray);
      int extraClasses = unOrderedArray.length - Rotation.R1.getTimes().length;
      ClassPeriod[] newArray = new ClassPeriod[r.getTimes().length+extraClasses];
      int[] order = Rotation.getSlotRotation(r);
      
      //check for zero period, etc.
      int arrayStart = 0; 
      int newArrayIndex = 0, rotationIndex = 0;
      for (int i = 0; i < unOrderedArray.length; i++) {
         if (unOrderedArray[i].getSlot() == 0) {
            newArray[0] = unOrderedArray[i];
            newArrayIndex++;
            arrayStart++;
         }
         else if (unOrderedArray[i].getSlot() == 8) {
            newArray[newArray.length-1] = unOrderedArray[i];
         }
      }
      
      //every other class
      for (int i = 0; i < order.length; i++) {
         if (debug) System.out.println("order run "+i);
         for (int o = arrayStart; o < unOrderedArray.length; o++) {
            if (order[i] == unOrderedArray[o].getSlot()) {
               newArray[newArrayIndex] = new ClassPeriod(unOrderedArray[o].getSlot(), unOrderedArray[o].getName(),
                     r.getTimes()[rotationIndex].getStartTime(), r.getTimes()[rotationIndex].getEndTime(), 
                     unOrderedArray[o].getTeacher(), unOrderedArray[o].getRoomNumber());
               
               if (debug) {
                  System.out.println("new array["+newArrayIndex+"] set to old["+o);
                  System.out.println("\tindex is; "+unOrderedArray[o].getSlot());
               }
               newArrayIndex++;
               rotationIndex++;
            }
            //TODO for now... make sure to have them write their own pascack.
         }
         if (order[i] == RotationConstants.PASCACK) {
            if (debug) System.out.println("entering pascack...");
            newArray[newArrayIndex] = RotationConstants.getPascack();
            newArrayIndex++;
            rotationIndex++;
         }
      }
      if (debug) {
         System.out.println("finished ordering... PRODUCT");
         printData(r, newArray);
      }
      return newArray;
   }
   
   private static void printData(Rotation r, ClassPeriod[] oldArray) {
         System.out.println("--------");
         for (ClassPeriod c : oldArray)
            System.out.println(c);
         System.out.println("to "+r+"\n--------");
   }
}
