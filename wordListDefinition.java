package Laboratoire5;

import java.util.List;
import java.util.Vector;

public class wordListDefinition  implements InterfaceWordDefinition{

    private List<WordDefinition> wordListDictio;
    private int positionCharWord;
    private String researchWord;

    public wordListDefinition(){
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
    public List<WordDefinition> getAllWordsDefinition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
