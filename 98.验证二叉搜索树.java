import java.util.*;
/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

import javax.swing.tree.TreeNode;

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return dfs(root, java.lang.Long.MIN_VALUE, java.lang.Long.MAX_VALUE);
//     }
//     private boolean dfs(TreeNode root, long min, long max) {
//         return (root == null) || root.val > min && root.val < max && dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
//     }
// }

// one-line solution
// 相当于中序遍历，在到达自身时，判断上个遍历到的元素和自己的大小
// 二叉搜索树的中序遍历是递增的
// class Solution {
//     long lastVal = Long.MIN_VALUE;
//     public boolean isValidBST(TreeNode root) {
//         return (root == null) || (isValidBST(root.left) && (lasVal < (lasVal = root.val)) && isValidBST(root.right));
//     }
// }

// dfs; preorder
// @date Mar 05 2020
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
//     }
//     boolean dfs(TreeNode root, long lower, long upper) {
//         if (root == null) return true;
//         if (root.val <= lower) return false;
//         if (root.val >= upper) return false;
//         if (!dfs(root.right, root.val, upper)) return false; // @important right first
//         if (!dfs(root.left, lower, root.val)) return false;
//         return true;
//     }
// }

// dfs with stack; preorder 
// @date Mar 06 2020
// class Solution {
//     Stack<TreeNode> st = new Stack<>();
//     Stack<Integer> upperList = new Stack<>(), 
//         lowerList = new Stack<>();
        
//     public boolean isValidBST(TreeNode root) {
//         Integer lower = null, upper = null, val;
//         update(root, lower, upper);
//         while (!st.empty()) {
//             root = st.pop();
//             lower = lowerList.pop();
//             upper = upperList.pop();
            
//             if (root == null) continue;
//             val = root.val;
//             if (lower != null && val <= lower) return false;
//             if (upper != null && val >= upper) return false;

//             update(root.right, val, upper); // @important right first
//             update(root.left, lower, val);
//         }
//         return true;
//     }

//     void update(TreeNode root, Integer lower, Integer upper) {
//         st.push(root);
//         lowerList.push(lower);
//         upperList.push(upper);
//     }
// }

// dfs with stack; inorder
// @date Mar 06 2020
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         Stack<TreeNode> st = new Stack<>();
//         long inorderVal = Long.MIN_VALUE;
        
//         while (!st.empty() || root != null) {
//             while(root != null) {
//                 st.push(root);
//                 root = root.left;
//             }
//             root = st.pop();
//             if (root.val <= inorderVal) return false;
//             inorderVal = (long)root.val;
//             root = root.right;
//         }
//         return true;
//     }
// }

// dfs; inorder;
// same as the one line solution
// @date Mar 06 2020
// class Solution {
//     long lastNodeVal = Long.MIN_VALUE;
//     public boolean isValidBST(TreeNode root) {
//         return dfs(root);
//     }
//     boolean dfs(TreeNode node) {
//         if (node == null)
//             return true;
        
//         if (!dfs(node.left))
//             return false;
        
//         if (node.val <= lastNodeVal) 
//             return false;
//         lastNodeVal = (long) node.val;

//         if (!dfs(node.right))
//             return false;

//         return true;
//     }
// }

class Solution {
    long lastNodeVal = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        
        if (!isValidBST(root.left))
            return false;
        
        if (root.val <= lastNodeVal) 
            return false;
        lastNodeVal = (long) root.val;

        if (!isValidBST(root.right))
            return false;

        return true;
    }
}

// bfs with queue;
// class Solution {
//     Queue<TreeNode> queue = new LinkedList<>();
//     Queue<Integer> upperList = new LinkedList<>(), 
//         lowerList = new LinkedList<>();
        
//     public boolean isValidBST(TreeNode root) {
//         Integer lower = null, upper = null, val;
//         update(root, lower, upper);
//         while (!queue.isEmpty()) {
//             root = queue.poll();
//             lower = lowerList.poll();
//             upper = upperList.poll();
//             if (root == null) continue;
//             val = root.val;
//             if (lower != null && val <= lower) return false;
//             if (upper != null && val >= upper) return false;
//             update(root.left, lower, val);
//             update(root.right, val, upper);
//         }
//         return true;
//     }

//     void update(TreeNode root, Integer lower, Integer upper) {
//         queue.offer(root);
//         lowerList.offer(lower);
//         upperList.offer(upper);
//     }
// }
// @lc code=end
