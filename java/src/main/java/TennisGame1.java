import static com.tennis.util.Constants.ADVANTAGE_PLAYER_1;
import static com.tennis.util.Constants.ADVANTAGE_PLAYER_2;
import static com.tennis.util.Constants.DASH;
import static com.tennis.util.Constants.DEUCE;
import static com.tennis.util.Constants.EMPTY_STRING;
import static com.tennis.util.Constants.FIFTEEN;
import static com.tennis.util.Constants.FIFTEEN_ALL;
import static com.tennis.util.Constants.FORTY;
import static com.tennis.util.Constants.LOVE;
import static com.tennis.util.Constants.LOVE_ALL;
import static com.tennis.util.Constants.PLAYER_1;
import static com.tennis.util.Constants.THIRTY;
import static com.tennis.util.Constants.THIRTY_ALL;
import static com.tennis.util.Constants.WIN_FOR_PLAYER_1;
import static com.tennis.util.Constants.WIN_FOR_PLAYER_2;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == PLAYER_1)
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = EMPTY_STRING;
        int tempScore=0;
        if (m_score1==m_score2)
        {
            switch (m_score1)
            {
                case 0:
                        score = LOVE_ALL;
                    break;
                case 1:
                        score = FIFTEEN_ALL;
                    break;
                case 2:
                        score = THIRTY_ALL;
                    break;
                default:
                        score = DEUCE;
                    break;
                
            }
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            int minusResult = m_score1-m_score2;
            if (minusResult==1) score = ADVANTAGE_PLAYER_1;
            else if (minusResult ==-1) score = ADVANTAGE_PLAYER_2;
            else if (minusResult>=2) score = WIN_FOR_PLAYER_1;
            else score = WIN_FOR_PLAYER_2;
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = m_score1;
                else { score+= DASH; tempScore = m_score2;}
                switch(tempScore)
                {
                    case 0:
                        score+= LOVE;
                        break;
                    case 1:
                        score+= FIFTEEN;
                        break;
                    case 2:
                        score+= THIRTY;
                        break;
                    case 3:
                        score+= FORTY;
                        break;
                }
            }
        }
        return score;
    }
}
