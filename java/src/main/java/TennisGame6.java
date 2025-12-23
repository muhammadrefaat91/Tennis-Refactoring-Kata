import static com.tennis.util.Constants.ADVANTAGE;
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
        if (playerName.equals(PLAYER_1))
            player1Score++;
        else
            player2Score++;

    }

    public String getScore()
    {
        String result;

        if (player1Score == player2Score)
        {
            // tie score
            String tieScore;
            switch (player1Score)
            {
                case 0:
                    tieScore = LOVE_ALL;
                    break;
                case 1:
                    tieScore = FIFTEEN_ALL;
                    break;
                case 2:
                    tieScore = THIRTY_ALL;
                    break;
                default:
                    tieScore = DEUCE;
                    break;
            }

            result = tieScore;
        }
        else if (player1Score >= 4 || player2Score >= 4)
        {
            // end-game score
            String endGameScore;

            if (player1Score - player2Score == 1) {
                endGameScore = ADVANTAGE + player1Name;
            } else if (player1Score - player2Score == -1) {
                endGameScore = ADVANTAGE + player2Name;
            } else if (player1Score - player2Score >= 2) {
                endGameScore = WIN_FOR + player1Name;
            } else {
                endGameScore = WIN_FOR + player2Name;
            }

            result = endGameScore;
        }
        else
        {
            // regular score
            String regularScore;

            String score1 =  switch (player1Score)
            {
                case 0 -> LOVE;
                case 1 -> FIFTEEN;
                case 2 -> THIRTY;
                default -> FORTY;
            };

            var score2 =  switch (player2Score)
            {
                case 0 -> LOVE;
                case 1 -> FIFTEEN;
                case 2 -> THIRTY;
                default -> FORTY;
            };

            regularScore = score1 + DASH + score2;

            result = regularScore;
        }

        return result;
    }
}
