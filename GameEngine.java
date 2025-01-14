import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;


import java.util.HashMap;
import java.util.ArrayList;

/**
 *  This class is part of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.
 * 
 *  This class creates all rooms, creates the parser and starts
 *  the game.  It also evaluates and executes the commands that 
 *  the parser returns.
 * 
 * @author Antoine MARMOL
 * @version 11 / 21/05/2024
 */
public class GameEngine
{
    private Parser        aParser;
    private UserInterface aGui;
    private Player aPlayer;
    private ArrayList<Room> aRooms;
    private boolean aTestMode;
    
    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine()
    {
        this.aParser = new Parser();
        this.aPlayer = new Player("Chuck");
        this.aTestMode = false;
        this.aRooms  = new ArrayList<Room>();
        this.createRooms();
        
    }

    /**
     * Sets the user interface for the game engine.
     * 
     * @param pUserInterface The user interface object to be set.
     */
    public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
        this.printWelcome();
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        this.aGui.print( "\n" );
        this.aGui.println( "Welcome to Zuul Combat Evolved!" );
        this.aGui.println( "Your objective is to repair the space station." );
        this.aGui.println( "First Objective: find FlexTape and FlexSeal." );
        this.aGui.println( "Type 'help' if you need help." );
        this.aGui.print( "\n" );
        printLocaInfo();
    }
    

    /**
     * Create all the rooms and link their exits together.
     * Create all items and put them in the rooms
     */
    private void createRooms()
    {
        // Déclaration / création des salles 
        
        //Pole tech
        Room vVaisseau              = new Room("Ship","in the ship you arrived with","Vaisseau.png");
        Room vHangar                = new Room("Hangar","in the hangar","Hangar.png");
        RepairableRoom vSalleDesMachines      = new RepairableRoom("Engines room","in the engines room","SalleDesMachinesBroken.jpg","SalleDesMachinesRepaired.jpg");
        Room vSalleDeMaintenance    = new Room("Maintenance bay","in a maintenance bay","SalleDeMaintenance.jpg");
        Room vEntrepot              = new Room("Warehouse","in a warehouse","Entrepot.jpg");
        Room vMetroTech             = new Room("Metro station, technical division","in the metro station of the technical department","MetroTech.png");
        Room vArmurerie             = new Room("Armory","in the armory.","Armory.png");
        
        //Pole med
        Room vMetroMedic            = new Room("Metro station, medical departement","in the metro station of the medical bay","MetroMedic.png");
        Room vHallHopital           = new Room("Hospital reception","in the hospital reception.","Hopital.jpg");
        Room vChambre13             = new Room("Chamber 13","in the chamber number 13 of the hospital.","Chambre13.png");
        Room vChambre14             = new Room("Chamber 14","in the chamber number 14 of the hospital.","Chambre14.png");
        Room vBaieEvac              = new Room("Evac bay","in the evac bay","BaieEvac.png");
        Room vLab                   = new Room("Laboratory","in the lab.","Labo.png");
        Room vObservatoire           = new Room("Observatory","in the observatory.","Observatoire.png");
        TransporterRoom vNavette    = new TransporterRoom("Escape pod","in a strange escape pod","Navette.jpg");
        
        //Pole res
        Room vMetroRes              = new Room("Metro station, resitential area","in the metro station of the residential area","MetroRes.png");
        Room vPrison                = new Room("Prison", "in the jail","Prison.png");
        Room vHall                  = new Room("Hall","in the hall","Hall.png");
        Room vAdmin                 = new Room("Admin","in the admin","Admin.jpg");
        Room vCentreSecu            = new Room("Security center","in the security center","CentreSecu.jpg");
        Room vMarchand              = new Room("Srcapp","in the Scrapp store.\n Where you can buy and sell all you want.","Marchand.png");
        Room vZoneR1                = new Room("Residential area 1","in a residential area.\n Seems like it's dead.","ZR1.jpg");
        Room vA117                  = new Room("Appartment 117","in the appartment number 117","A117.png");
        Room vA052                  = new Room("Appartment 052","in the appartment number 052","A052.png");
        Room vA010                  = new Room("Appartment 010","in the appartment number 010","A010.png");
        Room vZoneR2                = new Room("Residential area 2","in a residential area.\n Seems like people are pretty rich there.","ZR2.jpg");
        Room vA239                  = new Room("Appartment 239","in the appartment number 239","A239.png");
        Room vA312                  = new Room("Appartment 312","in the appartment number 312","A312.png");
        Room vA141                  = new Room("Appartment 141","in the appartment number 141","A141.png");
        Room vA1837                 = new Room("Appartment 1837","in the appartment number 1837","A1837.jpg");
        Room vBar                   = new Room("Bar","in the bar","Bar.jpg");
        
        // Doors
        vEntrepot.setDoor(vSalleDesMachines, new Door (vSalleDesMachines,new Item("BlueKey","Can open the engines room door.",0,0.0)));    
        
        // aRooms
        this.aRooms.add(vVaisseau);
        this.aRooms.add(vHangar );
        this.aRooms.add(vSalleDesMachines );
        this.aRooms.add(vSalleDeMaintenance);
        this.aRooms.add(vEntrepot);
        this.aRooms.add(vMetroTech);
        this.aRooms.add(vArmurerie);
        
        this.aRooms.add(vMetroMedic);
        this.aRooms.add(vHallHopital);
        this.aRooms.add(vChambre13);
        this.aRooms.add(vChambre14);
        this.aRooms.add(vBaieEvac);
        this.aRooms.add(vLab);
        this.aRooms.add(vObservatoire);
        this.aRooms.add(vNavette);
        
        this.aRooms.add(vMetroRes);
        this.aRooms.add(vPrison);
        this.aRooms.add(vHall);
        this.aRooms.add(vAdmin);
        this.aRooms.add(vCentreSecu);
        this.aRooms.add(vMarchand);
        this.aRooms.add(vZoneR1);
        this.aRooms.add(vA117);
        this.aRooms.add(vA052);
        this.aRooms.add(vA010);
        this.aRooms.add(vZoneR2);
        this.aRooms.add(vA239);
        this.aRooms.add(vA312);
        this.aRooms.add(vA141);
        this.aRooms.add(vA1837);
        this.aRooms.add(vBar);
        
        
        
        // Entrées / Sorties
        //Pole tech ---------------------------------------------------------------
        //Sorties vVaisseau
        vVaisseau.setExits("south",vHangar);
        
        //Sorties vHangar
        vHangar.setExits("north",vVaisseau);
        vHangar.setExits("west",vEntrepot);
        vHangar.setExits("down",vMetroTech);
        
        //Sorties vSalleDesMachines
        vSalleDesMachines.setExits("west",vHangar);
        vSalleDesMachines.setExits("south",vEntrepot);
        
        //Sorties vSalleDeMaintenance
        vSalleDeMaintenance.setExits("down",vEntrepot);
        vSalleDeMaintenance.setExits("east",vMetroTech);
        
        //Sorties vEntrepot
        vEntrepot.setExits("east",vHangar);
        vEntrepot.setExits("up",vSalleDeMaintenance);
        vEntrepot.setExits("north",vSalleDesMachines);
        
        //Sorties vMetroTech
        vMetroTech.setExits("up",vHangar); 
        vMetroTech.setExits("south",vArmurerie);
        vMetroTech.setExits("west",vMetroMedic);
        vMetroTech.setExits("east",vMetroRes);
        
        //Sorties vArmurerie
        vArmurerie.setExits("north",vMetroTech);
        
        //Pole Med ---------------------------------------------------------------
        //Sorties vMetroMedic
        vMetroMedic.setExits("east",vMetroTech);
        vMetroMedic.setExits("up",vHallHopital);
        vMetroMedic.setExits("south",vObservatoire);
        vMetroMedic.setExits("west",vMetroRes);
        
        //Sorties vObservatoire
        vObservatoire.setExits("north",vMetroMedic);
        vObservatoire.setExits("up",vLab);
        
        //Sortie vLab
        vLab.setExits("west",vHallHopital);
        vLab.setExits("down",vObservatoire);
        
        //Sortie vHallHopital
        vHallHopital.setExits("down",vMetroMedic);
        vHallHopital.setExits("east",vLab);
        vHallHopital.setExits("north",vBaieEvac);
        vHallHopital.setExits("south",vChambre13);
        vHallHopital.setExits("west",vChambre14);
        
        //Sortie Chambre13
        vChambre13.setExits("north",vHallHopital);
        
        //Sortie Chambre14
        vChambre14.setExits("east",vHallHopital);
        
        //Sortie vBaieEvac
        vBaieEvac.setExits("south",vHallHopital);
        vBaieEvac.setExits("north",vNavette);
        
        //Sorties vNavette
        vNavette.setExits("south",vBaieEvac);
        
        //Pole Res ---------------------------------------------------------------
        //Sortie vMetroRes
        vMetroRes.setExits("west",vMetroTech);
        vMetroRes.setExits("east",vMetroMedic);
        vMetroRes.setExits("up",vHall);
        vMetroRes.setExits("south",vPrison);
        
        //Sortie vPrison
        vPrison.setExits("north",vMetroRes);
        
        //Sortie vHall
        vHall.setExits("down",vMetroRes);
        vHall.setExits("up",vAdmin);
        vHall.setExits("west",vMarchand);
        vHall.setExits("north",vZoneR1);
        vHall.setExits("south",vZoneR2);
        
        //Sortie vMarchand
        vMarchand.setExits("east",vHall);
        
        //Sortie vAdmin
        vAdmin.setExits("down",vHall);
        vAdmin.setExits("east",vCentreSecu);
        
        //Sortie vCentreSecu
        vCentreSecu.setExits("west",vAdmin);
        
        //Sortie vZoneR1
        vZoneR1.setExits("up",vA117);
        vZoneR1.setExits("north",vA052);
        vZoneR1.setExits("west",vA010);
        vZoneR1.setExits("east",vBar);
        vZoneR1.setExits("south",vHall);
        
        //Sortie vA117
        vA117.setExits("down",vZoneR1);
        
        //Sortie vA052
        vA052.setExits("south",vZoneR1);
        
        //Sortie vA010
        vA010.setExits("east",vZoneR1);
        
        //Sortie vZoneR2
        vZoneR2.setExits("north",vHall);
        vZoneR2.setExits("down",vA1837);
        vZoneR2.setExits("up",vA312);
        vZoneR2.setExits("east",vA239);
        vZoneR2.setExits("west",vBar);
        vZoneR2.setExits("south",vA141);
        
        //Sortie vA141
        vA141.setExits("north",vZoneR2);
        
        //Sortie vA239
        vA239.setExits("west",vZoneR2);
        
        //Sortie vA312
        vA312.setExits("down",vZoneR2);
        
        //Sortie vA1837
        vA1837.setExits("up",vZoneR2);
        
        //Sortie vBar
        vBar.setExits("west",vZoneR1);
        vBar.setExits("east",vZoneR2);
        
        //--------------------------------------------------------
        
        // Doors
        //Door vDoorSDM = new Door (vSalleDesMachines, new Item("BlueKey","Can open the engines room door.",0,0.0));        
        
        
        //Début du jeu
        this.aPlayer.setCurrentRoom(vVaisseau);
        
        
        
        // Items   
        vHangar.addItem( new Item("Flashlight","Lumos Maxima",15,0.5) ); //# 1
        vSalleDeMaintenance.addItem( new Item("Shovel","Useful for burying people or monsters",30,3.0) );
        vSalleDeMaintenance.addItem( new Item("Spanner","Could be usefull to enter locked vents",25,1.0) );
        vEntrepot.addItem( new Item("GoldBar","It must be worth a lot ",150,35.0) ); //# 3
        vLab.addItem( new MagicCookie("MagicCookie",3) ); //# 2
        vAdmin.addItem( new Beamer("Beamer") ); //# 4
        vPrison.addItem( new Poison("Poison",7) ); //# 5
        vChambre13.addItem( new Antidote("Antidote") ); //# 6
        vMarchand.addItem( new FlexTape("FlexSeal",50) );
        vBar.addItem( new FlexTape("FlexTape",50) );
        vBar.addItem( new Item("Beer","Great beer",20,2.0 ) );
        vChambre14.addItem( new Item("BlueKey","Can open the engines room",0,0.0) );
        vA312.addItem( new Item("BlueKey","Can open the engines room",0,0.0) );
        vMetroTech.addItem( new Poison("StrangePotion",15) );
    }//createRooms()
    
    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     * 
     * @param pCommandLine The command entered by the user.
     */
    public void interpretCommand( final String pCommandLine ) 
    {
        this.aGui.println( "> " + pCommandLine );
        Command vCommand = this.aParser.getCommand( pCommandLine );

        if ( vCommand.isUnknown() ) {
            this.aGui.println( "I don't know what you mean..." );
            return;
        }
        
        CommandWord vCommandWord = vCommand.getCommandWord();
        switch(vCommandWord){
            case GO: this.goRoom(vCommand);
                break;
            case HELP: this.printHelp();
                break;
            case LOOK: this.look(vCommand);
                break;
            case EAT:  this.eat(vCommand);
                break;
            case BACK: this.back();
                break;
            case INVENTORY: this.inventory();
                break;
            case TEST: this.test(vCommand);
                break;
            case TAKE: this.take(vCommand);
                break;
            case DROP: this.drop(vCommand);
                break;
            case FIRE: this.fire(vCommand);
                break;
            case CHARGE: this.charge(vCommand);
                break;
            case ALEA: this.alea(vCommand);
                break;
            case USE:  this.use(vCommand);
                break;
            case QUIT:
                if ( vCommand.hasSecondWord() )this.aGui.println( "Quit what?" );
                else this.endGame();
                break;
            default:
                this.aGui.println("Programmer error: Command not recognised!");
                break;
        }
    }

    // implementations of user commands:
    /**
     * Tests a bunch of commands
     * 
     * @param pCommand the document where the commands are
     */
    private void test(final Command pCommand)
    {
        this.aTestMode = true;
        if ( !pCommand.hasSecondWord() ) {
            // if there is no second word, we don't know where to go...
            this.aGui.println( "Test what? ( indicate the document's name )" );
            return;
        }
        Scanner vDoc; 
        try{
            vDoc = new Scanner( new BufferedReader( new FileReader( "Test\\"+ pCommand.getSecondWord() +".txt" ) ) );
            while(vDoc.hasNextLine()){
                String vLigne = vDoc.nextLine();
                interpretCommand(vLigne);
            }
            vDoc.close();
        } 
        catch( FileNotFoundException Error ){
            this.aGui.println("This document is not found");
        }
    }
    
    /**
     * Saves a room for testing without being worried by the Transporter Room
     * 
     * @param pCommand The command entered by the user.
     */
    private void alea(final Command pCommand)
    {
        if(this.aTestMode == false) return;
        if(!pCommand.hasSecondWord()){
            this.aGui.println( "Error: please indicate an index of room." );
            return;
        }else{
            String vIndexS = pCommand.getSecondWord();
            int vIndex = Integer.parseInt(vIndexS);
            this.aGui.println("s:"+vIndexS+" i:"+vIndex);
            for(Room vRoom : this.aRooms){
                if(vRoom instanceof TransporterRoom){
                    TransporterRoom vTR = (TransporterRoom)vRoom;
                    vTR.setAleaRoom( this.aRooms.get(vIndex) );
                }
            }
        }
    }
    
    /**
     * Prints the result of the charge of a beamer
     * 
     * @param pCommand The command entered by the user.
     */
    private void charge(final Command pCommand)
    {
        this.aGui.println( this.aPlayer.charge(pCommand) );
    }
     
    /**
     * Prints the result of the fire of a beamer
     * 
     * @param pCommand The command entered by the user.
     */
        private void fire(final Command pCommand)
    {
        this.aGui.println( this.aPlayer.fire(pCommand) );
        this.printLocaInfo();
    }
    
    /**
     * prints the inventory of the player
     */
    private void inventory()
    {
         this.aGui.println(this.aPlayer.inventoryString());
    }
    
    /**
     * prints the action of taking an Item
     * 
     * @param pCommand the command of the user
     */
    private void take(final Command pCommand)
    {
        this.aGui.println(this.aPlayer.take(pCommand));
    }
    
    /**
     * prints the droping an Item
     * 
     * @param pCommand the command of the user
     */
    private void drop(final Command pCommand)
    {
         this.aGui.println(this.aPlayer.drop(pCommand));
    }
    
    /**
     * Prints the long description of the room.
     * 
     * @param pCommand the command of the user
     */
    private void look(final Command pCommand)
    {
        if ( !pCommand.hasSecondWord() ) {
            this.aGui.println( this.aPlayer.getCurrentRoom().getLongDescription() );
            return;
        } else {
            String vItemName = pCommand.getSecondWord();
            if(this.aPlayer.getCurrentRoom().getItemList().containsItem(vItemName) ){
                this.aGui.println( this.aPlayer.getCurrentRoom().getItem(vItemName).getItemInfos() );
            }else if(this.aPlayer.getInventory().containsItem(vItemName) ){
                this.aGui.println( this.aPlayer.getInventory().getItem(vItemName).getItemInfos() );
            }else{
                this.aGui.println( "This Item is not disponible!" );
            }
        }
    } // look()
    
    /**
     * prints the action of eating
     * 
     * @param pCommand the command of the user
     */
    private void eat(final Command pCommand)
    {
        this.aGui.println(this.aPlayer.eat(pCommand));
    } // eat(.)
    
    /**
     * prints the action of using an item.
     * 
     * @param pCommand the command of the user.
     */
    private void use(final Command pCommand)
    {
        this.aGui.println(this.aPlayer.use(pCommand));
        this.aGui.showImage( this.aPlayer.getCurrentRoom().getImageName() );
        RepairableRoom vSalleDesMachines = (RepairableRoom)this.aRooms.get(2);
        if(vSalleDesMachines.isRepaired()){
            this.endGame();
        }
    }

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        this.aGui.println( "You are lost. You are alone. You wander" );
        this.aGui.println( "around at Sebastopol station, Solar system." + "\n" );
        this.aGui.println( "Your command words are: " + this.aParser.getCommandString() );
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     * 
     * @param pCommand The command word representing the direction the player wants to go
     */
    private void goRoom( final Command pCommand ) 
    {
        if ( ! pCommand.hasSecondWord() ) {
            // if there is no second word, we don't know where to go...
            this.aGui.println( "Go where?" );
            return;
        }

        String vDirection = pCommand.getSecondWord();

        // Try to leave current room.
        Room vNextRoom;
        if(this.aPlayer.getCurrentRoom() instanceof TransporterRoom){
            TransporterRoom vCurrentRoom = (TransporterRoom)this.aPlayer.getCurrentRoom();
            if(this.aTestMode == true){
                vNextRoom = vCurrentRoom.getAleaRoom();
            }else{
                vNextRoom = vCurrentRoom.getExit( this.aRooms );
            }
        }else{
            vNextRoom = this.aPlayer.getCurrentRoom().getExit( vDirection );
            if(this.aPlayer.getCurrentRoom().getDoors().containsValue( this.aPlayer.getCurrentRoom().getDoor( vNextRoom ))){
                String vKeyName = this.aPlayer.getCurrentRoom().getDoor(vNextRoom).getKey().getItemName();
                if( this.aPlayer.getInventory().containsItem( vKeyName ) ){
                    this.aPlayer.getCurrentRoom().getDoor(vNextRoom).openDoor( vKeyName );
                    this.aGui.println( "This door is unlocked." );
                } else {
                    this.aPlayer.getCurrentRoom().getDoor(vNextRoom).openDoor( "a" );
                }
                if(this.aPlayer.getCurrentRoom().getDoor(vNextRoom).isLocked()){
                    this.aGui.println( "This door is locked. Find the "+this.aPlayer.getCurrentRoom().getDoor(vNextRoom).getKey().getItemName() );
                    return; 
                }
            }
        }
        if ( vNextRoom == null )
            this.aGui.println( "There is no door!" );
        else {
            this.aPlayer.changeRoom(vNextRoom);
            this.printLocaInfo();
            if( this.aPlayer.getTimeLimit().getGameOver() ){
                this.aGui.println("GAME OVER! You lost!");
                this.endGame();
            }
        }
    }
    /*
    public boolean canPlayerGoDoor(final Room pNextRoom){
        if(this.aPlayer.getCurrentRoom().getDoors().containsValue( this.aPlayer.getCurrentRoom().getDoor( pNextRoom ))){
            String vKeyName = this.aPlayer.getCurrentRoom().getDoor(pNextRoom).getKey().getItemName();
            if( this.aPlayer.getInventory().containsItem( vKeyName ) ){
                this.aPlayer.getCurrentRoom().getDoor(pNextRoom).openDoor( vKeyName );
                this.aGui.println( "This door is unlocked." );
                return true;
            } else {
                this.aPlayer.getCurrentRoom().getDoor(pNextRoom).openDoor( "a" );
            }
            if(this.aPlayer.getCurrentRoom().getDoor(pNextRoom).isLocked()){
                this.aGui.println( "This door is locked. Find the "+this.aPlayer.getCurrentRoom().getDoor(pNextRoom).getKey().getItemName() );
                return false; 
            }
        }
        return false;
    }
    */
    /**
     * Returns to the previous room.
     */
    private void back()
    {
        if(this.aPlayer.isThereAPreviousRoom()){
            this.aGui.println("There is no previous room.");              
        } else {
            Room vNextRoom;
            if(this.aPlayer.getCurrentRoom() instanceof TransporterRoom){
                TransporterRoom vCurrentRoom = (TransporterRoom)this.aPlayer.getCurrentRoom();
                if(this.aTestMode == true){
                    vNextRoom = vCurrentRoom.getAleaRoom();
                }else{
                    vNextRoom = vCurrentRoom.getExit( this.aRooms );
                }
                this.aPlayer.changeRoom(vNextRoom);
                this.printLocaInfo();  
                return;
            }
            this.aPlayer.backToThePreviousRoom();
            this.printLocaInfo();  
        }
    } // back()
    
    /**
     * Prints out the description of the room and it's image.
     */
    private void printLocaInfo()
    {
        this.aGui.println( this.aPlayer.getCurrentRoom().getLongDescription() );
        if ( this.aPlayer.getCurrentRoom().getImageName() != null )
            this.aGui.showImage( this.aPlayer.getCurrentRoom().getImageName() );
    }
    
    /**
     * Ends the game and prints out the ending message.
     */
    private void endGame()
    {
        this.aGui.println( "Thank you for playing.  Good bye." );
        this.aGui.enable( false );
    }

}
