/*
 * @lc app=leetcode.cn id=1013 lang=java
 *
 * [1013] 将数组分成和相等的三个部分
 */

// @lc code=start
class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        if (sum % 3 != 0) return false;
        int onethird = sum / 3, group = 0;
        sum = 0;
        for (int a : A) {
            sum += a;
            if (sum == onethird) {
                group ++;
                sum = 0;
            }
            if (group == 3)
                return true;
        }
        return false;
    }
}
// @lc code=end

