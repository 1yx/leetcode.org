/*
 * @lc app=leetcode.cn id=892 lang=java
 *
 * [892] 三维形体的表面积
 */

// @lc code=start
class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length, res = 0;
        for (int r = 0; r < n; r ++) {
            for (int c = 0; c < n; c ++) {
                res += grid[r][c] * 4 + 2;
                res -= (r > 1) ? Math.min(grid[r][c], grid[r - 1][c]) * 2 : 0;
                res -= (c > 0) ? Math.min(grid[r][c], grid[r][c - 1]) * 2 : 0;
            }
        }
        return res;
    }
}
// @lc code=end

