/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
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
// 快慢指针
// class Solution {
//     public boolean hasCycle(ListNode head) {
//         if (head == null || head.next == null) return false;
//         ListNode fast = head.next;
//         ListNode slow = head;
//         while(fast != slow) {
//             if (fast == null || fast.next == null) {
//                 return false;
//             }
//             fast = fast.next.next;
//             slow = slow.next;
//         }
//         return true;
//     }
// }

// 链表
// @date Mar 02 2020
// class Solution {
//     public boolean hasCycle(ListNode head) {
//         Set<ListNode> seen = new HashSet<>();
//         while (head != null) {
//             if (seen.contains(head)) return true;
//             seen.add(head);
//             head = head.next;
//         }
//         return false;
//     }
// }

// @date Mar 02 2020
class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head.next, slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
    
}
// @lc code=end

