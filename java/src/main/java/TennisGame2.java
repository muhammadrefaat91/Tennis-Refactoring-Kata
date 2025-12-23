import static com.tennis.util.Constants.DASH_ALL;
import static com.tennis.util.Constants.EMPTY_STRING;
import static com.tennis.util.Constants.ADVANTAGE_PLAYER_1;
import static com.tennis.util.Constants.ADVANTAGE_PLAYER_2;
import static com.tennis.util.Constants.DASH;
import static com.tennis.util.Constants.DEUCE;
import static com.tennis.util.Constants.FIFTEEN;
import static com.tennis.util.Constants.FORTY;
import static com.tennis.util.Constants.LOVE;
import static com.tennis.util.Constants.PLAYER_1;
import static com.tennis.util.Constants.THIRTY;
import static com.tennis.util.Constants.WIN_FOR_PLAYER_1;
import static com.tennis.util.Constants.WIN_FOR_PLAYER_2;

public class TennisGame2 implements TennisGame
{

    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = EMPTY_STRING;
    public String P2res = EMPTY_STRING;
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = EMPTY_STRING;
        if (P1point == P2point && P1point < 4)
        {
            if (P1point==0)
                score = LOVE;
            if (P1point==1)
                score = FIFTEEN;
            if (P1point==2)
                score = THIRTY;
            score += DASH_ALL;
        }
        if (P1point==P2point && P1point>=3)
            score = DEUCE;
        
        if (P1point > 0 && P2point==0)
        {
            if (P1point==1)
                P1res = FIFTEEN;
            if (P1point==2)
                P1res = THIRTY;
            if (P1point==3)
                P1res = FORTY;
            
            P2res = LOVE;
            score = P1res + DASH + P2res;
        }
        if (P2point > 0 && P1point==0)
        {
            if (P2point==1)
                P2res = FIFTEEN;
            if (P2point==2)
                P2res = THIRTY;
            if (P2point==3)
                P2res = FORTY;
            
            P1res = LOVE;
            score = P1res + DASH + P2res;
        }
        
        if (P1point>P2point && P1point < 4)
        {
            if (P1point==2)
                P1res= THIRTY;
            if (P1point==3)
                P1res= FORTY;
            if (P2point==1)
                P2res= FIFTEEN;
            if (P2point==2)
                P2res= THIRTY;
            score = P1res + DASH + P2res;
        }
        if (P2point>P1point && P2point < 4)
        {
            if (P2point==2)
                P2res= THIRTY;
            if (P2point==3)
                P2res= FORTY;
            if (P1point==1)
                P1res= FIFTEEN;
            if (P1point==2)
                P1res= THIRTY;
            score = P1res + DASH + P2res;
        }
        
        if (P1point > P2point && P2point >= 3)
        {
            score = ADVANTAGE_PLAYER_1;
        }
        
        if (P2point > P1point && P1point >= 3)
        {
            score = ADVANTAGE_PLAYER_2;
        }
        
        if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            score = WIN_FOR_PLAYER_1;
        }
        if (P2point>=4 && P1point>=0 && (P2point-P1point)>=2)
        {
            score = WIN_FOR_PLAYER_2;
        }
        return score;
    }
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        P1point++;
    }
    
    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == PLAYER_1)
            P1Score();
        else
            P2Score();
    }
}