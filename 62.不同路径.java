/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
// class Solution {
//     public int uniquePaths(int rl, int cl) {
//         int[][] grid = new int[rl][cl];
//         for (int r = 0; r < rl; r ++) 
//             grid[r][0] = 1;
//         for (int c = 0; c < cl; c ++) 
//             grid[0][c] = 1;
//         for (int r = 1; r < rl; r ++) {
//             for (int c = 1; c < cl; c ++) {
//                 grid[r][c] = grid[r-1][c] + grid[r][c-1];
//             }
//         }
//         return grid[rl-1][cl-1];
//     }
// }

// class Solution {
//     public int uniquePaths(int rl, int cl) {
//         int[] prevRow = new int[cl];
//         int[] currRow = new int[cl];
//         Arrays.fill(prevRow, 1);
//         Arrays.fill(currRow, 1);
//         for (int r = 1; r < rl; r ++) {
//             for (int c = 1; c < cl; c++) {
//                 currRow[c] = currRow[c - 1] + prevRow[c];
//             }
//             prevRow = currRow.clone();
//         }
//         return currRow[cl - 1];
//     }
// }

class Solution {
    public int uniquePaths(int rl, int cl) {
        int[] row = new int[cl];
        Arrays.fill(row, 1);
        for (int r = 1; r < rl; r ++) {
            for (int c = 1; c < cl; c ++) {
                row[c] = row[c-1] + row[c];
            }
        }
        return row[cl-1];
    }
}
// @lc code=end

