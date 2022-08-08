// Liana Ikoyan
// 002395362
// ikoyan@chapman.edu
// CPSC-231-01
// MP3A_Cards
// This class creates card objects,specifying value and suit

public class Card {

  // suit of the card
  private int m_suit;
  // value of the card
  private int m_value;

  // final variables that define values and suits
  public static final int HEARTS = 0;
  public static final int SPADES = 1;
  public static final int CLUBS = 2;
  public static final int DIAMONDS = 3;

  public static final int JACK = 11;
  public static final int QUEEN = 12;
  public static final int KING = 13;
  public static final int ACE = 14;

  // default constructor
  public Card() {
    m_suit = 0;
    m_value = 0;
  }

  // overloaded constructor
  public Card(int suit, int value) {
    if ((suit >= 0) && (suit <= 3) && (value >= 2) && (value <= 14)) {
      m_suit = suit;
      m_value = value;
    } else {
      System.out.println("Invalid suit or value");
    }
  }

  // copy constructor
  public Card(Card otherCard) {
    this.m_suit = otherCard.m_suit;
    this.m_value = otherCard.m_value;
  }

  // toString
  // returns a string showing the suit and value of the card
  public String toString() {
    String suit;
    String value;
    if (m_suit == 0) {
      suit = "Hearts";
    } else if (m_suit == 1) {
      suit = "Spades";
    } else if (m_suit == 2) {
      suit = "Clubs";
    } else if (m_suit == 3) {
      suit = "Diamonds";
    } else {
      suit = String.valueOf(m_suit);
    }

    if (m_value == 11) {
      value = "Jack";
    } else if (m_value == 12) {
      value = "Queen";
    } else if (m_value == 13) {
      value = "King";
    } else if (m_value == 14) {
      value = "Ace";
    } else {
      value = String.valueOf(m_value);
    }
    return value + " of " + suit;
  }

  // equals
  // determines if two cards are equal
  // returns true or false
  public boolean equals(Card otherCard){
    // if (otherCard.equals(null)){
    //   return ;
    // }
    if (this.m_value == otherCard.m_value){
      return true;
    } else {
      return false;
    }
  }

  // accessors and mutators for both member variables

  public void setSuit(int suit) {
    m_suit = suit;
  }
  public int getSuit() {
    return m_suit;
  }

  public void setValue(int value) {
    m_value = value;
  }
  public int getValue() {
    return m_value;
  }



}
