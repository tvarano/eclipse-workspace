import java.util.ArrayList;

//Thomas Varano
//[Program Descripion]

//Dec 11, 2016

public class ArrayTester {

	public static void main(String[] args) {
		ArrayList<String> test = new ArrayList<String>(5);
		System.out.println(test.size());
   		test.add(0, "Heello1");
   		test.add(1, "Heello2");
   		test.add(2, "Heello3");
   		test.add(3, "Heello4");
   		test.add(4, "Heello5");

		System.out.println("here");
		System.out.println(test.get(0));
		for(int i = 0; i<test.size();i++){
		   System.out.println(test.get(i));
		   System.out.println("what");
		}
	}

}
