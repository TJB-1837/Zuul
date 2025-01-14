import java.util.HashMap;
import java.util.Set;
/**
 * Décrivez votre classe ItemList ici.
 *
 * @author Antoine MARMOL
 * @version 11 / 21/05/2024
 */
public class ItemList
{
    private  HashMap< String, Item > aItemList;
    
    /**
     * constructs an ItemList
     */
    public ItemList()
    {
        this.aItemList = new HashMap< String, Item >();    
    }
    
    /**
     * gets the Item from an ItemList
     * 
     * @param pItemName the name of the item you want
     * @return the Item
     */
    public Item getItem(final String pItemName){
        return this.aItemList.get(pItemName);
    }
    
    /**
     * gets the size of the ItemList
     * 
     * @return the size
     */
    public int getSize(){
        return this.aItemList.size();
    }
    
    /**
     * gets the keySet of the ItemList
     * 
     * @return keySet
     */
    public Set<String> getKeySet(){
        return this.aItemList.keySet();
    }
    
    /**
     * removes the Item of the ItemList
     * 
     * @param pItemName Item name
     */
    public void removeItem(final String pItemName)
    {
        this.aItemList.remove(pItemName);
    }
     
    /**
     * gets if there's an Item in the ItemList
     * 
     * @return true if there's no Item
     */
    public boolean isThereAnItem()
    {
        return this.aItemList.isEmpty();
    }
    
    /**
     * Verifies if there's the Item in the ItemList base on the String you gave to it
     * 
     * @param pItemName the ItemName
     * @return true if the Item is present
     */
    public boolean containsItem(final String pItemName)
    {
        return this.aItemList.containsKey(pItemName);
    }
    
    /**
     * adds an Item in the room's item list
     * 
     * @param pItem the Item
     */
    public void addItem(final Item pItem)
    {
        this.aItemList.put(pItem.getItemName(),pItem);
    }
}
