/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
// class Solution {
//     public int mySqrt(int x) {
//         if (x < 2) return x;
//         long left = 1, right = x / 2, pivot;

//         while (left <= right) {
//             pivot = left + (right - left) / 2;
//             if (pivot * pivot > x)
//                 right = pivot - 1;
//             else // no need determine == x, cause return the right 
//                 left = pivot + 1;
//         }
//         return (int)right;
//     }
// }

// 二分
// @date Mar 07 2020
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
        return (int) right;
    }
}
// @lc code=end


