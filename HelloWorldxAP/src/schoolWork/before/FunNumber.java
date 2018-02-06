package schoolWork.before;

public class FunNumber
{
   private int num;

   /**
   * Constructs a Fun Number from an integer parameter
   */   
   public FunNumber(int myNum)
   {
      num = myNum;
   }

   /**
   * Constructs a Fun Number from a valid String parameter
   */   
   public FunNumber(String myNum)
   {
      this(Integer.parseInt(myNum));
   }

   /**
   * @return the value of the Fun Number as an integer
   */   
   public int getFunNum()
   {
      return num;
   }

   /**
   * @return the factorial of the Fun Number
   */   
   public long funFact()
   {
      long fact = 1;
      for (int i = num; i > 0; i--) {
         fact*=num;
      }
      return fact;
   }

   /**
   * @return a string list of the factors of the Fun Number value
   */   
   public String getFactors()
   {
      String retval = "";
      for (int i = 1; i < num; i++) {
         if (num % i == 0)
            retval+=i+", ";
      }
      retval += num;
      return retval;
   }

   /**
   * @return true if the Fun Number is prime, false otherwise
   */   
   public boolean isPrime()
   {
      return getFactors().equals("1, "+num);
   }

   /**
   * @return the number of digits in the Fun Number value
   */   
   public int numDigits()
   {
      return (int) (Math.log10(num)+1);
   }

   /**
   * @return the sum of the digits that make up the Fun Number
   */         
   public int sumDigits()
   {
      int sum = 0;
      for (int i : getDigits()) {
         sum+=i;
      }
      return sum;
   }
   
   /**
    * @return an int array that contains the digits in the number
    */
   public byte[] getDigits() {
      byte[] retval = new byte[numDigits()];
      int number = num;
      int multiplier;
      for (int i = numDigits()-1, index = 0; i >= 0; i--, index++) {
         multiplier = (int)(Math.pow(10, i));
         retval[index] = (byte)(number/multiplier);
         number %= multiplier;
      }
      return retval;
   }
   
   /**
   * @return an integer with digits that are the reverse of the Fun Number digits
   */         
   public int reverseNum()
   {
      int reverse = 0;
      byte[] digits = getDigits();
      for (int i = 0; i < digits.length; i++) {
         reverse += digits[i]*Math.pow(10, i);
      }
      return reverse;
   }
   
   public static void main(String[] args) {
      FunNumber i = new FunNumber(7);
      System.out.println(i.isPrime());
      System.out.println(i);
   }
   
   /**
   * @return a String representation of the Fun Number value
   */         
   public String toString()
   {
      return getClass().getName()+"["+num+"]";
   }
   
}
