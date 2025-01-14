
/**
 * Poison Class - A special Item, when eated it limit the number of remaining moves
 *
 * @author Antoine MARMOL
 * @version 11 / 21/05/2024
 */
public class Poison extends ConsumableItem
{
    private int aEffect;
    
    /**
     * Constructs a Poison item
     * 
     * @param pItemName Name of the Poison item
     * @param pEffect Effect of the Poison item (nb of remaining moves when consume)
     */
    public Poison(final String pItemName,final int pEffect)
    {
        super(pItemName, "I shouldn't drink that!", 100, 5.0);
        this.aEffect = pEffect;
    }
    
    /**
     * Apply the effect of the player
     * 
     * @param pPlayer The player you're applying the effect
     */
    public void applyEffect(final Player pPlayer)
    {
        pPlayer.setTimeLimiter(true);
        pPlayer.getTimeLimit().setRemainingMoves(this.aEffect);
    }
    
    /**
     * Gets the effect of this object
     * 
     * @return the effect of this object
     */
    public int getEffect()
    {
        return this.aEffect;
    }
}
