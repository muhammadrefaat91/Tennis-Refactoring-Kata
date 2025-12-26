package com.tennis.core;

import static com.tennis.common.Constants.DASH;
import static com.tennis.common.Constants.DASH_ALL;
import static com.tennis.common.Constants.EMPTY_STRING;

public class TennisResult {

    String serverScore;
    String receiverScore;

    TennisResult(String serverScore, String receiverScore) {
        this.serverScore = serverScore;
        this.receiverScore = receiverScore;
    }

    public String format() {
        if (EMPTY_STRING.equals(this.receiverScore)) {
            return this.serverScore;
        }
        if (serverScore.equals(receiverScore)) {
            return serverScore + DASH_ALL;
        }
        return this.serverScore + DASH + this.receiverScore;
    }
}
