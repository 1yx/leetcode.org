/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子序列
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int pos = 1, neg = 1, res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = pos;
                pos = neg;
                neg = temp;
            }
            pos = Math.max(pos * nums[i], nums[i]);
            neg = Math.min(neg * nums[i], nums[i]);
            res = Math.max(res, pos);
        }
        return res;
    }
}
// @lc code=end

