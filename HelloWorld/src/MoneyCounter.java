import javax.swing.JOptionPane;

//Thomas Varano
//[Program Descripion]
//Oct 31, 2016
public class MoneyCounter
{
   public static void main(String[] args)
   {
    final byte QUARTER_VALUE = 25;
    final byte DIME_VALUE = 10;
    final byte NICKEL_VALUE = 5;
    final byte PENNY_VALUE = 1;
   
      
      String quarterstring = (String) JOptionPane.showInputDialog(null,"Input your number of quarters","Money Counter",JOptionPane.PLAIN_MESSAGE, null, null, "0");
         int quarters = Integer.parseInt(quarterstring);
      String dimestring = (String)JOptionPane.showInputDialog(null, "Input your number of dimes","Money Counter",JOptionPane.PLAIN_MESSAGE, null, null, "0");
         int dimes = Integer.parseInt(dimestring);
      String nickelstring = (String)JOptionPane.showInputDialog(null,"Input your number of nickels","Money Counter",JOptionPane.PLAIN_MESSAGE, null, null, "0");
         int nickels = Integer.parseInt(nickelstring);
      String pennystring = (String)JOptionPane.showInputDialog(null,"Input your number of pennies","Money Counter",JOptionPane.PLAIN_MESSAGE, null, null, "0");
         int penny = Integer.parseInt(pennystring);
         
     quarters = (quarters*QUARTER_VALUE);
     dimes = (dimes*DIME_VALUE);
     nickels = (nickels*NICKEL_VALUE);
     penny = PENNY_VALUE * penny;
     
     int cents = (quarters+dimes+nickels+penny);
     int dollars = cents/100;
     int centsleft = cents%100;
     
     String centleft;
     if (centsleft < 10)
        centleft = "0"+centsleft;
     else centleft = ""+centsleft;
     JOptionPane.showMessageDialog(null, "Your total amount of change is:\n$"+dollars+"."+centleft);
    
               
      
   }
}
