package Laboratoire5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordListDefinition  implements WordDefinitionInterface
{
    private List<WordDefinition> wordListDictio;
    private int positionCharWord;
    private String researchWord;

    public WordListDefinition(){
        setWordListDictio(new Vector<WordDefinition>());
    }


    public void setWordListDictio(List<WordDefinition> wordListDictio) {
        this.wordListDictio = wordListDictio;
    }

    private List<WordDefinition> searchWord(char c, List<WordDefinition> remaningWord){
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
    @Override
    public boolean addWordDefinition(WordDefinition m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public List<WordDefinition> getAllWordsDefinition() 
    {
        // load definitions from txt file
        String pathname = "src/Laboratoire5/Dictio.txt";
        File file = new File(pathname);
        
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
            }
            
            reader.close();
            return list;
        } 
        
        catch (Exception e) 
        {
            System.out.println("Could not load dictionnary file.");
            e.printStackTrace();
            return null;
        }
    }

}