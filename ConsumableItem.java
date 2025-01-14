
/**
 * ConsumableItem - a category of objects that can be eat / use on the player.
 *
 * @author Antoine MARMOL
 * @version 11 / 21/05/2024
 */
public abstract class ConsumableItem extends Item
{
    private boolean aIsConsumable;
    
    /**
     * Constructs a ConsumableItem
     * 
     * @param pItemName name of the item
     * @param pDes Description of the item
     * @param pPrice Price of the item
     * @param pWeight Weight of the item
     */
    public ConsumableItem(final String pItemName, final String pDes, final int pPrice, final double pWeight)
    {
        super(pItemName, pDes, pPrice, pWeight);
        this.aIsConsumable = true;
    }
}
