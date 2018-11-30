package Laboratoire5;


import java.util.Comparator;

public class WordDefinitionComparator implements Comparator<WordDefinition> {

    @Override
    public int compare(WordDefinition o1, WordDefinition o2) {
       return o1.getWord().compareTo(o2.getWord());
    }
}
