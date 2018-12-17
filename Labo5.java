package Laboratoire5;

import java.util.ArrayList;

/**
 * This class contains the main methods
 * Responsibilities : 
 *          - Show the UI
 * Collaborators :
 *          - UI
 * @author : Banujan Atputharajah and Maxym Bonnette
 * @version : 1.0
 */
public class Labo5 
{
    /**
     * Main method of the application
     * @param args The command line arguments (not needed for this application)
     */
    public static void main(String args[])
    {
        // show UI
        UI ui = new UI();
        ui.setVisible(true);
        
        /*
        // Lexi node test
        LexiNode bTree = new LexiNode('B');
        String word, def;
        WordDefinition wordDef;
        
        word = "Banc";
        def = "Pour assir";
        wordDef = new WordDefinition(word, def);
        bTree.addWord(wordDef);
        
        word = "Banane";
        def = "Pour manger";
        wordDef = new WordDefinition(word, def);
        bTree.addWord(wordDef);
        
        word = "Banque";
        def = "$$";
        wordDef = new WordDefinition(word, def);
        bTree.addWord(wordDef);
        
        wordDef.setDefinition("Pour l'argent");
        bTree.modifyWord(wordDef);
        
        word = "Banquette";
        def = "Pour les ours polaires";
        wordDef = new WordDefinition(word, def);
        bTree.addWord(wordDef);
        
        ArrayList<WordDefinition> list = bTree.searchWord("Banqu", false);
        for(int i = 0 ; i < list.size() ; i++)
        {
            System.out.println(list.get(i).getWord() + " : " + list.get(i).getDefinition());
        }*/
        
        
        /*
        LexiNode L1 = new LexiNode(null, 'a',false);
        LexiNode L2 = new LexiNode(L1,'l',false);
        LexiNode L3 = new LexiNode(L2,'l',true);
        LexiNode L4 = new LexiNode(L3, 'o',true);



        LexiNode L5 = new LexiNode(L3,'i',false);
        LexiNode L6 = new LexiNode(L5,'e',true);
        LexiNode L7 = new LexiNode(L6,'r',true);

        LexiNode L8 = new LexiNode(L1,'v',false);
        LexiNode L9 = new LexiNode(L8, 'o',false);
        LexiNode L10 = new LexiNode(L9,'i',false);
        LexiNode L11 = new LexiNode(L10, 'r',true);

        //System.out.println(L1);
        System.out.println(L2.getWordPossibility());*/
    }
}
