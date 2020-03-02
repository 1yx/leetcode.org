/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
// @date Feb 13 2020
/* class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        var sol1 = 1;
        var sol2 = 2;
        var sol3 = 3;
        for (var i = 2; i < n; ++i) {
            sol3 = sol1 + sol2;
            sol1 = sol2;
            sol2 = sol3;
        }
        return sol3;
    }
} */
// 缓存递归
// @date Feb 20 2020
class Solution {
    // an int is a primitive type and cannot be null
    public Integer[] sol = new Integer[100];
    public int climbStairs(final int i) {
        sol[1] = 1;
        sol[2] = 2;
        if (i <= 2) return sol[i];
        if (sol[i - 1] == null) sol[i - 1] = climbStairs(i - 1);
        if (sol[i - 2] == null) sol[i - 2] = climbStairs(i - 2);
        return sol[i-1] + sol[i-2];
    }
}
// @lc code=end

