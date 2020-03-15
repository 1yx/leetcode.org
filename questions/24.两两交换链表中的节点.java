/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
// @date Mar 02 2020
// class Solution {
//     public ListNode swapPairs(ListNode head) {
//         if (head == null || head.next == null) return head;
//         ListNode first = head, second = head.next;
//         first.next = swapPairs(second.next);
//         second.next = first;
//         return second;
//     }
// }

// 迭代
// @date 02 Mar 2020
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(Integer.MIN_VALUE);
        temp.next = head;
        ListNode prev = temp;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;
            
            prev = first;
            head = first.next;
        }
        return temp.next;
    }
}
// @lc code=end

