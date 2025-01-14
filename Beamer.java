
/**
 * Beamer - it's a special item that teleport the player into the room where he charged the beamer
 *
 * @author Antoine MARMOL
 * @version 11 / 21/05/2024
 */
public class Beamer extends Item
{
    private Room aSavedRoom;
    
    /**
     * Constructs a beamer
     * 
     * @param pItemName Name of the Beamer item
     */
    public Beamer(final String pItemName)
    {
        super(pItemName,"A device that remembers the room you charge it in and teleports you there once you've used it.",50,10.0);
    }
    
    /**
     * Gets the saved room
     * 
     * @return the saved room
     */
    public Room getSavedRoom()
    {
        return this.aSavedRoom;
    }
    
    /**
     * Saves the room in the beamer
     * 
     * @param pSavedRoom the room you wanna save
     */
    public void chargeBeamer(final Room pSavedRoom)
    {
        this.aSavedRoom = pSavedRoom;
    }
        
    /**
     * Verifies if the beamer is charged
     * 
     * @return A boolean that return true if there is a saved room
     */
    public boolean isCharged()
    {
        return this.aSavedRoom != null;
    }
    
    /**
     * Resets the beamer 
     */
    public void resetBeamer()
    {
        this.aSavedRoom = null;
    }
}
