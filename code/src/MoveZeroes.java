public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        //[0, p] [p+1, i-1] [i, sz-1]
        final int sz = nums.length;
        int p = -1;
        for (int i = 0; i < sz; i++) {
            if (nums[i] != 0) {
                swap(nums, ++p, i);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
