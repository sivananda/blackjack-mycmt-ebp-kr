package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sthummala
 * @since 1.0.0
 */
public class DealerTest {

    private TestUtility testUtility = new TestUtility();

    @Test
    public void testDealerPlays() {
        Dealer dealer = new Dealer();
        dealer.drawCardIntoHand(testUtility.getAceOfHearts());
        assertThat(dealer.plays()).isEqualTo(true);
    }

    @Test
    public void testDealerDoesNotPlay() {
        Dealer dealer = new Dealer();
        dealer.drawCardIntoHand(testUtility.getAceOfHearts());
        dealer.drawCardIntoHand(testUtility.getFiveOfSpades());
        dealer.drawCardIntoHand(testUtility.getTwoOfHearts());
        dealer.drawCardIntoHand(testUtility.getFiveOfHearts());
        dealer.drawCardIntoHand(testUtility.getTenOfSpades());
        assertThat(dealer.plays()).isEqualTo(false);
    }

    @Test
    public void testDealerRole() {
        Dealer dealer = new Dealer();
        assertThat(dealer.getPlayerRole()).isEqualTo(PlayerRole.DEALER);
    }
}

