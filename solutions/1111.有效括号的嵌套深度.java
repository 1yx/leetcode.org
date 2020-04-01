/*
 * @lc app=leetcode.cn id=1111 lang=java
 *
 * [1111] 有效括号的嵌套深度
 */

// @lc code=start
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        int i = 0;
        for (char c : seq.toCharArray()) {
            res[i++] = c == '(' ? i & 1 : (i + 1) & 1;
        }
        return res;
    }
}
// @lc code=end

