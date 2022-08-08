// Liana Ikoyan
// 002395362
// ikoyan@chapman.edu
// CPSC-231-01
// MP3A_Cards
// This class creates decks of cards as a LinkedList of Card objects

import java.util.LinkedList;
import java.util.Random;

public class Deck {
  // new random object
  Random ran = new Random();

  // LinkedList of all cards in the decks
  protected LinkedList<Card> m_cards = new LinkedList<Card>();

  // default constructor
  public Deck() {
    int suit;
    int value;

    for (suit = 0; suit < 4; ++suit){
      for (value = 2; value < 15; ++value) {
        m_cards.add(new Card(suit, value));
      }
    }
  }

  // copy constructor
  public Deck(Deck otherDeck) {
    for (int i = 0; i < otherDeck.size(); ++i) {
      m_cards.add(new Card(otherDeck.m_cards.get(i)));
    }
  }

  // toString
  // prints out all cards currently in the deck
  public String toString() {
    System.out.println("Cards in Deck: ");
    for ( Card c : m_cards) {
      System.out.println(c.toString());
    }
    return "";
  }

  // size
  // returns the number of cards in the deck
  public int size() {
    return m_cards.size();
  }

  // deal
  // picks a random card from the deck and removes it from the deck
  // returns the randomly picked card
  public Card deal() {
    int randInt = ran.nextInt(size());
    Card copyCard = new Card(m_cards.get(randInt));
    m_cards.remove(randInt);
    return copyCard;
  }
}
