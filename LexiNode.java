package Laboratoire5;

import java.util.LinkedList;

public class LexiNode {

    private Character data;
    private LexiNode parent;
    private LinkedList<LexiNode> children;

    public LexiNode(LexiNode parent, Character data){
        setParent(parent);
        setData(data);
    }

    public boolean addChildren(LexiNode children){
        return this.children.add(children);
    }

    public LinkedList<LexiNode> getChildren(){
        return children;
    }
    @Override
    public String toString(){
        if(parent != null)
            return parent.toString()+getData();
        return data.toString();
    }
    public Character getData() {
        return data;
    }

    public LexiNode getParent() {
        return parent;
    }

    public void setData(Character data) {
        this.data = data;
    }

    public void setParent(LexiNode parent) {
        this.parent = parent;
    }
}
