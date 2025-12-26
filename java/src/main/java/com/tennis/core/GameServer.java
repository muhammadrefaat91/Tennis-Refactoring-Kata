package com.tennis.core;

import static com.tennis.common.Constants.WIN_FOR;

import com.tennis.TennisGame4;

public class GameServer implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public GameServer(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    @Override
    public TennisResult getResult() {
        if (game.serverHasWon())
            return new TennisResult(WIN_FOR + game.getServer().getName(), "");
        return this.nextResult.getResult();
    }

}
