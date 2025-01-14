
/**
 * FlexTape Class - Special item that can repair rooms
 *
 * @author Antoine MARMOL
 * @version 11 / 21/05/2024
 */
public class FlexTape extends Item
{   
    private int aRepairPercent;
    
    /**
     * Constructs a FlexTape Item
     * 
     * @param pName the name of the item
     * @param pRepairPercent the percentage of reparation the item is able to provide
     */
    public FlexTape(final String pName, final int pRepairPercent)
    {
        super(pName,"Oh that's a lot of DAMAGE!",5000,40.0);
        this.aRepairPercent = pRepairPercent;
    }
    
    /**
     * Gets the percentage of reparability of the item
     * 
     * @return the percentage of reparability
     */
    public int getRepairPercent()
    {
        return this.aRepairPercent;
    }
}
