//Thomas Varano
//[Program Descripion]
//Dec 26, 2017

package december;

public @interface Unused {
   String text()
   default "This method is not used";
}
