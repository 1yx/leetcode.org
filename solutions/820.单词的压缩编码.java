/*
 * @lc app=leetcode.cn id=820 lang=java
 *
 * [820] 单词的压缩编码
 */


// @solution trie
// class Solution {
//     public int minimumLengthEncoding(String[] words) {
//         int res = 0;
//         Trie trie = new Trie();
//         Arrays.sort(words, (word1, word2) ->
//             word2.length() - word1.length());
//         for (String word : words)
//             res += trie.insert(word);
//         return res;
//     }
//     class Trie {
//         public TrieNode root = new TrieNode();
//         public int insert (String str) {
//             TrieNode node = root;
//             boolean isNew = false;
//             for(int i = str.length() - 1; i >= 0; i --) {
//                 int c = str.charAt(i) - 'a';
//                 if (node.children[c] == null) {
//                     node.children[c] = new TrieNode();
//                     isNew = true;
//                 }
//                 node = node.children[c];
//             }
//             return isNew ? str.length() + 1: 0;// + 1 means plus '#'
//         }
//     }
//     class TrieNode {
//         public TrieNode[] children;
//         TrieNode() {
//             children = new TrieNode[26];
//         }
//     }
// }

// @lc code=start
class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (word1, word2) -> {
            int len1 = word1.length(), len2 = word2.length();
            for (int i = 0; i < Math.min(len1, len2); i ++) {
                char c1 = word1.charAt(len1 - 1 - i);
                char c2 = word2.charAt(len2 - 1 - i);
                int compare = Character.compare(c1, c2);
                if (compare != 0) return compare;
            }
            return Integer.compare(len1, len2);
        });
        int res = 0;
        for (int i = 0; i < words.length; i ++) {
            if (i + 1 < words.length && words[i + 1].endsWith(words[i]))
                continue;
            res += words[i].length() + 1;
        }
        return res;
    }
}
// @lc code=end

