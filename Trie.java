import java.util.*;

/**
 * Implements a Trie data structure otherwise known as a prefix tree
 * 
 * @author Akbarali Sodikov
 * @author Lucas Almedia
 * @author Lucas Liang
 * @author Milton Rue
 */

public class Trie {
	private TrieNode root;
	private int size;

	public Trie() {
		root = new TrieNode();
		size = 0;
	}

	/**
	 * Inserts a word into trie
	 * 
	 * @param word word to be inserted
	 * @return none
	 */

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
		if (curr.isEndOfWord) {
			return;
		}
		curr.isEndOfWord = true;
		size++;
	}

	/**
	 * Checks if a word exists in the trie
	 * 
	 * @param word word to be looked for
	 * @return boolean of if the word exists or not
	 */

	public boolean doesWordExist(String word) {

		TrieNode curr = this.root;

		for (int i = 0; i < word.length(); i++) {
			//
			if (!curr.children.containsKey(word.charAt(i)))
				return false;
			curr = curr.children.get(word.charAt(i));
		}

		return curr.isEndOfWord;
	}

	/**
	 * Removes a word from trie.
	 * 
	 * @param word word to remove
	 * @return return true if exist, return false if not
	 */
	public boolean removeWord(String word) {
		TrieNode curr = this.root;
		for (int i = 0; i < word.length(); i++) {
			// init node for this char
			Character currChar = word.charAt(i);
			if (!curr.children.containsKey(word.charAt(i)))
				return false;
			// move pointer
			curr = curr.children.get(currChar);
		}
		if (!curr.isEndOfWord) {
			return false;
		}
		curr.isEndOfWord = false;
		size--;
		return true;
	}

	/**
	 * Wrapper function that finds all words beginning with a given prefix.
	 * 
	 * @param prefix prefix in question
	 * @return list of all words in trie that have that prefix
	 */
	public List<String> findWordsWithPrefix(String prefix) {
		List<String> result = new ArrayList<>();
		TrieNode curr = root;
		for (Character c : prefix.toCharArray()) {
			if (!curr.children.containsKey(c)) {
				return result;
			}
			curr = curr.children.get(c);
		}

		findAllWordsPrefix(prefix, curr, result, new ArrayList<Character>());

		return result;
	}

	/**
	 * Private recursive helper method for findWordsWithPrefix.
	 * 
	 * @param prefix   prefix to look for
	 * @param curr     current node
	 * @param currList final list of words
	 * @param path     list that contains characters of current path so far
	 */
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
			path.remove(path.size() - 1);
		}
	}

	/**
	 * Counts the number of words that start with this prefix.
	 * 
	 * @param prefix prefix in question
	 * @return count, the number of words that begin with the given prefix
	 */
	public int countWordsWithPrefix(String prefix) {
		return findWordsWithPrefix(prefix).size();
	}

	/**
	 * Prints all of the words with the given prefix.
	 * 
	 * @param prefix prefix in question
	 */
	public void printWordsWithPrefix(String prefix) {
		List<String> allWords = findWordsWithPrefix(prefix);
		System.out.println(allWords);
	}

	/**
	 * Prints all words in the Trie.
	 */
	public void printAllWords() {
		List<String> allWords = findAllWords(new ArrayList<String>(), root, new ArrayList<Character>());
		System.out.println(allWords);

	}

	/**
	 * Returns the number of words in the Trie.
	 * 
	 * @return size, the number of words in the Trie.
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Private recursive helper method for findAllWords
	 * 
	 * @param result list of words so far
	 * @param root   current node
	 * @param path   list of characters for current path so far
	 * @return list of all words in trie
	 */
	private List<String> findAllWords(List<String> result, TrieNode root, List<Character> path) {
		if (root == null) {
			return null;
		}
		if (root.isEndOfWord == true) {
			String strRes = "";
			for (int i = 0; i < path.size(); i++) {
				strRes += String.valueOf(path.get(i));
			}
			result.add(strRes);
		}
		for (Character c : root.children.keySet()) {
			path.add(c);
			findAllWords(result, root.children.get(c), path);
			path.remove(path.size() - 1);
		}
		return result;
	}

	/**
	 * For leetcode "Lexicographical Numbers"
	 * Finds and returns a list of all numbers after traversing the Trie
	 * using a preorder traversal.
	 * 
	 * @return
	 */
	public List<String> preorder() {
		return findIntWords(new ArrayList<String>(), root, new ArrayList<Character>());
	}

	/**
	 * For leetcode "Lexicographical Numbers"
	 * Private recursive helper for preorder traversal
	 * 
	 * @param result list of numbers so far
	 * @param root   current node
	 * @param path   list of characters for current path so far
	 * @return list of all words in trie
	 */
	private List<String> findIntWords(List<String> result, TrieNode root, List<Character> path) {
		if (root == null) {
			return null;
		}
		if (root.isEndOfWord == true) {
			String strRes = "";
			for (int i = 0; i < path.size(); i++) {
				strRes += String.valueOf(path.get(i));
			}
			result.add(strRes);
		}
		for (int i = 0; i <= 9; i++) {
			Character c = Character.forDigit(i, 10);
			if (root.children.keySet().contains(c)) {
				path.add(c);
				findIntWords(result, root.children.get(c), path);
				path.remove(path.size() - 1);
			}
		}
		return result;
	}

	/**
	 * For leetcode "Longest Common Prefix"
	 * Finds the longest prefix that all words in the Trie share
	 * 
	 * @return a string of the longest common prefix
	 */
	public String findCommonPrefix() {
		TrieNode cur = root;
		String res = "";
		while (!cur.isEndOfWord && cur.children.keySet().size() == 1) {
			Character next = cur.children.keySet().iterator().next();
			res += String.valueOf(next);
			cur = cur.children.get(next);
		}
		return res;
	}

	/**
	 * Private class that represents a node in the trie
	 */
	private class TrieNode {
		Character key;
		HashMap<Character, TrieNode> children;
		boolean isEndOfWord;

		TrieNode(Character key) {
			this.key = key;
			this.children = new HashMap<>();
			isEndOfWord = false;
		}

		TrieNode() {
			this(null);
		}
	}
}
