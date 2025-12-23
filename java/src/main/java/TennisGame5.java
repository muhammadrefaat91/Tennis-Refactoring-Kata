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
import static com.tennis.util.Constants.INVALID_PLAYER_NAME;
import static com.tennis.util.Constants.INVALID_SCORE;
import static com.tennis.util.Constants.LOVE_ALL;
import static com.tennis.util.Constants.LOVE_FIFTEEN;
import static com.tennis.util.Constants.LOVE_FORTY;
import static com.tennis.util.Constants.LOVE_THIRTY;
import static com.tennis.util.Constants.PLAYER_1;
import static com.tennis.util.Constants.PLAYER_2;
import static com.tennis.util.Constants.THIRTY_ALL;
import static com.tennis.util.Constants.THIRTY_FIFTEEN;
import static com.tennis.util.Constants.THIRTY_FORTY;
import static com.tennis.util.Constants.THIRTY_LOVE;
import static com.tennis.util.Constants.WIN_FOR_PLAYER_1;
import static com.tennis.util.Constants.WIN_FOR_PLAYER_2;

import java.util.HashMap;
import java.util.Map;

public class TennisGame5 implements TennisGame {

    private final String player1Name;
    private final String player2Name;
    private int player1Score;
    private int player2Score;

    public TennisGame5(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER_1))
            player1Score++;
        else if (playerName.equals(PLAYER_2))
            player2Score++;
        else
            throw new IllegalArgumentException(INVALID_PLAYER_NAME);
    }

    @Override
    public String getScore() {
        int p1 = player1Score;
        int p2 = player2Score;

        while (p1 > 4 || p2 > 4) {
            p1--;
            p2--;
        }

        var lookup = new HashMap<Map.Entry, String>();
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

        var entry = Map.entry(p1, p2);
        if (lookup.containsKey(entry)) {
            return lookup.get(entry);
        } else {
            throw new IllegalArgumentException(INVALID_SCORE);
        }
    }
}
