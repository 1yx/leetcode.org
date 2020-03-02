import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList();
        var len = nums.length;
        Arrays.sort(nums);
        // -2,0,0,2,2
        for(var i = 0; i < len; i ++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            var j = i + 1;
            var k = len - 1;
            while (j < k) {
                if (nums[j] + nums[k] + nums[i] < 0) {
                    j ++;
                } else if (nums[j] + nums[k] + nums[i] > 0) {
                    k --;
                }  else {
                    while (j < k && nums[j] == nums[j + 1]) j ++;
                    while (j < k && nums[k] == nums[k - 1]) k --;
                    j ++;
                    k --;
                    ret.add(Arrays.asList(nums[i],nums[j - 1],nums[k + 1]));
                }
            }
        }
        return ret;
    }
}


