import static com.tennis.util.Constants.DASH_ALL;
import static com.tennis.util.Constants.EMPTY_STRING;
import static com.tennis.util.Constants.ADVANTAGE_PLAYER_1;
import static com.tennis.util.Constants.ADVANTAGE_PLAYER_2;
import static com.tennis.util.Constants.DASH;
import static com.tennis.util.Constants.DEUCE;
import static com.tennis.util.Constants.FIFTEEN;
import static com.tennis.util.Constants.FORTY;
import static com.tennis.util.Constants.LOVE;
import static com.tennis.util.Constants.THIRTY;
import static com.tennis.util.Constants.WIN_FOR_PLAYER_1;
import static com.tennis.util.Constants.WIN_FOR_PLAYER_2;

public class TennisGame2 implements TennisGame {

    public int player1Score = 0;
    public int player2Score = 0;
    public String p1res = EMPTY_STRING;
    public String p2res = EMPTY_STRING;
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = EMPTY_STRING;
        if (player1Score == player2Score && player1Score < 4) {
            if (player1Score == 0) {
                score = LOVE;
            }
            if (player1Score == 1) {
                score = FIFTEEN;
            }
            if (player1Score == 2) {
                score = THIRTY;
            }
            score += DASH_ALL;
        }
        if (player1Score == player2Score && player1Score >= 3) {
            score = DEUCE;
        }
        
        if (player1Score > 0 && player2Score == 0) {
            if (player1Score == 1) {
                p1res = FIFTEEN;
            }
            if (player1Score == 2) {
                p1res = THIRTY;
            }
            if (player1Score == 3) {
                p1res = FORTY;
            }
            
            p2res = LOVE;
            score = p1res + DASH + p2res;
        }
        if (player2Score > 0 && player1Score == 0) {
            if (player2Score == 1) {
                p2res = FIFTEEN;
            }
            if (player2Score == 2) {
                p2res = THIRTY;
            }
            if (player2Score == 3) {
                p2res = FORTY;
            }
            p1res = LOVE;
            score = p1res + DASH + p2res;
        }
        
        if (player1Score > player2Score && player1Score < 4) {
            if (player1Score == 2) {
                p1res = THIRTY;
            }
            if (player1Score == 3) {
                p1res = FORTY;
            }
            if (player2Score == 1) {
                p2res = FIFTEEN;
            }
            if (player2Score == 2) {
                p2res = THIRTY;
            }
            score = p1res + DASH + p2res;
        }
        if (player2Score > player1Score && player2Score < 4) {
            if (player2Score == 2) {
                p2res = THIRTY;
            }
            if (player2Score == 3) {
                p2res = FORTY;
            }
            if (player1Score == 1) {
                p1res = FIFTEEN;
            }
            if (player1Score == 2) {
                p1res = THIRTY;
            }
            score = p1res + DASH + p2res;
        }
        
        if (player1Score > player2Score && player2Score >= 3) {
            score = ADVANTAGE_PLAYER_1;
        }
        
        if (player2Score > player1Score && player1Score >= 3) {
            score = ADVANTAGE_PLAYER_2;
        }
        
        if (player1Score >= 4 && player2Score >= 0 && (player1Score - player2Score) >= 2) {
            score = WIN_FOR_PLAYER_1;
        }
        if (player2Score >= 4 && player1Score >= 0 && (player2Score - player1Score) >= 2) {
            score = WIN_FOR_PLAYER_2;
        }
        return score;
    }
    
    public void SetPlayer1Score(int number) {
        for (int i = 0; i < number; i++) {
            player1Score();
        }
    }
    
    public void SetPlayer2Score(int number) {
        for (int i = 0; i < number; i++) {
            player2Score();
        }
    }
    
    public void player1Score() {
        player1Score++;
    }

    public void player2Score() {
        player2Score++;
    }

    public void wonPoint(String player) {
        if (player.equalsIgnoreCase(player1Name)) {
            player1Score();
        } else {
            player2Score();
        }
    }
}