/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
// 迭代
// @date Mar 02 2020
// class Solution {
//     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         ListNode head = new ListNode(Integer.MIN_VALUE);

//         ListNode node = head;
//         while(l1 != null && l2 != null) {
//             if (l1.val <= l2.val){
//                 node.next = l1;
//                 l1 = l1.next;
//             } else {
//                 node.next = l2;
//                 l2 = l2.next;
//             }
//             node = node.next;
//         }
//         node.next = l1 != null ? l1 : l2;
//         return head.next;
//     }
// }

// 递归
// @date Mar 02 2020
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
// @lc code=end

