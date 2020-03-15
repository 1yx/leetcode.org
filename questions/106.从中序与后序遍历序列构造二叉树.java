import java.util.Arrays;
/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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

// inorder = [9,3,15,20,7]
// postorder = [9,15,7,20,3]
// class Solution {
//     public TreeNode buildTree(int[] inorder, int[] postorder) {
//         if (inorder.length == 0) return null;
//         int i, l = inorder.length;
//         TreeNode root = new TreeNode(postorder[l - 1]);
//         for (i = 0; ;i ++) {
//             if (inorder[i] == root.val)
//                 break;
//         }

//         int[] li = new int[i];
//         int[] lp = new int[i];
//         System.arraycopy(inorder, 0, li, 0, i);
//         System.arraycopy(postorder, 0, lp, 0, i);
//         root.left = buildTree(li, lp);

//         int[] ri = new int[l - i - 1];
//         int[] rp = new int[l - i - 1];
//         System.arraycopy(inorder, i + 1, ri, 0, l - i - 1);
//         System.arraycopy(postorder, i, rp, 0, l - i - 1);
//         root.right = buildTree(ri, rp);

//         return root;
//     }
// }


// TODO Array.copyOfRange
// inorder = [9,3,15,20,7]
// postorder = [9,15,7,20,3]
// @date Mar 07 2020
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int i = 0, l = inorder.length;
        if (l == 0) return null;
        TreeNode root = new TreeNode(postorder[l - 1]);
        for (i = 0; ; i++) {
            if (inorder[i] == root.val)
                break;
        }
        int[] li = Arrays.copyOfRange(inorder, 0, i);
        int[] ri = Arrays.copyOfRange(inorder, i + 1, l);
        int[] lp = Arrays.copyOfRange(postorder, 0, i);
        int[] rp = Arrays.copyOfRange(postorder, i , l - 1);
        root.left = buildTree(li, lp);
        root.right = buildTree(ri, rp);
        return root;
    }
}
// @lc code=end

