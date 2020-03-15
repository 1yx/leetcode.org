/*
 * @lc app=leetcode.cn id=1103 lang=java
 *
 * [1103] 分糖果 II
 */

// @lc code=start
class Solution {
    public int[] distributeCandies(int candies, int numPeople) {
        int fairRound = (int)(Math.sqrt(2 * candies + 0.25) - 0.5);
        int fullRows = fairRound / numPeople;
        int partRows = fairRound % numPeople;
        int[] res = new int[numPeople];
        for (int i = 0; i < numPeople; i ++) {
            res[i] = (i + 1) * fullRows + numPeople * (int)(fullRows * (fullRows - 1) * 0.5);
            if (i < partRows) 
                res[i] += i + 1 + numPeople * fullRows;
            else if (i == partRows)
                res[i] += candies - (int)(fairRound * (fairRound + 1) * 0.5);
        }
        return res;
    }
}

// @lc code=end

