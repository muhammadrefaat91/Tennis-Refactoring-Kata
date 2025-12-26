package com.tennis.core;

import static com.tennis.common.Constants.DEUCE;

import com.tennis.TennisGame4;

public class Deuce implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public Deuce(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    @Override
    public TennisResult getResult() {
        if (game.isDeuce())
            return new TennisResult(DEUCE, "");
        return this.nextResult.getResult();
    }
}
