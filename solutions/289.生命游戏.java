/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
// @date Apr 2 2020
class Solution {
    public void gameOfLife(int[][] board) {
        int rl = board.length, cl = board[0].length;
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        for (int r = 0; r < rl; r ++) {
            for (int c = 0; c < cl; c ++) {
                int cell = board[r][c] & 1;
                int nb = 0; // live neighbour
                for (int i = 0; i < 8; i ++) {
                    int x = r + dx[i], y = c + dy[i];
                    if (x < 0 || x == rl || y < 0 || y == cl) continue;
                    nb += board[x][y] & 1;
                }
                if (nb == 3 || (nb == 2 && cell == 1)) {
                    board[r][c] |= 2;
                }
            }
        }
        for (int r = 0; r < rl; r ++) 
            for (int c = 0; c < cl; c ++) 
                board[r][c] = board[r][c] >> 1;
    }
}
// @lc code=end

