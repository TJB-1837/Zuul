
/**
 * Represents an item in the game. 
 * This class encapsulates the properties of an item, including its name, description, and price.
 *
 * @author Antoine MARMOL
 * @version 7 / 17/03/2024
 */
public class Item
{
    private String aItemName;
    private String aDescription = null;
    private int aPrice;
    private double aWeight;
    
    /**
     * Constructs an Item object with the specified name, description, and price.
     * 
     * @param pItemName The name of the item.
     * @param pDes The description of the item.
     * @param pPrice The price of the item. 
     * @param pWeight The weight of the item.
     */
    public Item(final String pItemName, final String pDes, final int pPrice, final double pWeight)
    {
        this.aItemName = pItemName;
        this.aDescription = pDes;
        this.aPrice = pPrice;
        this.aWeight = pWeight;
    }
    
    /**
     * Gets the name of the item.
     * 
     * @return The name of the item.
     */
    public String getItemName()
    {
        return this.aItemName;
    }
    
    /**
     * Gets the description of the item.
     * 
     * @return The description of the item.
     */
    public String getItemDescription()
    {
        return this.aDescription;
    }    
    
    /**
     * Gets the price of the item.
     * 
     * @return The price of the item.
     */
    public int getItemPrice()
    {
        return this.aPrice;
    }
    
    /**
     * Gets the weight of the item.
     * 
     * @return The weight of the item.
     */
    public double getItemWeight()
    {
        return this.aWeight;
    }
    
    /**
     * gets all the infos about an item
     * 
     * @return the string containing all these infos.
     */
    public String getItemInfos()
    {
        return this.getItemName()+", "+this.getItemDescription()+", Price : "+this.getItemPrice()+", Weight : "+this.getItemWeight();
    }
}

