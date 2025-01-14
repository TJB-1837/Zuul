import java.util.Stack;


/**
 * Player is a class who creates the player attributes / limits
 *
 * @author Antoine MARMOL
 * @version 11 / 21/05/2024
 */
public class Player
{
    private String aPlayerName;
    private Room aCurrentRoom;
    private Stack< Room > aPreviousRooms;
    private ItemList aInventory;
    private double aWeight;
    private double aMaxWeight;
    private final int MAX_HEALTH = 100;
    private int aCredits;
    private TimeLimit aTimeLimit;
    
    
    /**
     * constructs the player object
     * 
     * @param pPlayerName the name of the player;
     */
    public Player(final String pPlayerName)
    {
        this.aPlayerName = pPlayerName;
        this.aInventory = new ItemList();
        this.aWeight = 0.0;
        this.aMaxWeight = 30.0;
        this.aCredits = 0;
        this.aPreviousRooms = new Stack< Room >();
        this.aTimeLimit = new TimeLimit();
        //this.aTimeLimit.getTimer().start();
    }
    
    /**
     * Gets the TimeLimit object
     * 
     * @return the TimeLimit
     */
    public TimeLimit getTimeLimit()
    {
        return this.aTimeLimit;
    }
    
    /**
     * Gets the inventory.
     * 
     * @return The inventory.
     */
    public ItemList getInventory()
    {
        return this.aInventory;
    }
    
    /**
     * Gets the name of the player.
     * 
     * @return the name of the player.
     */
    public String getPlayerName()
    {
        return this.aPlayerName;
    }  
    
    /**
     * Gets the current room of the player.
     * 
     * @return the current room of the player.
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    }  
    
    /**
     * Gets the Item.
     * 
     * @param pItemName the name of the Item
     * @return the Item
     */
    public Item getItem(final String pItemName)
    {
        return this.aInventory.getItem(pItemName);
    }
    
    /**
     * Gets the max weight the player can carry.
     * 
     * @return The max weight the player can carry.
     */
    public double getMaxWeight()
    {
        return this.aMaxWeight;
    }
    
    /**
     * Sets the Room where the player should be.
     * 
     * @param pCurrentRoom the Room you want to be in.
     */
    public void setCurrentRoom(final Room pCurrentRoom)
    {
        this.aCurrentRoom = pCurrentRoom;
    }  
    
    /**
     * sets the max weigh the player can carry.
     * 
     * @param pWeight the weight.
     */
    public void setMaxWeight(final double pWeight)
    {
        this.aMaxWeight = pWeight;
    }
    
    /**
     * adds an Item in the player's inventory
     * 
     * @param pItem the Item
     */
    public void addItem(final Item pItem)
    {
        this.aInventory.addItem( pItem );
    }
    
    /**
     * changes the player's Room 
     * 
     * @param pNextRoom The room where you wanna go
     */
    public void changeRoom(final Room pNextRoom)
    {
        if(this.aCurrentRoom instanceof TransporterRoom){
            this.aPreviousRooms.clear();
        } else {
            this.aPreviousRooms.push(this.aCurrentRoom);
        }
        this.setCurrentRoom( pNextRoom );
        if(this.aTimeLimit.isTimeLimited()) this.aTimeLimit.timeLimit(this.aTimeLimit.getRemainingMoves());
    }
    
    /**
     * gets if there is a previous room
     * 
     * @return true if there is no previous room
     */
    public boolean isThereAPreviousRoom()
    {
        return this.aPreviousRooms.empty();
    }
    
    /**
     * Gets the last room the player was in 
     * 
     * @return the last room of the previous rooms stack
     */
    public Room getLastRoom()
    {
        return this.aPreviousRooms.peek();
    }
    
    /**
     * moves the player back to the previous room he was
     */
    public void backToThePreviousRoom()
    {
        if( this.aCurrentRoom.isExit(this.aPreviousRooms.peek()) ) {
            this.aCurrentRoom = this.aPreviousRooms.pop();
            if(this.aTimeLimit.isTimeLimited()) this.aTimeLimit.timeLimit(this.aTimeLimit.getRemainingMoves());
        }
    }
        
