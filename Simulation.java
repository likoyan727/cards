// Liana Ikoyan
// 002395362
// ikoyan@chapman.edu
// CPSC-231-01
// MP3A_Cards
// Simulates, calculates, and reports Crazy Eights games. Driver class for Player and Game classes

import java.util.LinkedList;

public class Simulation {

  // number of games to be played
  private int m_numGames;
  // total score of player 1 across all games
  private int m_player1TotalScore;
  // total score of player 2 across all games
  private int m_player2TotalScore;
  // total number of wins by player 1 across all games
  private int m_wins1;
  // total number of wins by player 2 across all games
  private int m_wins2;
  // total number of cards in the losing player's hand after every game
  private int m_numLosingCards;
  // average number of cards in the losing player's after every game
  private int m_avgLosingCards;
  // total number of times the stock was empty across all games
  private int m_numStockEmpty;
  // total number of eights played across all games
  private int m_numEightsPlayed;
  // average number of eights played across all games
  private int m_avgEightsPlayed;


  // overloaded constructor
  public Simulation(int numGames) {
    m_numGames = numGames;
    m_player1TotalScore = 0;
    m_player2TotalScore = 0;
    m_wins1 = 0;
    m_wins2 = 0;
    m_numLosingCards = 0;
    m_avgLosingCards = 0;
    m_numStockEmpty = 0;
    m_numEightsPlayed = 0;
    m_avgEightsPlayed = 0;
  }

  // simulate
  // plays the game the specified number of times
  public void simulate() {
    Game newGame;
    for (int i=0; i < m_numGames; ++i) {
      newGame = new Game();
      newGame.play();
      calculate(newGame, i+1);

    }
  }

  // calculate
  // calculates the aggregate statistics of players 1 and 2 across all games
  public void calculate(Game game, int gameNum) {
    m_player1TotalScore += game.getPlayer1Score();
    m_player2TotalScore += game.getPlayer2Score();

    if (game.getPlayer1Score() < game.getPlayer2Score()) {
      m_wins1 += 1;
      m_numLosingCards += game.getPlayer2().getPlayerHand().size();
    } else {
      m_wins2 += 1;
      m_numLosingCards += game.getPlayer1().getPlayerHand().size();
    }
    m_avgLosingCards = m_numLosingCards / gameNum;

    if (game.getDealer().size() == 0) {
      m_numStockEmpty += 1;
    }

    m_numEightsPlayed += game.getEightsPlayed();
    m_avgEightsPlayed = m_numEightsPlayed / gameNum;


  }

  // report
  // prints final staticstics to the screen
  public void report() {
    System.out.println("Statistics: ");
    System.out.println(" Number of games won by Player 1: " + m_wins1);
    System.out.println(" Number of games won by Player 2: " + m_wins2);
    System.out.println(" Number of points collected by Player 1: " + m_player1TotalScore);
    System.out.println(" Number of points collected by Player 2: " + m_player2TotalScore);
    System.out.println(" The average number of cards held by the losing player when the game ended: " + m_avgLosingCards);
    System.out.println(" The number of times the stock became empty during the games: " + m_numStockEmpty);
    System.out.println(" The average number of times an Eight was played as a wild card: " + m_avgEightsPlayed);

  }

  // main method
  public static void main(String[] args) {
    Simulation games = new Simulation(3);
    games.simulate();
    games.report();

  }
}
