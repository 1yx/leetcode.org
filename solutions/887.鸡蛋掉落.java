/*
 * @lc app=leetcode.cn id=887 lang=java
 *
 * [887] 鸡蛋掉落
 */

// @lc code=start
class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        for (int j = 1; j <= K; j ++) 
            dp[1][j] = 1;
        int res = -1;
        for (int i = 2; i <= N; i ++) {
            for (int j = 1; j <= K; j ++)
                dp[i][j] = 1 + dp[i - 1][j - 1] + dp[i - 1][j];
            if (dp[i][K] >= N) {
                res = i;
                break;
            }
        }
        return (N == 1) ? 1 : res;
    }
}
// @lc code=end
