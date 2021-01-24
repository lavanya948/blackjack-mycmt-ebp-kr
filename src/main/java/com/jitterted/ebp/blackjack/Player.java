package com.jitterted.ebp.blackjack;

public class Player {
    private int playerBet = 0;
    private int playerBalance = 0;
    private int totalBet = 0;

    public void playerDeposits(int amount) {
        playerBalance += amount;
    }

    public void playerBets(int betAmount) {
        checkAmountsValid(betAmount);
        checkEnoughBalance(betAmount);
        addBonusIfRequired(betAmount);
        updateBalance(betAmount);
    }

    private void updateBalance(int betAmount) {
        this.playerBet = betAmount;
        this.totalBet += playerBet;
        this.playerBalance -= betAmount;
    }

    private void addBonusIfRequired(int betAmount) {
        if (betAmount >= 100) {
            playerBalance += 10;
        }
    }

    private void checkEnoughBalance(int betAmount) {
        if(playerBalance < betAmount)
            throw new IllegalArgumentException();
    }

    private void checkAmountsValid(int betAmount) {
        if(playerBalance <= 0 || betAmount <= 0)
            throw new IllegalArgumentException();
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
