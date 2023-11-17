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
import java.util.*;

public class TrieTest {
    public static void main(String[] args) {
        testBasic();
        checkDuplicate();
        testFile1();
        testFile2();
        
    }
    /**
     * Tests basic insert and remove for small number of elements
     */
    private static void testBasic(){
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
        System.out.println("------------------------------------------------------------ \n");

    }

    /**
     * Checks to ensure that duplicates are not being added to tree as separate entities.
     */

    private static void checkDuplicate(){
        Trie t = new Trie();
        t.insert("hello");
        t.insert("hello");
        System.out.println("The size of the trie is: " + t.size());
        System.out.println('\n');
        System.out.println("Printing all words in the trie!");
        t.printAllWords();
        System.out.println("------------------------------------------------------------ \n");
    } 

    /**
     * Tests insert using 1,000 unique word text file, checks to see
     * if contents of the file are the same as the Trie.
     */

    private static void testFile1(){
        ArrayList<String> allWords = new ArrayList<>();
        Trie t = new Trie();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("uniqueWords.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                t.insert(line);
                allWords.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total words in the file: 1000\n");
        System.out.println("Total words in the Trie after adding words from the file: " + t.size());
        Collections.sort(allWords);
        List<String> trieWords = t.findWordsWithPrefix("");
        Collections.sort(trieWords);
        boolean flag = false;
        for(int i = 0; i < allWords.size(); i++){
            if(!allWords.get(i).equals(trieWords.get(i))){
                flag = true;
            }
        }
        if(flag){
            System.out.println("ARRAYS DO NOT MATCH");
        }
        else{
            System.out.println("ARRAYS DO MATCH");
        }

        System.out.println("------------------------------------------------------------ \n");
    }

    /**
     * Tests methods on 84,099 size text file.
     */

    private static void testFile2(){
        Trie t = new Trie();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("engmix.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                t.insert(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total words in the file: 84099\n");
        System.out.println("Total words in the Trie after adding words from the file: " + t.size());
        List<String> words = t.findWordsWithPrefix("zy");
        String wordsZY = "zygote, zygotes, zygotic, zymology, zymurgy";
        System.out.println("Words that start with zy are: " + wordsZY + "\n");
        System.out.println("The Trie found the following words start with zy: ");
        for(String s : words){
            System.out.println(s);
        }
        t.removeWord("zygote");
        System.out.println("Was zygote removed: " + !(t.doesWordExist("zygote")) + "\n");
        List<String> words2 = t.findWordsWithPrefix("zy");
        System.out.println("Printing words that start with zy! \n");
        for(String s : words2){
            System.out.println(s);
        }

        

        System.out.println("------------------------------------------------------------ \n");
    }

    }

