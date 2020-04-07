/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 */
// @lc code=start
// @date Apr 5 2020
// @solution dp 1
class Solution {
    public boolean isMatch(String s, String p) {
        if (p.equals(s) || p.equals("*")) return true;
        int rl = p.length(), cl = s.length();
        if (rl * cl == 0) return false;
        boolean[][] dp = new boolean[rl + 1][cl + 1];
        dp[0][0] = true;
        for (int r = 1; r < rl + 1; r ++) {
            if (p.charAt(r - 1) == '*') {
                boolean flag = false;
                dp[r][0] = dp[r - 1][0];
                for (int c = 1; c < cl + 1; c ++) {
                    dp[r][c] = flag ? true : dp[r - 1][c] || dp[r - 1][c - 1];
                    if (dp[r - 1][c - 1])
                        flag = true;
                }
                continue;
            } 
            if (p.charAt(r - 1) == '?') {
                for (int c = 1; c < cl + 1; c ++) 
                    dp[r][c] = dp[r - 1][c - 1];
                continue;
            }
            for (int c = 1; c < cl + 1; c ++) 
                dp[r][c] = dp[r - 1][c - 1] && p.charAt(r - 1) == s.charAt(c - 1);
        }
        return dp[rl][cl];
    }
}


// @date Apr 5 2020
// @solution dp 2
// class Solution {
//     public boolean isMatch(String s, String p) {
//         int rl = s.length(), cl = p.length();
//         boolean[][] dp = new boolean[rl + 1][cl + 1];
//         dp[0][0] = true;
//         for (int r = 0; r <= rl; r ++)
//             for (int c = 1; c <= cl; c ++)
//                 if (r == 0)
//                     dp[r][c] = dp[r][c - 1] && p.charAt(c - 1) == '*';
//                 else if (s.charAt(r - 1) == p.charAt(c - 1) || p.charAt(c - 1) == '?') 
//                     dp[r][c] = dp[r - 1][c - 1];
//                 else if (p.charAt(c - 1) == '*')
//                     dp[r][c] = dp[r][c - 1] || dp[r - 1][c];
//         return dp[rl][cl];
//     }
// }
// @lc code=end

