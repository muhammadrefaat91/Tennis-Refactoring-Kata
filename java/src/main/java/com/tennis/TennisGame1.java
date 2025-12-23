package com.tennis;

import static com.tennis.util.Constants.EMPTY_STRING;
import static com.tennis.util.TennisGameCommonUtil.getEndGameScore;
import static com.tennis.util.TennisGameCommonUtil.getRegularScore;
import static com.tennis.util.TennisGameCommonUtil.getTieScore;

import com.tennis.model.Player;
import com.tennis.util.TennisGameCommonUtil;

public class TennisGame1 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name, 0);
        this.player2 = new Player(player2Name, 0);
    }

    public void wonPoint(String playerName) {
        TennisGameCommonUtil.wonPoint(playerName, player1, player2);
    }

    public String getScore() {
        StringBuilder finalScore = new StringBuilder(EMPTY_STRING);
        if (player1.getScore().equals(player2.getScore())) {
            finalScore.append(getTieScore(player1.getScore()));
        } else if (player1.getScore() >= 4 || player2.getScore() >= 4) {
            finalScore.append(getEndGameScore(player1.getScore(), player2.getScore(), player1.getName(), player2.getName()));
        } else {
            finalScore.append(getRegularScore(player1.getScore(), player2.getScore()));
        }
        return finalScore.toString();
    }
}
