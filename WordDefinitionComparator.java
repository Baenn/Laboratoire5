package Laboratoire5;


import java.util.Comparator;

public class WordDefinitionComparator implements Comparator<WordDefinition> {

    @Override
    public int compare(WordDefinition o1, WordDefinition o2) {
       return o1.getMot().compareTo(o2.getMot());
    }
}
