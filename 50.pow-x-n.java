/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
// 快速幂
// class Solution {
//     public double myPow(double x, int n) {
//         long _n = n;
//         if (_n < 0) {
//             _n = -_n;
//             x = 1/x;
//         }
//         return dc(x, _n);
//     }

//     public double dc(double x, long n) {
//         if (n == 0) 
//             return 1.0;
//         double half = dc(x, n / 2);
//         return n % 2 == 1 ? half * half * x : half * half;
//     }
// }

// 快速幂 递归
// @date Mar 07 2020
// class Solution {
//     public double myPow(double x, int n) {
//         long _n = n;
//         if (n < 0) {
//             _n = -_n;
//             x = 1 / x;
//         }
//         return divideconquer(x, _n);
            
//     }
//     double divideconquer(double x, long n) {
//         if (n == 0)
//             return 1.0;
//         double half = divideconquer(x, n / 2);
//         return n % 2 == 1 ? half * half * x : half * half;
//     }
// }

// 快速幂 迭代
// @date Mar 07 2020
class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        long _n = n;
        if (n < 0) {
            _n *= -1;
            x = 1 / x;
        }
        for (long i = _n; i > 0; i /= 2) {
            if (i % 2 == 1)
                res *= x;
            x *= x;
        }
        return res;
    }
}
// @lc code=end

