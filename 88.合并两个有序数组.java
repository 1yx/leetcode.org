/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int p = m-- + n-- - 1;
//         while (m >= 0 && n >= 0)
//             nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];

            
//         while (n >= 0)
//             nums1[p--] = nums2[n--];
//     }
// }

// 双指针 从后往前
// @date Mar 03 2020
// class Solution {
//     public void merge (int[] nums1, int m, int[] nums2, int n) {
//         int p = m-- + n-- -1;
//         while (m >= 0 && n >= 0) 
//             nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
//         System.arraycopy(nums2, 0, nums1, 0, n+1);
//     }
// }

// 双指针 从前往后
// @date Mar 03 2020
class Solution {
    public void merge (int[] nums1, int m, int[] nums2, int n) {
        int[] _nums1 = new int[m];
        System.arraycopy(nums1, 0, _nums1, 0, m);
        int _m = 0, _n = 0, p = 0;
        while (_m < m && _n < n) 
            nums1[p++] = _nums1[_m] < nums2[_n] ? _nums1[_m++] : nums2[_n++];
        if (_m < m) 
            System.arraycopy(_nums1, _m , nums1, _m + _n, m + n - _m - _n);    
        if (_n < n)
        System.arraycopy(nums2, _n , nums1, _m + _n, m + n - _m - _n);
    }
}
// @lc code=end

