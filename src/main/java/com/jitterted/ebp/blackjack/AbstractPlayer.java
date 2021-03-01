package com.jitterted.ebp.blackjack;

public abstract class AbstractPlayer {
    private Hand hand;

    public AbstractPlayer() {
        this.hand = new Hand();
    }

    public boolean beats(AbstractPlayer dealer) {
        return this.hand.beats(dealer.hand);
    }

    protected void drawCardIntoHand(Card card) {
        getHand().add(card);
    }

    public boolean isBusted() {
        return getHand().isBusted();
    }

    public void displayHand() {
        System.out.println();
        System.out.println(getPlayerRole() +" has: ");
        hand.displayHand();
        System.out.println(" (" + hand.value() + ")");
    }

    protected Hand getHand() {
        return this.hand;
    }

    protected abstract PlayerRole getPlayerRole();
}
