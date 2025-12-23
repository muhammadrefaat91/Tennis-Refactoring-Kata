package com.tennis.core;

import static com.tennis.util.Constants.ADVANTAGE_STRING;

import com.tennis.TennisGame4;

public class AdvantageReceiver implements ResultProvider {

    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public AdvantageReceiver(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    @Override
    public TennisResult getResult() {
        if (game.receiverHasAdvantage())
            return new TennisResult(ADVANTAGE_STRING + game.receiver, "");
        return this.nextResult.getResult();
    }
}
