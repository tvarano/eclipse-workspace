package schoolWork.before;

//Thomas Varano
//Quadizzle 2.0
//Sep 18, 2017

public class Quadratic implements Comparable<Quadratic>
{
   private double a, b, c;
   private final double EPSILON = 1e-10;
   
   public Quadratic(double a, double b, double c) {
      setA(a); setB(b); setC(c);
   }
   
   public double getDiscriminant() {
      return (Math.pow(b, 2)-4*a*c);
   }
   
   private double quadraticFormula(boolean plus) {
      double sqrt = Math.sqrt(getDiscriminant());
      if (sqrt == getDiscriminant())
         return -1;
      if (plus) {
         return (-b + Math.sqrt(getDiscriminant()))/(2*a);
      }
      return (-b - Math.sqrt(getDiscriminant()))/(2*a);
   }
   
   public double[] solve(){
      double[] solutions = new double[0];
      if (2*a == 0 || quadraticFormula(true) == -1)
         return solutions;
      solutions = new double[2];
      solutions[0] = quadraticFormula(false);
      solutions[1] = quadraticFormula(true);
      return solutions;
   }
   
   public boolean equals(Quadratic q) {
      return ((Math.abs(a-q.getA()) < EPSILON) && (Math.abs(b-q.getB()) < EPSILON) && (Math.abs(c-q.getC()) < EPSILON));
   }
   public double getYValue(double x) {
      return a*Math.pow(x, 2)+b*x+c;
   }
      
   public double getVertexX() {
      return -b/(2*a);
   }
   
   public String getVertex() {
      return "("+getVertexX()+","+getYValue(getVertexX())+")";
   }
   
   public double getSolution1() {
      return quadraticFormula(false);
   }
   
   public double getSolution2() {
      return quadraticFormula(true);
   }
   
   public boolean hasRealSolutions() {
      return (solve().length > 0);
   }
   
   public String getStandardForm() {
      String bSign = (b < 0) ? "" : "+";
      String cSign = (c < 0) ? "" : "+";
      return a+"x\u00B2"+bSign+b+"x"+cSign+c;
   }
   
   public String toString() {
      return getClass().getName()+"[a = "+a+" b = "+b+" c = "+c+"]";
   }

   public int compareTo(Quadratic q) {
      return (int) (getDiscriminant() - q.getDiscriminant());
   }
   
   public double getA() {
      return a;
   }
   public void setA(double a) {
      this.a = a;
   }
   public double getB() {
      return b;
   }
   public void setB(double b) {
      this.b = b;
   }
   public double getC() {
      return c;
   }
   public void setC(double c) {
      this.c = c;
   }
   
   
   public static void main(String[] args) {
      Quadratic q1 = new Quadratic (3, 2, -1);
      System.out.println(q1.getStandardForm()); //expected output: 3x2 + 2x – 1
      System.out.println(q1.getYValue(5)); //expected output: 84
      System.out.println(q1.getVertexX()); //expected output: -0.333333
      System.out.println(q1.getVertex()); //expected output: (-0.33, -1.33)
      System.out.println(q1.getDiscriminant()); //expected output: 16
      System.out.println(q1.hasRealSolutions()); //expected output: true
      System.out.println(q1.getSolution1()); //expected output: -1
      System.out.println(q1.getSolution2()); //expected output: 0.3333333
      System.out.println(q1.toString()); //expected output:[varies by student]
      Quadratic q2 = new Quadratic (2, 4, 5);
      System.out.println(q1.compareTo(q2)); //expected output: 40
      System.out.println(q1.equals(q2)); //expected output: false
      System.out.println(q2.equals(new Quadratic (2, 4, 5)));
      //expected output: true
   }
}
