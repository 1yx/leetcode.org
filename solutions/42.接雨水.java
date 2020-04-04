import java.util.*;
/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// class Solution {
//     public int trap(final int[] height) {
//         if (height.length < 2) return 0;
//         int ret = 0;
//         int len = height.length;
//         int[] left = new int[len];
//         int[] right = new int[len];
//         left[0] = height[0];
//         for(var i = 1; i < len; ++ i) 
//             left[i] = Math.max(height[i], left[i - 1]);
//         right[len - 1] = height[len - 1];
//         for(var i = len - 2; i >= 0; --i )
//             right[i] = Math.max(height[i], right[i + 1]);
//         for(var i = 1; i < len - 1 ; ++i) {
//             ret += Math.min(left[i], right[i]) - height[i];
//         }
//         return ret;
//     }
// }

// @date Mar 04 2020
// class Solution {
//     public int trap(int [] height) {
//         if (height == null || height.length < 3) return 0;
//         Stack<Integer> st = new Stack<Integer>();
//         int right = 0, res = 0;
//         while (right < height.length) {
//             if (st.isEmpty() || height[right] <= height[st.peek()]) {
//                 st.push(right++);
//             } else {
//                 int concave = height[st.pop()];
//                 if (!st.empty()) {
//                     int left = st.peek();
//                     int subPeak = Math.min(height[left], height[right]);
//                     int dist = right - left - 1;
//                     res += (subPeak - concave) * dist;
//                 }
//             }
//         }
//         return res;
//     }
// }

// 迭代计算每列左右最大
// 累加min(height[left], height[right]) - height[curr]
// @date Mar 04 2020
// class Solution {
//     public int trap(int[] height) {
//         int res = 0;
//         for (int i = 1; i < height.length - 1; i ++) {
//             int maxLeft = 0, maxRight = 0;
//             for (int j = i; j >= 0; j --) 
//                 maxLeft = Math.max(maxLeft, height[j]);
//             for (int j = i; j < height.length; j ++)
//                 maxRight = Math.max(maxRight, height[j]);
//             res += Math.min(maxLeft, maxRight) - height[i];
//         }
//         return res;
//     }
// }

// 使用两个数组存储每列左右最大
// 累加min(height[left], height[right]) - height[curr]
// @date Mar 04 2020
// class Solution {
//     public int trap(int[] height) {
//         if (height == null || height.length == 0) return 0;
//         int res = 0;
//         int size = height.length;
//         int[] leftHeight = new int[size],  rightHeight = new int[size];
//         leftHeight[0] = height[0];
//         for (int i = 1; i < size; i ++) 
//             leftHeight[i] = Math.max(leftHeight[i - 1], height[i]);
//         rightHeight[size - 1] = height[size - 1];
//         for (int i = size - 2; i >= 0; i --) 
//             rightHeight[i] = Math.max(rightHeight[i + 1], height[i]);
//         for (int i = 0; i < size; i ++) 
//             res += Math.min(leftHeight[i], rightHeight[i]) - height[i];
//         return res;
//     }
// }

// 使用栈的方式计算，类似匹配双括号后计算括号内的水
// 很喜欢我起的 subPeak 和 concave 两个变量名
// subPeak = min(height[left], height[right])
// concave = height[curr]
// dist = right - left - 1;
// 累加 (subPeak - concave) * dist;
// @date Mar 04 2020
// class Solution {
//     public int trap (int[] height) {
//         if (height == null || height.length == 0) return 0;
//         int res = 0;
//         Stack<Integer> st = new Stack<>();
//         int curr = 0;
//         while(curr < height.length) {
//             while (!st.empty() && height[curr] > height[st.peek()]) {
//                 int concave = height[st.pop()];
//                 if (st.empty()) break;
//                 int dist = curr - st.peek() - 1;
//                 int subPeak = Math.min(height[st.peek()], height[curr]);
//                 res += (subPeak - concave) * dist;
//             }
//             st.push(curr ++);
//         }
//         return res;
//     }
// }

