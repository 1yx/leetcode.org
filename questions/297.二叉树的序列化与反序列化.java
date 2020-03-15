import java.util.*;
/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
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

// bfs
// @date 07 2020
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> res = new ArrayList<>();
        int nullCount = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = qSize; i > 0; i --) {
                TreeNode node = queue.poll();
                if (node == null) {
                    res.add(null);    
                    nullCount ++;
                } else {
                    res.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                    nullCount = 0;
                }
            }
        }
        res.subList(res.size() - nullCount, res.size()).clear();
        return res.toString().replaceAll(" ", "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        if (data.isEmpty()) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<String> strQueue = new LinkedList<>(Arrays.asList(data.split(",")));
        TreeNode root = null, node = null;
        String str = strQueue.poll();
        if (!str.equals(null))
            root = new TreeNode(Integer.valueOf(str));
        queue.offer(root);
        while (!strQueue.isEmpty()) {
            node = queue.poll();
            // left
            str = strQueue.poll();
            node.left = null;
            if (!str.equals("null")) {
                node.left = new TreeNode(Integer.valueOf(str));
                queue.offer(node.left);
            }
            // right
            str = strQueue.poll();
            if(str == null) break; // @important
            node.right = null;
            if (!str.equals("null")){
                node.right = new TreeNode(Integer.valueOf(str));
                queue.offer(node.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

