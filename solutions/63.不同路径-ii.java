/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
// class Solution {
//     public int uniquePathsWithObstacles (int[][] grid){ 
//         int rl = grid.length, cl = grid[0].length;
//         if (grid[0][0] == 1) return 0;
//         grid[0][0] = 1;
//         for (int r = 1; r < rl; r ++) 
//             grid[r][0] = (grid[r][0] == 0 && grid[r-1][0] == 1) ? 1 : 0;
//         for (int c = 1; c < cl; c ++)
//             grid[0][c] = (grid[0][c] == 0 && grid[0][c-1] == 1) ? 1 : 0;
//         for (int r = 1; r < rl; r ++) {
//             for (int c = 1; c < cl; c++) {
//                 grid[r][c] = grid[r][c] == 1 ? 0 : grid[r-1][c] + grid[r][c-1];
//         return grid[rl-1][cl-1];
//     }
// }
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int rl = grid.length, cl = grid[0].length;
        if (grid[0][0] == 1) return 0;
        int[] row = new int[cl];
        row[0] = 1;
        for (int r = 0; r < rl; r ++) 
            for (int c = 0; c < cl; c++) 
                row[c] = (grid[r][c] == 1) ? 0 : (c - 1 < 0) ? row[c] : row[c] + row[c - 1];
        return row[cl - 1];
    }
}
// @lc code=end

