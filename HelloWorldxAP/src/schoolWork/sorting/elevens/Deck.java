//Thomas Varano
//Mar 12, 2018

package schoolWork.sorting.elevens;

import java.util.ArrayList;
import java.util.List;

public class Deck {
   /**
    * cards contains all the cards in the deck.
    */
   private List<Card> cards;

   /**
    * size is the number of not-yet-dealt cards.
    * Cards are dealt from the top (highest index) down.
    * The next card to be dealt is at size - 1.
    */
   private int size;


   /**
    * Creates a new <code>Deck</code> instance.<BR>
    * It pairs each element of ranks with each element of suits,
    * and produces one of the corresponding card.
    * @param ranks is an array containing all of the card ranks.
    * @param suits is an array containing all of the card suits.
    * @param values is an array containing all of the card point values.
    */
   public Deck(String[] ranks, String[] suits, int[] values) {
      cards = new ArrayList<Card>();
      for (int i = 0; i < suits.length; i++)
         for (int j = 0; j < ranks.length; j++)
            cards.add(new Card(ranks[j], suits[i], values[j]));
      size = cards.size();
   }


   /**
    * Determines if this deck is empty (no undealt cards).
    * @return true if this deck is empty, false otherwise.
    */
   public boolean isEmpty() {
      return size == 0;
   }

   /**
    * Accesses the number of undealt cards in this deck.
    * @return the number of undealt cards in this deck.
    */
   public int size() {
      return size;
   }

   /**
    * Randomly permute the given collection of cards
    * and reset the size to represent the entire deck.
    */
   public void shuffle() {
      for (int i = cards.size() - 1; i > 0; i--) {
         int random = (int) (Math.random() * i);
         cards.set(i, cards.set(random, cards.get(i)));
      }
      size = cards.size();
   }
   
   public void perfectShuffleBad() {
      Card[] halfOne = new Card[cards.size() / 2];
      Card[] halfTwo = new Card[cards.size() / 2];
      for (int i = 0; i < cards.size() / 2; i++) {
         halfOne[i] = cards.get(i);
         halfTwo[i] = cards.get(cards.size() / 2 + i);
      }
      for (int i = 0; i < cards.size(); i++)
         if (i % 2 == 0)
            cards.set(i, halfOne[i / 2]);
         else 
            cards.set(i, halfTwo[i / 2]);
      size = cards.size();
   }
   
   public void perfectShuffle() {
      Card[] ret = new Card[cards.size()];
      for (int i = 0; i < 2; i++)
         for (int j = 0; j < cards.size() / 2; j++)
            ret[j * 2 + i] = cards.get(cards.size() / 2 * i + j);
      for (int i = 0; i < cards.size(); i++)
         cards.set(i, ret[i]);
      size = cards.size();
   }

   /**
    * Deals a card from this deck.
    * @return the card just dealt, or null if all the cards have been
    *         previously dealt.
    */
   public Card deal() {
      if (isEmpty()) return null;
      return cards.get(--size);
   }

   /**
    * Generates and returns a string representation of this deck.
    * @return a string representation of this deck.
    */
   @Override
   public String toString() {
      String rtn = "size = " + size + "\nUndealt cards: \n";

      for (int k = size - 1; k >= 0; k--) {
         rtn = rtn + cards.get(k);
         if (k != 0) {
            rtn = rtn + "\n";
         }
      }

      rtn = rtn + "\nDealt cards: \n";
      for (int k = cards.size() - 1; k >= size; k--) {
         rtn = rtn + cards.get(k);
         if (k != size) {
            rtn = rtn + "\n";
         }
      }

      rtn = rtn + "\n";
      return rtn;
   }
   
   public static void main(String[] args) {
      String[] rank = {"A", "2", "3"};
      String[] suit = {"Hearts", "Clubs"};
      int[] value = {1, 2, 3};
      
      Deck d = new Deck(rank, suit, value);
      System.out.println(d);
      d.perfectShuffle();
      System.out.println(d);
      d.deal(); d.deal(); d.deal();
      System.out.println(d);
   }
}
