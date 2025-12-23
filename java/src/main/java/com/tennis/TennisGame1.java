package com.tennis;

import static com.tennis.util.Constants.ADVANTAGE_PLAYER_1;
import static com.tennis.util.Constants.ADVANTAGE_PLAYER_2;
import static com.tennis.util.Constants.DASH;
import static com.tennis.util.Constants.DEUCE;
import static com.tennis.util.Constants.EMPTY_STRING;
import static com.tennis.util.Constants.FIFTEEN;
import static com.tennis.util.Constants.FIFTEEN_ALL;
import static com.tennis.util.Constants.FORTY;
import static com.tennis.util.Constants.LOVE;
import static com.tennis.util.Constants.LOVE_ALL;
import static com.tennis.util.Constants.THIRTY;
import static com.tennis.util.Constants.THIRTY_ALL;
import static com.tennis.util.Constants.WIN_FOR_PLAYER_1;
import static com.tennis.util.Constants.WIN_FOR_PLAYER_2;

public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equalsIgnoreCase(player1Name)) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    public String getScore() {
        StringBuilder finalScore = new StringBuilder(EMPTY_STRING);
        if (player1Score == player2Score) {
            finalScore = switch (player1Score) {
                case 0 -> new StringBuilder(LOVE_ALL);
                case 1 -> new StringBuilder(FIFTEEN_ALL);
                case 2 -> new StringBuilder(THIRTY_ALL);
                default -> new StringBuilder(DEUCE);
            };
        } else if (player1Score >= 4 || player2Score >= 4) {
            int minusResult = player1Score - player2Score;
            if (minusResult == 1) {
                finalScore = new StringBuilder(ADVANTAGE_PLAYER_1);
            } else if (minusResult == -1) {
                finalScore = new StringBuilder(ADVANTAGE_PLAYER_2);
            } else if (minusResult >= 2) {
                finalScore = new StringBuilder(WIN_FOR_PLAYER_1);
            } else {
                finalScore = new StringBuilder(WIN_FOR_PLAYER_2);
            }
        } else {
            int tempScore = 0;
            for (int i = 1; i < 3; i++) {
                if (i == 1) {
                    tempScore = player1Score;
                } else {
                    finalScore.append(DASH);
                    tempScore = player2Score;
                }
                switch(tempScore) {
                    case 0:
                        finalScore.append(LOVE);
                        break;
                    case 1:
                        finalScore.append(FIFTEEN);
                        break;
                    case 2:
                        finalScore.append(THIRTY);
                        break;
                    case 3:
                        finalScore.append(FORTY);
                        break;
                }
            }
        }
        return finalScore.toString();
    }
}
