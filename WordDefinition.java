package Laboratoire5;

public class WordDefinition {

    private String Mot;
    private String definition;

    public WordDefinition(String mot, String definition) 
    {
        if(mot == null || mot.isEmpty())
            throw new WordException();
        else if(definition == null || definition.isEmpty())
            throw new DefinitionException();
        setMot(mot);
        setDefinition(definition);

    }

    public String getMot() {
        return Mot;
    }

    public void setMot(String mot) {
        Mot = mot;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
