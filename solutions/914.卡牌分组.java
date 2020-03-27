/*
 * @lc app=leetcode.cn id=914 lang=java
 *
 * [914] 卡牌分组
 */

// @lc code=start
// greatest common divisor
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) return false;
        int[] cnt = new int[10000];
        for (int i : deck) 
            cnt[i] ++;
        int gcd = 0;
        for (int i = 0 ; i < 10000; i ++) {
            if (cnt[i] == 0) continue;
            gcd = calculator(gcd, cnt[i]);
            if (gcd == 1) return false;
        }
        return true;
    }
    int calculator(int a, int b) {
        return (b == 0) ? a : calculator(b, a % b);
    }
}
// @lc code=end

