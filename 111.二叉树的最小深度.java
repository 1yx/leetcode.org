/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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

/// bfs
// @date Mar 06 2020
// class Solution {
//     public int minDepth(TreeNode root) {
//         if (root == null) return 0;
//         Queue<TreeNode> queue = new LinkedList<>();
//         int step = 0;
//         queue.add(root);
//         while (!queue.isEmpty()) {
//             step ++;
//             for (int i = queue.size(); i > 0; i --) {
//                 TreeNode node = queue.poll();
//                 if (node.left == null && node.right == null)
//                     return step;
//                 if (node.left != null) queue.add(node.left);
//                 if (node.right != null) queue.add(node.right);
//             }
//         }
//         return step;
//     }
// }

// recursion
// @date Mar 06 2020
// class Solution {
//     public int minDepth(TreeNode root) {
//         if (root == null) return 0;
//         if (root.left == null && root.right == null) return 1;
//         int min = Integer.MAX_VALUE;
//         if (root.left != null) 
//             min = Math.min(min, minDepth(root.left));
//         if (root.right != null)
//             min = Math.min(min, minDepth(root.right));
//         return min + 1;
//     }
// }

// dfs
// class Solution {
//     int res = Integer.MAX_VALUE;
//     public int minDepth(TreeNode root) {
//         if (root == null) return 0;
//         dfs(root, 1);
//         return res;
//     }
//     void dfs (TreeNode node, int depth) {
//         if (node == null) return;
//         if (node.left == null && node.right == null) {
//             res = Math.min(res, depth);
//             return;
//         }
//         dfs(node.left, depth + 1);
//         dfs(node.right, depth + 1);
//     }
// }

// dfs with stack
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0; 
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> depthSt = new Stack<>();
        st.push(root);
        depthSt.push(1);
        int min = Integer.MAX_VALUE;

        while(! st.empty()) {
            TreeNode node = st.pop();
            int depth = depthSt.pop();
            if (node.left == null && node.right == null) {
                min = Math.min(min, depth);
            }
            if (node.right != null) {
                st.push(node.right); // @important push right to stack first
                depthSt.push(depth + 1);
            }
            if (node.left != null) {
                st.push(node.left);
                depthSt.push(depth + 1);
            }
        }
        return min;
    }
}
// @lc code=end

