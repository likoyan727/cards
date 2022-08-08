// Liana Ikoyan
// 002395362
// ikoyan@chapman.edu
// CPSC-231-01
// MP3A_Cards
// Creates Game object which plays one game of Crazy Eights and calculates the scores

import java.util.LinkedList;

public class Game {

  // player 1
  private Player m_player1;
  // player 2
  private Player m_player2;
  // dealer, keeps track of dealer stock
  private Dealer m_dealer;
  // starter pile
  private LinkedList<Card> m_starterPile;
  // score of player 1
  private int m_player1Score;
  // score of player 2
  private int m_player2Score;
  // tracks number of eights played in game
  private int m_eightsPlayed;

  // default constructor
  public Game() {
    m_dealer = new Dealer();
    m_starterPile = new LinkedList<Card>();
    m_starterPile.add(m_dealer.deals(1).get(0));
    m_player1 = new Player(1, m_dealer, m_starterPile);
    m_player2 = new Player(2, m_dealer, m_starterPile);
  }

  // points
  // calculates the amount of points a card is worth
  // returns amount of points
  public int points(Card card) {
    int points = 0;
    if (card.getValue() > 9 && card.getValue() < 14) {
      points += 10;
    } else if (card.getValue() == 14) {
      points += 1;
    } else if (card.getValue() == 8) {
      points += 50;
    } else {
      points += card.getValue();
    }
    return points;
  }

  // calcScores
  // adds the points of each card in the player's hand to their score
  public void calcScores() {
    m_player1Score = 0;
    m_player2Score = 0;
    for (Card c : m_player1.getPlayerHand()) {
      m_player1Score += points(c);
    }
    for (Card d : m_player2.getPlayerHand()) {
      m_player2Score += points(d);
    }

  }

  // play
  // carries out the rules of Crazy Eights until a player wins
  public void play() {
    Card playedCard1;
    Card playedCard2;
    calcScores();

    while ((m_player1Score != 0) && (m_player2Score != 0)) {
      playedCard1 = m_player1.takeTurn();

      if (playedCard1 != null) {
        m_starterPile.add(playedCard1);

        if (playedCard1.getValue() == 8) {
          m_player1.newSuit();
          m_eightsPlayed += 1;
        }
      }

      playedCard2 = m_player2.takeTurn();

      if (playedCard2 != null) {
        m_starterPile.add(playedCard2);

        if (playedCard2.getValue() == 8) {
          m_player2.newSuit();
          m_eightsPlayed += 1;
        }
      }

      calcScores();
    }

  }

  // accessors for all member variables
  public Player getPlayer1() {
    return m_player1;
  }

  public Player getPlayer2() {
    return m_player2;
  }

  public Dealer getDealer() {
    return m_dealer;
  }

  public LinkedList<Card> getStarterPile() {
    return m_starterPile;
  }

  public int getPlayer1Score() {
    return m_player1Score;
  }

  public int getPlayer2Score() {
    return m_player2Score;
  }

  public int getEightsPlayed() {
    return m_eightsPlayed;
  }

}
