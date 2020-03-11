/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @date Mar 11 2020
// class Solution {
//     public int rob(int[] nums) {
//         int l = nums.length;
//         if (l == 0) return 0;
//         int[][] dp = new int[l][2];
//         dp[0][0] = 0;
//         dp[0][1] = nums[0];
//         for (int i = 1; i < l; i ++) {
//             dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
//             dp[i][1] = dp[i - 1][0] + nums[i];
//         }
//         return Math.max(dp[l - 1][0], dp[l - 1][1]);
//     }
// }

// @date Mar 11 2020
// class Solution {
//     public int rob(int[] nums) {
//         int l = nums.length;
//         if (l == 0) return 0;
//         if (l < 2) return nums[0];
//         int[] dp = new int[l];
//         dp[0] = nums[0];
//         dp[1] = Math.max(nums[0], nums[1]);
//         for (int i = 2; i < l; i ++) {
//             dp[i] = Math.max(dp[i-1], dp[i - 2] + nums[i]);
//         }
//         return dp[l - 1];
//     }
// }

// @lc code=start
// @date Mar 11 2020
class Solution {
    public int rob(int[] nums) {
        int prev = 0, curr = 0;
        for (int x : nums) {
            int temp = curr;
            curr = Math.max(prev + x, curr);
            prev = temp;
        }
        return curr;
    }
}
// @lc code=end

