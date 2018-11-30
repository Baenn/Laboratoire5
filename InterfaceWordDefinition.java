package Laboratoire5;

import java.util.List;

public interface InterfaceWordDefinition {
    boolean addWordDefinition(WordDefinition m);
    boolean removeWordDefinition(WordDefinition m);


    List<WordDefinition> getWord(String m);
    List<WordDefinition> getAllWordsDefinition();
}
