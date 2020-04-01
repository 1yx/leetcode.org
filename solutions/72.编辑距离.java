/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// class Solution {
//     public int minDistance(String word1, String word2) {
//         int rl = word1.length(), cl = word2.length();
//         int[][] dp = new int[rl + 1][cl + 1];
//         for (int r = 0; r <= rl; r ++) {
//             dp[r][0] = r;   
//         }
//         for (int c = 0; c <= cl; c ++) {
//             dp[0][c] = c;
//         }
//         for (int r = 1; r <= rl; r ++) {
//             for (int c = 1; c <= cl; c ++) {
//                 if (word1.charAt(r - 1) == word2.charAt(c - 1)) 
//                     dp[r][c] = dp[r - 1][c - 1];
//                 else
//                     dp[r][c] = Math.min(dp[r - 1][c - 1], Math.min(dp[r][c - 1], dp[r - 1][c])) + 1;
//             }
//         }
//         return dp[rl][cl];
//     }
// }

// @date Apr 1 2020
// @solution dp 1
// class Solution {
//     public int minDistance(String word1, String word2) {
//         int rl = word1.length(), cl = word2.length();
//         int[][] dp = new int[rl + 1][cl + 1];
//         for (int r = 0; r <= rl; r ++)
//             dp[r][0] = r;
//         for (int c = 0; c <= cl; c ++) 
//             dp[0][c] = c;
//         for (int r = 1; r <= rl; r ++) 
//             for (int c = 1; c <= cl; c ++) 
//                 dp[r][c] = (word1.charAt(r - 1) == word2.charAt(c - 1)) 
//                     ? dp[r - 1][c - 1] 
//                     : Math.min(dp[r - 1][c - 1], Math.min(dp[r][c -1], dp[r - 1][c])) + 1;
//         return dp[rl][cl];
//     }    
// }

// @lc code=start
// @date Apr 1 2020
// @solution dp 2 压缩数组
class Solution {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int rl = w1.length, cl = w2.length;
        int[] dp = new int[cl + 1];
        for (int c = 0; c <= cl; c ++) 
            dp[c] = c;
        for (int r = 1; r <= rl; r ++) {
            int ul = dp[0]; // upper left
            for (int c = 0; c <= cl; c ++) {
                if (c == 0) {
                    dp[c] = r;
                    continue;
                }
                int up = dp[c], l = dp[c - 1]; // up and left
                dp[c] = (w1[r - 1] == w2[c - 1]) ? ul
                    : Math.min(ul, Math.min(up, l)) + 1;
                ul = up;
            }
        }
        return dp[cl];
    }
}



// @lc code=end

