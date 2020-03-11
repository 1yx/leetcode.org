/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */


// class Solution {
//     public int maxSubArray(int[] nums) {
//         for (int i = 1; i < nums.length; i ++) {
//             nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
//         }
//         int res = Integer.MIN_VALUE;
//         for (int i = 0; i < nums.length; i ++) {
//             res = Math.max(res, nums[i]);
//         }
//         return res;
//     }
// }

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int res = Math.max(nums[0], Integer.MIN_VALUE);
        for (int i = 1; i < nums.length; i ++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
// @lc code=end

