import java.util.*;
/*
 * @lc app=leetcode.cn id=1162 lang=java
 *
 * [1162] 地图分析
 */

// @lc code=start
// @date Mar 29 2020
// @solution bfs
class Solution {
    public int maxDistance(int[][] grid) {
        Queue<Integer> queue = new LinkedList<>();
        int rl = grid.length, cl = grid[0].length;
        for (int r = 0; r < rl; r ++) 
            for (int c = 0; c < cl; c ++) 
                if (grid[r][c] == 1) {
                    queue.offer(r);
                    queue.offer(c);
                }
        if (queue.size() == 0 || queue.size() == rl * cl * 2)
            return -1;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int _x = 0, _y = 0;
        while (!queue.isEmpty()) {
            _x = queue.poll();
            _y = queue.poll();
            for (int i = 0; i < 4; i ++){
                int x = _x + dx[i];
                int y = _y + dy[i];
                if (x < 0 || y < 0 || x == rl || y == cl) continue;
                if (grid[x][y] != 0) continue;
                grid[x][y] = grid[_x][_y] + 1;
                queue.offer(x);
                queue.offer(y);
            }
        }
        return grid[_x][_y] - 1;
    }
}
// @lc code=end

