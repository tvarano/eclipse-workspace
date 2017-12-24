
import javax.swing.JOptionPane;

//Thomas Varano
//Calculator
//Oct 5, 2016
public class Calca
{
   public static void main(String[] args)
   {
          String equation;

    while(true)
      {equation = (String) JOptionPane.showInputDialog(null, "Type Your Equation (Spaces in between)\nAlso enter \"stop\" to exit.", 
                                 "Calculator", JOptionPane.PLAIN_MESSAGE,null, null, "--");
      if (equation == "stop");
         System.exit(0);
      //TODO halfone goes until space, but if no space, can't tell how long half one is
      if (equation.charAt(equation.indexOf('+')-1) != ' ') break;
      String halfone;
    //  if (equation.charAt(halfone.length()+2) != ' ') break;
      halfone = equation.substring(0,equation.indexOf(' '));
      String halftwo = equation.substring(equation.indexOf(' ')+3);
      System.out.println("\"" + equation.charAt(halfone.length()) + "\"");
      System.out.println("\"" + equation.charAt(halfone.length()+2) + "\"");
           //TODO make it so if no spaces are entered, prompt again for entering or just exit
           //TODO make it so if String entered, prompt again or just exit
      char plus = '+';
      char minus = '-';
      char mult = '*';
      char div = '/';
//      if (Double.parseDouble(halfone) == ())break;
      
           double a = Double.parseDouble(halfone);
           double b = Double.parseDouble(halftwo);
          // if (a  >= 0) continue;
          // else break;
        //FIXME it does all operations when it shouldn't?
           //TODO else if?
           JOptionPane.showMessageDialog(null, equation.charAt(halfone.length() + 1));
        if (equation.charAt(halfone.length() + 1)  == plus)
           JOptionPane.showMessageDialog(null, "The answer is " + (a + b));
        else if (equation.charAt(halfone.length() + 1) == minus)
           JOptionPane.showMessageDialog(null, "The answer is " + (a - b)); 
        else if (equation.charAt(halfone.length() + 1) == mult)
           JOptionPane.showMessageDialog(null, "The answer is " + (a / b));
        else if (equation.charAt(halfone.length() + 1) == div)
           JOptionPane.showMessageDialog(null, "The answer is " + (a * b));
        }
    JOptionPane.showMessageDialog(null, "An error has occurred.", "Error", JOptionPane.ERROR_MESSAGE, null);
    System.exit(0);
      }   
   }

