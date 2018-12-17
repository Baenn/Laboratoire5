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
public class WordDefinition {

    private String word;
    private String definition;

    public WordDefinition(String word, String definition) 
    {
        if(word == null || word.isEmpty())
            throw new IllegalArgumentException("Empty or null word are invalid");
        
        else if(definition == null || definition.isEmpty())
            throw new IllegalArgumentException("Empty or null definition are invalid");
        
        setWord(word);
        setDefinition(definition);

    }

    public String getWord() {
        return word;
    }

    public String getDefinition() {
        return definition;
    }

    // mutator
    public void setWord(String word) {
        this.word = word;
    }
    
    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
