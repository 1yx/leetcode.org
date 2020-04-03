/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

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
// @solution stack 1
// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         Stack<Integer> stack = new Stack<>();
//         stack.push(-1);
//         int maxArea = 0;
//         for (int i = 0; i < heights.length; i ++) {
//             while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) 
//                 maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            
//             stack.push(i);
//         }

//         while (stack.peek() != -1) {
//             maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
//         }
//         return maxArea;
//     }
// }

// @date Mar 03 2020
// hights 6 7 5      2    4 5 9 3
// i      0 1 1 1  2 2  3 4 5 6 6 6  6  7 7  7  8 9
// s.peek 0 1 0 -1 2 -1 3 4 5 6 5 4  3  7 3  -1 8
// area   0 0 7 12 0 15 0 0 0 0 9 10 12 0 12 16 0
// @solution stack 2
// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         Stack<Integer> stack = new Stack<>();
//         int res = 0;
//         for (int i = 0; i <= heights.length; i ++) 
//             if (stack.isEmpty() || (i == heights.length ? 0 : heights[i]) >= heights[stack.peek()])
//                 stack.push(i);
//             else
//                 res = Math.max(res, heights[stack.pop()] * (stack.isEmpty() ? i-- : --i - stack.peek()));
//         return res;
//     }
// }

// @date Apr 2 2020
// @solution dfs bisection divide&conquer
// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         return dfs(heights, 0, heights.length - 1);
//     }
//     int dfs(int[] heights, int start, int end) {
//         if (start > end) return 0;
//         int min = start;
//         for (int i = start + 1; i <= end; i ++)
//             if (heights[i] < heights[min])
//                 min = i;
//         int left  = dfs(heights, start, min - 1);
//         int right = dfs(heights, min + 1, end);
//         int flat  = heights[min] * (end - start + 1);
//         return Math.max(flat, Math.max(left, right));
//     }
// }

// TODO
// 线状树
// also see: https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28941/segment-tree-solution-just-another-idea-onlogn-solution
// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         SegTreeNode root = buildSegmentTree(heights,0,heights.length-1);
//         return largestRectangleArea(heights,root,0,heights.length-1);
//     }

//     public int largestRectangleArea(int[] heights, SegTreeNode root,int start,int end) {
//         if(end<start)return 0;
//         if(end==start)return heights[start];
//         int minIndex = query(root,heights,start,end);
//         int min = heights[minIndex];
//         int ans = Math.max(largestRectangleArea(heights,root,start,minIndex-1),largestRectangleArea(heights,root,minIndex+1,end));
//         return Math.max(ans,min*(end-start+1));
//     }
//     class SegTreeNode {
//         int start;
//         int end;
//         int min;
//         SegTreeNode left;
//         SegTreeNode right;
//         SegTreeNode(int start, int end){
//             this.start = start;
//             this.end = end;
//         }
//     }

//     public SegTreeNode buildSegmentTree(int[] heights,int start, int end){
//         if(start > end) return null;
//         SegTreeNode root = new SegTreeNode(start,end);
//         if(start == end){
//             root.min = start;
//         } else {
//           int middle = (start + end) / 2;
//           root.left = buildSegmentTree(heights,start,middle);
//           root.right = buildSegmentTree(heights,middle+1,end);
//           root.min = heights[root.right.min] < heights[root.left.min] ? root.right.min : root.left.min;
//         }
//         return root;
//     }

//     public int query(SegTreeNode root,int[] heights,int start,int end){
//         if(root == null || end < root.start || start > root.end)return -1;
//         if(start <= root.start && end >= root.end)return root.min;
//         int leftMin = query(root.left,heights,start,end);
//         int rightMin = query(root.right,heights,start,end);
//         if(leftMin == -1) return rightMin;
//         if(rightMin == -1) return leftMin;
//         return heights[leftMin] < heights[rightMin] ? leftMin : rightMin;
//     }
// }

// @lc code=start
class Solution {
    public int largestRectangleArea (int[] heights) {
        int res = 0, len = heights.length;
        for (int i = 0 ; i < len; i ++) {
            if (i + 1 < len && heights[i] < heights[i + 1])
                continue;
            for (int j = i, min = heights[i]; j >= 0; j --) {
                min = Math.min(min, heights[j]);
                res = Math.max(res, min * (i - j + 1));
            }
        }
        return res;
    }
}
// @lc code=end

