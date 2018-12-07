package Laboratoire5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
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
    public boolean loadListFromFile(String filename)
    {
        // load definitions from txt file
        // example filename: "src/Laboratoire5/Dictio.txt";
        File file = new File(filename);
        
        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            List<WordDefinition> list = new ArrayList<>(); 
            String line; // this variable will contain each line of the file
            
            while( (line = reader.readLine()) != null)
            {
                String wordDefinition = line;
                String wordDefinitionParts[] = wordDefinition.split("\\&");
                
                // text before & is word and after & is definition
                String word = wordDefinitionParts[0].trim();
                String definition = wordDefinitionParts[1].trim();
                
                // add the word and definition to the list
                list.add(new WordDefinition(word, definition));
                setWordListDictio(list);
            }
            
            reader.close();
            return true;
        } 
        
        catch (Exception e) 
        {
            System.out.println("Could not load dictionnary file.");
            e.printStackTrace();
            return false;
        }
    }
    
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
     * @param m The WordDefinition object containing the word to add/modify
     * @return True if the operation is successful.
     */
    @Override
    public boolean addWordDefinition(WordDefinition m) 
    {    
        try
        {
            // first, find the list 
            boolean wordFound = false;
            for(int i = 0 ; i < wordListDictio.size() ; i++)
            {
                if(wordListDictio.get(i).getWord().equals(m.getWord()))
                {
                    wordListDictio.get(i).setDefinition(m.getDefinition());

                    wordFound = true;
                    i = wordListDictio.size();
                }
            }

            // if word not found, we have to add it to the list
            if(!wordFound) // TODO must sort the list in alphabetical order
                wordListDictio.add(m);

            return true;
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeWordDefinition(WordDefinition m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<WordDefinition> getWord(String m) {
        positionCharWord = 0;
        researchWord = m;
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
