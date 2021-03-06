package com.jitterted.ebp.blackjack;

import org.fusesource.jansi.Ansi;

import java.util.Scanner;

import static org.fusesource.jansi.Ansi.ansi;

public class Game {

  private final Deck deck;

  private Dealer dealer = new Dealer();
  private Player player = new Player();

  public static void main(String[] args) {
    displayWelcomeScreen();
    playGame();
    resetScreen();
  }

  private static void displayWelcomeScreen() {
    System.out.println(ansi()
                           .bgBright(Ansi.Color.WHITE)
                           .eraseScreen()
                           .cursor(1, 1)
                           .fgGreen().a("Welcome to")
                           .fgRed().a(" Jitterted's")
                           .fgBlack().a(" BlackJack"));
  }

  private static void playGame() {
    Game game = new Game();

    String input;
    do {
      game.initialDeal();
      game.play();
      System.out.println("Play again? (y/n):");
      Scanner scanner = new Scanner(System.in);
      input = scanner.nextLine();
    } while (input.equalsIgnoreCase("y"));
  }

  private static void resetScreen() {
    System.out.println(ansi().reset());
  }

  public Game() {
    deck = new Deck();
  }

  public void initialDeal() {
    dealer = new Dealer();
    player = new Player();

    // deal first round of cards, players first
    dealHand();

    // deal next round of cards
    dealHand();
  }

  private void dealHand() {
    drawCardIntoPlayerHand();
    drawCardIntoDealerHand();
  }

  private void drawCardIntoDealerHand() {
    dealer.drawCardIntoHand(deck.draw());
  }

  private void drawCardIntoPlayerHand() {
    player.drawCardIntoHand(deck.draw());
  }

  public void play() {
    // get Player's decision: hit until they stand, then they're done (or they go bust)
    boolean playerBusted = false;
    while (!playerBusted) {
      displayGameState();
      String playerChoice = inputFromPlayer().toLowerCase();
      if (playerChoice.startsWith("s")) {
        break;
      }
      if (playerChoice.startsWith("h")) {
        drawCardIntoPlayerHand();
        playerBusted = player.isBusted();
      } else {
        System.out.println("You need to [H]it or [S]tand");
      }
    }

    // Dealer makes its choice automatically based on a simple heuristic (<=16, hit, 17>stand)
    if (!playerBusted) {
      dealerPlays();
    }

    displayFinalGameState();

    handleGameOutcome();
  }

  private void dealerPlays() {
    while (dealer.plays()) {
      drawCardIntoDealerHand();
    }
  }

  private void handleGameOutcome() {
    if (player.isBusted()) {
      System.out.println("You Busted, so you lose.  💸");
    } else if (dealer.isBusted()) {
      System.out.println("Dealer went BUST, Player wins! Yay for you!! 💵");
    } else if (player.beats(dealer)) {
      System.out.println("You beat the Dealer! 💵");
    } else if (player.pushesWith(dealer)) {
      System.out.println("Push: The house wins, you Lose. 💸");
    } else {
      System.out.println("You lost to the Dealer. 💸");
    }
  }

  private String inputFromPlayer() {
    System.out.println("[H]it or [S]tand?");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  private void displayGameState() {
    clearScreen();
    displayDealerHand();
    player.displayHand();
  }

  private void displayFinalGameState() {
    clearScreen();
    dealer.displayHand();
    player.displayHand();
  }

  private void displayDealerHand() {
    dealer.displayUpCard();
    dealer.displayHoleCard();
  }

  private void clearScreen() {
    System.out.print(ansi().eraseScreen().cursor(1, 1));
  }
}
