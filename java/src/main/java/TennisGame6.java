import static com.tennis.util.Constants.ADVANTAGE_STRING;
import static com.tennis.util.Constants.DASH;
import static com.tennis.util.Constants.DEUCE;
import static com.tennis.util.Constants.FIFTEEN;
import static com.tennis.util.Constants.FIFTEEN_ALL;
import static com.tennis.util.Constants.FORTY;
import static com.tennis.util.Constants.LOVE;
import static com.tennis.util.Constants.LOVE_ALL;
import static com.tennis.util.Constants.PLAYER_1;
import static com.tennis.util.Constants.THIRTY;
import static com.tennis.util.Constants.THIRTY_ALL;
import static com.tennis.util.Constants.WIN_FOR;

public class TennisGame6 implements TennisGame {
    private final String player1Name;
    private final String player2Name;
    private int player1Score;
    private int player2Score;

    public TennisGame6(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER_1)) {
            player1Score++;
        } else {
            player2Score++;
        }
    }

    public String getScore() {
        String result;
        if (player1Score == player2Score) {
            // tie score
            result = switch (player1Score) {
                case 0 -> LOVE_ALL;
                case 1 -> FIFTEEN_ALL;
                case 2 -> THIRTY_ALL;
                default -> DEUCE;
            };
        } else if (player1Score >= 4 || player2Score >= 4) {
            // end-game score
            if (player1Score - player2Score == 1) {
                result = ADVANTAGE_STRING + player1Name;
            } else if (player1Score - player2Score == -1) {
                result = ADVANTAGE_STRING + player2Name;
            } else if (player1Score - player2Score >= 2) {
                result = WIN_FOR + player1Name;
            } else {
                result = WIN_FOR + player2Name;
            }
        } else {
            // regular score
            String score1 =  switch (player1Score) {
                case 0 -> LOVE;
                case 1 -> FIFTEEN;
                case 2 -> THIRTY;
                default -> FORTY;
            };

            var score2 =  switch (player2Score) {
                case 0 -> LOVE;
                case 1 -> FIFTEEN;
                case 2 -> THIRTY;
                default -> FORTY;
            };
            result = score1 + DASH + score2;
        }
        return result;
    }
}
