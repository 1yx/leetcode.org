import java.util.Map;

/*
 * @lc app=leetcode.cn id=1074 lang=java
 *
 * [1074] 元素和为目标值的子矩阵数量
 */
// using Kadane's Algorithm DP
// @date Mar 14 2020
// class Solution {
//     public int numSubmatrixSumTarget(int[][] matrix, int target) {
//         int rl = matrix.length, cl = matrix[0].length;
//         for (int r = 0; r < rl; r ++) {
//             for (int c = 1; c < cl; c ++) {
//                 matrix[r][c] += matrix[r][c - 1];
//             }
//         }
//         int res = 0;
//         for (int c = 0; c < cl; c ++) {
//             for (int _c = -1; _c < c; _c ++) {
//                 Map<Integer, Integer> counter = new HashMap<>();
//                 counter.put(0, 1);
//                 int source = 0;
//                 for (int r = 0; r < rl; r ++) {
//                     source += matrix[r][c] - (_c > 0 ? matrix[r][_c] : 0);
//                     res += counter.getOrDefault(source - target, 0);
//                     counter.put(source, counter.getOrDefault(source, 0) + 1);
//                 }
//             }
//         }
//         return res;
//     }
// }

// @lc code=start
// @date Mar 14 2020
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rl = matrix.length, cl = matrix[0].length;
        for (int r = 0; r < rl; r ++) 
            for (int c = 1; c < cl; c ++)
                matrix[r][c] += matrix[r][c - 1];

        int res = 0;
        for (int c = 0; c < cl; c ++) {
            for (int _c = -1; _c < c; _c ++) {
                Map<Integer, Integer> srcCnt = new HashMap<>();
                srcCnt.put(0, 1);
                int source = 0;
                for (int r = 0; r < rl; r ++) {
                    source += matrix[r][c] - (_c >= 0 ? matrix[r][_c] : 0);
                    res += srcCnt.getOrDefault(source - target, 0);
                    srcCnt.put(source, srcCnt.getOrDefault(source, 0) + 1);
                }
            }
        }
        return res;
    }
}
// @lc code=end

