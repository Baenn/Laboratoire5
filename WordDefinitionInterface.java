package Laboratoire5;

import java.util.List;

public interface WordDefinitionInterface {
    boolean addWordDefinition(WordDefinition inputWord);
    boolean removeWordDefinition(WordDefinition wordToRemove);


    List<WordDefinition> getWord(String word);
    List<WordDefinition> getAllWordsDefinition();
}
