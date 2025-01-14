
/**
 * Door - A class that can block acces to certains exits of a room if you have not the right keyItem to open it 
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Door
{
    private boolean aIsLocked;
    private Room aRoom;
    private Item aKey;
    
    /**
     * Constructs the door object 
     * 
     * @param pRoom the room the door gives you access
     * @param pKey the item that can unlock this door
     */
    public Door(final Room pRoom, final Item pKey)
    {
        this.aIsLocked = true;
        this.aRoom = pRoom;
        this.aKey = pKey;
    }
    
    /**
     * Gets the key item that can unlock this door
     * 
     * @return the key item
     */
    public Item getKey()
    {
        return this.aKey;
    }
    
    /**
     * Gets the room that this door gives you access to
     * 
     * @return the door
     */
    public Room getNextRoom()
    {
        return this.aRoom;
    }
    
    /**
     * Gets if the door is lock or not
     * 
     * @return true if the door is locked
     */
    public boolean isLocked()
    {
        return this.aIsLocked;
    }
    
    /**
     * Sets the lock of the door 
     * 
     * @param pIsLocked the new lock status of the door
     */
    public void setLock(final boolean pIsLocked)
    {
        this.aIsLocked = pIsLocked;
    }
    
    /**
     * Open the door if the key item name in parameter is equals to the key item name of the door
     * 
     * @param pItemName the key item name 
     */
    public void openDoor(final String pItemName)
    {
        if(pItemName.equals(this.aKey.getItemName()) ){
            this.setLock(false);
        }else{
            this.setLock(true);
        }
    }
    
    
}
