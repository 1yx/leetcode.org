import java.util.*;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */


 // @lc code=start
// dfs 
// @date Feb 25 2020
/* class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dc(nums, 0, list, res);
        return res;_sub
    }
    private void dc (int[] nums, int i,List<Integer> list, List<List<Integer>>res) {
        if (i == nums.length) {
            res.add(list);
            return;
        }
        dc(nums, i+1, list, res);
        list.add(nums[i]);
        dc(nums, i+1, new ArrayList<Integer>(list), res);
        list.remove(list.size() - 1);
    }
} */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for (Integer n : nums) {
            int s = res.size(); // important
            for (int i = 0; i < s; i ++) {
                List<Integer> _sub = new ArrayList<>(res.get(i));
                _sub.add(n);
                res.add(_sub);
            }
        }
        return res;
    }
}
// @lc code=end

