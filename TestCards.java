// Liana Ikoyan
// 002395362
// ikoyan@chapman.edu
// CPSC-231-01
// MP3A_Cards
// Driver class for Card, Dealer, and Deck classes

public class TestCards {
  public static void main(String[] args) {

    Card card1 = new Card(0,2);
    System.out.println(card1);
    card1.setSuit(3);
    card1.setValue(14);
    System.out.println(card1);


    Deck deck1 = new Deck();
    deck1.toString();
    System.out.println(deck1.size());
    System.out.println(deck1.deal());
    System.out.println(deck1.size());

    Dealer dealer1 = new Dealer();
    dealer1.toString();
    System.out.println(dealer1.size());
    dealer1.deals(5);
    System.out.println(dealer1.size());


  }
}
