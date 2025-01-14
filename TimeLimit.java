import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Time limit - a Class that limit the player in the number of moves he can do
 *
 * @author Antoine MARMOL
 * @version 11 / 21/05/2024
 */
public class TimeLimit implements ActionListener
{
    private int aNumberOfMoves;
    private int aNumberOfRemainingMoves;
    private boolean aGameOver;
    private boolean aTimeLimited;
    private Timer aTimer;
    private final int THIRTY_MINUTES = 1000 * 60 * 30;
    private int aTime;

    /**
     * Constructs a TimeLimit object
     */
    public TimeLimit()
    {
        this.aNumberOfMoves = 0;
        this.aGameOver = false;
        this.aTimeLimited = false;
        this.aTime = 0;
        //this.aTimer = new Timer(1000,new actionPermformed);
    }

    @Override public void actionPerformed(ActionEvent pActionEvent)
    {
        return;
    }

    /**
     * Gets the Timer attribute
     *
     * @return the timer
     */
    public Timer getTimer()
    {
        return this.aTimer;
    }

    /**
     * Checks if the timelimited boolean is true
     *
     * @return the value of time limited status
     */
    public boolean isTimeLimited()
    {
        return this.aTimeLimited;
    }
    
    /**
     * Sets if we want to limit in moves or not something
     * 
     * @param pTimeLimited The boolean that define the limited status
     */
    public void setTimeLimited(final boolean pTimeLimited)
    {
        this.aTimeLimited = pTimeLimited;
    }
    
    /**
     * Gets the number of remaining moves
     * 
     * @return the number of remaining moves
     */
    public int getRemainingMoves() 
    {
        return this.aNumberOfRemainingMoves;
    }
    
    /**
     * See if the game need to stop because of a time limit exceeding
     * 
     * @return if the game is over
     */
    public boolean getGameOver() 
    {
        return this.aGameOver;
    }

    /**
     * Sets if the game need to stop because of a time limit exceeding
     *
     * @param pGameOver if the game is over
     */
    public void setGameOver(final boolean pGameOver)
    {
        this.aGameOver = pGameOver;
    }

    /**
     * Sets the number of remaining moves
     * 
     * @param pRemainingMoves The number of remaining moves
     */
    public void setRemainingMoves(final int pRemainingMoves) 
    {
        this.aNumberOfRemainingMoves = pRemainingMoves;
    }
    
    /**
     * Sets the remaining moves for the player and checks if the game should end.
     * If the remaining moves are zero, the game is set to over.
     * 
     * @param pRemainingMoves The number of moves remaining for the player.
     */
    public void timeLimit(final int pRemainingMoves)
    {
        if(pRemainingMoves == 0) {
            this.aGameOver=true;
        }
        this.setRemainingMoves(pRemainingMoves-1);
    }
}
