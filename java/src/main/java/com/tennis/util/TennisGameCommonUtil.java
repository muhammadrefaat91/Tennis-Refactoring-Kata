package com.tennis.util;

import static com.tennis.util.Constants.ADVANTAGE_STRING;
import static com.tennis.util.Constants.DASH;
import static com.tennis.util.Constants.DEUCE;
import static com.tennis.util.Constants.EMPTY_STRING;
import static com.tennis.util.Constants.FIFTEEN;
import static com.tennis.util.Constants.FIFTEEN_ALL;
import static com.tennis.util.Constants.FORTY;
import static com.tennis.util.Constants.INVALID_PLAYER_NAME;
import static com.tennis.util.Constants.LOVE;
import static com.tennis.util.Constants.LOVE_ALL;
import static com.tennis.util.Constants.THIRTY;
import static com.tennis.util.Constants.THIRTY_ALL;
import static com.tennis.util.Constants.WIN_FOR;

import com.tennis.model.Player;

public class TennisGameCommonUtil {

    public static void wonPoint(String playerName, String player1Name, String player2Name,
            int player1Score, int player2Score) {
        if (!playerName.equals(player1Name) && !playerName.equals(player2Name)) {
            throw new IllegalArgumentException(INVALID_PLAYER_NAME);
        }

        if (playerName.equals(player1Name)) {
            player1Score+=1;
        } else if (playerName.equals(player2Name)) {
            player2Score+=1;
        }
    }

    public static void wonPoint(String playerName, Player player1, Player player2) {
        if (!playerName.equals(player1.getName()) && !playerName.equals(player2.getName())) {
            throw new IllegalArgumentException(INVALID_PLAYER_NAME);
        }

        if (playerName.equals(player1.getName())) {
            player1.setScore(player1.getScore() + 1);
        } else if (playerName.equals(player2.getName())) {
            player2.setScore(player2.getScore() + 1);
        }
    }

    public static String getEndGameScore(Integer player1Score, Integer player2Score,
            String player1Name, String player2Name) {
        String result = EMPTY_STRING;
        if (player1Score - player2Score == 1) {
            result = ADVANTAGE_STRING + player1Name;
        } else if (player1Score - player2Score == -1) {
            result = ADVANTAGE_STRING + player2Name;
        } else if (player1Score - player2Score >= 2) {
            result = WIN_FOR + player1Name;
        } else {
            result = WIN_FOR + player2Name;
        }
        return result;
    }

    public static String getTieScore(Integer playerScore) {
        return switch (playerScore) {
            case 0 -> LOVE_ALL;
            case 1 -> FIFTEEN_ALL;
            case 2 -> THIRTY_ALL;
            default -> DEUCE;
        };
    }

    public static String getRegularScore(Integer player1Score, Integer player2Score) {
        var score1 =  mapScoreResult(player1Score);
        var score2 =  mapScoreResult(player2Score);
        return score1 + DASH + score2;
    }

    public static String mapScoreResult(Integer playerScore) {
        return switch (playerScore) {
            case 0 -> LOVE;
            case 1 -> FIFTEEN;
            case 2 -> THIRTY;
            default -> FORTY;
        };
    }
}
