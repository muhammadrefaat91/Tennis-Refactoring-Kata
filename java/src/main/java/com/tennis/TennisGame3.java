package com.tennis;

import static com.tennis.util.Constants.ADVANTAGE_STRING;
import static com.tennis.util.Constants.DASH;
import static com.tennis.util.Constants.DASH_ALL;
import static com.tennis.util.Constants.DEUCE;
import static com.tennis.util.Constants.FIFTEEN;
import static com.tennis.util.Constants.FORTY;
import static com.tennis.util.Constants.LOVE;
import static com.tennis.util.Constants.THIRTY;
import static com.tennis.util.Constants.WIN_FOR;

import com.tennis.model.Player;
import com.tennis.util.TennisGameCommonUtil;

public class TennisGame3 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name, 0);
        this.player2 = new Player(player2Name, 0);
    }

    public String getScore() {
        String[] scoreDesc = new String[]{LOVE, FIFTEEN, THIRTY, FORTY};
        String result;
        if (player1.getScore() < 4 && player2.getScore() < 4 && !(player1.getScore() + player2.getScore() == 6)) {
            result = scoreDesc[player1.getScore()];
            return (player1.getScore().equals(player2.getScore())) ? result + DASH_ALL : result + DASH + scoreDesc[player2.getScore()];
        } else {
            if (player1.getScore().equals(player2.getScore()))
                return DEUCE;
            result = player1.getScore() > player2.getScore() ? player1.getName() : player2.getName();
            return ((player1.getScore() - player2.getScore()) * (player1.getScore() - player2.getScore()) == 1) ? ADVANTAGE_STRING + result : WIN_FOR + result;
        }
    }
    
    public void wonPoint(String playerName) {
        TennisGameCommonUtil.wonPoint(playerName, player1, player2);
    }

}
