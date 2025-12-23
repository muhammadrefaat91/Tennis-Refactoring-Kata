package com.tennis.core;

import static com.tennis.util.Constants.FIFTEEN;
import static com.tennis.util.Constants.FORTY;
import static com.tennis.util.Constants.LOVE;
import static com.tennis.util.Constants.THIRTY;

import com.tennis.TennisGame4;

public class DefaultResult implements ResultProvider {

    private static final String[] scores = {LOVE, FIFTEEN, THIRTY, FORTY};

    private final TennisGame4 game;

    public DefaultResult(TennisGame4 game) {
        this.game = game;
    }

    @Override
    public TennisResult getResult() {
        return new TennisResult(scores[game.serverScore], scores[game.receiverScore]);
    }
}
