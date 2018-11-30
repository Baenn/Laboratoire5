package Laboratoire5;

public class WordDefinition {

    private String word;
    private String definition;

    public WordDefinition(String word, String definition) 
    {
        if(word == null || word.isEmpty())
            throw new WordException();
        else if(definition == null || definition.isEmpty())
            throw new DefinitionException();
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
