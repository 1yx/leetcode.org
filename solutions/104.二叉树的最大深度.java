import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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

// dfs
// @date Feb 20 2020
// class Solution {
//     public int maxDepth(TreeNode root) {
//         if (root == null) return 0;
//         return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//     }
// }

// bfs
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int step = 0;
        while (!queue.isEmpty()) {
            step ++;
            for (int i = queue.size(); i > 0; i --) {
                root = queue.poll();
                if (root.left != null) queue.add(root.left);
                if (root.right != null) queue.add(root.right);
            }
        }
        return step;
    }
}
// @lc code=end

