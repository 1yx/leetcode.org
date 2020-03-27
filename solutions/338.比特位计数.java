/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
// @solution dp
// class Solution {
//     public int[] countBits(int num) {
//         int[] res = new int[num + 1];

//         for (int pot = 1; pot <= num; pot <<= 1) // power of two
//             for (int diff = 0; diff < pot && diff <= num - pot; diff ++)
//                 res[pot + diff] = ans[diff] + 1;
        
//         return res;
//     }
// }
// class Solution {
//     public int[] countBits(int num) {
//         int[] res = new int[num + 1];
//         for (int i = 1; i <= num; i ++) 
//             res[i] = ans[i >> 1] + (i & 1);
//         return res;
//     }
// }
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1] ;
        for (int i = 1; i <= num; i ++)
            res[i] = res[i & (i - 1)] + 1;
        return res;
    }
}
// @lc code=end

