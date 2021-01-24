package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlayerTest {

    @Test
    void playerBalance50WhenBet50Of100WhenPlayerLoses() {
        Player player = new Player();
        player.playerDeposits(100);
        player.playerBets(50);

        assertThat(player.playerBalance()).isEqualTo(100 - 50);
    }

    @Test
    void playerShouldNotBeAbleToBetWhenZeroBalance() {
        Player player = new Player();

        assertThatIllegalArgumentException().isThrownBy(() -> {
            player.playerBets(50);
        });
    }

    @Test
    void playerBalanceWhenplayerWins() {
        Player player = new Player();
        player.playerDeposits(100);
        player.playerBets(50);

        player.playerWins();

        assertThat(player.playerBalance()).isEqualTo(50 + (50 * 2));
    }

    @Test
    void playerBalanceWhenplayerTies() {
        Player player = new Player();
        player.playerDeposits(100);
        player.playerBets(50);

        player.playerTies();

        assertThat(player.playerBalance()).isEqualTo(50 + (50 * 1));
    }

    @Test
    void playerShouldNotBetZeroAmount() {
        Player player = new Player();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            player.playerBets(0);
        });
    }

    @Test
    void playerBetShouldNotAllowNegativeAmount() {
        Player player = new Player();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            player.playerBets(-4);
        });
    }

    @Test
    void playerBetShouldNotAllowBetMoreThanBalance() {
        Player player = new Player();
        player.playerDeposits(100);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            player.playerBets(115);
        });
    }

    @Test
    void playerBalanceAfterMultipleDeposits() {
        Player player = new Player();
        player.playerDeposits(100);
        player.playerDeposits(100);

        assertThat(player.playerBalance()).isEqualTo(100 + 100);
    }

    @Test
    void playerBalanceAfterMultipleBets() {
        Player player = new Player();
        player.playerDeposits(100);
        player.playerBets(50);
        player.playerBets(25);

        assertThat(player.playerBalance()).isEqualTo(100 - 50 - 25);
    }

    @Test
    void playerBetAmount() {
        Player player = new Player();
        player.playerDeposits(100);

        player.playerBets(50);
        assertThat(player.totalAmountBet()).isEqualTo(50);
    }

    @Test
    void playerBetAmountWhenPlayerBetsMultipleTimes() {
        Player player = new Player();
        player.playerDeposits(100);

        player.playerBets(50);
        player.playerBets(50);
        assertThat(player.totalAmountBet()).isEqualTo(50 + 50);
    }

    @Test
    void playerBalanceWhenPlayerBetsMultipleTimesAndWins() {
        Player player = new Player();
        player.playerDeposits(100);

        player.playerBets(50);
        player.playerWins();
        player.playerBets(50);
        assertThat(player.playerBalance()).isEqualTo(50 + (50 * 2) - 50);
    }

    @Test
    void playerBalanceWhenPlayerBetsMultipleTimesAndWinsBoth() {
        Player player = new Player();
        player.playerDeposits(100);

        player.playerBets(50);
        player.playerWins();
        player.playerBets(50);
        player.playerWins();
        assertThat(player.playerBalance()).isEqualTo(150 - 50 + (50 * 2));
    }
}