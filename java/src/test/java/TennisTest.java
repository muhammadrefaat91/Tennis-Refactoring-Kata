import org.junit.jupiter.params.ParameterizedTest;

import java.util.stream.Stream;

import static com.tennis.util.Constants.ADVANTAGE_PLAYER_1;
import static com.tennis.util.Constants.ADVANTAGE_PLAYER_2;
import static com.tennis.util.Constants.DEUCE;
import static com.tennis.util.Constants.FIFTEEN_ALL;
import static com.tennis.util.Constants.LOVE_ALL;
import static com.tennis.util.Constants.PLAYER_1;
import static com.tennis.util.Constants.THIRTY_ALL;
import static com.tennis.util.Constants.WIN_FOR_PLAYER_1;
import static com.tennis.util.Constants.WIN_FOR_PLAYER_2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.provider.MethodSource;

import com.tennis.TennisGame;
import com.tennis.TennisGame1;
import com.tennis.TennisGame2;
import com.tennis.TennisGame3;
import com.tennis.TennisGame4;
import com.tennis.TennisGame5;
import com.tennis.TennisGame6;
import com.tennis.TennisGame7;

public class TennisTest {

    public static Stream<Object[]> getAllScores() {
        return Stream.of(new Object[][]{
                {0, 0, LOVE_ALL},
                {1, 1, FIFTEEN_ALL},
                {2, 2, THIRTY_ALL},
                {3, 3, DEUCE},
                {4, 4, DEUCE},

                {1, 0, "Fifteen-Love"},
                {0, 1, "Love-Fifteen"},
                {2, 0, "Thirty-Love"},
                {0, 2, "Love-Thirty"},
                {3, 0, "Forty-Love"},
                {0, 3, "Love-Forty"},
                {4, 0, WIN_FOR_PLAYER_1},
                {0, 4, WIN_FOR_PLAYER_2},

                {2, 1, "Thirty-Fifteen"},
                {1, 2, "Fifteen-Thirty"},
                {3, 1, "Forty-Fifteen"},
                {1, 3, "Fifteen-Forty"},
                {4, 1, WIN_FOR_PLAYER_1},
                {1, 4, WIN_FOR_PLAYER_2},

                {3, 2, "Forty-Thirty"},
                {2, 3, "Thirty-Forty"},
                {4, 2, WIN_FOR_PLAYER_1},
                {2, 4, WIN_FOR_PLAYER_2},

                {4, 3, ADVANTAGE_PLAYER_1},
                {3, 4, ADVANTAGE_PLAYER_2},
                {5, 4, ADVANTAGE_PLAYER_1},
                {4, 5, ADVANTAGE_PLAYER_2},
                {15, 14, ADVANTAGE_PLAYER_1},
                {14, 15, ADVANTAGE_PLAYER_2},

                {6, 4, WIN_FOR_PLAYER_1},
                {4, 6, WIN_FOR_PLAYER_2},
                {16, 14, WIN_FOR_PLAYER_1},
                {14, 16, WIN_FOR_PLAYER_2},
        });
    }

    private static void checkAllScores(int player1Points, int player2Points, String expectedScore, TennisGame game) {
        int highestScore = Math.max(player1Points, player2Points);
        for (int i = 0; i < highestScore; i++) {
            if (i < player1Points)
                game.wonPoint(PLAYER_1);
            if (i < player2Points)
                game.wonPoint("player2");
        }
        assertEquals(expectedScore, game.getScore());
    }

    @ParameterizedTest
    @MethodSource("getAllScores")
    public void checkAllScoresTennisGame1(int player1Points, int player2Points, String expectedScore) {
        TennisGame game = new TennisGame1(PLAYER_1, "player2");
        checkAllScores(player1Points, player2Points, expectedScore, game);
    }

    @ParameterizedTest
    @MethodSource("getAllScores")
    public void checkAllScoresTennisGame2(int player1Points, int player2Points, String expectedScore) {
        TennisGame game = new TennisGame2(PLAYER_1, "player2");
        checkAllScores(player1Points, player2Points, expectedScore, game);
    }

    @ParameterizedTest
    @MethodSource("getAllScores")
    public void checkAllScoresTennisGame3(int player1Points, int player2Points, String expectedScore) {
        TennisGame game = new TennisGame3(PLAYER_1, "player2");
        checkAllScores(player1Points, player2Points, expectedScore, game);
    }

    @ParameterizedTest
    @MethodSource("getAllScores")
    public void checkAllScoresTennisGame4(int player1Points, int player2Points, String expectedScore) {
        TennisGame game = new TennisGame4(PLAYER_1, "player2");
        checkAllScores(player1Points, player2Points, expectedScore, game);
    }

    @ParameterizedTest
    @MethodSource("getAllScores")
    public void checkAllScoresTennisGame5(int player1Points, int player2Points, String expectedScore) {
        TennisGame game = new TennisGame5(PLAYER_1, "player2");
        checkAllScores(player1Points, player2Points, expectedScore, game);
    }

    @ParameterizedTest
    @MethodSource("getAllScores")
    public void checkAllScoresTennisGame6(int player1Points, int player2Points, String expectedScore) {
        TennisGame game = new TennisGame6(PLAYER_1, "player2");
        checkAllScores(player1Points, player2Points, expectedScore, game);
    }


    @ParameterizedTest
    @MethodSource("getAllScores")
    public void checkAllScoresTennisGame7(int player1Points, int player2Points, String expectedScore) {
        TennisGame game = new TennisGame7(PLAYER_1, "player2");
        checkAllScores(player1Points, player2Points, "Current score: " + expectedScore + ", enjoy your game!", game);
    }
}
