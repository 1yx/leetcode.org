import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
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
//     public List<Integer> preorder(Node root) {
//         List<Integer> ans = new ArrayList<Integer> ();
//         preOrder(root, ans);
//         return ans;
//     }

//     public void preOrder(Node root, List<Integer> ans) {
//         if (root == null) return;
//         ans.add(root.val);
//         if (root.children.size() == 0) return;
//         for (Node child : root.children) 
//             preOrder(child, ans);
//     }
// }

// 递归
// @date Mar 05 2020
// class Solution {
//     public List<Integer> preorder(Node root) {
//         List<Integer> res = new ArrayList<>();
//         preOrder(root, res);
//         return res;
//     }
//     void preOrder(Node root, List<Integer> res) {
//         if (root == null) return;
//         res.add(root.val);
//         for (Node child: root.children)
//             preOrder(child, res);
//     }
// }

// 迭代
// @date Mar 05 2020
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.empty()) {
            Node father = st.pop();
            res.add(father.val);
            for (int i = father.children.size() - 1; i >= 0; i --) // @important
                if (father.children.get(i) != null) 
                    st.push(father.children.get(i));
        }
        return res;
    }
}
// @lc code=end

