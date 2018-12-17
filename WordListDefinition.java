package Laboratoire5;

import java.util.List;
import java.util.Vector;

public class WordListDefinition  implements WordDefinitionInterface
{
    private List<WordDefinition> wordListDictio;
    private int positionCharWord;
    private String researchWord;

    public WordListDefinition()
    {
        setWordListDictio(new Vector<WordDefinition>());
    }

    // instance methods 
    public List<WordDefinition> searchWord(char c, List<WordDefinition> remaningWord)
    {
        List<WordDefinition> listToSearch = new Vector<WordDefinition>();
        listToSearch = remaningWord;
        for(WordDefinition word : listToSearch){
            if(word.getWord().length() - 1 <= positionCharWord){
                if (word.getWord().charAt(positionCharWord) != c)
                    remaningWord.remove(word);
            }else{
                remaningWord.remove(word);
            }
        }
        if(researchWord.length() - 1 > positionCharWord) {
            positionCharWord++;
            searchWord(researchWord.charAt(positionCharWord), listToSearch);
        }
        return listToSearch;
    }
    
    /**
     * This method will either add a new word to the list (if the word wasn't 
     * found) or modify its definition (if the word was found).
     * TODO: Rename the method or split it since it does 2 things?
     * @param inputWord The WordDefinition object containing the word to add/modify
     * @return True if the operation is successful, false otherwise
     */
    @Override
    public boolean addWordDefinition(WordDefinition inputWord) 
    {    
        try
        {
            // first, try to find the word in the list 
            boolean wordFound = false;
            for(int i = 0 ; i < wordListDictio.size() ; i++)
            {
                // if word is found, we update its definitino
                if(wordListDictio.get(i).getWord().equals(inputWord.getWord()))
                {
                    wordListDictio.get(i).setDefinition(inputWord.getDefinition());

                    wordFound = true;
                    i = wordListDictio.size(); // escape the loop
                }
            }

            // if word not found, we have to add it to the list
            if(!wordFound) // TODO must sort the list in alphabetical order
                wordListDictio.add(inputWord);

            return true;
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeWordDefinition(WordDefinition wordToRemove) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<WordDefinition> getWord(String word) {
        positionCharWord = 0;
        researchWord = word;
        return searchWord(researchWord.charAt(positionCharWord),wordListDictio);
    }

    // accessor methods
    @Override
    public List<WordDefinition> getAllWordsDefinition() 
    {
        return this.wordListDictio;
    }
    
    // mutator methods
    public void setWordListDictio(List<WordDefinition> wordListDictio) {
        this.wordListDictio = wordListDictio;
    }
}
