/**
 * Implements a Trie data structure
 * @author  Akbarali Sodikov
 * @author  Lucas Almedia
 * @author  Lucas Liang
 * @author  Milton Rue  
 */

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        
    }

    public boolean search(String word) {
       
    }

    public boolean startsWith(String prefix) {
        
    }

    
    // Finding words with a certain prefix 
    public ArrayList<String> findWordsWithPrefix(String prefix) {
        List<String> result = new ArrayList<>();
        TrieNode node = root;
        for (char c: prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return result; 
            }
            node = node.children.get(c);
        }

        findAllWordsFromNode(node, prefix, result);
        return result;
    }
    
    // Counting words with a certain prefix
    public int countWordsWithPrefix(String prefix) {
        TrieNode node = root;
        for (char c: prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return 0; 
            }
            node = node.children.get(c);
        }
        return countWordsFromNode(node);
    }
    
    private TrieNode searchPrefix(String prefix) {
        
    }

    private class TrieNode {
        
    }
}

