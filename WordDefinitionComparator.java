package Laboratoire5;

import java.util.Comparator;

/**
 * This class is used to compare two WordDefinition objects to order a list of 
 * WordDefinition objects alphabetically.
 * Responsibilities : 
 *          - Compare 2 WordDefinition objects by their word
 * Collaborators :s
 *          - 
 * @author : Banujan Atputharajah and Maxym Bonnette
 * @version : 1.0
 */
public class WordDefinitionComparator implements Comparator<WordDefinition> {

    /**
     * @inheritDoc
     */
    @Override
    public int compare(WordDefinition o1, WordDefinition o2) {
       return o1.getWord().compareTo(o2.getWord());
    }
}
