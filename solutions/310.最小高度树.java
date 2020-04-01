import java.util.*;
/*
 * @lc app=leetcode.cn id=310 lang=java
 *
 * [310] 最小高度树
 */

// @lc code=start
// @date Mar 30 2020
// @solution bfs
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 1) return Arrays.asList(0);
        if (n == 2) return Arrays.asList(0, 1);
        List<Integer> res = new ArrayList<>();
        int[] indegree = new int [n];
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i ++)
            tree.add(new ArrayList<>());
        for (int[] e : edges) {
            indegree[e[0]] ++;
            indegree[e[1]] ++;
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i ++) 
            if (indegree[i] == 1)
                queue.offer(i);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            res = new ArrayList<>();
            for (int i = 0; i < size; i ++) {
                int leaf = queue.poll();
                res.add(leaf);
                for (int node : tree.get(leaf)) 
                    if (--indegree[node] == 1) 
                        queue.offer(node);
            }
        }
        return res;
    }
}
// @lc code=end

