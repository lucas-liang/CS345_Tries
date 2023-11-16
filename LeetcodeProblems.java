import java.util.*;

public class LeetcodeProblems {
    public static String LongestCommonPrefix(List<String> strings){
        /*
         * 14. Longest Common Prefix
         * Write a function to find the longest common prefix string amongst an array of strings.
         * If there is no common prefix, return an empty string "".
         */
        Trie trieOfStrings = new Trie();
        for(String s: strings){
            trieOfStrings.insert(s);
        }
        return trieOfStrings.findCommonPrefix();
    }

    public static List<String> LexicographicalNumbers(int n){
        /*
         * 386. Lexicographical Numbers
         * Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
         */
        Trie intTrie = new Trie();
        for(int i = 1; i<=n; i++){
            intTrie.insert(Integer.toString(i));
        }

        List<String> intList = intTrie.preorder();

        return intList;
    }

    public static void main(String[] args){
        System.out.println("Test Longest Common Prefix");
        List<String> words1 = new ArrayList<String>();
        words1.add("flower");
        words1.add("flow");
        words1.add("flight");
        System.out.println(LongestCommonPrefix(words1));


        List<String> words2 = new ArrayList<String>();
        words2.add("dog");
        words2.add("racecar");
        words2.add("car");
        System.out.println(LongestCommonPrefix(words2));

        List<String> words3 = new ArrayList<String>();
        words3.add("flower");
        words3.add("flow");
        words3.add("flown");
        System.out.println(LongestCommonPrefix(words3));

        List<String> words4 = new ArrayList<String>();
        words4.add("i want");
        words4.add("it that way");
        words4.add("");
        System.out.println(LongestCommonPrefix(words4));

        System.out.println("\n\nTest Lexicographic Numbers");
        System.out.println(LexicographicalNumbers(1));
        System.out.println(LexicographicalNumbers(27));
        System.out.println(LexicographicalNumbers(-123));
        System.out.println(LexicographicalNumbers(187));
    }
}
