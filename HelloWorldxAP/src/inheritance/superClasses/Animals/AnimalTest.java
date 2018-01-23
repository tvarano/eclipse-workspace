//Thomas Varano
//[Program Descripion]
//Jan 22, 2018

package inheritance.superClasses.Animals;

import java.util.ArrayList;

public class AnimalTest {
   public static void main(String[] args)
   {
      Dog d = new Dog();
      System.out.println(d);
      Bird b = new Bird();
      System.out.println(b);
      System.out.println();
      Careable d1 = new Dog("Sparky");
      Careable d2 = new Dog("Fido", "04-01-12", 42);
      Careable b1 = new Bird("Tweety");
      Careable b2 = new Bird("Sam the Eagle", "07-04-02", 15, false);
   
      ArrayList<Careable> myPets = new ArrayList<Careable>();
      myPets.add(d1);myPets.add(d2);myPets.add(b1);myPets.add(b2);
   
      for(Careable c : myPets)
      System.out.println(c);
      System.out.println();
   
      System.out.println("Feeding Time:");
      for(Careable c : myPets)
      c.feed();
   
      System.out.println();
      System.out.println("Grooming Time:");
      for(Careable c : myPets)
      c.groom();
   
      System.out.println();
      System.out.println("Check-up Time:");
      for(Careable c : myPets)
      c.checkUp();
   }
   /*
      [Species: dog, Born: 01-01-2016, Weight: 0.0][Name: Default Dog][License# 10000]
      [Species: bird, Born: 01-01-2016, Weight: 0.0][Name: Default Bird][Exotic: false]
      [Species: dog, Born: 01-01-2016, Weight: 0.0][Name: Sparky][License# 10001]
      [Species: dog, Born: 04-01-12, Weight: 42.0][Name: Fido][License# 10002]
      [Species: bird, Born: 01-01-2016, Weight: 0.0][Name: Tweety][Exotic: false]
      [Species: bird, Born: 07-04-02, Weight: 15.0][Name: Sam the Eagle][Exotic: false]
      Feeding Time:
      Sparky eating dog food.
      Fido eating dog food.
      Tweety eating bird food.
      Sam the Eagle eating bird food.
      Grooming Time:
      Sparky getting a bath and clipping nails.
      Fido getting a bath and clipping nails.
      Tweety taking a bird bath and filing beak.
      Sam the Eagle taking a bird bath and filing beak.
      Check-up Time:
      Sparky getting dog stuff examined.
      Fido getting dog stuff examined.
      Tweety getting bird parts examined.
      Sam the Eagle getting bird parts examined.
    */
}
