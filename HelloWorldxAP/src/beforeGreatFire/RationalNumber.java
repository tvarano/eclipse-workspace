package beforeGreatFire;
//Thomas Varano
//[Program Descripion]
//Sep 30, 2017

public class RationalNumber implements Comparable<RationalNumber>
{
   private int n, d;
   
   public RationalNumber(int n, int d) {
      setNumerator(n); setDenominator(d);
   }
   public RationalNumber(String num) {
      this();
      try {
         setNumerator(Integer.parseInt(num.substring(0, num.indexOf('/'))));
         setDenominator(Integer.parseInt(num.substring(num.indexOf('/')+1)));
      } catch (NumberFormatException a) {
         System.err.println("not a num");
      } catch (IndexOutOfBoundsException b) {
         System.err.println("no slash");
      }
   }
   //works sometimes
   public RationalNumber(double decimal) {
      double convDec = decimal;
      String dec = convDec +"";
      if (convDec > 1)
         convDec -= (int)convDec;
      int decLen = dec.length();
      int denom = (int) Math.pow(10, decLen);
      int num = (int)(convDec * denom);
      num +=(int) decimal * denom;
      RationalNumber r = new RationalNumber(num, denom).simplify();
      
      setNumerator(r.getNumerator()); setDenominator(r.getDenominator());
   }
   public RationalNumber() {
      this(0,1);
   }
   
   public RationalNumber simplify() {
      int newD = d / gcf(n,d);
      int newN = n / gcf(n,d);
      if (newD < 0) {
         newD = -newD;
         newN = -newN;
      }
      setNumerator(newN); setDenominator(newD);
      return this;
   }
   
   public int commonDenom(RationalNumber r) {
      return lcm(d, r.d);
   }
   
   public RationalNumber bringToCommonDenom(RationalNumber r) {
      setNumerator(n * (commonDenom(r)/d)); setDenominator(commonDenom(r));
      return this;
   }
   
   public RationalNumber add(RationalNumber r) {
      this.bringToCommonDenom(r);
      r.bringToCommonDenom(this);
      n+=r.n;
      d = commonDenom(r);
      return simplify();
   }
   
   public RationalNumber getOpposite() {
      return new RationalNumber(-n, d);
   }
   
   public RationalNumber subtract(RationalNumber r) {
      return add(r.getOpposite());
   }
   
   public RationalNumber multiply(RationalNumber r) {
      setNumerator(n * r.n); setDenominator(d * r.d);
      return simplify();
   }
   
   public RationalNumber power(int n) {
      for (int i = 0; i < n-1; i++)
         multiply(this);
      return this;
   }
   
   public RationalNumber divide(RationalNumber r) {
      return multiply(r.getReciprocal());
   }
   
   public static int gcf(int a, int b) {
      for (int i = Math.min(Math.abs(a), Math.abs(b)); i > 0; i--) {
         if (a % i == 0 && b % i == 0)
            return i;
      }
      System.err.println("ERROR IN GCF");
      return 1;
   }
   
   public static int lcm(int a, int b) {
      a = Math.abs(a); b = Math.abs(b);
      int i = Math.max(a, b);
      int max = i;
      while (i % a != 0 || i % b != 0) {
         i += max;
      }
      return i;
   }
   
   public RationalNumber getReciprocal() {
      return new RationalNumber(d, n);
   }
   
   public double getDecimal() {
      return n/(d*1.0);
   }
   
   
   @Override
   public int compareTo(RationalNumber r) {
      return clone().subtract(r.clone()).getNumerator();
   }
   
   public RationalNumber clone() {
      return new RationalNumber(n, d);
   }
   
   public String getRationalNum() {
      return n+"/"+d;
   }
   
   public String toString() {
      return getRationalNum();
   }
   
   public int getNumerator() {
      return n;
   }
   public void setNumerator(int n) {
      this.n = n;
   }
   public int getDenominator() {
      return d;
   }
   public void setDenominator(int d) {
      this.d = d;
   }
   
   
   
   public static void main(String[] args) {
      System.out.println(new RationalNumber(1.7));
      RationalNumber r1 = new RationalNumber(5, 10);
      RationalNumber r2 = new RationalNumber ("2/3");
      System.out.println(r1.getRationalNum()); //expected output: 5/10
      System.out.println(r2.getDecimal()); //expected output: 0.666666
      System.out.println(r2.getReciprocal()); //expected output: 3/2
      System.out.println(RationalNumber.gcf(12, 30)); //expected output: 6
      System.out.println(RationalNumber.lcm(6, 8)); //expected output: 24
      r1.simplify();System.out.println(r1); //expected output: 1/2
      r1.add(r2);System.out.println(r1); //expected output: 7/6
      r2.subtract(r1);System.out.println(r2); //expected output: –1/2
      r1.multiply(r2);System.out.println(r1); //expected output: –7/12
      r1.divide(r2);System.out.println(r1); //expected output: 7/6
      r1.power(2);System.out.println(r1); //expected output: 49/36
      System.out.println(r1.compareTo(r2)); //expected output: 67
      System.out.println(r1.equals(r2)); //expected output: false
   }
}
