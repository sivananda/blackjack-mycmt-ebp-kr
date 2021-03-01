package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

  // Player Ties = get Bet back
  // Player BJ = Bet + Bet + 50% Bet

  private TestUtility testUtility = new TestUtility();

  @Test
  public void playerWith20Bets10WhenWinsBalanceIs30() throws Exception {
    Player player = new Player();
    player.deposits(20);
    player.bets(10);

    player.playerWins();

    assertThat(player.balance())
        .isEqualTo(30);
  }

  @Test
  public void playerWith80Bets70WhenTiesBalanceIs80() throws Exception {
    Player player = new Player();
    player.deposits(80);
    player.bets(70);

    player.playerTies();

    assertThat(player.balance())
        .isEqualTo(80);
  }

  @Test
  public void playerWith35Bets30WhenLosesBalanceIs5() throws Exception {
    Player player = new Player();
    player.deposits(35);
    player.bets(30);
    player.playerLoses();

    assertThat(player.balance())
        .isEqualTo(5);
  }

  @Test
  public void playerWith40Bets15BalanceIs25() throws Exception {
    Player player = new Player();
    player.deposits(40);
    player.bets(15);

    assertThat(player.balance())
        .isEqualTo(25);
  }

  @Test
  public void playerDeposits18DollarsBalanceIs18Dollars() throws Exception {
    Player player = new Player();
    player.deposits(18);
    assertThat(player.balance())
        .isEqualTo(18);
  }

  @Test
  public void testPlayerRole() {
    Player player = new Player();
    assertThat(player.getPlayerRole()).isEqualTo(PlayerRole.PLAYER);
  }

  @Test
  public void playerBeatsDealer() {
    Player player = new Player();
    Dealer dealer = new Dealer();
    player.drawCardIntoHand(testUtility.getAceOfSpades());
    player.drawCardIntoHand(testUtility.getTwoOfHearts());
    dealer.drawCardIntoHand(testUtility.getFiveOfHearts());
    dealer.drawCardIntoHand(testUtility.getFiveOfSpades());
    assertThat(player.beats(dealer)).isEqualTo(true);
  }

  @Test
  public void dealerBeatsPlayer() {
    Player player = new Player();
    Dealer dealer = new Dealer();
    player.drawCardIntoHand(testUtility.getFiveOfHearts());
    player.drawCardIntoHand(testUtility.getFiveOfSpades());
    dealer.drawCardIntoHand(testUtility.getAceOfHearts());
    dealer.drawCardIntoHand(testUtility.getTwoOfHearts());
    assertThat(player.beats(dealer)).isEqualTo(false);
  }

  @Test
  public void playerPushesWithDealer() {
    Player player = new Player();
    Dealer dealer = new Dealer();
    player.drawCardIntoHand(testUtility.getAceOfHearts());
    player.drawCardIntoHand(testUtility.getFiveOfHearts());
    dealer.drawCardIntoHand(testUtility.getAceOfSpades());
    dealer.drawCardIntoHand(testUtility.getFiveOfSpades());
    assertThat(player.pushesWith(dealer)).isEqualTo(true);
  }

  @Test
  public void playerDoesNotPushesWithDealer() {
    Player player = new Player();
    Dealer dealer = new Dealer();
    player.drawCardIntoHand(testUtility.getAceOfHearts());
    player.drawCardIntoHand(testUtility.getFiveOfHearts());
    dealer.drawCardIntoHand(testUtility.getFiveOfSpades());
    dealer.drawCardIntoHand(testUtility.getTwoOfHearts());
    assertThat(player.pushesWith(dealer)).isEqualTo(false);
  }

  @Test
  public void playerBets5ThenBets10TotalAmountBetIs15() {
    Player player = new Player();
    player.deposits(100);
    player.bets(5);
    player.bets(10);
    assertThat(player.totalAmountBet()).isEqualTo(5+10);
  }

  @Test
  public void playerDeposits200Bets5ThenBets110TotalBalanceIs95() {
    Player player = new Player();
    player.deposits(200);
    player.bets(5);
    player.bets(110);
    assertThat(player.balance()).isEqualTo(200 -  5 - 110 + 10);
  }
}