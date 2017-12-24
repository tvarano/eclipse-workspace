import javax.swing.JOptionPane;


//Thomas Varano
//Windows pop up
//Sep 14, 2016

public class JOptionIntro
{

   public static void main(String[] args)
   {
      //Scanner input = new Scanner(System.in);
      //String name = JOptionPane.showInputDialog(null, "Please enter your name");
      //JOptionPane.showMessageDialog(null, "Hi, " + name);
      
      
      System.out.println((-10.0 + sqrt(10*10-4*4*6))/(2*4));
      System.out.println(Math.sqrt(10*10-4*4*6));
      //Scanner input = new Scanner(System.in);
         String anum = JOptionPane.showInputDialog(null,"Enter number A.",JOptionPane.QUESTION_MESSAGE);
         String bnum = JOptionPane.showInputDialog("Enter number B.");
         String cnum = JOptionPane.showInputDialog("Enter Number C.");
           double a = Double.parseDouble(anum);
           double b = Double.parseDouble(bnum);
           double c = Double.parseDouble(cnum);
         double quad1 = ((-b + Math.sqrt(b*b-4*a*c)) / 2*a);
         double quad2 = ((-b - Math.sqrt(b*b-4*a*c)) / 2*a);
         
         String[] names = {"hi","Tom", "ben", "john", "henry", "hello"};
         
         JOptionPane.showInputDialog(null, "Choose this",
                                    "hi this works?",
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    names,
                                    "Hi");
      
      JOptionPane.showMessageDialog(null, "The answers are: "+ quad1 + " and " + quad2);
      
      System.exit(0);
      
      }

   private static int sqrt(double d)
   {
      return 0;
   }
}
