/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
// class Solution {
//     public void moveZeroes(int[] nums) {
//         var j = 0;
//         for(var i = 0; i < nums.length; ++i) {
//             if(nums[i] != 0) {
//                 if(i != j) {
//                     nums[j] = nums[i];
//                     nums[i] = 0;
//                 }
//                 j ++;
//             }
//         }
//     }
// }

// @date Mar 2 2020
class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }
}
// @lc code=end

