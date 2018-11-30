package Laboratoire5;

import java.util.List;

public interface InterfaceWordDefinition {
    boolean addMotDefinition(WordDefinition m);
    boolean removeMotDefinition(WordDefinition m);


    List<WordDefinition> getMot(String m);
    List<WordDefinition> getAllMotDefinition();
}
