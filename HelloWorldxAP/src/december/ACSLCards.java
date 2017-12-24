//Thomas Varano


//JUST FOR PERSONAL PACKAGING... REMOVE AND THEN COMPILE
package december;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * ACSL contest #1
 * @author Thomas Varano
 *
 */
public class ACSLCards
{  
   private static final Character[] cardValues = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
   private static final int[] pts = {2, 3, 4, 5, 6, 7, 8, 0, -10, 11, 12, 13, 14};
  
   public static void main(String[] args) {
      //read all data, store as string
      Scanner in = new Scanner(System.in);
         //first line, read and format
      System.out.println("Enter line 1");
      String rawData = in.nextLine();
      StringBuilder p1Values = new StringBuilder();
      StringBuilder p2Values = new StringBuilder();
      final int handSize = 5;
      final ArrayList<Card> p1Start = new ArrayList<Card>();
      final ArrayList<Card> p2Start = new ArrayList<Card>();
      int index = 0;      
      // format strings
      StringBuilder playerString = p1Values;
      for (int i = 0; i < handSize * 2; i++) {
         if (i == handSize)
            playerString = p2Values;
         String addition = (rawData.indexOf(", ", index) == -1)
               ? rawData.substring(index)
               : rawData.substring(index, rawData.indexOf(", ", index));
               playerString.append(addition);
         index += addition.length() + ", ".length();
      }
      for (int i = 0; i < handSize; i++) {
         p1Start.add(new Card(p1Values.toString().charAt(i)));
         p2Start.add(new Card(p2Values.toString().charAt(i)));
      }
      //Start loop here
      final int amtLines = 6;
      int linesDone = 1;
      while (linesDone < amtLines) {
         ArrayList<Card> p1 = new ArrayList<Card>(); p1.addAll(p1Start);
         ArrayList<Card> p2 = new ArrayList<Card>(); p2.addAll(p2Start);
         // read data for the game
         rawData = in.nextLine();
         index = 0;
         int pts = Integer.parseInt(rawData.substring(0, rawData.indexOf(',')));
         final int amtCards = 10;
         Card[] pile = new Card[amtCards];
         for (int i = 2; i < rawData.length(); i++) {
            if (rawData.charAt(i) != ',' && rawData.charAt(i) != ' ') {
               pile[index] = new Card(rawData.charAt(i));
               System.out.println(pile[index]);
               index++;
            }
         }
         int pileIndex = 0;
         // play game
         final String[] playerNames = {"Player #1", "Player #2"};
         final int[] borders = {33, 55, 77};
         int currentPlayer = 0;
         final int goal = 100;
         while (pts < goal && (!p1.isEmpty() && !p2.isEmpty())) {
            int begin = pts;
            ArrayList<Card> playerHand = (currentPlayer == 0) ? p1 : p2;
            int addition = findMedian(playerHand).getPtVal();
            playerHand.remove(findMedian(playerHand));
            if (pileIndex < pile.length)
               playerHand.add(pile[pileIndex]);
            pileIndex++;
            //checking for 7
            if (addition == 7 && goal - pts <= 7)
               addition = 1;
            pts += addition;
            
            // checking for borders, first up then down
            for (int i : borders) {
               if (begin < i && pts > i)
                  pts += 5;
               else if (begin > i && pts < i)
                  pts += 5;
            }
            currentPlayer = (currentPlayer == 0) ? 1 : 0;
         }
         if (pts < 100 && (p1.isEmpty() || p2.isEmpty()))
            System.out.println(pts + ", No Winner");
         System.out.println(pts + ", " + playerNames[currentPlayer]);
         
         linesDone++;
      }
              
      in.close();
      System.exit(0);
   }
   
   private static Card findMedian(ArrayList<Card> list) {
      Collections.sort(list);
      return list.get(list.size()/2);
   }
   
   private static class Card implements Comparable<Card> {
      private char value;
      public Card(char value) {
         this.value = value;
      }
      public int getPtVal() {
         return pts[Arrays.asList(cardValues).indexOf(value)];
      }
      @Override
      public int compareTo(Card arg0) {
         return Arrays.asList(cardValues).indexOf(value) - Arrays.asList(cardValues).indexOf(arg0.value);
      }
      public String toString() {
         return "Card["+value + "]";
      }
   }
}
