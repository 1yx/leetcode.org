import java.util.*;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
// backtracking in swapping
// class Solution {
//     List<List<Integer>> res = new ArrayList<>();
//     int l;
//     public List<List<Integer>> permute(int[] nums) {
//         l = nums.length;
//         backtrace(0, new ArrayList<Integer>() {{ for (int i : nums) add(i); }});
//         return res;
//     }

//     private void backtrace(int i, ArrayList<Integer> nums) {
//         if (i == l) {
//             res.add(new ArrayList<Integer>(nums));
//         }
//         for (int j = i; j < l; j ++) {
//             backtrace(i+1, swap(nums, i, j));
//         }
//     }

//     public ArrayList<Integer> swap (ArrayList<Integer> arr, int i, int j) {
//         ArrayList<Integer> newArr = new ArrayList<Integer>(arr);
//         int tmp = newArr.get(i);
//         newArr.set(i, newArr.get(j));
//         newArr.set(j, tmp);
//         return newArr;
//     }
// }

// backtracking in adding 
// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();
//         List<Integer> permutation = new ArrayList<>();
//         backtrack(permutation, nums, new boolean[nums.length], 0, res);
//         return res;
//     }
//     void backtrack(List<Integer> permutation, int[] nums, boolean[] used, int i, List<List<Integer>> res) {
//         if (i == nums.length) {
//             res.add(new ArrayList<Integer>(permutation));
//             return;
//         }
//         for (int j = 0; j < nums.length; j ++) {
//             if (!used[j]) {
//                 permutation.add(nums[j]);
//                 used[j] = true;
//                 backtrack(permutation, nums, used, i + 1, res);
//                 permutation.remove(permutation.size() - 1);
//                 used[j] = false;
//             }
//         }
//     }
// }


// better backtracking with adding 
// @date Mar 07 2020
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }
    void backtrack(int[]nums, List<Integer> permutation, boolean[] used) {
        if (permutation.size() == nums.length) {
            res.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (used[i]) continue;
            permutation.add(nums[i]);
            used[i] = true;
            backtrack(nums, permutation, used);
            permutation.remove(permutation.size() - 1);
            used[i] = false;
        }
    }
}


// better backtracking with swapping
// class Solution {
//     List<List<Integer>> res = new ArrayList<>();
//     public List<List<Integer>> permute(int[] nums) {
//         List<Integer> numsList = IntStream.of(nums)
//             .boxed().collect(Collectors.toCollection(ArrayList::new));
//         backtrack(numsList, 0);
//         return res;
//     }
//     void backtrack(List<Integer> nums, int i) {
//         if (i == nums.size()) {
//             res.add(new ArrayList<>(nums));
//             return ;
//         }
//         for (int j = i; j < nums.size(); j ++) {
//             Collections.swap(nums, i, j);
//             backtrack(nums, i + 1);
//             Collections.swap(nums, j, i);
//         }
//     }
// }
// @lc code=end

