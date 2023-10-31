/**
 * Test code for the Trie data structure
 * @author  Akbarali Sodikov
 * @author  Lucas Almedia
 * @author  Lucas Liang
 * @author  Milton Rue  
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TrieTest {
    public static void main(String[] args) {
        Trie t = new Trie();

        t.insert("hello");
        t.insert("hi");
        t.insert("bye");
        t.insert("yo");
        t.insert("milt");
        t.insert("akbar");
        t.insert("lucas");

   
        System.out.println("Does 'hello' exist: " + t.doesWordExist("hello"));
        System.out.println("Does 'hi' exist: " + t.doesWordExist("hi"));
        System.out.println("Count of words starting with 'h': " + t.countWordsWithPrefix("h"));
        t.removeWord("hi");
        System.out.println("Does 'hi' exist after removal: " + t.doesWordExist("hi"));
        System.out.println("Count of words starting with 'h' after removal: " + t.countWordsWithPrefix("h"));
        
        
        System.out.println("All words in the Trie:");
        t.printAllWords();

        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("uniqueWords.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                t.insert(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        System.out.println("Total words in the Trie after adding words from the file: " + t.size());
    }
}