    /**
     * The command of eating an item
     * 
     * @param pCommand The command put by the user
     * @return A String that informs the user on what action he realized
     */
    public String eat(final Command pCommand)
    {
        if(!pCommand.hasSecondWord()){
            return "What do you want to eat?" ;
        }else{
            String vItemName = pCommand.getSecondWord();
            Item vItem = this.getInventory().getItem(vItemName);
            if(this.getInventory().containsItem(vItemName)){
                if(vItem instanceof MagicCookie){
                    MagicCookie vMC = (MagicCookie)vItem;
                    vMC.applyEffect(this);
                    this.aWeight -= vMC.getItemWeight();
                    this.aInventory.removeItem(vMC.getItemName());
                    return "You have eaten now and you are not hungry any more." ;
                }
                if(vItem instanceof Poison){
                    Poison vP = (Poison)vItem;
                    String vS = "";
                    vP.applyEffect(this);
                    this.aWeight -= vP.getItemWeight();
                    this.aInventory.removeItem(vP.getItemName());
                    vS = "Are you crazy!!! Why did you eat poison.\n" ;
                    vS = + vP.getEffect()+" moves until you die\n" ;
                    return vS + "Your only chance to survive is to eat an Antidote" ;
                }
                if(vItem instanceof Antidote){
                    Antidote vA = (Antidote)vItem;
                    String vS = "";
                    if(this.getTimeLimit().isTimeLimited()) vS = " Congratulation you survived!\n ";
                    vA.applyEffect(this);
                    this.aWeight -= vA.getItemWeight();
                    this.aInventory.removeItem(vA.getItemName());
                    return vS + "Taste like a medicine." ;
                }
            }else{
                return "You don't have";
            }
        }
        return "You don't have this item in your inventory";
    }
    
    /**
     * The command of using an item
     * 
     * @param pCommand The command put by the user
     * @return A String that informs the user on what action he realized
     */
    public String use(final Command pCommand)
    {
        if ( !pCommand.hasSecondWord() ) {
            return "Use what?" ;
        }   
        String vItemName = pCommand.getSecondWord();
        if ( this.aInventory.containsItem(vItemName) ){
            Item vItem = this.aInventory.getItem(vItemName);
            if( vItem instanceof FlexTape ){
                FlexTape vFlexTape = (FlexTape)vItem;
                if(this.aCurrentRoom instanceof RepairableRoom){
                    RepairableRoom vCurrentRoom = (RepairableRoom) this.aCurrentRoom;
                    vCurrentRoom.setRepairPercent(vCurrentRoom.getRepairPercent() + vFlexTape.getRepairPercent());
                    vCurrentRoom.changeImageName();
                    this.aInventory.removeItem(vFlexTape.getItemName());
                    this.aWeight -= vFlexTape.getItemWeight();
                    if(vCurrentRoom.getRepairPercent() >= 100){
                        vCurrentRoom.setRepaired(true);
                    }
                    if(vCurrentRoom.isRepaired() ){
                        return "You repaired the "+this.aCurrentRoom.getName() + "\n You won the Zuul: CE game\n Thanks for playing";
                    }
                    return "You repaired the room at "+vCurrentRoom.getRepairPercent()+" percent.";
                }
                return "This isn't a repairable room";
            }
            return "This isn't a FlexTape."+ vItem.getClass().getName();
        }else{
            return "You don't have this item in your inventory";
        }
    }
    
    /**
     * The command of taking
     * 
     * @param pCommand The command put by the user
     * @return A String that informs the user on what action he realized
     */
    public String take(final Command pCommand)
    {
        if ( !pCommand.hasSecondWord() ) {
            return "Take what?";
        }else{
            String vItemName = pCommand.getSecondWord();
            // taking an Item
            if(this.getCurrentRoom().getItemList().containsItem(vItemName) ){
                if( (this.aWeight + this.aCurrentRoom.getItem(vItemName).getItemWeight()) <= this.aMaxWeight ){
                    this.addItem(this.getCurrentRoom().getItem(vItemName));
                    this.aWeight += this.getCurrentRoom().getItem(vItemName).getItemWeight();
                    this.getCurrentRoom().getItemList().removeItem(vItemName);
                    if(this.aInventory.getItem(vItemName) instanceof FlexTape){
                        if(this.aInventory.containsItem("FlexTape") && this.aInventory.containsItem("FlexSeal")){
                            return "First Objective complete. Find the Engines room\nto repair this space station.\nYou took "+vItemName+"\nYour new Weight is "+this.aWeight;
                        }else if(this.aInventory.containsItem("FlexTape")){
                            return "Good! You found FlexTape. All that's left is to find some FlexSeal";
                        }else if(this.aInventory.containsItem("FlexSeal")){
                            return "Good! You found FlexSeal. All that's left is to find some FlexTape";
                        }
                    }
                    return"You took "+vItemName+"\nYour new Weight is "+this.aWeight;
                }else{
                    return "This item is to heavy for you.";
                }
            } else {
                return"Which object ?";
            }
        }     
    }
    
