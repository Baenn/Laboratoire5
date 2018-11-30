package Labo5;

import java.util.List;
import java.util.Vector;

public class LMotDefinition  implements IMotDefinition{

    private List<MotDefinition> listMotDictio;

    public LMotDefinition(){
        setListMotDictio(new Vector<MotDefinition>());
    }


    public void setListMotDictio(List<MotDefinition> listMotDictio) {
        this.listMotDictio = listMotDictio;
    }

    @Override
    public boolean addMotDefinition(MotDefinition m) {
        return false;
    }

    @Override
    public boolean removeMotDefinition(MotDefinition m) {
        return false;
    }

    @Override
    public List<MotDefinition> getMot(String m) {
        return null;
    }

    @Override
    public List<MotDefinition> getAllMotDefinition() {
        return null;
    }

}
