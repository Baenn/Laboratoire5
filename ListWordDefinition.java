package Laboratoire5;

import java.util.List;
import java.util.Vector;

public class ListWordDefinition  implements InterfaceWordDefinition{

    private List<WordDefinition> listMotDictio;

    public ListWordDefinition(){
        setListMotDictio(new Vector<WordDefinition>());
    }


    public void setListMotDictio(List<WordDefinition> listMotDictio) {
        this.listMotDictio = listMotDictio;
    }

    @Override
    public boolean addMotDefinition(WordDefinition m) {
        return false;
    }

    @Override
    public boolean removeMotDefinition(WordDefinition m) {
        return false;
    }

    @Override
    public List<WordDefinition> getMot(String m) {
        return null;
    }

    @Override
    public List<WordDefinition> getAllMotDefinition() {
        return null;
    }

}
