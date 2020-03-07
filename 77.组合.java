import java.util.*;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
// class Solution {
//     List<List<Integer>> res;
//     public List<List<Integer>> combine(int n, int k) {
//         res = new ArrayList<>();
//         helper(new ArrayList<Integer>(), n, k, 1);
//         return res;
//     }
//     private void helper(ArrayList<Integer> kList, int n, int k, int i) {
//         if (kList.size() == k) {
//             ArrayList<Integer> tmp = new ArrayList<Integer>();
//             for(int v: kList)
//                 tmp.add(v);
//             res.add(tmp);
//             return;
//         }

//         for(int j = i; j <= n; j++) {
//             kList.add(j);
//             helper(kList, n, k, j+1);
//             kList.remove(kList.size() - 1);
//         }
//     }
// }

// @date Mar 07 2020
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtrack(combination, n, k, 0, res);
        return res;
    }
    void backtrack(List<Integer> combination, int n, int k, int i, List<List<Integer>> res) {
        if (combination.size() == k) {
            res.add(new ArrayList<Integer>(combination));
            return;
        }
        for (int j = i; j < n; j ++) {
            combination.add(j + 1); // 1..n the first is 1 not 0;
            backtrack(combination, n, k, j + 1, res);
            combination.remove(combination.size() - 1);
        }
    }
}
// @lc code=end

