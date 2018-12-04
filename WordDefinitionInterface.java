package Laboratoire5;

import java.util.List;

public interface WordDefinitionInterface {
    boolean addWordDefinition(WordDefinition m);
    boolean removeWordDefinition(WordDefinition m);


    List<WordDefinition> getWord(String m);
    List<WordDefinition> getAllWordsDefinition();
}
