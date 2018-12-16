package Laboratoire5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class LexiNode
{
    // data members
    private char currentCharacter; // the current letter represented by the node
    private WordDefinition wordDefinition; // represents a word from root to crrent letter
    private ArrayList<LexiNode> childNodes; // to store child of the current node
    
    // constructor
    /**
     * Default constructor for the class.
     * @param character The character for the current node
     */
    public LexiNode(char character)
    {
        this.currentCharacter = character;
        this.wordDefinition = null;
        this.childNodes = new ArrayList<>();
    }
    
    // inatance methods
    /**
     * Method used to search for a word
     * @param word The word to be search
     * @return An array list containing the result of the search query.
     */
    public ArrayList<WordDefinition> searchWord(String word)
    {
        return searchWordRecursive(this, word, 1, new ArrayList<WordDefinition>());
    }
    
    /**
     * Method to add a word to the tree letter by letter
     * @param wordDefinition An object containing a word and a definition
     * @return True if the word was added to the tree
     */
    public boolean addWordToTree(WordDefinition wordDefinition)
    {
        // get word
        String word = wordDefinition.getWord();
        
        // call recursive method to get the last node inserted
        LexiNode node = this.addWordToTreeRecursion(this, word, 1);
        node.setWordDefinition(wordDefinition);
        
        return true;
    }
    
    // private methods
    /**
     * 
     * @param parentNode
     * @param word
     * @param index
     * @param wordsFoundList
     * @return 
     */
    private ArrayList<WordDefinition> searchWordRecursive(LexiNode parentNode, String word, int index, ArrayList<WordDefinition> wordsFoundList)
    {
        // if we've looked trough all letters of the word, we continue the search
        // along the tree to find other words
        if(index >= word.length())
        {
            if(parentNode.getWordDefinition() != null)
                wordsFoundList.add(parentNode.getWordDefinition());
            
            for(int i = 0 ; i < parentNode.childNodes.size() ; i++)
            {
                LexiNode childNode = parentNode.childNodes.get(i);

                // search for words children of the children node
                searchWordRecursive(childNode, word, index, wordsFoundList);
            }
            
            return wordsFoundList;
        }
        
        // check if the parentNode has already a child with the letter
        LexiNode childNode = null;
        
        for(int i = 0 ; i < parentNode.childNodes.size() ; i++)
        {
            LexiNode nodeToCheck = parentNode.childNodes.get(i);
            
            if(nodeToCheck.currentCharacter == word.charAt(index))
            {
                childNode = nodeToCheck;
                i = parentNode.childNodes.size(); // escape the loop
            }
        }
        
        // if node was found, we proceed to next letter
        if(childNode != null)
            return searchWordRecursive(childNode, word, index+1, wordsFoundList);
        
        // if node wasn't found, we stop search
        else
            return wordsFoundList;
    }
    
    /**
     * Recursive method to add a node for every letter in the word in the true
     * @param parentNode The starting node to check. FIrst value should be the root node of the tree
     * @param word The word to be added in the tree
     * @param index The index position of the letter in the word. Should start
     * with 1 because we assume the root node created with the first letter
     * @return The last node in the tree (which contains the last letter of the 
     * word)
     */
    private LexiNode addWordToTreeRecursion(LexiNode parentNode, String word, int index)
    {
        // if we've added all letters to the tree
        if(index == word.length())
            return parentNode;
        
        // check if the parentNode has already a child with the letter to add
        LexiNode childNode = null;
        
        for(int i = 0 ; i < parentNode.childNodes.size() ; i++)
        {
            LexiNode nodeToCheck = parentNode.childNodes.get(i);
            
            if(nodeToCheck.currentCharacter == word.charAt(index))
            {
                childNode = nodeToCheck;
                i = parentNode.childNodes.size(); // escape the loop
            }
        }
        
        // if node was found, we proceed ot next letter
        if(childNode != null)
            return addWordToTreeRecursion(childNode, word, index+1);
        
        // if node wasn't found, we create it using the letter
        else
        {
            childNode = new LexiNode( word.charAt(index) );
            parentNode.childNodes.add( childNode );
            return addWordToTreeRecursion(childNode, word, index+1);
        }
    }
    
    // accessor methods
    public char getCurrentCharacter() {
        return currentCharacter;
    }

    public WordDefinition getWordDefinition() {
        return wordDefinition;
    }

    public ArrayList<LexiNode> getChildNodes() {
        return childNodes;
    }
    
    // mutator methods
    public void setWordDefinition(WordDefinition wordDefinition) {
        this.wordDefinition = wordDefinition;
    }
}

/*
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
*/