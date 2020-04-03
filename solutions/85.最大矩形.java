import java.util.Stack;
/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 */

// @date Apr 2 2020
// @solution stack
// class Solution {
//     public int maximalRectangle(char[][] matrix) {
//         if (matrix.length == 0) return 0;
//         int rl = matrix.length, cl = matrix[0].length;
//         int[] histogram = new int[cl];
//         int res = 0;
//         for (int r = 0; r < rl; r ++) {
//             for (int c = 0; c < cl; c ++) {
//                 histogram[c] = matrix[r][c] == '1' ? histogram[c] + 1 : 0;
//             }
//             res = Math.max(res, largestRectangleArea(histogram));
//         }
//         return res;
//     }

//     int largestRectangleArea (int[] histogram) {
//         Stack<Integer> stack = new Stack<>();
//         stack.add(-1);
//         int len = histogram.length;
//         int res = 0, area;
//         for (int i = 0; i < len; i ++) {
//             while (stack.peek() != -1 && histogram[i] < histogram[stack.peek()]) {
//                 area = histogram[stack.pop()] * (i - stack.peek() - 1);
//                 res = Math.max(res, area);
//             }
//             stack.add(i);
//         }
//         while (stack.peek() != -1) {
//             area = histogram[stack.pop()] * (len - stack.peek() - 1);
//             res = Math.max(res, area);
//         }
//         return res;
//     }
// }

// @date Apr 2 2020
// class Solution {
//     public int maximalRectangle(char[][] matrix) {
//         if (matrix.length == 0) return 0;
//         int rl = matrix.length, cl = matrix[0].length;
//         int[][][] dp = new int[rl][cl][3];
//         int res = 0;
//         for (int r = 0; r < rl; r ++) {
//             for (int c = 0; c < cl; c ++) {
//                 if (matrix[r][c] == '0') continue;
//                 if (r == 0 && c == 0) {
//                     dp[0][0][0] = dp[0][0][1] = dp[0][0][2] = 1;
//                 } else if (r == 0) {
//                     dp[r][c][0] = dp[r][c - 1][0] + 1;
//                     dp[r][c][1] = 1;
//                     dp[r][c][2] = dp[r][c - 1][2] + 1;
//                 } else if (c == 0) {
//                     dp[r][c][0] = 1;
//                     dp[r][c][1] = dp[r - 1][c][1] + 1;
//                     dp[r][c][2] = dp[r - 1][c][2] + 1;
//                 } else {
//                     dp[r][c][0] = dp[r][c - 1][0] + 1;
//                     dp[r][c][1] = dp[r - 1][c][1] + 1;
//                     int left = dp[r][c][0], up = dp[r][c][1];
//                     for (int i = 0; i < up; i ++) {
//                         left = Math.min(left, dp[r - i][c][0]);
//                         dp[r][c][2] = Math.max(dp[r][c][2], left * (i + 1));
//                     }
//                 }
//                 res = Math.max(res, dp[r][c][2]);
//             }
//         }
//         return res;
//     }
// }

// @date Apr 1 2020
// @solution dp 1
// class Solution {
//     public int maximalRectangle(char[][] matrix) { 
//         if (matrix.length == 0) return 0;
//         int rl = matrix.length, cl = matrix[0].length;
//         int[][] dp = new int[rl][cl];
//         int res = 0;
//         for (int r = 0; r < rl; r ++) {
//             for (int c = 0; c < cl; c ++) {        
//                 if (matrix[r][c] == '0') continue;
//                 dp[r][c] = (c == 0) ? 1 : dp[r][c - 1] + 1;
//                 int left = dp[r][c];
//                 for (int _r = r; _r >= 0; _r --) {
//                     left = Math.min(left, dp[_r][c]);
//                     res = Math.max(res, left * (r - _r + 1));
//                 }
//             }
//         }
//         return res;
//     }
// }


// @date Apr 2 2020
// class Solution {
//     public int maximalRectangle(char[][] matrix) {
//         if (matrix.length == 0) return 0;
//         int rl = matrix.length, cl = matrix[0].length;
//         int[][] dp = new int[cl][3]; // 0: above, 1: left, 2: right
//         int res = 0;
//         for (int c = 0; c < cl; c ++) 
//             dp[c][2] = cl - 1;
//         for (int r = 0; r < rl; r ++) {
//             int left = 0, right = cl;
//             for (int c = 0; c < cl; c ++) {
//                 if (matrix[r][c] == '1') {
//                     dp[c][0] = dp[c][0] + 1;
//                     dp[c][1] = Math.max(dp[c][1], left);
//                 } else {
//                     dp[c][0] = 0;
//                     left = c + 1;
//                 }
//                 if (matrix[r][cl - 1 - c] == '1') 
//                     dp[cl - 1 - c][2] = Math.min(dp[cl - 1 - c][2], right);
//                 else {
//                     right = cl - 1 - c - 1;
//                 }
//             }
//             for (int c = 0; c < cl; c ++) {
//                 res = Math.max(res, (dp[c][2] - dp[c][1] + 1) * dp[c][0]);
//             }
//         }
//         return res;
//     }
// }
// @lc code=start
// @date Apr 3 2020
// @solution dp 2
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int rl = matrix.length, cl = matrix[0].length;
        int[][] left = new int[rl][cl], right = new int[rl][cl], up = new int[rl][cl];
        int res = 0;
        for (int r = 0; r < rl; r ++) {
            int leftBorder = 0, rightBorder = cl - 1;
            for (int c = 0; c < cl; c ++) {
                if (matrix[r][c] == '1') {
                    up[r][c] = r > 0 ? up[r - 1][c] + 1: 1;
                    left[r][c] = r > 0 ? Math.max(left[r - 1][c], leftBorder) : leftBorder;
                } else {
                    up[r][c] = 0;
                    left[r][c] = 0;
                    leftBorder = c + 1;
                }
                int _c = cl - 1 - c;
                if (matrix[r][_c] == '1') {
                    right[r][_c] = r > 0 ? Math.min(right[r - 1][_c], rightBorder) : rightBorder;
                } else {
                    right[r][_c] = cl - 1;
                    rightBorder = _c - 1;
                }
            }
            for (int c = 0; c < cl; c ++) {
                res = Math.max(res, (right[r][c] - left[r][c] + 1) * up[r][c]);
            }
        }
        return res;
    }
}


// @date Apr 3 2020
// @solution dp 3
// class Solution {
//     public int maximalRectangle(char[][] matrix) {
//         if (matrix.length == 0) return 0;
//         int rl = matrix.length, cl = matrix[0].length;
//         int[] left = new int[cl], right = new int[cl], up = new int[cl];
//         Arrays.fill(right, cl - 1);
//         int res = 0;
//         for (int r = 0; r < rl; r ++) {
//             int leftBorder = 0, rightBorder = cl - 1;
//             for (int c = 0; c < cl; c ++) {
//                 if (matrix[r][c] == '1') {
//                     up[c] = up[c] + 1;
//                     left[c] = Math.max(left[c], leftBorder);
//                 } else {
//                     up[c] = 0;
//                     left[c] = 0;
//                     leftBorder = c + 1;
//                 }
//                 int _c = cl - 1 - c;
//                 if (matrix[r][_c] == '1') {
//                     right[_c] = Math.min(right[_c], rightBorder);
//                 } else {
//                     right[_c] = cl - 1;
//                     rightBorder = _c - 1;
//                 }
//             }
//             for (int c = 0; c < cl; c ++) {
//                 res = Math.max(res, (right[c] - left[c] + 1) * up[c]);
//             }
//         }
//         return res;
//     }
// }
// @lc code=end

