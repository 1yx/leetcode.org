import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
// @date Feb 20 2020
// class Solution {
//     public List<List<Integer>> levelOrder(Node root) {
//         List<List<Integer>> ans = new ArrayList<>();
//         if (root == null) return ans;
//         Queue<Node> q = new LinkedList<>();
//         q.add(root);
//         while(!q.isEmpty()) {
//             List<Integer> l = new ArrayList<>();
//             int size = q.size();
//             for (int i = 0; i < size; i ++) {
//                 Node n = q.poll();
//                 l.add(n.val);
//                 q.addAll(n.children);
//             }
//             ans.add(l);
//         }
//         return ans;
//     }
// }

// bfs
// @date Mar 05 2020
// class Solution {
//     public List<List<Integer>> levelOrder(Node root) {
//         List<List<Integer>> res = new ArrayList<>();
//         if (root == null) return res;
//         Queue<Node> qu = new LinkedList<>();
//         qu.offer(root);
//         while (!qu.isEmpty()) {
//             List<Integer> subRes = new ArrayList<>();
//             for (int i = qu.size(); i > 0; i--) { // perfer this than upper
//                 Node father = qu.poll();
//                 subRes.add(father.val);
//                 for (Node child: father.children)  // perfer upper than this
//                     qu.offer(child);
//             }
//             res.add(subRes);
//         }
//         return res;
//     }
// }

// bfs without queue
// @date Mar 05 2020
// class Solution {
//     public List<List<Integer>> levelOrder(Node root) {
//         List<List<Integer>> res = new ArrayList<>();
//         if (root == null) return res;
//         List<Node> prev = Arrays.asList(root);
//         if (!prev.isEmpty()) {
//             List<Integer> subRes = new ArrayList<>();
//             List<Node> curr = new ArrayList<>();
//             for (Node father : prev) {
//                 subRes.add(father.val);
//                 curr.addAll(father.children);
//             }
//             res.add(subRes);
//             prev = curr;
//         }
//         return res;
//     }
// }

// dfs
// @date Mar 05 2020
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) dfs(root, 0, res);
        return res;
    }
    void dfs(Node root, int level, List<List<Integer>> res) {
        if (level >= res.size())
            res.add(new ArrayList<>());
        res.get(level).add(root.val);
        for (Node child : root.children)
            dfs (child, level + 1, res);
    }
}
// @lc code=end

