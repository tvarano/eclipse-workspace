//Thomas Varano
//[Program Descripion]
//Oct 25, 2017

package packageA;

public class ClassOne
{
   int paramOne, paramTwo;
   
   public ClassOne(int a, int b) {
      setParamOne(a); setParamTwo(b);
   }

   public int getParamOne() {
      return paramOne;
   }
   public void setParamOne(int paramOne) {
      this.paramOne = paramOne;
   }
   public int getParamTwo() {
      return paramTwo;
   }
   public void setParamTwo(int paramTwo) {
      this.paramTwo = paramTwo;
   }
}
