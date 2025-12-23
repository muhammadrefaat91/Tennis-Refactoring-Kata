package com.tennis.core;

import static com.tennis.util.Constants.WIN_FOR;

import com.tennis.TennisGame4;

public class GameReceiver implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public GameReceiver(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    @Override
    public TennisResult getResult() {
        if (game.receiverHasWon())
            return new TennisResult(WIN_FOR + game.receiver, "");
        return this.nextResult.getResult();
    }
}
