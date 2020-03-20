import java.util.*;
/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        // asscii 97+(i-2)*3...97+(i-2)*3+2
        // if i==9 ==7 97+(i-2)*3+3.
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        dc(digits, 0, new StringBuilder(digits.length()), res);
        return res;
    }
    private void dc (String digits, int i, StringBuilder sb, List<String> res) {
        if (i == digits.length()){
            res.add(sb.toString());
            return;
        }
        int code = Integer.parseInt(digits.substring(i, ++i));
        for(var j = 0; j < 4; j++) {
            if (code > 1) {
                char c = (char)(97+(code-2)*3+j);
                if (code > 7) c++;
                dc(digits, i, sb.append(c), res);
                sb.deleteCharAt(sb.length() - 1);
            }
                
            if ((code != 9 && code != 7) && j == 2) j = 3;
        }
    }
}
// @lc code=end

