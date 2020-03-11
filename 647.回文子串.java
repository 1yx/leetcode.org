/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int l = s.length();
        boolean[][] dp = new boolean[l][l];
        int res = 0;
        for (int i = l - 1; i >= 0; i --) {
            for (int j = i; j < l; j ++) {
                if ((j - i <= 2 || dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    res ++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

