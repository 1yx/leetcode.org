import java.util.*;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */
// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        List<Integer> smaller = new ArrayList<>();
        List<Integer> bigger  = new ArrayList<>();
        for (int num : nums) {
            if (num < nums[0]) 
                smaller.add(num);
            if (num > nums[0])
                bigger.add(num);
        }
        if (smaller.size() > nums.length / 2)
            return majorityElement(smaller.stream().mapToInt(i -> i).toArray());
        if (bigger.size() > nums.length / 2)
            return majorityElement(bigger.stream().mapToInt(i -> i).toArray());
        return nums[0];
    }
}
// @lc code=end

