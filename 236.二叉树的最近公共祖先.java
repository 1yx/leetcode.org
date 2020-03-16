/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

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
// @date Feb 21 2020
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         //recursion
//         if (root == null) return null;
//         if (root == q) return q;
//         if (root == p) return p;
//         //process logic
//         //drill down 
//         TreeNode left = lowestCommonAncestor(root.left, p, q);
//         TreeNode right = lowestCommonAncestor(root.right, p, q);

//         if (left == null) return right;
//         if (right == null) return left;
//         return root;
//         //reverse status
//     }
// }


// backtrace
// @date Mar 07 2020
// class Solution {
//     TreeNode;
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
//         bt (root, p, q);
//         return lca;
//     }

//     boolean bt (TreeNode node, TreeNode p, TreeNode q) {
//         if (node == null) return false;

//         boolean left = bt(node.left, p, q);
//         boolean right = bt(node.right, p, q);
//         boolean mid = (node == p || node == q);
//         if (mid ? (left || right) : (left && right))
//             lca = node;
//         return left || right || mid;
//     }
// }

// 迭代 parent node in hashmap
// @date Mar 07 2020
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         Stack<TreeNode> st = new Stack<>();
//         Map<TreeNode, TreeNode> map = new HashMap<>();
//         map.put(root, null);
//         st.push(root);
//         while (!map.containsKey(p) || !map.containsKey(q)) {
//             TreeNode node = st.pop();
//             if (node.left != null) {
//                 map.put(node.left, node);
//                 st.push(node.left);
//             }
//             if (node.right != null) {
//                 map.put(node.right, node);
//                 st.push(node.right);
//             }
//         }
//         Set<TreeNode> ancestors = new HashSet<>();
//         while (p != null) {
//             ancestors.add(p);
//             p = map.get(p);
//         }
//         while (!ancestors.contains(q)) {
//             q = map.get(q);
//         }
//         return q;
//     }
// }

// same as recursion
// @date Mar 07 2020
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if (root == null || root == p || root == q) return root;
//         TreeNode left = lowestCommonAncestor(root.left, p, q);
//         TreeNode right = lowestCommonAncestor(root.right, p, q);
//         return (left == null) ? right : (right == null) ? left : root;
//     }
// }
// @lc code=end

