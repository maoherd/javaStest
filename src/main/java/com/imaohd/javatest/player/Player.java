package com.imaohd.javatest.player;

public class Player {

    private final Dice dice;
    private final int minNumberToWin;

    public Player(final Dice dice, final int minNumberToWin) {
        this.dice = dice;
        this.minNumberToWin = minNumberToWin;
    }

    public boolean play() {
        int diceNumber = dice.roll();
        return diceNumber > minNumberToWin;
    }
}
