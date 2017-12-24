import java.util.Scanner;

public class HelloWorld2 {

   public static void main(String[] args) {
	   @SuppressWarnings("resource")
      Scanner input = new Scanner(System.in);
	     System.out.print("Print (x,y): ");
	     String full = input.nextLine();
	     System.out.print("Print (x1,y1): ");
	     String fullprime = input.nextLine();
	     System.out.println(full.indexOf(',') + " and " + full.indexOf('2'));
	    // System.out.println(full.substring(full.indexOf(","+1),full.indexOf(')')));
	     int x1 = Integer.parseInt(full.substring(1, full.indexOf(",")+1));
	     int y1 = Integer.parseInt(full.substring(full.indexOf(","+1),full.indexOf((')')-1)));
	     int x2 = Integer.parseInt(fullprime.substring(2, fullprime.indexOf(",")));
	     int y2 = Integer.parseInt(fullprime.substring(fullprime.indexOf(","+1),fullprime.indexOf(')'-1)));
   	   double slope = (y1 - y2)/(x1 - x2)*1.0;
   	   double dist = Math.sqrt((Math.pow(x2-x1,2))+(Math.pow(y1-y2,2)));
   	   double midpx = (x1+x2)/2.0;
   	   double midpy = (y1+y2)/2.0;
	   System.out.println("For the coordinates (" + y1 + ","+ x1 + ") and (" + y2 + "," + x2 + ")...\n\tSlope: " + slope + 
	                     "\nDistance: " + dist
	                     +"\nMidpoint: ("+midpx+','+midpy+")");
	         
	         
	}
}