/*
 * This class is used to read and write a dictionary file.
 */
package Laboratoire5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Banujan
 */
public final class DictioFileOperations 
{
    /**
     * Method used to load a list of word and its corresponding definition into
     * the object's wordListDictio attribute
     * @param filename The name of the dictionary file
     * @return 
     */
    public static ArrayList<LexiNode> loadListFromFile(String filename)
    {
        // load definitions from txt file
        File file = new File(filename);
        
        try 
        {
            // create array to contain list of trees
            ArrayList<LexiNode> lexiNodeList = new ArrayList<>();
            
            // read the file
            BufferedReader reader = new BufferedReader(new FileReader(file));
            ArrayList<WordDefinition> list = new ArrayList<>(); 
            String line; // this variable will contain each line of the file
            
            while( (line = reader.readLine()) != null)
            {
                String wordDefinition = line;
                String wordDefinitionParts[] = wordDefinition.split("\\&");
                
                // text before & is word and after & is definition
                String word = wordDefinitionParts[0].trim();
                String definition = wordDefinitionParts[1].trim();
                
                // add to LexiNode tree (each tree for each letter in the alphabet)
                char firstLetterOfWord = word.toUpperCase().charAt(0);
                
                int index = -1;
                for(int i = 0 ; i < lexiNodeList.size() ; i++)
                {
                    // find the index of the root tree
                    if(lexiNodeList.get(i).getCurrentCharacter() == firstLetterOfWord)
                    {
                        index = i;
                        i = lexiNodeList.size(); // escape the loop
                    }
                }

                // if index not found (the word starts with a different 
                // letter), we create a new tree.
                if(index == -1)
                {
                    lexiNodeList.add(new LexiNode(firstLetterOfWord));
                    index = lexiNodeList.size() - 1;
                }
                
                lexiNodeList.get(index).addWord( new WordDefinition(word, definition) );
            }
            
            reader.close();
            return lexiNodeList;
        } 
        
        catch (Exception e) 
        {
            System.out.println("Could not load dictionnary file.");
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Method used to save the word list (Represented by the wordListDictio 
     * attribute) to a file. Each line in the file will have the following 
     * format: word & definition
     * @param filename The name of the file to save
     * @return True if the operation is successful, false otherwise.
     */
    public static boolean saveListToFile(String filename, List<WordDefinition> wordListDictio)
    {
        File file = new File(filename);
        
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            
            // write each line in the following format: word & definition
            for(WordDefinition wordDef : wordListDictio)
            {
                String line = wordDef.getWord() + " & " + wordDef.getDefinition() + "\n";
                writer.write(line);
            }
            
            writer.close();
            return true;
        }
        
        catch(Exception e)
        {
            System.out.println("Could not save to file");
            e.printStackTrace();
            return false;
        }
    }
}
