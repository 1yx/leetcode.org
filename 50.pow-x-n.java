/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        long _n = n;
        if (_n < 0) {
            _n = -_n;
            x = 1/x;
        }
        return dc(x, _n);
    }

    public double dc(double x, long n) {
        if (n == 0) 
            return 1.0;
        double half = dc(x, n / 2);
        return n % 2 == 1 ? half * half * x : half * half;
    }
}
// @lc code=end

