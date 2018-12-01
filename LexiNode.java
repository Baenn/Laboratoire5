package Laboratoire5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LexiNode {

    private Character data;
    private LexiNode parent;
    private LinkedList<LexiNode> listChildren;
    private List<String> wordPossibility;
    private boolean flag;

    public LexiNode(LexiNode parent, Character data, boolean flag){
        setParent(parent);
        setData(data);
        if(getParent() != null){
            getParent().addChildren(this);
        }
        this.flag = flag;
        listChildren = new LinkedList<LexiNode>();
        wordPossibility = new ArrayList<String>();

    }


    private void fillWordPossibility(List<String> allWord){
        if(flag)
            allWord.add(this.toString());
        for(LexiNode n : this.getChildren()){
            n.fillWordPossibility(allWord);
        }
    }


    @Override
    public String toString(){
        if(parent != null)
            return parent.toString()+getData();
        return getData().toString();
    }

    public LinkedList<LexiNode> getChildren(){
        return listChildren;
    }
    public Character getData() {
        return data;
    }

    public LexiNode getParent() {
        return parent;
    }

    public List<String> getWordPossibility() {
        fillWordPossibility(wordPossibility);
        return wordPossibility;
    }

    public boolean addChildren(LexiNode children){
        return getChildren().add(children);
    }

    public void setData(Character data) {
        this.data = data;
    }

    public void setParent(LexiNode parent) {
        this.parent = parent;
    }
}
