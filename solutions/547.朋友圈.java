/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 */

// @lc code=start
// disjoint set
class Solution {
    public int findCircleNum(int[][] M) {

    }
    class UnionFind {
        int count = 0;
        int[] parent;
        public UnionFind(int n) {
            count = 0;
            parent = new int[n];
            for (int i = 0; i < n; i ++)
                parent[i] = i;
        }
        int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        void union(int p, int q) {
            int rp = find(p);
            int rq = find(q);
            if (rp = rq) return;
            parent[rp] = rq;
            count --;
        }
    }
    class DisjointSet {
        int[] parent;
        public DisjointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i ++)
                parent[i] = i;
        }
        void union (int p, int q) {
            int rq = find(p);
            int rq = find(q);
            parent[rp] = rq;
        }
        int find (i) {
            int root = i;
            while (parent[root] != root) 
                root = parent[root];
            while (parent[i] != i) {
                int temp = i;
                i = parent[i];
                p[temp] = root;
            }
        }  
    }
}
// @lc code=end

