/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        long left = 1, right = x / 2, pivot;

        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (pivot * pivot > x)
                right = pivot - 1;
            else 
                left = pivot + 1;
        }
        return (int)right;
    }
}
// @lc code=end


