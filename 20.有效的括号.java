/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if (s.isEmpty())
            return true;
        
        Stack<Character> stack = new Stack<Character>(); 
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{')
                stack.push('}');
            else if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (stack.empty() || c != stack.pop())
                return false;
        }
        
        return stack.empty();
    }
}
// @lc code=end