    /**
     * The command of dropping
     * 
     * @param pCommand The command put by the user
     * @return A String that informs the user on what action he realized
     */
    public String drop(final Command pCommand)
    {
        if ( !pCommand.hasSecondWord() ) {
            return "Drop what?" ;
        }else{
            String vItemName = pCommand.getSecondWord();
            Item vItem = this.getItem(vItemName);
            // Dropping an Item
            if( this.aInventory.isThereAnItem() ) {
                return "You don't have any Item in your inventory";
            } else {
                this.getCurrentRoom().getItemList().addItem( vItem );
                this.aInventory.removeItem(vItemName);
                this.aWeight -= this.getCurrentRoom().getItem(vItemName).getItemWeight();
                return "You dropped "+vItemName+"\nYour new Weight is "+this.aWeight;
            }
        }     
    }
    
    /**
     * gets the string with all the Items in the player inventory and it's total weight
     * 
     * @return the string information the user about what's in his inventory
     */
    public String inventoryString()
    {
        if(this.aInventory.isThereAnItem()){
            return "You are not carring any Item.\nWeight: 0.0/"+this.aMaxWeight;
        } else {
            StringBuilder vInventoryString = new StringBuilder("Items in your inventory: ");
            double vWeight = 0.0;
            for(String vItemName : this.aInventory.getKeySet()){
                vInventoryString.append(vItemName +" / "); 
                vWeight += this.getItem(vItemName).getItemWeight();
            } 
            return vInventoryString + "Weight : " + vWeight + "/" + this.aMaxWeight;
        }
    }
    
    /**
     * Sets if the player is limited in moves or not
     * 
     * @param pValue The boolean that define the limited status
     */
    public void setTimeLimiter(final boolean pValue) 
    {
         this.aTimeLimit.setTimeLimited(pValue);
    }
    
    /**
     * The command of charging
     * 
     * @param pCommand The command put by the user
     * @return A String that informs the user on what action he realized
     */
    public String charge(final Command pCommand)
    {
        if ( !pCommand.hasSecondWord() ) {
            return "Charge what?" ;
        }else{  
            String vItemName = pCommand.getSecondWord();           
            if ( this.aInventory.containsItem(vItemName) ){
                Item vItem = this.aInventory.getItem(vItemName);
                if( vItem instanceof Beamer ){
                    Beamer vBeamer = (Beamer)vItem;
                    vBeamer.chargeBeamer(this.aCurrentRoom);
                    return "You saved this room in the beamer.";
                }else{
                    return "This isn't a beamer.";
                }
            }
            return "You don't have this item in your inventory";
        }
    }
    
    /**
     * The command of firing
     * 
     * @param pCommand The command put by the user
     * @return A String that informs the user on what action he realized
     */
    public String fire(final Command pCommand)
    {
        if ( !pCommand.hasSecondWord() ) {
            return "Fire what?" ;
        }else{   
            String vItemName = pCommand.getSecondWord();
            if ( this.aInventory.containsItem(vItemName) ){
                Item vItem = this.aInventory.getItem(vItemName);
                if( vItem instanceof Beamer ){
                    Beamer vBeamer = (Beamer)vItem;
                    this.changeRoom( vBeamer.getSavedRoom() );
                    this.aPreviousRooms.clear();
                    vBeamer.resetBeamer();
                    return "You fired the beamer.";
                }else{
                    return "This isn't a beamer.";
                }
            }
            return "You don't have this item in your inventory";
        }
    }

}
