package com.tennis;

import static com.tennis.util.Constants.ADVANTAGE_PLAYER_1;
import static com.tennis.util.Constants.ADVANTAGE_PLAYER_2;
import static com.tennis.util.Constants.DEUCE;
import static com.tennis.util.Constants.FIFTEEN_ALL;
import static com.tennis.util.Constants.FIFTEEN_FORTY;
import static com.tennis.util.Constants.FIFTEEN_LOVE;
import static com.tennis.util.Constants.FIFTEEN_THIRTY;
import static com.tennis.util.Constants.FORTY_FIFTEEN;
import static com.tennis.util.Constants.FORTY_LOVE;
import static com.tennis.util.Constants.FORTY_THIRTY;
import static com.tennis.util.Constants.INVALID_SCORE;
import static com.tennis.util.Constants.LOVE_ALL;
import static com.tennis.util.Constants.LOVE_FIFTEEN;
import static com.tennis.util.Constants.LOVE_FORTY;
import static com.tennis.util.Constants.LOVE_THIRTY;
import static com.tennis.util.Constants.THIRTY_ALL;
import static com.tennis.util.Constants.THIRTY_FIFTEEN;
import static com.tennis.util.Constants.THIRTY_FORTY;
import static com.tennis.util.Constants.THIRTY_LOVE;
import static com.tennis.util.Constants.WIN_FOR_PLAYER_1;
import static com.tennis.util.Constants.WIN_FOR_PLAYER_2;

import java.util.HashMap;
import java.util.Map;

import com.tennis.model.Player;
import com.tennis.util.TennisGameCommonUtil;

public class TennisGame5 implements TennisGame {

    static Map<Map.Entry, String> lookup = new HashMap<Map.Entry, String>();
    private Player player1;
    private Player player2;

    static {
        lookup.put(Map.entry(0, 0), LOVE_ALL);
        lookup.put(Map.entry(0, 1), LOVE_FIFTEEN);
        lookup.put(Map.entry(0, 2), LOVE_THIRTY);
        lookup.put(Map.entry(0, 3), LOVE_FORTY);
        lookup.put(Map.entry(0, 4), WIN_FOR_PLAYER_2);
        lookup.put(Map.entry(1, 0), FIFTEEN_LOVE);
        lookup.put(Map.entry(1, 1), FIFTEEN_ALL);
        lookup.put(Map.entry(1, 2), FIFTEEN_THIRTY);
        lookup.put(Map.entry(1, 3), FIFTEEN_FORTY);
        lookup.put(Map.entry(1, 4), WIN_FOR_PLAYER_2);
        lookup.put(Map.entry(2, 0), THIRTY_LOVE);
        lookup.put(Map.entry(2, 1), THIRTY_FIFTEEN);
        lookup.put(Map.entry(2, 2), THIRTY_ALL);
        lookup.put(Map.entry(2, 3), THIRTY_FORTY);
        lookup.put(Map.entry(2, 4), WIN_FOR_PLAYER_2);
        lookup.put(Map.entry(3, 0), FORTY_LOVE);
        lookup.put(Map.entry(3, 1), FORTY_FIFTEEN);
        lookup.put(Map.entry(3, 2), FORTY_THIRTY);
        lookup.put(Map.entry(3, 3), DEUCE);
        lookup.put(Map.entry(3, 4), ADVANTAGE_PLAYER_2);
        lookup.put(Map.entry(4, 0), WIN_FOR_PLAYER_1);
        lookup.put(Map.entry(4, 1), WIN_FOR_PLAYER_1);
        lookup.put(Map.entry(4, 2), WIN_FOR_PLAYER_1);
        lookup.put(Map.entry(4, 3), ADVANTAGE_PLAYER_1);
        lookup.put(Map.entry(4, 4), DEUCE);
    }

    public TennisGame5(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name, 0);
        this.player2 = new Player(player2Name, 0);
    }

    @Override
    public void wonPoint(String playerName) {
        TennisGameCommonUtil.wonPoint(playerName, player1, player2);
    }

    @Override
    public String getScore() {
        while (player1.getScore() > 4 || player2.getScore() > 4) {
            player1.setScore(player1.getScore() - 1);
            player2.setScore(player2.getScore() - 1);
        }
        var entry = Map.entry(player1.getScore(), player2.getScore());
        if (lookup.containsKey(entry)) {
            return lookup.get(entry);
        } else {
            throw new IllegalArgumentException(INVALID_SCORE);
        }
    }
}
