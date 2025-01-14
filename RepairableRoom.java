
/**
 * RepairableRoom Class - a room that has 2 stages (broken / repaired)
 *
 * @author Antoine MARMOL
 * @version 11 / 21/05/2024
 */
public class RepairableRoom extends Room
{
    private String aRepairedRoomImagePath;
    private boolean aRepaired;
    private int aRepairPercent;
    
    /**
     * Constructs a RepairableRoom object
     * 
     * @param pName name of the room
     * @param pDes description of the room
     * @param pImageName path of the first image
     * @param pRepairedRoomImagePath path of the second image
     */
    public RepairableRoom(final String pName, final String pDes, final String pImageName,final String pRepairedRoomImagePath)
    {
        super(pName,pDes,pImageName);
        this.aRepairedRoomImagePath = pRepairedRoomImagePath;
        this.aRepaired = false;
        this.aRepairPercent = 0;
    }
    
    /**
     * Sets the repaired status (true or false)
     * 
     * @param pRepaired if the room is repaired or not
     */
    public void setRepaired(final boolean pRepaired)
    {
        this.aRepaired = pRepaired;
    }
    
    /**
     * Swaps the fist image to the second 
     */
    public void changeImageName()
    {
        this.setImageName(this.aRepairedRoomImagePath);
    }
    
    /**
     * Checks if the room is repaired
     * 
     * @return If the room is repaired
     */
    public boolean isRepaired()
    {
        return this.aRepaired;
    }
    
    /**
     * Gets The percent of repairation of the room
     * 
     * @return The percent of repairation of the room
     */
    public int getRepairPercent()
    {
        return this.aRepairPercent;
    }
    
    /**
     * Sets the repair percentage of the room
     * 
     * @param pRepairPercent the percent of repairation of the room
     */
    public void setRepairPercent(final int pRepairPercent)
    {
        this.aRepairPercent = pRepairPercent;
    }
}
