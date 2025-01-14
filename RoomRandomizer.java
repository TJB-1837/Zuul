import java.util.Random;
import java.util.ArrayList;

/**
 * RoomRandomizer Class - finds a random room
 *
 * @author Antoine MARMOL
 * @version 11 / 21/05/2024
 */
public class RoomRandomizer
{
    private Room aRandomRoom;
    private Random aRandom;
    
    /**
     * Constructs a RoomRandomizer object
     */
    public RoomRandomizer()
    {
        this.aRandom = new Random();
    }
    
    /**
     * creates a random index 
     * 
     * @param pNbRooms the number of rooms
     * @return a random index
     */
    public int generateRandomRoomIndex(final int pNbRooms)
    {
        return this.aRandom.nextInt(pNbRooms);
    }
    
    /**
     * Saves a random room base on the size of the list in parameters
     * 
     * @param pRooms the ArrayList of created rooms
     */
    public void setRandomRoom(final ArrayList<Room> pRooms)
    {
        this.aRandomRoom = pRooms.get( this.generateRandomRoomIndex( pRooms.size() ) );
    }
    
    /**
     * gets the random room stored in this Transporter room
     * 
     * @return the saved room
     */
    public Room getRandomRoom()
    {
        return this.aRandomRoom;
    }
}
