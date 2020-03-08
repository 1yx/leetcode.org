import java.util.*;
import java.util.stream.*;
/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
// swap backtrack
// 需去重
// @date Feb 21 2020
// class Solution {
//     int l;
//     List<List<Integer>> res = new ArrayList<>();
//     public List<List<Integer>> permuteUnique(int[] nums) {
//         l = nums.length;
//         backtrack(new ArrayList<Integer>(){{for(int n:nums) add(n);}}, 0);
//         return res;
//     }
//     private void backtrack(ArrayList<Integer> nums, int i) {
//         if (i == l && !used(nums))
//             res.add(new ArrayList<Integer>(nums));
            
//         for(int j = i; j < l; j ++) 
//             backtrack(swap(nums, i, j), i + 1);
//     }

//     private ArrayList<Integer> swap(ArrayList<Integer> arr, int i, int j) {
//         ArrayList<Integer> newArr = new ArrayList<>(arr);
//         int temp = arr.get(i);
//         newArr.set(i, arr.get(j));
//         newArr.set(j, temp);
//         return newArr;
//     }

//     private boolean used(ArrayList<Integer> arr) {
//         for(List<Integer> a : res)
//             if(a.equals(arr)) return true;
//         return false;
//     }
// }

// list add backtrack
// 需排序
// @date Feb 22 2020
// class Solution {
//     List<List<Integer>> res = new ArrayList<>();
//     int l;
//     public List<List<Integer>> permuteUnique(int[] nums) {
//         l = nums.length;
//         Arrays.sort(nums);
//         backtrack(nums, new ArrayList<Integer>(), new boolean[l]);
//         return res;
//     }
//     private void backtrack(int[] nums, ArrayList<Integer> list, boolean[] used){
//         if (list.size() == l) {
//             res.add(new ArrayList<Integer>(list));
//             return;
//         }
//         for(int i = 0; i < l; i++) {
//             if (used[i]) continue;
//             if (i > 0 && nums[i] == nums[i -1] && !used[i - 1]) continue;

//             used[i] = true;
//             list.add(nums[i]);
//             backtrack(nums, list, used);
//             used[i] = false;
//             list.remove(list.size() - 1);
//         }
//     }
// }

// better backtrracking with swapping
// similar to question 47
// @date Mar 07 2020
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> numsList = IntStream.of(nums)
            .boxed().collect(Collectors.toCollection(ArrayList::new));
        backtrack(numsList, 0);
        return res;
    }
    void backtrack(List<Integer> nums, int i) {
        if (i == nums.size() && !res.contains(nums)) {
            res.add(new ArrayList<Integer>(nums));
            return ; // return is useless, cause i==nums.size()==j,the loop don't work
        }
        for (int j = i; j < nums.size(); j ++) {
            Collections.swap(nums, i, j);
            backtrack(nums, i + 1);
            Collections.swap(nums, j, i);
        }
        
    }
}

// better backtracking with adding 
// similar to question 46 
// class Solution {
//     List<List<Integer>> res = new ArrayList<>();
//     public List<List<Integer>> permuteUnique(int[] nums) {
//         Arrays.sort(nums); // 仅为了让重复的元素相临，为下面的nums[i]与nums[i-1]的比较做准备
//         backtrack(nums, new ArrayList<>(), new boolean[nums.length]);
//         return res;
//     }
//     void backtrack(int[] nums, List<Integer> permutation, boolean[] used) {
//         if (permutation.size() == nums.length) {
//             res.add(new ArrayList<>(permutation));
//             return;
//         }        
//         for (int i = 0; i < nums.length; i ++) {
//             if (used[i]) continue;
//             if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
//             permutation.add(nums[i]);
//             used[i] =true;
//             backtrack(nums, permutation, used);
//             permutation.remove(permutation.size() - 1);
//             used[i] = false;
//          }
//     }
// }
// @lc code=end

