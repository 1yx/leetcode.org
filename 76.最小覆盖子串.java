import java.util.*;
/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> dp = new HashMap<>();
        for (char c: t.toCharArray())
            dp.put(c, 1);
        int left = 0, count = 0, maxLength = s.length() + 1, start = left;
        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (dp.get(c) >= 0) { // -1 ?
                dp.put(c, dp.get(c) - 1);
                count ++;
            }
                
        }
    }
}
// @lc code=end

