package com.tennis;

import com.tennis.core.AdvantageReceiver;
import com.tennis.core.AdvantageServer;
import com.tennis.core.DefaultResult;
import com.tennis.core.Deuce;
import com.tennis.core.GameReceiver;
import com.tennis.core.GameServer;
import com.tennis.core.TennisResult;
import com.tennis.model.Player;
import com.tennis.common.TennisGameCommonUtil;

public class TennisGame4 implements TennisGame {

    private final Player server;
    private final Player receiver;

    public TennisGame4(String player1Name, String player2Name) {
        this.server = new Player(player1Name, 0);
        this.receiver = new Player(player2Name, 0);
    }

    @Override
    public void wonPoint(String playerName) {
        TennisGameCommonUtil.wonPoint(playerName, server, receiver);
    }

    @Override
    public String getScore() {
        TennisResult result = new Deuce(
                this, new GameServer(
                        this, new GameReceiver(
                                this, new AdvantageServer(
                                        this, new AdvantageReceiver(
                                                this, new DefaultResult(this)))))).getResult();
        return result.format();
    }

    public boolean receiverHasAdvantage() {
        return receiver.getScore() >= 4 && (receiver.getScore() - server.getScore()) == 1;
    }

    public boolean serverHasAdvantage() {
        return server.getScore() >= 4 && (server.getScore() - receiver.getScore()) == 1;
    }

    public boolean receiverHasWon() {
        return receiver.getScore() >= 4 && (receiver.getScore() - server.getScore()) >= 2;
    }

    public boolean serverHasWon() {
        return server.getScore() >= 4 && (server.getScore() - receiver.getScore()) >= 2;
    }

    public boolean isDeuce() {
        return server.getScore() >= 3 && receiver.getScore() >= 3 && (server.getScore().equals(receiver.getScore()));
    }

    public Player getServer() {
        return server;
    }

    public Player getReceiver() {
        return receiver;
    }
}

