/**
 * Test code for the Trie data structure
 * @author  Akbarali Sodikov
 * @author  Lucas Almedia
 * @author  Lucas Liang
 * @author  Milton Rue  
 */

public class TrieTest {
    public static void main(String[] args){
        Trie t = new Trie();
        t.insert("hello");
        System.out.println(t.doesWordExist("hello"));
        t.insert("hi");
        System.out.println(t.countWordsWithPrefix("h"));
        t.removeWord("hi");
        System.out.println(t.doesWordExist("hi"));
        System.out.println(t.doesWordExist("hello"));
        System.out.println(t.countWordsWithPrefix("h"));
        t.printAllWords();
        t.insert("bye");
        t.insert("yo");
        t.insert("milt");
        t.insert("akbar");
        t.insert("lucas");
        t.printAllWords();
        System.out.println(t.size());

    }
}
