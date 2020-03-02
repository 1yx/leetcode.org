/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] a) {
        int max = 0;
        for(int i = 0, j = a.length-1; i < j;) {
            int minHeight = a[i] < a[j] ? a[i++] : a[j--];
            int area = (j - i + 1) * minHeight;
            max = Math.max(max, area);
        }
        return max;
    }
}
// @lc code=end

