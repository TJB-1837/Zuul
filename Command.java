 

/**
 * Classe Command - une commande du jeu d'aventure Zuul.
 *
 * @author Antoine MARMOL
 * @version 11 / 21/05/2024
 */
public class Command
{
    private CommandWord aCommandWord;
    private String aSecondWord = null;
    
    // Constructeurs 
    /**
     * Constructs a Command object with a specified command word and second word.
     *
     * @param pCommandWord The main command word.
     * @param pSecondWord  The second word associated with the command.
     */
    public Command(final CommandWord pCommandWord, final String pSecondWord)
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
    }
    
    // Accesseurs
    /**
     * Gets the command word of the command.
     *
     * @return The command word.
     */
    public CommandWord getCommandWord()
    {
        return this.aCommandWord;
    }
    
    /**
     * Gets the second word of the command.
     *
     * @return The second word, or null if none exists.
     */
    public String getSecondWord()
    {
        return this.aSecondWord;
    }
    
    // Méthodes 
    /**
     * Checks if the command has a second word.
     *
     * @return True if a second word is present, false otherwise.
     */
    public boolean hasSecondWord()
    {
        return this.aSecondWord != null;
    }
    
    /**
     * Checks if the command is unknown.
     *
     * @return True if the command word is null, indicating an unknown command.
     */
    public boolean isUnknown()
    {
        return this.aCommandWord == CommandWord.UNKNOWN || this.aCommandWord == null;
    }
} // Command
