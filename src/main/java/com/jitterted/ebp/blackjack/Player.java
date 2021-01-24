package com.jitterted.ebp.blackjack;

public class Player {
    private int playerBet = 0;
    private int playerBalance = 0;
    private int totalBet = 0;

    public void playerDeposits(int amount) {
        playerBalance += amount;
    }

    public void playerBets(int betAmount) {
        if(playerBalance <= 0 || betAmount <= 0)
            throw new IllegalArgumentException();

        if(playerBalance < betAmount)
            throw new IllegalArgumentException();
        this.playerBet = betAmount;
        this.totalBet += playerBet;
        this.playerBalance -= betAmount;
    }

    public void playerLoses() {
        playerBalance += playerBet * 0;
    }

    public void playerWins() {
        playerBalance += playerBet * 2;
    }

    public void playerTies() {
        playerBalance += playerBet * 1;
    }

    public int playerBalance() {
        return playerBalance;
    }

    public int totalAmountBet() {
        return totalBet;
    }
}
