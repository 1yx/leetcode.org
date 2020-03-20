import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         List<List<Integer>> ret = new ArrayList<>();
//         int len = nums.length;
//         Arrays.sort(nums);
//         // -2,0,0,2,2
//         for(int i = 0; i < len; i ++) {
//             if (nums[i] > 0) break;
//             if (i > 0 && nums[i] == nums[i - 1]) continue;
//             int j = i + 1;
//             int k = len - 1;
//             while (j < k) {
//                 if (nums[j] + nums[k] + nums[i] < 0) {
//                     j ++;
//                 } else if (nums[j] + nums[k] + nums[i] > 0) {
//                     k --;
//                 }  else {
//                     while (j < k && nums[j] == nums[j + 1]) j ++;
//                     while (j < k && nums[k] == nums[k - 1]) k --;
//                     j ++;
//                     k --;
//                     ret.add(Arrays.asList(nums[i],nums[j - 1],nums[k + 1]));
//                 }
//             }
//         }
//         return ret;
//     }
// }

//@date Mar 02 2020
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k ++) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                if (nums[k] + nums[i] + nums[j] < 0) 
                    while (i < j && nums[i] == nums[++i]);
                else if (nums[k] + nums[i] + nums[j] > 0)
                    while (i < j && nums[j] == nums[--j]);
                else {
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }
}


