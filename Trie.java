import java.util.*;
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
        TrieNode curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            // init node for this char
            Character currChar = word.charAt(i);
            if (!curr.children.containsKey(word.charAt(i))) {
                curr.children.put(currChar, new TrieNode(currChar));
            }
            curr = curr.children.get(currChar);
        }
        curr.isEndOfWord = true;
    }

    public boolean doesWordExist(String word) {
       
        TrieNode curr = this.root;

        for (int i = 0; i < word.length(); i++) {
            // 
            if (!curr.children.containsKey(word.charAt(i))) return false;
            curr = curr.children.get(word.charAt(i));
        }

        return curr.isEndOfWord;
    }

    /**
     * remove word from trie
     * @param word word to remove
     * @return  return true if exist, return false if not
     */
    public boolean removeWord(String word) {
       TrieNode curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            // init node for this char
            Character currChar = word.charAt(i);
            if (!curr.children.containsKey(word.charAt(i))) return false;
            // move pointer
            curr = curr.children.get(currChar);
        }
        curr.isEndOfWord = false;
        return curr.isEndOfWord;
    }
   

    
    /**
     * get list of words that start with prefix
     * @param prefix
     * @return
     */
    public List<String> findWordsWithPrefix(String prefix) {
        List<String> result = new ArrayList<>();
        TrieNode curr = root;
        for (Character c: prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return result;
            }
            curr = curr.children.get(c);
        }

        findAllWordsPrefix(prefix, curr, result, new ArrayList<Character>());

        return result;
    }

    private void findAllWordsPrefix(String prefix, TrieNode curr, List<String> currList, List<Character> path) {

        if (curr == null) {
            return;
        }


        if (curr.isEndOfWord) {
            String res = prefix;
            for (Character c : path) {
                res += String.valueOf(c);
            }
            currList.add(res);
        }

        for (Character c : curr.children.keySet()) {
            path.add(c);
            findAllWordsPrefix(prefix, curr.children.get(c), currList, path);
            path.remove(path.size()-1);
        }
    }
    
    /**
     * counts the number of words that start with this prefix
     * @param prefix  prefix in question
     * @return count
     */
    public int countWordsWithPrefix(String prefix) {
        return findWordsWithPrefix(prefix).size();
    }

    public void printWordsWithPrefix(String prefix){
        List<String> allWords = findWordsWithPrefix(prefix);
        for(String word : allWords){
            System.out.println(word);
        }
    }

    public void printAllWords(){
        List<String> words = findAllWords(new ArrayList<String>(), root, new ArrayList<Character>());
        for(String s : words){
            System.out.println(s);
        }

    }

    public int size(){
        List<String> words = findAllWords(new ArrayList<String>(), root, new ArrayList<Character>());
        return words.size();
    }

    private List<String> findAllWords(List<String> result, TrieNode root, List<Character> path){
        if(root == null){
            return null;
        }
        if(root.isEndOfWord == true){
            String strRes = "";
            for(int i = 0; i < path.size(); i++){
                strRes += String.valueOf(path.get(i));
            }
            result.add(strRes);
        }
        for(Character c : root.children.keySet()){
            path.add(c);
            findAllWords(result, root.children.get(c), path);
            path.remove(c);
        }
        return result;
    }

    private class TrieNode {
        Character key;
        HashMap<Character,TrieNode> children;
        boolean isEndOfWord;

        
        TrieNode(Character key) {
            this.key = key;
            this.children = new HashMap<>();
            isEndOfWord = false;
        }
        TrieNode(){
            this(null);
        }
    }
}

