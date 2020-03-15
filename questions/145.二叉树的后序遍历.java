import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         postOrder(root, ans);
//         return ans;
//     }

//     public void postOrder(TreeNode root, List<Integer> ans) {
//         if (root == null) return;
//         if (root.left != null) postOrder(root.left, ans);
//         if (root.right != null) postOrder(root.right, ans);
//         ans.add(root.val);
//     }
// }

// @date Mar 05 2020
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }
    void postOrder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (root.left != null) postOrder(root.left, res);
        if (root.right != null) postOrder(root.right, res);
        res.add(root.val);
    }
}
// @lc code=end

