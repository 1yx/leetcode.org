import java.util.Arrays;
/*
 * @lc app=leetcode.cn id=542 lang=java
 *
 * [542] 01 矩阵
 */

// @lc code=start
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int rl = matrix.length, cl = matrix[0].length;
        int[][] dp = new int[rl][cl];
        for (int r = 0; r < rl; r ++)
            for (int c = 0; c < cl; c ++) 
                if (matrix[r][c] == 0)
                    dp[r][c] = 0;
                else
                    dp[r][c] = 20000;
        
        for (int r = 0; r < rl; r ++) {
            for (int c = 0; c < cl; c ++) {
                if (r > 0) 
                    dp[r][c] = Math.min(dp[r][c], dp[r - 1][c] + 1);
                if (c > 0) 
                    dp[r][c] = Math.min(dp[r][c], dp[r][c - 1] + 1);
            }
        }
        for (int r = rl - 1; r >= 0; r --) {
            for (int c = cl - 1; c >= 0; c --) {
                if (r < rl - 1) 
                    dp[r][c] = Math.min(dp[r][c], dp[r + 1][c] + 1);
                if (c < cl - 1) 
                    dp[r][c] = Math.min(dp[r][c], dp[r][c + 1] + 1);
            }
        }    
        return dp;
    }
}
// @lc code=end

