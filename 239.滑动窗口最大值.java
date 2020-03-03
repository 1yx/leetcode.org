import java.util.*;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
// class Solution {
//     ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
//     int [] nums;

//     public void clean_deque(int i, int k) {
//         if(!deq.isEmpty() && deq.getFirst() == (i - k)){
//             deq.removeFirst();
//         }
//         while(!deq.isEmpty() && nums[i] > nums[deq.getLast()])
//             deq.removeLast();
//     }

//     public int[] maxSlidingWindow(int[] nums, int k) {
//         this.nums = nums;
//         int n = nums.length;
//         if (n * k == 0) return new int[0];
//         if (k == 1) return nums;

//         int max_idx = 0;
//         for(int i = 0; i < k; ++i) {
//             clean_deque(i, k);
//             deq.addLast(i);
//             if (nums[max_idx] < nums[i]) 
//                 max_idx = i;
//         }
//         int[] output = new int[n - k + 1];
//         output[0] = nums[max_idx];

//         for(int i = k; i < n; ++i) {
//             clean_deque(i, k);
//             deq.addLast(i);
//             output[i - k + 1] = nums[deq.getFirst()];
//         }

//         return output;
//     }
// }

// @date Mar 03 2020
class Solution {
    Deque<Integer> deq = new ArrayDeque<>();
    public void cleanAndAdd(int[] nums, int i, int k){
        if (!deq.isEmpty() && deq.getFirst() == i - k)
            deq.removeFirst();
        while(!deq.isEmpty() && nums[i] > nums[deq.getLast()])
            deq.removeLast();
        deq.addLast(i);
    }
    public int [] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int initMax = Integer.MIN_VALUE;
        for (int i = 0; i < k; i ++) {
            cleanAndAdd(nums, i, k);
            initMax = Math.max(initMax, nums[i]);
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = initMax;
        for (int i = k; i < nums.length; i++) {
            cleanAndAdd(nums, i, k);
            res[i - k + 1] = nums[deq.getFirst()];
        }
        return res;
    }
}
// @lc code=end

