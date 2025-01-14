
/**
 * MagicCookie Class - Special item, when eated, confers the ability to carry twice more than default (double maxWeight of the player).
 *
 * @author Antoine MARMOL
 * @version 11 / 21/05/2024
 */
public class MagicCookie extends ConsumableItem
{
    private int aEffect;
    
    /**
     * Constructs a MagicCookie item
     * 
     * @param pItemName Name of the MagicCookie
     * @param pEffect Effect of the MagicCookie (max weight multiplier)
     */
    public MagicCookie(final String pItemName,final int pEffect)
    {
        super(pItemName, "Taste really good but looks a bit radioactive", 500, 10.0);
        this.aEffect = pEffect;
    }
    
    /**
     * Apply the effect of the player
     * 
     * @param pPlayer The player you're applying the effect
     */
    public void applyEffect(final Player pPlayer)
    {
        pPlayer.setMaxWeight( pPlayer.getMaxWeight()*this.aEffect );
    }
}
