import java.util.*;
/*
 * @lc app=leetcode.cn id=994 lang=java
 *
 * [994] 腐烂的橘子
 */

// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int rl = grid.length, cl = grid[0].length, freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        for (int r = 0; r < rl; r++) {
            for (int c = 0; c < cl; c++) {
                if (grid[r][c] == 1)
                    freshCount ++;
                else if (grid[r][c] == 2)
                    queue.add(new int[] {r, c});
            }
        }

        int step = 0;
        while (freshCount > 0 && !queue.isEmpty()) {
            step ++;
            for (int i = queue.size(); i > 0; i --) {
                int[] orange = queue.poll();
                int r = orange[0], c = orange[1], _r, _c;
                if ((_r = r - 1) >= 0 && grid[_r][c] == 1){
                    grid[_r][c] = 2;
                    freshCount --;
                    queue.add(new int[]{_r, c});
                }
                if ((_r = r + 1) < rl && grid[r + 1][c] == 1){
                    grid[_r][c] = 2;
                    freshCount --;
                    queue.add(new int[]{_r, c});
                }
                if ((_c = c - 1) >= 0 && grid[r][_c] == 1){
                    grid[r][c - 1] = 2;
                    freshCount --;
                    queue.add(new int[]{r, _c});
                }
                if ((_c = c + 1) < cl && grid[r][_c] == 1){
                    grid[r][_c] = 2;
                    freshCount --;
                    queue.add(new int[]{r, _c});
                }

            }
        }
        return (freshCount > 0) ? -1 : step;
    }
}
// @lc code=end

