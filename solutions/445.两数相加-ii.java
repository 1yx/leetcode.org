import java.util.Stack;
/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
        for (;l1 != null; l1 = l1.next)
            s1.push(l1.val);
        for (;l2 != null; l2 = l2.next) 
            s2.push(l2.val);
        ListNode res = null;
        for (int digit = 0; !s1.empty() || !s2.empty() || digit > 0; digit /= 10) {
            digit += s1.empty() ? 0 : s1.pop();
            digit += s2.empty() ? 0 : s2.pop();
            ListNode curr = new ListNode(digit % 10);
            curr.next = res;
            res = curr;
        }
        return res;
    }
}
// @lc code=end

