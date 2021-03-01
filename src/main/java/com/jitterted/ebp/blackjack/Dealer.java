package com.jitterted.ebp.blackjack;

import static org.fusesource.jansi.Ansi.ansi;

/**
 * @author sthummala
 * @since 1.0.0
 */
public class Dealer extends AbstractPlayer {

    public Dealer() {
        super();
    };

    public boolean plays() {
        return getHand().value() <= 16;
    }

    public void displayUpCard() {
        System.out.println("Dealer has: ");
        System.out.println(getHand().displayFirstCard()); // first card is Face Up
    }

    // second card is the hole card, which is hidden
    public void displayHoleCard() {
        System.out.print(
                ansi()
                        .cursorUp(7)
                        .cursorRight(12)
                        .a("┌─────────┐").cursorDown(1).cursorLeft(11)
                        .a("│░░░░░░░░░│").cursorDown(1).cursorLeft(11)
                        .a("│░ J I T ░│").cursorDown(1).cursorLeft(11)
                        .a("│░ T E R ░│").cursorDown(1).cursorLeft(11)
                        .a("│░ T E D ░│").cursorDown(1).cursorLeft(11)
                        .a("│░░░░░░░░░│").cursorDown(1).cursorLeft(11)
                        .a("└─────────┘"));
    }

    @Override
    protected PlayerRole getPlayerRole() {
        return PlayerRole.DEALER;
    }
}
