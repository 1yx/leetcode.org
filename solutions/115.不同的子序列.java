/*
 * @lc app=leetcode.cn id=115 lang=java
 *
 * [115] 不同的子序列
 */
// @date Apr 3 2020
// @solution dp 1
// class Solution {
//     public int numDistinct(String s, String t) {
//         int rl = t.length(), cl = s.length();
//         int[][] dp = new int[rl + 1][cl + 1];
//         for (int c = 0; c < cl; c ++) 
//             dp[0][c] = 1;
        
//         for (int r = 1; r < rl + 1; r ++) 
//             for (int c = 1; c < cl + 1; c ++) 
//                 if (t.charAt(r - 1) == s.charAt(c - 1))
//                     dp[r][c] = dp[r - 1][c - 1] + dp[r][c - 1];
//                 else 
//                     dp[r][c] = dp[r][c - 1];
            
//         return dp[rl][cl];
//     }
// }

// @lc code=start
// @date Apr 3 2020
// @solution dp 2
class Solution {
    public int numDistinct(String s, String t) {
        int rl = t.length(), cl = s.length();
        int[] dp = new int[cl + 1];
        Arrays.fill(dp, 1);
        for (int r = 1; r < rl + 1; r ++) {
            int prev = dp[0];
            dp[0] = 0;
            for (int c = 1; c < cl + 1; c ++) {
                int temp = dp[c];
                if (t.charAt(r - 1) == s.charAt(c - 1))
                    dp[c] = prev + dp[c - 1];
                else
                    dp[c] = dp[c - 1];
                prev = temp;
            }
        }
        return dp[cl];
    }
}
// @lc code=end

