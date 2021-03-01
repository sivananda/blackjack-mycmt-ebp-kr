package com.jitterted.ebp.blackjack;

/**
 * @author sthummala
 * @Since 1.0.0
 */
public class Player extends  AbstractPlayer {
    private int balance = 0;
    private int bet = 0;
    private int totalAmountBet = 0;

    public Player() {
        super();
    }

    public void deposits(int amount) {
        balance += amount;
    }

    public void bets(int betAmount) {
        bet = betAmount;
        balance -= betAmount;
        totalAmountBet += betAmount;
    }

    public int balance() {
        return balance;
    }

    public void playerWins() {
        balance += bet * 2;
    }

    public void playerLoses() {
        balance += bet * 0;
    }

    public void playerTies() {
        balance += bet * 1;
    }

    public int totalAmountBet() {
        return totalAmountBet;
    }

    public boolean beats(Dealer dealer) {
        return getHand().beats(dealer.getHand());
    }

    public boolean pushesWith(Dealer dealer) {
        return getHand().pushesWith(dealer.getHand());
    }

    @Override
    protected PlayerRole getPlayerRole() {
        return PlayerRole.PLAYER;
    }
}
