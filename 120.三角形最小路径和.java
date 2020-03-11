import java.util.*;
/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */
// 自顶向下
// @date Mar 10 2020
// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         if (triangle == null || triangle.isEmpty())  return 0;
//         int rl = triangle.size(), cl = triangle.get(rl - 1).size();
//         int [][] dp = new int[rl][cl];
//         dp[0][0] = triangle.get(0).get(0);
//         int res = Integer.MAX_VALUE;
//         for (int r = 1; r < rl; r ++) {
//             for (int c = 0; c <= r; c ++) {
//                 int val = triangle.get(r).get(c);
//                 if (c == 0)
//                     dp[r][c] = dp[r-1][c] + val;
//                 else if (c == r) 
//                     dp[r][c] = dp[r-1][c-1] + val;
//                 else
//                     dp[r][c] = Math.min(dp[r-1][c], dp[r-1][c-1]) + val;
//             }
//         }
//         for (int c = 0; c < cl; c ++) {
//             res = Math.min(res, dp[rl - 1][c]);
//         }
//         return res;
//     }
// }

// 自底向上
// @date Mar 10 2020
// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         if (triangle.isEmpty()) return 0;
//         int rl = triangle.size(), cl = triangle.get(rl - 1).size();
//         int[][] dp = new int[rl][cl];
//         // int res = Integer.MAX_VALUE;
//         for (int c = cl - 1; c >= 0; c --) {
//             dp[rl - 1][c] = triangle.get(rl - 1).get(c);
//         }
//         for (int r = rl - 2; r >= 0; r --) {
//             for (int c = 0; c <= r; c ++) {
//                 dp[r][c] = Math.min(dp[r + 1][c], dp[r + 1][c + 1]) + triangle.get(r).get(c);
//             }
//         }
//         return dp[0][0];
//     }
// }
// @lc code=start
// 自底向上，一维数组
// @date Mar 10 2020
// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int[] dp = new int[triangle.size() + 1];
//         for (int r = triangle.size() - 1; r >= 0; r --)
//             for (int c = 0; c <= r; c ++) 
//                 dp[c] = Math.min(dp[c], dp[c + 1]) + triangle.get(r).get(c);
//         return dp[0];
//     }
// }

// 自顶向下，递归，超时
// @date Mar 10 2020
// class Solution {
//     int rl;
//     public int minimumTotal(List<List<Integer>> triangle) {
//         rl = triangle.size();
//         return dp(triangle, 0, 0);
//     }
//     int dp (List<List<Integer>> triangle, int r, int c) {
//         if (r == rl - 1)
//             return triangle.get(rl - 1).get(c);
//         return Math.min(dp(triangle, r + 1, c), dp(triangle, r + 1, c +1)) + triangle.get(r).get(c);
//     }
// }

// @lc code=end

