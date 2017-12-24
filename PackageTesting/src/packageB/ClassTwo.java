
//Thomas Varano
//[Program Descripion]
//Oct 25, 2017

package packageB;
import packageA.ClassOne;

public class ClassTwo
{
   int paramOne, paramTwo;
   ClassOne a;
   
   public ClassTwo(int a, int b) {
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
