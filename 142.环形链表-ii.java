/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// 哈希表
// @date Mar 02 2020
// class Solution {
//     public ListNode detectCycle(ListNode head) {
//         Set<ListNode> set = new HashSet<>();
//         ListNode node = head;
//         while(node != null) {
//             if (set.contains(node)) return node;
//             set.add(node);
//             node = node.next;
//         }
//         return null;
//     }
// }

// Floyd算法
// @date Mar 02 2020
class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) return null;
        ListNode restart = head;
        while (restart != fast) {
            fast = fast.next;
            restart = restart.next;
        }
        return fast;
    }
}
// @lc code=end

