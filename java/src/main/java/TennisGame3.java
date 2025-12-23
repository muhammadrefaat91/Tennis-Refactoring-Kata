import static com.tennis.util.Constants.ADVANTAGE;
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

    private int p2;
    private int p1;
    private String p1N;
    private String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        String s;
        if (p1 < 4 && p2 < 4 && !(p1 + p2 == 6)) {
            String[] p = new String[]{LOVE, FIFTEEN, THIRTY, FORTY};
            s = p[p1];
            return (p1 == p2) ? s + DASH_ALL : s + DASH + p[p2];
        } else {
            if (p1 == p2)
                return DEUCE;
            s = p1 > p2 ? p1N : p2N;
            return ((p1-p2)*(p1-p2) == 1) ? ADVANTAGE + s : WIN_FOR + s;
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName == PLAYER_1)
            this.p1 += 1;
        else
            this.p2 += 1;
        
    }

}
