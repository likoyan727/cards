// Liana Ikoyan
// 002395362
// ikoyan@chapman.edu
// CPSC-231-01
// MP3A_Cards
// Creates Player object which track's player's hand, plays a turn, and picks a new suit

import java.util.LinkedList;
import java.util.Random;

public class Player {

  // new Random object
  Random rand = new Random();

  // player's number
  private int m_playerNum;
  // LinkedList tracking cards in player's hand
  private LinkedList<Card> m_playerHand = new LinkedList<Card>();
  // LinkedList tracking starter pile
  private LinkedList<Card> m_starterPile = new LinkedList<Card>();
  // dealer, keeps track of dealer stock
  private Dealer m_dealer = new Dealer();

  // overloaded constructor
  public Player(int playerNum, Dealer dealer, LinkedList<Card> starterPile) {
    m_playerNum = playerNum;
    m_starterPile = starterPile;
    m_dealer = dealer;

    for (Card c : m_dealer.deals(5)) {
      m_playerHand.add(c);
    }

  }

  // takeTurn
  // player takes turn by trying to match suit or value of top card, draws card if there are no matches, automatically plays card with 8 value
  // returns played card if there's a match or if value is 8, returns null otherwise
  public Card takeTurn() {
    Card topCard = m_starterPile.get(m_starterPile.size() - 1);

    // System.out.println("TopCard: " + topCard);

    LinkedList<Card> playerHandCopy = new LinkedList<Card>();
    for (Card c : m_playerHand) {
      playerHandCopy.add(c);
    }

    for (Card c : playerHandCopy) {
      if ((c.getSuit() == topCard.getSuit()) || (c.getValue() == topCard.getValue())) {
        // Card playedCard = new Card(c);

        m_playerHand.remove(c);
        return c;
      }
      else if (c.getValue() == 8) {
        // Card playedCard = new Card(c);
        m_playerHand.remove(c);
        return c;
      }
      else {
        if (m_dealer.size() > 0) {

          m_playerHand.add(m_dealer.deals(1).get(0));

        } else {
          return null;
        }
      }
    }
    return null;
  }

  // newSuit
  // adds a new card to the starter pile specifying new suit to match
  // returns the new card's suit
  public int newSuit() {
    Card newTopCard = new Card(rand.nextInt(4), 8);
    m_starterPile.add(newTopCard);

    return newTopCard.getSuit();
  }

  // accessor for player hand LinikedList
  public LinkedList<Card> getPlayerHand() {
    return m_playerHand;
  }

}
