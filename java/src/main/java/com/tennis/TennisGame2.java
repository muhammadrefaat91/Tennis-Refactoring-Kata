package com.tennis;

import static com.tennis.common.Constants.DASH_ALL;
import static com.tennis.common.Constants.EMPTY_STRING;
import static com.tennis.common.Constants.ADVANTAGE_PLAYER_1;
import static com.tennis.common.Constants.ADVANTAGE_PLAYER_2;
import static com.tennis.common.Constants.DASH;
import static com.tennis.common.Constants.DEUCE;
import static com.tennis.common.Constants.LOVE;
import static com.tennis.common.Constants.WIN_FOR_PLAYER_1;
import static com.tennis.common.Constants.WIN_FOR_PLAYER_2;
import static com.tennis.common.TennisGameCommonUtil.getRegularScore;
import static com.tennis.common.TennisGameCommonUtil.getScoreLabel;
import com.tennis.model.Player;
import com.tennis.common.TennisGameCommonUtil;

public class TennisGame2 implements TennisGame {

    private final Player player1;
    private final Player player2;
    
    public TennisGame2(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name, 0);
        this.player2 = new Player(player2Name, 0);
    }

    public void wonPoint(String playerName) {
        TennisGameCommonUtil.wonPoint(playerName, player1, player2);
    }

    public String getScore() {
        String result = EMPTY_STRING;
        if (player1.getScore().equals(player2.getScore())) {
            if (player1.getScore() < 4) {
                result = getScoreLabel(player1.getScore());
                result += DASH_ALL;
            }
            if (player1.getScore() >= 3) {
                result = DEUCE;
            }
        }

        if (player1.getScore() > 0 && player2.getScore() == 0) {
            result = getScoreLabel(player1.getScore()) + DASH + LOVE;
        }
        if (player2.getScore() > 0 && player1.getScore() == 0) {
            result = LOVE + DASH + getScoreLabel(player2.getScore());
        }
        if ((player1.getScore() > player2.getScore() || player2.getScore() > player1.getScore()) &&
                (player1.getScore() < 4 || player2.getScore() < 4)) {
            result = getRegularScore(player1.getScore(), player2.getScore());
        }

        if (player1.getScore() > player2.getScore() && player2.getScore() >= 3) {
            result = ADVANTAGE_PLAYER_1;
        }

        if (player2.getScore() > player1.getScore() && player1.getScore() >= 3) {
            result = ADVANTAGE_PLAYER_2;
        }

        if (player1.getScore() >= 4 && player2.getScore() >= 0 && (player1.getScore() - player2.getScore()) >= 2) {
            result = WIN_FOR_PLAYER_1;
        }
        if (player2.getScore() >= 4 && player1.getScore() >= 0 && (player2.getScore() - player1.getScore()) >= 2) {
            result = WIN_FOR_PLAYER_2;
        }
        return result;
    }
}