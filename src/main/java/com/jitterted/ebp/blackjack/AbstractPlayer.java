package com.jitterted.ebp.blackjack;

public abstract class BasePlayer {
    private Hand hand;
    private int playerBalance = 0;
    private int playerBet = 0;

    public BasePlayer() {
        this.hand = new Hand();
    }

    public boolean beats(BasePlayer dealer) {
        return this.hand.beats(dealer.hand);
    }

    public boolean pushesWith(BasePlayer dealer) {
        return this.hand.pushesWith(dealer.hand);
    }

    public void displayHand() {
        System.out.println();
        System.out.println(getPlayerRole() +" has: ");
        hand.displayHand();
        System.out.println(" (" + hand.value() + ")");
    }

    protected abstract PlayerRole getPlayerRole();
}
