import java.util.ArrayList;

/**
 * TransporterRoom Class - a room that transports the player into a random room of the map
 *
 * @author Antoine MARMOL
 * @version 11 / 21/05/2024
 */
public class TransporterRoom extends Room
{
    private RoomRandomizer aRoomRandomizer;
    private Room aRoomAlea;
    
    /**
     * Constructs a TransporterRoom object
     * 
     * @param pName name of the room
     * @param pDes  description of the room
     * @param pImageName name of the image / path
     */
    public TransporterRoom(final String pName, final String pDes, final String pImageName)
    {
        super(pName,pDes,pImageName);
        this.aRoomRandomizer = new RoomRandomizer();
    }    
    
    /**
     * Puts the exit of the transporter room to a random room
     * 
     * @param pRooms the list of rooms created
     * @return the room which is exit of the transporter room
     */
    public Room getExit(final ArrayList<Room> pRooms)
    {
        this.aRoomRandomizer.setRandomRoom(pRooms);
        return this.aRoomRandomizer.getRandomRoom();
    }
    
    /**
     * Sets the alea room for the alea command
     * 
     * @param pRoom the alea room
     */
    public void setAleaRoom(final Room pRoom)
    {
        this.aRoomAlea = pRoom;
    }
    
    /**
     * Gets the alea room for the alea command
     * 
     * @return pRoom the alea room
     */
    public Room getAleaRoom()
    {
        return this.aRoomAlea;
    }
}
