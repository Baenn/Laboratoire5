package Laboratoire5;

/**
 * This class represents a word and its matching definition.
 * Responsibilities : 
 *          - Contain a word and its matching definition.
 * Collaborators :
 *          - 
 * @author : Banujan Atputharajah and Maxym Bonnette
 * @version : 1.0
 */
public class WordDefinition 
{
    // attributs
    private String word;
    private String definition;

    // constructor
    /**
     * Default constructor for the class
     * @ requires   word != null && word.isEmpty() == false
     *              definition != null && definition.isEmpty() == false
     * @param word The name of the word
     * @param definition The matching definition of the word
     * @throws IllegalArgumentException if word is null or empty OR if definition
     * is null or empty
     */
    public WordDefinition(String word, String definition) throws IllegalArgumentException
    {
        if(word == null || word.isEmpty())
            throw new IllegalArgumentException("Empty or null word are invalid");
        
        else if(definition == null || definition.isEmpty())
            throw new IllegalArgumentException("Empty or null definition are invalid");
        
        setWord(word);
        setDefinition(definition);

    }

    // accessors ethods 
    public String getWord() {
        return word;
    }

    public String getDefinition() {
        return definition;
    }

    // mutator methods
    public void setWord(String word) {
        this.word = word;
    }
    
    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
