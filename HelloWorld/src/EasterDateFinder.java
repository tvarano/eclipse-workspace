import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

//Thomas Varano
//Whens easter?
//Nov 2, 2016

public class EasterDateFinder
{
   public static void main(String[] args)
   {
      ImageIcon moses = new ImageIcon(EasterDateFinder.class.getResource("moses3.gif"));
      int y = Integer.parseInt((String) JOptionPane.showInputDialog(null,"Hey enter a year man so you can see when easter is.","Easter",
            JOptionPane.PLAIN_MESSAGE,
            moses, null, "Input Here"));
      while(y!=-1){ 
               int a = y%19;
               int b = y/100;
               int c = y%100;
               int d = b/4;
               int e = b%4;
               int g = (8*b+13)/25;
               int h = (19*a+b-d-g+15)%30;
               int j = c/4;
               int k = c%4;
               int m = (a+11*h)/319;
               int r = (2*e+2*j-k-h+m+32)%7;
               int n = (h-m+r+90)/25;
               int p = (h-m+r+n+19)%32;
               String month;
               if (n == 4)
                  month = "April ";
               else if (n == 3) 
                  month = "March ";
               else 
                  month = "ERROR";
               JOptionPane.showMessageDialog(null, "The date is "+month+p,"Easter",
                     JOptionPane.PLAIN_MESSAGE,
                     moses);
               y = Integer.parseInt((String) JOptionPane.showInputDialog(null,"Hey enter a year man so you can see when easter is.","Easter",
                     JOptionPane.PLAIN_MESSAGE,
                     moses, null, "-1 to stop"));
      }
      
      
      System.exit(0);
   }
}
