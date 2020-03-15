/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        ListNode prev = dummy, end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k; i++) {
                if (end == null) break;
                end = end.next;
            }
            if (end == null) break;
            ListNode _head = prev.next;
            ListNode nextGroup = end.next;
            end.next = null;
            prev.next = reverse(_head);
            _head.next = nextGroup;
            prev = _head;
            end = _head;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}
// @lc code=end

