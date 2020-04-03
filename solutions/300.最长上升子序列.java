/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 */

// @lc code=start
// @date Apr 1 2020
// @solution dp
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < len; i ++) {
            for (int j = 0; j < i; j ++) 
                if (nums[j] < nums[i]) 
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
// @lc code=end

