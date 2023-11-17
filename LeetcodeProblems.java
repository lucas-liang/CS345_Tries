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
        /*
         * Test longest common prefix solution
         */
        System.out.println("Test Longest Common Prefix");

        /*
         * Expected - "fl"
         */
        List<String> words1 = new ArrayList<String>();
        words1.add("flower");
        words1.add("flow");
        words1.add("flight");
        System.out.println(LongestCommonPrefix(words1));

        /*
         * Expected - ""
         */
        List<String> words2 = new ArrayList<String>();
        words2.add("dog");
        words2.add("racecar");
        words2.add("car");
        System.out.println(LongestCommonPrefix(words2));

        /*
         * Expected - "flow"
         */
        List<String> words3 = new ArrayList<String>();
        words3.add("flower");
        words3.add("flow");
        words3.add("flown");
        System.out.println(LongestCommonPrefix(words3));

        /*
         * Expected - ""
         */
        List<String> words4 = new ArrayList<String>();
        words4.add("i want");
        words4.add("it that way");
        words4.add("");
        System.out.println(LongestCommonPrefix(words4));

        /*
         * Test lexicographic numbers solution
         */
        System.out.println("\n\nTest Lexicographic Numbers");

        /*
         * Expected [1]
         */
        System.out.println(LexicographicalNumbers(1));

        /*
         * Expected [1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2,
         * 20, 21, 22, 23, 24, 25, 26, 27, 3, 4, 5, 6, 7, 8, 9]
         */
        System.out.println(LexicographicalNumbers(27));

        /*
         * Expected []
         */
        System.out.println(LexicographicalNumbers(-123));

        /*
         * Expected [1, 10, 100, 101, 102, 103, 104, 105, 106, 107,
         * 108, 109, 11, 110, 111, 112, 113, 114, 115, 116, 117, 118,
         * 119, 12, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129,
         * 13, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 14,
         * 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 15, 150,
         * 151, 152, 153, 154, 155, 156, 157, 158, 159, 16, 160, 161,
         * 162, 163, 164, 165, 166, 167, 168, 169, 17, 170, 171, 172,
         * 173, 174, 175, 176, 177, 178, 179, 18, 180, 181, 182, 183,
         * 184, 185, 186, 187, 19, 2, 20, 21, 22, 23, 24, 25, 26, 27,
         * 28, 29, 3, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 4, 40,
         * 41, 42, 43, 44, 45, 46, 47, 48, 49, 5, 50, 51, 52, 53, 54,
         * 55, 56, 57, 58, 59, 6, 60, 61, 62, 63, 64, 65, 66, 67, 68,
         * 69, 7, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 8, 80, 81,
         * 82, 83, 84, 85, 86, 87, 88, 89, 9, 90, 91, 92, 93, 94,
         * 95, 96, 97, 98, 99]
         */
        System.out.println(LexicographicalNumbers(187));
    }
}
