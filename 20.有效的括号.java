import java.util.*;
/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
// class Solution {
//     public boolean isValid(String s) {
//         if (s.isEmpty())
//             return true;
        
//         Stack<Character> stack = new Stack<Character>(); 
//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);
//             if (c == '{')
//                 stack.push('}');
//             else if (c == '(')
//                 stack.push(')');
//             else if (c == '[')
//                 stack.push(']');
//             else if (stack.empty() || c != stack.pop())
//                 return false;
//         }
        
//         return stack.empty();
//     }
// }

// 栈
// @date Mar 03 2020
// class Solution {
//     public boolean isValid(String s) {
//         if (s.isEmpty()) return true;
//         Stack<Character> stack = new Stack<>();
//         for (int i = 0; i < s.length(); i ++) {
//             if (s.charAt(i) == '(') 
//                 stack.push(')');
//             else if (s.charAt(i) == '[')
//                 stack.push(']');
//             else if (s.charAt(i) == '{')
//                 stack.push('}');
//             else if (stack.empty() || s.charAt(i) != stack.pop())
//                 return false;
//         }
//         return stack.empty();
//     }
// }

// @date Mar 03 2020
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>(){{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c))
                stack.push(c);
            else if (stack.empty() || map.get(stack.pop()) != c)
                return false;
        }
        return stack.empty();
    }
}

// @lc code=end

class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int p = m-- + n -- - 1;
        while (m > 0 && n > 0) 
            A[p] = A[m] > B[n] ? A[m--] : B[n--];
        
        if (n > 0) 
            System.arraycopy(B, 0, A, 0, n - 1);
        
    }
}