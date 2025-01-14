
/**
 *Antidote Class - Special item that can heal the player from a poison infection.
 *
 * @author Antoine MARMOL
 * @version 11 / 21/05/2024
 */
public class Antidote extends ConsumableItem
{   
    /**
     * Constructs an Antidote item
     * 
     * @param pItemName Name of the Antidote item
     */
    public Antidote(final String pItemName)
    {
        super(pItemName, "In case of snake bite", 500, 5.0);
    }
    
    /**
     * Apply the effect of the player
     * 
     * @param pPlayer The player you're applying the effect
     */
    public void applyEffect(final Player pPlayer)
    {
        pPlayer.setTimeLimiter(false);
        pPlayer.getTimeLimit().setRemainingMoves(0);
    }
}
