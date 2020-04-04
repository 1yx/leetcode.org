/*
 * @lc app=leetcode.cn id=818 lang=java
 *
 * [818] 赛车
 */


// @date Apr 3 2020
// @solution dp 1
// class Solution {
//     public int racecar(int target) {
//         int[] dp = new int[target + 1];
//         for (int i = 1; i <= target; i ++) {
//             dp[i] = Integer.MAX_VALUE;
//             for (int aPow = 1, aVal = 1; aVal < 2 * i; aVal = (1 << ++aPow) - 1) {
//                 if (aVal == i) {
//                     dp[i] = aPow;
//                     continue;
//                 }
//                 if (aVal > i) {
//                     dp[i] = Math.min(dp[i], dp[aVal - i] + 1 + aPow);
//                     continue;
//                 }
//                 // aVal < i
//                 for (int rPow = 0, rVal = 0; rPow < aPow; rVal = (1 << ++rPow) - 1) {
//                     dp[i] = Math.min(dp[i], dp[i + rVal - aVal] + 1 + aPow + 1 + rPow);
//                 }
//             }
//         }
//         return dp[target];
//     }
// }

// @lc code=start
// @date Apr 3 2020
// @solution dp 2
class Solution {
    public int racecar(int target) {
        int[] dp = new int[target + 3];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; dp[1] = 1; dp[2] = 4;// aarr
        for (int i = 3; i <= target; ++i) {
            int aPow = 32 - Integer.numberOfLeadingZeros(i);
            int aVal = (1 << aPow) - 1;
            if (i == aVal) {
                dp[i] = aPow;
                continue;
            }
            for (int rPow = 0; rPow < aPow - 1; rPow ++)
                dp[i] = Math.min(dp[i], dp[i - (1 << (aPow - 1)) + (1 << rPow)] + aPow + 1 + rPow);
            if (aVal - i < i)
                dp[i] = Math.min(dp[i], dp[aVal - i] + 1 + aPow);
        }
        return dp[target];  
    }
}
// @lc code=end

