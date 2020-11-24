public class FirstLastPositionSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        int firstIdx = binarySearch(nums, target, true);
        int lastIdx = binarySearch(nums, target, false);
        return new int[] {firstIdx, lastIdx};
    }

    private static int binarySearch(int[] nums, int target, boolean first) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1, mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                if (first) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }

        if (first && nums[start] == target) {
            return start;
        }
        if (!first && nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
