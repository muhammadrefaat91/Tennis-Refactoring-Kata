package com.tennis.core;

import static com.tennis.util.Constants.ADVANTAGE_STRING;

import com.tennis.TennisGame4;

public class AdvantageServer implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public AdvantageServer(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    @Override
    public TennisResult getResult() {
        if (game.serverHasAdvantage())
            return new TennisResult(ADVANTAGE_STRING + game.getServer().getName(), "");
        return this.nextResult.getResult();
    }
}
