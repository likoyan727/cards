// Liana Ikoyan
// 002395362
// ikoyan@chapman.edu
// CPSC-231-01
// MP3A_Cards
// This class creates a Deck object and manages the cards dealt

import java.util.LinkedList;

public class Dealer {
  // deck of cards
  private Deck m_deck;

  // default constructor
  public Dealer() {
    m_deck = new Deck();
  }

  // deals
  // deals specfied amount of randomly selected cards
  // returns a LinkedList of cards dealt
  public LinkedList<Card> deals(int n) {
    LinkedList<Card> dealtCards = new LinkedList<Card>();

    if (m_deck.size() == 0) {
      return dealtCards;
    }

    for (int i = 0; i < n; ++i) {
      //dealtCards.add(m_deck.get(i).deal());
      dealtCards.add(m_deck.deal());
    }
    return dealtCards;
  }

  // size
  // returns the number of cards in the deck
  public int size() {
    return m_deck.size();
  }

  // toString
  // prints all cards currently in the deck
  public String toString() {
    m_deck.toString();
    return "";
  }

}
