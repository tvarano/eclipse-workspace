import java.awt.Color;
import java.awt.Rectangle;
import java.util.LinkedList;

//Thomas Varano
//[Program Descripion]
//Mar 3, 2017

public class CalculationTest
{

   public static void main(String[] args) {
//      int x = 325;
//      int y = 760;
//      int degree = 2;
//      int width = 370;
//      int difHeight = 2;
//      System.out.println("tan: "+Math.tan(Math.toRadians(Math.abs(degree))));
//      int difY = (int)(Math.tan(Math.toRadians(degree))*width);
//      int amountSection = difY/difHeight;
//      System.out.println("currentY: "+(y+(difY/amountSection)*5));
//      System.out.println("difY="+difY + " amountSection="+ amountSection+" difperThing="+(difY/amountSection));
//      System.out.println("currentX: "+(x+(width/amountSection)*4));
//      
//      System.out.println();
//      325,760,370,30
//      
//      System.out.println(Math.tan(Math.toRadians(degree)));
//      System.out.println(Math.tan(Math.toRadians(-degree)));
//      System.out.println();
//      System.out.println(difY);
//      rotateAndBreak(2);
      
      
//      String tryOne = ";vertical(10,10*jump(12,0.0012;vertical(-20,39;";
//      String tryTwo = "*jump(10,10;horizontal(12,12$vertical(-20,39;";
//      String tryThree = ";vertical(2,3;horizontal(45,49494;vertical(20,02;";
//      String tryFour = ";vertical(4,900$switchSheet(walk;horizontal(30,03;";
//      String impossible = ";left(0,20;right(-23.43234,232323*jump(1929.293029,293;";
//      
//      Command[] array = getCommandArray(tryFour);
//      for (int i =0; i<array.length; i++)
//         System.out.println(array[i]);
//      
//   }
//   
//   private static Command[] getCommandArray(String commandString){
//      int currentAmountSteps = -1;
//      int[] punctuationIndex;
//      int currentIndex = 0;
//      String[] commandStringArray;
//      for (char currentChar : commandString.toCharArray()){
//         if(currentChar == ';' || currentChar == '*' || currentChar == '$'){
//            currentAmountSteps++;
//         }
//      }
//      punctuationIndex = new int[currentAmountSteps+1];
//      for (int i = 0; i<commandString.toCharArray().length; i++){
//         if (commandString.toCharArray()[i] == ';' ||
//               commandString.toCharArray()[i] == '*' ||
//               commandString.toCharArray()[i] == '$'){
//            punctuationIndex[currentIndex] = i;
//            currentIndex++;
//         }
//      }
//      currentIndex = 0;
//      System.out.println("amount"+currentAmountSteps);
//      System.out.println(commandString);
//      commandStringArray = new String[currentAmountSteps];
//      Command[] commandArray = new Command[currentAmountSteps];
//      int currentStep = 0;
//      for (int i = 0; i<currentAmountSteps; i++){
//         System.out.println("\nrun"+i);
//         System.out.println("step"+currentStep);
//         commandStringArray[i] = commandString.substring(
//               punctuationIndex[currentIndex],punctuationIndex[currentIndex+1]);
//         currentIndex++;
//      }
//      
//      System.out.println();
//      for (String current : commandStringArray)
//         System.out.println(current);
//      
//      String currentString;
//      for (int i = 0; i<commandStringArray.length; i++){
//         currentString = commandStringArray[i];
//         if (currentString.charAt(0) == '*'){
//            commandArray[i] = new Command(currentString.substring(1, currentString.indexOf('(')),
//                  Double.parseDouble(currentString.substring(currentString.indexOf('(')+1, 
//                        currentString.indexOf(','))),
//                  Double.parseDouble(currentString.substring(currentString.indexOf(',')+1)));
//         }
//         else if (currentString.charAt(0) == '$'){
//            commandArray[i] = new Command(currentString.substring(1, currentString.indexOf('(')),
//                  currentString.substring(currentString.indexOf('(')+1));
//         }
//         else if (currentString.charAt(0) ==';'){
//            commandArray[i] = new Command(currentString.substring(1, currentString.indexOf('(')),
//                  Double.parseDouble(currentString.substring(currentString.indexOf('(')+1, 
//                        currentString.indexOf(','))),
//                  Long.parseLong(currentString.substring(currentString.indexOf(',')+1)));
//         }
//      }
//      return commandArray;
//   }
// 
//   public static void thirdTimesACharm(int stepBetween){
//      
//      rotated = true;
//      sections.removeAll(sections);
//      int difY = (int)Math.round((Math.tan(Math.toRadians(degreeRotation))*width));
//      if (Math.abs(stepBetween)>Math.abs(difY))
//         throw new Error("stepBetween larger than difference in y");
//      int amountSection = Math.round(difY/stepBetween);
//      Random random = new Random();
//      for (int i = 0; i<amountSection; i++){
//         int platformInitX = x+(width/amountSection)*(i);
//         int platformInitY = y+(difY/amountSection)*i;
//         sections.add(new Platform(platformInitX, platformInitY,
//               width/amountSection, height));
//         sections.get(i).setColor(new Color(random.nextInt(255),random.nextInt(255), random.nextInt(255)));
//      }
//      System.out.println(difY);
//   }
//   
//   public static void rotateAndBreak(int stepBetween){
//      int x = 325;
//      int y = 760;
//      int degreeRotation = -2;
//      int width = 370;
//      int difY = (int)Math.round((Math.tan(Math.toRadians(degreeRotation))*width));
//      int amountSection = Math.round(Math.abs(difY/stepBetween));
//      for (int i = 0; i<amountSection; i++){
//         int platformInitX = x+(width/amountSection)*(i);
//         int platformInitY = y+(difY/amountSection)*i;
//         System.out.println(platformInitX+","+platformInitY);
//      }
//      System.out.println("??");
//      System.out.println((int)(50*6.5));
//      
//      
//      
//      int space = 2;
//      int a = (int)(space/3);
//      int c = (space%3);
//      c = 0;
//      
//      System.out.println(a+","+c);
//      
//      for (int r = 0; r<3; r++) {
//         System.out.println("thing:"+((c+1)+((r)*3))+"");
//      }   }
//      JukeBox.init();
//      JukeBox.load("DKHowHigh.wav", "test");
//      JukeBox.load("DKOpening.wav", "test");
//      JukeBox.loop("test");
      
      Command c = new Command("label");
      System.out.println("hello".toCharArray() .toString());
   }
}
