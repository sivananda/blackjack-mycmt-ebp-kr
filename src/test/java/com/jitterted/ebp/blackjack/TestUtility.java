package com.jitterted.ebp.blackjack;

/**
 * @author sthummala
 * @since 1.0.0
 */
public class TestUtility {

    public TestUtility() {};

    public Card getAceOfHearts() {
        return new Card(Suit.HEART, "A");
    }

    public Card getAceOfSpades() {
        return new Card(Suit.SPADE, "A");
    }

    public Card getFiveOfHearts() {
        return new Card(Suit.HEART, "5");
    }

    public Card getTwoOfHearts() {
        return new Card(Suit.HEART, "2");
    }

    public Card getFiveOfSpades() {
        return new Card(Suit.SPADE, "5");
    }

    public Card getTenOfSpades() {
        return new Card(Suit.SPADE, "10");
    }
}
