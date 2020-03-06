import java.util.Queue;

import javax.swing.tree.TreeNode;

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
class Solution {
    public int minDepth(TreeNode root) {
            
    }
    int dfs (TreeNode node, int, depth, int res) {
        if (node == null) return res;
        if (node.left == null && node.right == null)
            return Math.min(res, depth);
                
        dfs(root.left, depth + 1, res);
        dfs(root.right, depth + 1, res);
    }
}

// dfs with stack
// class Solution {
//     public int minDepth(TreeNode root) {

//     }
// }
// @lc code=end

