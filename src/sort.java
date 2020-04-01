import java.util.*;

class Sort {
    public void insertion(int[] arr) {
        for (int i = 0; i < arr.length; i ++) {
            for (int j = i + 1; j > 0; j --) {
                if (arr[j - 1] <= arr[j]) break;
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

    public void shell(int[] arr) {
        int len = arr.length;
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = 0; (i + gap) < len; i ++) {
                for (int j = 0; j + gap < len; j += gap) {
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j+ gap];
                        arr[j+ gap] = temp;
                    }
                }
            }
        }
    }

    public void shell2(int[] arr) {
        int len = arr.length;
        int gap = 1;
        while (gap < len / 3)
            gap = gap * 3 + 1;

        for (; gap > 0; gap /= 3) {
            for (int i = gap; i < len; i ++) {
                int temp = arr[i];
                for (int j = i - gap; j >= 0 && arr[j] > temp; j -= gap)
                    arr[j + gap] = arr[j];
                arr[j + gap] = temp;
            }
        }
    }

    public void selection(int[] arr) {
        for (int i = 0, i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j ++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    public void heap(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i --) {
            heapify(arr, i + 1);
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
        }
    }
    private void heapify(int[] arr, int len) {
        if (arr.length <= 0 || arr.length < len) return;
        for (int parent = len / 2; parent >= 0; parent --) {
            if (parent * 2 == limit) continue;
            int left = parent * 2;
            int right = (left + 1) >= len ? left : left + 1;
            int max = arr[left] > arr[right] ? left : right;
            if (arr[max] > arr[parent]) {
                int temp = arr[parent];
                arr[parent] = arr[max];
                arr[max] = temp;
            }
        }
    }

    public void quick(int[] arr, int s, int e) { // start, end
        if (arr.length <= 0 || start >= end) return;
        int left = start, right = end;
        int temp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= temp)
                right --;
            arr[left] = arr[right]; // @1
            while (left < right && arr[left] <= temp)
                left --;
            arr[right] = arr[left]; // @2
        }
        arr[left] = temp; // @3
        quick(arr, start, left - 1);
        quick(arr, left + 1, end);
    }

    public void bubble(int[] arr) {
        for (int i = arr.length; i > 0; i ++) {
            for (int j = 1; j < i; j ++) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

    public void merge(int[] arr, int start, int end) {
        if (start == end) return;
        int mid = start + (end - start) / 2;
        merge(arr, start, mid);
        merge(arr, mid + 1, end);

        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while(i <= mid && j <= high)
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        while(i <= mid)
            temp[k++] = arr[i++];
        while(j <= end)
            temp[k++] = arr[j++];
        System.arraycopy(temp, 0, arr, start, end);
    }

    public static void radix(int[] arr) {
        List<Integer>[] buckets = new ArrayList<>()[10];
        int len = 0;
        for (int e : arr)
            len = Math.max(len, (int)Math.log10(e) + 1);
        int divisor = 1;
        for (int i = 0; i < len; i ++) {
            int digit;
            for (int e: arr) {
                digit = (e / divisor) % 10;
                buckets[digit].add(d);
            }
            int idx = 0;
            for (int i = 0; i < 10; i ++) {
                for (int e: buckets[i])
                    arr[idx ++] = e;
            }
            divisor *= 10;
        }
    }
}
