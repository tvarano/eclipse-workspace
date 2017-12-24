import java.util.Scanner;

//Thomas Varano
//Get your grade
//Dec 8, 2016

public class GradeFinder {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("print your grade: number");
		System.out.println(getLetterGrade(Double.parseDouble(input.nextLine())));
		System.out.println("print your grade: letter");
		System.out.println(getNumberGrade(input.nextLine()));
	}

	public static String getLetterGrade(double g){
		      if (g < 59.5){
		         return "F";
		      }
		      else if (g < 62.5){
		         return "D-";
		      }
		      else if (g < 66.5){
		         return "D";
		      }
		      else if (g < 69.5){
		         return "D+";
		      }
		      else if (g < 72.5){
		         return "C-";
		      }
		      else if (g < 76.5){
		         return "C";
		      }
		      else if (g < 79.5){
		         return "C+";
		      }
		      else if (g < 82.5){
		    	  return "B-";
		      }
		      else if (g < 86.5){
		    	  return "B";
		      }
		      else if (g < 89.5){
		    	  return "B+";
		      }
		      else if (g < 92.5){
		    	  return "A-";
		      }
		      else if (g < 97.5){
		    	  return "A";
		      }
		      else if (g < 100){
		    	  return "A+";
		      }		      
		      else 
		         return "what";
			}
	
	public static int getNumberGrade(String g){
	      if (g.equals("F")){
		         return 55;
		      }
		      else if (g.equals("D-")){
		         return 62;
		      }
		      else if (g == "D"){
		         return 65;
		      }
		      else if (g.equals("D+")){
		         return 67;
		      }
		      else if (g.equals("C-")){
		         return 72;
		      }
		      else if (g.equals("C")){
		         return 75;
		      }
		      else if (g.equals("C+")){
		         return 77;
		      }
		      else if (g.equals("B-")){
		    	  return 82;
		      }
		      else if (g.equals("B")){
		    	  return 85;
		      }
		      else if (g.equals("B+")){
		    	  return 87;
		      }
		      else if (g.equals("A-")){
		    	  return 92;
		      }
		      else if (g.equals("A")){
		    	  return 95;
		      }
		      else if (g.equals("A+")){
		    	  return 97;
		      }		      
		      else 
		         return 00;
	}
}
