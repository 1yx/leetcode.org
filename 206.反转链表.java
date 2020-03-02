/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
// 递归
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         if(head == null || head.next == null) return head;
//         ListNode p = reverseList(head.next);
//         head.next.next = head;
//         head.next = null;
//         return p;
//     }
// }

// @date Mar 02 2020
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         if (head == null || head.next == null) return head;
//         ListNode tmp = reverseList(head.next);
//         head.next.next = head;
//         head.next = null;
//         return tmp;
//     }
// }

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next; // 2 // null
            curr.next = prev; // null // 1
            prev = curr; // 1 // 2
            curr = temp; // 2 // null
        }
        return prev;
    }
}
// @lc code=end

