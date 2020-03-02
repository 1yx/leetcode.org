import java.util.*;
/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
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
// bfs with queue
// @date Feb 26 2020
/* class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new LinkedList<>();

        if (root == null) return res;

        // offer is equal to add in linkedlist
        // list use add, queue use offer
        queue.offer(root);
        while (! queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new LinkedList<Integer>();
            for (int i = 0; i < size; i ++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                level.add(queue.poll().val);
            }
            res.add(level);
        }
        return res;
    }
} */

// dfs with recursion
// @date Feb 26 2020
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(res, root, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, TreeNode root, int depth) {
        if (root == null) return;
        if (depth >= res.size()) 
            res.add(new LinkedList<>());

        res.get(depth).add(root.val);
        dfs(res, root.left, depth+1);
        dfs(res, root.right, depth+1);
    }
}
// @lc code=end

