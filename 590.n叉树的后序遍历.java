/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
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
// class Solution {
//     public List<Integer> postorder(Node root) {
//         List<Integer> ans = new ArrayList<> ();
//         postOrder(root, ans);
//         return ans;
//     }
//     public void postOrder (Node root, List<Integer> ans) {
//         if (root == null) return;
//         if (root.children.size() !=0 ) {
//             for (Node child : root.children) {
//                 postOrder(child, ans);
//             }
//         }
//         ans.add(root.val);
//     }
// }

// 迭代
// @date Mar 05 2020
// class Solution {
//     public List<Integer> postorder(Node root) {
//         List<Integer> res = new ArrayList<>();
//         if (root == null) return res;
//         Stack<Node> st = new Stack<>();
//         st.push(root);
//         while(!st.empty()) {
//             Node father = st.pop();
//             res.add(father.val);
//             for (Node child: father.children) { // @important
//                 if (child != null) 
//                     st.push(child);
//             }
//         }
//         Collections.reverse(res); // @important
//         return res;
//     }
// }

// 递归
// @date Mar 05 2020
 class Solution {
     public List<Integer> postorder(Node root) {
         List<Integer> res = new ArrayList<>();
         postOrder(root, res);
         return res;
     }
     void postOrder(Node root, List<Integer> res) {
        if (root == null) return;
        for (Node child: root.children) 
            if (child != null) 
                postOrder(child, res);
        res.add(root.val);
     }
 }
// @lc code=end

