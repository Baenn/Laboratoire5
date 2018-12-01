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
//        System.out.println("Hello world!");
//
//        // test all words list
//        ArrayList<WordDefinition> allWordsList = new ArrayList<>();
//        WordDefinition def1 = new WordDefinition("hello", "Hello ta mer");
//        WordDefinition def2 = new WordDefinition("bye", "bye mer");
//        allWordsList.add(def1);
//        allWordsList.add(def2);
//
//        // show UI
//        UI ui = new UI(allWordsList);
//        ui.show();
        LexiNode L1 = new LexiNode(null, 'a');
        LexiNode L2 = new LexiNode(L1,'l');
        LexiNode L3 = new LexiNode(L2,'l');
        LexiNode L4 = new LexiNode(L3, 'o');

        //System.out.println(L1);
        System.out.println(L4);
    }
}
