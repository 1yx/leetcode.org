import java.util.*;
/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
// preorder = [3,9,20,15,7]
// inorder = [9,3,15,20,7]
// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         if(preorder.length == 0) return null;
//         TreeNode root = new TreeNode(preorder[0]);
//         int i = 0;
//         for(int val: inorder) {
//             if (val == preorder[0]) break;
//             i ++;
//         }
//         root.left = buildTree(buildArr(preorder, 1, i+1), buildArr(inorder, 0, i));
//         root.right = buildTree(buildArr(preorder, i+1, preorder.length), buildArr(inorder, i+1, inorder.length));
//         return root;
//     }
//     public int[] buildArr(int[] arr, int startIdx, int endIdx){
//         if (endIdx - startIdx <= 0) return new int[0];
//         int[] ints = new int[endIdx - startIdx];
//         for (int i = startIdx; i < endIdx; i++) {
//             ints[i - startIdx] = arr[i];
//         }
//         return ints;
//     }
// }

// same as first solution, but use System.arraycopy
// @date Mar 07 2020
// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         if (preorder.length == 0) return null;
//         TreeNode root = new TreeNode(preorder[0]);
//         int i, l = preorder.length;
//         for (i = 0; ;i ++) {
//             if (inorder[i] == root.val)
//                 break;
//         }

//         int[] lp = new int[i];
//         int[] li = new int[i];
//         System.arraycopy(preorder, 1, lp, 0, i);
//         System.arraycopy(inorder, 0, li, 0, i);
//         root.left = buildTree(lp, li);

//         int[] rp = new int[l - i - 1];
//         int[] ri = new int[l - i - 1];
//         System.arraycopy(preorder, i + 1, rp, 0, l - i - 1);
//         System.arraycopy(inorder, i + 1, ri, 0, l - i - 1);
//         root.right = buildTree(rp, ri);

//         return root;
//     }
// }


// preorder = [3,9,20,15,7]
// inorder = [9,3,15,20,7]
// @date Mar 07 2020
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int i = 0, l = inorder.length;
        if (l == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        for (int v: inorder) {
            if (v == root.val)
                break;
            i ++;
        }
        
        int[] li = Arrays.copyOfRange(inorder, 0, i);
        int[] lp = Arrays.copyOfRange(preorder, 1, i+1);
        int[] ri = Arrays.copyOfRange(inorder, i+1, l);
        int[] rp = Arrays.copyOfRange(preorder, i+1, l);
        root.left = buildTree(lp, li);
        root.right = buildTree(rp, ri);
        return root;
    }
}
// @lc code=end

