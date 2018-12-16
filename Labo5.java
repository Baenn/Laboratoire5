/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboratoire5;

import java.util.ArrayList;

/**
 *
 * @author AP85250
 */
public class Labo5 
{
    public static void main(String args[])
    {
        // show UI
        /*UI ui = new UI();
        ui.setVisible(true);*/
        
        LexiNode bTree = new LexiNode('B');
        String word, def;
        WordDefinition wordDef;
        
        word = "Banc";
        def = "Pour assir";
        wordDef = new WordDefinition(word, def);
        bTree.addWordToTree(wordDef);
        
        word = "Banane";
        def = "Pour manger";
        wordDef = new WordDefinition(word, def);
        bTree.addWordToTree(wordDef);
        
        word = "Banque";
        def = "Pour manger";
        wordDef = new WordDefinition(word, def);
        bTree.addWordToTree(wordDef);
        
        word = "Banquette";
        def = "Pour manger";
        wordDef = new WordDefinition(word, def);
        bTree.addWordToTree(wordDef);
        
        ArrayList<WordDefinition> list = bTree.searchWord("Banqu");
        System.out.println(list.size());
        for(int i = 0 ; i < list.size() ; i++)
        {
            System.out.println(list.get(i).getWord());
        }
        
        
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
