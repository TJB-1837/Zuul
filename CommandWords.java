import java.util.HashMap;

/**
 * CommandWords class - words that are recognised by the game
 *
 * @author Antoine MARMOL
 * @version 11 / 21/05/2024
 */
public class CommandWords
{
    // Attribut
    private HashMap<String, CommandWord> aValidCommands;
    
    // Constructeur
    /**
     * Constructs the HashMap of valid command words associated with their string
     */
    public CommandWords()
    {
        this.aValidCommands = new HashMap<String, CommandWord>();
        this.aValidCommands.put(null,CommandWord.UNKNOWN);
        this.aValidCommands.put("go", CommandWord.GO);
        this.aValidCommands.put("help", CommandWord.HELP);
        this.aValidCommands.put("quit", CommandWord.QUIT);
        this.aValidCommands.put("look", CommandWord.LOOK);
        this.aValidCommands.put("eat", CommandWord.EAT);
        this.aValidCommands.put("back", CommandWord.BACK);
        this.aValidCommands.put("test", CommandWord.TEST);
        this.aValidCommands.put("take", CommandWord.TAKE);
        this.aValidCommands.put("drop", CommandWord.DROP);
        this.aValidCommands.put("inventory", CommandWord.INVENTORY);
        this.aValidCommands.put("charge", CommandWord.CHARGE);
        this.aValidCommands.put("fire", CommandWord.FIRE);
        this.aValidCommands.put("alea", CommandWord.ALEA);
        this.aValidCommands.put("use",CommandWord.USE);
    }
    // Méthodes
    /**
     * Checks if a given string is a valid command.
     *
     * @param pCom The command to be checked for validity.
     * @return True if the command is valid, false otherwise.
     */
    public boolean isCommand(String pCom)
    {
        return aValidCommands.containsKey(pCom);
    } // isCommand(pCom)
    
    /**
     * Put in a String all available command words
     *
     * @return all valid commands
     */ 
    public String getCommandList()
    {
        String vCommandWords = "";
        for( String vCommand : aValidCommands.keySet() ){
            vCommandWords += vCommand + " ";
        }
        return vCommandWords;
    }// getCommandList()
    
    /**
     * Find the CommandWord associated with a command word.
     * 
     * @param commandWord The word to look up.
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = aValidCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
}
