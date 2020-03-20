/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        long left = 1, right = num / 2, pivot;
        long n;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            n = pivot * pivot;
            if (n == num)
                return true;
            else if (n < num)
                left = pivot + 1;
            else 
                right = pivot - 1;
        }
        return false;
    }
}
// @lc code=end

