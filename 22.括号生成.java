import java.util.*;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start

// 递归
// @date Feb 20 2020
class Solution {
    private List<String> ans;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<String>();
        addParenthesis(0, 0, n, "");
        return ans;
    }

    private void addParenthesis(int left, int right, int max, String str) {
        // terminator
        if (left == max && right == max){
            ans.add(str);
            return;
        }
        if (left + 1 <= max)
            addParenthesis(left + 1, right, max, str + "(");
        if (right < left)
            addParenthesis(left, right + 1, max, str + ")");
    }
}

// @lc code=end
