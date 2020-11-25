public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        final int sz = nums.length;
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[sz - 1]) {
            return sz;
        }

        int start = 0, end = sz - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                return mid;
            }
        }

        return nums[start] == target ? start : end;
    }
}
