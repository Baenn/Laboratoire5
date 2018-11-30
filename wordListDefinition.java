package Laboratoire5;

import java.util.List;
import java.util.Vector;

public class wordListDefinition  implements InterfaceWordDefinition{

    private List<WordDefinition> wordListDictio;

    public wordListDefinition(){
        setWordListDictio(new Vector<WordDefinition>());
    }


    public void setWordListDictio(List<WordDefinition> wordListDictio) {
        this.wordListDictio = wordListDictio;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<WordDefinition> getAllWordsDefinition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
