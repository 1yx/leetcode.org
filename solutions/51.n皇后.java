import java.util.*;/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */




// @lc code=start
class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        bt(board, 0, n);
        return res;
    }
    private void bt(int[][] board, int i, int n) {
        if (i == n) {
            List<String> l = new ArrayList<>();
            for (var k = 0; k < n; k++) {
                StringBuilder sb = new StringBuilder();
                for (var m = 0; m < n; m++) {
                    sb.append((board[k][m] == 0) ? '.' : 'Q');
                }
                l.add(sb.toString());
            }
            res.add(l);
            return ;
        }
        for (int j = 0; j < n; j ++) {
            if (available(i, j, board)) {
                board[i][j] = 1;
                bt(board, i+1, n);
                board[i][j] = 0;
            }
        }
    }
    private boolean available(int i, int j, int[][] board) {
        for (int h = 0; h < i; h ++) 
            if (board[h][j] == 1) return false;
        
        int max = board.length;
        int offset;
        for (offset = 0; i - offset >= 0 && j + offset < max; offset ++) 
            if (board[i-offset][j+offset] == 1) return false;
        
        for (offset = 0; i + offset < max && j - offset >= 0; offset ++) 
            if (board[i+offset][j-offset] == 1) return false;
        
        for (offset = 0; i - offset >= 0 && j - offset >= 0; offset ++) 
            if (board[i-offset][j-offset] == 1) return false;

        for (offset = 0; i + offset < max && j + offset < max; offset ++) 
            if (board[i+offset][j+offset] == 1) return false;

        return true;
    }
}
// @lc code=end

