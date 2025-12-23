import static com.tennis.util.Constants.ADVANTAGE_STRING;
import static com.tennis.util.Constants.DASH;
import static com.tennis.util.Constants.DASH_ALL;
import static com.tennis.util.Constants.DEUCE;
import static com.tennis.util.Constants.FIFTEEN;
import static com.tennis.util.Constants.FORTY;
import static com.tennis.util.Constants.LOVE;
import static com.tennis.util.Constants.PLAYER_1;
import static com.tennis.util.Constants.THIRTY;
import static com.tennis.util.Constants.WIN_FOR;

public class TennisGame3 implements TennisGame {

    private int player2Score;
    private int player1Score;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String[] scoreDesc = new String[]{LOVE, FIFTEEN, THIRTY, FORTY};
        String s;
        if (player1Score < 4 && player2Score < 4 && !(player1Score + player2Score == 6)) {
            s = scoreDesc[player1Score];
            return (player1Score == player2Score) ? s + DASH_ALL : s + DASH + scoreDesc[player2Score];
        } else {
            if (player1Score == player2Score)
                return DEUCE;
            s = player1Score > player2Score ? player1Name : player2Name;
            return ((player1Score - player2Score)*(player1Score - player2Score) == 1) ? ADVANTAGE_STRING + s : WIN_FOR + s;
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER_1)) {
            this.player1Score += 1;
        } else {
            this.player2Score += 1;
        }
    }

}
