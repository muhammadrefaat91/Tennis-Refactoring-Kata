import static com.tennis.util.Constants.ADVANTAGE;
import static com.tennis.util.Constants.CURRENT_SCORE;
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

public class TennisGame7 implements TennisGame {

    private final String player1Name;
    private final String player2Name;
    private int player1Score;
    private int player2Score;

    public TennisGame7(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER_1))
            player1Score++;
        else
            player2Score++;

    }

    public String getScore()
    {
        String result = CURRENT_SCORE;

        if (player1Score == player2Score)
        {
            // tie score
            switch (player1Score)
            {
                case 0:
                    result += LOVE_ALL;
                    break;
                case 1:
                    result += FIFTEEN_ALL;
                    break;
                case 2:
                    result += THIRTY_ALL;
                    break;
                default:
                    result += DEUCE;
                    break;
            }
        }
        else if (player1Score >= 4 || player2Score >= 4)
        {
            // end-game score
            if (player1Score - player2Score == 1) {
                result += ADVANTAGE + player1Name;
            } else if (player1Score - player2Score == -1) {
                result += ADVANTAGE + player2Name;
            } else if (player1Score - player2Score >= 2) {
                result += WIN_FOR + player1Name;
            } else {
                result += WIN_FOR + player2Name;
            }
        }
        else
        {
            // regular score
            result +=  switch (player1Score)
            {
                case 0 -> LOVE;
                case 1 -> FIFTEEN;
                case 2 -> THIRTY;
                default -> FORTY;
            };
            result += DASH;
            result +=  switch (player2Score)
            {
                case 0 -> LOVE;
                case 1 -> FIFTEEN;
                case 2 -> THIRTY;
                default -> FORTY;
            };

        }

        return result + ", enjoy your game!";
    }
}
