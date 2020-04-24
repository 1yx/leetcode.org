class Solution {
    public int reversePairs(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }

    int merge(int[] arr, int start, int end) {
        if (start >= end) return 0;
        int mid = (start + end) / 2;
        int invCount = merge(arr, start, mid) + merge(arr, mid + 1, end);
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            invCount += arr[i] <= arr[j] ? j - (mid + 1) : 0;
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            invCount += j - (mid + 1);
            temp[k++] = arr[i++];
        }
        while (j <= end)
            temp[k++] = arr[j++];
        System.out.println(invCount);
        System.arraycopy(temp, 0, arr, start, end - start + 1);
        return invCount;
    }
}
