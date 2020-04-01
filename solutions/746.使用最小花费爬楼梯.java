/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
// @date Apr 1 2020
// @solution dp 1
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len < 1) return 0;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i ++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[len - 1], dp[len - 2]);
    }
}
// @lc code=end

