/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         preOrder(root, ans);
//         return ans;
//     }

//     public void preOrder(TreeNode root, List<Integer> ans) {
//         if (root == null) return ;
//         ans.add(root.val);
//         if (root.left != null) preOrder(root.left, ans);
//         if (root.right != null) preOrder(root.right, ans);
//     }
// }

// @date Mar 05 2020
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }
    void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        if (root.left != null) preOrder(root.left, res);
        if (root.right != null) preOrder(root.right, res);
    }
}
// @lc code=end

