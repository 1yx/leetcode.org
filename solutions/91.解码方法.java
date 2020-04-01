/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// class Solution {
//     public int numDecodings(String s) {
//         int l = s.length();
//         int[][] dp = new int[l + 1][3];
//         dp[1][1] = singleDigit(s, 1) ? 1 : 0;
//         if (l == 1) return dp[1][1];
//         dp[2][1] = singleDigit(s, 2) ? dp[1][1] : 0;
//         dp[2][2] = doubleDigit(s, 2) ? 1 : 0;
//         if (l == 2) return dp[2][1] + dp[2][2];
//         for (int i = 3; i <= l; i ++) {
//             dp[i][1] = singleDigit(s, i) ? dp[i - 1][1] + dp[i - 1][2] : 0;
//             dp[i][2] = doubleDigit(s, i) ? dp[i - 2][1] + dp[i - 2][2] : 0;
//         }
//         return dp[l][1] + dp[l][2];
//     }
//     boolean singleDigit (String s, int i) {
//         int n = Integer.parseInt(s.substring(i - 1, i));
//         return n > 0;
//     }
//     boolean doubleDigit (String s, int i) {
//         int n = Integer.parseInt(s.substring(i - 2, i));
//         return n <= 26 && n >= 10;
//     }
// }

// @date Apr 1 2020
// class Solution {
//     public int numDecodings(String str) {
//         if (str == null) return 0;
//         char[] digits = str.toCharArray();
//         int len = digits.length;
//         int[] dp = new int[len + 1];
//         dp[0] = 1;
//         dp[1] = (digits[0] == '0') ? 0 : 1;
//         for (int i = 2; i <= len; i ++) {
//             int front = digits[i - 2] - '0', curr = digits[i - 1] - '0';
//             int ddn = front * 10 + curr; // double digit number
//             if (ddn == 0 || (ddn > 26 && curr == 0)) return 0;
//             if (front == 0 || ddn > 26)
//                 dp[i] = dp[i - 1];
//             else if (curr == 0)
//                 dp[i] = dp[i - 2];
//             else 
//                 dp[i] = dp[i - 1] + dp[i - 2];
//         }
//         return dp[len];
//     }
// }

// @lc code=start
// @date Apr 1 2020
// @solution dp 1
class Solution {
    public int numDecodings(String s) {
        char[] digits = s.toCharArray();
        int len = digits.length;
        if (digits[0] == '0') return 0;
        int[] dp = new int[len + 1];
        dp[0] = dp[1] = 1;
        for (int i = 1; i < len; i ++) {
            if (digits[i] == '0') {
                if (digits[i - 1] != '1' && digits[i - 1] != '2') return 0;
                dp[i + 1] = dp[i - 1];
            } else if (digits[i - 1] == '1' || digits[i - 1] == '2' && digits[i] <= '6')
                dp[i + 1] = dp[i] + dp[i - 1];
            else
                dp[i + 1] = dp[i];
        }
        return dp[len];
    }
}

// @date Apr 1 2020
// @solution dp 2
// class Solution {
//     public int numDecodings(String s) {
//         char[] digits = s.toCharArray();
//         if (digits[0] == '0') return 0;
//         int prev = 1, curr = 1;
//         for (int i = 1; i < digits.length; i ++) {
//             int _curr = curr;
//             if (digits[i] == '0') {
//                 if (digits[i - 1] != '1' && digits[i - 1] != '2') return 0;
//                 curr = prev;
//             } else if (digits[i - 1] == '1' || digits[i - 1] == '2' && digits[i] <= '6')
//                 curr = curr + prev;
//             prev = _curr;
//         }
//         return curr;
//     }
// }

// @lc code=end

