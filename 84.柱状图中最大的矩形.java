import java.util.Stack;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         Stack<Integer> stack = new Stack<>();
//         stack.push(-1); // 被视为下标0的上一个下标，用于计算矩形的宽。
//         int maxArea = 0;
//         for (int i = 0; i < heights.length; ++ i) {
//             while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
//                 maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
//             }
//             stack.push(i);
//         }
//         while(stack.peek() != -1) {
//             maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
//         }
//         return maxArea;
//     }
// }

// @date Mar 03 2020
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i ++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) 
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            
            stack.push(i);
        }

        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }
}
// @lc code=end

