package Laboratoire5;

import java.util.ArrayList;

/**
 * This class represents the data structure of the application.
 * It represents a node in the tree structure.
 * Responsibilities : 
 *          - Search a word letter by letter
 *          - Add a word to the tree (create a node for every letter of the word)
 *          - Modify an existing word in tree structure
 *          - Get a list of all words in the tree
 * Collaborators :
 *          - WordDefinition
 * @author : Banujan Atputharajah and Maxym Bonnette
 * @version : 1.0
 */
public class LexiNode
{
    // data members
    private char currentCharacter; // the current letter represented by the node
    private WordDefinition wordDefinition; // represents a word from root to crrent letter
    private ArrayList<LexiNode> childNodes; // to store child of the current node
    
    // constructor
    /**
     * Default constructor for the class.
     * @ requires character The character to be stored in this node
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
     * @ requires   word != null && word.isEmpty() == false
     *              returnFirstResultOnly == true || returnFirstResultOnly == false
     * @param word The word to be search
     * @param returnFirstResultOnly If set to true, the method will return the 
     * first result found. This is to improve the speed of the search in case the
     * tree is long.
     * @return An array list containing the result of the search query.
     */
    public ArrayList<WordDefinition> searchWord(String word, boolean returnFirstResultOnly)
    {
        return searchWordRecursion(this, word.toLowerCase(), 1, new ArrayList<WordDefinition>(), returnFirstResultOnly);
    }
    
    /**
     * Method to add a word to the tree letter by letter
     * @ requires wordDef != null
     * @param wordDef An object containing a word and a definition
     * @return True if the word was added to the tree, false if the word already
     * exist in the tree or if the wordDefinition provided is invalid
     */
    public boolean addWord(WordDefinition wordDef)
    {
        if(wordDef == null)
            return false;
        
        // get word
        String wordToAdd = wordDef.getWord();
        
        // reformat word (first letter capital, rest lowercase)
        wordToAdd = wordToAdd.toUpperCase().charAt(0) + wordToAdd.substring(1).toLowerCase();
        wordDef.setWord(wordToAdd);
        
        // search for the word in the tree to make sure it doesn't exist
        ArrayList<WordDefinition> query = this.searchWord(wordToAdd, true);
        
        if(query.size() > 0 && query.get(0).getWord().equals(wordToAdd))
            return false;
        
        else // if word doesn't exist, we can add it
        {
            // call recursive method to get the last node inserted
            LexiNode node = this.addWordRecursion(this, wordToAdd, 1);
            node.setWordDefinition(wordDef);

            return true;
        }
    }
    
    /**
     * Method used to modify the definition of a word. If the word is not found
     * in the list, the addWord function will be called to add the word to 
     * the list.
     * @ requires wordDef != null
     * @param wordDef The WordDefinition object representing the word to modify
     * @return True if the word was modified/added, false if the operation was
     * unsuccessful
     */
    public boolean modifyWord(WordDefinition wordDef)
    {
        if(wordDef == null)
            return false;
        
        String wordToModify = wordDef.getWord();
        String definition = wordDef.getDefinition();
        
        // query the word in the tree
        ArrayList<WordDefinition> query = this.searchWord(wordToModify.toLowerCase(), true);
        
        if(query.size() == 0) // if query returned no result, we add the word
            return this.addWord(wordDef);
        
        // the word should be the first element in the list
        else if( query.get(0).getWord().equals(wordToModify) )
        {
            query.get(0).setDefinition(definition);
            return true;
        }
        
        else
        {
            System.out.println(wordToModify + " : " + query.get(0).getWord());
            return false;
        }
    }
    
    /**
     * Method to get all words in the tree
     * @return An array list object containing all the words in the tree
     */
    public ArrayList<WordDefinition> getAllWordsFromTree()
    {
        return getAllWordsFromTreeRecursion(this, new ArrayList<WordDefinition>());
    }
    
    // private methods
    /**
     * Recursive method used by the searchWord method to search along the tree 
     * for a word.
     * Recursion complexity : log(n)
     * @param parentNode The starting node to check. FIrst value should be the 
     * root node of the tree
     * @param word The word to search for
     * @param index The index position of the letter in the word. Should start
     * with 1 because we assume the root node created with the first letter
     * @param wordsFoundList A list that will contain the results of the query
     * @param returnFirstResultOnly If set to true, search will stop after 1 
     * result found
     * @return The wordsFoundList array list will be returned with the result of
     * the search query.
     */
    private ArrayList<WordDefinition> searchWordRecursion(LexiNode parentNode, String word, int index, ArrayList<WordDefinition> wordsFoundList, boolean returnFirstResultOnly)
    {
        // if we've looked trough all letters of the word, we continue the search
        // along the tree to find other words
        if(index >= word.length())
        {
            if(parentNode.getWordDefinition() != null)
                wordsFoundList.add(parentNode.getWordDefinition());
            
            if(returnFirstResultOnly)
                return wordsFoundList;
            
            for(int i = 0 ; i < parentNode.childNodes.size() ; i++)
            {
                LexiNode childNode = parentNode.childNodes.get(i);

                // search for words children of the children node
                searchWordRecursion(childNode, word, index, wordsFoundList, returnFirstResultOnly);
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
            return searchWordRecursion(childNode, word, index+1, wordsFoundList, returnFirstResultOnly);
        
        // if node wasn't found, we stop search
        else
            return wordsFoundList;
    }
    
    /**
     * Recursive method used by the addWord method  to add a node for every 
     * letter in the word in the true
     * Recursion complexity : log(n)
     * @param parentNode The starting node to check. FIrst value should be the root node of the tree
     * @param word The word to be added in the tree
     * @param index The index position of the letter in the word. Should start
     * with 1 because we assume the root node created with the first letter
     * @return The last node in the tree (which contains the last letter of the 
     * word)
     */
    private LexiNode addWordRecursion(LexiNode parentNode, String word, int index)
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
            return addWordRecursion(childNode, word, index+1);
        
        // if node wasn't found, we create it using the letter
        else
        {
            childNode = new LexiNode( word.charAt(index) );
            parentNode.childNodes.add( childNode );
            return addWordRecursion(childNode, word, index+1);
        }
    }
    
    /**
     * Recursive method used by the getAllWordsFromTree function to fetch all 
     * words in the tree
     * Recursion complexity : O(n) + log(n)
     * @param parentNode The starting node to check. FIrst value should be the 
     * root node of the tree
     * @param list The array list object that will contain the search query
     * @return An array list object containing the query result
     */
    private ArrayList<WordDefinition> getAllWordsFromTreeRecursion(LexiNode parentNode, ArrayList<WordDefinition> list)
    {
        for(int i = 0 ; i < parentNode.childNodes.size() ; i++)
        {
            LexiNode childNode = parentNode.childNodes.get(i);
            
            if(childNode.getWordDefinition() != null)
                list.add(childNode.getWordDefinition());
            
            getAllWordsFromTreeRecursion(childNode, list);
        }
        
        return list;
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