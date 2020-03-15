import java.util.*;
/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
// bfs 
// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         Set<String> wordSet = new HashSet<>(wordList);
//         if (!wordSet.contains(endWord)) return 0;
//         Queue<String> queue = new LinkedList<>();
//         queue.offer(beginWord);
//         wordSet.remove(beginWord);
//         int step = 0, wordLength = beginWord.length();
//         while (!queue.isEmpty()) {
//             step ++;
//             for (int i = queue.size(); i > 0; i --) {
//                 String word = queue.poll();
//                 for (Iterator<String> it = wordSet.iterator(); it.hasNext();) {
//                     String element = it.next();
//                     int diff = 0;
//                     for (int j = 0; j < wordLength; j ++) {
//                         if (word.charAt(j) != element.charAt(j))
//                             if (++diff > 1) break;
//                     }                   
//                     if (diff == 1) {
//                         if (endWord.equals(element))
//                             return step + 1;
//                         queue.offer(element);
//                         it.remove();
//                     }
//                 }
//             }
//         }
//         return 0;
//     }
// }

// bfs
// @date Mar 072020
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        dict.remove(beginWord);
        int step = 0;
        while (!queue.isEmpty()) {
            step ++;
            for (int i = queue.size(); i > 0; i --) {
                String word = queue.poll();
                for (int j = word.length() - 1; j >= 0; j --) {
                    char[] letter = word.toCharArray();
                    for (char alphabet = 'a'; alphabet <= 'z'; alphabet ++) {
                        if (letter[j] == alphabet) continue;
                        letter[j] = alphabet;
                        String newWord = new String(letter);
                        if (newWord.equals(endWord)) return step + 1;
                        if (dict.contains(newWord)) {
                            queue.offer(newWord);
                            dict.remove(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
// @lc code=end