// 跟上面的方法完全相同，循环条件right不变更时就是上面方法while内的while
// 远不如上述方法好理解
// 这里的arr.length < 3的判断我很喜欢
// subPeak = min(height[left], height[right])
// concave = height[curr]
// dist = right - left - 1;
// 累加 (subPeak - concave) * dist;
// @date Mar 04 2020
// class Solution {
//     public int trap(int[] height) {
//         if (height == null || height.length < 3) return 0;
//         Stack<Integer> st = new Stack<Integer>();
//         int right = 0, res = 0;
//         while (right < height.length){
//             if (st.empty() || height[right]<=height[st.peek()]){
//                 st.push(right++);
//             } else {
//                 int concave = height[st.pop()];
//                 if (! st.empty()) {
//                     int left = st.peek();
//                     int subPeak = Math.min(height[left], height[right]);
//                     int dist = (right - left - 1);
//                     res += (subPeak - concave) * dist;
//                 }
//             }
//         }
//         return res;
//     }
// }


// 双指针
// @date Mar 04 2020
// class Solution {
//     public int trap(int[] height) {
//         if (height == null || height.length < 3) return 0;
//         int leftMaxHeight = 0, rightMaxHeight = 0;
//         int left = 0, right = height.length - 1;
//         int res = 0;
//         while (left <= right) {
//             if (leftMaxHeight < rightMaxHeight) 
//                 if (height[left] >= leftMaxHeight)
//                     leftMaxHeight = height[left++];
//                 else
//                     res += leftMaxHeight - height[left++];
//             else 
//                 if (height[right] >= rightMaxHeight)
//                     rightMaxHeight = height[right--];
//                 else
//                     res += rightMaxHeight - height[right--];
            
//         }
//         return res;
//     }
// }

// 双指针
// 注意
// while (left < right) {
//     if (height[left] < height[right]) 
// 与上面
// while (left <= right) {
//     if (leftMaxHeight < rightMaxHeight) 
// 的区别，left==right的状况就是走到柱状图的最高峰
// 当用左右最高时，就要保障都走到最高峰
// @date Mar 04 2020
// class Solution {
//     public int trap(int[] height) {
//         if (height == null || height.length < 3) return 0;
//         int leftMaxHeight = 0, rightMaxHeight = 0;
//         int left = 0, right = height.length - 1;
//         int res = 0;
//         while (left < right) {
//             if (height[left] < height[right]) 
//                 if (height[left] >= leftMaxHeight)
//                     leftMaxHeight = height[left++];
//                 else
//                     res += leftMaxHeight - height[left++];
//             else 
//                 if (height[right] >= rightMaxHeight)
//                     rightMaxHeight = height[right--];
//                 else
//                     res += rightMaxHeight - height[right--];
            
//         }
//         return res;
//     }
// }


// @date Apr 4 2020
// @solution stack
// class Solution {
//     public int trap(int[] height) {
//         if (height.length == 0) return 0;
//         Stack<Integer> stack = new Stack<>();
//         int res = 0;
//         for (int i = 0; i < height.length; i ++) {
//             while (!stack.empty() && height[i] > height[stack.peek()]) {
//                 int concave = height[stack.pop()];
//                 if (stack.empty()) break;
//                 int dist = i - stack.peek() - 1;
//                 int subPeak = Math.min(height[stack.peek()], height[i]);
//                 res += (subPeak - concave) * dist;
//             }
//             stack.push(i);
//         }
//         return res;
//     }
// }

// @lc code=start
// @date Apr 4 2020
// @solution dp
class Solution {
    public int trap(int[] height) {
        int res = 0, len = height.length;
        if (len == 0) return 0;
        int[] left = new int[len],  right = new int[len];
        left[0] = height[0];
        right[len - 1] = height[len - 1];
        for (int i = 1; i < len; i ++) 
            left[i] = Math.max(left[i - 1], height[i]);
        for (int i = len - 2; i >= 0; i --) 
            right[i] = Math.max(right[i + 1], height[i]);
        for (int i = 0; i < len; i ++) 
            res += Math.min(left[i], right[i]) - height[i];
        return res;
    }
}
// @lc code=end

