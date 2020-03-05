/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
//     public boolean isValidBST(TreeNode root) {
//         return isValid(root, java.lang.Long.MIN_VALUE, java.lang.Long.MAX_VALUE);
//     }
//     private boolean isValid(TreeNode root, long min, long max) {
//         if (root == null) return true;
//         if (root.val <= min || root.val >= max) return false;
//         return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
//     }
// }
//[10,5,15,3,7,13,17,1,4,6,8,12,14,16,18]

// one-line solution
// 相当于中序遍历，在到达自身时，判断上个遍历到的元素和自己的大小
// 二叉搜索树的中序遍历是递增的
// class Solution {
//     long min = Long.MIN_VALUE;
//     public boolean isValidBST(TreeNode root) {
//         return (root == null) || (isValidBST(root.left) && (min < (min = root.val)) && isValidBST(root.right));
//     }
// }

// dfs preorder
// @date Mar 05 2020
class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    boolean dfs(TreeNode root, int lower, int upper) {

    }
    
}
// class Solution {
//     public boolean isValidBST(TreeNode root) {
        
//     }
// }
// class Solution {
//     public boolean isValidBST(TreeNode root) {
        
//     }
// }
// class Solution {
//     public boolean isValidBST(TreeNode root) {
        
//     }
// }
// class Solution {
//     public boolean isValidBST(TreeNode root) {
        
//     }
// }
// @lc code=end

