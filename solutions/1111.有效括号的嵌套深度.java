/*
 * @lc app=leetcode.cn id=1111 lang=java
 *
 * [1111] 有效括号的嵌套深度
 */

//左括号 ( 的下标编号与嵌套深度的奇偶性相反
// 下标编号为偶数的 (，其嵌套深度为奇数，分配给 A
// 下标编号为奇数的 (，其嵌套深度为偶数，分配给 B
// class Solution {
//     public int[] maxDepthAfterSplit(String seq) {
//         int[] res = new int[seq.length()];
//         int i = 0;
//         for (char c : seq.toCharArray()) {
//             res[i++] = c == '(' ? i & 1 : (i + 1) & 1;
//         }
//         return res;
//     }
// }

// @lc code=start
// '(' 与 ')' 的 ascii 本身就是一奇一偶
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        int i = 0;
        for (char c : seq.toCharArray()) 
            res[i ++] = (c ^ i) & 1;
        return res;
    }
}


// @date Apr 4 2020
// @solution stack 1
// class Solution {
//     public int[] maxDepthAfterSplit(String seq) {
//         int[] res = new int[seq.length()];
//         Stack<Integer> stack = new Stack<>();
//         int i = 0;
//         for (char c : seq.toCharArray()) {
//             if (c == '(') {
//                 stack.push(i);
//                 res[i++] = stack.size() & 1;
//             } else if (c == ')') {
//                 res[i++] = stack.size() & 1;
//                 stack.pop();
//             }
//         }
//         return res;
//     }
// }

// @date Apr 4 2020
// @solution stack 2
// class Solution {
//     public int[] maxDepthAfterSplit(String seq) {
//         int[] res = new int[seq.length()];
//         int depth = 0, i = 0;
//         for (char c : seq.toCharArray()) {
//             if (c == '(') {
//                 depth ++;
//                 res[i ++] = depth & 1;
//             } else if (c == ')') {
//                 res[i ++] = depth & 1;                
//                 depth --;
//             }
//         }
//         return res;
//     }
// }


// @lc code=end

