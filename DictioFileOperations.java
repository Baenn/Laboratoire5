package Laboratoire5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to read and write a dictionary file.
 * Responsibilities : 
 *          - Load a dictionary file
 *          - Save a list of words and their definitions to a file
 * Collaborators :
 *          - LexiNode
 *          - WordDefinition
 * @author : Banujan Atputharajah and Maxym Bonnette
 * @version : 1.0
 */
public final class DictioFileOperations 
{
    /**
     * Method used to load a list of word and its corresponding definition into
     * the object's wordListDictio attribute
     * @ requires filename != null && filename.isEmpty() == false
     * @param filename The name of the dictionary file
     * @return An array list of LexiNode objects. Each element in the array list
     *  corresponds to a tree structure (one for each letter in the alphabet)
     */
    public static ArrayList<LexiNode> loadListFromFile(String filename)
    {
        try 
        {
            // load definitions from txt file
            File file = new File(filename);
            
            // create array to contain list of trees
            ArrayList<LexiNode> lexiNodeList = new ArrayList<>();
            
            // read the file
            /*
                CODE EMPREUNTÉ:
                La ligne suivante est basé du site suivant:
                https://stackoverflow.com/questions/9281629/read-special-characters-in-java-with-bufferedreader
                (consulté le 17 décembre 2018)
            
                Ce code permet de résoudre un problème que nous avions conceranant
                la lecture des charactères spéciaux (é,è,à,etc.) dans un fichier.
            */
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"));
            /* FIN DU CODE EMPRUNTÉ */
            
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
     * * @ requires   filename != null && fliename.isEmpty() == false
     *              wordListDictio != null
     * @param filename The name of the file to save
     * @param wordListDictio The array list of WordDefinition objects containing
     * all words from all trees with their definition.
     * @return True if the operation is successful, false otherwise.
     */
    public static boolean saveListToFile(String filename, ArrayList<WordDefinition> wordListDictio)
    {
        try
        {
            File file = new File(filename);
            /*
                CODE EMPREUNTÉ:
                La ligne suivante est basé du site suivant:
                https://stackoverflow.com/questions/9281629/read-special-characters-in-java-with-bufferedreader
                (consulté le 17 décembre 2018)
            
                Ce code permet de résoudre un problème que nous avions conceranant
                l'écriture des charactères spéciaux (é,è,à,etc.) dans un fichier.
            */
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "ISO-8859-1"));
            /* FIN DU CODE EMPRUNTÉ */
            
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
