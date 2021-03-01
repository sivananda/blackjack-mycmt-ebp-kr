package com.jitterted.ebp.blackjack;

/**
 * @author sthummala
 * @since 1.0.0
 */
public enum PlayerRole {
    PLAYER("Player"),
    DEALER("Dealer");

    private final String roleName;
    PlayerRole(String roleName){
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return this.roleName;
    }
}
