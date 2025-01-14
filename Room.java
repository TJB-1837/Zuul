import java.util.HashMap;
import java.util.Set;
/**
 * Classe Room - un lieu du jeu d'aventure Zuul.
 *
 * @author Antoine MARMOL
 * @version 11 / 21/05/2024
 */

public class Room
{
    private HashMap< String , Room > aExits;
    private String aName;
    private String aDescription;
    private String aImageName;
    private ItemList aItems;
    
    private HashMap< Room , Door > aDoors;
    
    // Constructeurs
    /**
     * Constructs a Room with a specified description.
     *
     * @param pName Name of the room
     * @param pDes The description of the room.
     * @param pImageName The name of the image of the room.
     */
    public Room(final String pName, final String pDes, final String pImageName)
    {
        this.aName = pName;
        this.aDescription = pDes;
        this.aExits = new HashMap< String , Room >();
        this.aDoors = new HashMap< Room , Door >();
        this.aImageName = pImageName;
        this.aItems = new ItemList();
    } // Room(pDescription,pImageName)
    
    // Accesseurs
    /**
     * Gets the doors and their destinations
     * 
     * @return the HashMap containing all the doors and their destinations
     */
    public HashMap< Room , Door > getDoors()
    {
        return this.aDoors;
    }
    
    /**
     * Gets the door that access to the next room in parameter
     * 
     * @param pNextRoom the next room 
     * @return the door that access to the next room
     */
    public Door getDoor(final Room pNextRoom)
    {
        return this.aDoors.get(pNextRoom);
    }
    
    /**
     * Sets a door 
     * 
     * @param pNextRoom the room the door gives you access
     * @param pDoor the door 
     */
    public void setDoor(final Room pNextRoom, final Door pDoor)
    {
        this.aDoors.put(pNextRoom,pDoor);
    }
    
    /**
     * Gets the description of the room.
     *
     * @return The description of the room.
     */
    public String getDescription()
    {
        return this.aDescription;
    }
    
    /**
     * Gets the description of the room.
     *
     * @return The description of the room.
     */
    public String getName()
    {
        return this.aName;
    }
    
    /**
     * Gets the room in the specified direction.
     *
     * @param pDirection The direction of the exit.
     * @return The room in the specified direction.
     */
    public Room getExit(final String pDirection)
    {
        return this.aExits.get(pDirection);
    } // getExit(pDirection)
    
    /**
     * Gets a string representation of the available exits from the room.
     *
     * @return A string containing the available exits.
     */
     public String getExitString()
    {
        StringBuilder vExits = new StringBuilder("Exits: ");
        for( String exit : this.aExits.keySet() ){
            vExits.append(" " + exit);
        }
        return vExits.toString();
    } // getExitString()
    
    /**
     * Return a long description of this room, of the form:
     *      You are in the kitchen
     *      Exits: north west
     * 
     * @return A string containing a description of the room and  it's exits
     */
    public String getLongDescription()
    {
        return "You are " +this.aDescription + ".\n" + this.getItemString() + "\n" + this.getExitString() ;
    } // getLongDescription()
    
    /**
     * Gets the name of the image associated with this room.
     * 
     * @return The name of the image.
     */
    public String getImageName()
    {
        return this.aImageName;
    }
    
    /**
     * Retrieves an item from the collection of items based on its name.
     * 
     * @param pItemName The name of the item to retrieve.
     * @return The item object associated with the given name, or null if no such item exists.
     */
    public Item getItem(final String pItemName)
    {
        return this.aItems.getItem(pItemName);
    }
    
    /**
     * Generates a string representation of the items available in the room.
     * 
     * @return A string containing the names of all available items, or "No item here." if there are no items.
     */
    public String getItemString()
    {
        if(this.aItems.getSize() != 0){
            StringBuilder vItems = new StringBuilder("Items: ");
            for( String vItem : this.aItems.getKeySet() ){
                vItems.append(vItem + " / ");
            }
            return vItems.toString();
        } else {
            return "No item here.";
        }
    }
    
    /**
     * gets the ItemList of the room
     * 
     * @return the ItemList of the Room
     */
    public ItemList getItemList()
    {
        return this.aItems;
    }
    
    // Modificateurs
    /**
     * Sets the exit for a direction from the current room.
     *
     * @param pDirection      The direction of the exit.
     * @param pSalleVoisine   The room in the specified direction.
     */
    public void setExits(final String pDirection, final Room pSalleVoisine)
    {
        this.aExits.put(pDirection,pSalleVoisine);
    } // setExits(pDirection,pSalleVoisine);
    
    /**
     * Sets the imageName for a room
     * 
     * @param pImageName The path of the image
     */
    public void setImageName(final String pImageName)
    {
        this.aImageName = pImageName;
    }
    
    /**
     * Verfies if this Room has the room in parameter as an exit
     * 
     * @param pRoom the room we check the exits
     * @return a boolean value (true if this is an exit of pRoom and if the door is unlocked) 
     */
    public boolean isExit(final Room pRoom)
    {
        for( Room vRoom : this.aExits.values() ){
            if( vRoom.equals(pRoom) ){
                if(this.aDoors.containsKey(pRoom)){
                    return this.aDoors.get(pRoom).isLocked();
                }
                return true;
            }
        }
        return false;
    }
    
    /**
     * adds an item to the room
     * 
     * @param pItem the item you want to add
     */
    public void addItem(final Item pItem)
    {
        this.getItemList().addItem(pItem);
    }
} // Room
