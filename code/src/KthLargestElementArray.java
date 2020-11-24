import static Utils.swap;

public class KthLargestElementArray {
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            throw new IllegalArgumentException();
        }
        final int sz = nums.length;
        return quickSelect(nums, 0, sz - 1, sz - k + 1);
    }

    public static int quickSelect(int[] arr, int start, int end, int k) {
        if (start == end) {
            return arr[start];
        }
        int p = partition(arr, start, end);
        int rank = p - start + 1;
        if (rank == k) {
            return arr[p];
        } else if (rank > k) {
            return quickSelect(arr, start, p - 1, k);
        } else {
            return quickSelect(arr, p + 1, end, k - rank);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end], p = start - 1;
        for (int i = start; i <= end - 1; i++) {
            if (arr[i] < pivot) {
                swap(arr, ++p, i);
            }
        }
        swap(arr, ++p, end);
        return p;
    }
}
